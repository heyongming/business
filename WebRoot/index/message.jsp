<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/index/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <!--添加视口 移动端适配-->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>订单信息</title>
    <!--引入第三方框架-->
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet/less" href="css/base.less"/>
    <link rel="stylesheet/less" href="css/message.less"/>
    <!--引入rem.js文件-->
    <script src="lib/rem/rem.js"></script>
    <!--引入less文件的js-->
    <script src="lib/less/less.js"></script>
    <script src="lib/less/less.min.js"></script>
</head>
<body>

<!--订单信息-->
<section id="product">
    <img src="images/top_01.png" alt=""/>
    <div>
        <p>热门产品</p>
        <p class="price">￥5988</p>
    </div>
</section>
<section id="message">
    <p>真实姓名：张子玲</p>
    <p>手机号码：15014569876</p>
    <p>推&nbsp;&nbsp;荐&nbsp;&nbsp;码：1001</p>
    <p>订单编号：123456321654</p>
    <p>支付编号：123456321654</p>
</section>
<section id="process">
    <h2>服务审核流程</h2>
    <div class="bottom">
        <p></p>
        <ul>
            <li><div class="active"></div><a href="#">身份核验</a></li>
            <li><div></div><a href="agreement.html">签署<span>《服务协议》</span></a></li>
            <li><div></div><a href="#">审核通过</a></li>
            <li><div></div><a href="#">查看<span>《电子协议》</span></a></li>
            <li><div></div><a href="#">查看服务激活码</a></li>
        </ul>
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
</body>
</html>