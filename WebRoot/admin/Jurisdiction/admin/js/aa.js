$(function(){

    //�����Ϣ
    $("#add").click(function(){
        $("#j_mask").css("display","block");
        $("#j_formAdd").css("display","block");
        //�ر�

        $("#j_hideFormAdd").click(function () {
            $("#j_mask").css("display","none");
            $("#j_formAdd").css("display","none");
        });
        addSubmit();

    });
    /*�޸�����*/
    $("#content>tr>td:last-child>a:first-child").click(function(){
        $.ajax({
            url:"aa",
            data:{
                goodsId:goodsId
            },
            success:function(data){
                /*������ʾ*/
                $("#j_mask").css("display","block");
                $("#j_formAdd").css("display","block");
                /*��ʾ����Ϣ*/
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
    /*ɾ��*/
    $("#content>tr>td:last-child>a:last-child").click(function(){
        $.ajax({
            url:"delete",
            data:{
                goodsId:goodsId
            },
            success:function(data){
                $(this).parent().parent().remove();//ɾ��tr
                alert("ɾ���ɹ�");
            }
        })
    });

})

function addSubmit(){
    /*����ύ���ݣ����*/
    $("#submit").click(function(){
        //����һ��FormData����Ȼ��form��Ϊ�������뵽FormData����
        /*��ȡ����*/
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
                alert("��ӳɹ���");
                /*�ɹ��󣬴Ӻ�̨��������Ⱦ��ҳ����*/
                $.ajax({
                    url:"c",
                    success:function(data){
                        /*ģ��ƴ����Ⱦ*/
                        var tag=template("tableTem",data);
                        $("#content").append(tag);
                    }
                })
            }
        })

    })
}