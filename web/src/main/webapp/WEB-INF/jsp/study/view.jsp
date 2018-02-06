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
<c:if test="${not empty study}">
<form action='update' method='post'>
<div class='form-group row'>
<label for='photo' class='col-sm-2 col-form-label'></label>
<div class='col-sm-10'>
<img src="${contextPath}/download/${study.simg}" height="300px"/>
</div>
</div>
<div class='form-group row'>
<label for='sno' class='col-sm-2 col-form-label'>번호</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='sno' type='number' name='sno' value='${study.sno}'>
</div>
</div>
<div class='form-group row'>
<label for='sloc' class='col-sm-2 col-form-label'>지역</label>
<div class='col-sm-10'>
<input class='form-control' id='sloc' type='text' name='sloc' value='${study.sloc}'>
</div>
</div>

<div class='form-group row'>
<label for='sname' class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='sname' type='text' name='sname' value='${study.sname}'>
</div>
</div> 
<div class='form-group row'>
<label for='sdesc' class='col-sm-2 col-form-label'>설명</label>
<div class='col-sm-10'>
<input class='form-control' id='sdesc' type='text' name='sdesc' value='${study.sdesc}'>
</div>
</div>
<div class='form-group row'>
<label for='sint' class='col-sm-2 col-form-label'>관심분야</label>
<div class='col-sm-10'>
<input class='form-control' id='sint' type='text' name='sint' value='${study.sint}'>
</div>
</div>
<div class='form-group row'>
<label for='sppl' class='col-sm-2 col-form-label'>인원수</label>
<div class='col-sm-10'>
<input class='form-control' id='sppl' type='number' name='sppl' value='${study.sppl}'>
</div>
</div>
<div class='form-group row'>
<label for='sregdt' class='col-sm-2 col-form-label'>등록날짜</label>
<div class='col-sm-10'>
<input class='form-control' readonly id='sregdt' type='date' value='${study.sregdt}'>
</div>
</div> 
<div class='form-group row'>
<label for='scorp' class='col-sm-2 col-form-label'>대상기업</label>
<div class='col-sm-10'>
<input class='form-control' id='scorp' type='text' name='scorp' value='${study.scorp}'>
</div>
</div>

<div class='form-group row'>
<label for='scheck' class='col-sm-2 col-form-label'>모집상태</label>
<div class='col-sm-10'>
<input class='form-control' id='scheck' type='text' name='scheck' value='${study.scheck}'>
</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>변경</button>
<a href='delete?sno=${study.sno}' class='btn btn-primary btn-sm'>삭제</a>
</div>
</div>
</form>
</c:if>
<c:if test="${empty study}">
        <p>'${param.sno}'번 회원 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    