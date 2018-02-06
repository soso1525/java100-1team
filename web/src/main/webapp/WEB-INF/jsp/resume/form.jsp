<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>이력서</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<%-- <jsp:include page="../header.jsp"/> --%>

<h1>이력서
</h1>
<form action='add' method='post' enctype="multipart/form-data">
<div class='form-group row'>
<label for='education' class='col-sm-2 col-form-label'>학력</label>
<div class='col-sm-10'>
<input class='form-control' id='education' type='text' name='education'>
</div>
</div>
<div class='form-group row'>
<label for='career' class='col-sm-2 col-form-label'>경력</label>
<div class='col-sm-10'>
<input class='form-control' id='career' type='number' name='career'>
</div>
</div>
<div class='form-group row'>
<label for='kind' class='col-sm-2 col-form-label'>직종</label>
<div class='col-sm-10'>
<input class='form-control' id='kind' type='text' name='kind'>
</div>
</div>
<div class='form-group row'>
<label for='image' class='col-sm-2 col-form-label'>사진</label>
<div class='col-sm-10'>
<input class='form-control' id='image' type='file' name='files'>
</div>
</div>
<div class='form-group row'>
<label for='qualification' class='col-sm-2 col-form-label'>자격증</label>
<div class='col-sm-10'>
<input class='form-control' id='qualification' type='text' name='qualification'>
</div>
</div>
<div class='form-group row'>
<label for='language' class='col-sm-2 col-form-label'>어학</label>
<div class='col-sm-10'>
<input class='form-control' id='language' type='text' name='language'>
</div>
</div>
<div class='form-group row'>
<label for='award' class='col-sm-2 col-form-label'>수상</label>
<div class='col-sm-10'>
<input class='form-control' id='award' type='text' name='award'>
</div>
</div>

<div class='form-group row'>
<label for='major' class='col-sm-2 col-form-label'>전공</label>
<div class='col-sm-10'>
<input class='form-control' id='major' type='text' name='major'>
</div>
</div>
<div class='form-group row'>
<label for='schoolName' class='col-sm-2 col-form-label'>학교명</label>
<div class='col-sm-10'>
<input class='form-control' id='schoolName' type='text' name='schoolName'>
</div>
</div>
<div class='form-group row'>
<label for='grades' class='col-sm-2 col-form-label'>학점</label>
<div class='col-sm-10'>
<input class='form-control' id='grades' type='text' name='grades'>
</div>
</div>
<div class='form-group row'>
<label for='avi' class='col-sm-2 col-form-label'>1분 동영상</label>
<div class='col-sm-10'>
<input class='form-control' id='avi' type='file' name='files'>
</div>
</div>
<div class='form-group row'>
<label for='file' class='col-sm-2 col-form-label'>파일</label>
<div class='col-sm-10'>
<input class='form-control' id='file' type='file' name='files'>
</div>
</div>

<div class='form-group row'>
<label for='note' class='col-sm-2 col-form-label'>할말</label>
<div class='col-sm-10'>
<input class='form-control' id='note' type='text' name='note'>
</div>
</div>

<div class='form-group row'>
<label for='check' class='col-sm-2 col-form-label'>공개여부</label>
<div class='col-sm-10'>
<input class='form-control' id='check' type='text' name='check'>
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