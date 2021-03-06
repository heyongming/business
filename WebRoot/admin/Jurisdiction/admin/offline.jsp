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
  <base href="<%=basePath%>">
    <title>线下购买</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css" />
    <link rel="stylesheet" href="css/offline.css" />
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
            position: fixed;
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
            <i class="layui-icon">&#xe608;</i> 线下购买信息录入
        </a>
    </blockquote>
    <!-- 弹窗 -->
    <div id="j_formAdd" class="form-add">
        <form class="layui-form" enctype="multipart/form-data" action="/">
        	<div class="layui-form-item">
				<label class="layui-form-label">推荐码：</label>
				<div class="layui-input-block">
					<input type="text" id="referralCode" name="referralCode"
						autocomplete="off" required  lay-verify="required" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">购买的产品：</label>
				<select name="product" id="product">
                    
                </select>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">购买数量：</label>
				<select name="number" id="number">
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
			<div class="layui-form-item">
				<label class="layui-form-label">支付金额：</label>
				<div class="layui-input-block">
					<input type="text" id="money" name="money"
						autocomplete="off" required  lay-verify="required|number" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
					<div class="layui-input-block">
						     <button class="layui-btn" lay-submit lay-filter="btn">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
           
        </form>
    </div>
    <fieldset class="layui-elem-field">
        <legend>线下购买数据列表</legend>
        <div class="layui-field-box layui-form">
            <table class="layui-table admin-table">
                <thead>
                <tr>
                    <th>用户id</th>
                    <th>用户名</th>
                    <th>订单编号</th>
                    <th>商品名称</th>
                    <th>日期</th>
                    <th>单价	</th>
                    <th>数量</th>
                    <th>总金额</th>
                    <th>激活码</th>
                    <th>交易状态</th>
               <!--      <th>操作</th> -->
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
<script type="text/javascript" src="js/offline.js"></script>
<script>

</script>
</body>

</html>