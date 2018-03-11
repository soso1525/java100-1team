
//String Date타입으로 바꾸기
function parse(str) {
	var date = new Date(str.split('-'));
	return date.getDate();
}

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
			var type = $("input[type=radio][name=type]:checked").val();
			console.log(type);
			
			var d = 'd' + document.getElementById('day').value;
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
 			
		});

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