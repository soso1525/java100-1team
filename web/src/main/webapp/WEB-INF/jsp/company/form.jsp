<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>기업회원관리</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="margin-top: 30px; margin-bottom: 30px">기업 회원 가입</h1>
		<form action='iAdd' method='post' name="frm">
			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="id">ID</label> <input type="text" class="form-control"
						id="id" placeholder="user ID" onkeyup="checkID()" name="id"
						required>
					<div class="" id="validID"></div>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="validationServerUsername">Password</label> <input
						type="password" class="form-control" id="password"
						placeholder="password" aria-describedby="inputGroupPrepend3"
						name="password"
						pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
						required>
					<div style="margin: 5px; font-size: 11px; color: red;">문자/숫자/특수문자를
						포함하여 최소 8자 이상</div>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="repassword">Password 확인</label> <input type="password"
						class="form-control" id="repassword" placeholder="password"
						aria-describedby="inputGroupPrepend3" onkeyup="checkPwd()"
						name="repassword" required>
					<div class="" id="validPWD"></div>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="name">기업명</label> <input type="text"
						class="form-control" id="name" placeholder="company name"
						name="name" required>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="businessNo">사업자등록번호</label> <input type="text"
						class="form-control" id="businessNo" placeholder="company no"
						name="businessNo" required>
					<button class="form-control" id='btnCheckInfo'>조회하기</button>
					<div class="" id="validID"></div>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="kind">업종</label> <select class="form-control" id="kind"
						name="kind">
						<option value="경영/사무">경영/사무</option>
						<option value="영업/고객상담">영업/고객상담</option>
						<option value="생산/제조">생산/제조</option>
						<option value="IT/인터넷">IT/인터넷</option>
						<option value="전문직">전문직</option>
						<option value="교육">교육</option>
						<option value="미디어">미디어</option>
						<option value="특수계층/공공">특수계층/공공</option>
						<option value="건설">건설</option>
						<option value="유통/무역">유통/무역</option>
						<option value="서비스">서비스</option>
						<option value="디자인">디자인</option>
						<option value="의료">의료</option>
					</select>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="cType">기업형태</label> <select class="form-control"
						id="cType" name="cType">
						<option value="대기업">대기업</option>
						<option value="중견기업">중견기업</option>
						<option value="공사/공기업">공사/공기업</option>
						<option value="코스닥">코스닥</option>
						<option value="코스피">코스피</option>
						<option value="외국계">외국계</option>
						<option value="매출1000대기업">매출1000대기업</option>
						<option value="중소기업">중소기업</option>
						<option value="기타">기타</option>
					</select>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" placeholder="user@email.com"
						name="email" onkeyup="checkEmail()" required>
					<div class="" id="validEmail"></div>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="address">지역</label> <select
						class="col-md-5 mb-3 form-control" id="address" name="address">
						<option value="서울전체">서울전체</option>
						<option value="강남구">강남구</option>
						<option value="강동구">강동구</option>
						<option value="강북구">강북구</option>
						<option value="강서구">강서구</option>
						<option value="관악구">관악구</option>
						<option value="광진구">광진구</option>
						<option value="구로구">구로구</option>
						<option value="금천구">금천구</option>
						<option value="노원구">노원구</option>
						<option value="도봉구">도봉구</option>
						<option value="동대문구">동대문구</option>
						<option value="동작구">동작구</option>
						<option value="마포구">마포구</option>
						<option value="서대문구">서대문구</option>
						<option value="서초구">서초구</option>
						<option value="성동구">성동구</option>
						<option value="성북구">성북구</option>
						<option value="송파구">송파구</option>
						<option value="양천구">양천구</option>
						<option value="영등포구">영등포구</option>
					</select>
				</div>
			</div>

			<div class="form-row">
				<div class="col-md-6 mb-3">
					<label for="tel">전화번호</label> <input type="text"
						class="form-control" id="tel" placeholder="company tel" name="tel"
						required>
				</div>
			</div>

			<input type="hidden" name="type" value="2" />

			<div class="form-row">
				<div class="form-check">
					<input class="form-check-input is-invalid" type="checkbox" value=""
						id="invalidCheck3" required> <label
						class="form-check-label" for="invalidCheck3"> Agree to
						terms and conditions </label>
					<div class="invalid-feedback">You must agree before
						submitting.</div>
				</div>
			</div>

			<div style="align-items: right" class="form-row">
				<button style="margin-top: 30px; margin-bottom: 30px"
					class="btn btn-primary" type="submit" id="submitBtn">Submit
					form</button>
			</div>
		</form>
	</div>

	<div id="loading" style="display: none">로딩중....</div>
	<script type="text/javascript">
		var passID = true, passPwd = true, passEmail = true;

		function checkID() {
			var ctxpath = '${pageContext.request.contextPath}/app';
			var userID = $('#id').val();
			$
					.ajax({
						type : 'GET',
						url : ctxpath + '/member/check-memb-id',
						data : {
							id : userID
						},
						success : function(data) {
							var result = JSON.parse(data);
							if (result.success) {
								console.log("success");
								passID = true;
								$('#id').removeClass("form-control");
								$('#id').removeClass("form-control is-invalid");
								$('#id').addClass("form-control is-valid");
								$('#validID').removeClass("valid-feedback");
								$('#validID').removeClass("invalid-feedback");
								$('#validID').addClass("valid-feedback");
								document.querySelector('#validID').innerHTML = "사용 가능한 ID입니다";
								checkPass();
							} else {
								passID = false;
								console.log("fail");
								$('#submitBtn').prop("disabled", true);
								$('#id').removeClass("form-control");
								$('#id').removeClass("form-control is-valid");
								$('#id').addClass("form-control is-invalid");
								$('#validID').removeClass("invalid-feedback");
								$('#validID').removeClass("valid-feedback");
								$('#validID').addClass("invalid-feedback");
								document.querySelector('#validID').innerHTML = "사용 불가능한 ID입니다. 다른 ID를 입력해주세요";
								checkPass();
							}
						}
					});
		}

		function checkEmail() {
			var ctxpath = '${pageContext.request.contextPath}/app';
			var userEmail = $('#email').val();
			$
					.ajax({
						type : 'GET',
						url : ctxpath + '/member/check-memb-email',
						data : {
							email : userEmail
						},
						success : function(data) {
							var result = JSON.parse(data);
							if (result.success) {
								console.log("success");
								passEmail = true;
								$('#email').removeClass("form-control");
								$('#email').removeClass(
										"form-control is-invalid");
								$('#email').addClass("form-control is-valid");
								$('#validEmail').removeClass("valid-feedback");
								$('#validEmail')
										.removeClass("invalid-feedback");
								$('#validEmail').addClass("valid-feedback");
								document.querySelector('#validEmail').innerHTML = "사용 가능한 email입니다";
								checkPass();
							} else {
								console.log("fail");
								passEmail = false;
								$('#submitBtn').prop("disabled", true);
								$('#email').removeClass("form-control");
								$('#email')
										.removeClass("form-control is-valid");
								$('#email').addClass("form-control is-invalid");
								$('#validEmail')
										.removeClass("invalid-feedback");
								$('#validEmail').removeClass("valid-feedback");
								$('#validEmail').addClass("invalid-feedback");
								document.querySelector('#validEmail').innerHTML = "이미 사용중인 email입니다. 다른 Email을 입력해주세요";
								checkPass();
							}
						}
					});
		}

		function checkPwd() {
			var password = document.querySelector('#password')
			var repassword = document.querySelector('#repassword')
			var checkpassword = document.querySelector('#validPWD')
			repassword.addEventListener('keyup', function() {
				if (password.value == repassword.value) {
					passPwd = true;
					$('#repassword').removeClass("form-control");
					$('#repassword').removeClass("form-control is-invalid");
					$('#repassword').addClass("form-control is-valid");
					$('#validPWD').removeClass("valid-feedback");
					$('#validPWD').removeClass("invalid-feedback");
					$('#validPWD').addClass("valid-feedback");
					checkpassword.innerHTML = "비밀번호가 일치합니다";
					//$('#submitBtn').prop("disabled", false);
					checkPass();
				} else {
					passPwd = false;
					$('#repassword').removeClass("form-control");
					$('#repassword').removeClass("form-control is-valid");
					$('#repassword').addClass("form-control is-invalid");
					$('#validPWD').removeClass("valid-feedback");
					$('#validPWD').removeClass("invalid-feedback");
					$('#validPWD').addClass("invalid-feedback");
					checkpassword.innerHTML = "비밀번호가 일치하지않습니다";
					//$('#submitBtn').prop("disabled", true);
					checkPass();
				}
			});
		}

		function checkPass() {
			if (passID && passEmail && passPwd) {
				$('#submitBtn').prop("disabled", false);
			} else {
				$('#submitBtn').prop("disabled", true);
			}
		}

		var ctxpath = '${pageContext.request.contextPath}/app';
		$(document).ready(function() {
			var compCheckBtn = $('#btnCheckInfo');
			console.log(compCheckBtn);

			compCheckBtn.on('click', function(e) {
				e.preventDefault(); // 
				$('#loading').show();
				console.log('눌렸다!');
				var compName = $('#name').val();
				var compNum = $('#businessNo').val();
				console.log(compName, compNum);
				var qs = {
					cname : compName,
					cnum : compNum
				};

				$.ajax({
					type : 'GET',
					url : ctxpath + '/company/check-comp-info',
					data : qs,
					success : function(response) {
						$('#loading').hide();
						console.log('[response]', response);
						var result = JSON.parse(response);
						console.log('[response]', result);
						if (result.success) {
							$('#btn-enrol').show();
						} else {
							$('#btn-enrol').hide();
						}
					}
				});
			});
		});
	</script>

</body>
</html>