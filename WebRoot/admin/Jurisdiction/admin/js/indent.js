$(function() {
	show();
	/*默认显示数据*/
	function show() {
		$.ajax({
			url : '/business/order/getDataAll',
			type : 'post',
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				console.log(data);
				dataTem(data);

			}
		});

	}

	/*点击展示全部信息*/
	$("#whole").click(function() {
		show();
	});
	/*订单查询*/
	$("#number").click(function() {
		var orderSerialNumber = $('#dingdan').val();
		$.ajax({
			url : '/business/order/getWhereData',
			data : {
				orderSerialNumber : orderSerialNumber
			},
			success : function(data) {
				if (data == "") {
					$('#content').html("");
					return;
				}

				data = JSON.parse(data)
				dataTem(data);
			}
		});
	});

	/*用户名查询*/
	$("#name").click(function() {
		var userName = $('#yonghu').val();
		$.ajax({
			url : '/business/order/getWhereData',
			data : {
				"orderForm.user.userName" : userName
			},
			success : function(data) {
				if (data == "") {
					$('#content').html("");
					return;
				}

				data = JSON.parse(data)
				dataTem(data);
			}
		});
	});

	/*下单时间查询*/
	$("#time").click(function() {
		var dateManufacture = $('#xiadan').val();
		$.ajax({
			url : '/business/order/getWhereData',
			data : {
				'purchaseTime' : dateManufacture
			},
			success : function(data) {
				if (data == "") {
					$('#content').html("");
					return;
				}

				data = JSON.parse(data)
				dataTem(data);

			}
		});
	});

	/*封装渲染*/
	function dataTem(data) {
		var tag = '';
		$.each(data, function(i, e) {
			var userName = e.user.userName;
			var goodsId = e.goodsList.goodsId;
			var imgUrl = e.goodsList.imageUrl;
			var goodsListName = e.goodsList.goodsName;
			var goodsPrice = e.goodsList.goodsPrice;
			var activationCode = e.activationCode.activationCode;

			tag += '<tr>' +
				'<td>' + userName + '</td>' +
				'<td>' + goodsId + '</td>' +
				'<td>' + e.orderSerialNumber + '</td>' +
				'<td style="width: 45px; height: 30px"><img style="height: 30px" src=' + imgUrl + ' alt=""/></td>' +

				'<td>' + goodsListName + '</td>' +
				'<td>' + e.purchaseTime + '</td>' +
				'<td>' + goodsPrice + '</td>' +
				'<td>' + e.paymentNumber + '</td>' +
				'<td>' + e.actualPurchasePriceGoods + '</td>' +
				'<td>' + activationCode + '</td>' +
				'<td>' + e.orderStatus + '</td>' +
				'<td>' + e.orderStatus + '</td>' +
				'</tr>';
		});
		$('#content').html(tag);
	}
})