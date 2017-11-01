<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/mbimc/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>后台登录</title>
<!--引入第三方框架-->
<link rel="icon" type="image/x-icon" href="mbimc.ico" />
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/login.css" />
</head>

<body>

	<c:if test="${empty sessionScope.buyGoodsList}">
		<script type="text/javascript">
			location.href = "/business/mbimc/"
		</script>

	</c:if>
	<div id="content">
		<!--左上角logo-->
		<div class="logo">
			<img src="images/loginLogo.png" alt="" />
		</div>
		<div class="login">
			<h2>登录</h2>
			<form action="" method="post">
				<ul>
					<li><img src="images/login01.png" alt="" /> <input
						type="text" name="username" id="username" placeholder="请输入您的名字" /></li>
					<li class="tel"><img src="images/login02.png" alt="" /> <input
						type="text" id="j_phone" class="phone" name="phone"
						placeholder="请输入您的手机号码" /> <a id="j_getVerifyCode"
						class="getverify-code-btn">获取验证码</a></li>
					<li><img src="images/login03.png" alt="" /> <input
						type="text" name="code" id="password" placeholder="请输入6位数字验证码" /></li>
					<li><img src="images/login03.png" alt="" /> <input
						type="text" name="rdCode" id="recommended"
						placeholder="请输入6位数字推荐码" /></li>
				</ul>
				<button id="btn" type="submit">确认资料并保存</button>
			</form>
		</div>
	</div>


	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<!--引入自己写的登录js-->
	<script src="js/login.js"></script>
	<!--引入手机验证码的js-->
	<script src="js/loginCode.js"></script>
</body>
</html>