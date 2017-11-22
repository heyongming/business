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

    //获取当前时间
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
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
                tag+='<li>咨询订单</li>';
            })
            //动态获取问题列表
            $(".dhmes").html(tag);
            /* //客服回答
             var str= "";
             str+='<div class="answer">'+
             '<div class="left"><img src="images/logo.png" alt=""/></div>'+
             '<div class="right">'+
             '<div class="sanjiao"></div>'+
             '<p>客服回答客服回答客服回答客服回答客服回答</p>'+
             '<ul class="dhmes">'+
             /!*'<li>咨询订单</li>'+
             '<li>咨询订单</li>'+
             '<li>咨询订单</li>'+
             '<li>咨询订单</li>'+
             '<li>咨询订单</li>'+*!/
             '</ul>'+
             '</div>'+
             '</div>';
             $("#message").append(str);*/
            //客户发送消息
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
            //遍历问题，弹窗
            $(".dhmes li").each(function(){
                $(this).click(function(){
                    var suoYin = $(this).index();
                    //鼠标单击问题--弹窗
                    mask(suoYin);
                })
            })

        }
    })

    //鼠标单击问题--弹窗
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
        //根据索引，取得问题及回答
        $.ajax({
            url:"...",
            dataType:"json",
            type:"post",
            data:{
                "suoYin":suoYin
            },
            success:function(data){
                var tag = "";
                tag+='<div class="shut">×</div>'+
                    '<p>问题问题问题问题问题问题问题问题问题问</p>'+
                    '<div class="answer">'+
                    '<p>回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答回答</p>'+
                    '</div>'+
                    '<div class="db">'+
                    '是否对您有帮助：<span class="y1"><em class="yy"></em>有用</span><span class="y2"><em class="not"></em>没用</span>'+
                    '</div>';
                $("#mask_content").html(tag);
            }
        })
    }


})