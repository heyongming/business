
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/tianxiang/index1/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>牛股指标</title>
<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link href="images/tx.ico" rel="shortcut icon" type="image/x-icon">
<style type="text/css">
#cnzz_stat_icon_1261062232
{
 display: none;
}
</style>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cspan id='cnzz_stat_icon_1261062232'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/z_stat.php%3Fid%3D1261062232%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
</script>

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/showMsg.js"></script>
<script type="text/javascript" src="js/commit.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?e1ffb643c598c4840cb42ddfca2b4bb0";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

<script>
	(function(doc, win) {
		var docEl = doc.documentElement,
			resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
			recalc = function() {
				var clientWidth = docEl.clientWidth;
				if (!clientWidth) return;
				if (clientWidth >= 750) {
					docEl.style.fontSize = '100px';
				} else {
					docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
				}
				docEl.style.fontSize = 100 * (clientWidth / 750).toFixed(2) + 'px';

			};


		if (!doc.addEventListener) return;
		win.addEventListener(resizeEvt, recalc, false);
		doc.addEventListener('DOMContentLoaded', recalc, false);
	})(document, window);
</script>

</head>
<body style="font-size:16px">

	<div id="woeks" style="width: 100%;height: auto;overflow:auto;">
		<div id="pri_head">
			<div class="pri_head_input">
				<input type="text" name="pri_head_input" placeholder="请输入股票代码"
					class="pri_head_val" />
			</div>
			<div class="pri_head_btn">
				<button>&nbsp;&nbsp;&nbsp;获取诊股报告</button>
			</div>
		</div>
	</div>
	<div id="pri_foot">
		<div class="pri_foot_title">
			<span>诊断报告 </span><span class="pri_foot_title_say"><img
				src="images/left.png" /></span><span style="color: red">华友钴业</span>(603799)
		</div>
		<div class="pri_foot_body">
			<div class="pri_foot_body_item">
				概念题材:<span class="pri_foot_body_item_font">钴价上涨</span>
			</div>
			<div class="pri_foot_body_item">
				报告日期:<span class="pri_foot_body_item_font">2017年8月21日</span>
			</div>
			<div class="pri_foot_body_item">
				压力位:<span class="pri_foot_body_item_font">维持强势</span>
			</div>
			<div class="pri_foot_body_item">
				支撑位:<span class="pri_foot_body_item_font">60.36</span>
			</div>
			<div claass="pri_foot_body_image">
				<img src="images/k.png"a>
			</div>
			<div class="progress"
				style="height:auto;overflow: hidden; background-color:transparent ">
				<div class="pri_foot_body_item">
					财务情况:
					<div style="" class="pri_foot_body_loadPro">

						<div
							class="progress-bar progress-bar-info progress-bar-striped active"
							style="width: 80%; border-radius:0.2rem;">
							<div class="progress-value">80</div>

						</div>
					</div>

				</div>
				<div class="pri_foot_body_item">
					运营能力:
					<div style="" class="pri_foot_body_loadPro">

						<div
							class="progress-bar progress-bar-success progress-bar-striped active"
							style="width: 65%;border-radius:0.2rem;">
							<div class="progress-value">65</div>

						</div>
					</div>

				</div>
				<div class="pri_foot_body_item">
					市场人气:
					<div style="" class="pri_foot_body_loadPro">

						<div
							class="progress-bar progress-bar-warning progress-bar-striped active"
							style="width: 70%;border-radius:0.2rem;">
							<div class="progress-value">70</div>

						</div>
					</div>

				</div>
				<div class="pri_foot_body_item">
					主力资金:
					<div style="" class="pri_foot_body_loadPro">

						<div
							class="progress-bar progress-bar-danger progress-bar-striped active"
							style="width: 60%;border-radius:0.2rem;">
							<div class="progress-value">60</div>

						</div>
					</div>

				</div>


			</div>
			<div class="pri_foot_body_comprehensiveAnalysis">综合评估</div>
			<div class="pri_foot_body_comprehensiveAnalysis_details">
			 该公司运营状况良好，多数机构认为该股长期投资价值较高。近期的平均成本为63.49元，股价突破调整平台，维持强势走势。</div>
			<div class="pri_foot_body_Clinic">
				<button>我也要诊股</button>
			</div>
		</div>


	</div>
	<!--弹窗-->
	<div class="modal fade" id="informModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog" style="top:100px;position: relative;">
			<div class="modal-content" style="background-color:#00bfff;">
				<div class="informModal__logo">

					<button type="button" class="close" data-dismiss="modal"
						id="closeMsg" style="z-index: 9999999999">
						<span style="color:#ffffff; font-weight:700">X</span>
					</button>

				</div>

				<div class="modal-body" style="margin-top:20px; clear: both;">
					<div class="informModal__content">
						<div class="informModal__title">诊股结果</div>
						<div class="informModal__title_fu_title">你所查询的个股是:</div>
						<div class="informModal__title_answer"></div>
						<div class="informModal__detiles">诊股系统编写报告已完成，诊股报告将以短信的形式直接发送到您的手机，请注意查收！</div>
						<div class="informModal__input_phone">
							<input name="phone" type="text" placeholder="请输入手机号码" />
						</div>
						<div class="informModal__btn_phone">
							<button>立即诊股</button>
						</div>
						<div class="informModal__btn_Prompt">接收短信完全免费</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!---->
	<!--弹窗-->
	<div class="modal fade" id="clinicShares" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog" style="top:100px;position: relative;">
			<div class="modal-content" style="background-color:#00bfff;">
				<div class="informModal__logo">

					<button type="button" class="close" data-dismiss="modal"
						id="closeMsg" style="z-index: 9999999999">
						<span style="color:#ffffff; font-weight:700">X</span>
					</button>

				</div>

				<div class="modal-body" style="margin-top:20px; clear: both;">
					<div class="clinicShares__content">
						<div class="clinicShares__title">我要诊股</div>
						<div class="clinicShares__input_phone">
							<input name="phone" type="text" placeholder="请输入您要诊股的代码" />
						</div>
						<div class="clinicShares__btn_phone">
							<button>立即诊股</button>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<!---->
	<div class="modal fade" id="showMsg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog" style="top:200px;position: relative;">
			<div class="modal-content" style="background-color:#00bfff;">
				<div class="informModal__logo">

					<button type="button" class="close" data-dismiss="modal"
						id="closeMsg" style="z-index: 9999999999">
						<span style="color:#ffffff; font-weight:700">X</span>
					</button>

				</div>

				<div class="modal-body" style="margin-top:20px; clear: both;">
					<div class="showMsg__content">
						<div class="showMsg__title">提示</div>
						<div class="showMsg__log"></div>



					</div>
				</div>
			</div>
		</div>
	</div>
	<div
		style="position:fixed; top: 50%; left: 50%; display: none; z-index: 10000;margin-left:-50px;margin-top: -50px;"
		id="loadgif">

		<img alt="加载中..." width="50px" height="50px"
			src="images/loadAjax.gif " />

	</div>
</body>
</html>
