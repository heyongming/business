/*通过ajax获取数据*/
$(function() {
	//获取导航数据
	getNav();
	function getNav() {
		$.ajax({
			url : "/business/goods/getAllType",
			dataType : "json",
			success : function(data) {
				//导航数据渲染
				var tag = '';
				$.each(data, function(i, e) {
					tag += '<a href="#" data-titleid="' + e.goodsTypeId + '">' + e.goodsTypeName + '</a>';
				});
				$("#nav").append(tag);
				//给第一个li添加样式
				$("#nav").find("a").eq(0).addClass("active");
				//给a点击事件
				$("#nav").find("a").click(function() {
					//排他
					$("#nav").find("a").removeClass("active");
					$(this).addClass("active");
					//获取当前点击a的titleid
					var titleid = $(this).attr("data-titleid");
					if (titleid == null) {
						$.ajax({
							url : "/business/goods/getHotGoodsList",

							success : function(data) {

								data = JSON.parse(data);
								dataTem(data);
							}
						});
					} else {
						//点击当前a，列表显示对应的信息
						$.ajax({
							url : "/business/goods/getTypeGoodsList",
							data : {
								"typeId" : titleid
							},
							success : function(data) {
								data = JSON.parse(data);
								dataTem(data);
							}
						});
					}
				});
				//点击之前，默认显示热门的列表信息
				$.ajax({
					url : "/business/goods/getTypeGoodsList",
					data : {
						"typeId" : 2
					},
					success : function(data) {

						data = JSON.parse(data);
						dataTem(data);
					}
				});
			}
		});
	}
	//封装页面数据渲染
	function dataTem(data) {
		var tag = '';
		$.each(data, function(i, e) {
			tag += '<img class="productImages" src="' + e.imageUrl + '" alt="产品图"/>' +
				'<div class="product">' +
				'<div class="left">' +
				'<p>' + e.goodsName + ' </p>' +
				'<p class="price" style="display:none">￥' + e.goodsPrice + '</p>' +
				'</div>' +
				'<button type="button" data-goodsId="' + e.goodsId + '" class="btn btn-primary">购买</button>' +
				'</div>' +
				'<div class="modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">' +
				'</div>' +
				'<div class="modal-dialog modal-sm" role="document">' +
				'</div>';
		});
		$("#product").html(tag);
		//弹出购买页
		$('.product').each(function(i, e) {
			// 给购买按钮绑定事件
			$(e).find('.btn-primary').click(function() {
				$('.modal').css('display', "block");
				$('.modal-dialog').css('display', "block");
				$('.modal').click(function() {
					$(".modal").hide();
					$('.modal-dialog').hide();
					location.reload();
				});
				var goodsId = $(this).attr("data-goodsId");
				$.ajax({
					url : '/business/goods/getgoodsListById',
					type : 'post',
					data : {
						"goodsId" : goodsId
					},
					dataType : 'json',
					success : function(data) {
						// 购买详情页渲染
						console.log(data);
						//data = JSON.parse(data);
						var arryList = new Array();
						arryList.push(data);
						//var goodsTypeId = data.goodTypes[0].goodsTypeId;
						//判断哪一款产品，暂时不用此功能
						/*if (goodsTypeId == 2) { //短线
							buyTem(arryList);
						} else if (goodsTypeId == 3) { //长线
							buyTemLong(arryList);
						} else if (goodsTypeId == 4) { //长线
							;
						}*/
						buyMoni(arryList);
					}
				});

			});

		});
	}
	// 短线最多三个月，购买详情页封装
	/*function buyTem(arryList) {
		console.log(arryList);
		var tag = '';
		$.each(arryList, function(i, e) {
			tag += '<div class="modal-content">' +
				'<div class="top">' +
				'<div class="img">' +
				'<img class="productImg" src="' + e.imageUrl + '" alt=""/>' +
				'</div>' +
				'<div>' +
				'<p class="productTitle more" data-goodsId="' + e.goodsId + '">' + e.goodsName + '</p>' +
				'<span class="danjia" style="display:none" >' + e.goodsPrice + '</span>' +
				'<p class="num">已选份数*<span></span></p>' +
				'<p class="price">￥<span class="zongjia"></span></p>' +
				'</div>' +
				'</div>' +
				'<div class="middle">' +
				'<div class="left">购买几份</div>' +
				'<div class="right">' +
				'<input class="min" name="" type="button" value="-" />' +
				'<input class="text_box" readonly="readonly" name="" type="text" value="1" />' +
				'<input class="add" name="" type="button" value="+" />' +
				'</div>' +
				'</div>' +
				'<submit class="bottom"><a>确认</a></submit>' +
				'</div>';
		});
		$(".modal-dialog").html(tag);
		total();
		//获得文本框对象
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
			if (parseInt(t.val()) == 3) {
				$('.add').attr('disabled', true);
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
			if (parseInt(t.val()) != 3) {
				$('.add').attr('disabled', false);
			}
			;
			total();
		});
		//提交
		$(".bottom").click(function() {
			var goodsId = $(".productTitle").attr("data-goodsId");
			var paymentNumber = $(".num").find("span").html();
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
		});
	}*/
	// 长线两个月起步，购买详情页封装
	/*function buyTemLong(arryList) {
		console.log(arryList);
		var tag = '';
		$.each(arryList, function(i, e) {
			tag +='<div class="modal-content">' +
				'<div class="top">' +
				'<div class="img">' +
				'<img class="productImg" src="' + e.imageUrl + '" alt=""/>' +
				'</div>' +
				'<div>' +
				'<p class="productTitle more" data-goodsId="' + e.goodsId + '">' + e.goodsName + '</p>' +
				'<span class="danjia" style="display:none" >' + e.goodsPrice + '</span>' +
				'<p class="num">已选份数*<span></span></p>' +
				'<p class="price">￥<span class="zongjia"></span></p>' +
				'</div>' +
				'</div>' +
				'<div class="middle">' +
				'<div class="left">购买几份</div>' +
				'<div class="right">' +
				'<input class="min" name="" type="button" value="-" />' +
				'<input class="text_box" readonly="readonly" name="" type="text" value="2" />' +
				'<input class="add" name="" type="button" value="+" />' +
				'</div>' +
				'</div>' +
				'<submit class="bottom"><a>确认</a></submit>' +
				'</div>';
		});
		$(".modal-dialog").html(tag);
		total();
		//获得文本框对象
		var t = $(".text_box");
		//初始化数量为1,并失效减
		$('.min').attr('disabled', true);
		//数量增加操作
		$(".add").click(function() {
			// 给获取的val加上绝对值，避免出现负数
			t.val(Math.abs(parseInt(t.val())) + 2);
			if (parseInt(t.val()) != 2) {
				$('.min').attr('disabled', false);
			}
			;
			total();
		})
		//数量减少操作
		$(".min").click(function() {
			t.val(Math.abs(parseInt(t.val())) - 2);
			if (parseInt(t.val()) == 2) {
				$('.min').attr('disabled', true);
			}
			;
			total();
		});
		//提交
		$(".bottom").click(function() {
			var goodsId = $(".productTitle").attr("data-goodsId");
			var paymentNumber = $(".num").find("span").html();
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
		});
	}*/
	// 一份一份卖(之前为模拟炒股，购买详情页封装)
	function buyMoni(arryList) {
		//console.log(arryList);
		var tag = '';
		$.each(arryList, function(i, e) {
			tag += '<div class="modal-content">' +
				'<div class="top">' +
				'<div class="img">' +
				'<img class="productImg" src="' + e.imageUrl + '" alt=""/>' +
				'</div>' +
				'<div>' +
				'<p class="productTitle more" data-goodsId="' + e.goodsId + '">' + e.goodsName + '</p>' +
				'<span class="danjia" style="display:none" >' + e.goodsPrice + '</span>' +
				'<p class="num">已选份数*<span></span></p>' +
				'<p class="price" style="display:none">￥<span class="zongjia"></span></p>' +
				'</div>' +
				'</div>' +
				'<div class="middle">' +
				'<div class="left">购买几份</div>' +
				'<div class="right">' +
				'<input class="min" name="" type="button" value="-" />' +
				'<input class="text_box" readonly="readonly" name="" type="text" value="1" />' +
				'<input class="add" name="" type="button" value="+" />' +
				'</div>' +
				'</div>' +
				'<submit class="bottom"><a>确认</a></submit>' +
				'</div>';
		});
		$(".modal-dialog").html(tag);
		total();
		//获得文本框对象
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
		//提交
		$(".bottom").click(function() {
			var goodsId = $(".productTitle").attr("data-goodsId");
			var paymentNumber = $(".num").find("span").html();
			$.ajax({
				url : "/business/order/saveBuyGoods",
				data : {
					"goodsId" : goodsId,
					"paymentNumber" : paymentNumber,
				},
				dataType : 'json',
				success : function(data) {
					if (is_weixn()) {
						location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxaf9208856d550d06&redirect_uri=http%3A%2F%2F18f42658v7.iok.la%2Fbusiness%2Fmp%2FoauthLogin&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
					} else {
						location.href = "login.jsp";
					}

				}
			});
		});
	}
	//商品价格计算
	function total() {
		var allprice = 0; //默认商品总价
		var num = parseInt($(".text_box").val()); //商品数量

		var price = $(".danjia").html(); //商品单价

		var total = price * num; //计算商品总价
		allprice += total;

		$(".num").children("span").text(num.toFixed(0));
		$(".price").children("span").text(allprice.toFixed(0));
	}
	function is_weixn() {
		var ua = navigator.userAgent.toLowerCase();
		if (ua.match(/MicroMessenger/i) == "micromessenger") {
			return true;
		} else {
			return false;
		}
	}
});