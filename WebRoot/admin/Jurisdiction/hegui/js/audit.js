$(function() {
	//页面展示信息
	show();
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
					// 给查看按钮绑定事件
					td.find('a:eq(0)').click(function() {
						location.href = "/business/user/callBackUser?userId="+kehuid;
					/*
					$.ajax({
						url : "vvvv",
						dataType : "json",
						type : 'post',
						data : {
							kehuid : kehuid
						},
						success : function(data) {
							
						}
					})*/
					});

					// 给修改按钮绑定事件
					td.find('a:eq(1)').click(function() {
						$("#x_mask").css("display", "block");
						$("#x_formAdd").css("display", "block");
						//关闭
						$("#x_hideFormAdd").click(function() {
							$("#x_mask").css("display", "none");
							$("#x_formAdd").css("display", "none");
						});
						updateData(kehuid);
					});
					// 给删除按钮绑定事件
					td.find('a:eq(2)').click(function() {
						$(this).parent().parent().remove();
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
									show();
								} else {
									alert(data.errMsg)
								}
							}
						});
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
							$("#x_mask").css("display", "none");
							$("#x_formAdd").css("display", "none");
							if (data.success == "true") {
								show();
							} else {
								alert(data.errMsg)
							}
						}
					})
					return false;
				})
			}
		})
	}
})