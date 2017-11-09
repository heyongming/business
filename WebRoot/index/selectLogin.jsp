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

<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<style>
body{
    background-color: #fff;
}
#message{
    padding: 0.3rem;
}
#message h2{
    font-size: 0.56rem;
    text-align: center;
    margin: 0.9rem;
    color: #da251c;
}
#message .product{
    padding: 0 0.2rem;
}
#message .product ul li{
    width: 100%;
    height: 1.6rem;
    line-height: 1.6rem;
    text-align: center;
    background-color: #da251c;
    margin: 0.8rem 0;
    border-radius: 0.2rem;
}
#message .product ul li a{
    font-size: 0.36rem;
    color: #fff;
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
		if(id==1)
		{
		//window.location = "/business/mp/mpService?goodsId="+${sessionScope.loginUserGoodsList[0].goodsId};
		}
		
		</script>

	<section id="message">
		<h2>我的服务</h2>
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