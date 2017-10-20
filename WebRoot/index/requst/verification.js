$(function() {
	$("#immediately .sub").click(function() {
		let idCard = $("#activation .idCard").val();
		let activationCode = $("#activation .activationCode").val();
		let objRegExp = /^\d{6}$/;
		let isTrue = objRegExp.test(idCard);
		if (isTrue == false) {
			alert("身份证错误");
			return;
		}
		objRegExp = /^\w{8}$/;
		isTrue = objRegExp.test(activationCode);
		if (isTrue == false) {
			alert("激活码格式错误");
			return;
		}
		$(".spinner").show();
		$.ajax(
			{
				url : "/business/mp/activation",
				data : {
					"idCard" : idCard,
					"activationCode" : activationCode
				},
				dataType : 'json',
				success : function(data) {
					$(".spinner").hide();
					if (data.success == "true") {
						location.href = "/business/mp/service";
					} else {
						alert(data.errMsg)
					}

				},
				error:function(XMLHttpRequest, textStatus, errorThrown)
				{
					$(".spinner").hide();
					alert("出现未知错误，请与客服联系，为您造成的不便，敬请谅解"+"状态码"+XMLHttpRequest.status+"错误信息"+XMLHttpRequest.readyState)
					
				}
			}
		)
	})

})