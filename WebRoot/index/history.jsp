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
<meta charset="utf-8">
<base href="<%=basePath%>">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>历史</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet" href="css/history.css" />
<style>
.spinner {
	width: 100%;
	height: 100%;
	position: absolute;
	z-index: 9999;
	background: rgba(233, 233, 233, 0.6);
	display: none;
}

.spinner .jiazai {
	position: absolute;
	width: 6rem;
	height: 6rem;
	left: 50%;
	top: 50%;
	margin-top: -3rem;
	margin-left: -3rem;
	background: url("images/jiazai.gif") no-repeat;
	background-position: center center;
	background-size: cover;
}

#noMessage {
	text-align: center;
	margin: 1rem 0;
	display: none;
}

#noMessage .logo {
	width: 3rem;
	margin-left: 2rem;
	margin-bottom: 0.6rem;
}

#noMessage .logo img {
	width: 100%;
}

#noMessage h2 {
	font-size: 0.5rem;
	color: #9d9d9d;
}
</style>

<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<section class="spinner">
		<div class="jiazai"></div>
	</section>

	<section id="message">
		<div class="wrap">
			<div class="wrap-main">
				<div class="top">
					<div class="prevSweek" onclick="previousWeek()"></div>
					<span id="showdate"></span> 
					<div class="nextSweek" onclick="nextWeek()"></div>
				</div>
				<table>
					<tr id="week">
						<td>一</td>
						<td>二</td>
						<td>三</td>
						<td>四</td>
						<td>五</td>
						<td>六</td>
						<td>日</td>
					</tr>
				</table>
				<table id="mytable">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
				<div class="newtime" style="display:none"></div>
				<div class="datetime" style="display:none">
					<input type="text">
				</div>
			</div>
		</div>

		<div class="news">
			<div id="mes"></div>
			<div id="noMessage">
				<div class="logo"><img src="images/logo.png" alt=""/></div>
				<h2>暂时还没有数据哦</h2>
			</div>
		</div>
	</section>

	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入自己写的首页js-->
	<script src="js/date.js"></script>
	<script src="js/history.js"></script>
</body>
</html>