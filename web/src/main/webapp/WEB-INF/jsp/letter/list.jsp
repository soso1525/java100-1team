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
<h1>기업 목록</h1>

<%-- <jsp:include page="../listToolbar.jsp"/> --%>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>내용</th><th>저장일시</th><th>마감일</th><th>제출여부</th>
<th>합격여부</th><!-- <th>첨삭완료파일</th> --><th>지원회사</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="cover">
      <tr>
      	<td>${cover.lno}</td>
      	<td>${cover.lcont }[F]</td>
      	<td>${cover.lsdt}</td>
      	<td>${cover.ledt}</td>
      	<td>
      		<c:if test="${cover.lscheck eq 'y' }">제출완료</c:if>
      		<c:if test="${cover.lscheck eq 'n' }">미제출</c:if>
      	</td>
      	<td>${cover.lpcheck}</td>
      	<%-- <td>${lts.lfile}</td> --%>
      	<td>${cover.ano.aname}</td>
      	<td><a href='delete?no=${cover.lno}'>삭제</a></td>
      </tr>
</c:forEach>

</tbody>
</table>
<button type="button" class='btn btn-primary btn-sm' id="btn-add" onclick="location.href='form.jsp'">추가</button>
<%-- <jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>



<jsp:include page="../jslib.jsp"/> --%>

</body>
</html>

