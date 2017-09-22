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
</style>
</head>
<body>
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
			<form class="layui-form" enctype="multipart/form-data" action="/">
				<div class="form-add-title">
					<span>添加商品</span>
					<div id="j_hideFormAdd">x</div>
				</div>
				
				<div class="layui-form-item" style="display: none;">
					<label class="layui-form-label">商品编号：</label>
					<div class="layui-input-block">
						<input type="text" id="goodsId" name="goodsId" required
							lay-verify="aa|required" placeholder="输入商品名称" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				 
				<div class="layui-form-item">
					<label class="layui-form-label">展示图：</label>
					<div class="layui-input-block fileImages">
						<input type="file" name="imageUrl" id="imageUrl"
							placeholder="上传图像" onchange="getFileContent();"> <br>
						<img src="" alt="" id="imageUrlTemp">
						<div></div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称：</label>
					<div class="layui-input-block">
						<input type="text" id="goodsName" name="goodsName" required
							lay-verify="aa|required" placeholder="输入商品名称" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品分类：</label>
					<div class="layui-input-inline">
						<select name="goodsTypeId" class="layui-input">
							<option value="短线" selected="">短线</option>
							<option value="长线">长线</option>
							<option value="模拟对股">模拟对股</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">排序：</label>
					<div class="layui-input-block">
						<input type="text" id="weight" name="weight" required
							lay-verify="aa|required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">定价：</label>
					<div class="layui-input-block">
						<input type="text" id="goodsPrice" name="goodsPrice" required
							lay-verify="aa|required" placeholder="输入商品的价格" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">库存：</label>
					<div class="layui-input-block">
						<input type="text" id="inventory" name="inventory" required
							lay-verify="aa|required" placeholder="输入入库的数量" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">销售量：</label>
					<div class="layui-input-block">
						<input type="text" id="salesVolume" name="salesVolume" required
							lay-verify="aa|required" placeholder="查看前台的销售量"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">热门显示：</label>
					<div class="layui-input-inline">
						<select name="hotGoods" class="layui-input" id="selectbyGoods">
							<option value="是" selected="">是</option>
							<option value="否">否</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">上下架：</label>
					<div class="layui-input-inline">
						<select name="isShelves" class="layui-input" id="isShelvesGoods">
							<option value="是" selected="">上架</option>
							<option value="否">下架</option>
						</select>
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
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="content">

					</tbody>
				</table>
			</div>
		</fieldset>
	</div>
	<!--数据模板拼接-->
	<script type="text/html" id="tableTem">
    {{each result as value}}
    <tr>
        <td>{{value.goodsId}}</td>
        <td style="width: 45px; height: 30px"><img style="height: 30px" src="{{value.imageUrl}}" alt=""/></td>
        <td>{{value.goodsName}}</td>
        <td>{{value.goodsTypeId}}</td>
        <td>{{value.weight}}</td>
        <td>{{value.goodsPrice}}</td>
        <td>{{value.inventory}}</td>
        <td>{{value.salesVolume}}</td>
        <td>{{value.hotGoods}}</td>
        <td>{{value.isShelves}}</td>
        <td>
            <a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a>
            <a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a>
        </td>
    </tr>
    {{/each}}
</script>
	<script src="../lib/jquery/jquery.js"></script>
	<script src="../lib/layui/layui.js"></script>
	<script src="../lib/bootstrap/js/bootstrap.js"></script>
	<script src="../lib/template.js"></script>
	<!--引入颜色选择器-->
	<script src="../lib/template.js"></script>
	<script type="text/javascript" src="js/add.js"></script>
	<!--预览图片-->
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