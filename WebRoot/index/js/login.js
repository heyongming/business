
$(function() {
	//获取手机验证码
	$("#j_getVerifyCode").on("click", getVerifyCode({
		callBack : function() { //按钮点击后的回调函数，-----必须-----
			//在这里你还是可以对你的按钮进行操作
			//console.log(this);
			alert("验证码发送成功");
			console.log($("#j_phone").val());

			//将手机号传到后台

			$.ajax({
				url : "/business/user/sendVcode",
				data : {
					"phone" : $("#j_phone").val()
				},
				success : function(data) {
					console.log(data);
				}
			});
		},
		time : 60, //定时时间，以秒为单位，默认60秒
		getCurrentTime : function(time) { //获取倒计时当前时间
			//console.log(time);
			//console.log(this);//这里的这个this执行按钮
			//console.log("=================================");
		},
		isPhone : true, //是否为发送手机验证码，如果是则会验证手机号格式，-----必须-----
		getPhone : function() { //获取手机号，此处一定要return
			return $("#j_phone").val();

		},
		//phoneReg: /^1[34578]\d{9}$/,//手机号验证正则
		phoneCallBack : function() { //当手机号有误时的回调，默认会中止操作
			alert("您输入的手机号有误");
		},
		timeIsUpText : "重新发送", //倒计时时间到了后按钮所显示文字
		timeRunnigText : "s后重新发送", //倒计时时间正在走的时候按钮所显示文字。默认为"xxs后重新获取"
		unabledClass : "unlabed" //按钮不能用的样式，即点击按钮后的样式
	}));

	/*表单提交*/
	$("#btn").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var recommended = $("#recommended").val();
		var myreg = /[\u4e00-\u9fa5A-Za-z]{2,}/;
		if (!myreg.test(username)) {
			alert("名字至少两个字");
			return false;
		}

		var number = /^\d{6}$/;
		if (!number.test(password)) {
			alert("请输入6位推荐码数字验证码");
			return false;
		}

		var shuzi = /^\d{6}$/;
		if (!shuzi.test(recommended)) {
			alert("请输入6位数字推荐码");
			return false;
		}

		/*提交数据*/
		$.ajax({
			url : "",
			data : {},
			success : function(data) {
				console.log(data);
				location.href = '../maibutest/buy01.html'
			}
		});
	})

})