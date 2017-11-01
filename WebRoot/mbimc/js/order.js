$(function() {
	var danjia = $(".danjia").text(); //获取产品单价
	var price = $(".price").children("span").text(danjia); //总价开始默认与单价相同
	var t = $(".text_box");
	//初始化数量为1,并失效减
	$('.min').attr('disabled', true);
	//数量增加操作
	$(".add").click(function() {
		// 给获取的val加上绝对值，避免出现负数
		t.val(Math.abs(parseInt(t.val())) + 1);
		if (parseInt(t.val()) != 1) {
			$('.min').attr('disabled', false);
		}
		;
		total();
	})
	//数量减少操作
	$(".min").click(function() {
		t.val(Math.abs(parseInt(t.val())) - 1);
		if (parseInt(t.val()) == 1) {
			$('.min').attr('disabled', true);
		}
		;
		total();
	});
	//下单购买
	$("#btn").click(function() {
		
		var goodsId = $(".goodsName").attr("tag");
		var paymentNumber = $(".text_box").val();
		if(goodsId==null || paymentNumber==null)
		{
			return false;
		}
		$.ajax({
			url : "/business/order/saveBuyGoods",
			data : {
				"goodsId" : goodsId,
				"paymentNumber" : paymentNumber,
			},
			dataType : 'json',
			success : function(data) {
				location.href = "login.jsp";
			}
		});
		return false;
	})
	//封装商品数量操作
	function total() {
		var allprice = 0; //默认商品总价
		var num = parseInt($(".text_box").val()); //商品数量
		var price = parseInt($(".danjia").text()); //商品单价
		var total = price * num; //计算商品总价
		allprice += total;
		$(".num").children("span").text(num.toFixed(0));
		$(".price").children("span").text(allprice.toFixed(0));
	}
})