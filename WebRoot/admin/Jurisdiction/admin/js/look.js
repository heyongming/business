$(function() {


	//进入页面请求加载数据
	$.ajax({
		url : "/business/goods/getUpgradeAll",
		dataType : "json",
		success : function(data) {
			//成功

			var tag = "";
			$.each(data, function(i, e) {
				
				tag += '<tr>' +
					'<td style="display: none">'+e.id+'</td>' +
					'<td>'+e.goodsList.goodsName+'</td>' +
					'<td>'+e.goodsList.goodsPrice+'</td>' +
					'<td>'+e.upgradeGoodsList.goodsName+'</td>' +
					'<td>'+e.upgradeGoodsList.goodsPrice+'</td>' +
					'<td><a href="javascript:;" class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>'+
					'</tr>';
			});
			$("#lookMessage").append(tag);
			$("#lookMessage tr").each(function(i, e) {
				var td = $(e).find('td:last-of-type');
				var id = $(e).find('td:eq(0)').text();
				// 给删除按钮绑定事件
				td.find('a:eq(0)').click(function() {
					
					$.ajax({
						url : '/business/goods/delGoodslistUpgrade',
						type : 'post',
						data : {
							"id" : id
						},
						dataType : 'json',
						success : function(data) {
							// 删除后渲染数据列表
							alert("成功");

						}
					});
					$(this).parent().parent().remove();
				});
			})
		},
		error : function() {
			console.log("请求数据失败!");
		}
	})

})