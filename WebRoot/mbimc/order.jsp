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
<link rel="stylesheet" href="css/order.css" />
</head>

<body>
	<c:if test="${empty requestScope.goodsList}">
		<script type="text/javascript">
			location.href = "/business/mbimc/"
		</script>

	</c:if>
	<div id="content">
		<!--左上角logo-->
		<div class="logo">
			<img src="images/orderLogo.png" alt="" />
		</div>
		<div class="order">
			<form action="" enctype="multipart/form-data">
				<h2>确认订单信息</h2>
				<table>
					<thead>
						<tr class="title">

							<th>商品图片</th>
							<th>商品名称</th>
							<th>商品价格</th>

							<th>数量</th>
							<th>支付方式</th>
						</tr>
					</thead>
					<tbody id="message">
						<tr>

							<td style="width: 130px;height: 60px;padding:0;padding-top:10px;"><img
								src="${requestScope.goodsList.imageUrl}" alt="" width="100%" /></td>
							<td class="goodsName" tag="${requestScope.goodsList.goodsId}">${requestScope.goodsList.goodsName}</td>
							<td>￥<span class="danjia">${requestScope.goodsList.goodsPrice}</span></td>

							<td>
								<div class="num">
									<input class="min" name="" type="button" value="-" /> <input
										class="text_box" readonly="readonly" name="" type="text"
										value="1" /> <input class="add" name="" type="button"
										value="+" />
								</div>
							</td>
							<td>微信支付</td>
						</tr>
					</tbody>
				</table>
				<div class="bottom">
					<p class="price" style="color:#da251c">
						实付款：¥<span></span>
					</p>
					<button id="btn" type="button">提交订单</button>
				</div>
			</form>
		</div>
	</div>


	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<script src="js/order.js"></script>
	<script>

</script>

</body>
</html>