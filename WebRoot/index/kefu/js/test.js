$(function(){
    $("#btn").click(function(){
        var a = 13;
        var b;
        var aa = new Cat(a);
        console.log(aa.a);
    });
    function Cat(a){
        console.log(a);
        this.a = a;
        b = a;
        console.log(a);
        console.log(b);
    }

    //��ȡ��ǰʱ��
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //�·�
            "d+": this.getDate(), //��
            "h+": this.getHours(), //Сʱ
            "m+": this.getMinutes(), //��
            "s+": this.getSeconds(), //��
            "q+": Math.floor((this.getMonth() + 3) / 3), //����
            "S": this.getMilliseconds() //����
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    var time = new Date().Format("yyyy-MM-dd hh:mm:ss");
    $(".date").html(time);
    $.ajax({
        url:",,,",
        dataType:"json",
        type:"post",
        success:function(data){
            var tag = "";
            $.each(data,function(i,e){
                tag+='<li>��ѯ����</li>';
            })
            //��̬��ȡ�����б�
            $(".dhmes").html(tag);
            /* //�ͷ��ش�
             var str= "";
             str+='<div class="answer">'+
             '<div class="left"><img src="images/logo.png" alt=""/></div>'+
             '<div class="right">'+
             '<div class="sanjiao"></div>'+
             '<p>�ͷ��ش�ͷ��ش�ͷ��ش�ͷ��ش�ͷ��ش�</p>'+
             '<ul class="dhmes">'+
             /!*'<li>��ѯ����</li>'+
             '<li>��ѯ����</li>'+
             '<li>��ѯ����</li>'+
             '<li>��ѯ����</li>'+
             '<li>��ѯ����</li>'+*!/
             '</ul>'+
             '</div>'+
             '</div>';
             $("#message").append(str);*/
            //�ͻ�������Ϣ
            $("#btn").click(function(){
                var text = $("#text").val();
                $.ajax({
                    url:"...",
                    dataType:"json",
                    type:"post",
                    data:{
                        "text":text
                    },
                    success:function(data){
                        var tag = "";
                        tag+='<div class="question">'+
                            '<div class="left">'+
                            '<div class="sanjiao"></div>'+
                            '<p>'+text+'</p>'+
                            '</div>'+
                            '<div class="right">'+
                            '<img src="images/logo.png" alt=""/>'+
                            '</div>'+
                            '</div>';
                        $("#message").append(tag);
                        $("#text").val("");
                        autoHeight()
                    }
                })
            })
            //�������⣬����
            $(".dhmes li").each(function(){
                $(this).click(function(){
                    var suoYin = $(this).index();
                    //��굥������--����
                    mask(suoYin);
                })
            })

        }
    })

    //��굥������--����
    function mask(suoYin){
        $("#mask_bg").click(function(){
            $("#mask").hide();
        })
        $(".shut").click(function(){
            $("#mask").hide();
        })
        $(".y1").click(function(){
            $(".yy").addClass("yyh");
            $("#dz").show();
        })
        $(".y2").click(function(){
            $(".not").addClass("noth");
            $("#mask_content").hide();
            $("#mask_sorry").show();
            $("#dz").hide();
        })
        //����������ȡ�����⼰�ش�
        $.ajax({
            url:"...",
            dataType:"json",
            type:"post",
            data:{
                "suoYin":suoYin
            },
            success:function(data){
                var tag = "";
                tag+='<div class="shut">��</div>'+
                    '<p>��������������������������������������</p>'+
                    '<div class="answer">'+
                    '<p>�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�ش�</p>'+
                    '</div>'+
                    '<div class="db">'+
                    '�Ƿ�����а�����<span class="y1"><em class="yy"></em>����</span><span class="y2"><em class="not"></em>û��</span>'+
                    '</div>';
                $("#mask_content").html(tag);
            }
        })
    }


})