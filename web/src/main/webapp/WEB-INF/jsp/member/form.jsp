<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class='container'>

<%-- <jsp:include page="../header.jsp"/> --%>

<h1>회원 가입
</h1>
<form action='iAdd' method='post'>
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
<label for='name' class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>

<div class='form-group row'>
<label for='birth' class='col-sm-2 col-form-label'>생년월일</label>
<div class='col-sm-10'>
<input class='form-control' id='birth' type='date' name='birth'>
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
<input class='form=control' type='text' id='address' name='address'>
<div class='col-sm-10'>
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


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script charset="UTF-8" type="text/javascript" src="http://t1.daumcdn.net/cssjs/postcode/1513129253770/171213.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
 
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
 
                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
 
                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<div id="loading" style="display:none">로딩중....</div>
<script type="text/javascript">
var ctxpath = '${pageContext.request.contextPath}/app';
$(document).ready ( function (){
	
	var compCheckBtn = $('#btnCheckId'); 
	
	compCheckBtn.on ('click', function(e){
		e.preventDefault(); // 
		$('#loading').show();
		var memberId = $('#id').val();
		var qs = { id : memberId };
		
		$.ajax ({
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
		});
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