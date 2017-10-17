<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>

<!DOCTYPE html>
<html lang="en" id="htmlId">
<head>
<meta charset="utf-8">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>证券投资顾问业务风险揭示书</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet/less" href="css/fengxian.less" />
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
</head>
<body>

	<!--订单信息-->
	<section id="product">
		<h2 class="color">证券投资顾问业务风险揭示书</h2>
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
				class="color">**********。（投诉专线号码待定）</span>
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
				class="color">**********（客服专线号码待定）</span><br /> 投诉受理渠道：<span
				class="color">**********（投诉专线号码待定）</span><br /> 公司网站：vvvvv
		</p>
		<p>十六、本风险揭示书的揭示事项仅为列举性质，未能详尽列明您接受证券投资顾问服务所面临的全部风险和可能导致投资者投资损失的所有因素。</p>
		<p>您在接受本公司服务前，应认真阅读并理解相关业务规则、证券投资顾问服务协议及本风险揭示书的全部内容。</p>
		<p>关于接受证券投资顾问服务的您，自行承担投资风险，本公司不以任何方式向您做出不受损失或者取得最低收益的承诺。</p>
		<p>特别提示：您应签署本风险揭示书，表明您已经理解并愿意自行承担接受证券投资顾问服务的风险和损失。</p>
		<p>本人已认真阅读并理解相关业务规则，证券投资顾问服务协议及本风险揭示书的全部内容，并愿意自行承担相关的投资风险和损失。</p>
		<div class="bottom">
			<label> <input type="radio" name="sex" value="1" />
				<div class="option"></div>
				<!--该div盛放的是优化后的按钮图片--> <span class="opt-text">
					以上《风险揭示书》所有内容本人已阅读并完全理解。。</span>
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
		/*点击提交*/
		function msg() {
			var html = $("#htmlId").html();
			console.log(html);
			var inputValue = $("input[type='radio']:checked").val();
			if (inputValue != 1) {
				alert("请签约");
			} else {
				$.ajax({
					url : "/business/order/htmlToPdf",
					type : "post",
					data : {
						//     "htmlContent":html
					},
					dataType : "json",
					success : function(data) {
						//alert(data.msg);
						location.href = '../index/message.jsp'
					}
				});
			}
	
		}
	</script>
</body>
</html>