var addBtn = $('#addBtn'),
	fileItem = $('#file'),
	qaddBtn = $('#qaddBtn'),
	questionNum = 1;

var index = location.href.indexOf('?');
var qs = location.href.substr(index + 1);
var arr = qs.split('=');


addBtn.click(() => {
	$.ajax(host + '/json/apply/find', {
		data: {
			aname: $('#companyName').val()
		},
		dataType: 'json',
		success: (result) => {
			$('#ano').val(0);
			if (result.data) {
				$('#ano').val(result.data.ano);
				var formData = new FormData($('#form')[0]);
			    $.ajax(host + '/json/letter/add', {
			        data: formData,
			        dataType: 'json',
			        method: 'POST',
			        processData : false,
			        contentType : false,
			        success: () => {
			        	swal("Apply Success!", "자기소개서가 정상적으로 등록되었습니다.", "success");
			            location.href = "../apply/my-apply-list.html";
			        },
			        error: () => {
			            window.alert('서버 실행 오류!');
			        }
			    });
				
			} else {
				var formData = new FormData($('#form')[0]);
			    $.ajax(host + '/json/letter/addLetter', {
			        data: formData,
			        dataType: 'json',
			        method: 'POST',
			        processData : false,
			        contentType : false,
			        success: () => {
			        	swal("Apply Success!", "자기소개서가 정상적으로 등록되었습니다.", "success");
			            location.href = "../apply/my-apply-list.html";
			        },
			        error: () => {
			            window.alert('서버 실행 오류!');
			        }
			    });
			}
		},
		error: () => {
            window.alert('서버 실행 오류!');
        }
		
	});
});

qaddBtn.click(() => {
	console.log('qAddBtn clicked');
	var q = $('#lq').clone();
	q.attr('id', 'lq' + questionNum);
	q.find('#article').val("");
	q.find('#length').val("");
	q.find('#content').val("");
	q.appendTo('#questionBox');
});

$(document).ready(function(){ 
	$('body').click(function(e){
        var id = e.target.getAttribute('id');
        if(id != null) {
	        if(id.startsWith('rmvBtn')) {
	        	var article = e.target.parentNode.parentNode.parentNode.parentNode;
	        	article.remove();
	        }
	        
	        if(id.startsWith('correct')) {
	        	window.open("http://speller.cs.pusan.ac.kr/PnuWebSpeller/", "", "width=850px, height=701px");
	        }
	    }
    });
});

