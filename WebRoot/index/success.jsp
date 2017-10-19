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
<title>审核通过</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/success.less" />
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
</head>
<body>
	<c:if test="${empty sessionScope.buyuser}">
		<script type="text/javascript">
			location.href = "/business/index/"
		</script>

	</c:if>
	<header id="header">
		<h2>审核通过</h2>
	</header>
	<section id="message">
		<h2>您已审核通过！</h2>
		<p>
			您的产品为:<span>${sessionScope.buyGoodsList.goodsName}</span>
		</p>
		<p>
			您的服务激活码为:<span>${requestScope.orderActivationCode.activationCode}</span>
		</p>
		<p>关注下方公众号，立即享受服务吧！</p>
		<div>
			<img class="erweima" src="images/erweima.png" alt="" />
		</div>
		<p class="font">
			<span>如何激活服务？</span>
		</p>
		<p>
			第一步：微信扫描二维码或搜索<span>“迈步投资”</span>或<span>“MBIMC888”</span>关注微信服务号。
		</p>
		<p>
			第二步：点击菜单右侧-<span>【我的】</span>-<span>【服务激活】</span>
		</p>
		<div>
			<img src="images/photo.png" alt="" />
		</div>
		<p>
			第三步：输入<span>【服务激活码】</span>，点击激活，收到激活成功 通知。
		</p>
		<div>
			<img src="images/photo.png" alt="" />
		</div>
		<p class="prompt">小提示：服务过程中，有任何问题可询问在线客服。</p>
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
	<!--<script src="js/success.js"></script>-->
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