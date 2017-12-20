layui.use([ 'form', 'layer','laydate'], function() {
    var form = layui.form
        ,$ = layui.jquery
        ,layer = layui.layer
        ,laydate = layui.laydate;
    $(function(){
        form.render();
        show();  //展示数据
        addData();  //添加数据
    })
    //展示数据
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
        	layer.open({
                type: 1,
                title: ['线下购买信息录入', 'font-size:18px'],
                area: ['1000px', '700px'],
                content: $("#j_formAdd"),
                end: function () {
                    $("#j_formAdd").hide()
                }
            })
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
                    $('#product').html(tag);
                    // 给表单提交按钮绑定事件
                    form.on('submit(btn)', function(data) {
                        var money = $("#money").val();
                        var referralCode = $("#referralCode").val();
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
                            	$('#content').html("");
    							if (data.success == "true") {
    								//修改成功
    		                        layer.msg('修改成功');
    								show();
    								layer.closeAll('page');
    							} else {
    								//修改失败
    		                        layer.msg(data.errMsg);
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
        $('#content').html(tag);
        // 删除
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var userId = $(e).find('td:eq(0)').text(); //用户id
            // 删除
            td.find('a:eq(0)').click(function() {
            	layer.confirm('确定删除此条数据吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
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
								layer.msg('删除成功');
								show();
							} else {
								layer.msg(data.errMsg);
							}
						}
					});
                })
            	
            });
        });
    }

})