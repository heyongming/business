<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/hegui/";
%>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title>客户信息列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css" />
    <link rel="stylesheet" href="css/yhliebiao.css" />
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
                <span>客户信息列表</span>
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
    <h2>客户信息列表</h2>
    <!-- 表格-->
    <table class="layui-table admin-table">
        <thead>
        <tr>
            <th>id</th>
            <th>客户姓名</th>
            <th>手机号</th>
            <th>业务员</th>
            <th>产品名称</th>
            <th>产品金额</th>
            <th>开单日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="content">
            <td>id</td>
            <td>客户姓名</td>
            <td>手机号</td>
            <td>业务员</td>
            <td>产品名称</td>
            <td>产品金额</td>
            <td>开单日期</td>
            <td><a href="#" class="layui-btn layui-btn-mini">查看</a><a href="#" class="layui-btn layui-btn-mini">删除</a></td>
        </tbody>
    </table>
</div>
<script src="../lib/jquery/jquery.js"></script>
<script src="../lib/layui/layui.js"></script>
<!--引入颜色选择器-->
<script src="../lib/template.js"></script>
<script type="text/javascript" src="js/yhliebiao.js"></script>
</body>
</html>