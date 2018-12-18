/**
 * Created by delltest on 2017/5/12.
 */
$(function(){

    var $image_classification = $('#image_classification');
    var $image_faculty = $('#image_faculty');
    var $image_subject = $('#image_subject');
    //选择第一层
    $image_faculty.change(function()
    {
        $image_subject.empty();
        $image_subject.append(
            '<option selected value="">---请选择---</option>  '
        );
        //加载第二层，传当前选中的内容
        load_image_subject();
    });
    $image_classification.change(function()
    {
        $image_faculty.empty();
        $image_faculty.append(
            '<option selected value="">---请选择---</option>'
        );
        //加载第二层，传当前选中的内容
        load_image_faculty();
    });
});

function load_image_subject()
{
    var IF = $('#image_faculty').val()
    var $image_subject = $('#image_subject');
    switch (IF)
    {
        case "MathematicsAndAppliedMathematics":
            $image_subject.append(
                ' <option value="AdvancedMathematics">高等数学</option>  ' +
                ' <option value="IDK">数学分析</option>' +
                ' <option value="IDK">解析几何</option>' +
                '<option value="IDK">复变函数</option>'
            );
            break;
        case "English":
            $image_subject.append(
                '<option value="English1">大学英语（一）</option>' +
                '<option value="IDK">大学英语（二）</option>' +
                '<option value="IDK">大学英语（三）</option>' +
                '<option value="IDK">大学英语（四）</option>' +
                '<option value="IDK">大学英语四级考试</option>' +
                '<option value="IDK">大学英语六级考试</option>'
            );
            break;
        case "ComputerScienceAndTechnology":
            $image_subject.append(
                '<option value="IDK">数据结构</option>' +
                '<option value="IDK">操作系统</option>' +
                '<option value="IDK">计算机网络</option>' +
                '<option value="IDK">计算机原理与组成</option>'
            );
            break;
        case "ElectronicScienceAndTechnology":
            $image_subject.append(
                '<option value="IDK">数据结构</option>' +
                '<option value="IDK">操作系统</option>' +
                '<option value="IDK">计算机网络</option>' +
                '<option value="IDK">计算机原理与组成</option>'
            );
            break;
        case "Law":
            $image_subject.append(
                '<option value="IDK">国际法</option>' +
                '<option value="IDK">经济法</option>' +
                '<option value="IDK">宪法学</option>' +
                '<option value="IDK">合同法</option>'
            );
            break;
    }
}

function load_image_faculty()
{
    var IC = $('#image_classification').val()
    var $image_faculty = $('#image_faculty');
    switch (IC)
    {
        case "NaturalScience":
            $image_faculty.append(
                '<option value="MathematicsAndAppliedMathematics">数学与应用数学</option>'
            );
            break;
        case "Literature":
            $image_faculty.append(
                '<option value="English">英语</option>'
            );
            break;
        case "Engineering":
            $image_faculty.append(
                '<option value="ComputerScienceAndTechnology">计算机科学与技术</option> ' +
                '<option value="ElectronicScienceAndTechnology">电子科学与技术</option>'
            );
            break;
        case "Law":
            $image_faculty.append(
                '<option value="Law">法学</option>'
            );
            break;
    }
}

function upload() {
    var formData = new FormData(document.getElementById("form"));//表单id
    var imagePath = $("#image_input").val();
    if (imagePath == "") {
        alert("请选择图片！");
        return false;
    }
    var name = imagePath.substr(imagePath.lastIndexOf("\\")+1);
    var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);
    if (strExtension != 'png') {
        alert("只支持:png 格式！");
        return false;
    }
    $.ajax({
        type : 'POST',
        url : '/upload',
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success : function(data) {
            alert("上传成功，此为预览！");
            $("#imgDiv").empty();
            $("#imgDiv").html("<img src="+data+">");
            $("#imgDiv").show();
        },
        error : function() {
            alert("上传失败，请检查网络后重试");
        }
    });

}

function Imagesave()
{
    var imagePath = $("#image_input").val();
    var imageName = $("#image_name").val();
    var imageClassification =$("#image_classification").val();
    var imageFaculty =$("#image_faculty").val();
    var imageSubject =$("#image_subject").val();
    var imageQuestion =$("#image_question").val();
    var imageDifficulty =$("#image_difficulty").val();

    imagePath=imagePath.substr(imagePath.lastIndexOf("\\")+1);
    //alert("文件名:"+imagePath);
    if(imagePath!="" && imageName!=""&& imageClassification!="" && imageFaculty!="" && imageSubject!="" && imageQuestion!="" && imageDifficulty!="") {
        $.ajax({
            type: 'POST',
            url: '/imageSave',
            data: {
                strings: imagePath,
                pid: imageName,
                classification: imageClassification,
                faculty: imageFaculty,
                subject: imageSubject,
                question: imageQuestion,
                difficulty: imageDifficulty,
            },
            success: function () {
                alert("保存成功");
            },
            error: function () {
                alert("保存失败");
            }
        });
    }
    else
    {
        alert("请完善信息！");
    }
}