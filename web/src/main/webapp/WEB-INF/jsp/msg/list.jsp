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
<!-- <link rel='stylesheet' href='../../css/reset.css'> -->
<style type="text/css">
body {
/* background-image: url('../../images/back.png'); */
background: url('../../images/back.png') no-repeat top;
/* background-size: 100%; */
/* background-repeat: no-repeat;
background-position: 50% 50%; */
/* background-attachment: fixed; */
}
</style>
</head>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>쪽지 목록</h1>

<%-- <jsp:include page="../listToolbar.jsp"/> --%>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>보낸이</th><th>받는이</th><th>발신날짜</th>
<th>내용</th><th>수신여부</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="msg">
    <tr>
        <td>${msg.mno}</td>
        <td>${msg.msend}</td>
        <td><a href='${msg.mno}'>${msg.mrecv}</a></td>
        <td>${msg.mdt}</td>
        <td>${msg.mcont}</td>
        <td>${msg.mcheck}</td>
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