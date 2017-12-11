$(function() {
    initGoodsList(); //初始化下拉列表
    show(); /*页面初始化*/
    addData(); /*添加*/
    var yanZheng = 0;
    //初始化下拉列表
    function initGoodsList() {
        $.ajax({
            url : "/business/goods/getAllData",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                var tag = "<option>请选择</option>";
                $.each(data, function(i, e) {
                    tag+="<option value=" + e.goodsId + ">" + e.goodsName + "</option>";
                })
                $("#goodsId").append(tag);
                //下拉选中 表格显示相应数据
                $("#goodsId").change(function(){
                    var goodsIdValue = $("#goodsId").val();
                    tableCon(goodsIdValue);
                });

            }
        });
    }
    /*页面初始化*/
    function show() {
        $.ajax({
            url : "/business/serviceArticle/getFullData",
            type : 'post',
            dataType : 'json',
            success : function(data) {
                // 渲染数据列表
                renderData(data);
            }
        });
    }
    //富文本编辑器操作
    var ue = UE.getEditor('redContent');
    /*点击添加，提交*/
    function addData() {
        $("#add").click(function() {
            $("#j_mask").css("display", "block");
            $("#j_formAdd").css("display", "block");
            //关闭
            $("#j_hideFormAdd").click(function() {
                $("#j_mask").css("display", "none");
                $("#j_formAdd").css("display", "none");
            });
            btnForm();
        });
    }
    // 封装渲染数据列表
    function renderData(data) {
        // 数据解析和渲染
        var tag = '';
        $.each(data, function(i, e) {
            tag += '<tr>' +
                '<td>红点ID</td>'+
                '<td>红点标题</td>'+
                '<td>商品名称</td>'+
                '<td>发送时间</td>'+
                '<td>操作</td>'+
                '<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a></td>' +
                '</tr>';
        });
        $('#content').html(tag);
        // 给修改和删除按钮绑定单击事件
        $('#content tr').each(function(i, e) {
            var td = $(e).find('td:last-of-type');
            var redId = $(e).find('td:eq(0)').text(); //ID
            // 给修改按钮绑定事件
            td.find('a:eq(0)').click(function() {
                //先弹出
                $("#j_mask").css("display", "block");
                $("#j_formAdd").css("display", "block");
                //关闭
                $("#j_hideFormAdd").click(function() {
                    $("#j_mask").css("display", "none");
                    $("#j_formAdd").css("display", "none");
                });
                updateData(redId);
            });
        });

    }
    //封装更新操作
    function updateData(redId) {
        $.ajax({
            url : "/business/serviceArticle/findById",
            type : 'post',
            data : {
                "redId" : redId
            },
            dataType : 'json',
            success : function(data) {
                /*显示旧信息*/
                $("#redTitle").val(data.redTitle); //红点标题
                $("#goodsId").val(data.goodsId); //商品
                var goodsIdValue = data.goodsId;
                tableCon(goodsIdValue);//表格
                ue.setContent(data.redContent);//红点内容
                $("#produceName").val(data.produceName); //产品名称
                $("#serviceName").val(data.serviceName); //服务名称
                $("#sendTime").val(data.sendTime); //发布时间
                $("#reported").val(data.reported); //报告摘要
                $("#endContent").val(data.endContent); //结束语
                // 重新绑定表单提交事件
                btnForm();
            }
        });
    }
    //提交数据
    function btnForm(){
        // 给表单提交按钮绑定事件
        $("#btn").unbind('click').click(function() {
            if(yanZheng==0){
                //表格验证
                var tableArr = new Array();
                $("input[name=tableContent]").each(function (i,d){
                    if(d.checked) {
                        tableArr.push(d.value);
                    }
                })
                if(tableArr.length<1){
                    alert("请选择用户至少一位!");
                }
            }
            // 获取所有的表单数据
            var redContent = ue.getContent(); //获取富文本编辑器内容
            var formData = new FormData();
            formData.append("redTitle", $("#redTitle").val());  //红点标题
            formData.append("goodsId", $("select[name='goodsId']").val());  //商品
            formData.append("tableArr", tableArr);  //表格
            formData.append("redContent", redContent);  //红点内容
            formData.append("produceName", $("#produceName").val());  //产品名称
            formData.append("serviceName", $("#serviceName").val());  //服务名称
            formData.append("sendTime", $("#sendTime").val());  //发布时间
            formData.append("reported", $("#reported").val()); //报告摘要
            formData.append("endContent", $("#endContent").val()); //结束语
            $(".spinner").show();
            $.ajax({
                type : 'post',
                url : '/business/serviceArticle/addServiceArticle',
                data : formData,
                processData : false,
                contentType : false,
                dataType : 'json',
                success : function(data) {
                    // 渲染数据列表
                    alert("添加成功");
                    $(".spinner").hide();
                    $("#j_mask").css("display", "none");
                    $("#j_formAdd").css("display", "none");
                    if (data.success == "true") {
                        show();
                    } else {
                        alert(data.errMsg)
                    }
                },
                error:function(){
                    alert("添加失败，请联系管理员");
                }
            });
            return false;
        });
    }
    //表格数据
    function tableCon(goodsIdValue){
        $.ajax({
            type : 'post',
            url : '...',
            data : {
                "goodsIdValue":goodsIdValue
            },
            dataType : 'json',
            success : function(data) {
                if(data.state==0){
                    alert("此产品下无用户数据");
                    yanZheng = 1;
                }
                $("#wrap").show();  //表格显示
                var tag = "";
                $.each(data, function(i, e) {
                    tag+='<tr>'+
                        '<td>'+
                        '<input type="checkbox" name="tableContent" value="id"/>'+
                        '</td>'+
                        '<td>姓名</td>'+
                        '<td>身份证</td>'+
                        '<td>微信昵称</td>'+
                        '</tr>';
                })
                $("#j_tb").html(tag);
                //表格 全选反选  样式
                $("#j_cbAll").click(function () {
                    var cked=$(this).prop("checked");

                    $("#j_tb").find(":checkbox").prop("checked",cked);
                });

                $("#j_tb").find(":checkbox").click(function () {

                    var length1=$("#j_tb").find(":checkbox").length;

                    var length2=$("#j_tb").find(":checked").length;

                    if(length1==length2){

                        $("#j_cbAll").prop("checked",true);
                    }else{

                        $("#j_cbAll").prop("checked",false);
                    }
                });
            },
            error:function(){
                alert("获取用户失败，请联系管理员");
            }
        })
    }
})