<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>确认订单</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/buy.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<script type="text/javascript">
	//禁止ios10缩放
	window.onload = function() {
		document.addEventListener('touchstart', function(event) {
			if (event.touches.length > 1) {
				event.preventDefault();
			}
		});
		var lastTouchEnd = 0;
		document.addEventListener('touchend', function(event) {
			var now = (new Date()).getTime();
			if (now - lastTouchEnd <= 300) {
				event.preventDefault();
			}
			lastTouchEnd = now;
		}, false)
	}
</script>

</head>
<body>
	<c:if test="${empty sessionScope.buyuser}">
		<script type="text/javascript">
			location.href = "business/index/"
		</script>

	</c:if>
	<header id="header">
		<h2>确认订单</h2>
	</header>
	<!--message开始-->
	<section id="message">
		<div id="left">
			<p>${sessionScope.buyuser.userName }:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.buyuser.phone }</p>
			<p>推荐码：&nbsp;&nbsp;${sessionScope.buyuser.rdCode }</p>
		</div>
	</section>
	<!--message结束-->

	<!--产品块开始-->
	<section id="product">
		<img src="${sessionScope.buyGoodsList.imageUrl}" alt="" />
		<div>
			<p id="productTitle">${sessionScope.buyGoodsList.goodsName}</p>
			<p id="productPrice">￥${sessionScope.buyGoodsList.goodsPrice}</p>
		</div>
	</section>
	<!--产品块结束-->

	<!--支付块开始-->
	<section id="money">
		<p>支付方式</p>
		<ul>
			<!-- 			<li id="zhifubao" value="1"><img src="images/zf.png" alt="" />
				<span>支付宝支付</span>
				<div class="select"></div></li>
				 -->

			<li id="weixin" value="0"><img src="images/wx.png" alt="" /> <span
				class="spanColor">微信支付</span>
				<div class="active"></div></li>
			<!-- <li>
            <img src="images/yh.png" alt=""/>
            <span>银行卡支付</span>
            <div class="select"></div>
        </li>-->
		</ul>
	</section>
	<!--支付块结束-->

	<!--底部开始-->
	<footer id="footer">
		<div class="left">
			<span>实付：</span> <span class="price">￥${sessionScope.buyOderForm.actualPurchasePriceGoods}</span>
		</div>
		<div class="right">确认</div>
	</footer>
	<!--底部结束-->

	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入模板js-->
	<script src="lib/template.js"></script>
	<!--引入自己写的确认订单页面js-->
	<script src="js/buy.js"></script>
</body>
</html>