$(function(){

    //点击问题类型
    $(".sel").click(function(){
        $("#mask").show();
    })
    $("#mask_bg").click(function(){
        $("#mask").hide();
    })
    $(".shut").click(function(){
        $("#mask").hide();
    })
    $(".questUl li").click(function(){
        var aa = $(this).html();
        $("#questMes").val(aa);
        $("#mask").hide();
    })
    //提交
    $("#btn").click(function(){
        var textarea = $("#textarea").val();
        var questMes = $("#questMes").val();
        var phone = $("#phone").val();
        if(textarea==""){
            alert("问题描述不能为空");
            return false;
        }
        if(questMes==""){
            alert("请选择问题类型");
            return false;
        }
        if(!(/^1[34578]\d{9}$/.test(phone))){
            alert("手机号码有误，请重填");
            return false;
        }
        var formData = new FormData();
    //    console.log($("#imageUrl")[0].files[0])                             
        formData.append("file",$("#file")[0].files[0],$("#file")[0].files[0].name);  //问题描述
        formData.append("messageContent",textarea);  //问题描述
        formData.append("messageType",questMes);  //问题类型
        formData.append("phone",phone);  //电话
        $.ajax({
            url:"/business/customer/insertMessageContent",
            dataType:"json",
            type:"post",
            data:formData,
            processData:false,
            contentType:false,
            success:function(){
                alert("提交成功");
           //     location.href="kefu.html"
            }
        })
    })
})