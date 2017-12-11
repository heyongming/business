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
            url : "/business/serviceArticle/getFullData",
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
                formData.append("redTitle", $("#redTitle").val());  //红点标题
                formData.append("goodsId", $("select[name='goodsId']").val());  //商品
                formData.append("redContent", redContent); //红点内容
                formData.append("gupiaoCode", $("#gupiaoCode").val());  //股票代码
                formData.append("gupiaoName", $("#gupiaoName").val());  //股票名称
                formData.append("nowPrice", $("#nowPrice").val()); //当前价
                formData.append("weiPrice", $("#weiPrice").val());  //预警价
                formData.append("tiTime", $("#tiTime").val());  //提醒时间
                formData.append("endContent", $("#endContent").val());  //结束语
                $(".spinner").show();
                $.ajax({
                    type : 'post',
                    url : '/business/serviceArticle/addServiceArticle',
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
                            show();
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
                '<td>红点ID</td>'+
                '<td>红点标题</td>'+
                '<td>商品名称</td>'+
                '<td>发送时间</td>'+
                '<td>操作</td>'+
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
            url : "/business/serviceArticle/findById",
            type : 'post',
            data : {
                serviceArticleNum : serviceArticleNum
            },
            dataType : 'json',
            success : function(data) {
                /*显示旧信息*/
                $("#redTitle").val(data.redTitle);  //红点标题
                $("#goodsId").val(data.goodsId);//商品
                ue.setContent(data.redContent);//红点内容
                $("#gupiaoCode").val(data.gupiaoCode);//股票代码
                $("#gupiaoName").val(data.gupiaoName);//股票名称
                $("#nowPrice").val(data.nowPrice);//当前价
                $("#weiPrice").val(data.weiPrice);//预警价
                $("#tiTime").val(data.tiTime);//提醒时间
                $("#endContent").val(data.endContent);//结束语
                // 重新绑定表单提交事件
                $('#btn').unbind('click').click(function() {
                    // 获取所有的表单数据
                    var redContent = ue.getContent(); //获取富文本编辑器内容
                    var formData = new FormData();
                    formData.append("redTitle", $("#redTitle").val());  //红点标题
                    formData.append("goodsId", $("select[name='goodsId']").val());  //商品
                    formData.append("redContent", redContent); //红点内容
                    formData.append("gupiaoCode", $("#gupiaoCode").val());  //股票代码
                    formData.append("gupiaoName", $("#gupiaoName").val());  //股票名称
                    formData.append("nowPrice", $("#nowPrice").val()); //当前价
                    formData.append("weiPrice", $("#weiPrice").val());  //预警价
                    formData.append("tiTime", $("#tiTime").val());  //提醒时间
                    formData.append("endContent", $("#endContent").val());  //结束语
                    $(".spinner").show();
                    $.ajax({
                        url : '/business/serviceArticle/updateServiceArtcle',
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