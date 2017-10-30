<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/hegui/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>已添加客户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="css/audit.css" />
<!--引入rem.js文件-->
<script src="../lib/rem/rem.js"></script>
</head>
<body>
	<div id="message">
		<!-- 弹窗 -->
		<div id="x_mask"></div>
		<div id="x_formAdd">
			<form class="layui-form" id="formId" enctype="multipart/form-data">
				<div class="form-add-title">
					<span>修改客户信息</span>
					<div id="x_hideFormAdd">x</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">客户姓名：</label>
					<div class="layui-input-block">
						<input type="text" id="userName" name="userName"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">客户身份证：</label>
					<div class="layui-input-block">
						<input type="text" id="idCard" name="idCard" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" id="submit">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<h2>已添加客户</h2>
		<!-- 表格-->
		<table class="layui-table admin-table">
			<thead>
				<tr>
					<th>id</th>
					<th>姓名</th>
					<th>风险承受能力</th>
					<th>评测时间</th>
					<th>客户身份证</th>
					<th>推荐码</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="content">
			
			</tbody>
		</table>
	</div>
	<script src="../lib/jquery/jquery.js"></script>
	<script src="../lib/layui/layui.js"></script>
	<!--引入颜色选择器-->
	<script src="../lib/template.js"></script>
	<script type="text/javascript" src="js/audit.js"></script>
</body>
</html>