<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/fuwu/";
%>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>股票到价通知</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css" />
    <link rel="stylesheet" href="css/gupiao.css" />
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
            <i class="layui-icon">&#xe608;</i> 发布红点
        </a>
    </blockquote>
    <!-- 弹窗 -->
    <div id="j_mask" class="mask"></div>
    <div id="j_formAdd" class="form-add">
        <form class="layui-form" id="formId" enctype="multipart/form-data">
            <div class="form-add-title">
                <span>发布红点</span>
                <div id="j_hideFormAdd">x</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">红点标题：</label>
                <div class="layui-input-block">
                    <input type="text" id="redTitle"
                           name="redTitle" autocomplete="off" required
                           lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品：</label>
                <div class="layui-input-inline">
                    <select name="goodsId" id="goodsId" required
                            lay-verify="required" class="layui-input">
                        <option value="">请选择</option>
                      

                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">红点内容：</label>
                <div class="layui-input-block">
                    <script id="redContent" name="redContent" type="text/plain">

                    </script>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">股票代码：</label>
                <div class="layui-input-block">
                    <input type="text" id="gupiaoCode"
                           name="gupiaoCode" autocomplete="off" required
                           lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">股票名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="gupiaoName"
                           name="gupiaoName" autocomplete="off" required
                           lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">当前价：</label>
                <div class="layui-input-block">
                    <input type="text" id="nowPrice"
                           name="nowPrice" autocomplete="off" required
                           lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">预警价：</label>
                <div class="layui-input-block">
                    <input type="text" id="weiPrice"
                           name="weiPrice" autocomplete="off" required
                           lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">提醒时间</label>
                <div class="layui-input-block">
                    <input type="text" id="tiTime" class="layui-input"
                           name="tiTime" required lay-verify="date" placeholder="提醒时间">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">结束语：</label>
                <div class="layui-input-block">
                    <input type="text" id="endContent"
                           name="endContent" autocomplete="off" required
                           lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" id="btn">立即提交</button>
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
                    <th>红点ID</th>
                    <th>红点标题</th>
                    <th>商品名称</th>
                    <th>发送时间</th>
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
<!-- 配置文件 -->
<script type="text/javascript" src="../lib/uditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../lib/uditor/ueditor.all.js"></script>
<script type="text/javascript" src="../lib/uditor/ueditor.parse.js"></script>
<script type="text/javascript" src="js/gupiao.js"></script>
<script>
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        //当前日期
        laydate.render({
            elem : '#tiTime',
            type : 'datetime'
        });
    });
</script>
</body>

</html>