<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
<nav class='navbar navbar-expand-lg navbar-backe bg-red'>

<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>
  <span class='navbar-toggler-icon'></span>
</button>
<div class='collapse navbar-collapse' id='navbarNav'>
<ul style="margin-left: auto; margin-right: auto; font-size: 25px; padding-left:20px; padding-right: 20px" class='navbar-nav mr-auto'>
  <li class='nav-item'>
    <a class='nav-link' href='../score/list' style="margin-left: 30px;">JOB</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../member/list' style="margin-left: 30px;">STUDY</a>
  </li>
  <li class='nav-item'>
    <a class='nav-link' href='../person/list' style="margin-left: 30px;">MYPAGE</a>
  </li>
  <li class='nav-item' style="margin-left: 50px">
    <a class='navbar-brand' href='../index.html'>
  <img src='${contextPath}/images/mar.png' width='25' height='25' class='d-inline-block' alt=''>
</a>
  </li>
</ul>

</div>
</nav>
</header>