<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/mbimc/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>上海迈步投资管理有限公司官网</title>
<link rel="icon" type="image/x-icon" href="mbimc.ico" />
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/base.css" />
</head>
<body>
	<div id="fullpage">
		<div class="section first">
			<!--banner轮播按钮-->
			<div class="nav">
				<dl>
					<dd class=""></dd>
					<dd class=""></dd>
					<dd class=""></dd>
					<dd class=""></dd>
				</dl>
			</div>
			<!--轮播图-->
			<ul>
				<li class="banner1"><a href="#">
						<div class="banner_content">
							<div class="banner1-a">
								<img src="images/bannerContent1.png" alt="" />
							</div>
							<div class="banner1-b">
								<img src="images/bannerContent1_1.png" alt="" />
							</div>
							<div class="banner1-c">
								<img src="images/bannerContent1_2.png" alt="" />
							</div>
							<div class="logoMessage">
								<p>天禄，神话传说中的瑞兽。作为以 股票或金融为主的人，都希望自己 所买的股票可以暴涨或者所投资的 金融可以赚钱。</p>
							</div>
						</div>
				</a></li>
				<li class="banner2"><a href="#">
						<div class="banner_content">
							<div class="banner2-a">
								<img src="images/bannerContent2.png" alt="" width="100%" />
							</div>
						</div>
				</a></li>
				<li class="banner3"><a href="#">
						<div class="banner_content">
							<div class="banner3-a">
								<img src="images/bannerContent3.png" alt="" width="100%" />
							</div>
							<div class="banner3-b">
								<img src="images/bannerContent3_1.png" alt="" width="100%" />
							</div>
						</div>
				</a></li>
				<li class="banner4"><a href="#">
						<div class="banner_content">
							<div class="banner4-a">
								<img src="images/bannerContent4.png" alt="" width="100%" />
							</div>
							<div class="banner4-b">
								<img src="images/bannerContent4_1.png" alt="" width="100%" />
							</div>
						</div>
				</a></li>
			</ul>
		</div>
		<div class="section second">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<img src="images/wenhua.png" alt="" class="wenhua">
				<div class="gif">
					<div>
						<img src="images/img1.png" alt="" class="img1" /> <img
							src="images/img2.png" alt="" class="img2" /> <img
							src="images/img3.png" alt="" class="img3" /> <img
							src="images/img4.png" alt="" class="img4" /> <img
							src="images/img5.png" alt="" class="img5" /> <img
							src="images/img6.png" alt="" class="img6" />
					</div>
				</div>
				<p class="message">
					上海迈步投资管理有限公司，紧扣中国经济的兴盛脉搏与发展机遇，经过十九年的躬耕不止<br>
					现已领先地成为一家致力于金融创新与投资咨询的专业证券研究咨询机构。
				</p>
			</div>
		</div>
		<div class="section third">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<ul class="goodsList">
				<!-- 
					<li><img src="images/fuwu1.jpg" alt="" width="100%">
						<div class="message">
							<div class="left">
								<p>添禄涨停板</p>
								<p class="color">¥2999</p>
							</div>
							<div class="right btn">
								<a href="login.html" target="_blank">购买</a>
							</div>
						</div></li>
					<li><img src="images/fuwu2.jpg" alt="" width="100%">
						<div class="message">
							<div class="left">
								<p>添禄涨不停</p>
								<p class="color">¥6999</p>
							</div>
							<div class="right btn">
								<a href="login.html" target="_blank">购买</a>
							</div>
						</div></li>
					<li><img src="images/fuwu3.jpg" alt="" width="100%">
						<div class="message">
							<div class="left">
								<p>添禄跟投（基础版）</p>
								<p class="color">¥29999</p>
							</div>
							<div class="right btn">
								<a href="login.html" target="_blank">购买</a>
							</div>
						</div></li>
					<li><img src="images/fuwu4.jpg" alt="" width="100%">
						<div class="message">
							<div class="left">
								<p>添禄跟投（增强版）</p>
								<p class="color">¥39999</p>
							</div>
							<div class="right btn">
								<a href="login.html" target="_blank">购买</a>
							</div>
						</div></li>
						-->
				</ul>
			</div>
		</div>
		<div class="section fourth">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<div class="line"></div>
				<img src="images/time1.png" alt="" class="time1"> <img
					src="images/time2.png" alt="" class="time2"> <img
					src="images/time3.png" alt="" class="time3">
			</div>
		</div>
		<div class="section fifth">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<ul>
					<li><a href="http://live.mbimc.com/" target="_blank"><img
							src="images/video1.jpg" alt="" /></a></li>
					<li><a href="http://live.mbimc.com/" target="_blank"><img
							src="images/video2.jpg" alt="" /></a></li>
				</ul>
			</div>
		</div>
		<div class="section sixth">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<ul>
					<li><img src="images/yingye.png" alt="" />
						<p>营业执照</p></li>
					<li><img src="images/xuke.png" alt="" />
						<p>证券资质</p></li>
				</ul>
			</div>
		</div>
		<div class="section seven">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<ul>
					<li><a href="http://live.mbimc.com/"> <img
							src="images/zhanghu.png" alt="" />
					</a></li>
					<li>
						<p>公司名称：上海迈步投资管理有限公司</p>
						<p>开户银行：招商银行股份有限公司上海徐家汇支行</p>
						<p>账号：532902477610601</p>
					</li>
				</ul>

			</div>
		</div>
		<div class="section eight">
			<!--左上角logo-->
			<div class="logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="section_content">
				<ul>
					<li class="map"><img src="images/map.png" alt="" /></li>
					<li class="mes"><img src="images/phone.png" alt=""
						class="phone" /> <img src="images/address.png" alt=""
						class="address" /></li>

				</ul>
				<div class="footer">
					<p>
						投资有风险，入市需谨慎 <br /> 版权所有：上海迈步投资管理有限公司<br />
						地址：上海市黄浦区淡水路277号SOHO复兴广场B楼B503室<br /> 联系方式：021-63319005<br /> <a
							href="http://www.miibeian.gov.cn/" target="_blank">备案号：沪ICP备16017885号-1</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div></div>
	<!-- 右侧导航 -->
	<ul class="headul" id="headul">

		<li class="select" data-menuanchor="page1"><a href="#page1">
				<dl>
					<dt>HOME</dt>
					<div>公司首页</div>
				</dl>
		</a></li>
		<li data-menuanchor="page2"><a href="#page2">
				<dl>
					<dt>PROFILE</dt>
					<div>公司简介</div>
				</dl>
		</a></li>
		<li data-menuanchor="page3"><a href="#page3">
				<dl>
					<dt>PRODUCTS</dt>
					<div>服务产品</div>
				</dl>
		</a></li>
		<li data-menuanchor="page4"><a href="#page4">
				<dl>
					<dt>DRILL</dt>
					<div>实战演练</div>
				</dl>
		</a></li>
		<li data-menuanchor="page5"><a href="#page5">
				<dl>
					<dt>AUDITORIUM</dt>
					<div>名师讲堂</div>
				</dl>
		</a></li>
		<li data-menuanchor="page6"><a href="#page6">
				<dl>
					<dt>QUALIFICATION</dt>
					<div>公司资质</div>
				</dl>
		</a></li>
		<li data-menuanchor="page7"><a href="#page7">
				<dl>
					<dt>ACCOUNT</dt>
					<div>对公账户</div>
				</dl>
		</a></li>
		<li data-menuanchor="page8"><a href="#page8">
				<dl>
					<dt>ADDRESS</dt>
					<div>联系地址</div>
				</dl>
		</a></li>
	</ul>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.fullPage.min.js"></script>
	<script src="js/banner.js"></script>
	<script src="js/index.js"></script>
	
	<script>
		$(function() {
			$("#fullpage").fullpage({ //初始化
				anchors : [ 'page1', 'page2', 'page3', 'page4', 'page5', 'page6', 'page7', 'page8' ], //定义锚链接
				menu : '#headul', //导航
				afterLoad : function(anchorLink, index) {
					$(".section").removeClass("current");
					setTimeout(function() {
						//当滚动到某一个屏之后，添加样式标记
						$(".section").eq(index - 1).addClass("current");
					}, 500)
				}
			})
		});
	</script>
</body>
</html>