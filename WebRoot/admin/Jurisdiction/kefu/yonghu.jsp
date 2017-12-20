<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/kefu/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>用户接入列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css" />
    <link rel="stylesheet" href="css/yonghu.css" />
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

    </blockquote>
    <!-- 弹窗 -->
    <div id="j_formAdd" class="form-add">
        <form class="layui-form" id="formId" enctype="multipart/form-data">
     
                <ul id="liuyanUl">

                </ul>
        </form>
    </div>
    <fieldset class="layui-elem-field">
        <legend>用户接入列表</legend>
        <div class="layui-field-box layui-form">
            <table class="layui-table admin-table">
                <thead>
                <tr>
                    <th>ip</th>
                    <th>用户</th>
                   
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
<script type="text/javascript" src="js/yonghu.js"></script>
</body>

</html>