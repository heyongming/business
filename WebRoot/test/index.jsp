<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + request.getContextPath() + "/";//定位到根目录
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="test/js/jquery.js"></script>
<script type="text/javascript">
	var ws;
	var url = "ws://localhost/business/testws";
	function connect() {
		alert("准备连接");
		if ('WebSocket' in window) {
			alert("创建WebSocket连接");
			ws = new WebSocket(url);
		} else if ('MozWebSocket' in window) {
			alert("创建MozWebSocket连接");
			ws = new MozWebSocket(url);
		} else {
			alert('WebSocket is not supported by this browser.');
			return;
		}

		ws.onmessage = function(event) {
			console.log(event);
			$("#content").append(event.data + "<br/>");
		};

	}

	function send() {
		var value = $("#msg").val();
		ws.send(value);
	}
</script>
</head>
<body>

	<button onclick="connect();">connect</button>
	<hr />
	<input id="msg" />
	<button onclick="send();">send</button>
	<div id="content"
		style="border: 1px solid black; width: 200px; height: 300px;"></div>

</body>
</html>

