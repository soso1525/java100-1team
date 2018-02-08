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

<h1>스터디 목록</h1>

<%-- <jsp:include page="../listToolbar.jsp"/> --%>

<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>지역</th><th>이름</th><th>관심분야</th>
<th>인원수</th><th>등록일</th><th>대상기업</th><th>모집상태</th><th>이미지</th>
</tr>
</thead>
<tbody>

<c:forEach items="${list}" var="study">
    <tr>
        <td>${study.sno}</td>
        <td><a href='${study.sno}'>${study.sloc}</a></td>
        <td>${study.sname}</td>
        <td>${study.sint}</td>
        <td>${study.sppl}</td>
        <td>${study.sregdt}</td>
        <td>${study.scorp}</td>
        <td>${study.scheck}</td>
        <td><img src="${contextPath}/download/${study.simg}" height="50px"/></td>
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