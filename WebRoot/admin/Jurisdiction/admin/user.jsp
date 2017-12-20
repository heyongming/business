<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/admin/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>账号管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="css/user.css" />
<!--引入rem.js文件-->
<script src="../lib/rem/rem.js"></script>
</head>
<body>
	<div class="admin-main">
		<!--添加按钮-->
		<blockquote class="layui-elem-quote">
			<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
				<i class="layui-icon">&#xe608;</i> 添加权限
			</a>
		</blockquote>
		<!-- 弹窗 -->
		<div id="j_formAdd" class="form-add">
			<form class="layui-form" id="formId" enctype="multipart/form-data">
			
				<div class="layui-form-item">
					<label class="layui-form-label">用户名：</label>
					<div class="layui-input-block">
						<input type="text" id="userName" name="userName" required
							lay-verify="aa|required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码：</label>
					<div class="layui-input-block">
						<input type="text" id="passWord" name="passWord" required
							lay-verify="aa|required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">权限：</label>
					<div class="layui-input-inline">
						<select name="quanXian" id="quanXian" class="layui-input">
							<option value="1" selected="">管理员</option>
							<option value="4">销售人员</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号：</label>
					<div class="layui-input-block">
						<input type="text" id="tel" name="tel" required
							lay-verify="aa|phone" autocomplete="off" class="layui-input">
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

		<fieldset class="layui-elem-field">
			<legend>管理列表</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table admin-table">
					<thead>
						<tr>
							<th>id</th>
							<th>用户名</th>
							<th>密码</th>
							<th>权限</th>
							<th>手机号</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="content">


					</tbody>
				</table>
			</div>
			<div id="page" style="text-align: center"></div>
		</fieldset>
	</div>
	<script src="../lib/jquery/jquery.js"></script>
	<script src="../lib/layui/layui.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>

</html>