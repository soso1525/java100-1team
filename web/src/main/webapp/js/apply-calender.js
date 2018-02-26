$('#addBtn').click(() => {
			var type = $("input[type=radio][name=type]:checked").val()
			var d = 'd' + document.getElementById('day').value;
			var tag;
			
			if(type == '인적성') {
				tag = '<div style="color:blue">' + document.getElementById('company').value + ' : ' + type + '</div>'
			} 
			
			if(type == '면접')
			{
				tag = '<div style="color:red">' + document.getElementById('company').value + ' : ' + type + '</div>'
			}
			
 			document.getElementById(d).innerHTML += tag;
 			
 			$('input[type=text]').not($('#prepare')).val('');
 			$('input[id=modal-2]').attr('checked', false);
 			
		});

$('#cancelBtn').click(() => {
	$('input[type=text]').not($('#prepare')).val('');
	$('input[id=modal-2]').attr('checked', false);
})

$(document).ready(function(){ 
	$('body').click(function(e){
// console.log(e.target.tagName);
		if(e.target.tagName == 'DIV' && e.target.style.color == 'blue')
			swal("인적성 일정", "좋은 결과 있기를 기원합니다.");
		else if(e.target.tagName == 'DIV' && e.target.style.color == 'red')
			swal("면접 일정", "마지막 관문입니다. 좋은 결과 있기를 기원합니다.");
    });
});