<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>

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

	<section id="activation">
		<form action="/business/mp/activation" class="form">
			<h2>输入身份证后四位</h2>
			<input type="text" class="idCard"/>
			<h2>输入服务激活码</h2>
			<input type="text" class="activationCode" />
			<p>Tips：一旦激活成功，该服务激活码自动失效。</p>
		</form>
	</section>

	<section id="immediately">
		<input type="button" value="立即激活" class="sub" >
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