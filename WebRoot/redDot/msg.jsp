<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/redDot/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${RequestScope.msg.porTitle}</title>
</head>
<body>
	<c:if test="${empty RequestScope.msg } ">
		<script type="text/javascript">
			window.location.href = "/business/redDot/notFind.jsp"
		</script>
	</c:if>
	<div id="message">${RequestScope.msg.porCtent }</div>
</body>
</html>