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
    <title>添加用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css"/>
    <!--引入rem.js文件-->
    <script src="../lib/rem/rem.js"></script>
    <style>
        .select h2{
            text-align: center;
            font-size: 0.16rem;
            line-height: 0.4rem;
            font-weight: 400;
            color: #da251c;
        }
        .select p{
            font-size: 18px;
            line-height: 40px;
        }
        .admin-table thead th{
            text-align: center;
            font-size: 20px;
        }
        #lookMessage .title{
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<div class="layui-table">
    <form class="layui-form" action="">
        <div class="select">
            <h2>升级产品搭配详情</h2>
            <ul>
                <li>
                    <table class="layui-table admin-table">
                        <thead>
                        <tr>
                            <th colspan="2">升级前产品信息</th>
                            <th colspan="2">升级后产品信息</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="lookMessage">
                        <tr class="title">
                            <td>产品名称</td>
                            <td>商品价格</td>
                            <td>产品名称</td>
                            <td>商品价格</td>
                            <td>是否删除</td>
                        </tr>
                        
                        </tbody>
                    </table>
                </li>
            </ul>
        </div>
        <!---->
    </form>

</div>
<script src="../lib/layui/layui.js"></script>
<!--引入颜色选择器-->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<script type="text/javascript" src="js/look.js"></script>
</body>

</html>