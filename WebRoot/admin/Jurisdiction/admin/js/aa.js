$(function(){

    //添加信息
    $("#add").click(function(){
        $("#j_mask").css("display","block");
        $("#j_formAdd").css("display","block");
        //关闭

        $("#j_hideFormAdd").click(function () {
            $("#j_mask").css("display","none");
            $("#j_formAdd").css("display","none");
        });
        addSubmit();

    });
    /*修改数据*/
    $("#content>tr>td:last-child>a:first-child").click(function(){
        $.ajax({
            url:"aa",
            data:{
                goodsId:goodsId
            },
            success:function(data){
                /*弹窗显示*/
                $("#j_mask").css("display","block");
                $("#j_formAdd").css("display","block");
                /*显示旧信息*/
                $("#goodsId").val(data.goodsId);
                $("#imageUrl").val(data.imageUrl);
                $("#goodsName").val(data.goodsName);
                $("#goodsTypeId").val(data.goodsTypeId);
                $("#weight").val(data.weight);
                $("#goodsPrice").val(data.goodsPrice);
                $("#inventory").val(data.inventory);
                $("#salesVolume").val(data.salesVolume);
                $("#hotGoods").val(data.hotGoods);
                $("#isShelves").val(data.isShelves);
                addSubmit();
            }
        })
    });
    /*删除*/
    $("#content>tr>td:last-child>a:last-child").click(function(){
        $.ajax({
            url:"delete",
            data:{
                goodsId:goodsId
            },
            success:function(data){
                $(this).parent().parent().remove();//删除tr
                alert("删除成功");
            }
        })
    });

})

function addSubmit(){
    /*点击提交数据，添加*/
    $("#submit").click(function(){
        //创建一个FormData对象，然后将form作为参数传入到FormData对象
        /*获取数据*/
        var formData = new FormData();
        formData.append("goodsId", $("#goodsId").val());
        formData.append("imageUrl", $("#imageUrl")[0].files[0], $("#imageUrl")[0].files[0].name);
        formData.append("goodsName", $("#goodsName").val());
        formData.append("goodsTypeId", $("select[name='goodsTypeId']").val());
        formData.append("weight", $("#weight").val());
        formData.append("goodsPrice", $("#goodsPrice").val());
        formData.append("inventory", $("#inventory").val());
        formData.append("salesVolume", $("#salesVolume").val());
        formData.append("hotGoods", $("select[name='hotGoods']").val());
        formData.append("isShelves", $("select[name='isShelves']").val());
        console.log(formData);
        $.ajax({
            url:"add",
            type: 'post',
            data: formData,
            dataType: 'json',
            success:function(){
                alert("添加成功！");
                /*成功后，从后台拿数据渲染到页面上*/
                $.ajax({
                    url:"c",
                    success:function(data){
                        /*模板拼接渲染*/
                        var tag=template("tableTem",data);
                        $("#content").append(tag);
                    }
                })
            }
        })

    })
}