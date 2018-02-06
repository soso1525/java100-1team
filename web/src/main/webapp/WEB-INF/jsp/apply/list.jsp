<%@page import="java100.app.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>입사지원목록</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<%-- <jsp:include page="../header.jsp"/> --%>

<h1>입사지원 목록</h1>

<%-- <jsp:include page="../listToolbar.jsp"/> --%>

<table class='table table-hover'>
<thead>
<tr>
<th>입사지원번호</th><th>기업명</th><th>신청일</th><th>삭제</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="apply">
        <tr>
        	<td><a href='${apply.ano}'>${apply.ano}</a></td>
        	<td>${apply.aname}</td>
	        <td>${apply.adt}</td>
	        <td><a href='delete?no=${apply.ano}'>삭제</a></td>
	        
        </tr>
</c:forEach>

</tbody>
</table>
<button type="button" class='btn btn-primary btn-sm' id="btn-add" onclick="location.href='form'">추가</button>

<%-- <jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/> --%>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    