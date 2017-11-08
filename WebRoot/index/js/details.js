$(function(){
    $(".btn-primary").click(function(){
        $('.modal').css('display',"block");
        $('.modal-dialog').css('display',"block");
        $('.modal').click(function(){
            $(".modal").hide();
            $('.modal-dialog').hide();
            location.reload();
        });
        var productId = $("#productId").text();  //产品id
        
        $.ajax({
            url:"/business/goods/getgoodsListById",
            dataType:"json",
            type:"post",
            data:{
                "goodsId":productId
            },
            success:function(data) {
                //数据渲染
                buyTem(data);
            }
        })
    })
    //弹窗详情
    function buyTem(data) {
        var tag = '<div class="modal-content">' +
        			'<div class="top">' +
        			'<div class="img">' +
        			'<img class="productImg" src="' + data.imageUrl + '" alt=""/>' +
        			'</div>' +
        			'<div>' +
        			'<p class="productTitle more" data-goodsId="' + data.goodsId + '">' + data.goodsName + '</p>' +
        			'<span class="danjia" style="display:none" >' + data.goodsPrice + '</span>' +
        			'<p class="num">已选份数*<span></span></p>' +
        			'<p class="price" style="display:none">￥<span class="zongjia"></span></p>' +
        			'</div>' +
        			'</div>' +
        			'<div class="middle">' +
        			'<div class="left">购买几份</div>' +
        			'<div class="right">' +
        			'<input class="min" name="" type="button" value="-" />' +
        			'<input class="text_box" readonly="readonly" name="" type="text" value="1" />' +
        			'<input class="add" name="" type="button" value="+" />' +
        			'</div>' +
        			'</div>' +
        			'<submit class="bottom"><a>确认</a></submit>' +
        			'</div>';
        $(".modal-dialog").append(tag);
        total();
        //获得文本框对象
        var t = $(".text_box");   //份数
        //初始化数量为1,并失效减
        $('.min').attr('disabled', true);
        //数量增加操作
        $(".add").click(function () {
            // 给获取的val加上绝对值，避免出现负数
            t.val(Math.abs(parseInt(t.val())) + 1);
            if (parseInt(t.val()) != 1) {
                $('.min').attr('disabled', false);
            }
            ;
            total();
        });
        //数量减少操作
        $(".min").click(function () {
            t.val(Math.abs(parseInt(t.val())) - 1);
            if (parseInt(t.val()) == 1) {
                $('.min').attr('disabled', true);
            }
            ;
            total();
        });
        //提交
        $(".bottom").click(function () {
            var goodsId = $(".productTitle").attr("data-goodsId");
            var paymentNumber = $(".num").find("span").val();
            $.ajax({
                url: "/business/order/saveBuyGoods",
                data: {
                    "goodsId": goodsId,
                    "paymentNumber": paymentNumber,
                },
                dataType: 'json',
                success: function (data) {
                   
                    location.href = "/business/index/login.jsp";
                }
            });
        });
    }
//封装商品数量操作
    function total(){
        var allprice =0; //默认商品总价
        var num = parseInt($(".text_box").val()); //商品数量
        var price = parseInt($(".danjia").text()); //商品单价
        var total = price * num; //计算商品总价
        allprice += total;
        $(".num").children("span").text(num.toFixed(0));
        $(".price").children("span").text(allprice.toFixed(0));
    }

})