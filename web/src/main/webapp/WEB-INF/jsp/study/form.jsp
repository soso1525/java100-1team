<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>스터디관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<h1>스터디등록</h1>
<form action='add' method='post' enctype="multipart/form-data">
<div class='form-group row'>
<label for='sloc' class='col-sm-2 col-form-label'>지역</label>
<div class='col-sm-10'>
<input class='form-control' id='sloc' type='text' name='sloc'>
</div>
</div>

<div class='form-group row'>
<label for='sname' class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='sname' type='text' name='sname'>
</div>
</div> 
<div class='form-group row'>
<label for='sdesc' class='col-sm-2 col-form-label'>설명</label>
<div class='col-sm-10'>
<input class='form-control' id='sdesc' type='text' name='sdesc'>
</div>
</div>
<div class='form-group row'>
<label for='sint' class='col-sm-2 col-form-label'>관심분야</label>
<div class='col-sm-10'>
<input class='form-control' id='sint' type='text' name='sint'>
</div>
</div>
<div class='form-group row'>
<label for='sppl' class='col-sm-2 col-form-label'>인원수</label>
<div class='col-sm-10'>
<input class='form-control' id='sppl' type='number' name='sppl'>
</div>
</div>
<!-- <div class='form-group row'>
<label for='sregdt' class='col-sm-2 col-form-label'>등록일</label>
<div class='col-sm-10'>
<input class='form-control' id='sregdt' type='date' name='sregdt'>
</div>
</div> -->
<div class='form-group row'>
<label for='scorp' class='col-sm-2 col-form-label'>대상기업</label>
<div class='col-sm-10'>
<input class='form-control' id='scorp' type='text' name='scorp'>
</div>
</div>
<div class='form-group row'>
<label for='file' class='col-sm-2 col-form-label'>이미지</label>
<div class='col-sm-10'>
<input class='form-control-file' id='file' type='file' name='file'>
</div>
</div>
<div class='form-group row'>
<label for='scheck' class='col-sm-2 col-form-label'>모집상태</label>
<div class='col-sm-10'>
<input class='form-control' id='scheck' type='text' name='scheck'>
</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>


</div>

</body>
</html>