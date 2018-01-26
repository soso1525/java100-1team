<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>기업회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>기업회원 가입
</h1>
<form action='cAdd' method='post'>
<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>아이디</label>
<div class='col-sm-10'>
<input class='form-control' id='id' type='text' name='id'>
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
<label for='name' class='col-sm-2 col-form-label'>기업명</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>

<div class='form-group row'>
<label for='businessNo' class='col-sm-2 col-form-label'>사업자등록번호</label>
<div class='col-sm-10'>
<input class='form-control' id='businessNo' type='text' name='businessNo'>
</div>
</div>


<div class='form-group row'>
<label for='kind' class='col-sm-2 col-form-label'>업종</label>
<div class='col-sm-10'>
<input class='form-control' id='kind' type='text' name='kind'>
</div>
</div>


<div class='form-group row'>
<label for='type' class='col-sm-2 col-form-label'>기업형태</label>
<div class='col-sm-10'>
<input class='form-control' id='type' type='text' name='type'>
</div>
</div>


<div class='form-group row'>
<label for='email' class='col-sm-2 col-form-label'>이메일</label>
<div class='col-sm-10'>
<input class='form-control' id='email' type='text' name='email'>
</div>
</div>

<div class='form-group row'>
<label for='post' class='col-sm-2 col-form-label'>주소</label>
<div class='col-sm-10'>
<input class='form-control' id='post' type='text' name='post'>
</div>
</div>

<div class='form-group row'>
<label for='tel' class='col-sm-2 col-form-label'>전화번호</label>
<div class='col-sm-10'>
<input class='form-control' id='tel' type='text' name='tel'>
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