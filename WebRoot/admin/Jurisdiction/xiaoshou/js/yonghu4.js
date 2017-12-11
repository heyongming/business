$(function() {
	//提交
	$.ajax({
		url : "/business/goods/getAllData",
		dataType : "json",
		type : "post",

		success : function(data) {
			var tag = '';
			$.each(data, function(i, e) {
			
				tag += "<option value="+e.goodsId+">"+e.goodsName+"</option>";
			});
			$("#product").append(tag)
		},
		error : function() {
			alert("上传失败");
		}
	})

	$("#button").click(function() {
		//文本框验证
		var arrInput = [
			{
				a : "name",
				b : "客户姓名"
			},
			{
				a : "phone",
				b : "客户手机号"
			},
			{
				a : "tuiJian",
				b : "客户推荐码"
			},
			{
				a : "jingLi",
				b : "业务经理"
			},
			{
				a : "yewuyuan",
				b : "业务员"
			},
			{
				a : "tel",
				b : "开单手机号"
			},
			{
				a : "weixinhao",
				b : "开单微信号"
			},
			{
				a : "date",
				b : "开单日期"
			},
			{
				a : "money",
				b : "产品金额"
			},
			{
				a : "dingDan",
				b : "支付订单号"
			} ];
		inputContent(arrInput);
		//单选验证
		var arrRadio = [
			{
				a : "fukuan",
				b : "付款方式"
			},
			{
				a : "shengJi",
				b : "是否升级"
			},
			{
				a : "faPiao",
				b : "是否需要发票"
			} ];
		checkRadio(arrRadio);
		var formData = new FormData();
		formData.append("customerName", $("#name").val()); //客户姓名
		formData.append("customerPhone", $("#phone").val()); //客户手机号
		formData.append("customerPhoneRdCode", $("#tuiJian").val()); //客户推荐码
		formData.append("serviceManager", $("#jingLi").val()); //业务经理
		formData.append("serviceSalesman", $("#yewuyuan").val()); //业务员
		formData.append("orderPhone", $("#tel").val()); //开单手机号
		formData.append("orderWxId", $("#weixinhao").val()); //开单微信号
		formData.append("orderDate", $("#date").val()); //开单日期
		formData.append("goodsId", $("#product").val()); //产品名称
		formData.append("allPrice", $("#money").val()); //产品金额
		formData.append("payMthod", $("input[name=fukuan]:checked").val()); //付款方式

		formData.append("file", $("#photo")[0].files[0], $("#photo")[0].files[0].name); //支付凭证

		formData.append("orderNumber", $("#dingDan").val()); //支付订单号
		formData.append("isUpgrade", $("input[name=shengJi]:checked").val()); //是否升级
		formData.append("isInvoice", $("input[name=faPiao]:checked").val()); //是否需要发票
		$.ajax({
			url : "/business/salesman/insertSalManSuuces",
			dataType : "json",
			type : "post",
			processData : false,
			contentType : false,
			data : formData,
			success : function(data) {
				alert(data.errMsg)
			},
			error : function() {
				alert("上传失败");
			}
		})
	})
	//input验证必填
	function inputContent(arrInput) {
		for (var i = 0; i < arrInput.length; i++) {
			if (document.getElementById(arrInput[i].a).value == "") {
				alert('请输入----' + arrInput[i].b);
				return false;
			}
		}

	}
	//单选按钮必选验证
	function checkRadio(arrRadio) {
		for (var i = 0; i < arrRadio.length; i++) {
			if ($('input:radio[name="' + arrRadio[i].a + '"]:checked').val() == null) {
				alert('请输入----' + arrRadio[i].b);
				return false;
			}
		}

	}
})