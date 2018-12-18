/**
 * Created by delltest on 2017/5/21.
 */
var x=0;
var pid = "";
function RefreshTable () {
    $.ajax({
        type:"POST",
        url:"/RefreshTemp",
        async:false,
        dataType:'json',
        success:function(data){
            $(".re-information").remove();
            $(".re-image").remove();
            for(i=0;i<data.length;i++){
                pid = data[i].pid;
                $("#table1").append('<tr class="re-image"><td colspan="7" align="center"><img src="/ProblemBank/Problem/'+data[i].pid+'.png"></td></tr><tr class="re-information"><td>'+data[i].pid+'</td>' +
                    '<td>'+data[i].classification+'</td><td>'+data[i].faculty+'</td><td>'+data[i].subject+'</td><td>'+data[i].question+'</td><td>'+data[i].difficulty+'</td><td><button id="ButtonYes'+i+'" onclick="yes(this)">yes</button><button id="buttonNo'+i+'"onclick="no(this)">no</button></td></tr>');
            }
        },
        error:function(){
            alert("error");
        },
    });
}
function yes(obj) {
    var id=$(obj).closest("tr").children().html();
    $.ajax({
        type: 'POST',
        url: '/reviewSave',
        data: {
            pid : id,
        },
        success: function () {
            alert("保存成功");
        },
        error: function () {
            alert("保存失败");
        }
    });
}
function no(obj) {
    var id=$(obj).closest("tr").children().html();
    $.ajax({
        type: 'POST',
        url: '/reviewDelete',
        data: {
            pid : id,
        },
        success: function () {
            alert("保存成功");
        },
        error: function () {
            alert("保存失败");
        }
    });
}