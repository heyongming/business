layui.use([ 'form', 'layer','laydate'], function() {
    var form = layui.form
        ,$ = layui.jquery
        ,layer = layui.layer
        ,laydate = layui.laydate;
    $(function(){
        form.render();
        show();  //展示数据
        addData(); /*添加*/
    })
	function show() {
		$.ajax({
			url : '/business/salesman/getUserAll',
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
                title: ['添加权限', 'font-size:18px'],
                area: ['1000px', '700px'],
                content: $("#j_formAdd"),
                end: function () {
                    $("#j_formAdd").hide()
                }
            })
			// 给表单提交按钮绑定事件
			$("#submit").unbind('click').click(function() {
				// 获取所有的表单数据
				var formData = new FormData();
				formData.append("userName", $("#userName").val());
				formData.append("passWord", $("#passWord").val());
				formData.append("type", $("select[name='quanXian']").val());
				formData.append("phone", $("#tel").val());
				$.ajax({
					type : 'post',
					url : '/business/salesman/addUser',
					data : formData,
					processData : false,
					contentType : false,
					dataType : 'json',
					success : function(data) {
						// 渲染数据列表
						$('#content').html("");
						
                        layer.msg('添加成功');
						show();
						layer.closeAll('page');
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
			if (e.type == 1) {
				quanXian = "管理员";
			}
			if (e.type == 4) {
				quanXian = "销售人员";
			}
			tag += '<tr>' +
				'<td>' + e.userId + '</td>' +
				'<td>' + e.userName + '</td>' +
				'<td>' + e.passWord + '</td>' +
				'<td>' + quanXian + '</td>' +
				'<td>' + e.phone + '</td>' +
				'<td><a href="javascript:;" class="layui-btn layui-btn-mini">修改</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
				'</tr>';
		});
		$('#content').html(tag);
		// 给修改和删除按钮绑定单击事件
		$('#content tr').each(function(i, e) {
			var td = $(e).find('td:last-child');
			var id = $(e).find('td:eq(0)').text();
			// 给修改按钮绑定事件
			td.find('a:eq(0)').click(function() {
				layer.open({
	                type: 1,
	                title: ['添加权限', 'font-size:18px'],
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
    					url : '/business/salesman/delUser',
    					type : 'post',
    					data : {
    						"userId" : id
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
	//封装更新操作
	function updateData(id) {
		$.ajax({
			url : '/business/salesman/queryUserById',
			type : 'post',
			data : {
				"userId" : id
			},
			dataType : 'json',
			success : function(data) {
				/*显示旧信息*/
				$("#userName").val(data.userName);
				$("#passWord").val(data.passWord);
				$("#quanXian").val(data.type);
				$("#tel").val(data.phone);
				// 重新绑定表单提交事件
				$('#submit').unbind('click').click(function() {
					// 获取更新后的表单数据
					var formData = new FormData();
					formData.append("userId", id);
					formData.append("userName", $("#userName").val());
					formData.append("passWord", $("#passWord").val());
					formData.append("type", $("select[name='quanXian']").val());
					formData.append("phone", $("#tel").val());
					$.ajax({
						type : 'post',
						url : '/business/salesman/update',
						data : formData,
						dataType : 'json',
						processData : false,
						contentType : false,
						success : function(data) {
							$('#content').html("");
							//修改成功
	                        layer.msg('修改成功');
							show();
							layer.closeAll('page');
						}
					});
					return false;
				});
			}
		});
	}
	
})