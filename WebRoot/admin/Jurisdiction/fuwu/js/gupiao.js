$(function() {
    initGoodsList(); //初始化下拉列表
    show(); /*初始化*/
    addData(); /*添加*/
    function initGoodsList() {
        $.ajax({
            url : "/business/goods/getAllData",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                var commBox = $("#goodsId")

                $.each(data, function(i, e) {

                    var appendHtml = "<option value=" + e.goodsId + ">" + e.goodsName + "</option>";

                    commBox.append(appendHtml);

                })
            }
        });
    }
    function show() {
        $.ajax({
           url : "/business/productOperationReport/getAllData",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                //console.log(data);
                renderData(data);
            }
        });
    }
    //富文本编辑器操作
    var ue = UE.getEditor('redContent');
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
            // 给表单提交按钮绑定事件
            $("#btn").unbind('click').click(function() {
                // 获取所有的表单数据
                var redContent = ue.getContent(); //获取富文本编辑器内容
                var formData = new FormData();
                formData.append("porTitle", $("#redTitle").val());  //红点标题
                formData.append("goodsId", $("select[name='goodsId']").val());  //商品
                formData.append("porCtent", redContent); //红点内容
                formData.append("keyword1", $("#gupiaoCode").val());  //股票代码
                formData.append("keyword2", $("#gupiaoName").val());  //股票名称
                formData.append("keyword3", $("#nowPrice").val()); //当前价
                formData.append("keyword4", $("#weiPrice").val());  //预警价
                formData.append("keyword5", $("#tiTime").val());  //提醒时间
                formData.append("remark", $("#endContent").val());  //结束语
                //标题颜色
                formData.append("porTitleClor", "#FF0000");  //红点标题
                formData.append("keyword1Clor", "#0000FF");  //股票代码
                formData.append("keyword2Clor", "#0000FF");  //股票名称
                formData.append("keyword3Clor", "#FF0000"); //当前价
                formData.append("keyword4Clor", "#FF0000");  //预警价
                formData.append("keyword5Clor","#FF0000");  //提醒时间
                formData.append("remarkClor", "#FF0000");  //结束语
                $(".spinner").show();
                $.ajax({
                    type : 'post',
                    url : '/business/productOperationReport/insertPor',
                    data : formData,
                    processData : false,
                    contentType : false,
                    dataType : 'json',
                    success : function(data) {
                        alert("上传成功");
                        // 渲染数据列表
                        $(".spinner").hide();
                        $("#j_mask").css("display", "none");
                        $("#j_formAdd").css("display", "none");
                        if (data.success == "true") {
                       //     show();
                        } else {
                            alert(data.errMsg)
                        }
                    },
                    error:function(){
                        alert("上传失败，请联系管理员");
                        return false;
                    }
                });
                return false;
            });
        });
    }
    // 封装渲染数据列表
    function renderData(data) {
        // 数据解析和渲染
        var tag = '';
        $.each(data, function(i, e) {
            tag += '<tr>' +
                '<td>'+e.porId+'</td>'+
                '<td>'+e.porTitle+'</td>'+
                '<td>'+e.goodsList.goodsName+'</td>'+
                '<td>'+e.createTime+'</td>'+
               
                '<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a></td>' +
                '</tr>';
        });
        $('#content').html(tag);
        // 给编辑按钮绑定单击事件
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var serviceArticleNum = $(e).find('td:eq(0)').text(); //ID
            // 给修改按钮绑定事件
            td.find('a:eq(0)').click(function() {
                //先弹出
                $("#j_mask").css("display", "block");
                $("#j_formAdd").css("display", "block");
                //关闭
                $("#j_hideFormAdd").click(function() {
                    $("#j_mask").css("display", "none");
                    $("#j_formAdd").css("display", "none");
                });
                updateData(serviceArticleNum);
            });
        });
    }
    //封装更新操作
    function updateData(serviceArticleNum) {
        $.ajax({
            url : "/business/productOperationReport/getDataById",
            type : 'post',
            data : {
            	porId : serviceArticleNum
            },
            dataType : 'json',
            success : function(data) {
                /*显示旧信息*/
                $("#redTitle").val(data.porTitle);  //红点标题
                $("#goodsId").val(data.goodsId);//商品
                ue.setContent(data.porCtent);//红点内容
                $("#gupiaoCode").val(data.keyword1);//股票代码
                $("#gupiaoName").val(data.keyword2);//股票名称
                $("#nowPrice").val(data.keyword3);//当前价
                $("#weiPrice").val(data.keyword4);//预警价
                $("#tiTime").val(data.keyword5);//提醒时间
                $("#endContent").val(data.remark);//结束语
                // 重新绑定表单提交事件
                $('#btn').unbind('click').click(function() {
                    // 获取所有的表单数据
                    var redContent = ue.getContent(); //获取富文本编辑器内容
                    var formData = new FormData();
                    formData.append("porId", serviceArticleNum)
                    formData.append("porCtent", redContent); //红点内容
                    $(".spinner").show();
                    $.ajax({
                        url : '/business/productOperationReport/updatePor',
                        type : 'post',
                        data : formData,
                        dataType : 'json',
                        processData : false,
                        contentType : false,
                        success : function(data) {
                            // 渲染数据列表
                            $(".spinner").hide();
                            $('#content').html("");

                            $("#j_mask").css("display", "none");
                            $("#j_formAdd").css("display", "none");
                            if (data.success == "true") {
                                show();
                            } else {
                                alert(data.errMsg)
                            }
                        },
                        error:function(){
                            alert("更新上传失败，请联系管理员");
                        }
                    });
                    return false;
                });
            }
        });
    }
})