<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>联系客服</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="kefu/css/base.css" />
<link rel="stylesheet" href="kefu/css/kefu.css" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<header id="header">
		<h2>联系客服</h2>
	</header>
	<!--对话开始-->
	<section id="message">
		<p class="date"></p>
		<div class="moren">
			<ul>
				<li>
					<div class="left">
						<img src="images/logo.png" alt="" />
					</div>
					<div class="right">
						<div class="sanjiao"></div>
						<p id="jieru">
							<!--您好，请问有什么可以帮到您？-->
						</p>
					</div>
				</li>
				<li>
					<div class="left">
						<img src="images/logo.png" alt="" />
					</div>
					<div class="right">
						<div class="sanjiao"></div>
						<p>迈步猜您想了解：</p>
						<ul class="dhmes">

						</ul>
					</div>
				</li>
			</ul>
		</div>
		<!--<div class="question">
         <div class="left">
             <div class="sanjiao"></div>
             <p>您好，请问有什么可以帮到您？您好，请问有什么可以帮到您？您好，请问有什么可以帮到您？</p>
         </div>
         <div class="right">
             <img src="images/logo.png" alt=""/>
         </div>
    </div>-->
		<!--<div class="answer">
         <div class="left"><img src="images/logo.png" alt=""/></div>
         <div class="right">
             <div class="sanjiao"></div>
             <p>客服回答客服回答客服回答客服回答客服回答</p>
             <ul class="dhmes">
                 <li>咨询订单</li>
                 <li>咨询订单</li>
                 <li>咨询订单</li>
                 <li>咨询订单</li>
                 <li>咨询订单</li>
             </ul>
         </div>
    </div>-->
	</section>
	<!--底部-->
	<section id="footer">
		<!--机器人模式-->
		<div id="jiQi">
			<div class="person"></div>
			<div style="display: none" id="ip">
				<%!public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		//	System.out.println(ip);
		int indexOf = ip.indexOf(",");
		if (indexOf > 0) {
			return ip.substring(0, indexOf);
		}
		return ip;

	}%>
				<%=getIpAddr(request)%>
			</div>
			<form action="">
				<textarea name="text" autofocus="autofocus" id="text"></textarea>
			</form>
			<div class="add"></div>
			<button type="button" id="btn">发送</button>
			<ul class="addMes">
				<li class="evaluate">评价</li>
				<li class="words">留言</li>
			</ul>
		</div>
		<!--有用-->
		<div class="db">
			是否对您有帮助：<span class="y1"><em class="yy"></em>有用</span><span
				class="y2"><em class="not"></em>没用</span>
			<div id="dz">谢谢您的鼓励，我会再接再厉哦~</div>
		</div>
	</section>
	<!--问题弹窗-->
	<section id="mask">
		<div id="mask_bg"></div>
		<div id="mask_content">
			<div class="shut">×</div>
			<p>对不起没能解决您的问题，您的反馈能够帮助我们做的更好！</p>
			<button type="button" id="wordsBtn">留言</button>
		</div>
	</section>
	<script src="kefu/js/jquery.min.js"></script>
	<script src="lib/zepto-js/zepto.min.js"></script>
	<script src="lib/fastclick.js"></script>
	<script src="kefu/js/kefu.js"></script>
</body>
</html>