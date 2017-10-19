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
<title>填写资料</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/login.less" />
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
	<h2>填写资料</h2>
	</header>
	<!--填写信息-->
	<section id="message">
		<form id="form">
			<ul>
				<li>真实姓名：<input type="text" name="userName" id="username"
					placeholder="请输入您的名字" /></li>
				<li class="tel">手机号码：<input type="text" id="j_phone"
					class="phone" name="phone" placeholder="请输入您的手机号码" /> <a
					id="j_getVerifyCode" class="getverify-code-btn">获取手机验证码</a></li>
				<li>验证码：<input type="text" name="code" id="password"
					placeholder="请输入6位数字验证码" /></li>
				<li>推荐码：<input type="text" name="rdCode" id="recommended"
					placeholder="请输入6位数字推荐码" /></li>
			</ul>
			<div class="submit">
				<input type="button" id="btn" class="btnbox" value="确认资料并保存">
			</div>
		</form>
	</section>



	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入模板js-->
	<script src="lib/template.js"></script>
	<!--引入自己写的登录js-->
	<script src="js/login.js"></script>
	<!--引入手机验证码的js-->
	<script src="js/loginCode.js"></script>
</body>
</html>