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
    <title>已成交的交易</title>
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
    <h2>已成交的交易</h2>
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
            
        </tbody>
    </table>
</div>
<script src="../lib/jquery/jquery.js"></script>
<script src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="js/yhliebiao.js"></script>
</body>
</html>