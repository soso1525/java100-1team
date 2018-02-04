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

<h1>이력서 상세 정보</h1>

<c:if test="${not empty resume}">

<form action='update' method='post'>
<div class='form-group row'>
<label for='no' class='col-sm-2 col-form-label'>번호</label>
<div class='col-sm-10'>
<input class='form-control' id='no' type='text'
 name='no' value='${resume.no}'>
</div>
</div>
<div class='form-group row'>
<label for='education' class='col-sm-2 col-form-label'>학력</label>
<div class='col-sm-10'>
<input class='form-control' id='education' type='text'
 name='education' value='${resume.education}'>
</div>
</div>
<div class='form-group row'>
<label for='career' class='col-sm-2 col-form-label'>경력</label>
<div class='col-sm-10'>
<input class='form-control' id='career' type='number' name='career' value='${resume.career}'>
</div>
</div>
<div class='form-group row'>
<label for='kind' class='col-sm-2 col-form-label'>직종</label>
<div class='col-sm-10'>
<input class='form-control' id='kind' type='text' name='kind' value='${resume.kind}'>
</div>
</div>
<div class='form-group row'>
<label for='image' class='col-sm-2 col-form-label'>사진</label>
<div class='col-sm-10'>
<input class='form-control' id='image' type='text' name='image' value='${resume.image}'>
</div>
</div>
<div class='form-group row'>
<label for='qualification' class='col-sm-2 col-form-label'>자격증</label>
<div class='col-sm-10'>
<input class='form-control' id='qualification' type='text' name='qualification' value='${resume.qualification}'>
</div>
</div>
<div class='form-group row'>
<label for='language' class='col-sm-2 col-form-label'>어학</label>
<div class='col-sm-10'>
<input class='form-control' id='language' type='text' name='language' value='${resume.language}'>
</div>
</div>
<div class='form-group row'>
<label for='award' class='col-sm-2 col-form-label'>수상</label>
<div class='col-sm-10'>
<input class='form-control' id='award' type='text' name='award' value='${resume.award}'>
</div>
</div>

<div class='form-group row'>
<label for='major' class='col-sm-2 col-form-label'>전공</label>
<div class='col-sm-10'>
<input class='form-control' id='major' type='text' name='major' value='${resume.major}'>
</div>
</div>
<div class='form-group row'>
<label for='schoolName' class='col-sm-2 col-form-label'>학교명</label>
<div class='col-sm-10'>
<input class='form-control' id='schoolName' type='text' name='schoolName' value='${resume.schoolName}'>
</div>
</div>
<div class='form-group row'>
<label for='grades' class='col-sm-2 col-form-label'>학점</label>
<div class='col-sm-10'>
<input class='form-control' id='grades' type='text' name='grades' value='${resume.grades}'>
</div>
</div>
<div class='form-group row'>
<label for='avi' class='col-sm-2 col-form-label'>1분 동영상</label>
<div class='col-sm-10'>
<input class='form-control' id='avi' type='text' name='avi' value='${resume.avi}'>
</div>
</div>
<div class='form-group row'>
<label for='file' class='col-sm-2 col-form-label'>파일</label>
<div class='col-sm-10'>
<input class='form-control' id='file' type='text' name='file' value='${resume.file}'>
</div>
</div>

<div class='form-group row'>
<label for='note' class='col-sm-2 col-form-label'>할말</label>
<div class='col-sm-10'>
<input class='form-control' id='note' type='text' name='note' value='${resume.note}'>
</div>
</div>

<div class='form-group row'>
<label for='check' class='col-sm-2 col-form-label'>공개여부</label>
<div class='col-sm-10'>
<input class='form-control' id='check' type='text' name='check' value='${resume.check}'>
</div>
</div>

<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm' id="btn-enrol">변경</button>
<a href='delete?no=${resume.no}' class='btn btn-primary btn-sm'>삭제</a>
</div>
</div>
</form>
</c:if>
<c:if test="${empty resume}">
        <p>'${param.no}'번 회원 정보가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>

</div>

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    