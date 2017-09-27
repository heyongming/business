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
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>迈步官网首页</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/index.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<!--导航块开始-->
	<nav id="nav">
		<a href="#" class="active">热门</a>

	</nav>
	<!--导航块结束-->

	<!--产品块开始-->
	<section id="product">
		

	</section>
	<!--产品块结束-->

	<!--模板渲染-->
	<!--导航块模板拼接-->
	<!--<script type="text/html" id="navTem">
    <ul>
        {{each result as value}}
        <a href="#" data-titleid="{{value.titleId}}">{{value.title}}</a>
        {{/each}}
    </ul>
</script>
&lt;!&ndash;产品块模板拼接&ndash;&gt;
<script type="text/html" id="productTem">
    {{each result as value}}
    <img class="productImages" src="images/image01.png" alt="产品图"/>
    <div class="product">
        <div class="left">
            <p>{{value.text}}</p>
            <p class="price">{{value.price}}</p>
        </div>
        <div class="right">购买</div>
    </div>
    <p class="title">{{value.main}}</p>
    <img class="productImages" src="images/image01.png" alt="产品图"/>
    <div class="product">
        <div class="left">
            <p>{{value.text}}</p>
            <p class="price">{{value.price}}</p>
        </div>
        <div class="right">购买</div>
    </div>
    {{/each}}
</script>-->

	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入模板js-->
	<script src="lib/template.js"></script>
	<!--引入自己写的首页js-->
	<script src="js/index.js"></script>
</body>
</html>