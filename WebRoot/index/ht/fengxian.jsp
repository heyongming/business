<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/ht/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en" id="htmlId">
<head>
<meta charset="utf-8">
<!--添加视口 移动端适配-->
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>证券投资顾问业务风险揭示书</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/agreement.css" />



</head>
<body>
	
	<header id="header">
		<h2>证券投资顾问服务协议</h2>
	</header>
	<section class="twoSides">
		<p>
			甲方：<span>${sessionScope.buyuser.userName}</span>
		</p>
		<p>
			身份证号码：<span>${sessionScope.buyuser.idCard}</span>
		</p>
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
		<h2 class="title">证券投资顾问服务协议</h2>
		<p>依据《中华人民共和国证券法》、《中华人民共和国合同法》和《证券投资顾问业务暂行规定》等法律法规，以及中国证券业协会的有关自律规则的规定，甲乙双方本着公平、合理、自愿的原则，经友好协商，甲方按照乙方的要求如实进行风险承受能力评估，现就乙方向甲方提供证券投资顾问服务事宜，签订协议，内容如下：</p>
		<h2 class="color">第一章 服务内容与方式</h2>
		<p>第一条
			服务内容：乙方接受甲方委托，向甲方提供涉及证券及证券相关的投资建议服务，辅助甲方做出投资决策。投资建议服务内容包括投资参考、专业研究成果、理财规划建议、向甲方开展投资者教育活动，传播证券投资知识等；在本协议有效期内，乙方向甲方提供前述服务的一种或多种。</p>
		<p>第二条
			服务方式：乙方向甲方提供证券投资顾问服务的方式包括但不限于通过乙方官方认证的服务电话及短信平台、官方认证的移动终端及web页面提供服务。如乙方对服务方式有增加或变更，乙方通过短信平台及服务电话等官方途径予以告知。</p>
		<h2 class="color">第二章 双方权利与义务</h2>
		<p>第三条
			本协议服务期限内，甲方有权按照协议规定，享受乙方提供的咨询意见和投资建议服务。未经乙方同意，甲方不得转让其在本协议下的任何权利义务。</p>
		<p>第四条甲方应当全面、客观和及时地向乙方提供与服务有关的各种信息、文件、资料，并认真填写《投资者风险承受能力问卷》，并对所提供信息和资料的真实性、准确性和完整性负责。如果发生相应信息的变更，应及时通知乙方。甲方不得提供虚假信息或采取其他方式故意规避乙方的风险测评及适当性评估。如经乙方发现，有权按照本协议第五十条予以处理。</p>
		<p>甲方应向乙方提供有效的联系方式，如有变动须及时通过乙方指定途径进行变更，如因甲方自身原因或不可抗力因素导致其未能及时获取证券投资顾问服务，责任将由甲方自行承担。</p>
		<p>第五条 甲方有权决定是否采用乙方提供的咨询意见和投资建议。甲方基于独立判断，自行决定证券投资，承担相应的投资风险和损失。</p>
		<p>甲方应妥善保管证券账户、资金账户和对应的密码，不得委托乙方或者乙方的员工保管其账户，代理买卖证券。不得与乙方、乙方的员工另行签订证券投资收益保证、利益共享或者损失分担的协议或达成约定。</p>
		<p>第六条
			甲方应妥善保管乙方提供的投顾服务产品账号和密码，甲方因个人原因导致用户账号和密码泄露造成经济损失的，乙方不承担任何责任。</p>
		<p>第七条
			乙方享有所提供的证券投资顾问服务内容的所有权、知识产权及其他相关权利，未经乙方书面许可，甲方不得进行模仿、复制、传播、转发或提供给其他第三方。</p>
		<p>第八条
			乙方保留随时对投顾服务产品平台进行免费升级或变更的权利。乙方免费升级或变更后，应当及时告知甲方登陆方式及使用方式，不得影响甲方的正常使用。</p>
		<p>第九条 乙方应当遵循诚实信用原则，勤勉、审慎地为甲方提供证券投资顾问服务。</p>
		<p>第十条
			乙方应当根据甲方填写的《投资者风险承受能力问卷》的基础上，在评估甲方风险承受能力和风险类型，对其适合销售或者提供服务的投资者类型作出判断，向甲方提供适合购买的产品或者接受的服务并提供适当的投资建议服务。</p>
		<p>第十一条 乙方应按照本协议规定，向甲方提供证券投资顾问服务，辅助甲方做出投资决策。乙方向甲方提供的投资建议，仅供甲方参考。</p>
		<p>第十二条
			乙方由拥有投资顾问资质的投资顾问团队向甲方提供投资顾问服务。乙方投资顾问人员及投资咨询执业资格编码信息通过乙方网站进行公示，网址为www.mbimc.com。在服务提供过程中，向甲方提供投资顾问服务的投资顾问人员离职、离岗的，乙方应向甲方提供其他证券投资顾问人员进行服务，并保持投顾服务的持续性。</p>
		<p>第十三条 乙方有权根据本协议约定收取证券投资顾问服务费用。</p>
		<h2 class="color">第三章 禁止行为</h2>
		<p>第十四条
			乙方向甲方提供证券投资顾问服务，应当忠实甲方利益，不得为自身或者其他关联方的利益损害甲方利益；不得为乙方员工及其利益相关者的利益而损害甲方利益；不得为特定用户利益而损害其他客户利益。</p>
		<p>第十五条 乙方不得以虚假信息、市场传言或者内部信息为依据向甲方提供投资分析、预测或建议。</p>
		<p>第十六条
			乙方对因提供本协议规定的服务内容而知悉的甲方个人财产状况等其他个人资料负有保密义务，未经甲方事先书面许可，不得向第三方提供。但因监管机关要求、及乙方公司或关联公司内部使用及司法需要等原因除外。</p>
		<p>第十七条 乙方因向甲方提供投资建议，知悉甲方做出具体投资决策计划的，不得向第三方泄露甲方的投资决策计划信息。</p>
		<p>第十八条 乙方不得代理甲方进行证券买卖和操作，或者替甲方做出投资决策</p>
		<p>第十九条 乙方不得与甲方约定分享投资收益或分担损失，也不得以任何方式对甲方承诺或保证证券投资收益。</p>
		<p>第二十条 乙方应当以公司账户收取证券投资顾问服务费，禁止以个人名义向甲方收取证券投资顾问服务费用。</p>
		<h2 class="color">第四章 声明与保证</h2>
		<h2 class="color">甲方声明与保证：</h2>
		<p>第二十一条 甲方是拥有签订本协议并履行本协议义务所需的完全民事权利能力和完全民事行为能力的自然人。</p>
		<p>第二十二条
			甲方已仔细阅读并完全理解和认可乙方提交的有关证券及证券相关服务的《风险揭示书》、《免责声明》等文件，理解投资可能需要承担的风险并有相应的承担风险的能力。</p>
		<p>第二十三条
			甲方承诺在进行证券投资之前已经对证券交易规则、证券交易惯例、证券交易知识、所投资的证券服务有了一定的了解，并完全知悉证券投资过程中可能蕴含的亏损风险与盈利机会，并已充分理解证券市场“买者自负”的含义，愿意遵守“买者自负”原则。</p>
		<p>第二十四条 甲方进行任何投资，包括其投资判断及决策，并不依赖于乙方和/或其员工提供的建议、方案、报告或相关信息。</p>
		<p>第二十五条
			甲方向乙方提供的《投资者风险承受能力问卷》，及本人相关信息真实有效，甲方通过隐瞒、伪造、变造或其他手段向乙方提供虚假个人信息致使乙方对甲方做出错误的风险评级标准，由此导致的损失由甲方自行承担。</p>
		<p>第二十六条
			甲方有责任对委托服务事项及投资风险做出独立的判断、决策，甲方根据乙方证券投资顾问提供的建议、方案所做出的决定而导致的损失，由甲方自行承担。</p>
		<p>第二十七条
			甲方根据乙方证券投资顾问服务所提供的所有信息数据以及观点、投资建议、投资分析等资料操作而造成必然或偶然的损失，由甲方自行承担。</p>
		<p>第二十八条 甲方已仔细阅读本协议条款，不存在重大误解情况。</p>
		<h2 class="color">乙方声明与保证：</h2>
		<p>第二十九条 乙方是根据中国法律依法设立并有效存续的公司，拥有法人资格。</p>
		<p>第三十条 乙方拥有签订本协议并履行本协议义务所需的完全权利能力和完全行为能力及一切合法授权。</p>
		<h2 class="color">第五章 服务期限、类型、费用及支付方式：</h2>
		<p>第三十一条 服务期限：自乙方为甲方开通服务之日起开始计算。</p>
		<div class="message">
			<p>
				第三十二条 服务费用： <span>${sessionScope.buyOderForm.actualPurchasePriceGoods}</span>
			</p>
			<p>
				第三十三条 服务名称：<span>${sessionScope.buyGoodsList.goodsName}</span>
			</p>
		</div>
		<p>第三十四条
			甲方应该在本协议签订之日起3日内，向乙方一次性足额支付服务费用。费用支付到乙方指定账户。甲方在购买服务时，根据系统提示向乙方指定微信及支付宝官方认证收款账户或乙方官网（www.mbimc.com）的银行收款账户付款。</p>
		<h2 class="color">第六章 风险提示和免责条款</h2>
		<p>第三十五条
			乙方向甲方提供本协议项下的服务，有可能需要依赖网站、移动终端设备或其他终端为载体。甲方在使用乙方提供的服务前应仔细阅读该服务的相关说明，知悉并了解其实际功能、信息来源、固有缺陷和使用风险，由于甲方使用不当或受到病毒入侵、黑客攻击等不良影响的，由此导致的风险将由甲方自行承担。</p>
		<p>第三十六条
			乙方提供的证券投资品种：在乙方知情的范围内，乙方以及财产上的利害关系人与所评价的证券没有任何利害关系。由于证券技术分析本身固有的局限性，提示会随时间和股票价格变动而动态更新，不构成任何投资和股票买卖的建议或依据，甲方据此操作，风险自担。</p>
		<p>第三十七条 甲方应综合考虑投资风险并进行风险控制，由于甲方忽略风险控制而造成的任何损失，乙方不承担任何经济和法律责任。</p>
		<p>乙方尽力提供完整、及时、准确的信息，但不对所提供的信息的完整性、及时性、准确性承担任何责任。</p>
		<p>第三十八条 乙方全力保障信息的优质传输，但不对因非乙方原因造成的信息异常或信息传递异常情况所致后果承担任何责任。</p>
		<p>第三十九条
			乙方仅通过约定渠道向甲方提供服务，推送信息，提供投资建议，除乙方官方通知变更外，乙方未授权任何其它机构或个人发布服务内容，乙方不会通过短信、微信等方式向投资者发送推荐股票、建议购买等营销性质内容。同时，乙方通过通讯平台、软件平台发送甲方的通知和短信会注明出处。甲方在收到信息后进行操作前应当仔细核查，如甲方对信息真实性怀疑，请及时与乙方联系核实。如在非因乙方发送的通知及短信进行操作造成甲方损失，乙方不承担赔偿责任。</p>
		<p>第四十条
			因发生不可抗力、政策法规规定、监管机构等政府机关要求、通信链路中断、黑客攻击、网络中断、病毒侵害、信息源异常等非乙方原因导致乙方无法向甲方提供证券投资顾问服务或证券投资顾问服务内容发生遗漏、错误、丢失、延迟、中断等情形的，乙方不对此向甲方承担任何责任。</p>
		<p>第四十一条
			甲方深刻理解证券投资的风险，充分认识到乙方提供的证券投资顾问服务仅供甲方参考使用，不构成甲方进行投资决策的依据，甲方如采纳乙方服务内容作为投资决策依据，属于甲方自主选择，乙方不承担任何经济和法律责任。</p>
		<p>第四十二条
			乙方工作人员不得以书面或者口头等形式向甲方出具本协议以外的服务内容，如甲方发现乙方工作人员有此类情况发生，甲方拥有向乙方告知的义务。如乙方工作人员与甲方私自签订任何形式的协议，乙方不承担任何责任，并保留对其追究责任的权利。</p>
		<p></p>
		<p></p>
		<h2 class="color">第七章 保密原则：</h2>
		<p>第四十三条
			一方（“接收方”）同意对其履行本协议过程中所知悉的有关另一方（“披露方”）的保密信息（“秘密信息”）严守秘密。除非为履行本协议项下的工作，接收方不得使用秘密信息；未经披露方或有关秘密信息的权利人的同意或根据有关法律、法规的规定，不得将秘密信息透露给其他任何第三方。</p>
		<p>第四十四条
			以下信息不属于保密信息：1）有书面证据表明接收方先前已知悉的任何信息；2）非因接收方的过错而进入公共领域或为公众所知晓的信息；3）或接收方其后从其他途径合法获得的信息。</p>
		<p>第四十五条
			乙方可将秘密信息透露给其相关的雇员或其所聘请的专业人士，但乙方应确保上述人员亦应受本协议的约束，使保密信息处于保密状态，并仅为本协议履行之目的使用该等保密信息。</p>
		<h2 class="color">第八章 违约责任：</h2>
		<p>第四十六条 甲方无任何正当理由不支付服务费，乙方有权要求甲方支付未付的服务费以及延期支付的利息。</p>
		<p>第四十七条
			如果乙方有证据证明，甲方违反了本协议第七条规定，乙方有权利终止本协议。乙方向甲方发出书面通知书后，协议终止且乙方无需向甲方退还任何费用。</p>
		<p>第四十八条
			甲方同意保障和维护乙方及其他客户的利益，依法行使权利，如因甲方违反有关法律、法规或合同约定给乙方造成损失，甲方必须承担由此造成的损害赔偿责任。</p>
		<h2 class="color">第九章协议变更、终止：</h2>
		<p>第四十九条
			自本协议生效之日起５个工作日内，甲方可以以书面通知方式提出解除本协议，乙方收到解除协议书面通知时，本协议解除，并全部退还已经支付的服务费。协议生效后20日内（不含本数），甲方书面通知方式提出解除本协议的，甲乙双方进行协商，经乙方判断甲方确有可退款情形的，乙方可以酌情退还部分款项；协议生效20日后（含本数）以上甲方无正当理由提出解除协议或无解除协议书面通知的，视为执行本协议，乙方不接受解除协议或退款。</p>
		<p>第五十条
			甲方有下列情形之一的，乙方有权解除本协议：（1）甲方逾期30日仍不向乙方支付服务费的。（2）甲方有捏造事实或者隐瞒重要情节等情形，致使乙方证券投资顾问不能依法提供有效的服务的。因甲方原因导致协议解除及提前终止的，因提供证券投资咨询服务所必要的传输出设备及其他相关费用与已缴税费由甲方负担，乙方将从退还的咨询报酬中扣减或向甲方请求给付。</p>
		<p>第五十一条
			本协议签署后，若有关法律法规、行业自律规则修订，本协议与之不相适应的内容或条款自动失效，相关内容及条款按新修订的法律法规、行业自律规则办理。但本协议其他内容及条款继续有效。</p>
		<p>第五十二条
			如根据新生效的法律法规、行业自律规则，需要修改或增补本协议的，调整后的内容自动成为协议的有效组成部分。协议未变更的部分效力不变。</p>
		<h2 class="color">第十章 适用法律与争议解决：</h2>
		<p>第五十三条 适用法律：与本协议之订立、解释、履行、争议解决等一切相关事宜，均适用中华人民共和国有关法律、法规及规章。</p>
		<p>第五十四条
			争议解决：因本协议的解释、履行、违约、终止和效力引起的或与之有关的任何争议及主张，应通过友好协商加以解决。发生争议时，一方有权提请大连证券期货仲裁中心按照该中心调解规则进行调解。如果争议双方在30天内仍不能通过调解解决争议，则协议任一方有权向大连仲裁委员会申请仲裁，仲裁地：上海。该会按照申请仲裁时现行有效的仲裁规则进行仲裁，仲裁结果是终局，对协议双方均具有法律约束力。</p>
		<h2 class="color">第十一章 通知和送达：</h2>
		<p>第五十五条 甲乙双方证券投资顾问服务中通知与送达根据以下约定进行</p>
		<p>1、甲方承诺在乙方留存的联络方式的真实、有效、畅通，联络方式变更时应及时以书面方式通知乙方，乙方收到甲方通知的时间视为送达时间。甲方未书面通知乙方的，乙方以甲方原留存的联络方式为准。因甲方未及时将变更结果通知乙方所产生的一切责任由甲方承担。</p>
		<p>2、乙方通知的方式</p>
		<p>甲方同意并接受乙方有权根据本协议所载的甲方联络方式采用下列任意一种或几种通知方式对甲方发出本协议所载的各种通知</p>
		<p>（1）电子邮件通知</p>
		<p>（2）录音电话通知</p>
		<p>（3）传真通知</p>
		<p>（4）手机短信通知</p>
		<p>（5）邮寄方式通知</p>
		<p>3、甲方承诺只要乙方通过以上任何一种方式向甲方发送了通知均视为乙方履行了本协议约定的通知义务。如果非因乙方原因使得甲方未能收到上述通知，由此造成的后果及损失均由甲方承担乙方不承担任何责任。</p>
		<p>4、通知的送达时间</p>
		<p>（1）以电子邮件方式、传真、手机短信通知的，以接收方收到电子邮件、传真、手机短信的时间为送达时间。</p>
		<p>（2）以录音电话方式通知的以通话当时视为已经送达。</p>
		<p>（3）以邮寄方式通知的以邮戳显示送达时间为准。</p>
		<h2 class="color">第十二章 附则：</h2>
		<p>第五十六条
			本协议附件和本协议具有同等法律效力。一方或双方此前就本协议有关事项以口头或书面形式形成的相同性质的许诺、承诺、声明、建议、意见、保证、安排、草案、协议、谅解、备忘录等，凡与本协议有冲突之处，均以本协议约定为准。未经本协议双方一致通过电子签名方式或其他形式书面同意，本协议条款不得变更。</p>
		<p>第五十七条 本协议自双方签字盖章之日起生效，有效期自乙方为甲方开通服务之日起开始计算，到服务截止之日终止。</p>
		<p>第五十八条 本协议一式贰份，甲乙双方各持壹份。</p>
		<p>
			客户服务及咨询渠道：<span>021-63319055</span>
		</p>
		<p>
			投诉受理渠道：<span>021-63319055</span>
		</p>
	</section>



	
</body>
</html>