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

<h1>문항
</h1>
<form action='add' method='post'>
<input type="hidden" name="lno" value="${param.lno}">
<div class='form-group row'>
<label for='article' class='col-sm-2 col-form-label'>문항</label>
<div class='col-sm-10'>
<input class='form-control' id='article' type='text' name='article'>
</div>
</div>
<div class='form-group row'>
<label for='context' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<textarea class='form-control' id='context' rows="20" name='context'></textarea>
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