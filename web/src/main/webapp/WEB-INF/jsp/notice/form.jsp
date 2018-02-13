<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>채용공고</h1>

<form action="add" method='post' enctype="multipart/form-data">


<div class='form-group row'>
<label for='image' class='col-sm-2 col-form-label'>공고이미지</label>
<div class='col-sm-10'>
<input class='form-control' id='image' type='file' name='file'>
</div>
</div>

<div class='form-group row'>
<label for='startDate' class='col-sm-2 col-form-label'>채용시작일</label>
<div class='col-sm-10'>
<input class='form-control' id='startDate' type='date' name='startDate'>
</div>
</div>

<div class='form-group row'>
<label for='endDate' class='col-sm-2 col-form-label'>채용종료일</label>
<div class='col-sm-10'>
<input class='form-control' id='endDate' type='date' name='endDate'>
</div>
</div>


<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    