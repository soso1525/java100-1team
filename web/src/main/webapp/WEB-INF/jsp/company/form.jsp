<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>기업회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class='container'>

<%-- <jsp:include page="../header.jsp"/> --%>

<h1>기업회원 가입
</h1>
<form action='cAdd' method='post'>
<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>아이디</label>
<div class='col-sm-10'>
<input class='form-control' id='id' type='text' name='id'>
</div>
</div>

<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'></label>
<div class='col-sm-10'>
<button class='form-control' id='btnCheckId' >조회하기</button>
</div>
</div>

<div class='form-group row'>
<label for='password' class='col-sm-2 col-form-label'>비밀번호</label>
<div class='col-sm-10'>
<input class='form-control' id='password' type='password' name='password'>
</div>
</div>
<div class='form-group row'>
<label for='repassword' class='col-sm-2 col-form-label'>비밀번호 재확인</label>
<div class='col-sm-10'>
<input class='form-control' id='repassword' type='password' name='repassword'>
</div>
</div>


<div class='form-group row'>
<label for='checkpassword' class='col-sm-2 col-form-label'></label>
<div class='col-sm-10'>
<input class='form-control' id='checkpassword' readonly type='text' name='checkpassword'>
</div>
</div>

<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>기업명</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>

<div class='form-group row'>
<label for='businessNo' class='col-sm-2 col-form-label'>사업자등록번호</label>
<div class='col-sm-10'>
<input class='form-control' id='businessNo' type='text' name='businessNo'>
</div>
</div>

<div class='form-group row'>
<label for='businessNo' class='col-sm-2 col-form-label'></label>
<div class='col-sm-10'>
<button class='form-control' id='btnCheckInfo' >조회하기</button>
</div>
</div>

<div class='form-group row'>
<label for='kind' class='col-sm-2 col-form-label'>업종</label>
<div class='col-sm-10'>
<input class='form-control' id='kind' type='text' name='kind'>
</div>
</div>




<div class='form-group row'>
<label for='cType' class='col-sm-2 col-form-label'>기업형태</label>
<div class='col-sm-10'>
<input class='form-control' id='cType' type='text' name='cType'>
</div>
</div>


<div class='form-group row'>
<label for='email' class='col-sm-2 col-form-label'>이메일</label>
<div class='col-sm-10'>
<input class='form-control' id='email' type='text' name='email'>
</div>
</div>

<div class='form-group row'>
<label for='address' class='col-sm-2 col-form-label'>주소</label>
<div class='col-sm-10'>
<input class='form-control' id='address' type='text' name='address'>
</div>
</div>

<div class='form-group row'>
<label for='tel' class='col-sm-2 col-form-label'>전화번호</label>
<div class='col-sm-10'>
<input class='form-control' id='tel' type='text' name='tel'>
</div>
</div>

<div class='form-group row'>
<label for='type' class='col-sm-2 col-form-label'>타입</label>
<div class='col-sm-10'>
<input class='form-control' id='type' type='text' name='type'>
</div>
</div>



<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm' id="btn-enrol" style="display:none">등록</button>
</div>
</div>
</form>

</div>
<div id="loading" style="display:none">로딩중....</div>
<script type="text/javascript">
var ctxpath = '${pageContext.request.contextPath}/app';
$(document).ready ( function (){
	var compCheckBtn = $('#btnCheckInfo'); 
	console.log ( compCheckBtn );
	
	compCheckBtn.on ('click', function(e){
		e.preventDefault(); // 
		$('#loading').show();
		console.log('눌렸다!');
		var compName = $('#name').val();
		var compNum = $('#businessNo').val();
		console.log ( compName, compNum);
		var qs = { cname : compName, cnum : compNum };
		
		$.ajax ( {
			type : 'GET',
			url : ctxpath + '/company/check-comp-info',
			data : qs,
			success : function (response) {
				$('#loading').hide();
				console.log ( '[response]', response );
				var result = JSON.parse ( response);
				console.log ( '[response]', result );
				if ( result.success ) {
					$('#btn-enrol').show();
				} else {
					$('#btn-enrol').hide();
				}
			}
		} );
	});
});

$(document).ready ( function (){
	
	var compCheckBtn = $('#btnCheckId'); 
	
	compCheckBtn.on ('click', function(e){
		e.preventDefault(); // 
		$('#loading').show();
		var memberId = $('#id').val();
		var qs = { id : memberId };
		
		$.ajax ( {
			type : 'GET',
			url : ctxpath + '/member/check-memb-id',
			data : qs,
			success : function (response) {
				$('#loading').hide();
				console.log ( '[response]', response );
				var result = JSON.parse ( response);
				console.log ( '[response]', result );
				if ( result.success ) {
					$('#btn-enrol').show();
				} else {
					$('#btn-enrol').hide();
				}
			}
		} );
	});
});

var password = document.querySelector('#password')
var repassword = document.querySelector('#repassword')
var checkpassword= document.querySelector('#checkpassword')
password.addEventListener('keyup', function() {
     if (password.value == repassword.value) {
        checkpassword.value = "일치합니다."
     } else {
        checkpassword.value = "일치하지않습니다."
     }
});
repassword.addEventListener('keyup', function() {
     if (password.value == repassword.value) {
        checkpassword.value = "일치합니다."
     } else {
        checkpassword.value = "일치하지않습니다."
     }
});
</script>

</body>
</html>