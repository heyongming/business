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
			url : "/business/user/getAllUserData",
			dataType : "json",
			success : function(data) {
				var tag = "";
				$.each(data, function(i, e) {
					tag += '<tr>' +
						'<td>' + e.userId + '</td>' +
						'<td>' + e.userName + '</td>' +
						'<td>' + e.grade + '</td>' +
						'<td>' + e.createTime + '</td>' +
						'<td>' + e.idCard + '</td>' +
						'<td>' + e.rdCode + '</td>' +
						'<td><a href="javascript:;" data-opt="look" class="layui-btn layui-btn-mini">查看</a><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
						'</tr>';
				});
				$("#content").html(tag);
				// 给查看，修改，删除按钮绑定单击事件
				$('#content tr').each(function(i, e) {
					var td = $(e).find('td:last-of-type'); //操作
					var kehuid = $(e).find('td:eq(0)').text(); //客户ID
					// 查看
					td.find('a:eq(0)').click(function() {
						window.open("/business/user/callBackUser?userId="+kehuid);
					});
					// 修改
					td.find('a:eq(1)').click(function() {
						layer.open({
			                type: 1,
			                title: ['修改客户信息', 'font-size:18px'],
			                area: ['1000px', '700px'],
			                content: $("#x_formAdd"),
			                end: function () {
			                    $("#x_formAdd").hide()
			                }
			            })
						updateData(kehuid);
					});
					// 删除
					td.find('a:eq(2)').click(function() {
						layer.confirm('确定删除此条数据吗？', {
                            btn: ['确定', '取消'] //按钮
                        }, function () {
                            $.ajax({
    							url : '/business/user/delUser',
    							type : 'post',
    							data : {
    								"userId" : kehuid
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
		});
	}
	//修改操作
	function updateData(kehuid) {
		$.ajax({
			url : "/business/user/getUserEntitys",
			dataType : "json",
			type : 'post',
			data : {
				"userId" : kehuid
			},
			success : function(data) {
				//获取原有数据
				$("#userName").val(data.userName);
				$("#grade").val(data.grade);
				$("#idCard").val(data.idCard);
				$("#rdCode").val(data.rdCode);
				$("#submit").unbind('click').click(function() {
					var formData = new FormData();

					formData.append("userId", kehuid);
					formData.append("userName", $("#userName").val());

					formData.append("idCard", $("#idCard").val());

					$.ajax({
						url : "/business/user/update",
						type : 'post',
						data : formData,
						dataType : 'json',
						processData : false,
						contentType : false,
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
					})
					return false;
				})
			}
		})
	}
})