<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/index/";
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
<title>服务号</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/service.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>


	<!-- 产品信息开始-->
	<section id="product">
		<div class="left">
			<!-- 
			<div class="integral">
				<img src="images/integral.png" alt="" />
				<p>##积分</p>
			</div>
		 -->
			<div class="product">
				<p class="pro">${requestScope.currentGoods.goodsName}</p>
				<p class="date">服务到期日：${requestScope.currentGoodsDay}天</p>
			</div>
		</div>
		<div class="right">
			<a href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}">查看历史&nbsp;&nbsp;<img
				src="images/back_01.png" alt="" /></a>
		</div>
	</section>
	<!--新闻块开始-->
	<section id="news">
		<h2>${requestScope.currentTime}</h2>
		<c:forEach var="item" items="${requestScope.currentGoodsList}"
			varStatus="status">
			<c:if test="${item.serviceTypeId==1}">
				<div class="reader">
					<img src="images/product.png" alt="" />
					<div class="moring">
						<p>股市早报</p>
						<a href="/business/mp/serviceArticle?serviceArticleNum=${item.serviceArticleNum}">立即阅读</a>
					</div>
				</div>
			</c:if>
			<c:if test="${item.serviceTypeId==2}">
				<div class="reader">
					<img src="images/product.png" alt="" />
					<div class="moring">
						<p>股市中报</p>
						<a href="/business/mp/serviceArticle?serviceArticleNum=${item.serviceArticleNum}">立即阅读</a>
					</div>
				</div>

			</c:if>

			<c:if test="${item.serviceTypeId==3}">
				<div class="reader">
					<img src="images/product.png" alt="" />
					<div class="moring">
						<p>股市晚报</p>
						<a href="/business/mp/serviceArticle?serviceArticleNum=${item.serviceArticleNum}">立即阅读</a>
					</div>
				</div>
			</c:if>

		</c:forEach>

	
	</section>


	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入模板js-->
	<script src="lib/template.js"></script>
	<!--引入自己写的首页js-->
	<!--<script src="js/service.js"></script>-->
</body>
</html>