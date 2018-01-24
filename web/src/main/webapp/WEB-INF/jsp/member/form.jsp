<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
 
 <script>
 function change(num)
 {
 var x  = document.form;
 var y = Number(x.count.value) + num;
 if(y < 1) y = 1;
 x.count.value = y;
 }
 </script>

</head>
<body>
<div class='container'>

<jsp:include page="../header.jsp"/>

<h1>회원 가입
</h1>
<form action="add" method='post'>
<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>아이디</label>
<div class='col-sm-10'>
<input class='form-control' id='id' type='text' name='id'>
</div>
</div>
<div class='form-group row'>
<label for='password' class='col-sm-2 col-form-label'>비밀번호</label>
<div class='col-sm-10'>
<input class='form-control' id='password' type='password' name='password'>
</div>
</div>
<div class='form-group row'>
<label for='password' class='col-sm-2 col-form-label'>비밀번호 재확인</label>
<div class='col-sm-10'>
<input class='form-control' id='repassword' type='password' name='repassword'>
</div>
</div>
<div class='form-group row'>
<label for='email' class='col-sm-2 col-form-label'>이름</label>
<div class='col-sm-10'>
<input class='form-control' id='name' type='text' name='name'>
</div>
</div>

<div class='form-group row'>
<label for='email' class='col-sm-2 col-form-label'>생일</label>
<div class='col-sm-10'>
<input class='form-control' id='birth' type='text' name='birth'>
</div>
</div>

  <table>
   <tr>
    <td>갯수</td>
    <td>
     <table>
      <tr>
       <td><input type='text' name='count' value='1' size='3' readonly><td>
       <td>
        <a href='#' onclick='javascript_:change(1);'>▲</a><br>
        <a href='#' onclick='javascript_:change(-1);'>▼</a>
       </td>
      </tr>
     </table>

    </td>
   </tr>
  </table> 

<div class='form-group row'>
<label for='name' class='col-sm-2 col-form-label'>이메일</label>
<div class='col-sm-10'>
<input class='form-control' id='email' type='text' name='email'>
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-primary btn-sm'>등록</button>
</div>
</div>
</form>
</div>

<jsp:include page="../footer.jsp"/>


<jsp:include page="../jslib.jsp"/>

</body>
</html>
    