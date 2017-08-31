<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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
	<form action="http://localhost/business/salesman/addUser" method="post">
		<input name="userName" type="text" /> <input name="phone" type="text" />
		<input name="type" type="text" /> <input name="passWord" type="text" />
		<input type="submit" />
	</form>
	<br />
	<form action="http://localhost/business/salesman/delUser" method="post">
		<input name="userId" type="text" /> <input type="submit" />
	</form>
	<form action="http://localhost/business/salesman/login" method="post">
		<input name="userId" type="text" /> <input name="passWord"
			type="text" /> <input type="submit" />
	</form>
	<form action="http://localhost/business/salesman/queryUserByName"
		method="post">
		<input name="userName" type="text" /> <input type="submit" />
	</form>
	<form action="http://localhost/business/salesman/queryUserById"
		method="post">
		<input name="userId" type="text" /> <input type="submit" />
	</form>
	<form action="http://localhost/business/salesman/getUserAll"
		method="post">

		<input type="submit" />
	</form>
	<form action="http://localhost/business/goods/addGoods"
		enctype="multipart/form-data" method="post">
		金额:<input type="text" name="goodsPrice" /> 商品名:<input type="text"
			name="goodsName" /> 库存:<input type="text" name="inventory" /> 销量:<input
			type="text" name="salesVolume" /> 权重:<input type="text"
			name="weight" /> 类型:<input type="text" name="goodsTypeName" /> 文件:<input
			type="file" name="file"> <input type="submit" value="上传" />

	</form>
	<h1>修改</h1>
	<form action="http://localhost/business/goods/updateGoodsImage"
		enctype="multipart/form-data" method="post">
		id:<input type="text" name="goodsId" /> 金额:<input type="text"
			name="goodsPrice" /> 商品名:<input type="text" name="goodsName" /> 库存:<input
			type="text" name="inventory" /> 销量:<input type="text"
			name="salesVolume" /> 权重:<input type="text" name="weight" /> 类型:<input
			type="text" name="goodsTypeName" /> 文件:<input type="file"
			name="file"> <input type="submit" value="上传" />

	</form>
	<h1>修改类型</h1>
	<form action="http://localhost/business/goods/updateGoodsTypes"
		 method="post">
		id:<input type="text" name="goodsId" /> 类型:<input type="text"
			name="goodsTypeName" /> <input type="submit" value="上传" />

	</form>
		<h1>删除类型</h1>
	<form action="http://localhost/business/goods/delGoods"
		 method="post">
		id:<input type="text" name="goodsId" /> <input type="submit" value="上传" />

	</form>
		

	<s:debug></s:debug>
</body>
</html>
