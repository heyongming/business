$(function() {

    //检测浏览器是否支持websocket
    if(window.WebSocket){
        ws = new WebSocket("ws://m.mbimc.com/business/testws");
        //连接成功，发送数据
        ws.onopen = function (data) {
            alert('连接成功');
            //接入语
            var joinUp = {
                "method":1,
                "data":"",
                "result":""
            };
            var joinUpData = JSON.stringify(joinUp);
            ws.send(joinUpData);
            //拿列表
            var listUp = {
                "method":2,
                "data":"",
                "result":""
            };
            var listUpData = JSON.stringify(listUp);
            ws.send(listUpData);
            btnEvent();

            //机器人文本域事件
            var text;
            var ip;
            $("#text").bind('input propertychange',function(){
                ip = $("#ip").html();
                text = $("#text").val();
                if(text==""){ //文本域为空
                    jiqiText();
                } else {
                    $(".addMes").hide();
                    $(".add").hide();
                    $("#btn").show();
                    $("#text").css("width","5rem");
                }
            })
            //机器人提交文本域内容
            $("#btn").click(function(){
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
                jiqiText();
                $("#text").val("").focus();
                autoHeight();
                //列表
                var keyword = {
                    "method":4,
                    "data":{
                        "ip":ip,
                        "questions":text
                    },
                    "result":""
                };
                var keywordData = JSON.stringify(keyword);
                ws.send(keywordData);
            })
        }
        //接收数据
        ws.onmessage = function (data) {
            var data = JSON.parse(data.data);
            var method = JSON.parse((data.method));

            //获得接入语数据
            if(method==1){
                var data = JSON.parse((data.result));
                $("#jieru").html(''+ data.errMsg+'');
            }
            //获取列表数据
            if(method==2){
                var data = JSON.parse((data.result));
                var data = JSON.parse((data.errMsg));
                var str = "";
                $.each(data,function(i,e){
                    str+='<li data-id="'+data[i].fdid+'">'+data[i].problem+'</li>';
                })
                $(".dhmes").html(str);   //了解列表
                //遍历问题，弹窗
                $(".dhmes li").each(function(){
                    $(this).click(function(){
                        var id = $(this).attr("data-id");
                        var content = $(this).html();
                        //鼠标单击问题--弹窗
                        var tag = "";
                        tag+='<div class="question">'+
                            '<div class="left">'+
                            '<div class="sanjiao"></div>'+
                            '<p>'+content+'</p>'+
                            '</div>'+
                            '<div class="right">'+
                            '<img src="images/logo.png" alt=""/>'+
                            '</div>'+
                            '</div>';
                        $("#message").append(tag);
                        var list = {
                            "method":3,
                            "data":id,
                            "result":""
                        };
                        var listData = JSON.stringify(list);
                        ws.send(listData);

                    })
                })
            }
            //获取列表数据回答
            if(method==3){
                var data = JSON.parse((data.result));
                var data = JSON.parse((data.errMsg));
                var tag = "";
                tag+='<div class="answer">'+
                    '<div class="left"><img src="images/logo.png" alt=""/></div>'+
                    '<div class="right">'+
                    '<div class="sanjiao"></div>'+
                    '<p>'+data.answer+'</p>'+
                    '</div>'+
                    '</div>';
                $("#message").append(tag);  //  机器回答
                $("#text").val("").focus();
                autoHeight();
            }
            //根据关键词回答
            if(method==4){
                var data = JSON.parse((data.result));
                if(data.code<0){
                    var tag = "";
                        tag+='<div class="answer">'+
                            '<div class="left"><img src="images/logo.png" alt=""/></div>'+
                            '<div class="right">'+
                            '<div class="sanjiao"></div>'+
                            '<p>'+data.errMsg+'</p>'+
                            '</div>'+
                            '</div>';
                    $("#message").append(tag);  //  机器回答
                    $("#text").val("").focus();
                    autoHeight();
                    return;
                }
                var data = JSON.parse((data.errMsg));
                var tag = "";
                $.each(data,function(i,e){
                    tag+='<div class="answer">'+
                        '<div class="left"><img src="images/logo.png" alt=""/></div>'+
                        '<div class="right">'+
                        '<div class="sanjiao"></div>'+
                        '<p>'+data[i].replyContent+'</p>'+
                        '</div>'+
                        '</div>';
                })

                $("#message").append(tag);  //  机器回答
                $("#text").val("").focus();
                autoHeight();
            }
        }
        //关闭连接
        ws.onclose = function (e) {
            //e  CloseEvent对象
            //e.code 关闭代码编号标识
            //e.reason 关闭原因
            console.info(e);
            alert('链接已经关闭');

        }
        //异常连接
        ws.onerror = function (e) {
            console.info(e);
            alert('发生异常:'+e.message);
            location.href = document.referrer;
        }
    }
    else{
        alert("WebSocket was not supported");
    }
    //机器人,文本域为空
    function jiqiText(){
        $(".add").show();
        $("#btn").hide();
        $("#text").css("width","5.5rem");
    }
    //点击评价等事件
    function btnEvent(){
        //点击加号
        $(".add").click(function(){
            $(".addMes").toggle();
        })
        //点击评价
        $(".evaluate").click(function(){
            $(".db").show();
            $("#jiQi").hide();
            $("#footer").css("background-color","#fff");
        })
        //点击有用
        $(".y1").click(function(){
            $(".yy").addClass("yyh");
            $("#dz").show();
        })
        //点击无用
        $(".y2").click(function(){
            $(".not").addClass("noth");
            $(".yy").removeClass("yyh");
            $("#dz").hide();
            $("#mask").show();
        })
        //点击留言
        $(".words").click(function(){
            location.href="liuyan.html"
        })
        $("#wordsBtn").click(function(){
            location.href="liuyan.html"
        })
        //点击弹窗
        $("#mask_bg").click(function(){
            $("#mask").hide();
            $(".db").hide();
            $("#jiQi").show();
        })
        $(".shut").click(function(){
            $("#mask").hide();
            $(".db").hide();
            $("#jiQi").show();
        })
    }
    //自动高度
    function autoHeight() {
        var message_height = $('#message').height();
        $('#message,body,html').animate({
            scrollTop:message_height
        }, 500);
    }

})