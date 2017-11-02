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
<title>激活服务</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/activation.less" />
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
<style>
#headul {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	display: none;
}

.mask {
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.6);
	z-index: 9999;
}

.mask_content {
	width: 4.5rem;
	height: 2.6rem;
	background-color: #fff;
	border-radius: 0.1rem;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -1.5rem;
	margin-left: -2.5rem;
	z-index: 99999;
	padding: 0.5rem;
	text-align: center;
}

.mask_content h2 {
	color: #da251c;
	font-size: 0.4rem;
}

.mask_content a {
	margin-top: 0.3rem;
	margin-left: 0.2rem;
	display: block;
	width: 3rem;
	height: 0.7rem;
	line-height: 0.7rem;
	background-color: #da251c;
	color: #fff;
	text-decoration: none;
}
</style>
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<!--头部块开始-->
	<!-- 
<header id="header">
    <a class="back" href="./buy.html"><img src="images/back.png" alt="返回"/></a>
    激活服务
    <a href="#" class="select"><img class="select" src="images/select.png" alt="选项卡"/></a>
</header>
-->
	<!--头部块结束-->
	<section class="spinner">
		<div class="jiazai"></div>
	</section>

	<section id="activation">
		<form action="/business/mp/activation" class="form">
			<h2>输入身份证后六位数</h2>
			<input type="text" class="idCard" />
			<h2>输入服务激活码</h2>
			<input type="text" class="activationCode" />
			<p>Tips：一旦激活成功，该服务激活码自动失效。</p>
		</form>
	</section>

	<section id="immediately">
		<input type="button" value="立即激活" class="sub">
	</section>


	<section class="headul" id="headul">
		<section class="mask"></section>
		<section class="mask_content">
			<h2>恭喜您，激活成功!</h2>
			<a href="/business/mp/service">下一步</a>
		</section>
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
	<!-- 进入验证与跳转 -->
	<script type="text/javascript" src="requst/verification.js"></script>
	<!--<script src="js/activation.js"></script>-->
</body>
</html>