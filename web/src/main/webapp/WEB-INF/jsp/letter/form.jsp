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
<h1>자소서 지원하기</h1>

<%-- <jsp:include page="../listToolbar.jsp"/> --%>
<form class="form" action="add" method="post" enctype="multipart/form-data">
	<input type="hidden" name="ano" value="${param.ano}">
	<textarea class="form-control" rows="20" name="lcont"></textarea>
	<input type="file"  class="form-control" name="file">
	<input type="submit"  class="form-control" value="지원하기">
</form>

<%-- <jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>



<jsp:include page="../jslib.jsp"/> --%>

</body>
</html>

