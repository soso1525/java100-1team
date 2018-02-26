var addBtn = $('#addBtn'),
	anoItem = $('#ano'),
	fileItem = $('#file'),
	qaddBtn = $('#qaddBtn'),
	questionNum = 1;

var index = location.href.indexOf('?');
var qs = location.href.substr(index + 1);
var arr = qs.split('=');
anoItem.val(arr[1]);


addBtn.click(() => {
	var formData = new FormData($('#form')[0]);
    $.ajax('../json/letter/add', {
        data: formData,
        dataType: 'json',
        method: 'POST',
        processData : false,
        contentType : false,
        success: (result) => {
            location.href = "../apply/form.html?no=" + arr[1];
        },
        error: () => {
            window.alert('서버 실행 오류!');
        }
    });
});

qaddBtn.click(() => {
	console.log('qAddBtn clicked');
	var q = $('.question').clone();
	q.attr('class', 'form-group row question' + questionNum);
	q.find('#rmvBtn').attr('id', 'rmvBtn'+questionNum);
	q.find('#qlabel').html('자소서 문항' + questionNum);
	q.css('visibility', 'visible');
	q.appendTo('#questionBox');
	questionNum++;
});

$(document).ready(function(){ 
	$('body').click(function(e){
        var id = e.target.getAttribute('id');
        console.log(id);
        if(id.startsWith('rmvBtn')) {
        	var question = document.getElementById(id).parentNode.parentNode.parentNode;
        	question.remove();
        	questionNum--;
        }
    });
});