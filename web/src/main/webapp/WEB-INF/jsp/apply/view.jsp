<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>이력서관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>입사지원 상세 정보</h1>

<c:if test="${not empty apply}">

<form action='letter/add' method='post'>
<div class='form-group row'>
<label for='no' class='col-sm-2 col-form-label'>입사지원번호</label>
<div class='col-sm-10'>
<input class='form-control' id='no' type='text'
 name='no' value='${apply.ano}'>
</div>
</div>
<div class='form-group row'>
<label for='education' class='col-sm-2 col-form-label'>기업명</label>
<div class='col-sm-10'>
<input class='form-control' id='education' type='text'
 name='aname' value='${apply.aname}'>
</div>
</div>
<div class='form-group row'>
<label for='career' class='col-sm-2 col-form-label'>신청일</label>
<div class='col-sm-10'>
<input class='form-control' id='adt' type='Date' name='adt' value='${apply.adt}'>
</div>
</div>
<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>내용</th><th>저장일시</th><th>마감일</th><th>제출여부</th>
<th>합격여부</th><th>지원회사</th>
</tr>
</thead>
<tbody>
<c:forEach items="${letter}" var='letter'>
      <tr>
      	<td><a href='../letter/${letter.lno}'>${letter.lno}</a></td>
      	<td>${letter.lsdt}</td>
      	<td>${letter.ledt}</td>
      	<td>${letter.lpcheck}</td>
      	<td>${letter.lfile}</td>
      	<td>${letter.apply.aname}</td>
      	<td><a href='../letter/delete?no=${letter.lno}'>삭제</a></td>
      </tr>
</c:forEach>

</tbody>
</table>
<div class='form-group row'>
<div class='col-sm-10'>
<a href='list' class='btn btn-primary btn-sm'>목록</a>
<button class='btn btn-primary btn-sm' id="btn-enrol">변경</button>
<a href='../letter/form?ano=${apply.ano}' class='btn btn-primary btn-sm'>추가</a>
<a href='delete?no=${apply.ano}' class='btn btn-primary btn-sm'>삭제</a>
</div>
</div>
</form>
</c:if>

<c:if test="${empty apply}">
        <p>'${param.no}'번 회원 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    