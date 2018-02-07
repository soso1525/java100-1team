<%@page import="java100.app.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>catch</title>
<link rel='stylesheet'
	href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
	<h1>인적성/면접 일정</h1>

	<%-- <jsp:include page="../listToolbar.jsp"/> --%>

	<table class='table table-hover'>
		<thead>
			<tr>
				<th>번호</th>
				<th>유형</th>
				<th>날짜</th>
				<th>시간</th>
				<th>위치</th>
				<th>준비물</th>
				<th>합격여부</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${list}" var="test">
				<tr>
					<td>${test.no}</td>
					<td>${test.type}</td>
					<td>${test.date}</td>
					<td>${test.time}</td>
					<td>${test.location}</td>
					<td>${test.prepare}</td>
					<td><c:if test="${cover.lscheck eq 'y' }">합격</c:if> 
						<c:if test="${cover.lscheck eq 'n' }"> - </c:if></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<button type="button" class='btn btn-primary btn-sm' id="btn-add"
		onclick="location.href='form.jsp'">추가</button>
	<%-- <jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>



<jsp:include page="../jslib.jsp"/> --%>

</body>
</html>

