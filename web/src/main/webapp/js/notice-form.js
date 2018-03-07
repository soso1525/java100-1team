	$('header').load("../header.html");
var addBtn = $('#addBtn'),
    updateBtn = $('#updateBtn'),
    deleteBtn = $('#deleteBtn'),
    noItem = $('#no'), 
    startDateItem = $('#startDate'), 
    endDateItem = $('#endDate'),
    imageItem = $('#image'),
    nodivItem = $('#nodiv'),
    simgs = $('#image'),
    dutyItem = $('#dutyItem'),
    questionAddItem = $('#questionAdd'),
    questionDeleteItem = $('#questionDelete'),
    nameItem = $('#name');
    
var index = location.href.indexOf('?');
if (index != -1) { // 기존 데이터를 조회할 경우,
    var qs = location.href.substr(index + 1);
    var arr = qs.split('=');
    $('.my-new').css('display', 'none');
    $(() => {
        $.ajax('../json/notice/' + arr[1], {
            dataType: 'json',
            success: (result) => {
               nodivItem.html("<input class='form-control' readonly id='no' " +
                       "name='no' value='" + result.data.no + "'> "); 
                simgs.html("<img src='../../download/" + result.data.image + "'/>");
                dutyItem.val(result.data.duty);
                nameItem.val(result.data.companyMember.name);
                startDateItem.val(result.data.startDate);
                endDateItem.val(result.data.endDate);
                imageItem.val(result.data.image);
            },
            error: () => {
                window.alert('서버 실행 오류!');
            }
        });
    });
    
} else { // 신규 데이터 입력일 경우,
    $('.my-view').css('display', 'none');
    var now = new Date();
    var month = (now.getMonth() + 1);               
    var day = now.getDate();
    if(month < 10) 
        month = "0" + month;
    if(day < 10) 
        day = "0" + day;
    var today = now.getFullYear() + '-' + month + '-' + day;
    startDateItem.attr('min', today);
    endDateItem.attr('min', today);
    startDateItem.val(today);
}

startDateItem.change(() => {
	endDateItem.attr('min', startDateItem.val());
});

endDateItem.change(() => {
	startDateItem.attr('max', endDateItem.val());
});

var cnt = 1;
questionAddItem.click(() => {
	if (cnt < 6) {
		var div = $("<div class='form-group row'></div>");
		div.html("<label for='startDate' class='col-sm-2 col-form-label'>문항" + cnt + "</label>" +
		"<div class='col-sm-10'>" +
			"<input class='form-control' type='text' name='articles'>" +
		"</div>");
		$('#questionForm').append(div);
		cnt++;
	}
});

questionDeleteItem.click(() => {
	if (cnt > 0) {
		$('#questionForm > div:last-child').remove();
		cnt--;
	}
});



addBtn.click(() => {
    var formData = new FormData($('#form')[0]);
    $.ajax('../json/notice/add', {
        data: formData,
        dataType: 'json',
        method: 'POST',
        processData : false,
        contentType : false,
        success: (result) => {
            location.href = "notice.html";
        },
        error: () => {
            window.alert('서버 실행 오류!');
        }
    });
});
updateBtn.click(() => {
    var formData = new FormData($('#form')[0]);
    $.ajax('../json/notice/update', {
        data: formData,
        dataType: 'json',
        method: 'POST',
        processData : false,
        contentType : false,
        success: (result) => {
            location.href = "notice.html";
        },
        error: () => {
            window.alert('서버 실행 오류!');
        }
    });
});
deleteBtn.click(() => {
    $.ajax('../json/notice/delete', {
        data: {
        	no: $('#no').val()
        },
        dataType: 'json',
        success: (result) => {
            location.href = "notice.html";
        },
        error: () => {
            window.alert('서버 실행 오류!');
        }
    });
});