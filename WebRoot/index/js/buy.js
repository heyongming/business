/**
 * Created by user on 2017/9/4.
 */
/*支付*/
$(function() {
	$("#zhifubao").click(function() {
		$("#zhifubao").find("span").addClass('spanColor');
		$("#zhifubao").find("div").removeClass('select').addClass('active');
		$("#weixin").find("span").removeClass("spanColor");
		$("#weixin").find("div").removeClass('active').addClass('select');
		$("#zhifubao").val("0");
		$("#weixin").val("1");
	})
	$("#weixin").click(function() {
		$("#weixin").find("span").addClass('spanColor');
		$("#weixin").find("div").removeClass('select').addClass('active');
		$("#zhifubao").find("span").removeClass("spanColor");
		$("#zhifubao").find("div").removeClass('active').addClass('select');
		$("#weixin").val("0");
		$("#zhifubao").val("1");
	});
	$(".right").click(function() {
		var checkId = 0;
		if ($("#weixin").val() == 0) {
			checkId = 1;
			alert("微信支付");
		} else if ($("#zhifubao").val() == 0) {
			checkId = 2;
			alert("支付宝支付");
		}
		$.ajax(
			{
				url : "/business/order/saveBuyGoods",
				data : {
					"paymentMethod" : checkId,
				},
				dataType : 'json',
				success : function(data) {
					alert(data)
				//	location.href = "../message.jsp";
				}
			}
		)
	})
})