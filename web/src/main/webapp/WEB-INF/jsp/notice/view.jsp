<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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

<h1>채용정보</h1>

<c:if test="${not empty notice}">
       <form action='update' method='post' enctype="multipart/form-data">
        
        <div class='form-group row'>
        <label for='no' class='col-sm-2 col-form-label'>번호</label>
        <div class='col-sm-10'>
        <input class='form-control' readonly id='no' type='number' 
                name='no' value='${notice.no}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='companyName' class='col-sm-2 col-form-label'>기업명</label>
        <div class='col-sm-10'>
        <input class='form-control' id='companyName' type='text' readonly
                name='companyName' value='${notice.companyMember.name}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='image' class='col-sm-2 col-form-label'>공고이미지</label>
        <div class='col-sm-10'>
        <input type='file' class='form-control' id='image' name='file'>
        </div>
        </div>
        <div class='form-group row'>
        <label for='startDate' class='col-sm-2 col-form-label'>채용시작일</label>
        <div class='col-sm-10'>
        <input class='form-control' id='startDate' type='date' name='startDate'
                value='${notice.startDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <label for='endDate' class='col-sm-2 col-form-label'>채용종료일</label>
        <div class='col-sm-10'>
        <input class='form-control' id='endDate' type='date' name='endDate'
                value='${notice.endDate}'>
        </div>
        </div>
        
        <div class='form-group row'>
        <div class='col-sm-10'>
        <button class='btn btn-primary btn-sm'>변경</button>
        <a href='delete?no=${notice.no}' class='btn btn-primary btn-sm'>삭제</a>
        </div>
        </div>
        </form>
</c:if>
<c:if test="${empty notice}">
        <p>'${param.no}'번 게시물이 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
