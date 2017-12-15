<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>上海迈步后台管理系统--管理员</title>
<link rel="stylesheet" href="./lib/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<link rel="stylesheet" href="./build/css/app.css" media="all">
</head>

<body>
	<div class="layui-layout layui-layout-admin kit-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">上海迈步后台--管理员</div>
			<ul class="layui-nav layui-layout-right kit-nav">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img">${sessionScope.salesmanUser.userName}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;">基本资料</a>
						</dd>
						<dd>
							<a href="javascript:;">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="/business/salesman/exit"><i
						class="fa fa-sign-out" aria-hidden="true"></i> 退出登录</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black kit-side">
			<div class="layui-side-scroll">
				<div class="kit-side-fold">
					<i class="fa fa-navicon" aria-hidden="true"></i>
				</div>
				<!-- 左侧导航区域（配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar"
					kit-navbar>
					<!--销售部-->
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span> 用户管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'xiaoshou/add.jsp',icon:'&#xe621;',title:'添加用户',id:'1'}">
									<span>添加用户</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'xiaoshou/performance.jsp',icon:'&#xe621;',title:'客户成交表',id:'11'}">
									<span>客户成交表</span>
								</a>
							</dd>
						</dl></li>
					<!--合规部-->
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span> 合规管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'hegui/audit.jsp',icon:'&#xe621;',title:'已通过合规',id:'2'}">
									<span>已通过合规</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'hegui/yhliebiao.jsp',icon:'&#xe621;',title:'已成交的交易',id:'16'}">
									<span>已成交的交易</span>
								</a>
							</dd>
						</dl></li>
					<!--服务部-->
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span> 服务管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'fuwu/add.jsp',icon:'&#xe621;',title:'发表文章',id:'3'}">
									<span>发表文章</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/service.jsp',icon:'&#xe621;',title:'服务权限',id:'10'}">
									<span>服务权限</span>
								</a>
							</dd>
								<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'fuwu/gupiao.jsp',icon:'&#xe621;',title:'股票到价通知',id:'40'}">
									<span>股票到价通知</span>
								</a>
							</dd>
								<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'fuwu/product.jsp',icon:'&#xe621;',title:'产品运行报告通',id:'41'}">
									<span>产品运行报告通</span>
								</a>
							</dd>
						</dl></li>
					<!--管理员-->
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span> 账单管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/indent.jsp',icon:'&#xe621;',title:'订单管理',id:'4'}">
									<span>订单管理</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/offline.jsp',icon:'&#xe621;',title:'线下购买',id:'9'}">
									<span>线下购买</span>
								</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span> 账号管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/user.jsp',icon:'&#xe621;',title:'账号管理',id:'5'}">
									<span>账号管理</span>
								</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span> 商品管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/add.jsp',icon:'&#xe621;',title:'添加商品',id:'6'}">
									<span>添加商品</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/update.jsp',icon:'&#xe621;',title:'商品升级管理',id:'7'}">
									<span>商品升级管理</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'admin/look.jsp',icon:'&#xe621;',title:'查看商品关系',id:'8'}">
									<span>查看商品关系</span>
								</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a class="" href="javascript:;"><i
							class="fa fa-plug" aria-hidden="true"></i><span>客服管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'kefu/auto.jsp',icon:'&#xe621;',title:'自动回复',id:'22'}">
									<span>自动回复</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'kefu/liuyan.jsp',icon:'&#xe621;',title:'留言',id:'23'}">
									<span>留言列表</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'kefu/yonghu.jsp',icon:'&#xe621;',title:'用户接入列表',id:'24'}">
									<span>用户接入列表</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'kefu/jieru.jsp',icon:'&#xe621;',title:'接入语设置',id:'25'}">
									<span>接入语设置</span>
								</a>
							</dd>
							<dd>
								<a href="javascript:;" kit-target
									data-options="{url:'kefu/guding.jsp',icon:'&#xe621;',title:'固定回答',id:'26'}">
									<span>固定回答</span>
								</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>
		<div class="layui-body" id="container">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">主体内容加载中,请稍等...</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			<a href="#">上海迈步投资管理有限公司/后台管理系统</a>
		</div>
	</div>
	<script type="text/javascript">
		var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
		document.write(unescape("%3Cspan id='cnzz_stat_icon_1264021086'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264021086%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<script src="./lib/layui/layui.js"></script>
	<script>
		var message;
		layui.config({
			base : 'build/js/'
		}).use([ 'app', 'message' ], function() {
			var app = layui.app,
				$ = layui.jquery,
				layer = layui.layer;
			//将message设置为全局以便子页面调用
			message = layui.message;
			//主入口
			app.set({
				type : 'iframe'
			}).init();
			$('#pay').on('click', function() {
				layer.open({
					title : false,
					type : 1,
					content : ' ',
					area : [ '500px', '250px' ],
					shadeClose : true
				});
			});
		});
	</script>
	<script type="text/javascript">
		var userName = "${sessionScope.salesmanUser.userName}"
		var userType = "${sessionScope.salesmanUser.type}"
	
		if (userName.length == 0 || userType != "1") {
	
			window.location.href = "/business/salesman/exit";
		}
	</script>
</body>

</html>