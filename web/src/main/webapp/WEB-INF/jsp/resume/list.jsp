<%@page import="java100.app.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>이력서목록</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>이력서 목록</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>학력</th><th>경력</th><th>직무</th><th>사진</th><th>자격증</th><th>어학</th>
<th>수상</th><th>전공</th><th>학교명</th><th>학점</th><th>조회수</th><th>동영상</th><th>이력서파일</th>
<th>할말</th><th>공개여부</th><th>회원번호</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="resume">
        <tr>
        	<td><a href='${resume.no}'>${resume.no}</a></td>
        	<td>${resume.education}</td>
	        <td>${resume.career}</td>
	        <td>${resume.kind}</td>
	        <td>${resume.image}</td>
	        <td>${resume.qualification}</td>
	        <td>${resume.language}</td>
	        <td>${resume.award}</td>
	        <td>${resume.major}</td>
	        <td>${resume.schoolName}</td>
	        <td>${resume.grades}</td>
	        <td>${resume.viewCount}</td>
	        <td>${resume.avi}</td>
	        <td>${resume.file}</td>
	        <td>${resume.note}</td>
	        <td>${resume.check}</td>
	        <td>${resume.ino}</td>
        </tr>
</c:forEach>

</tbody>
</table>

<jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    