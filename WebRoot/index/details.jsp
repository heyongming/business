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
<title>产品详情</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet" href="css/details.css" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<section id="message">
		<div id="header">
			<h2>产品详情</h2>
		</div>
		<div id="top">
			<img src="${requestScope.details.imageUrl}" alt="" />
			<div>
				<p id="productId" style="display: none">${requestScope.details.goodsId}</p>
				<p>${requestScope.details.goodsName}</p>
				<p class="span" style="display: none">${requestScope.details.goodsPrice}</p>
				<p class="xl">
					已售：<span>${requestScope.details.salesVolume}件</span>
				</p>
			</div>
		</div>
		<div class="pingjia" style="display: none">
			<p>产品评价：700人评价 95%好评</p>
			<p>张*玲</p>
			<p>2017-11-06</p>
			<p>此处是评论此处是评论此处是评论此处是评论此处是评论此处是 评论此处是评论此处是评论此处是评论此处是评论</p>
		</div>
		<div id="details">
			<h2>产品详情</h2>
			<div class="tp">${requestScope.details.hotGoods}</div>
		</div>
		<div id="footer">
			<button type="button" class="btn-primary">立即购买</button>
		</div>
		<div class="modal" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel"></div>
		<div class="modal-dialog modal-sm" role="document">
			
		</div>
	</section>
	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script src="js/details.js"></script>
</body>
</html>