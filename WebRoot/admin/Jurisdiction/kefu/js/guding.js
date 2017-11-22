$(function() {
    show(); /*初始化*/
    addData(); /*添加*/
    //富文本编辑器操作
    function show() {
        $.ajax({
            url : "/business/customer/getAllFix",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                renderData(data);
            }
        });
    }
    //富文本编辑器操作
    var ue = UE.getEditor('wordContent');
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
            $("#submit").unbind('click').click(function() {
                // 获取所有的表单数据
                var wordContent = ue.getContent(); //获取富文本编辑器内容
                var formData = new FormData();
                formData.append("problem", $("#word").val());  //关键词
                formData.append("answer", wordContent);//回复内容
                $(".spinner").show();
                $.ajax({
                    type : 'post',
                    url : '/business/customer/addFix',
                    data : formData,
                    processData : false,
                    contentType : false,
                    dataType : 'json',
                    success : function(data) {
                        // 渲染数据列表
                        $(".spinner").hide();
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
        });
    }
    // 封装渲染数据列表
    function renderData(data) {
        // 数据解析和渲染
        var tag = '';
        $.each(data, function(i, e) {
            tag += '<tr>' +
                '<td>' + e.fdid + '</td>' +
                '<td>' + e.problem + '</td>' +
                '<td>...</td>' +
                '<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
                '</tr>';
        });
        $('#content').append(tag);
        // 给修改和删除按钮绑定单击事件
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var id = $(e).find('td:eq(0)').text(); //ID
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
                updateData(id);
            });
            // 给删除按钮绑定事件
            td.find('a:eq(1)').click(function() {
                $(this).parent().parent().remove();
                $.ajax({
                    url : '/business/customer/delFix',
                    type : 'post',
                    data : {
                    	fdid : id
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
    //封装更新操作
    function updateData(id) {
        $.ajax({
            url : "/business/customer/findFixFdid",
            type : 'post',
            data : {
            	fdid : id
            },
            dataType : 'json',
            success : function(data) {
                /*显示旧信息*/
                $("#word").val(data.problem);
                ue.setContent(data.answer);
                // 重新绑定表单提交事件
                $('#submit').unbind('click').click(function() {
                    // 获取更新后的表单数据
                    var wordContent = ue.getContent(); //获取富文本编辑器内容
                    var formData = new FormData();
                    formData.append("problem", $("#word").val());  //关键词
                    formData.append("answer", wordContent);//回复内容
                    formData.append("fdid", id);//回复内容
                    
                    $(".spinner").show();
                    $.ajax({
                        url : '/business/customer/upFix',
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
                        }
                    });
                    return false;
                });
            }
        });
    }
})