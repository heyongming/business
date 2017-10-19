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
<title>查看已购买产品</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/history.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<style>
#message {
	padding: 0.3rem;
}

#message h2 {
	font-size: 0.36rem;
	text-align: center;
	margin-bottom: 0.3rem;
	color: #da251c;
}

#message .product {
	padding: 0 0.2rem;
}

#message .product ul li {
	width: 100%;
	height: 0.6rem;
	line-height: 0.6rem;
	text-align: center;
	background-color: #f5f5f5;
	border-radius: 0.05rem;
	margin-bottom: 0.2rem;
}

#message .product ul li a {
	font-size: 0.28rem;
}
</style>
</head>
<body>
	<c:if test="${empty sessionScope.loginUserGoodsList}">
		<script type="text/javascript">
			window.location = "/business/index/index.jsp";
		</script>
	</c:if>
		
		<script type="text/javascript">
		var id="${sessionScope.loginUserGoodsListSize}";
		
		window.location = "/business/mp/mpService?goodsId="+${sessionScope.loginUserGoodsList[0].goodsId};
		</script>
	
	<section id="message">
		<h2>查看已购买产品</h2>
		<div class="product">
			<ul>
				<c:forEach var="item" items="${sessionScope.loginUserGoodsList}"
					varStatus="status">

					<li><a href="/business/mp/mpService?goodsId=${item.goodsId}">
							${item.goodsName} </a></li>

				</c:forEach>

			</ul>
		</div>

	</section>
	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
</body>
</html>