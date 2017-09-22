<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/admin/";
%>
<base href="<%=basePath%>">
<html>
<head>
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
.layui-form-label {
	padding: 6px 15px;
	width: 100px;
	text-align: center;
}

.layui-inline button {
	height: 33px;
	line-height: 33px;
	padding: 0 18px;
	background-color: #FF5722;
	color: #fff;
	white-space: nowrap;
	text-align: center;
	font-size: 16px;
	border: none;
	border-radius: 2px;
	cursor: pointer;
	opacity: .9;
}
</style>
</head>
<body>
	<div class="admin-main">
		<!--添加按钮-->
		<blockquote class="layui-elem-quote">
			<div class="layui-inline">
				<button id="whole">全部</button>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">订单号:</label>
				<div class="layui-input-inline">
					<input type="input" id="dingdan" name="dingdan" class="layui-input">
				</div>
				<button id="number">查询</button>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">用户名:</label>
				<div class="layui-input-inline">
					<input type="input" id="yonghu" name="yonghu" class="layui-input">
				</div>
				<button id="name">查询</button>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">下单时间:</label>
				<div class="layui-input-inline">
					<input type="text" id="xiadan" name="xiadan" lay-verify="date"
						placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
				</div>
				<button id="time">查询</button>
			</div>
		</blockquote>
		<fieldset class="layui-elem-field">
			<legend>数据列表</legend>
			<div class="layui-field-box layui-form">
				<table class="layui-table admin-table">
					<thead>
						<tr>
							<th>用户名</th>
							<th>商品编号</th>
							<th>订单编号</th>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>日期</th>
							<th>单价</th>
							<th>数量</th>
							<th>总金额</th>
							<th>激活码</th>
							<th>协议内容</th>
							<th>交易状态</th>

						</tr>
					</thead>
					<tbody id="content">
						<tr>
							<td>用户名</td>
							<td>商品编号</td>
							<td>编号</td>
							<td style="width: 45px; height: 30px"><img
								style="height: 30px" src="images/bake.png" alt="" /></td>
							<td>商品名称</td>
							<td>日期</td>
							<td>单价</td>
							<td>数量</td>
							<td>总金额</td>
							<td>激活码</td>
							<td>协议内容</td>
							<td>交易状态</td>

						</tr>
					</tbody>
				</table>
			</div>
			<div id="page" style="text-align: center"></div>
		</fieldset>
	</div>
	<script src="../lib/jquery/jquery.js"></script>
	<script src="../lib/layui/layui.js"></script>
	<script type="text/javascript" src="js/indent.js"></script>
	<!--预览图片-->
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;
	
			//日期
			laydate.render({
				elem : '#xiadan'
			});
	
		});
	</script>
	<script>
		function getFileContent() {
			/*1.创建文件读取对象*/
			var reader = new FileReader();
			/*2.读取文件，获取DataURL*/
			var file = document.querySelector("#imageUrl").files;
			reader.readAsDataURL(file[0]);
			/*获取数据*/
			reader.onload = function() {
				//console.log(reader.result);
				/*展示*/
				document.querySelector("img").src = reader.result;
			}
			reader.onprogress = function(e) {
				var percent = e.loaded / e.total * 100 + "%";
				div.style.width = percent;
			}
		}
	</script>
</body>

</html>