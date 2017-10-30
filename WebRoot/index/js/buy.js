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
	function is_weixn() {
		var ua = navigator.userAgent.toLowerCase();
		if (ua.match(/MicroMessenger/i) == "micromessenger") {
			return true;
		} else {
			return false;
		}
	}
	if (is_weixn()) {
		//在微信浏览器里调用微信支付
		$(".right").click(function() {
			buyClick();

		});

		function buyClick() {
			$(".spinner").show();
			var checkId = 0;
			if ($("#weixin").val() == 0) {

				//	alert("微信支付");
				checkId = 1;
				$.ajax(
					{
						url : "/business/mp/downOrderCharPublicNumber",
						type : "post",
						data : {
							"paymentMethod" : checkId,
						},

						success : function(data) {
							$(".spinner").hide();
							data = JSON.parse(data);

							if (typeof WeixinJSBridge == "undefined") {
								if (document.addEventListener) {
									document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
								} else if (document.attachEvent) {
									document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
									document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
								}
							} else {
								onBridgeReady();
							}
							function onBridgeReady() {
								WeixinJSBridge.invoke(
									'getBrandWCPayRequest', {
										"appId" : data.appId, //公众号名称，由商户传入     
										"timeStamp" : data.timeStamp, //时间戳，自1970年以来的秒数     
										"nonceStr" : data.nonceStr, //随机串     
										"package" : data.package_id,
										"signType" : data.signType, //微信签名方式：     
										"paySign" : data.paySign //微信签名 
									},
									function(res) {

										if (res.err_msg == "get_brand_wcpay_request:ok") {
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
										} // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
									}
								);
							}

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
	} else {
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
	}
})