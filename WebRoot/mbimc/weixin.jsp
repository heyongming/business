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
<style>
#content {
	width: 100%;
	height: 100%;
	background-color: #fff;
	position: relative;
}

.logo {
	z-index: 22;
	position: absolute;
	left: 4%;
	top: 26px
}

#logo img {
	width: 100%
}

#content h2 {
	margin-bottom: 30px;
}

#content>.message {
	width: 1000px;
	height: 500px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -210px;
	margin-left: -200px;
}

#content .erweima {
	width: 400px;
	height: 400px;
}
</style>
</head>

<body>
	<c:if test="${empty sessionScope.buyuser}">
		<script type="text/javascript">
			location.href = "/business/mbimc/"
		</script>

	</c:if>
	<div id="content">
		<!--左上角logo-->
		<div class="logo">
			<img src="images/orderLogo.png" alt="" />
		</div>
		<div class="message">
			<h2>【 扫一扫，微信支付 】</h2>
			<div class="erweima">
				<img src="${requestScope.imageUrl}" alt="" width="100%" />
			</div>
		</div>
	</div>

	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<script src="js/weixin.js"></script>

</body>
</html>