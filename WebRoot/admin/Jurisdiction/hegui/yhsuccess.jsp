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
    <title>客户成交表详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css"/>
    <link rel="stylesheet" href="css/yhsuccess.css"/>
    <!--引入rem.js文件-->
    <script src="../lib/rem/rem.js"></script>
    <!--引入less文件的js-->
    <script src="../lib/less/less.js"></script>
    <script src="../lib/less/less.min.js"></script>
</head>
<body>
<div id="content">
    <form action="" id="form">
        <h2>客户成交表</h2>
        <table id="table1">
            <tr>
                <td>客户姓名</td>
                <td>xxxxxx</td>  <!--客户姓名-->
                <td>客户手机号</td>
                <td>xxxxxx</td><!--客户手机号-->
                <td>客户推荐码</td>
                <td>xxxxxx</td><!--客户推荐码-->
            </tr>
            <tr>
                <td>业务经理</td>
                <td>xxxxx</td><!--业务经理-->
                <td>业务员</td>
                <td colspan="3">xxxxxx</td><!--业务员-->
            </tr>
            <tr>
                <td>开单手机号</td>
                <td>xxxxxx</td><!--开单手机号-->
                <td>开单微信号</td>
                <td>xxxxxxxxx</td><!--开单微信号-->
                <td>开单日期</td>
                <td>xxxxxxxx</td><!--开单日期-->
            </tr>
            <tr>
                <td>产品名称</td>
                <td>xxxxx</td><!--产品名称-->
                <td>产品金额</td>
                <td>cccccccc</td><!--产品金额-->
                <td>付款方式</td>
                <td>ccc</td><!--付款方式-->
            </tr>
            <tr>
                <td>支付凭证</td>
                <td>
                    <div id="images">
                        <img src="images/logo.png" alt=""/>
                    </div>
                </td> <!--支付凭证图片-->
                <td>支付订单号</td>
                <td colspan="3">cccccccc</td><!--支付订单号-->
            </tr>
            <tr>
                <td>是否升级</td>
                <td>xxxx</td><!--是否升级-->
                <td>是否需要发票</td>
                <td colspan="3">xxxxxxx</td><!--是否需要发票-->
            </tr>
        </table>
    </form>
</div>
<script src="../lib/layui/layui.js"></script>
<!--引入颜色选择器-->
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../lib/jqueryColour/spectrum.js"></script>

</body>

</html>