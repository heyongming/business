<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/login/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
<meta charset="utf-8">
<title>后台登录</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/login.css" />
</head>

<body>
	<div id="content">
		<div class="login">
			<h2>后台登录</h2>
			<form action="/business/salesman/login" method="post">
				<ul>
					<li><img src="images/login.png" alt="" /> <input type="text"
						placeholder="请输入账号" name="userId" /></li>
					<li><img src="images/password.png" alt="" /> <input
						type="text" placeholder="请输入您的密码" name="passWord" /></li>
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
		var userName = "${sessionScope.salesmanUser.userName}"
		if (userName.length > 0) {
			var type = "${sessionScope.salesmanUser.type}"
			if (type == "1") {
				window.location.href = "/business/admin/Jurisdiction/admin.jsp";
	
			} else if (type == "2") {
				window.location.href = "/business/admin/Jurisdiction/fuwu.jsp";
	
			} else if (type == "3") {
				window.location.href = "/business/admin/Jurisdiction/hegui.jsp";
	
			} else if (type == "4") {
				window.location.href = "/business/admin/Jurisdiction/xiaoshou.jsp";
	
			} else if (type == "5") {
				window.location.href = "/business/admin/Jurisdiction/main.jsp";
	
			}
	
		}
	</script>
</body>
</html>