$(function(){

    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    // 验证用户名
    $('input[name="username"]').blur(function(){
        if($(this).val().length == 0){
            alert("请输入您的名字");
        }else{
            ok1=true;
        }
    });

    //验证手机号
    $('input[name="tel"]').blur(function(){
        var pattern= /^1[358]\d{9}$/;
        if($(this).val().length == 0 ||!pattern.test(tel.value)){
            alert("请输入合理的手机号");
        }else{
            ok2=true;
        }

    });
    //验证验证码
    $('input[name="password"]').blur(function(){
        var pattern= /^\d{6}$/;
        if($(this).val().length !== 6 || !pattern.test(tel.value)){
            alert("验证码不正确");
        }else{
            ok3=true;
        }
    });
    //推荐号
    $('input[name="recommended"]').blur(function(){
        var pattern= /^\d{6}$/;
        if($(this).val().length !== 6 || !pattern.test(tel.value)){
            alert("推荐号不正确");
        }else{
            ok4=true;
        }
    });

    //提交按钮,所有验证通过方可提交
    $('#btnbox').click(function(){
        if(ok1 && ok2 && ok3 && ok4){
            $('form').submit();
        }else{
            return false;
        }
    });

});