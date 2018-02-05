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
<style type="text/css">
body {
/* background-image: url('../../images/back.png'); */
/* background: url('../../images/back.png') no-repeat top;
/* background-size: 100%; */ 
/* background-repeat: no-repeat;
background-position: 50% 50%; */
/* background-attachment: fixed; */
}
</style>
</head>
<body>
<h1>기업 목록</h1>

<jsp:include page="../listToolbar.jsp"/>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>내용</th><th>저장일시</th><th>마감일</th><th>제출여부</th>
<th>합격여부</th><!-- <th>첨삭완료파일</th> --><th>지원회사</th>
</tr>
</thead>
<tbody>

<c:forEach items="${letters}" var="lts">
      <tr>
      	<td>${lts.lno}</td>
      	<td>${lts.lcont }[F]</td>
      	<td>${lts.lsdt}</td>
      	<td>${lts.ledt}</td>
      	<td>
      		<c:if test="${lts.lscheck eq 'y' }">제출완료</c:if>
      		<c:if test="${lts.lscheck eq 'n' }">미제출</c:if>
      	</td>
      	<td>${lts.lpcheck}</td>
      	<%-- <td>${lts.lfile}</td> --%>
      	<td>${lts.ano.aname}</td>
      </tr>
</c:forEach>

</tbody>
</table>

<%-- <jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>



<jsp:include page="../jslib.jsp"/> --%>

</body>
</html>

