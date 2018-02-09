<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<script src="../../js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h1 style="margin-top: 30px; margin-bottom: 30px">개인 회원 가입</h1>
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
					<label for="name">Name</label> <input type="text"
						class="form-control" id="name" placeholder="Username"
						aria-describedby="inputGroupPrepend3" name="name" required>
				</div>
			</div>

			<div class="form-row">
				<label for="birth">생년월일</label> <input type="hidden" name="birth" />
				<select style="margin-left: 10px; margin-right: 5px"
					class="col-md-1 mb-1 form-control" id="year" name="year">
					<option value=1980>1980</option>
					<option value=1981>1981</option>
					<option value=1982>1982</option>
					<option value=1983>1983</option>
					<option value=1984>1984</option>
					<option value=1985>1985</option>
					<option value=1986>1986</option>
					<option value=1987>1987</option>
					<option value=1988>1988</option>
					<option value=1989>1989</option>
					<option value=1990>1990</option>
					<option value=1991>1991</option>
					<option value=1992>1992</option>
					<option value=1993>1993</option>
					<option value=1994>1994</option>
					<option value=1995>1995</option>
					<option value=1996>1996</option>
					<option value=1997>1997</option>
					<option value=1998>1998</option>
					<option value=1999>1999</option>
					<option value=2000>2000</option>
				</select>년 <select style="margin-left: 10px; margin-right: 5px"
					class="col-md-1 mb-1 form-control" id="month" name="month">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
					<option value=6>6</option>
					<option value=7>7</option>
					<option value=8>8</option>
					<option value=9>9</option>
					<option value=10>10</option>
					<option value=11>11</option>
					<option value=12>12</option>
				</select>월 <select style="margin-left: 10px; margin-right: 5px"
					class="col-md-1 mb-1 form-control" id="day" name="day">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
					<option value=6>6</option>
					<option value=7>7</option>
					<option value=8>8</option>
					<option value=9>9</option>
					<option value=10>10</option>
					<option value=11>11</option>
					<option value=12>12</option>
					<option value=13>13</option>
					<option value=14>14</option>
					<option value=15>15</option>
					<option value=16>16</option>
					<option value=17>17</option>
					<option value=18>18</option>
					<option value=19>19</option>
					<option value=20>20</option>
					<option value=21>21</option>
					<option value=22>22</option>
					<option value=23>23</option>
					<option value=24>24</option>
					<option value=25>25</option>
					<option value=26>26</option>
					<option value=27>27</option>
					<option value=28>28</option>
					<option value=29>29</option>
					<option value=30>30</option>
					<option value=31>31</option>
				</select>일
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
				<label for="tel">휴대전화</label>
				<div style="margin-left: 10px" class="col-md-6 mb-3 form-row">
					<select class="col-md-2 mb-3 form-control">
						<option>SKT</option>
						<option>KT</option>
						<option>LG U+</option>
					</select> <input style="margin-left: 10px; margin-right: 10px" type="text"
						class="col-md-6 mb-3 form-control" id="tel"
						placeholder="phone number" name="tel" required
						pattern="(010)-\d{4}-\d{4}">
					<button class="col-md-2 mb-3 btn btn-success">본인인증</button>
					<div style="font-size: 11px; color: red;">010-1234-5678 형태로
						입력해주세요</div>
				</div>
			</div>

			<div class="form-row">
				<label for="address">지역</label> <select
					style="margin-left: 10px; margin-right: 5px"
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

			<input type="hidden" name="type" value="1">
		</form>
	</div>
	<script type="text/javascript">
		var passID = true, passPwd = true, passEmail = true;

		$('#submitBtn').click(
				function() {
					var f = document.frm;
					f.birth.value = f.year.value + '-' + f.month.value + '-'
							+ f.day.value;
					f.submit();
				})

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
								console.log("fail");
								passID = false;
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
								document.querySelector('#validID').innerHTML = "사용 가능한 Email입니다";
								checkPass();
							} else {
								console.log("fail");
								passEmail = false;
								$('#email').removeClass("form-control");
								$('#email')
										.removeClass("form-control is-valid");
								$('#email').addClass("form-control is-invalid");
								$('#validEmail')
										.removeClass("invalid-feedback");
								$('#validEmail').removeClass("valid-feedback");
								$('#validEmail').addClass("invalid-feedback");
								document.querySelector('#validEmail').innerHTML = "이미 사용중인 Email입니다. 다른 Email을 입력해주세요";
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
	</script>
</body>
</html>
