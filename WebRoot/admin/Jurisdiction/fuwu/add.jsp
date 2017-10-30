<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/fuwu/";
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
<link rel="stylesheet" href="css/add.css" />
<!--引入rem.js文件-->
<script src="../lib/rem/rem.js"></script>
<style>
textarea {
	display: block;
}
</style>
<style>
.spinner {
	width: 100%;
	height: 100%;
	line-height: 100%;
	text-align: center;
	position: absolute;
	z-index: 9999;
	background: rgba(233, 233, 233, 0.6);
	display: none;
}
</style>

</head>
<body>
	<div class="spinner">
		<img src="images/jiazai.gif" alt="" />
	</div>

	<div class="admin-main">
		<!--添加按钮-->
		<blockquote class="layui-elem-quote">
			<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
				<i class="layui-icon">&#xe608;</i> 添加信息
			</a>
		</blockquote>
		<!-- 弹窗 -->
		<div id="j_mask" class="mask"></div>
		<div id="j_formAdd" class="form-add">
			<form class="layui-form" id="formId" enctype="multipart/form-data">
				<div class="form-add-title">
					<span>添加文章</span>
					<div id="j_hideFormAdd">x</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">文章标题：</label>
					<div class="layui-input-block">
						<input type="text" id="serviceArticleTitle"
							name="serviceArticleTitle" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">缩略图：</label>
					<div class="layui-input-block fileImages">
						<input type="file" name="thumbnail" id="thumbnail"
							placeholder="上传缩略图"> <br>

					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品：</label>
					<div class="layui-input-inline">
						<select name="goodsId" id="goodsId" class="layui-input">

						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">服务板块：</label>
					<div class="layui-input-inline">
						<select name="serviceTypeId" id="serviceTypeId"
							class="layui-input">
							<option value="1" selected="">早报</option>
							<option value="2">中报</option>
							<option value="3">晚报</option>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">目标发送时间</label>
					<div class="layui-input-block">
						<input type="text" id="targetTime" class="layui-input"
							name="targetTime" required lay-verify="date" placeholder="目标发送时间">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">作者：</label>
					<div class="layui-input-block">
						<input type="text" id="author" name="author" required
							lay-verify="required" placeholder="作者" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">文章内容：</label>
					<div class="layui-input-block">
						<script id="articleContent" name="articleContent" required
							lay-verify="required" type="text/plain">

                    </script>
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
			<legend>数据列表</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table admin-table">
					<thead>
						<tr>
							<th>文章ID</th>
							<th>文章标题</th>
							<th>缩略图</th>
							<th>商品名称</th>
							<th>服务板块</th>
							<th>预计发送时间</th>
							<th>作者</th>
							<th>文章内容</th>
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
	<!-- 配置文件 -->
	<script type="text/javascript" src="../lib/uditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="../lib/uditor/ueditor.all.js"></script>
	<script type="text/javascript" src="../lib/uditor/ueditor.parse.js"></script>
	<script type="text/javascript" src="js/add.js"></script>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			//当前日期
			laydate.render({
				elem : '#targetTime',
				type : 'datetime'
			});
		});
	</script>
</body>

</html>