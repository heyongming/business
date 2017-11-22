$(function() {
	show(); /*初始化*/
	addData(); /*添加*/
	//富文本编辑器操作
	function show() {
		$.ajax({
			url : "/business/customer/getAllAutoReply",
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
				formData.append("Keyword", $("#word").val()); //关键词
				formData.append("matchingMethod", $("input[name='mate']").val()); //匹配设置
				formData.append("replyMode", $("input[name='huifu']").val()); //回复设置
				formData.append("replyContent", wordContent); //回复内容
				$(".spinner").show();
				$.ajax({
					type : 'post',
					url : '/business/customer/addAutoReply',
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
			var mate;
			if (e.matchingMethod == 1) {
				mate = "全匹配";
			} else if (e.matchingMethod == 2) {
				mate = "半匹配";
			}
			var huifu;
			if (e.replyMode == 1) {
				huifu = "全部";
			} else if (e.replyMode == 2) {
				huifu = "随即一条";
			}
			tag += '<tr>' +
				'<td>' + e.arId + '</td>' +
				'<td>' + e.keyword + '</td>' +
				'<td>' + mate + '</td>' +
				'<td>' + huifu + '</td>' +
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
					url : '/business/customer/delAutoReply',
					type : 'post',
					data : {
						arId : id
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
			url : "/business/customer/findAutoReplyByArid",
			type : 'post',
			data : {
				arId : id
			},
			dataType : 'json',
			success : function(data) {
				/*显示旧信息*/
				var mate;
					e=data;
				if (e.matchingMethod == "早报") {
					mate = 1;
				} else if (e.matchingMethod == "半匹配") {
					mate = 2;
				}
				var huifu;
				if (e.replyMode == "全部") {
					huifu = 1;
				} else if (e.replyMode == "随即一条") {
					huifu = 2;
				}
				$("#word").val(data.keyword);
				$("#goodsId").val(mate);
				$("#goodsId").val(huifu);
				ue.setContent(data.replyContent);
				// 重新绑定表单提交事件
				$('#submit').unbind('click').click(function() {
					// 获取更新后的表单数据
					var wordContent = ue.getContent(); //获取富文本编辑器内容
					var formData = new FormData();
					formData.append("Keyword", $("#word").val()); //关键词
					formData.append("matchingMethod", $("input[name='mate']").val()); //匹配设置
					formData.append("replyMode", $("input[name='huifu']").val()); //回复设置
					formData.append("replyContent", wordContent); //回复内容
					formData.append("arId", id); //回复内容
					
					$(".spinner").show();
					$.ajax({
						url : '/business/customer/upAutoReply',
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