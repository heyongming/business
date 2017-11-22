$(function() {
    show(); /*初始化*/
    function show() {
        $.ajax({
            url : "/business/customer/findmsgFulldate",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                renderData(data);
            }
        });
    }
    /*问题类型查询*/
    $("#search").click(function() {
        var question = $('#question').val();
        $.ajax({
            url : '/business/customer/findmsgbyTypeName',
            data : {
                "messageType" : question
            },
            success : function(data) {
                if (data == "") {
                    $('#content').html("");
                    return;
                }
                data = JSON.parse(data)
                renderData(data);
            }
        });
    });
    // 封装渲染数据列表
    function renderData(data) {
        // 数据解析和渲染
        var tag = '';
        $.each(data, function(i, e) {
            tag += '<tr>' +
                '<td tag='+e.mmId+'>'+e.ip+'</td>'+
                '<td>'+e.messageTime+'</td>'+
                '<td>'+e.user.userName+'</td>'+
                '<td>...</td>'+
                '<td style="width: 45px; height: 30px"><img style="height: 30px" src="'+e.messageImage+'" alt="" /></td>'+
                '<td>'+e.messageType+'</td>'+
                '<td>'+e.phone+'</td>'+
                '<td><a href="javascript:;" class="layui-btn layui-btn-mini">查看</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
                '</tr>';
        });
        $('#content').append(tag);
        // 给修改和删除按钮绑定单击事件
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var id = $(e).find('td:eq(0)').attr("tag"); //ID
            // 给查看按钮绑定事件
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
                    url : '/business/serviceArticle/deleteServiceArtcle',
                    type : 'post',
                    data : {
                        id : id
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
    //查看操作
    function updateData(id) {
        $.ajax({
            url : "/business/customer/findmsgbyId",
            type : 'post',
            data : {
                mmid : id
            },
            dataType : 'json',
            success : function(data) {
                $("#time").html(''+data.messageTime+'');
                $("#name").html(''+data.user.userName+'');
                $("#con").html(''+data.messageContent+'');
                $('#img').attr('src',''+data.messageImage+'');
                $("#type").html(''+data.messageType+'');
                $("#number").html(''+data.phone+'');
            }
        });
    }
})