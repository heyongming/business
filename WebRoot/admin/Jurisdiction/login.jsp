<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
    <meta charset="utf-8">
    <title>合规客户资料提交</title>
    <!--引入第三方框架-->
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet/less" href="css/base.less"/>
    <link rel="stylesheet/less" href="css/login.less"/>
    <!--引入less文件的js-->
    <script src="lib/less/less.js"></script>
    <script src="lib/less/less.min.js"></script>
</head>
<body>
<div id="content">
    <div class="login">
        <h2>后台登录</h2>
        <form action="">
            <ul>
                <li>
                    <img src="images/login.png" alt=""/>
                    <input type="text" placeholder="请输入账号"/>
                </li>
                <li>
                    <img src="images/password.png" alt=""/>
                    <input type="text" placeholder="请输入您的密码"/>
                </li>
            </ul>
            <button type="submit">登录</button>
        </form>
    </div>
</div>


<!-- 以下是所用到的js -->
<!--引入jQuery bootstrape依赖jQuery-->
<script src="lib/jquery/jquery.js"></script>
<!--引入自己写的首页js-->
<!--<script src="js/login_pc.js"></script>-->
<script>

</script>
</body>
</html>