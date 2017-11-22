<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = "/business/index/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
       <base href="<%=basePath%>">
    <!--添加视口 移动端适配-->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>联系客服</title>
    <!--引入第三方框架-->
    <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="kefu/css/base.css"/>
    <link rel="stylesheet" href="kefu/css/liuyan.css"/>
    <!--引入rem.js文件-->
    <script src="lib/rem/rem.js"></script>
    <!--引入less文件的js-->
    <script src="lib/less/less.js"></script>
    <script src="lib/less/less.min.js"></script>
</head>
<body>
<header id="header">
    <h2>留言</h2>
</header>
<section id="message">
    <form action="" enctype="multipart/form-data">
        <p>您好，很抱歉我们暂时无法为您提供服务，如需帮助，请留言，我们将尽快联系并解决您的问题。</p>
        <div class="describe">
            <p>问题描述:</p>
        <textarea name="" cols="30" rows="4" id="textarea"></textarea>
        <div class="img-box full">
            <section class="img-section">
                <div class="z_photo upimg-div clear" >
                    <section class="z_file fl">
                        <img src="kefu/images/photo.png" class="add-img">
                        <input type="file" name="file" id="file" class="file" value="" onchange="getFileContent()" />
                        <div></div>
                    </section>
                </div>
            </section>
        </div>
        <div class="mask works-mask">
            <div class="mask-content">
                <p class="del-p">您确定要删除作品图片吗？</p>
                <p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
            </div>
        </div>
        </div>
        <div class="wenz sel">
            <p>问题类型：&nbsp;&nbsp;&nbsp;<input type="text" id="questMes"/></p>
            <div class="jianTou"></div>
        </div>
        <div class="wenz">
            <p>手机号码：&nbsp;&nbsp;&nbsp;<input type="text" id="phone"/></p>
        </div>
        <button type="button" id="btn">提交</button>
    </form>
</section>
<!--问题类型 弹窗-->
<section id="mask">
    <div id="mask_bg"></div>
    <div id="mask_content">
        <div class="shut">×</div>
        <p>问题类型</p>
        <ul class="questUl">
            <li>售前咨询</li>
            <li>售后咨询</li>
            <li>合作</li>
            <li>投诉与建议</li>
            <li>其他</li>
        </ul>
    </div>
</section>
<script src="lib/jquery/jquery.js"></script>
<script src="lib/zepto-js/zepto.min.js"></script>
<script src="lib/fastclick.js"></script>
<script src="kefu/js/liuyan.js"></script>
<script>
    function getFileContent() {
        /*1.创建文件读取对象*/
        var reader = new FileReader();
        /*2.读取文件，获取DataURL*/
        var file = document.querySelector("#file").files;
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