(function ($) {
    $.extend({
        tipsBox: function (options) {
            options = $.extend({
                obj: null,  //jq����Ҫ���Ǹ�html��ǩ����ʾ
                str: "+1",  //�ַ�����Ҫ��ʾ������;Ҳ���Դ�һ��html����: "<b style='font-family:Microsoft YaHei;'>+1</b>"
                startSize: "12px",  //������ʼ�����ִ�С
                endSize: "30px",    //�������������ִ�С
                interval: 600,  //����ʱ����
                color: "red",    //������ɫ
                callback: function () { }    //�ص�����
            }, options);
            $("body").append("<span class='num'>" + options.str + "</span>");
            var box = $(".num");
            var left = options.obj.offset().left + options.obj.width() / 2;
            var top = options.obj.offset().top - options.obj.height();
            box.css({
                "position": "absolute",
                "left": left + "px",
                "top": top + "px",
                "z-index": 9999,
                "font-size": options.startSize,
                "line-height": options.endSize,
                "color": options.color
            });
            box.animate({
                "font-size": options.endSize,
                "opacity": "0",
                "top": top - parseInt(options.endSize) + "px"
            }, options.interval, function () {
                box.remove();
                options.callback();
            });
        }
    });
})(jQuery);

function niceIn(prop){
    prop.find('i').addClass('niceIn');
    setTimeout(function(){
        prop.find('i').removeClass('niceIn');
    },1000);
}
$(function () {
    $("#btn").click(function () {
        $.tipsBox({
            obj: $(this),
            str: "+1",
            callback: function () {
            }
        });
        niceIn($(this));
    });
});