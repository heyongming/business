/**
 * Created by Administrator on 2017/6/22.
 */
/*ͨ��ajax��ȡ����*/
/*
$(function(){
    //��ȡ��������
    getNav();
    function getNav(){
        $.ajax({
            url:"aa.php",
            dataType:"json",
            success:function(data){
                //console.log(data);
                var tem = template("navTem",data);
                $("#nav").html(tem);
                /!*����һ��li�����ʽ*!/
                $("#nav").find("a").eq(0).addClass("active");
                /!*��a����¼�*!/
                $("#nav").find("a").click(function(){
                    /!*����*!/
                    $("#nav").find("a").removeClass("active");
                    $(this).addClass("active");
                    var lis = $("#nav").find("a");
                    /!*��ȡ��ǰ���a��titleid*!/
                    var thisTitleId=$(this).attr("data-titleid");

                    /!*�����ǰa���б���ʾ��Ӧ����Ϣ*!/
                    $.ajax({
                        url:"cc.php",
                        data:{titleid:thisTitleId},
                        success:function(data){
                            //console.log(data);
                            var tem = template("productTem",data);
                            $("#product").html(tem);
                        }
                    });
                });
                /!*���֮ǰ��Ĭ����ʾ���ŵ��б���Ϣ*!/
                var titleid=data.result[0].titleId;
                $.ajax({
                    url:"cc.php",
                    data:{titleid:titleid},
                    success:function(data){
                        //console.log(data);
                        var tem = template("productTem",data);
                        $("#list").html(tem);
                    }
                });
            }
        });
    }
});*/


