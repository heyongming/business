$(function(){
    $
    /*点击填写评论，切换状态*/
    $(".amount p").click(function(){
        $("#msgBox #form").toggle();
    });
    /*点击提交*/
    $("#sendBtn").click(function(){
        /*文本域为空，则报错*/
        if ($("#conBox").val().trim() === "") {
            alert("请输入内容");
            return;
        }else{
            alert("提交成功");
            $("#form").hide();
        }

    })
})



/*用户填写评论，提交到后台，在显示到页面上的功能，暂时不用*/
/*
$.ajax({
    url:"dd.php",
    type:"json",
    success:function(data) {
        //判断一下后台是否让显示到页面上
        if(data.a==1){
            var li = document.createElement("li");
            var lis = $("#ul").children;
            li.innerHTML = '<div class="userPic"><img src="images/face.gif" /></div><div class="content"><div class="userName"><a href="javascript:;">����</a></div><div class="msgInfo">�г��Դ������ര���ڣ��г��������ϵ������Խ����������ֽ׶εĽṹ�������У���ֵ���ơ�ҵ�����ơ����ߴ߻���Ŀǰ�����ʽ��ע��������</div><div class="times"><span>07��05�� 15:14</span></div></div>';
            if (lis.length === 0) {
                $("#ul").appendChild(li);
            } else {
                $("#ul").insertBefore(li, lis[0]);
            }
            /!*清空文本域*!/
            $("#conBox").val() == "";
        }
    }
})*/
