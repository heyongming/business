/**
 * Created by Administrator on 2017/6/22.
 */
/*通过ajax获取数据*/
/*
$(function(){
    //获取导航数据
    getNav();
    function getNav(){
        $.ajax({
            url:"aa.php",
            dataType:"json",
            success:function(data){
                //console.log(data);
                var tem = template("navTem",data);
                $("#nav").html(tem);
                /!*给第一个li添加样式*!/
                $("#nav").find("a").eq(0).addClass("active");
                /!*给a点击事件*!/
                $("#nav").find("a").click(function(){
                    /!*排他*!/
                    $("#nav").find("a").removeClass("active");
                    $(this).addClass("active");
                    var lis = $("#nav").find("a");
                    /!*获取当前点击a的titleid*!/
                    var thisTitleId=$(this).attr("data-titleid");

                    /!*点击当前a，列表显示对应的信息*!/
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
                /!*点击之前，默认显示热门的列表信息*!/
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


