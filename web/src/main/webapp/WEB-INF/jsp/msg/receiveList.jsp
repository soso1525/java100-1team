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

<h1>받은 쪽지 목록</h1>

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
        <td>${msg.mrecv}</td>
        <td>${msg.mdt}</td>
        <td>${msg.mcont}</td>
        <c:if test="${msg.mcheck!=0}"><td><a href='${msg.mno}'>읽은쪽지</a></td></c:if>
        <c:if test="${msg.mcheck==0}"><td><a href='${msg.mno}'>안읽은쪽지</a></td></c:if>
    </tr>
</c:forEach>

<a href="sendList">보낸쪽지함</a>
</tbody>
</table>
<button type="button" class='btn btn-primary btn-sm' id="btn-add" onclick="location.href='form'">추가</button>
<c:set var="prevPageDisabled" value="${(pageNo > 1) ? '':'disabled'}"/>
<c:set var="prevPageTabIndex" value="${(pageNo > 1) ? 0 : -1}"/>
<c:set var="nextPageDisabled" value="${(pageNo < lastPageNo) ? '':'disabled'}"/>
<c:set var="nextPageTabIndex" value="${(pageNo < lastPageNo) ? 0 : -1}"/>

<nav aria-label="Page navigation">
  <ul class="pagination justify-content-center">
    <li class="page-item ${prevPageDisabled}"><a class="page-link" 
        href="receiveList?pn=${pageNo - 1}"
        tabindex="${prevPageTabIndex}">이전</a></li>
        
    <li class="page-item"><a class="page-link" href="#">${pageNo}</a></li>
    
    <li class="page-item ${nextPageDisabled}"><a class="page-link" 
        href="receiveList?pn=${pageNo + 1}"
        tabindex="${nextPageTabIndex}">다음</a></li>
  </ul>
</nav>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>
</body>
</html>