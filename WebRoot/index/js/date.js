window.onload = function() {
    initDate()
};
var currDT;
var lastDay; //页面显示的最后一天
var firstDay; //页面显示的第一天
var date = new Date; //获取完整日期  17:41:42 GMT+0800 (中国标准时间)
var year = date.getFullYear(); //获取当前年份   2017

//初始化日期加载
function initDate() {
    currDT = new Date(); //获取完整日期  17:41:42 GMT+0800 (中国标准时间)
    //showdate.innerHTML = currDT.toLocaleDateString(); //显示日期  2017/11/3
    showdate.innerHTML = currDT.getFullYear()+ "年" + (currDT.getMonth() + 1)+"月"; //显示
    var dw = currDT.getDay(); //从Date对象返回一周中的某一天(0~6)  周五
    var tdDT; //日期

    //在表格中显示一周的日期
    var objTB = document.getElementById("mytable"); //取得表格对象
    for (var i = 0; i < 7; i++) {
        tdDT = getDays()[i];

        dw = tdDT.getDay(); //星期几
        var dwdd = tdDT.getDate(); //月份的某一天
        if(dwdd<10) dwdd = '0' + dwdd;
        objTB.rows[0].cells[i].innerHTML = /*tdDT.getMonth() + 1 + "月" + */dwdd/* + "日 星期" + aryDay[dw]*/; //显示
        var newtime = '<input type="text" value="' + year + "-" + (tdDT.getMonth() + 1) + "-" + tdDT.getDate() + '">';
        $(".newtime").append(newtime);

        if (tdDT.toLocaleDateString() == currDT.toLocaleDateString()) {
  //          objTB.rows[0].cells[i].style.color = "white"; //currDT突出显示
   //         objTB.rows[0].cells[i].style.backgroundColor = "#1e9be8"; //currDT突出显示
        	$(objTB.rows[0].cells[i]).addClass("active")
            
            $(".datetime").find("input").val($(".newtime").find("input").eq(i).val())
            // alert($(".newtime").find("input").eq(i).val())
        }
    }
    //重新赋值
    lastDay = getDays()[6]; //本周的最后一天
    firstDay = getDays()[0]; //本周的第一天+ "年" + (currDT.getMonth()

  
}

//取得当前日期一周内的某一天

function getWeek(i) {
    var now = new Date();
    var n = now.getDay();
    var start = new Date();
    start.setDate(now.getDate() - n + i); //取得一周内的第一天、第二天、第三天...
    return start;
}

//取得当前日期一周内的七天

function getDays() {
    var days = new Array();
    for (var i = 1; i <= 7; i++) {
        days[i - 1] = getWeek(i);
    }
    return days;
}

//取得下一周的日期数(共七天)

function getNextWeekDatas(ndt) {
    var days = new Array();
    for (var i = 1; i <= 7; i++) {
        var dt = new Date(ndt);
        days[i - 1] = getNextWeek(dt, i);
    }
    return days;
}

//指定日期的下一周(后七天)

function getNextWeek(dt, i) {
    var today = dt;
    today.setDate(today.getDate() + i);
    return today;
}


//取得上一周的日期数(共七天)

function getPreviousWeekDatas(ndt) {
    var days = new Array();
    for (var i = -7; i <= -1; i++) {
        var dt = new Date(ndt);
        days[7 + i] = getPreviousWeek(dt, i);
    }
    return days;
}

//指定日期的上一周(前七天)

function getPreviousWeek(dt, i) {
    var today = dt;
    today.setDate(today.getDate() + i);
    return today;
}

//下一周

function nextWeek() {
    setCurrDTAfter(); //重设时间
    showdate.innerHTML = currDT.getFullYear()+ "年" + (currDT.getMonth() + 1)+"月"; //显示

    //在表格中显示一周的日期
    var objTB = document.getElementById("mytable"); //取得表格对象
    var dw = currDT.getDay(); //从Date对象返回一周中的某一天(0~6)
    var tdDT; //日期
    $(".newtime input").remove();
    for (var i = 0; i < 7; i++) {
        tdDT = getNextWeekDatas(lastDay)[i];

       var dwdd = tdDT.getDate();
        if(dwdd<10) dwdd = '0' + dwdd;
        objTB.rows[0].cells[i].innerHTML = /*tdDT.getMonth() + 1 + "月" + */dwdd/* + "日 星期" + aryDay[dw]*/; //显示
        var newtime = '<input type="text" value="' + year + "-" + (tdDT.getMonth() + 1) + "-" + tdDT.getDate() + '">';
        $(".newtime").append(newtime);

        if (tdDT.toLocaleDateString() == currDT.toLocaleDateString()) {
   //         objTB.rows[0].cells[i].style.color = "white"; //currDT突出显示
    //        objTB.rows[0].cells[i].style.backgroundColor = "#1e9be8"; //currDT突出显示
     //   	$(objTB.rows[0].cells[i]).addClass("active")
            
            $(".datetime").find("input").val($(".newtime").find("input").eq(i).val())
        
        }
    }
    //重新赋值
    firstDay = getNextWeekDatas(lastDay)[0]; //注意赋值顺序1
    lastDay = getNextWeekDatas(lastDay)[6]; //注意赋值顺序2
}

//上一周

function previousWeek() {
    settCurrDTBefore();
    showdate.innerHTML = currDT.getFullYear()+ "年" + (currDT.getMonth() + 1)+"月"; //显示

    //在表格中显示一周的日期
    var objTB = document.getElementById("mytable"); //取得表格对象
    var dw = currDT.getDay(); //从Date对象返回一周中的某一天(0~6)
    var tdDT; //日期
    $(".newtime input").remove();
    for (var i = 0; i < 7; i++) {
        tdDT = getPreviousWeekDatas(firstDay)[i];

        var dwdd = tdDT.getDate();
        if(dwdd<10) dwdd = '0' + dwdd;
        objTB.rows[0].cells[i].innerHTML = /*tdDT.getMonth() + 1 + "月" + */dwdd/* + "日 星期" + aryDay[dw]*/; //显示
        var newtime = '<input type="text" value="' + year + "-" + (tdDT.getMonth() + 1) + "-" + tdDT.getDate() + '">';
        $(".newtime").append(newtime);

        if (tdDT.toLocaleDateString() == currDT.toLocaleDateString()) {
           // objTB.rows[0].cells[i].style.color = "white"; //currDT突出显示
           // objTB.rows[0].cells[i].style.backgroundColor = "#1e9be8"; //currDT突出显示
        	//$(objTB.rows[0].cells[i]).addClass("active")
        
            $(".datetime").find("input").val($(".newtime").find("input").eq(i).val())
        }
    }
    //重新赋值
    lastDay = getPreviousWeekDatas(firstDay)[6]; //注意赋值顺序1
    firstDay = getPreviousWeekDatas(firstDay)[0]; //注意赋值顺序2
}

//当前日期后第七天

function setCurrDTAfter() {
    currDT.setDate(currDT.getDate() + 7);
}

//当前日期前第七天

function settCurrDTBefore() {
    currDT.setDate(currDT.getDate() - 7);
}

/**********************************************************************/
