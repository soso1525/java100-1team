
//String Date타입으로 바꾸기
function parse(str) {
	var date = new Date(str.split('-'));
	return date.getDate();
}


$(function(){

      //직접입력 인풋박스 기존에는 숨어있다가

$("#selboxDirect").hide();



$("#anameNew").change(function() {
		if($("#anameNew").val() == "direct") {
			$("#aname").show();
		}  else {
			$("#aname").hide();
		}
	}) 
});

$.ajax(host+ '/json/apply/list', {
	dataType: 'json',
	success: (result) => {
		$('#anameNew').empty();
		$('#anameNew').append($("<option value='direct'>직접입력</option>"));
		for (var data of result.apply) {
			var option = $("<option value='" + data.aname + "'>" + data.aname + "</option>");
			$('#anameNew').append(option);
		}
	},
	 error: () => {
        window.alert('서버 실행 오류!');
    }
});

$.ajax(host + '/json/test/allList', {
	dataType: 'json',
    success: (result) => {
    	for (var data of result.list) {
    		var d = 'd' + parse(data.date);
			var tag;
			
			if(data.type == '인적성') {
				tag = '<div style="color:blue">' + data.apply.aname + ' : ' + data.type + '</div>'
			} 
			
			if(data.type == '면접') {
				tag = '<div style="color:red">' + data.apply.aname + ' : ' + data.type + '</div>'
			}
			
			if(data.type == undefined) {
				swal('Missed!', '전형 유형을 선택하지 않으셨습니다!', 'error');
				return;
			}
			
			document.getElementById(d).innerHTML += tag;
    	}
    },
    error: () => {
        window.alert('서버 실행 오류!');
    }
});


$('#addBtn').click(() => {
	$.ajax(host + '/json/apply/find', {
		data: {
			aname: $('#anameNew').val()
		},
		dataType: 'json',
		success: (result) => {
			$('#ano').val(0);
			if (result.data) {
				$('#ano').val(result.data.ano);
				var ano = result.data.ano;
				var formData = new FormData($('#form')[0]);
			    $.ajax(host + '/json/test/add', {
			        data: formData,
			        dataType: 'json',
			        method: 'POST',
			        processData : false,
			        contentType : false,
			        success: () => {
			        	swal("Added!", "새로운 일정이 등록되었습니다", "success").then(()=> {
			        		location.href = "../apply/my-apply-status.html?ano="+ano;	
			        	});
			        },
			        error: () => {
			            window.alert('서버 실행 오류!');
			        }
			    });
				
			} else {
				var formData = new FormData($('#form')[0]);
			    $.ajax(host + '/json/test/addTest', {
			        data: formData,
			        dataType: 'json',
			        method: 'POST',
			        processData : false,
			        contentType : false,
			        success: (result) => {
			        	swal("Added!", "새로운 일정이 등록되었습니다", "success").then(()=> {
			        		location.href = "../apply/my-apply-status.html?ano=" + result.ano;	
			        	});
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
/*
$('#addBtn').click(() => {
	
		
			var type = $("input[type=radio][name=type]:checked").val();
			
			var d = 'd' + parse($('#date').val());
			var tag;
			
			if(type == '인적성') {
				tag = '<div style="color:blue">' + document.getElementById('companyName').value + ' : ' + type + '</div>'
			} 
			
			if(type == '면접')
			{
				tag = '<div style="color:red">' + document.getElementById('companyName').value + ' : ' + type + '</div>'
			}
			
			if(type == undefined) {
				swal('Missed!', '전형 유형을 선택하지 않으셨습니다!', 'error');
				return;
			}
			
 			document.getElementById(d).innerHTML += tag;
 			
 			$('input[type=text]').not($('#prepare')).val('');
 			$('input[id=modal-2]').prop('checked', false);
 			
		});*/

$('#cancelBtn').click(() => {
	console.log('cancelBtn clicked');
	$('input[type=text]').not($('#prepare')).val('');
	$('input:checkbox[id="modal-2"]').prop('checked', false);
})

$(document).ready(function(){ 
	$('body').click(function(e){
		if(e.target.tagName == 'DIV' && e.target.style.color == 'blue')
			swal("인적성 일정", "좋은 결과 있기를 기원합니다.");
		else if(e.target.tagName == 'DIV' && e.target.style.color == 'red')
			swal("면접 일정", "마지막 관문입니다. 좋은 결과 있기를 기원합니다.");
    });
});