<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/admin/";
%>
<html>
<head>
<meta charset="utf-8">
<title>商品升级管理</title>
<base href="<%=basePath%>">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="css/update.css" />
<!--引入rem.js文件-->
<script src="../lib/rem/rem.js"></script>
</head>
<body>

	<div class="layui-table">
		<h2>升级产品搭配</h2>
		<ul class="clearfix">
			<li><label>选择升级前产品：</label> <select id="titleBefore">

			</select></li>
			<li><label>选择升级后产品：</label> <select id="titleAfter">

			</select></li>
		</ul>
		<!--升级产品详情-->
		<ul>
			<li>
				<p>所选升级前产品详情</p>
				<table class="layui-table admin-table">
					<thead>
						<tr>
							<th>编号</th>
							<th>展示图</th>
							<th>商品名称</th>
							<th>商品分类</th>
							<th>排序</th>
							<th>定价</th>
							<th>库存</th>
							<th>销售量</th>
							<th>热门显示</th>
							<th>上下架</th>
							<th>购买上限</th>
							<th>购买下限</th>
							<th>服务期限</th>
							<th>是否混合</th>
						</tr>
					</thead>
					<tbody id="productBefore">
					
					</tbody>
				</table>
			</li>
			<li>
				<p>所选升级后产品详情</p>
				<table class="layui-table admin-table">
					<thead>
						<tr>
							<th>编号</th>
							<th>展示图</th>
							<th>商品名称</th>
							<th>商品分类</th>
							<th>排序</th>
							<th>定价</th>
							<th>库存</th>
							<th>销售量</th>
							<th>热门显示</th>
							<th>上下架</th>
								<th>购买上限</th>
							<th>购买下限</th>
							<th>服务期限</th>
							<th>是否混合</th>
						</tr>
					</thead>
					<tbody id="productAfter">
					
					</tbody>
				</table>
			</li>
		</ul>
	</div>
	<!---->
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn">确认</button>
		</div>
	</div>
	<div id="a"></div>
	</div>
	<script src="../lib/layui/layui.js"></script>
	<!--引入颜色选择器-->
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="js/update.js"></script>
</body>

</html>