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
    <title>留言列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css" />
    <link rel="stylesheet" href="css/liuyan.css" />
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
        <div class="layui-inline">
            <label class="layui-form-label">问题类型:</label>
            <div class="layui-input-inline">
                <input type="text" id="question" name="question" class="layui-input">
            </div>
            <button id="search" class="layui-btn">查询</button>
        </div>
    </blockquote>
    <!-- 弹窗 -->
    <div id="j_mask" class="mask"></div>
    <div id="j_formAdd" class="form-add">
        <form class="layui-form" id="formId" enctype="multipart/form-data">
            <div class="form-add-title">
                <span>留言内容</span>
                <div id="j_hideFormAdd">x</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">留言时间：</label>
                <div class="layui-input-block" id="time">

                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">客户：</label>
                <div class="layui-input-block" id="name">

                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">留言内容：</label>
                <div class="layui-input-block" id="con">

                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">留言图片：</label>
                <div class="layui-input-block" style="width: 300px">
                    <img src="../images/bake.png" style="width: 100%" id="img"/>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">问题类型：</label>
                <div class="layui-input-block" id="type">

                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机号：</label>
                <div class="layui-input-block" id="number">

                </div>
            </div>

        </form>
    </div>
    <fieldset class="layui-elem-field">
        <legend>留言列表</legend>
        <div class="layui-field-box layui-form">
            <table class="layui-table admin-table">
                <thead>
                <tr>
                    <th>ip</th>
                    <th>留言时间</th>
                    <th>客户</th>
                    <th>留言内容</th>
                    <th>留言图片</th>
                    <th>问题类型</th>
                    <th>手机号</th>
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
<script type="text/javascript" src="js/liuyan.js"></script>
<script>
    layui.use(['jquery','form'], function() {
        var form = layui.form,
                $=layui.jquery;
    });
</script>
</body>

</html>