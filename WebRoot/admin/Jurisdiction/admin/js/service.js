$(function(){
    //页面展示信息
    show();
    function show(){
        $.ajax({
            url:"/business/serviceTime/getFullData",
            dataType:"json",
            success:function(data){
                var tag = "";
                $.each(data,function(i,e){
                    tag+='<tr>' +
                        '<td>'+e.id+'</td>' +
                        '<td>'+e.user.userName+' </td>' +
                        '<td>'+e.goodsList.goodsName+' </td>' +
                        '<td>'+e.serviceDay+'</td>'+
                    '<td><a href="javascript:;" class="layui-btn layui-btn-mini">编辑</a><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
                    '</tr>';
                });
                $("#content").html(tag);
                // 给查看，修改，删除按钮绑定单击事件
                $('#content tr').each(function(i, e) {
                    var td = $(e).find('td:last-of-type');  //操作
                    var kehuid = $(e).find('td:eq(0)').text(); //客户ID
                    // 给修改按钮绑定事件
                    td.find('a:eq(0)').click(function() {
                        $("#j_mask").css("display", "block");
                        $("#j_formAdd").css("display", "block");
                        //关闭
                        $("#j_hideFormAdd").click(function() {
                            $("#j_mask").css("display", "none");
                            $("#j_formAdd").css("display", "none");
                        });
                        updateData(kehuid);
                    });
                    // 给删除按钮绑定事件
                    td.find('a:eq(1)').click(function() {
                        $(this).parent().parent().remove();
                        $.ajax({
                            url : '/business/serviceTime/delServiceTime',
                            type : 'post',
                            data : {
                                "id" : kehuid
                            },
                            dataType : 'json',
                            success : function(data) {
                                // 删除后渲染数据列表
                                if (data.success == "true") {
                                    show();
                                } else {
                                    alert(data.errMsg)
                                }
                            }
                        });
                    });
                });
            }
        });
    }
    //修改操作
    function updateData(kehuid){
        $.ajax({
            url:"/business/serviceTime/getDataById",
            dataType:"json",
            type : 'post',
            data:{
                id: kehuid
            },
            success:function(data){
                //获取原有数据
             
                $("#serviceTime").val(data.serviceDay);
                $("#submit").unbind('click').click(function(){
                    var formData = new FormData();
                    formData.append("id",kehuid);
                    formData.append("serviceDay",$("#serviceTime").val());
                    $.ajax({
                        url:"/business/serviceTime/updateServiceTime",
                        type : 'post',
                        data : formData,
                        dataType : 'json',
                        processData : false,
                        contentType : false,
                        success:function(data){
                            $("#j_mask").css("display", "none");
                            $("#j_formAdd").css("display", "none");
                            if (data.success == "true") {
                                show();
                            } else {
                                alert(data.errMsg)
                            }
                        }
                    })
                    return false;
                })
            }
        })
    }
})

