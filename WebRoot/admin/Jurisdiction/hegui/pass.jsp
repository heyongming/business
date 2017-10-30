<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/hegui/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>合规客户资料提交成功</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="../css/base.css" />
<link rel="stylesheet" href="css/pass.css" />
<!--引入rem.js文件-->
<script src="../lib/rem/rem.js"></script>
</head>
<body>
	<div id="message">
		<h2>合规客户资料提交</h2>
		<h3>提交成功!</h3>
		<p>
			客户姓名：<span>${requestScope.user.userName}</span>
		</p>
		<p>
			您的风险承受能力为：<span>${requestScope.user.grade}（系统自动评估）</span>
		</p>
		<p>
			评测时间：<span>${requestScope.user.createTime}</span>
		</p>
		<p>
			评测有效期：<span>2年</span>
		</p>
		<table>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
			</tr>
			<tr>
				<td class="res1"></td>
				<td class="res2"></td>
				<td class="res3"></td>
				<td class="res4"></td>
				<td class="res5"></td>
			</tr>
			<tr>
				<td>6</td>
				<td>7</td>
				<td>8</td>
				<td>9</td>
				<td>10</td>
			</tr>
			<tr>
				<td class="res6"></td>
				<td class="res7"></td>
				<td class="res8"></td>
				<td class="res9"></td>
				<td class="res10"></td>
			</tr>
			<tr>
				<td>11</td>
				<td>12</td>
				<td>13</td>
				<td>14</td>
				<td>15</td>
			</tr>
			<tr>
				<td class="res11"></td>
				<td class="res12"></td>
				<td class="res13"></td>
				<td class="res14"></td>
				<td class="res15"></td>
			</tr>
			<tr>
				<td>16</td>
				<td>17</td>
				<td>18</td>
				<td>19</td>
				<td>20</td>
			</tr>
			<tr>
				<td class="res16"></td>
				<td class="res17"></td>
				<td class="res18"></td>
				<td class="res19"></td>
				<td class="res20"></td>
			</tr>
		</table>
		<p>
			客户身份证：<span>${requestScope.user.idCard}</span>
		</p>
		<div class="img">
			<ul>
				<li><img src="images/photo.png" alt="" class="idCard1" /></li>
				<li><img src="images/photo.png" alt="" class="idCard2" /></li>
			</ul>
		</div>
		<p>
			客户推荐码：<span>${requestScope.user.rdCode}</span>
		</p>
	</div>
	<div id="product">
		<table>
			<thead>
				<tr>
					<th>购买产品名称</th>
					<th>查看协议</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${requestScope.serviceList}"
				varStatus="status">
				<tr>
					<td>${item.goodsList.goodsName}</td>
					<td><a href="${item.agreement}">查看协议</a></td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

	<script src="../lib/layui/layui.js"></script>
	<!--引入颜色选择器-->
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="../lib/jqueryColour/spectrum.js"></script>
	<script type='text/javascript' src='../lib/jqueryColour/docs/docs.js'></script>
	<script>
		var str = "${requestScope.user.answer}";
		str = "1=D,2=C,3=A,4=C,5=B,6=D,7=D,8=A E ,9=E,10=C,11=A E ,12=A,13=D,14=D,15=D,16=E,17=D,18=D,19=E,20=C";
		var regex = str.split(",");
	
		var log1 = regex[0];
		var res1 = log1.substr(2);
	
		var log2 = regex[1];
		var res2 = log2.substr(2)
	
		var log3 = regex[2];
		var res3 = log3.substr(2);
	
		var log4 = regex[3];
		var res4 = log4.substr(2);
	
		var log5 = regex[4];
		var res5 = log5.substr(2);
	
		var log6 = regex[5];
		var res6 = log6.substr(2)
	
		var log7 = regex[6];
		var res7 = log7.substr(2);
	
		var log8 = regex[7];
		var res8 = log8.substr(2);
	
		var log9 = regex[8];
		var res9 = log9.substr(2);
	
		var log10 = regex[9];
		var res10 = log10.substr(3);
	
		var log11 = regex[10];
		var res11 = log11.substr(3);
	
		var log12 = regex[11];
		var res12 = log12.substr(3);
	
		var log13 = regex[12];
		var res13 = log13.substr(3);
	
		var log14 = regex[13];
		var res14 = log14.substr(3);
	
		var log15 = regex[14];
		var res15 = log15.substr(3);
	
		var log16 = regex[15];
		var res16 = log16.substr(3);
	
		var log17 = regex[16];
		var res17 = log17.substr(3);
	
		var log18 = regex[17];
		var res18 = log18.substr(3);
	
		var log19 = regex[18];
		var res19 = log19.substr(3);
	
		var log20 = regex[19];
		var res20 = log20.substr(3);
	
	
		$(".res1").text(res1);
		$(".res2").text(res2);
		$(".res3").text(res3);
		$(".res4").text(res4);
		$(".res5").text(res5);
		$(".res6").text(res6);
		$(".res7").text(res7);
		$(".res8").text(res8);
		$(".res9").text(res9);
		$(".res10").text(res10);
		$(".res11").text(res11);
		$(".res12").text(res12);
		$(".res13").text(res13);
		$(".res14").text(res14);
		$(".res15").text(res15);
		$(".res16").text(res16);
		$(".res17").text(res17);
		$(".res18").text(res18);
		$(".res19").text(res19);
		$(".res20").text(res20);
		var path = "${requestScope.user.idImage}"
		path = path.substr(0, path.length - 1);
	
		var paths = path.split(",");
		$(".idCard1").attr("src", paths[0]);
		$(".idCard2").attr("src", paths[1]);
	</script>
</body>

</html>