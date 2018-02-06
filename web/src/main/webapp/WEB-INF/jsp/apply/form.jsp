<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>입사지원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<%-- <jsp:include page="../header.jsp"/> --%>

<h1>이력서
</h1>
<form action='add' method='post'>
<div class='form-group row'>
<label for='education' class='col-sm-2 col-form-label'>기업명</label>
<div class='col-sm-10'>
<input class='form-control' id='aname' type='text' name='aname'>
</div>
</div>
<div class='form-group row'>
<label for='career' class='col-sm-2 col-form-label'>신청일</label>
<div class='col-sm-10'>
<input class='form-control' id='adt' type='Date' name='adt'>
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