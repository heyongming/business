<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/index/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--添加视口 移动端适配-->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>历史</title>
    <!--引入第三方框架-->
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet/less" href="css/base.less"/>
    <link rel="stylesheet/less" href="css/history.less"/>
    <!--引入rem.js文件-->
    <script src="lib/rem/rem.js"></script>
    <!--引入less文件的js-->
    <script src="lib/less/less.js"></script>
    <script src="lib/less/less.min.js"></script>
</head>
<body>
<!--头部块开始-->
<header id="header">
    <a class="back" href="./buy.html"><img src="images/back.png" alt="返回"/></a>
    历史
    <a href="#" class="select"><img class="select" src="images/select.png" alt="选项卡"/></a>
</header>
<!--头部块结束-->

<section id="message">
    <div class="mes">
        <span class="left">短线产品-A</span>
        <span class="color">服务期：2017年6月19日-2017年8月20日</span>
    </div>
    <div id="nav">
        <a href="#" class="active">早评</a>
        <a href="#">午评</a>
        <a href="#">晚评</a>
    </div>
    <div class="news">
        <a href="#">
            <div class="left">
                <p>【8月20日】擦亮双眼，把
                    握精准买点，争做行情收
                    割机。</p>
                <p class="date">2017年8月20日</p>
            </div>
            <img src="images/news.png" alt=""/>
        </a>
    </div>
    <div class="news">
        <a href="#">
            <div class="left">
                <p>【8月20日】擦亮双眼，把
                    握精准买点，争做行情收
                    割机。</p>
                <p class="date">2017年8月20日</p>
            </div>
            <img src="images/news.png" alt=""/>
        </a>
    </div>
    <div class="news">
        <a href="#">
            <div class="left">
                <p>【8月20日】擦亮双眼，把
                    握精准买点，争做行情收
                    割机。</p>
                <p class="date">2017年8月20日</p>
            </div>
            <img src="images/news.png" alt=""/>
        </a>
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
<!--<script src="js/history.js"></script>-->
</body>
</html>