$(function() {


	$.ajax({
		url : '/business/goods/getAllData',
		type : 'post',
		dataType : 'json',
		success : function(data) {
		
			var tag = '';
			$.each(data, function(i, e) {
				tag += '<li><img src="' + e.imageUrl + '" alt=""   width="100%">' +
					'<div class="message">' +
					'<div class="left">' +
					'<p>' + e.goodsName + '</p>' +
					'<p class="color">¥' + e.goodsPrice + '</p>' +
					'</div>' +
					'<div class="right btn">' +
					'<a href="/business/pc/checkGoods?goodsId='+e.goodsId+'" target="_blank">购买</a>' +
					'</div>' +
					'<p class="price"><span class="zongjia"></span></p>' +
					'</div>' +
					'	</div></li>';
			});
			$(".goodsList").append(tag);
		}
	});

})