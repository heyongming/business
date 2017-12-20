layui.use([ 'form', 'layer','laydate'], function() {
    var form = layui.form
        ,$ = layui.jquery
        ,layer = layui.layer
        ,laydate = layui.laydate;
    $(function(){
        form.render();
        show();  //展示数据
    })
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
                // 给查看，删除按钮绑定单击事件
                $('#content tr').each(function(i, e) {
                    var td = $(e).find('td:last-of-type'); //操作
                    var kehuid = $(e).find('td:eq(0)').text(); //客户ID
                    // 查看
                    td.find('a:eq(0)').click(function() {
                        window.open('yhsuccess.html')
                    });
                    // 删除
                    td.find('a:eq(1)').click(function() {
                    	layer.confirm('确定删除此条数据吗？', {
                            btn: ['确定', '取消'] //按钮
                        }, function () {
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
    									layer.msg('删除成功');
    									show();
    								} else {
    									layer.msg(data.errMsg);
    								}
    							}
    						});
                        })
                    });
                });
            }
        });
    }
})
