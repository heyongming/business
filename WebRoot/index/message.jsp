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
<title>订单信息</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/message.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<script type="text/javascript">
	//禁止ios10缩放
	window.onload = function() {
		document.addEventListener('touchstart', function(event) {
			if (event.touches.length > 1) {
				event.preventDefault();
			}
		});
		var lastTouchEnd = 0;
		document.addEventListener('touchend', function(event) {
			var now = (new Date()).getTime();
			if (now - lastTouchEnd <= 300) {
				event.preventDefault();
			}
			lastTouchEnd = now;
		}, false)
	}
</script>
<style>
/* 查看电子协议*/
#smake {
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	top: 0;
	background-color: #fff;
	z-index: 999;
	display: none;
}

#smake .head {
	width: 100%;
	height: 0.5rem;
	background-color: #e8dada;
	position: relative;
}

#smake .head span {
	font-size: 0.5rem;
	position: absolute;
	right: 0.2rem;
	bottom: -0.1rem;
}

#smake iframe {
	width: 100%;
	height: 100%;
}

		#smakeAndriod{
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            background-color: rgba(0,0,0,0.2);
            z-index: 9999;
            display: none;
            text-align: center;
        }
        #smakeAndriod .con{
            width: 100%;
            height: 4rem;
            background-color: #fff;
            position: absolute;
            bottom: 0;
            left: 0;
        }
       #smakeAndriod .con p{
            margin: 0.3rem 0;
        }
        #smakeAndriod .con .head{
            width: 100%;
            height: 0.5rem;
            background-color: #e8dada;
            position: relative;
        }
        #smakeAndriod .con .head span{
            font-size: 0.5rem;
            position: absolute;
            right: 0.2rem;
            bottom: -0.1rem;
        }
       #smakeAndriod .con iframe{
            dispaly: "none";
        }
</style>
</head>
<body>
	<c:if test="${empty sessionScope.buyuser}">
		<script type="text/javascript">
			location.href = "business/index/"
		</script>

	</c:if>
	<header id="header">
		<h2>订单信息</h2>
	</header>
	<!--订单信息-->
	<section id="product">
		<img src="${sessionScope.buyGoodsList.imageUrl} " alt="" />
		<div>
			<p>${sessionScope.buyGoodsList.goodsName }</p>
			<p class="price">$
				${sessionScope.buyOrderResult.actualPurchasePriceGoods}</p>
		</div>
	</section>
	<section id="message">
		<p>真实姓名：${sessionScope.buyuser.userName }</p>
		<p>手机号码：${sessionScope.buyuser.phone }</p>
		<p>推&nbsp;&nbsp;荐&nbsp;&nbsp;码：${sessionScope.buyuser.rdCode }</p>
		<p>订单编号：${sessionScope.buyOrderResult.orderSerialNumber }</p>
		<p>支付编号：${sessionScope.buyOrderResult.orderSerialNumber }</p>
		${sessionScope.buyOrderResult.orderStatus}
	</section>
	<section id="process">
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
						<li><div></div> <a href="../index/agreement.jsp">签署<span>《服务协议》</span></a></li>
					</c:if>
					<c:if
						test="${(sessionScope.buyGoodsList.goodTypes[0].goodsTypeId) lt 4}">
						<li><div></div> <a href="../index/fengxian.jsp">签署<span>《服务协议》</span></a></li>
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
						<div></div> <a href="/business/order/success">查看服务激活码</a>
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

			</ul>
		</div>
	</section>
	<section id="smake">
		<div class="head">
			<span>×</span>
		</div>
		<iframe frameboder="0" class="pdfRanding" src=""></iframe>
	</section>
	<section id="smakeAndriod">
		<div class="con">
			<div class="head">
			<span>×</span>
		</div>
		<p>下载完成后，请在本地查看。</p>
		<iframe frameborder="0" class="pdfRanding" src=""></iframe>
		</div>
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
	<script src="js/message.js"></script>
	<script>
		$(function() {
			var ua = navigator.userAgent.toLowerCase();
			$("#look").click(function() {	
				$.ajax({
					url : "/business/order/getPdfPath",
					type : "POST",
					success : function(data) {
						alert(data.agreement)
						data = JSON.parse(data);
	
						$(".pdfRanding").attr("src", data.agreement);
					}
				})
				if (/android/.test(ua)) {
					$("#smakeAndriod").css("display", "block");
				}
				$("#smake").css( "display", "block");
			})
			$(".head span").click(function() {
				location.reload();
					$("#smakeAndriod").css("display", "none");
				$("#smake").css("display", "none");
			
			})
	
		})
	</script>
</body>
</html>