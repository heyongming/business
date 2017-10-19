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
<title>迈步官网首页</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/index.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<script type="text/javascript">
	//禁止ios10缩放
	window.onload = function () {
	document.addEventListener('touchstart', function (event) {
	if (event.touches.length > 1) {
	event.preventDefault();
	}
	});
	var lastTouchEnd = 0;
	document.addEventListener('touchend', function (event) {
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
	<header id="header">
	<h2>产品商城</h2>
	</header>
	<!--导航块开始-->
	<nav id="nav">
		<a href="#" class="active">热门</a>
	</nav>
	<!--导航块结束-->

	<!--产品块开始-->
	<section id="product">

	</section>
	<!--产品块结束-->

	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入模板js-->
	<script src="lib/template.js"></script>
	<!--引入自己写的首页js-->
	<script src="js/index.js"></script>
</body>
</html>