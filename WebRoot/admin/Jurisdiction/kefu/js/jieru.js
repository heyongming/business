$(function() {
	//富文本编辑器操作
	var ue = UE.getEditor('wordContent');
	show(); /*初始化*/
	function show() {
		$.ajax({
			url : "/business/customer/getWelcome",
			type : 'post',
			dataType : 'json',
			success : function(data) {
				// 渲染富文本编辑器
			//	data=JSON.parse(data); 
				var t2 = window.setTimeout(function()
						{
					ue.setContent(data.errMsg);
						},3000);
				
			//	addData();
			}
		});
	}
	$("#btn").click(function() {
		// 获取所有的表单数据
		
		var wordContent = ue.getContent(); //获取富文本编辑器内容
		var formData = new FormData();
		formData.append("title", wordContent); //回复内容
		$(".spinner").show();
		$.ajax({
			type : 'post',
			url : '/business/customer/SetWelcome',
			data : formData,
			processData : false,
			contentType : false,
			dataType : 'json',
			success : function(data) {
				// 渲染数据列表
				$(".spinner").hide();
				if (data.success == "true") {
				//	show();
				} else {
					alert(data.errMsg)
				}
			},
			error : function() {
				alert("shibai")
			}
		});
		return false;
	});

})