<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/redDot/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--添加视口 移动端适配-->
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>审核</title>
    <!--引入第三方框架-->
    <link rel="shortcut icon" href="mbimc.ico" />
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
        #header{
            height: 0.9rem;
            background-color: #393a3f;
        }
        #header h2{
            text-align: center;
            color:#fff;
            font-size: 0.4rem;
            line-height: 0.9rem;
        }
        #message div{
            margin-top: 2.4rem;
        }
        #message div{
            font-size: 0.3rem;
            color: #909090;
            text-align: center;
        }
        #message div img{
            width: 60%;
        }
    </style>
</head>
<body>
<header id="header">
    <h2>文章</h2>
</header>
<section id="message">
    <div>
        <img src="images/article.png" alt=""/>
        <p>文章不存在</p>
    </div>
</section>
<!-- 以下是所用到的js -->
<!--引入jQuery bootstrape依赖jQuery-->
<script src="lib/jquery/jquery.js"></script>
<!--引入zepto.js-->
<script src="lib/zepto-js/zepto.min.js"></script>
</body>
</html>