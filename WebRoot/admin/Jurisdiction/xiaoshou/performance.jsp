<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/xiaoshou/";
%>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <title>客户成交表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css"/>
    <link rel="stylesheet" href="css/yonghu4.css"/>
    <!--引入rem.js文件-->
    <script src="../lib/rem/rem.js"></script>
</head>
<body>
<div id="content">
    <form action="" id="form">
        <h2>客户成交表</h2>
        <table id="table1">
            <tr>
                <td>客户姓名</td>
                <td><input type="text" class="con" id="name"/></td>
                <td>客户手机号</td>
                <td><input type="text" class="con" id="phone"/></td>
                <td>客户推荐码</td>
                <td><input type="text" class="con" id="tuiJian"/></td>
            </tr>
            <tr>
                <td>业务经理</td>
                <td><input type="text" class="con" id="jingLi"/></td>
                <td>业务员</td>
                <td colspan="3"><input type="text" class="con" id="yewuyuan"/></td>
            </tr>
            <tr>
                <td>开单手机号</td>
                <td><input type="text" class="con" id="tel"/></td>
                <td>开单微信号</td>
                <td><input type="text" class="con" id="weixinhao"/></td>
                <td>开单日期</td>
                <td><input type="text" class="con" id="date"/></td>
            </tr>
            <tr>
                <td>产品名称</td>
                <td>
                    <select name="product" id="product">
                    	
                    </select>
                </td>
                <td>产品金额</td>
                <td><input type="text" class="con" id="money"/></td>
                <td>付款方式</td>
                <td>
                    <input type="radio" name="fukuan" value="微信"/>微信
                    <input type="radio" name="fukuan" value="支付宝"/>支付宝
                    <input type="radio" name="fukuan" value="银行卡"/>银行卡
                </td>
            </tr>
            <tr>
                <td>支付凭证</td>
                <td>
                    <input type="file" name="imageUrl" id="photo" placeholder="上传图像" onchange="getFileContent()";/>
                    <img src="" alt="" id="img">
                </td>
                <td>支付订单号</td>
                <td colspan="3"><input type="text" class="con" id="dingDan"/></td>
            </tr>
            <tr>
                <td>是否升级</td>
                <td>
                    <input type="radio" name="shengJi" value="是"/>是
                    <input type="radio" name="shengJi" value="否"/>否
                </td>
                <td>是否需要发票</td>
                <td colspan="3">
                    <input type="radio" name="faPiao" value="是"/>是
                    <input type="radio" name="faPiao" value="否"/>否
                </td>
            </tr>
        </table>
        <button type="button" id="button">提交</button>
        <button type="reset" class="cz">重置</button>
    </form>
</div>
<script src="../lib/layui/layui.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/yonghu4.js"></script>
<!--预览图片-->
<script>
    function getFileContent() {
        /*1.创建文件读取对象*/
        var reader = new FileReader();
        /*2.读取文件，获取DataURL*/
        var file = document.querySelector("#photo").files;
        reader.readAsDataURL(file[0]);
        /*获取数据*/
        reader.onload = function () {
            //console.log(reader.result);
            /*展示*/
            document.querySelector("img").src = reader.result;
        }
        reader.onprogress = function (e) {
            var percent = e.loaded / e.total * 100 + "%";
            div.style.width = percent;
        }
    }

</script>
</body>

</html>