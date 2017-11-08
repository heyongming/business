/*通过ajax获取数据*/
$(function() {
	Date.prototype.Format = function(fmt) { //author: meizz
		var o = {
			"M+" : this.getMonth() + 1, //月份
			"d+" : this.getDate(), //日
			"h+" : this.getHours(), //小时
			"m+" : this.getMinutes(), //分
			"s+" : this.getSeconds(), //秒
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度
			"S" : this.getMilliseconds() //毫秒
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		for (var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	var date = new Date().Format("yyyy-MM-dd"); //获取完整日期  17:41:42 GMT+0800 (中国标准时间)


	$(".spinner").show();
	$.ajax({
		url : "/business/mp/gethistory",
		dataType : "json",
		type : "post",
		data : {
			"date" : date
		},
		success : function(data) {
			$(".spinner").hide();
			var tag = "";
			let cout = 0;
			$.each(data, function(i, e) {
				tag += '<a href="/business/mp/serviceArticle?serviceArticleNum=' + e.serviceArticleNum + '">' +
					'<div class="left">' +
					'<p>' + e.serviceArticleTitle + '</p>' +
					'<p class="date">' + e.currentDate + '</p>' +
					'</div>' +
					'<img src="' + e.thumbnail + '" alt=""/>' +
					'</a>';
				cout = cout + 1;
			}

			);
			
			if (cout == 0) {
				$("#noMessage").show();
				return;
			}
			$(".news").html(tag);
		},
		error : function() {
			$("#noMessage").show();
		}
	})

	$("#mytable tr td").click(function() {
		$("#mytable tr td").removeAttr("class");
		$(this).attr("class", "active");
		// alert($(this).index())
		var num = $(this).index();
		// alert(num)
		// alert($(".newtime").find("input").eq(num).val())
		$(".datetime").find("input").val($(".newtime").find("input").eq(num).val());
		var date = $(".datetime").find("input").val();
		var dt = new Date(date.replace(/-/, "/")).Format("yyyy-MM-dd");
		$(".spinner").show();
		$.ajax({
			url : "/business/mp/gethistory",
			dataType : "json",
			type : "post",
			data : {
				"date" : dt
			},
			success : function(data) {
			
				$(".spinner").hide();
				console.log(data)
				var tag = "";
				let cout = 0;
				$.each(data, function(i, e) {
					tag += '<a href="/business/mp/serviceArticle?serviceArticleNum=' + e.serviceArticleNum + '">' +
						'<div class="left">' +
						'<p>' + e.serviceArticleTitle + '</p>' +
						'<p class="date">' + e.currentDate + '</p>' +
						'</div>' +
						'<img src="' + e.thumbnail + '" alt=""/>' +
						'</a>';
					cout = cout + 1;
				});

				$("#mes").html("");
				if (cout == 0) {
					$("#noMessage").show();
					return;
				}
				
				$("#mes").html(tag);
				$("#noMessage").hide();
				
			},
			error : function() {
				$("#noMessage").show();
			}
		})
	});
});