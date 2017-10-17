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
				var commBox=$("#goodsId")
				
				$.each(data, function(i, e) {
					var appendHtml="<option value="+e.goodsId+">"+e.goodsName+"</option>";
					commBox.append(appendHtml);
					
				})
			}
		});
	}
	//富文本编辑器操作
	function show() {
		$.ajax({
			url : "/business/serviceArticle/getFullData",
			type : 'post',
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				console.log(data);
				renderData(data);
			}
		});
	}
	//富文本编辑器操作
	var ue = UE.getEditor('articleContent');
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
				var articleContent = ue.getContent(); //获取富文本编辑器内容
				var formData = new FormData();
				formData.append("serviceArticleTitle", $("#serviceArticleTitle").val());
				formData.append("file", $("#thumbnail")[0].files[0], $("#thumbnail")[0].files[0].name);
				formData.append("goodsId", $("select[name='goodsId']").val());
				formData.append("serviceTypeId", $("select[name='serviceTypeId']").val());
				formData.append("targetTime", $("#targetTime").val());
				formData.append("author", $("#author").val());
				formData.append("articleContent", articleContent);
				$.ajax({
					type : 'post',
					url : '/business/serviceArticle/addServiceArticle',
					data : formData,
					processData : false,
					contentType : false,
					dataType : 'json',
					success : function(data) {
						// 渲染数据列表
						$("#j_mask").css("display", "none");
						$("#j_formAdd").css("display", "none");
						if (data.success == "true") {
						//	show();

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
		
			//服务板块
			var serviceTypeId;
			if (e.serviceTypeId == 1) {
				serviceTypeId = "早报";
			} else if (e.serviceTypeId == 2) {
				serviceTypeId = "中报";
			} else if (e.serviceTypeId == 3) {
				serviceTypeId = "晚报";
			}
			tag += '<tr>' +
				'<td>' + e.serviceArticleNum + '</td>' +
				'<td>' + e.serviceArticleTitle + '</td>' +
				'<td style="width: 45px; height: 30px"> <img style="height: 30px" src="' + e.thumbnail + '" alt=""/></td>' +
				'<td>' + e.goodsList.goodsName + '</td>' +
				'<td>' + serviceTypeId + '</td>' +
				'<td>' + e.targetTime + '</td>' +
				'<td>' + e.author + '</td>' +
				'<td>...</td>' +
				'<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
				'</tr>';
		});
		$('#content').append(tag);
		// 给修改和删除按钮绑定单击事件
		$('#content tr').each(function(i, e) {
			var td = $(e).find('td:last-of-type');
			var serviceArticleNum = $(e).find('td:eq(0)').text(); //文章ID
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
			// 给删除按钮绑定事件
			td.find('a:eq(1)').click(function() {
				$(this).parent().parent().remove();
				$.ajax({
					url : '/business/serviceArticle/deleteServiceArtcle',
					type : 'post',
					data : {
						serviceArticleNum : serviceArticleNum
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
	var thisServiceArticleNum = null;
	function updateData(serviceArticleNum) {
		thisServiceArticleNum = serviceArticleNum;
		$.ajax({
			url : "/business/serviceArticle/findById",
			type : 'post',
			data : {
				serviceArticleNum : serviceArticleNum
			},
			dataType : 'json',
			success : function(data) {
				/*显示旧信息*/
				//商品分类
				console.log(data);
				alert(data.goodsList.goodsId)
				
				//服务板块
				var serviceTypeId;
				if (data.serviceTypeId == 1) {
					serviceTypeId = "早报";
				} else if (data.serviceTypeId == 2) {
					serviceTypeId = "中报";
				} else if (data.serviceTypeId == 3) {
					serviceTypeId = "晚报";
				}
				$("#serviceArticleTitle").val(data.serviceArticleTitle);
				//     $("#thumbnail").val(data.thumbnail);

				$("#goodsId").val(data.goodsList.goodsId);
				$("#serviceTypeId").val(data.serviceTypeId);
				$("#targetTime").val(data.targetTime); //计划发送时间
				$("#author").val(data.author);

				ue.setContent(data.articleContent);
				// 重新绑定表单提交事件
				$('#submit').unbind('click').click(function() {
					// 获取更新后的表单数据
					var articleContent = ue.getContent(); //获取富文本编辑器内容
					var formData = new FormData();
					formData.append("serviceArticleTitle", $("#serviceArticleTitle").val());
					if ($("#thumbnail")[0].files[0] != null) {
						formData.append("file", $("#thumbnail")[0].files[0], $("#thumbnail")[0].files[0].name);
					}

					formData.append("goodsId", $("select[name='goodsId']").val());
					formData.append("serviceTypeId", $("select[name='serviceTypeId']").val());
					formData.append("targetTime", $("#targetTime").val());
					formData.append("author", $("#author").val());
					formData.append("articleContent", articleContent);
					formData.append("serviceArticleNum", thisServiceArticleNum);

					$.ajax({
						url : '/business/serviceArticle/updateServiceArtcle',
						type : 'post',
						data : formData,
						dataType : 'json',
						processData : false,
						contentType : false,
						success : function(data) {
							// 渲染数据列表
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