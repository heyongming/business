<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/user/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!--添加视口 移动端适配-->
<base href="<%=basePath%>">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>推广页</title>
<!--引入第三方框架-->
<link rel="stylesheet" href="lib/layui/css/layui.css" media="all">
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css" />
<!--引入自己的less,自己写的css-->
<link rel="stylesheet/less" href="css/base.less" />
<link rel="stylesheet" href="css/index.css" />
<!--引入rem.js文件-->
<script src="lib/rem/rem.js"></script>
<!--引入less文件的js-->
<script src="lib/less/less.js"></script>
<script src="lib/less/less.min.js"></script>
</head>
<body>
	<div class="layui-table">
		<form class="layui-form" action="" enctype="multipart/form-data">
			<h3>合规客户资料提交</h3>
			<div class="layui-form-item">
				<label class="layui-form-label">客户姓名：</label>
				<div class="layui-input-block">
					<input type="text" id="userName" name="userName" required
						lay-verify="aa|required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" pane="">
				<label class="layui-form-label">性别：</label>
				<div class="layui-input-block">
					<input type="radio" name="type" value="男" title="男" checked="">
					<input type="radio" name="type" value="女" title="女">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">住址：</label>
				<div class="layui-input-block">
					<input type="text" id="addRess" name="addRess" required
						lay-verify="aa|required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证号：</label>
				<div class="layui-input-block">
					<input type="text" id="idCard" name="idCard" required
						lay-verify="aa|required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">推荐码：</label>
				<div class="layui-input-block">
					<input type="text" id="rdCard" name="rdCard" required
						lay-verify="aa|required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!--上传照片-->
			<div class="upload">
				<h3>身份核验</h3>
				<!--    <div class="layui-upload">
            <button type="button" class="layui-btn" id="test2">上传身份证正反面</button>
            <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
                预览图：
                <div class="layui-upload-list" id="demo2">
                </div>
            </blockquote>
        </div>
         -->
				身份证正面: <input type="file" name="file" class="file" /> 身份证反面: <input
					type="file" name="file" class="file1" />

			</div>

			<div class="select">
				<h2>投资者风险承受能力问卷</h2>
				<p>本问卷旨在了解客户可承受的风险程度等情况，借此协助客户选择合适的产品或服务类别，以符合客户的风险承受能力。</p>
				<p class="tit">一、财务状况</p>
				<div class="layui-form-item" pane="">
					<p>1、客户的主要收入来源是：</p>
					<div class="layui-input-block">
						<input type="radio" name="one" value="A" title="A、工资、劳务报酬"
							checked=""><br /> <input type="radio" name="one"
							value="B" title="B、生产经营所得"><br /> <input type="radio"
							name="one" value="C" title="C、利息、股息、转让证券等金融性资产收入"><br />
						<input type="radio" name="one" value="D"
							title="D、出租、出售房地产等非金融性资产收入"><br /> <input type="radio"
							name="one" value="E" title="E、无固定收入"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>2、最近客户家庭预计进行证券投资的资金占家庭现有总资产(不含自住、自用房产及汽车等固定资产)的比例是：</p>
					<div class="layui-input-block">
						<input type="radio" name="two" value="A" title="A、70%以上"
							checked=""><br /> <input type="radio" name="two"
							value="B" title="B、50%-70%"><br /> <input type="radio"
							name="two" value="C" title="C、30%－50%"><br /> <input
							type="radio" name="two" value="D" title="D、10%－30%"><br />
						<input type="radio" name="two" value="E" title="E、10%以下"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>3、客户是否有尚未清偿的数额较大的债务，如有，其性质是：</p>
					<div class="layui-input-block">
						<input type="radio" name="three" value="A" title="A、没有" checked=""><br />
						<input type="radio" name="three" value="B"
							title="B、有，住房抵押贷款等长期定额债务"><br /> <input type="radio"
							name="three" value="C" title="C、有，信用卡欠款、消费信贷等短期信用债务"><br />
						<input type="radio" name="three" value="D"
							title="D、有，向亲友或贷款公司亦较大金额短期借款，需要筹资快速归还"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>4、客户可用于投资的资产数额（包括金融资产和不动产）为：</p>
					<div class="layui-input-block">
						<input type="radio" name="four" value="A" title="A、不超过50万元人民币"
							checked=""><br /> <input type="radio" name="four"
							value="B" title="B、50万-300万元（不含）人民币"><br /> <input
							type="radio" name="four" value="C" title="C、300万-1000万元（不含）人民币"><br />
						<input type="radio" name="four" value="D" title="D、1000万元人民币以上"><br />
					</div>
				</div>
				<p class="tit">二、投资知识</p>
				<div class="layui-form-item" pane="">
					<p>5、以下描述中何种符合客户的实际情况：</p>
					<div class="layui-input-block">
						<input type="radio" name="five" value="A"
							title="A、金融产品投资相关的工作经验超过2年" checked=""><br /> <input
							type="radio" name="five" value="B"
							title="B、已取得金融、经济或财会等与金融产品投资相关专业学士以上学位"><br /> <input
							type="radio" name="five" value="C"
							title="C、取得证券、基金、期货、注册会计师等相关执业资格证"><br /> <input
							type="radio" name="five" value="D" title="D、我不符合以上任何一项描述"><br />
					</div>
				</div>
				<p class="tit">三、投资经验</p>
				<div class="layui-form-item" pane="">
					<p>6、有一位投资者一个月内做了15笔交易（同一品种买卖各一次算一笔），客户认为这样的交易频率：</p>
					<div class="layui-input-block">
						<input type="radio" name="six" value="A" title="A、太高了" checked=""><br />
						<input type="radio" name="six" value="B" title="B、偏高"><br />
						<input type="radio" name="six" value="C" title="C、正常"><br />
						<input type="radio" name="six" value="D" title="D、偏低"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>7、过去一年时间内，客户购买的不同产品或接受的不同服务（含同一类型的不同产品或服务）的数量是：</p>
					<div class="layui-input-block">
						<input type="radio" name="seven" value="A" title="A、5个以下"
							checked=""><br /> <input type="radio" name="seven"
							value="B" title="B、6至10个"><br /> <input type="radio"
							name="seven" value="C" title="C、11至15个"><br /> <input
							type="radio" name="seven" value="D" title="D、16个以上"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>8、以下金融产品或服务，客户投资经验在两年以上的有：</p>
					<div class="layui-input-block">
						<input type="checkbox" name="eight" value="A" title="A、银行存款等"
							checked=""><br /> <input type="checkbox" name="eight"
							value="B" title="B、债券型等固定收益类产品"><br /> <input
							type="checkbox" name="eight" value="C" title="C、股票、基金等权益类投资产品"><br />
						<input type="checkbox" name="eight" value="D" title="D、期货、期权、融资融券"><br />
						<input type="checkbox" name="eight" value="E"
							title="E、复杂金融产品、其他产品或服务"><br />
						<p class="tit">（注：本题可多选，但评分以其中最高分值选项为准。）</p>
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>9、如果客户曾经从事过金融市场投资，在交易较为活跃的月份，平均月交易额大概是多少：</p>
					<div class="layui-input-block">
						<input type="radio" name="nine" value="A" title="A、10万元以内"
							checked=""><br /> <input type="radio" name="nine"
							value="B" title="B、10万元-30万元"><br /> <input type="radio"
							name="nine" value="C" title="C、30万元-100万元"><br /> <input
							type="radio" name="nine" value="D" title="D、100万元以上"><br />
						<input type="radio" name="nine" value="E" title="E、从未从事过金融市场投资"><br />
					</div>
				</div>
				<p class="tit">四、投资目标</p>
				<div class="layui-form-item" pane="">
					<p>10、客户用于证券投资的大部分资金不会用作其它用途的时间段为：</p>
					<div class="layui-input-block">
						<input type="radio" name="ten" value="A" title="A、0到1年" checked=""><br />
						<input type="radio" name="ten" value="B" title="B、1到5年"><br />
						<input type="radio" name="ten" value="C" title="C、无特别要求"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>11、客户打算重点投资于哪些种类的投资品种？</p>
					<div class="layui-input-block">
						<input type="checkbox" name="eleven" value="A"
							title="A、债券等固定收益类投资品种" checked=""><br /> <input
							type="checkbox" name="eleven" value="B" title="B、股票、基金等权益类投资品种"><br />
						<input type="checkbox" name="eleven" value="C"
							title="C、期货、期权、融资融券等"><br /> <input type="checkbox"
							name="eleven" value="D" title="D、高风险金融产品或服务"><br /> <input
							type="checkbox" name="eleven" value="E" title="E、其他产品或服务"><br />
						<p class="tit">（注：本题可多选，但评分以其中最高分值选项为准。）</p>
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>12、假设有两种不同的投资：投资A期望获得5%的收益，有可能承担非常小的损失；投资B期望获得20%的收益，但有可能面临25%甚至更高的亏损。客户将客户的投资资产分配为：</p>
					<div class="layui-input-block">
						<input type="radio" name="twelven" value="A" title="A、全部投资于A"
							checked=""><br /> <input type="radio" name="twelven"
							value="B" title="B、大部分投资于A"><br /> <input type="radio"
							name="twelven" value="C" title="C、两种投资各一半"><br /> <input
							type="radio" name="twelven" value="D" title="D、全部投资于B"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>13、当客户进行投资时，客户的期望收益是：：</p>
					<div class="layui-input-block">
						<input type="radio" name="thirteen" value="A"
							title="A、尽可能保证本金安全，不在乎收益率比较低" checked=""><br /> <input
							type="radio" name="thirteen" value="B"
							title="B、产生一定的收益，可以承担一定的投资风险"><br /> <input type="radio"
							name="thirteen" value="C" title="C、产生较多的收益，可以承担较大的投资风险"><br />
						<input type="radio" name="thirteen" value="D"
							title="D、实现资产大幅增长，愿意承担很大的投资风险"><br />
					</div>
				</div>
				<p class="tit">五、风险偏好</p>
				<div class="layui-form-item" pane="">
					<p>14、客户认为自己能承受的最大投资损失是多少？</p>
					<div class="layui-input-block">
						<input type="radio" name="fourteen" value="A" title="A、完全不能承受任何损失"
							checked=""><br /> <input type="radio" name="fourteen"
							value="B" title="B、可承受一定的投资损失"><br /> <input
							type="radio" name="fourteen" value="C" title="C、可承受较大的投资损失"><br />
						<input type="radio" name="fourteen" value="D" title="D、损失可能超过本金"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>15、客户打算将自己的投资回报主要用于：</p>
					<div class="layui-input-block">
						<input type="radio" name="fifteen" value="A" title="A、改善生活"
							checked=""><br /> <input type="radio" name="fifteen"
							value="B" title="B、个体生产经营或证券投资以外的投资行为"><br /> <input
							type="radio" name="fifteen" value="C" title="C、履行扶养、抚养或赡养义务"><br />
						<input type="radio" name="fifteen" value="D" title="D、本人养老或医疗"><br />
					</div>
				</div>
				<p class="tit">六、其他信息</p>
				<div class="layui-form-item" pane="">
					<p>16、客户的年龄是：</p>
					<div class="layui-input-block">
						<input type="radio" name="sixteen" value="A" title="A、18-30岁"
							checked=""><br /> <input type="radio" name="sixteen"
							value="B" title="B、31-40岁"><br /> <input type="radio"
							name="sixteen" value="C" title="C、41-50岁"><br /> <input
							type="radio" name="sixteen" value="D" title="D、51-65岁"><br />
						<input type="radio" name="sixteen" value="E" title="E、超过65岁"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>17、今后五年时间内，客户的父母、配偶以及未成年子女等需负法定抚养、扶养和赡养义务的人数为：</p>
					<div class="layui-input-block">
						<input type="radio" name="seventeen" value="A" title="A、1-2人"
							checked=""><br /> <input type="radio" name="seventeen"
							value="B" title="B、3-4人"><br /> <input type="radio"
							name="seventeen" value="C" title="C、5人以上"><br /> <input
							type="radio" name="seventeen" value="D" title="D、0人"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>18、客户的最高学历是：</p>
					<div class="layui-input-block">
						<input type="radio" name="eighteen" value="A" title="A、高中或以下"
							checked=""><br /> <input type="radio" name="eighteen"
							value="B" title="B、大学专科"><br /> <input type="radio"
							name="eighteen" value="C" title="C、大学本科"><br /> <input
							type="radio" name="eighteen" value="D" title="D、硕士及以上"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>19、客户家庭的就业状况是：</p>
					<div class="layui-input-block">
						<input type="radio" name="nineteen" value="A"
							title="A、客户与配偶均有稳定收入的工作" checked=""><br /> <input
							type="radio" name="nineteen" value="B"
							title="B、客户与配偶其中一人有稳定收入的工作"><br /> <input type="radio"
							name="nineteen" value="C" title="C、客户与配偶均没有稳定收入的工作或者已退休"><br />
						<input type="radio" name="nineteen" value="D"
							title="D、未婚，但有稳定收入的工作"><br /> <input type="radio"
							name="nineteen" value="E" title="E、未婚，目前暂无稳定收入的工作"><br />
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<p>20、客户是否有以下来源的不良诚信记录？</p>
					<div class="layui-input-block">
						<input type="radio" name="twenty" value="A" title="A、无" checked=""><br />
						<input type="radio" name="twenty" value="B"
							title="B、被法院、工商、税务、人民银行征信中心等行政监管机构列入失信名单"><br /> <input
							type="radio" name="twenty" value="C" title="C、被商业机构列入失信名单"><br />
					</div>
				</div>


			</div>
			<!---->
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				</div>
			</div>
		</form>

	</div>
	<!-- 以下是所用到的js -->
	<!--引入jQuery bootstrape依赖jQuery-->
	<script src="lib/jquery/jquery.js"></script>
	<!--引入zepto.js-->
	<script src="lib/zepto-js/zepto.min.js"></script>
	<script src="lib/layui/layui.js"></script>
	<!--引入bootstrape的js文件-->
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script>
		layui.use([ 'form', 'upload', 'layer' ], function() {
			var form = layui.form,
				$ = layui.jquery,
				upload = layui.upload;
	
			//自定义验证规则，首尾不能有空格
			form.verify({
				aa : function(value) {
					if (/^[\s　]|[ ]$/gi.test(value)) {
						return '首尾不能有空格';
					}
				}
			});
	
			var idImage = $("#demo2 img").val();
			console.log(idImage);
			//多图片上传
			upload.render({
				elem : '#test2',
				url : '/upload/',
				multiple : true,
				data : {
					"idImage" : idImage
				},
				exts : 'jpg|png|gif|jpeg', //允许上传文件
				auto : false, //选择文件后不自动上传
				bindAction : '.layui-btn', //指向一个按钮触发上传
				before : function(obj) {
					//预读本地文件示例，不支持ie8
					obj.preview(function(index, file, result) {
						$('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img">')
					});
				},
				done : function(res) {
					//上传完毕
				}
			});
	
			//监听提交表单
			form.on('submit(formDemo)', function(data) {
				//获取文本框的值
				var userName = $("#userName").val();
				// var type1 = $("input[name='type']:checked").val();
				var type = 0;
				if (type == "男") {
					type = 1;
				}
				var addRess = $("#addRess").val();
				var idCard = $("#idCard").val();
				var one = $("input[name='one']:checked").val();
				var two = $("input[name='two']:checked").val();
				var three = $("input[name='three']:checked").val();
				var four = $("input[name='four']:checked").val();
				var five = $("input[name='five']:checked").val();
				var six = $("input[name='six']:checked").val();
				var seven = $("input[name='seven']:checked").val();
				var eight = "";
				$("input:checkbox[name='eight']:checked").each(function() {
					eight += $(this).val() + " ";
				});
				var nine = $("input[name='nine']:checked").val();
				var ten = $("input[name='ten']:checked").val();
				var eleven = "";
				$("input:checkbox[name='eleven']:checked").each(function() {
					eleven += $(this).val() + " ";
				});
				var twelven = $("input[name='twelven']:checked").val();
				var thirteen = $("input[name='thirteen']:checked").val();
				var fourteen = $("input[name='fourteen']:checked").val();
				var fifteen = $("input[name='fifteen']:checked").val();
				var sixteen = $("input[name='sixteen']:checked").val();
				var seventeen = $("input[name='seventeen']:checked").val();
				var eighteen = $("input[name='eighteen']:checked").val();
				var nineteen = $("input[name='nineteen']:checked").val();
				var twenty = $("input[name='twenty']:checked").val();
	
				var answer = "1=" + one + ",2=" + two + ",3=" + three + ",4=" + four + ",5=" + five + ",6=" + six + ",7=" + seven + ",8=" + eight + ",9=" + nine + ",10=" + ten +
					",11=" + eleven + ",12=" + twelven + ",13=" + thirteen + ",14=" + fourteen + ",15=" + fifteen + ",16=" + sixteen + ",17=" +
					seventeen + ",18=" + eighteen + ",19=" + nineteen + ",20=" + twenty;
				var fromdata = new FormData();
				var rdCard = $("#rdCard").val();
				alert(rdCard)
				fromdata.enctype = "multipart/from-data";
				fromdata.append("rdCode", rdCard);
				fromdata.append("userName", userName);
				fromdata.append("type", type);
				fromdata.append("addRess", addRess);
				fromdata.append("answer", answer);
				fromdata.append("idCard", idCard);
				fromdata.append("file", $(".file")[0].files[0], $(".file")[0].files[0].name);
				fromdata.append("file", $(".file1")[0].files[0], $(".file1")[0].files[0].name);
				// console.log(fromdata);
				//发送ajax
				$.ajax({
					url : "/business/user/commitTheData",
					type : "post",
					dataType : "json",
					data : fromdata,
					processData : false,
					contentType : false,
	
					success : function(data) {
						//console.log(data);
						/*提交成功，跳转*/
						alert(data.errMsg);
	
	
					},
					error : function() {
						alert("系统错误，请联系管理员!");
					}
				})
				return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可
			});
		});
	</script>
</body>
</html>