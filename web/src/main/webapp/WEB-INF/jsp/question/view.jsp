<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>문항관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>문항 상세 정보</h1>

<c:if test="${not empty question}">

<form action='update' method='post'>
<div class='form-group row'>
<label for='no' class='col-sm-2 col-form-label'>번호</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='no' type='text'
 name='no' value='${question.no}'>
</div>
</div>
<div class='form-group row'>
<label for='article' class='col-sm-2 col-form-label'>문항</label>
<div class='col-sm-10'>
<input class='form-control' id='education' type='text'
 name='article' value='${question.article}'>
</div>
</div>
<div class='form-group row'>
<label for='context' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<input class='form-control' id='context' type='text' name='context' value='${question.context}'>
</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm' id="btn-enrol">변경</button>
<a href='delete?no=${resume.no}' class='btn btn-primary btn-sm'>삭제</a>
</div>
</div>
</form>
</c:if>


<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    