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
<title>历史</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/history.less" />
<!--引入rem.js文件-->
<style>
.spinner {
	width: 100%;
	height: 100%;
	position: absolute;
	z-index: 9999;
	background: rgba(233, 233, 233, 0.6);
	display: none;
}

.spinner .jiazai {
	position: absolute;
	width: 6rem;
	height: 6rem;
	left: 50%;
	top: 50%;
	margin-top: -3rem;
	margin-left: -3rem;
	background: url("images/jiazai.gif") no-repeat;
	background-position: center center;
	background-size: cover;
}
</style>

<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<section class="spinner">
		<div class="jiazai"></div>
	</section>

	<!--头部块结束-->
	<section id="message">
		<div class="mes">
			<p class="left">${requestScope.currentGoods.goodsName}</p>
			<p class="color">服务到期：${requestScope.currentGoodsDay}</p>
		</div>
		<div id="nav">


			<c:if test="${requestScope.ServiceTypeId==1}">
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=1"
					class="active">早评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=2">午评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=3">晚评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=4">策略</a>
			</c:if>
			<c:if test="${requestScope.ServiceTypeId==2}">
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=1">早评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=2"
					class="active">午评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=3">晚评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=4">策略</a>
			</c:if>
			<c:if test="${requestScope.ServiceTypeId==3}">
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=1">早评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=2">午评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=3"
					class="active">晚评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=4">策略</a>
			</c:if>
			<c:if test="${requestScope.ServiceTypeId==4}">
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=1">早评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=2">午评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=3">晚评</a>
				<a
					href="/business/mp/history?goodsId=${requestScope.currentGoods.goodsId}&serviceTypeId=4"
					class="active">策略</a>
			</c:if>
		</div>
		<c:forEach var="item" items="${requestScope.zpServiceArticle}"
			varStatus="status">
			<div class="news">
				<a
					href="/business/mp/serviceArticle?serviceArticleNum=${item.serviceArticleNum}">
					<div class="left">
						<p>${item.serviceArticleTitle}</p>
						<p class="date">${item.currentDate}</p>
					</div> <img src="${item.thumbnail}" alt="" />
				</a>
			</div>
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
	<!--<script src="js/history.js"></script>-->
</body>
</html>