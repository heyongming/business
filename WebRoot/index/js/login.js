$(function(){

    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    // ��֤�û���
    $('input[name="username"]').blur(function(){
        if($(this).val().length == 0){
            alert("��������������");
        }else{
            ok1=true;
        }
    });

    //��֤�ֻ���
    $('input[name="tel"]').blur(function(){
        var pattern= /^1[358]\d{9}$/;
        if($(this).val().length == 0 ||!pattern.test(tel.value)){
            alert("�����������ֻ���");
        }else{
            ok2=true;
        }

    });
    //��֤��֤��
    $('input[name="password"]').blur(function(){
        var pattern= /^\d{6}$/;
        if($(this).val().length !== 6 || !pattern.test(tel.value)){
            alert("��֤�벻��ȷ");
        }else{
            ok3=true;
        }
    });
    //�Ƽ���
    $('input[name="recommended"]').blur(function(){
        var pattern= /^\d{6}$/;
        if($(this).val().length !== 6 || !pattern.test(tel.value)){
            alert("�Ƽ��Ų���ȷ");
        }else{
            ok4=true;
        }
    });

    //�ύ��ť,������֤ͨ�������ύ
    $('#btnbox').click(function(){
        if(ok1 && ok2 && ok3 && ok4){
            $('form').submit();
        }else{
            return false;
        }
    });

});