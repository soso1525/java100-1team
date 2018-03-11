	var modal = document.getElementById('myModal');
	var btn = document.getElementById("myBtn");
	var span = document.getElementsByClassName("close")[0];
	btn.onclick = function() {
		modal.style.display = "block";
	}

	span.onclick = function() {
		modal.style.display = "none";
	}

	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
	$('#applyBtn').click(() => {
		var formData = new FormData($('#form')[0]);
	    
	    $.ajax(host + '/json/apply/add-simple', {
	        data:
	        	formData,
	        	dataType: 'json',
	        method: 'POST',
	        processData : false,
	        contentType : false,
	        success: (result) => {
	        	console.log('success');
	        	modal.style.display = "none";
	        	location.href="my-apply-list.html";
	        },
	        error: () => {
	            window.alert('서버 실행 오류!');
	        }
	    });
	});
	
	$('#like').click(() => {
		location.href="like.html";
	});
	
	$('#resume').click(() => {
		location.href="../resume/list.html";
	});
	
	$('#letter').click(() => {
		location.href="../letter/list.html";
	});
	
	$('#test').click(() => {
		location.href="../test/calendar.html";
	});