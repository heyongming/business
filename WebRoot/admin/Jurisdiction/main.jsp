<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>控制面板</title>
    <link rel="stylesheet" href="./lib/layui/css/layui.css" media="all">
    <style>
        body{
            width: 100%;
            height: 100%;
            position: relative;
        }
        div{
            position: absolute;
            left: 50%;
            top: 50%;
            margin-top: 34px;
            margin-left: -327px;
        }
        p{
            font-size: 32px;
        }
    </style>
</head>
<body>
    <div>
        <img src="images/logo.png" alt=""/>
        <p>上海迈步投资管理有限公司后台管理系统</p>
    </div>
    <script src="./lib/layui/layui.js"></script>

</body>

</html>