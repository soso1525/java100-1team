<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>이력서관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>입사지원 상세 정보</h1>

<c:if test="${not empty letter}">

<form action='update' method='post'>
<div class='form-group row'>
<label for='lsdt' class='col-sm-2 col-form-label'>최근저장일</label>
<div class='col-sm-10'>
<input class='form-control' id='lsdt' type='Date' readonly name='lsdt' value='${letter.lsdt}'>
</div>
</div>
<div class='form-group row'>
<label for='lfile' class='col-sm-2 col-form-label'>파일</label>
<div class='col-sm-10'>
<input class='form-control' id='lfile' type='file' name='lfile' value='${letter.lsdt}'>
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<a href='list' class='btn btn-primary btn-sm'>목록</a>
<button class='btn btn-primary btn-sm' id="btn-enrol">변경</button>
<a href='delete?no=${letter.lno}' class='btn btn-primary btn-sm'>삭제</a>
</div>
</div>
</form>

<table class='table table-hover'>
<thead>
<tr>
<th>문항번호</th><th>문항</th><th>내용</th><th>삭제</th>
</tr>
</thead>
<tbody>
<c:forEach items="${question}" var="question">
            <tr>
        	<td><a href='../question/${question.no}'>${question.no}</a></td>
        	<td>${question.article}</td>
	        <td>${question.context}</td>
	        <td><a href='../question/delete?no=${question.no}'>삭제</a></td>
	        
        </tr> 
</c:forEach>
</tbody>
</table>
</c:if>
<div class='form-group row'>
<div class='col-sm-10'>
<a href='../question/form?lno=${letter.lno}' class='btn btn-primary btn-sm'>추가</a>
</div>
</div>

<c:if test="${empty letter}">
        <p>'${param.no}'번 회원 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    