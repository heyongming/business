$(function() {
    //页面展示信息
    show();
    function show() {
        $.ajax({
            url : "/business/salesman/SalManSuucesFullData",
            dataType : "json",
            success : function(data) {
                var tag = "";
                $.each(data, function(i, e) {
                    tag += '<tr>' +
                        '<th>'+e.successId+'</th>' +
                        '<th>'+e.customerName+'</th>' +
                        '<th>'+e.customerPhone+'</th>' +
                        '<th>'+e.salesman.userName+'</th>' +
                        '<th>'+e.goodsList.goodsName+'</th>' +
                        '<th>'+e.allPrice+'</th>' +
                        '<th>'+e.orderDate+'</th>' +
                        '<td><a href="javascript:;" data-opt="look" class="layui-btn layui-btn-mini">查看</a>' +
                        '<a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>' +
                        '</tr>';
                });
                $("#content").html(tag);
                // 给查看，修改，删除按钮绑定单击事件
                $('#content tr').each(function(i, e) {
                    var td = $(e).find('td:last-of-type'); //操作
                    var kehuid = $(e).find('td:eq(0)').text(); //客户ID
                    // 给查看按钮绑定事件
                    td.find('a:eq(0)').click(function() {
                        window.open('yhsuccess.html')
                    });
                    // 给删除按钮绑定事件
                    td.find('a:eq(1)').click(function() {
                        $(this).parent().parent().remove();
                        $.ajax({
                            url : '...',
                            type : 'post',
                            data : {
                                "userId" : kehuid
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
})
