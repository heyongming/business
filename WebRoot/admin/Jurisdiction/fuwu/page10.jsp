<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	basePath = "/business/admin/Jurisdiction/fuwu/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>天禄跟投产品编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../lib/layui/css/layui.css" media="all">
    <!--引入自己的less,自己写的css-->
    <link rel="stylesheet" href="../css/base.css"/>
    <link rel="stylesheet" href="css/page10.css"/>
</head>
<body>
<div class="admin-main">
    <!--添加按钮-->
    <blockquote class="layui-elem-quote">
        <a class="layui-btn layui-btn-small" id="add">
            <i class="layui-icon">&#xe608;</i> 添加信息
        </a>
    </blockquote>
    <!-- 编辑总表 -->
    <div id="j_formAdd" class="form-add">
        <form class="layui-form" enctype="multipart/form-data">
            <div class="layui-form-item">
                <label class="layui-form-label">市场分析：</label>
                <div class="layui-input-block">
                    <script id="marketContent" name="marketContent" required
                            lay-verify="required" type="text/plain">

                    </script>
                </div>
            </div>
            <table id="oneTbale">
                <tr>
                    <td>初始资金：</td>
                    <td><input type="text" id="beginMoney" name="beginMoney" required lay-verify="required" autocomplete="off" class="layui-input"></td>
                    <td>资金余额：</td>
                    <td><input type="text" id="moneyBalance" name="moneyBalance" required lay-verify="required" autocomplete="off" class="layui-input"></td>
                </tr>

                <tr>
                    <td>总资产：</td>
                    <td><input type="text" id="totalAssets" name="totalAssets" required lay-verify="required" autocomplete="off" class="layui-input"></td>
                    <td>总市值：</td>
                    <td><input type="text" id="totalMarket" name="totalMarket" required lay-verify="required" autocomplete="off" class="layui-input"></td>
                </tr>
                <tr>
                    <td>总盈亏：</td>
                    <td colspan="3"><input type="text" id="totalProfit" name="totalProfit" required lay-verify="required" autocomplete="off" class="layui-input"></td>
                </tr>
                <tr>
                    <td>标题：</td>
                    <td colspan="3"><input type="text" id="title" name="title" required lay-verify="required" autocomplete="off" class="layui-input"></td>
                </tr>
            </table>
            <ul>
                <li>
                    <div class="layui-form-item">
                        <label class="layui-form-label chiCang">资产走势图：</label>
                        <input type="file" id="imageUrl01" class="file" onchange="showImg('imageUrl01','photoImg01')"/>
                    </div>
                    <div class="imgPhoto">
                        <img src="images/yulan.png" id="photoImg01" alt=""/>
                    </div>
                </li>
                <li>
                    <div class="layui-form-item">
                        <label class="layui-form-label chiCang">净值走势图：</label>
                        <input type="file" id="imageUrl02" class="file" onchange="showImg('imageUrl02','photoImg02')"/>
                    </div>
                    <div class="imgPhoto">
                        <img src="images/yulan.png" id="photoImg02" alt=""/>
                    </div>
                </li>
            </ul>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" id="btn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <!--当前持仓情况数据-->
    <div id="chiCangTable">
        <!--添加按钮-->
        <blockquote class="layui-elem-quote">
            <a class="layui-btn layui-btn-small" id="addChiCang">
                <i class="layui-icon">&#xe608;</i> 添加持仓信息
            </a>
        </blockquote>
        <!--当前持仓情况数据列表-->
        <fieldset class="layui-elem-field">
            <legend>当前持仓情况数据列表</legend>
            <div class="layui-field-box layui-form">
            <table class="tableQing layui-table admin-table">
                <tr>
                    <th>id</th>
                    <th>代码</th>
                    <th>名称</th>
                    <th>持仓量</th>
                    <th>比例</th>
                    <th>成本价</th>
                    <th>最新价</th>
                    <th>市值</th>
                    <th>盈亏比例</th>
                    <th>操作</th>
                </tr>
                <tbody id="chiCangContent">

                </tbody>
            </table>
        </div>
    </fieldset>
    </div>
    <!--当前持仓情况添加数据-->
    <div id="chiCangTabAdd">
        <form class="layui-form" enctype="multipart/form-data">
            <div class="layui-form-item">
                <label class="layui-form-label">代码：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangCode" name="chiCangCode" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangName" name="chiCangName" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">持仓量：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangNum" name="chiCangNum" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">持仓比例：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangProportion" name="chiCangProportion" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">成本价：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangPrice" name="chiCangPrice" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">最新价：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangNew" name="chiCangNew" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">市值：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangValue" name="chiCangValue" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">盈亏比例：</label>
                <div class="layui-input-block">
                    <input type="text" id="chiCangProfit" name="chiCangProfit" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" id="addChiCangBtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <!--今日策略情况数据-->
    <div id="jinRiTable">
        <!--添加按钮-->
        <blockquote class="layui-elem-quote">
            <a class="layui-btn layui-btn-small" id="addJinRi">
                <i class="layui-icon">&#xe608;</i> 添加今日策略
            </a>
        </blockquote>
        <!--今日策略情况数据列表-->
        <fieldset class="layui-elem-field">
            <legend>今日策略情况数据列表</legend>
            <div class="layui-field-box layui-form">
                <table class="tableQing layui-table admin-table">
                    <tr>
                        <th>id</th>
                        <th>日期</th>
                        <th>名称</th>
                        <th>代码</th>
                        <th>买进</th>
                        <th>卖出</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>操作</th>
                    </tr>
                    <tbody id="jinRiContent">

                    </tbody>
                </table>
            </div>
        </fieldset>
    </div>
    <!--今日策略情况添加数据-->
    <div id="jinRiTabAdd">
        <form class="layui-form" enctype="multipart/form-data">
            
            <div class="layui-form-item">
                <label class="layui-form-label">日期：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="nowDate" name="nowDate" placeholder="yyyy-MM-dd">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-block">
                    <input type="text" id="jinRiName" name="jinRiName" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">代码：</label>
                <div class="layui-input-block">
                    <input type="text" id="jinRiCode" name="jinRiCode" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">买进：</label>
                <div class="layui-input-block">
                    <input type="text" id="jinRibuy" name="jinRibuy" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">卖出：</label>
                <div class="layui-input-block">
                    <input type="text" id="jinRiOut" name="jinRiOut" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">价格：</label>
                <div class="layui-input-block">
                    <input type="text" id="jinRiPrice" name="jinRiPrice" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">数量：</label>
                <div class="layui-input-block">
                    <input type="text" id="jinRiNum" name="jinRiNum" required lay-verify="required" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" id="jinRiBtn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <!--总表列表-->
    <fieldset class="layui-elem-field">
        <legend>数据列表</legend>
        <div class="layui-field-box layui-form">
            <table class="layui-table admin-table">
                <thead>
                <tr>
                    <th>id</th>
                    <th>时间</th>
                    <th>总资产</th>
                    <th>总市值</th>
                    <th>总盈亏</th>
                    <th>今日策略标题</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="content">
                <tr>
                    <td>id</td>
                    <td>时间</td>
                    <td>总资产</td>
                    <td>总市值</td>
                    <td>总盈亏</td>
                    <td>今日策略标题</td>
                    <td>
                        <a class="layui-btn btn2 layui-btn-mini">总表编辑</a>
                        <a class="layui-btn btn3 layui-btn-danger layui-btn-mini">总表删除</a>
                        <a class="layui-btn btn1 layui-btn-mini">新增当前持仓情况</a>
                        <a class="layui-btn btn1 layui-btn-mini">新增今日策略情况</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
</div>
<script src="../lib/jquery/jquery.min.js"></script>
<script src="../lib/layui/layui.js"></script>
<script src="js/page10.js"></script>
<!-- 配置文件 -->
<script type="text/javascript" src="../lib/uditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../lib/uditor/ueditor.all.js"></script>
<script type="text/javascript" src="../lib/uditor/ueditor.parse.js"></script>
<script>
    function showImg(fileid,target){//给2个参数，其他位置的参数名一致，值就进去了
        var preview = document.querySelector('#'+target);//获取img元素,显示图片位置，根据el表达式('#'+target)
        var file = document.querySelector('#'+fileid).files[0];//根据id拿到文件选择框里面的文件，
        var reader = new FileReader();//创建FileReader接口（把文件放到图片预览框里面）
        reader.onloadend = function () {
            preview.src = reader.result;
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }
    }
</script>

</body>

</html>