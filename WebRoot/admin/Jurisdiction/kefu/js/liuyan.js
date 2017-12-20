layui.use([ 'form', 'layer','laydate'], function() {
    var form = layui.form
        ,$ = layui.jquery
        ,layer = layui.layer
        ,laydate = layui.laydate;
    $(function(){
        form.render();
        show();  //展示数据
    })
    
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
            	layer.open({
	                type: 1,
	                title: ['查看留言内容', 'font-size:18px'],
	                area: ['1000px', '700px'],
	                content: $("#j_formAdd"),
	                end: function () {
	                    $("#j_formAdd").hide()
	                }
	            })
                updateData(id);
            });
            // 给删除按钮绑定事件
            td.find('a:eq(1)').click(function() {
            	layer.confirm('确定删除此条数据吗？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
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
    //查看操作
    function updateData(id) {
        $.ajax({
            url : "/business/customer/findmsgbyId",
            type : 'post',
            data : {
                mmId : id
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