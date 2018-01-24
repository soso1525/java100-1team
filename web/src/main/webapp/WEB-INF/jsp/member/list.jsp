<%@page import="java100.app.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>catch</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<style>
.card {
	text-align: center;
	float: left;
	margin: 5px;
}
</style>
</head>
<body>
	<div class='container'>

		<jsp:include page="../header.jsp" />

		<jsp:include page="../listToolbar.jsp" />

		<div class="card" style="width: 286px; height: 364px;">
			<div class="card-body">
				<h5 class="card-title">
					<img src="../../../images/samsung.jpg" width=250px />
				</h5>
				<h6 class="card-subtitle mb-2 text-muted">삼성전자</h6>
				<script>
					var s_date = new Date(2018, 02, 19);
					var now = Date.now();
					document.write('D-Day ', Math.floor((s_date - now)
							/ (1000 * 60 * 60 * 24)), '일');
				</script>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="card-link">지원하기</a>
			</div>
		</div>

		<div class="card" style="width: 286px; height: 364px;">
			<div class="card-body">
				<h5 class="card-title">
					<img src="../../../images/lg.jpg" width=250px />
				</h5>
				<h6 class="card-subtitle mb-2 text-muted">LG전자</h6>
				<script>
					var l_date = new Date(2018, 02, 21);
					var now = Date.now();
					document.write('D-Day ', Math.floor((l_date - now)
							/ (1000 * 60 * 60 * 24)), '일');
				</script>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="card-link">지원하기</a>
			</div>
		</div>

		<div class="card" style="width: 286px; height: 364px;">
			<div class="card-body">
				<h5 class="card-title">
					<img src="../../../images/samsung.jpg" width=250px />
				</h5>
				<h6 class="card-subtitle mb-2 text-muted">삼성전자</h6>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="card-link">지원하기</a>
			</div>
		</div>



	</div>
</body>
</html>
