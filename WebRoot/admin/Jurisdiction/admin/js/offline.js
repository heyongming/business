$(function() {
    show(); /*初始化*/
    addData();  //添加
    function show() {
        $.ajax({
            url : "/business/order/getOffPayFullData",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                renderData(data);
            }
        });
    }
    /*点击添加，提交*/
    function addData() {
        $("#add").click(function() {
            $("#j_mask").css("display", "block");
            $("#j_formAdd").css("display", "block");
            //关闭
            $("#j_hideFormAdd").click(function() {
                $("#j_mask").css("display", "none");
                $("#j_formAdd").css("display", "none");
            });
            $.ajax({
                url:"/business/goods/getAllData",
                type:"post",
                dataType : 'json',
                success:function(data){
                    //获取产品列表
                    var tag = '';
                    $.each(data, function(i, e) {
                        tag += '<option value="'+e.goodsId+'">'+e.goodsName+'</option>';
                    });
                    $('#product').append(tag);
                    // 给表单提交按钮绑定事件
                    $("#btn").unbind('click').click(function() {
                        var money = $("#money").val();
                        var referralCode = $("#referralCode").val();
                        if(referralCode==""){
                            alert("推荐码不能为空");
                            return false;
                        }
                        if(money==""){
                            alert("金额不能为空");
                            return false;
                        }
                        var number = /^\d*$/;
                        if(!number.test(money)){
                            alert("金额只能为数字");
                            return false;
                        }
                        var formData = new FormData();
                        formData.append("rdCode", $("#referralCode").val());
                        formData.append("goodsId", $("select[name='product']").val());
                        formData.append("paymentNumber", $("select[name='number']").val());
                        formData.append("actualPurchasePriceGoods", $("#money").val());
                        $.ajax({
                            type : 'post',
                            url : '/business/order/offLinePay',
                            data : formData,
                            processData : false,
                            contentType : false,
                            dataType : 'json',
                            success : function(data) {
                                // 渲染数据列表
                                $("#j_mask").css("display", "none");
                                $("#j_formAdd").css("display", "none");
                                if (data.success == "true") {
                                    show();
                                } else {
                                    alert(data.errMsg)
                                }
                            }
                        });
                        return false;
                    });
                }
            })

        });
    }
    // 封装渲染数据列表
    function renderData(data) {
        // 数据解析和渲染
        var tag = '';
        $.each(data, function(i, e) {
            tag += '<tr>'+
                '<td>'+e.user.userId+' </td>'+
                '<td>'+e.user.userName+'</td>'+
                '<td>'+e.orderSerialNumber+'</td>'+
                '<td>'+e.goodsList.goodsName+'</td>'+
                '<td>'+e.purchaseTime+'</td>'+
                '<td>'+e.goodsList.goodsPrice+'</td>'+
                '<td>'+e.paymentNumber+'</td>'+
                '<td>'+e.actualPurchasePriceGoods+'</td>'+
                '<td>'+e.activationCode.activationCode+'</td>'+
                '<td>'+e.orderStatus+'</td>'+
               // '<td><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>'+
                '</tr>';
        });
        $('#content').append(tag);
        // 给删除按钮绑定单击事件
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var userId = $(e).find('td:eq(0)').text(); //用户id
            // 给删除按钮绑定事件
            td.find('a:eq(0)').click(function() {
                $(this).parent().parent().remove();
                $.ajax({
                    url : '/business/serviceArticle/deleteServiceArtcle',
                    type : 'post',
                    data : {
                        userId : userId
                    },
                    dataType : 'json',
                    success : function(data) {
                        // 删除后渲染数据列表
                        if (data.success == "true") {
                            show();
                        } else {
                            alert(data.errMsg)
                        }
                    }
                });
            });
        });
    }

})