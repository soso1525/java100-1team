<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>스터디관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>스터디 상세 정보</h1>
<c:if test="${not empty msg2}">
<form method='get'>
<div class='form-group row'>
<label for='msend' class='col-sm-2 col-form-label'>보낸이</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='msend' type='number' name='msend' value="${writer.no}">
</div>
</div>
<div class='form-group row'>
<label for='mrecv' class='col-sm-2 col-form-label'>받는이</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='mrecv' type='number' name='mrecv' value="${msg2.mrecv}">
</div>
</div> 
<div class='form-group row'>
<label for='mdt' class='col-sm-2 col-form-label'>보낸날짜</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='mdt' type='Date' name='mdt' value="${msg2.mdt}">
</div>
</div> 
<div class='form-group row'>
<label for='mcont' class='col-sm-2 col-form-label'>내용</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='mcont' type='text' name='mcont' value="${msg2.mcont}">
</div>
</div>
<%-- <div class='form-group row'>
<label for='mcheck' class='col-sm-2 col-form-label'>수신여부</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='mcheck' type='number' value="${msg.mcheck}">
</div>
</div> --%>

<div class='form-group row'>
<div class='col-sm-10'>
<a href='delete?mno=${msg2.mno}' class='btn btn-primary btn-sm'>삭제</a>
</div>
</div>
</form>
</c:if>
<c:if test="${empty msg2}">
        <p>'${param.mno}'번 회원 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    