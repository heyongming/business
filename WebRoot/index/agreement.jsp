<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en" id="htmlId">
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>服务协议</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/agreement.less" />
<style>
.spinner {
	width: 100%;
	height: 100%;
	position: fixed;
	z-index: 9999;
	background: rgba(233, 233, 233, 0.6);
	display: none;
}

.spinner .jiazai {
	position: absolute;
	width: 6rem;
	height: 6rem;
	left: 50%;
	top: 50%;
	margin-top: -3rem;
	margin-left: -3rem;
	background: url("images/jiazai.gif") no-repeat;
	background-position: center center;
	background-size: cover;
}
</style>

<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
<!--html转pdf-->
<script src="https://code.jquery.com/jquery-git.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
<script type="text/javascript">
	//禁止ios10缩放
	window.onload = function() {
		document.addEventListener('touchstart', function(event) {
			if (event.touches.length > 1) {
				event.preventDefault();
			}
		});
		var lastTouchEnd = 0;
		document.addEventListener('touchend', function(event) {
			var now = (new Date()).getTime();
			if (now - lastTouchEnd <= 300) {
				event.preventDefault();
			}
			lastTouchEnd = now;
		}, false)
	}
</script>
</head>
<body>

	<section class="spinner">
		<div class="jiazai"></div>
	</section>
	<header id="header">
		<h2>证券投资顾问服务协议</h2>
	</header>
	<section class="twoSides">
		<p>
			甲方：<span>${sessionScope.buyuser.userName}</span>
		<p>
			身份证号码：<span>${sessionScope.buyuser.phone}</span>
		<p>
			住址：<span>*******************（系统自动识别）</span>
		<p>乙方：上海迈步投资管理有限公司</p>
		<p>地址：上海市黄浦区淡水路277号SOHO复兴广场B楼B503室</p>
	</section>
	<section id="ceshi">
		<h2>风险测试评估结果</h2>
		<p>
			您的风险承受能力为：<span>${sessionScope.buyuser.grade}（系统自动评估）</span>
		</p>

	</section>
	<!--风险揭示书-->
	<section class="product">
		<h2 class="title">证券投资顾问业务风险揭示书</h2>
		<p>尊敬的投资者：</p>
		<p>为了使您充分了解证券投资顾问业务的风险，上海迈步投资管理顾问有限公司（以下称本公司）依据《证券投资顾问业务暂行规定》向投资者提供《证券投资顾问业务风险揭示书》，以便充分揭示证券投资顾问服务中所存在的风险或潜在风险。请您在接受本公司证券投资顾问服务前，认真阅读以下内容：</p>
		<p>一、在您接受证券投资顾问服务前，必须了解提供服务的机构是否具备证券投资咨询业务资格，提供服务的人员是否具备证券投资咨询执业资格并已经注册登记为证券投资顾问。本公司具有中国证监会颁发的证券投资咨询业务资格。有关信息可在中国证券业协会网站（www.sac.net.cn）查询确认。</p>
		<p>二、在您接受证券投资顾问服务前，须知本公司所开展的投资顾问服务业务仅限于以下业务范畴：接受您的委托，按照约定，向您提供涉及证券及证券相关产品的投资建议服务，辅助您做出投资决策，其中投资建议服务内容包括投资的品种选择、投资组合以及理财规划建议等。重点提醒：在您接受证券投资顾问服务后,需自主作出投资决策并独立承担投资风险。</p>
		<p>三、在您接受证券投资顾问服务前，须知本公司及其人员提供的证券投资顾问服务不能确保投资者获得盈利或本金不受损失。</p>
		<p>四、在您接受证券投资顾问服务前，须充分了解本公司及其人员提供的投资建议具有针对性和时效性的原则，其投资建议不能在任何市场环境下长期有效。</p>
		<p>五、在您接受证券投资顾问服务前，须充分了解本公司所提供的投资建议依据的证券研究报告和投资分析意见等，可能存在不准确、不全面或者被误读的风险，您有权向本公司任职的证券投资顾问了解证券研究报告的发布人和发布时间以及投资分析意见的来源，以便在进行投资决策时做出理性判断。</p>
		<p>六、在您接受证券投资顾问服务前，须充分了解本公司的服务收费标准和方式，按照公平、合理、自愿的原则与我公司协商并书面约定收取证券投资顾问服务费用等事宜。重点提醒：证券投资顾问服务费应向我公司账户支付，不得向证券投资顾问人员或其他个人账户支付。</p>
		<p>
			七、如您发现投资顾问存在违法违规行为或利益冲突情形，如泄露客户投资决策计划、传播虚假信息、进行关联交易等，您有权向本公司的投诉部门或向有关部门举报。投诉处理电话：<span
				class="color">021-63319055。</span>
		</p>
		<p>八、本公司可能存在因停业、解散、撤销、破产，或者被中国证监会撤销相关业务许可、责令停业整顿等原因导致不能履行职责的风险。</p>
		<p>九、本公司证券投资顾问人员存在因离职、离岗等原因导致更换证券投资顾问服务人员并影响服务连续性的风险。</p>
		<p>十、在您接受证券投资顾问服务前，需填写《投资者风险承受能力问卷》，如实说明自身资产与收入状况、投资经验、诚信状况、投资需求和风险偏好等情况并接受评估，以便于本公司根据您的风险承受能力和服务需求，向您提供适当的证券投资顾问产品及服务。如果因不提供信息或提供的信息不完整，导致本公司无法确定您的投资类别或风险承受能力等级，由此产生的后果由您自行承担。如果您提供的信息发生重大变化的，应当及时告知本公司，本公司将及时更新您的个人信息，并重新评估您的风险承受能力，如您未及时告知本公司，由此导致的风险将由您自行承担。</p>
		<p>十一、您需要向本公司提供有效的联系方式和服务获取方式，如有变动须及时进行说明，如因您自身原因或不可抗力因素导致您未能及时获取证券投资顾问服务，责任将由您自行承担。</p>
		<p>十二、在您接受证券投资顾问服务时，请保管好自己的证券账户、资金账户和相应的密码，不要委托本公司的任何人员管理您的证券账户、资金账户，代理买卖证券，否则由此导致的风险将由您自行承担。</p>
		<p>十三、本公司投资顾问服务内容将由约定渠道或方式送达投资者且仅供您参考，本公司未授权任何公司之外的其它机构或个人发布；证券投资顾问服务内容及形式版权仅为本公司所有，未经书面许可，任何机构和个人不得以任何形式翻版、复制和发布。如果您未按照本公司约定方式获取及使用信息，由此引起的法律及投资风险由您自行承担。</p>
		<p>十四、如果本公司以软件工具、终端设备等为载体，向您提供投资建议或者类似功能服务的，您在接受该软件工具、终端设备等服务前，必须仔细阅读相关说明书，了解其实际功能、信息来源、固有缺陷和使用风险，注意软件工具、终端设备等载体的自身风险，由于您自身原因导致该软件工具、终端设备等使用不当或受到病毒入侵、黑客攻击等第三方的过错及不可抗力导致不良影响的，由此导致的风险将由您自行承担。如果本公司以软件工具、终端设备等载体，向您提示买卖时机等类似功能服务的，您在接受该软件工具、终端设备等服务前，必须仔细阅其方法和局限。</p>
		<p>
			十五、本公司基本信息：<br /> 公司名称：上海迈步投资管理有限公司<br />
			证券投资咨询业务许可证号码：913101017064269274<br />
			公司注册地址：上海市黄浦区淡水路277号SOHO复兴广场B楼B503室<br /> 客户服务及咨询渠道：<span
				class="color">021-63319055</span><br /> 投诉受理渠道：<span class="color">021-63319055</span><br />
			公司网站：www.mbimc.com
		</p>
		<p>十六、本风险揭示书的揭示事项仅为列举性质，未能详尽列明您接受证券投资顾问服务所面临的全部风险和可能导致投资者投资损失的所有因素。</p>
		<p>您在接受本公司服务前，应认真阅读并理解相关业务规则、证券投资顾问服务协议及本风险揭示书的全部内容。</p>
		<p>关于接受证券投资顾问服务的您，自行承担投资风险，本公司不以任何方式向您做出不受损失或者取得最低收益的承诺。</p>
		<p>特别提示：您应签署本风险揭示书，表明您已经理解并愿意自行承担接受证券投资顾问服务的风险和损失。</p>
		<p>本人已认真阅读并理解相关业务规则，证券投资顾问服务协议及本风险揭示书的全部内容，并愿意自行承担相关的投资风险和损失。</p>
	</section>
	<!--服务协议-->
	<section class="product xieyi">
		<h2 class="title">资讯产品服务协议</h2>
		<p>阅读并点击“确认签署协议”表示您已经申请使用上海迈步投资管理有限公司（以下称上海迈步或产品服务方）提供的服务，并且接受本协议条款的约束，本协议即生效。请服务使用人（以下称“用户”）仔细阅读以下全部内容。</p>
		<h2 class="color">一、服务内容</h2>
		<p>1.1
			资讯产品服务是上海迈步提供的证券投资咨询服务，用户在支付相应费用后，可享受本平台提供的相应资讯产品服务。上海迈步提供不同档位的服务，具体服务内容、费用、以及服务期限应以本平台所展示的具体内容为准。</p>
		<p>1.2 服务期限届满后，您所购买的资讯产品服务即终止。</p>
		<p>1.3
			用户购买资讯产品服务后，非因质量问题，不得要求产品服务方退款，服务质量问题指因服务无法正常使用和正常查看并经产品服务方书面确认的技术故障。</p>
		<h2 class="color">二、声明与保证</h2>
		<h2 class="color">1.1 用户声明与保证：</h2>
		<p>（1）用户是拥有签订本协议并履行本协议义务所需的完全权利能力和完全行为能力的自然人。</p>
		<p>（2）用户承诺在进行证券投资之前已经对证券交易规则、证券交易惯例、证券交易知识、所投资的证券产品有了一定的了解，并完全知悉证券投资过程中可能蕴含的亏损风险与盈利机会，并已充分理解证券市场“买者自负”的含义，愿意遵守“买者自负”原则。</p>
		<p>（3）用户进行任何投资，包括其投资判断及决策，并不依赖于本平台展示的相关信息。</p>
		<p>（4）用户根据本平台所提供的所有信息数据以及观点、投资分析等资料操作而造成必然或偶然的损失，由用户自行承担。</p>
		<p>（5）用户已仔细阅读本协议条款，不存在重大误解情况；自本协议生效之日起，根据本协议中的条款和条件，本协议对用户合法有效并具有约束力和强制执行力。</p>
		<h2 class="color">1.2 产品服务方声明与保证：</h2>
		<p>（1）本平台提供的任何信息均仅供用户独立投资决策之参考。</p>
		<p>（2）上海迈步是根据中国法律依法设立并有效存续的公司，拥有法人资格。</p>
		<p>（3）上海迈步将在合法合规的基础上为用户提供服务。</p>
		<p>（4）自本协议生效之日起，根据本协议中的条款和条件，本协议对产品服务方合法有效并具有约束力和强制执行力。</p>
		<h2 class="color">三、知识产权</h2>
		<p>上海迈步提供的资讯产品服务内容的知识产权归上海迈步完全所有，用户购买资讯产品服务后，对本平台所提供的资讯产品服务仅限自身使用，用户不得对本公司及平台服务内容进行拷贝，复制，泄露，进行反向工程或销售给第三方使用，或以非自用为目的，以本平台资讯产品服务为基础进行开发或任何形式的盈利，否则上海迈步将追究用户法律责任及违约责任。</p>
		<h2 class="color">四、违约责任</h2>
		<p>4.1本协议当事人违反协议约定的，守约方有权要求违约方承担违约赔偿责任。</p>
		<p>4.2用户违反约定使用本平台资讯产品服务的，包括但不限于将资讯产品服务内容提供给第三方等行为的，服务方有权随时终止本协议并要求用户赔偿相应的损失。</p>
		<p>4.3由于不可抗力，依现有技术不可预料、不可克服的原因造成本平台系统不能运行导致的问题的，产品服务方不负责赔偿，但产品服务方有义务查找原因，尽量避免类似事件的发生。</p>
		<h2 class="color">五、其他</h2>
		<p>上海迈步有权在必要时修改本协议条款，您可以在本协议的最新版本中查阅相关协议条款。本协议条款变更后，如果您继续使用本平台相关资讯产品服务，即视为您已接受修改后的协议。</p>
		<div class="bottom">
			<label> <input type="radio" name="sex" value="1" />
				<div class="option"></div> <!--该div盛放的是优化后的按钮图片--> <span
				class="opt-text">以上风险测试评估结果、《风险揭示书》及《服务协议》所有内容本人已阅读并完全理解。一旦点击“确认签署协议”，即接受本协议约定的所有权利义务。</span>
			</label> <input type="button" id="btnbox" class="btnbox" onclick="msg()"
				value="确认签署协议">
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
	<!--引入自己写的首页js-->
	<script src="js/agreement.js"></script>
	<script type="text/javascript">
		/*先渲染页面数据*/
		$.ajax({
			url : "",
			success : function(data) {
				var tag = "";
				tag += '<p>甲方：<span>***（系统自动识别客户姓名）</span>' +
					'<p>身份证号码：<span>******************（系统自动识别）</span>' +
					'<p>住址：<span>*******************（系统自动识别）</span>' +
					'<p>乙方：上海迈步投资管理有限公司</p>' +
					'<p>地址：上海市黄浦区淡水路277号SOHO复兴广场B楼B503室</p>';
				$(".twoSides").html(tag);
	
				var mes = "";
				mes += '<p>第三十二条 服务费用： <span>贰万玖仟捌佰圆整</span></p>' +
					'<p>第三十三条 服务名称：<span>添禄模拟盘（基础版）</span></p>';
				$(".message").html(mes);
			}
		});
		/*点击提交*/
		function msg() {
			var html = $("#htmlId").html();
		
			var inputValue = $("input[type='radio']:checked").val();
			if (inputValue != 1) {
				alert("请签约");
			} else {
				$(".spinner").show();
				$.ajax({
					url : "/business/order/topdfFx",
					type : "post",
					data : {
						//	"htmlContent" : html
					},
					dataType : "json",
					success : function(data) {
						//alert(data.msg);
						$(".spinner").hide();
						console.log(data);
						location.href = '/business/order/success';
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						$(".spinner").hide();
						alert("出现未知错误，请与客服联系，为您造成的不便，敬请谅解" + "状态码" + XMLHttpRequest.status + "错误信息" + XMLHttpRequest.readyState)
	
					}
				});
			}
	
		}
	</script>
</body>
</html>