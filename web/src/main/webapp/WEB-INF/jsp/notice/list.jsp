<%@page import="java100.app.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>기업목록</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>기업 목록</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이미지</th><th>기업이름</th><th>기업로고</th><th>채용시작일</th><th>채용종료일</th><th>조회수</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="notice">
        <tr>
        	<td><a href='${notice.no}'>${notice.no}</a></td>
        	<td>${notice.image}</td>
	        <td>${notice.companyMember.name}</td>
	        <td>${notice.companyMember.logo}</td>
	        <td>${notice.startDate}</td>
	        <td>${notice.endDate}</td>
	        <td>${notice.viewCount}</td>
        </tr>
</c:forEach>

</tbody>
</table>
<button type="button" class='btn btn-primary btn-sm' id="btn-add" onclick="location.href='form'">추가</button>
<jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    