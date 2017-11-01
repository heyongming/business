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
<title>服务审核</title>
<!--引入第三方框架-->
<link rel="icon" type="image/x-icon" href="mbimc.ico" />
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/success.css" />
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
		<div class="successContent">
			<ul>
				<li>
					<h2>您已审核通过！</h2>
					<p>产品：${sessionScope.buyGoodsList.goodsName}</p>
					<p>
						激活码：<span>${requestScope.orderActivationCode.activationCode}</span>
					</p> <a href="jihuo.jsp">如何激活服务？</a>
				</li>
				<li class="erweima"><img src="images/erweima.png" alt="" /></li>
			</ul>
		</div>
	</div>


	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<script type="text/javascript">
		$.ajax({
			url : "/business/order/clearSession",
			type : "POST",
			success : function(data) {
				console.log(data);
			}
		});
	</script>
</body>
</html>