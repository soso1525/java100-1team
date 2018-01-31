<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
<style type="text/css">
body {
background: url('../../images/login.png') no-repeat top;
 
}
</style>
</head>
<div>
<div class='container2' style="margin: auto; margin-top: 300px">

<%-- <jsp:include page="../header.jsp"/> --%>


<form class="form-4" action="login" method="post">

<h1>Log In</h1>

    <p>
        <label for="login">Username or email</label>
        <input type="text" name="id" id='id' placeholder="Username or email" value="${cookie.id.value}" required >
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" name='password' placeholder="Password" id="password" required> 
    </p>

    <p>
        <input type="submit" name="submit" value="Continue">
    </p>       

  <a href="../member/form">일반 회원가입</a>
  <a href="../company/form">기업 회원가입</a>


</form>

<jsp:include page="../footer.jsp"/>
</div>
</div>
<body >

<jsp:include page="../jslib.jsp"/>

</body>
</html>
    