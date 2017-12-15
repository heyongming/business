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
<link rel="stylesheet" href="css/shenhe.css" />
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
		<div class="order">
			<div>
				<h2>订单信息</h2>
				<table>
					<thead>
						<tr class="title">
							<th>用户id</th>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>真实姓名</th>
							<th>手机号码</th>
							<th>推荐码</th>
							<th>订单编号</th>
							<th>支付编号</th>
						</tr>
					</thead>
					<tbody id="message">
						<tr>
							<td class="userId">${sessionScope.buyuser.userId }</td>
							<td style="width: 130px;height: 60px;padding:0;padding-top:10px;"><img
								src="${sessionScope.buyGoodsList.imageUrl}" alt="" width="100%" /></td>
							<td>${sessionScope.buyGoodsList.goodsName }</td>
							<td>￥<span class="danjia">${sessionScope.buyOrderResult.actualPurchasePriceGoods}</span></td>
							<td>${sessionScope.buyuser.userName }</td>
							<td>${sessionScope.buyuser.phone }</td>
							<td>${sessionScope.buyuser.rdCode }</td>
							<td>${sessionScope.buyOrderResult.orderSerialNumber }</td>
							<td>${sessionScope.buyOrderResult.openId }</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="process">
				<h2>服务审核流程</h2>
				<div class="bottom">
					<p></p>
					<ul>
						<li><div class="active"></div> <a class="disabled:true">身份核验</a></li>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) gt 2}">
							<li><div class="active"></div> <a class="disabled:true">签署<span>《服务协议》</span></a></li>
						</c:if>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) eq 2}">
							<c:if
								test="${(sessionScope.buyGoodsList.goodTypes[0].goodsTypeId) eq 4}">
								<li><div></div> <a href="../mbimc/tougu.jsp">签署<span>《服务协议》</span></a></li>
							</c:if>
							<c:if
								test="${(sessionScope.buyGoodsList.goodTypes[0].goodsTypeId) lt 4}">
								<li><div></div> <a href="../mbimc/zixun.jsp">签署<span>《服务协议》</span></a></li>
							</c:if>

						</c:if>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) eq 3}">
							<li><div></div> <a id="look">查看<span>《电子协议》</span></a></li>
						</c:if>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) gt 3}">
							<li><div class="active"></div> <a class="disabled:true">查看<span>《电子协议》</span></a></li>
						</c:if>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) lt 3}">
							<li><div></div> <a class="disabled:true">查看<span>《电子协议》</span></a></li>
						</c:if>

						<c:if test="${(sessionScope.buyOrderResult.orderStatus) eq 4}">
							<li>
								<div></div> <a href="/business/order/success?isPc=2">查看服务激活码</a>
							</li>
						</c:if>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) gt 4}">
							<li>
								<div class="active"></div> <a class="disabled:true">查看服务激活码</a>
							</li>
						</c:if>
						<c:if test="${(sessionScope.buyOrderResult.orderStatus) lt 4}">
							<li>
								<div></div> <a class="disabled:true">查看服务激活码</a>
							</li>
						</c:if>

						<!-- <li><div class="active"></div> <a>身份核验</a></li>
						<li><div></div> <a href="agreement.html">签署<span>《服务协议》</span></a></li>
						<li><div></div> <a href="#">审核通过</a></li>
						<li><div></div> <a id="look">查看<span>《电子协议》</span></a></li>
						<li><div></div> <a href="#" class="btn">查看服务激活码</a></li>
						 -->
					</ul>
				</div>
			</div>
		</div>
	</div>


	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<script src="js/shenhe.js"></script>
	<script>
		$(function() {
			$("#look").click(function() {
				$.ajax({
					url : "/business/order/getPdfPath",
					type : "POST",
					success : function(data) {
						//	alert(data.agreement)
						data = JSON.parse(data);
	
						var url = "http://m.mbimc.com" + data.agreement;
						//	alert(url);
						window.open(url);
						location.reload(true);
					}
				})
			})
		})
	</script>

</body>
</html>