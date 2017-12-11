$(function() {
	show(); /*初始化*/
	addData(); /*添加*/
	/*
		var op1 = '{"dateManufacture":"2017-09-21 10:17:56.0","effectiveTime":0,"goodTypes":[{"goodsTypeId":2,"goodsTypeName":"短线"}],"goodsId":10012,"goodsName":"1","goodsPrice":1,"hotGoods":1,"imageUrl":"/business/upload/goods/1JoPLeGNg/timg.jpg","inventory":1,"isShelves":1,"salesVolume":1,"weight":1}'
		var obj = JSON.parse(op1);
		var op = new Array();
		op.push(obj);
		
		// 渲染数据列表

		renderData(op);
	*/
	function show() {
		
		$.ajax({
			url : '/business/goods/getgoodsListData?date1234='+new Date().getTime(),
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
				//	formData.append("goodsId", $("#goodsId").val());
				
				formData.append("file", $("#imageUrl")[0].files[0], $("#imageUrl")[0].files[0].name);
				formData.append("goodsName", $("#goodsName").val());
				formData.append("goodsTypeName", $("select[name='goodsTypeId']").val());
				formData.append("weight", $("#weight").val());
				formData.append("goodsPrice", $("#goodsPrice").val());
				formData.append("inventory", $("#inventory").val());
				formData.append("salesVolume", $("#salesVolume").val());
				formData.append("effectiveTime", $("select[name='effectiveTime']").val());

				formData.append("minMon", $("select[name='minMon']").val());
				formData.append("maxMon", $("select[name='maxMon']").val());
				formData.append("hotGoods", articleContent);
				var isBlend = 0;
				if ($("select[name='isBlend']").val() =="是") {
					isBlend = 1;
				}
				formData.append("isBlend", isBlend);
				var isShelves = 0;
				if ($("select[name='isShelves']").val() == "是") {
					isShelves = 1;
				}
				formData.append("isShelves", isShelves);
				var io = formData.entries();
				for (var i = 0; i < 10; i++) {
					console.log(io.next())
				}
				$.ajax({
					type : 'post',
					url : '/business/goods/addGoods?date1234='+new Date().getTime(),
					data : formData,
					processData : false,
					contentType : false,
					dataType : 'json',
					success : function(data) {

						var op = new Array();
						op.push(data);
						// 渲染数据列表

						renderData(op);
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
			var goodsTypeEntity = e.goodTypes;
			var goodsName = goodsTypeEntity[0].goodsTypeName;
			isShelves = "下架";
			if (e.isShelves == 1) {
				isShelves = "上架";
			}
			isBlend="否"
			if(e.isBlend==1)
			{
			isBlend="是";
			}
			console.log(e)
			tag += '<tr>' +
				'<td>' + e.goodsId + '</td>' +
				'<td style="width: 45px; height: 30px"> <img style="height: 30px" src="' + e.imageUrl + '" alt=""/></td>' +
				'<td>' + e.goodsName + '</td>' +
				'<td>' + goodsName + '</td>' +
				'<td>' + e.weight + '</td>' +
				'<td>' + e.goodsPrice + '</td>' +
				'<td>' + e.inventory + '</td>' +
				'<td>' + e.salesVolume + '</td>' +
				'<td>' + isShelves + '</td>' +

				'<td>' + e.maxMon + '</td>' +
				'<td>' + e.minMon + '</td>' +
				'<td>' + e.effectiveTime + '</td>' +
				'<td>' + isBlend + '</td>' +
				'<td>...</td>' +
				'<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
				'</tr>';
		});
		$('#content').append(tag);
		// 给修改和删除按钮绑定单击事件
		$('#content tr').each(function(i, e) {
			var td = $(e).find('td:last-child');
			var goodsId = $(e).find('td:eq(0)').text();
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
				updateData(goodsId);
			});
			// 给删除按钮绑定事件
			td.find('a:eq(1)').click(function() {
				$(this).parent().parent().remove();
				$.ajax({
					url : '/business/goods/delGoods?date1234='+new Date().getTime(),
					type : 'post',
					data : {
						goodsId : goodsId
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
	var imageUrl;
	function updateData(goodsId) {
		$.ajax({
			url : '/business/goods/getgoodsListById?date1234='+new Date().getTime(),
			type : 'post',
			data : {
				goodsId : goodsId
			},
			dataType : 'json',
			success : function(data) {
				/*显示旧信息*/
				var isShelves = "是",
					isBlend="是";
				
				if (data.isShelves == 0) {
					isShelves = "否";
				}
				if(data.isBlend==0)
					{
					isBlend="否";
					}
				
				//	data.hotGoods
				//	data.isShelves
				//console.log(data)
				$("#goodsId").val(data.goodsId);
				//		$("#imageUrl").val(data.imageUrl);
				imageUrl = data.imageUrl;
				$("#imageUrlTemp").attr("src", data.imageUrl)
				$("#goodsName").val(data.goodsName);
				$("#goodsTypeId").val(data.goodTypes[0].goodsTypeName);
				$("#weight").val(data.weight);
				$("#goodsPrice").val(data.goodsPrice);
				$("#inventory").val(data.inventory);
				$("#salesVolume").val(data.salesVolume);
				$("#isShelvesGoods").val(isShelves);
				$("#maxMon").val(data.maxMon);
				$("#minMon").val(data.minMon);
				$("#effectiveTime").val(data.effectiveTime);
				$("#isBlend").val(isBlend);
				ue.setContent(data.hotGoods); //获取原有富文本编辑器内容
				// 重新绑定表单提交事件
				$('#submit').unbind('click').click(function() {
					// 获取更新后的表单数据
					var articleContent = ue.getContent(); //获取富文本编辑器内容
					var formData = new FormData();
					//	formData.append("goodsId", $("#goodsId").val());
					formData.append("goodsId", $("#goodsId").val());
					formData.append("goodsName", $("#goodsName").val());
					formData.append("goodsTypeName", $("select[name='goodsTypeId']").val());
					formData.append("weight", $("#weight").val());
					formData.append("goodsPrice", $("#goodsPrice").val());
					formData.append("inventory", $("#inventory").val());
					formData.append("salesVolume", $("#salesVolume").val());
					formData.append("effectiveTime", $("select[name='effectiveTime']").val());

					formData.append("minMon", $("select[name='minMon']").val());
					formData.append("maxMon", $("select[name='maxMon']").val());
					formData.append("hotGoods", articleContent);
					var isBlend = 0;
					if ($("select[name='isBlend']").val() =="是") {
						isBlend = 1;
					}
					formData.append("isBlend", isBlend);

					var isShelves = 0;
					if ($("select[name='isShelves']").val() == "是") {
						isShelves = 1;
					}
					formData.append("isShelves", isShelves);
					
					var io = formData.entries();
					for (var i = 0; i < 10; i++) {
						console.log(io.next())
					}
					if (($("#imageUrl")[0].files[0]) != null) {
						formData.append("file", $("#imageUrl")[0].files[0], $("#imageUrl")[0].files[0].name);

					}
					formData.append("imageUrl", imageUrl);

					$.ajax({
						type : 'post',
						url : '/business/goods/updateGoodsImage?date1234='+new Date().getTime(),
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