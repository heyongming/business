/**
 * Created by user on 2017/9/4.
 */
/*支付*/
$(function() {
	/*$("#zhifubao").click(function() {
		$("#zhifubao").find("span").addClass('spanColor');
		$("#zhifubao").find("div").removeClass('select').addClass('active');
		$("#weixin").find("span").removeClass("spanColor");
		$("#weixin").find("div").removeClass('active').addClass('select');
		$("#zhifubao").val("0");
		$("#weixin").val("1");
	})*/
	/*$("#weixin").click(function() {
		$("#weixin").find("span").addClass('spanColor');
		$("#weixin").find("div").removeClass('select').addClass('active');
		$("#zhifubao").find("span").removeClass("spanColor");
		$("#zhifubao").find("div").removeClass('active').addClass('select');
		$("#weixin").val("0");
		$("#zhifubao").val("1");
	});*/
	var timer;
	var ua = navigator.userAgent.toLowerCase();
	if (/android/.test(ua)) { //android终端

		timer = setInterval(function() {
			$.ajax({
				url : "/business/order/checkBuy",
				type : "POST",
				success : function(data) {
					//		alert(data)
					data = JSON.parse(data);
					if (data.success == 'true') {
						//支付成功
						location.href = "/business/index/message.jsp";
					} else {
						//支付失败
						//	location.href = ".html"; //确认订单页面
					}
				}
			})
		}, 3000)
	}
	$.ajax({
		url : "/business/order/checkBuy",
		type : "POST",
		success : function(data) {
			//	alert(data)
			data = JSON.parse(data);
			if (data.success == 'true') {
				//支付成功
				location.href = "/business/index/message.jsp";
			} else {
				//支付失败
				//	location.href = ".html"; //确认订单页面
			}
		}
	})

	$(".right").click(function() {
		buyClick();

	})

	function buyClick() {
		$(".spinner").show();
		var checkId = 0;
		if ($("#weixin").val() == 0) {

			//	alert("微信支付");
			checkId = 1;
			$.ajax(
				{
					url : "/business/mp/downOrder",
					type : "post",
					data : {
						"paymentMethod" : checkId,
					},

					success : function(data) {
						//	alert(data)
						$(".spinner").hide();
						data = JSON.parse(data);
						//	alert(data)
						location.href = data.errMsg;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						$(".spinner").hide();
						alert("出现未知错误，请与客服联系，为您造成的不便，敬请谅解" + "状态码" + XMLHttpRequest.status + "错误信息" + XMLHttpRequest.readyState)
					}
				}
			)
		//	alert("微信支付");
		} /*else if ($("#zhifubao").val() == 0) {
			 checkId = 2;
			 //	alert("支付宝支付");
			 }*/
	}
})