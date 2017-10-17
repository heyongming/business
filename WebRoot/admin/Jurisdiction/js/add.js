$(function() {

    show(); /*初始化*/
    addData(); /*添加*/
    //富文本编辑器操作
    var editorHtml;
    var ue = UE.getEditor('editor_id');
    function show() {
        $.ajax({
            url : 'aa',
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                console.log(data);
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
            //富文本编辑器操作

            //对编辑器的操作最好在编辑器ready之后再做
            ue.ready(function() {
                //获取html内容，返回: <p>hello</p>
                editorHtml = ue.getContent();
            });

            // 给表单提交按钮绑定事件
            $("#submit").unbind('click').click(function() {
                // 获取所有的表单数据
                var formData = new FormData();
                formData.append("titleId", $("#titleId").val());
                formData.append("goodsTypeId", $("select[name='goodsTypeId']").val());
                formData.append("serviceType", $("select[name='serviceType']").val());
                formData.append("serviceTime", $("#serviceTime").val());
                formData.append("original", $("#original").val());
                formData.append("currentDate", $("#currentDate").val());
                //formData.append("planDate", $("#planDate").val()); //预计发送时间
                formData.append("editorHtml", editorHtml);
                $.ajax({
                    type : 'post',
                    url : 'sss',
                    data : formData,
                    processData : false,
                    contentType : false,
                    dataType : 'json',
                    success : function(data) {
                        // 渲染数据列表
                        renderData(data);
                        $("#j_mask").css("display", "none");
                        $("#j_formAdd").css("display", "none");
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
            var div = document.createElement("div");
            div.innerHTML = editorHtml;
            tag += '<tr>' +
                '<td>文章ID</td>'+
                '<td>文章标题</td>'+
                '<td>商品分类</td>'+
                '<td>服务板块</td>'+
                '<td>服务期限</td>'+
                '<td>原创</td>'+
                '<td>当前日期</td>'+
                '<td>时间</td>'+
                '<td>作者</td>'+
                '<td>div</td>'+
                '<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
                '</tr>';
        });
        $('#content').append(tag);
        // 给修改和删除按钮绑定单击事件
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var passageId = $(e).find('td:eq(0)').text();
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
                updateData(passageId);
            });
            // 给删除按钮绑定事件
            td.find('a:eq(1)').click(function() {
                $(this).parent().parent().remove();
                $.ajax({
                    url : 'ddd',
                    type : 'post',
                    data : {
                        passageId : passageId
                    },
                    dataType : 'json',
                    success : function(data) {
                        // 删除后渲染数据列表

                    }
                });
            });
        });
    }
    //封装更新操作
    function updateData(passageId) {
        $.ajax({
            url : 'zz',
            type : 'post',
            data : {
                passageId : passageId
            },
            dataType : 'json',
            success : function(data) {
                /*显示旧信息*/
                $("#titleId").val(data.titleId);
                $("#goodsTypeId").val(data.goodsTypeId);
                $("#serviceType").val(data.serviceType);
                $("#serviceTime").val(data.serviceTime);
                $("#original").val(data.original);
                $("#currentDate").val(data.currentDate);
                //$("#planDate").val(data.planDate); //计划发送时间
                $("#author").val(data.author);
                $("#editor_id").val(data.editor_id);
                // 重新绑定表单提交事件
                $('#submit').unbind('click').click(function() {
                    //对编辑器的操作最好在编辑器ready之后再做
                    ue.ready(function() {
                        //获取html内容，返回: <p>hello</p>
                        editorHtml = ue.getContent();
                    });
                    // 获取更新后的表单数据
                    var formData = new FormData();
                    formData.append("titleId", $("#titleId").val());
                    formData.append("goodsTypeId", $("select[name='goodsTypeId']").val());
                    formData.append("serviceType", $("select[name='serviceType']").val());
                    formData.append("serviceTime", $("#serviceTime").val());
                    formData.append("original", $("#original").val());
                    formData.append("currentDate", $("#currentDate").val());
                    //formData.append("planDate", $("#planDate").val());  //预计发送时间
                    formData.append("author", $("#author").val());
                    formData.append("editorHtml", editorHtml);
                    $.ajax({
                        url : 'aac',
                        type : 'post',
                        data : formData,
                        dataType : 'json',
                        processData : false,
                        contentType : false,
                        success : function(data) {
                            console.log("修改成功!");
                            // 渲染数据列表
                            $('#content').html("");
                            renderData(data);
                            $("#j_mask").css("display", "none");
                            $("#j_formAdd").css("display", "none");
                        }
                    });
                    return false;
                });
            }
        });
    }
})