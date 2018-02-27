<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>쪽지관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<h1>쪽지등록</h1>
<!-- <form action='add' method='post'> -->
<!-- div class='form-group row'>
<label for='msend' class='col-sm-2 col-form-label'>보낸이</label>
<div class='col-sm-10'>
<input class='form-control' id='msend' type='number' name='msend'>
</div>
</div> -->

<div class='form-group row'>
<label for='mrecv' class='col-sm-2 col-form-label'>받는이</label>
<div class='col-sm-10'>
<input class='form-control' id='mrecv' type='number' name='mrecv'>
</div>
</div> 
<div class='form-group row'>
<label for='mcont' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<input class='form-control' id='mcont' type='text' name='mcont'>
</div>
</div>
<!-- <div class='form-group row'>
<label for='mcheck' class='col-sm-2 col-form-label'>수신여부</label>
<div class='col-sm-10'>
<input class='form-control' id='mcheck' type='text' name='mcheck'>
</div>
</div> -->


<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>


</div>

</body>
</html>