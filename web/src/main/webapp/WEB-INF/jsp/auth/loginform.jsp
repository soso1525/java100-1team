<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<style type="text/css">
body {
	background: url('../../images/login.png') no-repeat top;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="../member/list.html">CATCH</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Job</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/study/list.html">Study</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/apply/list.html">Apply</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/notice/list.html">Notice</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Message</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/app/auth/login">Login</a></li>
			</ul>
		</div>
	</nav>
	<div>
		<div class='container2' style="margin: auto; margin-top: 300px">
			<form class="form-4" action="login" method="post">
				<h1>Log In</h1>
				<p>
					<label for="login">Username or email</label> <input type="text"
						name="id" id='id' placeholder="Username or email"
						value="${cookie.id.value}" required>
				</p>
				<p>
					<label for="password">Password</label> <input type="password"
						name='password' placeholder="Password" id="password" required>
				</p>
				<p>
					<input type="submit" name="submit" value="Continue">
				</p>
				<a href="/member/form.html">일반 회원가입</a> <a href="/company/form.html">기업
					회원가입</a>
			</form>
			<jsp:include page="../footer.jsp" />
		</div>
	</div>
	<jsp:include page="../jslib.jsp" />
</body>
</html>
