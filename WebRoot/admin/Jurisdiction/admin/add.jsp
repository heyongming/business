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
<title>添加商品</title>
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
						<select name="goodsTypeId" class="layui-input" id="goodsTypeId">
							<option value="资讯" selected="">资讯</option>
							
							<option value="模拟账户">模拟账户</option>
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
					<label class="layui-form-label">上下架：</label>
					<div class="layui-input-inline">
						<select name="isShelves" class="layui-input" id="isShelvesGoods">
							<option value="是" selected="">上架</option>
							<option value="否">下架</option>
						</select>
					</div>
				</div>
				   <div class="layui-form-item">
                    <label class="layui-form-label">购买上限：</label>
                    <div class="layui-input-inline">
                        <select name="maxMon" class="layui-input" id="maxMon">
                            <option value="1" selected="">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">购买下限：</label>
                    <div class="layui-input-inline">
                        <select name="minMon" class="layui-input" id="minMon">
                            <option value="0" selected="">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">服务期限：</label>
                    <div class="layui-input-inline">
                        <select name="effectiveTime" class="layui-input" id="effectiveTime">
                            <option value="1" selected="">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">是否混合：</label>
                    <div class="layui-input-inline">
                        <select name="isBlend" class="layui-input" id="isBlend">
                            <option value="是" selected="">是</option>
                            <option value="否">否</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
					<label class="layui-form-label">文章详情：</label>
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
							<th>编号</th>
							<th>展示图</th>
							<th>商品名称</th>
							<th>商品分类</th>
							<th>排序</th>
							<th>定价</th>
							<th>库存</th>
							<th>销售量</th>
							<th>上下架</th>
							<th>购买上限</th>
							<th>购买下限</th>
							<th>服务期限</th>
							<th>是否混合</th>
							<th>产品详情</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="content">

					</tbody>
				</table>
			</div>
		</fieldset>
	</div>
	<script src="../lib/jquery/jquery.js"></script>
	<script src="../lib/layui/layui.js"></script>
	<script src="../lib/bootstrap/js/bootstrap.js"></script>
	<!-- 配置文件 -->
	<script type="text/javascript" src="../lib/uditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="../lib/uditor/ueditor.all.js"></script>
	<script type="text/javascript" src="../lib/uditor/ueditor.parse.js"></script>
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