<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
<nav class='navbar navbar-expand-lg navbar-light bg-red'>

<c:if test="${empty menuVisible or menuVisible == true}">
<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
  <span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
<ul class='navbar-nav mr-auto'>
  <li class='nav-item' style="margin-left:0px; margin-top:0px; padding-right: 20px; font-size: 50px;">
    <a class='nav-link' href='../member/list'>CATCH</a>
  </li>
  <li class='nav-item' style="margin-left:353px; margin-top:85px;">
    <a class='nav-brand' href='../score/list'>
    <img src='${contextPath}/images/2_1.png' width='98' height='30' class='d-inline-block' alt=''>
    </a>
  </li>
  <li class='nav-item' style="margin-left:20px; margin-top:85px;">
    <a class='nav-brand' href='../study/form'>
    <img src='${contextPath}/images/2_2.png' width='98' height='30' class='d-inline-block' alt=''>
    </a>
  </li>
  <li class='nav-item' style="margin-left:20px; margin-top:85px;">
    <a class='nav-brand' href='../score/list'>
    <img src='${contextPath}/images/2_3.png' width='98' height='30' class='d-inline-block' alt=''>
    </a>
  </li>
  <c:choose>
    <c:when test="${sessionScope.loginUser != null}">
        <%-- ${sessionScope.loginUser.id} --%>
        <li class='nav-item' style="margin-left:20px; margin-top:85px;">
    <a class='nav-brand' href='${contextPath}/app/auth/logout'>
    <img src='${contextPath}/images/2_5.png' width='98' height='30' class='d-inline-block' alt=''>
    </a>
  </li>
    </c:when>

    <c:otherwise>
       <li class='nav-item' style="margin-left:20px; margin-top:85px;">
    <a class='nav-brand' href='${contextPath}/app/auth/login'>
    <img src='${contextPath}/images/2_4.png' width='98' height='30' class='d-inline-block' alt=''>
    </a>
  </li>
    </c:otherwise>
</c:choose>
</ul>



</div>
</c:if>

</nav>
</header>

