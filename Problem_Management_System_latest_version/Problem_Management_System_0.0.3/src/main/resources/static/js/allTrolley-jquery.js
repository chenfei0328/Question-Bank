$(function() {

	ajax_init();

    GeneratePapers();

	//题目排序
    $('#sortable').sortable();
    $('#sortable').disableSelection();

});

function ajax_init() {
    var userid = $('#loginp').text().toString();
    $.ajax({
        type:'POST',
        url:'/trolley/allProblems',
        data:{
            userId:userid
        },
        success:function(res) {
            if (res.code === '0') {
            	$('.problem').empty().html('<h3><small>您还没有添加任何题目</small></h3>');
            }
            else {
                var problemAmount = res.data.currentSum;
                var pid;
                var dif;
                var content = '';
                $('.problem').empty();
                for (var i=0;i<problemAmount;i++) {
                    pid = res.data.problemInfoList[i].pid;
                    dif = res.data.problemInfoList[i].difficulty;
                    content += '<div class="row">' +
                    	            '<div class="col-sm-12 col-md-12">' +
                    				    '<div class="thumbnail">' +
                    					    '<img src="/ProblemBank/Problem/' + pid + '.png" alt="...">' +
                    						'<div class="caption">' +
                    							'<p>这是第' + (i+1) + '道题</p>' +
                    							'<p>这道题的难度为' + dif + '</p>' +
                    							'<p>' +
                    								'<a href="#" id="' + pid + '" class="btn btn-danger deleteproblem" role="button">从我的Trolley中删除此题</a>' +
                    							'</p>' +
                    						'</div>' +
                    					'</div>' +
                    				'</div>' +
                    			'</div>';
                }
                $('.problem').html(content);
            }
        }
    });
}

function GeneratePapers() {
    $('#generatePapers').click(function() {

        var userid= $('#loginp').text().toString();
        var name = getProblems();

        $.ajax({
            type:"POST",
            url:"/trolley/createPaper",
            data:{
                paperName:userid,
                pids:name
            },
            success:function(res) {
                alert('试卷已生成！');
                var content = '<a class="btn btn-info btn-lg btn-block" id="d" href="/result/' + res.data + '" download=' + res.data + '>点击下载</a>'
                $('#download').html(content);

                //$('#d').trigger('click');
            }
        });
        return false;
    });
}

function getProblems() {
    var s = [];
    $('#sortable').children().each(function() {
        var problemId = $(this).find('a').attr('id');
        s.push(problemId);
    });
    data = s.join(';');
    return data;
}