<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script src="lib/jquery/jquery.js"></script>
</head>

<body>
	<div id="zhifu">支付</div>


	<script type="text/javascript">$(function() {
			$("#zhifu").click(function() {
				$.ajax(
					{
						url : "/business/mp/downOrder",
	
						dataType : 'json',
						success : function(data) {
	
							location.href = data.errMsg;
						}
					}
				)
			})
		})
	</script>
</body>
</html>
