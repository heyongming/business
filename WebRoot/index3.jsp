<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index3.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="http://localhost/business/order/addOrderFrom" method="post">
	<p>	推荐码:<input  type="text" name="rdCode"/> </p>
	<p>	商品ID:<input  type="text" name="userId"/> </p>
	<p>	支付方式:<input  type="text" name="paymentMethod"/> </p>
	<p>	支付号码:<input  type="text" name="paymentNumber"/> </p>
	<p>	用户ID:<input  type="text" name="goodsId" /> </p>
	<p>发票消息:<input  type="text" name="invoiceInformation" /> </p>
	<p><input type="submit" value="上传" /></p>
		
	</form>
		<form action="http://localhost/business/order/saveOrderFrom" method="post">
	<p>	手机号:<input  type="text" name="phone"/> </p>
	<p>	流程:<input  type="text" name="orderStatus"/> </p>
	
	<p><input type="submit" value="上传" /></p>
		
	</form>
	<form action="http://localhost/business/order/getactivationCode" method="post">
		<p>	手机号:<input  type="text" name="phone"/> </p>
	<p><input type="submit" value="上传" /></p>
	</form>
</body>
</html>
