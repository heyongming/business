$(function() {
	//页面初始加载数据类型
	$.ajax({
		url : "/business/goods/getAllData",
		dataType : "json",
		success : function(data) {

			//定义全局变量
			var goodsId;
			var UpgradeGoodsId;

			//升级前标题
			var tag = "<option>--请选择--</option>";
			$.each(data, function(i, e) {
				tag += '<option value="' + e.goodsId + '">' + e.goodsName + '</option>';
			})
			$("#titleBefore").html(tag);
			dataBefore();

			//升级后标题
			var mes = "<option>--请选择--</option>";
			$.each(data, function(i, e) {
				mes += '<option value="' + e.goodsId + '">' + e.goodsName + '</option>';
			})
			$("#titleAfter").html(mes);
			dataAfter();

			//点击升级前数据详情
			function dataBefore() {
				$("#titleBefore").bind("change", function() {
					goodsId = $(this).val();

					$.ajax({
						url : "/business/goods/getgoodsListById",
						data : {
							"goodsId" : goodsId
						},
						dataType : "json",
						success : function(data) {
							var sale = "下架",
								hot = "不热门",
								isBlend = "否";

							if (data.hotGoods > 0) {
								hot = "热门";
							}
							if (data.isShelves > 0) {
								sale = "上架";
							}
							if (data.isBlend > 0) {
								isBlend = "是";
							}
							//成功
							var tag = "";
							tag += '<tr>' +
								'<td>' + data.goodsId + '</td>' +
								'<td style="width: 45px; height: 30px"><img style="height: 30px" src="' + data.imageUrl + '" alt=""/></td>' +
								'<td>' + data.goodsName + '</td>' +
								'<td>' + data.goodTypes[0].goodsTypeName + '</td>' +
								'<td>' + data.weight + '</td>' +
								'<td>' + data.goodsPrice + '</td>' +
								'<td>' + data.inventory + '</td>' +
								'<td>' + data.salesVolume + '</td>' +
								'<td>' + hot + '</td>' +
								'<td>' + sale + '</td>' +
								'<td>' + data.maxMon + '</td>' +
								'<td>' + data.minMon + '</td>' +
								'<td>' + data.effectiveTime + '</td>' +
								'<td>' + isBlend + '</td>' +
								'</tr>';
							$("#productBefore").html(tag);
						},
						error : function() {
							console.log("选择失败!");
						}
					})

					return goodsId;
				});
			}

			//点击升级后数据详情
			function dataAfter() {
				$("#titleAfter").bind("change", function() {
					UpgradeGoodsId = $(this).val();

					$.ajax({
						url : "/business/goods/getgoodsListById",
						data : {
							"goodsId" : UpgradeGoodsId
						},
						dataType : "json",
						success : function(data) {
							//成功
							var sale = "下架",
								hot = "不热门",
								isBlend = "否";;
								if (data.isBlend > 0) {
									isBlend = "是";
								}
							if (data.hotGoods > 0) {
								hot = "热门";
							}
							if (data.isShelves > 0) {
								sale = "上架";
							}
							var tag = "";
							tag += '<tr>' +
								'<td>' + data.goodsId + '</td>' +
								'<td style="width: 45px; height: 30px"><img style="height: 30px" src="' + data.imageUrl + '" alt=""/></td>' +
								'<td>' + data.goodsName + '</td>' +
								'<td>' + data.goodTypes[0].goodsTypeName + '</td>' +
								'<td>' + data.weight + '</td>' +
								'<td>' + data.goodsPrice + '</td>' +
								'<td>' + data.inventory + '</td>' +
								'<td>' + data.salesVolume + '</td>' +
								'<td>' + hot + '</td>' +
								'<td>' + sale + '</td>' +
								'<td>' + data.maxMon + '</td>' +
								'<td>' + data.minMon + '</td>' +
								'<td>' + data.effectiveTime + '</td>' +
								'<td>' + isBlend + '</td>' +
								'</tr>';
							$("#productAfter").html(tag);
						},
						error : function() {
							console.log("选择失败!");
						}
					})
					return UpgradeGoodsId;
				});
			}


			//提交表单将对应关系传到后台
			$("button").click(function() {
				//	goodsId = dataBefore();
				//	UpgradeGoodsId = dataAfter();

				$.ajax({
					url : "/business/goods/insertGoodslistUpgrade",
					type : "post",
					dataType : "json",
					data : {
						"goodsId" : goodsId,
						"UpgradeGoodsId" : UpgradeGoodsId
					},
					success : function(data) {
						alert(data.errMsg);

					},
					error : function() {
						console.log("系统错误，请联系管理员!");
					}
				})
				return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可
			});
		}
	})
})