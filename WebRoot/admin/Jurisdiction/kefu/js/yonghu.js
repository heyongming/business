$(function() {
	show(); /*初始化*/
	function show() {
		$.ajax({
			url : "/business/customer/getFullUserIp",
			type : 'post',
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				renderData(data);
			}
		});
	}
	// 封装渲染数据列表
	function renderData(data) {
		// 数据解析和渲染
		var tag = '';
		$.each(data, function(i, e) {
			tag += '<tr>' +
				'<td >' + e.ip + '</td>' +
				'<td tag=' + e.userId + '>' + e.user.userName + '</td>' +

				'<td><a href="javascript:;" class="layui-btn layui-btn-mini">查看</a></td>' +
				'</tr>';
		});
		$('#content').append(tag);
		// 给修改和删除按钮绑定单击事件
		$('#content tr').each(function(i, e) {
			var td = $(e).find('td:last-of-type');
			var ip = $(e).find('td:eq(0)').text(); //ID
			var id = $(e).find('td:eq(1)').attr("tag"); //ID

			// 给查看按钮绑定事件
			td.find('a:eq(0)').click(function() {
				//先弹出
				$("#j_mask").css("display", "block");
				$("#j_formAdd").css("display", "block");
				//关闭
				$("#j_hideFormAdd").click(function() {
					$("#j_mask").css("display", "none");
					$("#j_formAdd").css("display", "none");
				});
				updateData(ip, id);
			});
		});
	}
	//查看操作
	function updateData(ip, id) {
		$.ajax({
			url : "/business/customer/findIdAndUserId",
			type : 'post',
			data : {
				"ip" : ip,
				"userId" : id
			},
			dataType : 'json',
			success : function(data) {
				var tag = "";
				$.each(data, function(i, e) {
					tag += '<li><span>时间:'+e.queryTime+'</span>&nbsp;&nbsp;&nbsp;&nbsp;内容:'+e.questions+'</li>';
				});
				$('#liuyanUl').html(tag);
			}
		});
	}
})