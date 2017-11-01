$(function() {

	timer = setInterval(function() {
		$.ajax({
			url : "/business/order/checkBuy",
			type : "POST",
			success : function(data) {
				//		alert(data)
				data = JSON.parse(data);
				if (data.success == 'true') {
					//支付成功
					location.href = "/business/mbimc/shenhe.jsp";
				} else {
					//支付失败
					//	location.href = ".html"; //确认订单页面
				}
			}
		})
	}, 3000)

})