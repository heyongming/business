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
    <link rel="stylesheet" href="css/jihuo.css" />
</head>
<body>
<div id="content">
    <!--左上角logo-->
    <div class="logo">
        <img src="images/orderLogo.png" alt=""/>
    </div>
    <div class="jihuoContent">
        <h2 class="color">如何激活服务？</h2>
        <p>第一步：微信扫描二维码或搜索<span class="color">“迈步投资”</span>或<span class="color">“MBIMC888”</span>关注微信服务号。</p>
        <p>第二步：点击菜单右侧-<span class="color">【我的】</span>-<span class="color">【产品激活】</span></p>
        <ul>
                <li><img src="images/jihuo01.png" alt=""/></li>
                <li><img src="images/jihuo02.png" alt=""/></li>
        </ul>
        <p>第三步：输入<span class="color">【服务激活码】</span>，点击激活，收到激活成功通知。</p>
            <ul>
                <li><img src="images/jihuo03.png" alt=""/></li>
                <li><img src="images/jihuo04.png" alt=""/></li>
            </ul>
        <p class="color">小提示：服务过程中，有任何问题可询问在线客服。</p>
    </div>
</div>


<!-- 以下是所用到的js -->
<!--引入jQuery bootstrape依赖jQuery-->
<script src="lib/jquery/jquery.js"></script>
</body>
</html>