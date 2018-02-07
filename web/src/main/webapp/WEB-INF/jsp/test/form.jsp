<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>CATCH : 인적성/면접</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<style>
h1 {
	margin: 20px 0 20px 0;
}
</style>
</head>
<body>
	<div class='container'>
		<h1>인적성/면접 일정 등록</h1>
		<form action='add' method='post'>
			<input type="hidden" name="ano" value="${param.ano}">
			<div class='form-group row'>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="type" id="type1"
						value="인적성"> <label class="form-check-label" for="type1">인적성</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="type" id="type2"
						value="면접"> <label class="form-check-label" for="type2">면접</label>
				</div>
			</div>

			<div class='form-group row'>
				<label for='date' class='col-sm-2 col-form-label'>날짜</label>
				<div class='col-sm-10'>
					<input class='form-control' id='date' type='date' name='date'>
				</div>
			</div>

			<div class='form-group row'>
				<label for='time' class='col-sm-2 col-form-label'>시간</label>
				<div class='col-sm-10'>
					<input class='form-control' id='time' type='time' name='time'>
				</div>
			</div>

			<div class='form-group row'>
				<label for='location' class='col-sm-2 col-form-label'>장소</label>
				<div class='col-sm-10'>
					<input class='form-control' id='location' type='text'
						name='location'>
				</div>
			</div>

			<div class='form-group row'>
				<label for='prepare' class='col-sm-2 col-form-label'>준비물</label>
				<div class='col-sm-10'>
					<input class='form-control' id='prepare' type='text' name='prepare'>
				</div>
			</div>

			<div class='form-group row'>
				<div class='col-sm-10'>
					<button class='btn btn-primary btn-sm' id="btn-enrol">등록</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>