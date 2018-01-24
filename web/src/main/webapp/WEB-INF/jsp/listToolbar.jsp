<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<nav class="navbar navbar-light justify-content-between">
	<form style="margin-left: auto; margin-right: auto;" class="form-inline" action="list">
		<input name="words" class="form-control form-control-sm mr-sm-2"
			type="search" placeholder="keyword" aria-label="Search"> 
		<select class="form-control form-control-sm mr-sm-2">
			<option>서비스업</option>
			<option>제조/화학</option>
			<option>IT/웹/통신</option>
			<option>은행/금융업</option>
			<option>미디어/디자인</option>
			<option>교육업</option>
			<option>의료/제약/복지</option>
			<option>판매/유통</option>
			<option>건설업</option>
			<option>기관/협회</option>
		</select> 
		<input name="words" class="form-control form-control-sm mr-sm-2"
			type="search" placeholder="검색" aria-label="Search"> 
		<input name="ctype" class="form-control form-control-sm mr-sm-2"
			type="checkbox">신입
		<button style="margin-left: 10px"
			class="btn btn-sm btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>
</nav>

