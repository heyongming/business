<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/index/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>服务号</title>
<!--引入第三方框架-->
　<link rel="icon" href ="mbimc.ico" />
 <link rel="shortcut icon" href="mbimc.ico"  />

<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/news.less" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<style>
#btn i {
	display: inline-block;
	*display: inline;
	*zoom: 1;
}
</style>
</head>
<body>

	<section id="news">
		<h2>${requestScope.loginServiceArticle.serviceArticleTitle}</h2>
		<p class="jieshao">
			<span>${requestScope.loginServiceArticle.isOriginal}</span>&nbsp;&nbsp;${requestScope.loginServiceArticle.currentDate}&nbsp;&nbsp;
			${requestScope.loginServiceArticle.author}
		</p>
		<div id="message">

			${requestScope.loginServiceArticle.articleContent}</div>
		<div class="amount">
			<!-- 
			<span>阅读&nbsp;${requestScope.loginServiceArticle.readingNumber}</span>&nbsp;&nbsp;&nbsp;
			<span class="btn" id="btn"> <c:if
					test="${requestScope.isDoThumbsUp==0}">
					<img class="img1" src="images/n.png" />
					<span>${requestScope.loginServiceArticle.pointNumber}</span>
				</c:if> <c:if test="${requestScope.isDoThumbsUp==1}">
					<img class="img2" src="images/n.png" />
					<span>${requestScope.loginServiceArticle.pointNumber}</span>
				</c:if>

			</span>
			 -->
			<p href="#">
				写评论 <img src="images/pencil.png" alt="" />
			</p>
		</div>
	</section>

	<!--填写评论-->
	<section id="msgBox">

		<form id="form" class="clearfix">
			<h2>点击填写评论</h2>
			<div>
				<textarea id="conBox" class="f-text"></textarea>
			</div>
			<div class="tr">
				<p>
					<!--
                <span class="countTxt">还能输入</span><strong class="maxNum">140</strong><span>个字</span>
-->
					<input id="sendBtn" type="button" value="提交" title="快捷键 Ctrl+Enter" />
				</p>
			</div>
		</form>
		<div class="list">
			<h3>
				<span>评论详情</span>
			</h3>
			<ul id="ul">
				<c:forEach var="item" items="${requestScope.loginServiceArticleDetails}"
					varStatus="status">
					<li>
					<div class="userPic">
						<img src="${item.user.mpUserEntity.headimgurl}" />
					</div>
					<div class="content">
						<div class="userName">
							<a href="javascript:;">${item.user.mpUserEntity.nickname}</a>
						</div>
						<div class="msgInfo">${item.evaluateCent}</div>
						<div class="times">
							<span>${item.currentDate}</span>
						</div>
					</div>
				</li>
				</c:forEach>
			
			</ul>
		</div>
	</section>


	
	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<!--引入模板js-->
	<script src="lib/template.js"></script>
	<script>
		$(function() {
			//点赞功能
			var index=${requestScope.isDoThumbsUp};
			if(index==1)
			{	
			//评论功能
			/*点击填写评论，切换状态*/
			$(".amount p").click(function() {
				$("#msgBox #form").toggle();
			});
			/*点击提交*/
			$("#sendBtn").click(function() {
				var pinglunValue = $("#conBox").val();
				/*文本域为空，则报错*/
				if ($("#conBox").val().trim() === "") {
					alert("请输入内容");
					return;
				} else {
					$.ajax({
						url : "/business/mp/comment",
						type : "post",
						data : {
							"evaluateCent" : pinglunValue,
							'serviceArticleNum': ${requestScope.loginServiceArticle.serviceArticleNum}
						},
						success : function(data) {
							alert("提交成功");
							$("#form").hide();
						//判断一下后台是否让显示到页面上 暂时不用
						/* if(data.a==1){
						     var li = document.createElement("li");
						     var lis = $("#ul").children;
						     li.innerHTML = '<div class="userPic"><img src="images/face.gif" /></div><div class="content"><div class="userName"><a href="javascript:;">����</a></div><div class="msgInfo">�г��Դ������ര���ڣ��г��������ϵ������Խ����������ֽ׶εĽṹ�������У���ֵ���ơ�ҵ�����ơ����ߴ߻���Ŀǰ�����ʽ��ע��������</div><div class="times"><span>07��05�� 15:14</span></div></div>';
						     if (lis.length === 0) {
						         $("#ul").appendChild(li);
						     } else {
						         $("#ul").insertBefore(li, lis[0]);
						     }
						     /!*清空文本域*!/
						     $("#conBox").val() == "";
						 }*/
						}
					})
	
				}
	
			})
			return;
			}
			var textValue = parseInt($("#btn span").html());
			$("#btn").click(function() {
				$("#btn img").removeClass("img1").addClass("img2");
				$("#btn span").html(textValue + 1);
				$.ajax({
					url : "/business/mp/thumbsUp",
					type : "post",
					data : {
						
						'serviceArticleNum': ${requestScope.loginServiceArticle.serviceArticleNum},
						
					},	
					success : function(data) {}
				})
			})
	
			//评论功能
			/*点击填写评论，切换状态*/
			$(".amount p").click(function() {
				$("#msgBox #form").toggle();
			});
			/*点击提交*/
			$("#sendBtn").click(function() {
				var pinglunValue = $("#conBox").val();
				/*文本域为空，则报错*/
				if ($("#conBox").val().trim() === "") {
					alert("请输入内容");
					return;
				} else {
					$.ajax({
						url : "/business/mp/comment",
						type : "post",
						data : {
							"evaluateCent" : pinglunValue,
							'serviceArticleNum': ${requestScope.loginServiceArticle.serviceArticleNum}
						},
						success : function(data) {
							alert("提交成功");
							$("#form").hide();
						//判断一下后台是否让显示到页面上 暂时不用
						/* if(data.a==1){
						     var li = document.createElement("li");
						     var lis = $("#ul").children;
						     li.innerHTML = '<div class="userPic"><img src="images/face.gif" /></div><div class="content"><div class="userName"><a href="javascript:;">����</a></div><div class="msgInfo">�г��Դ������ര���ڣ��г��������ϵ������Խ����������ֽ׶εĽṹ�������У���ֵ���ơ�ҵ�����ơ����ߴ߻���Ŀǰ�����ʽ��ע��������</div><div class="times"><span>07��05�� 15:14</span></div></div>';
						     if (lis.length === 0) {
						         $("#ul").appendChild(li);
						     } else {
						         $("#ul").insertBefore(li, lis[0]);
						     }
						     /!*清空文本域*!/
						     $("#conBox").val() == "";
						 }*/
						}
					})
	
				}
	
			})
		})
	</script>

</body>
</html>