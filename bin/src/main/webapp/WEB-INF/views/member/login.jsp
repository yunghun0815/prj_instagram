<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="/css/common/common.css">
<link rel="stylesheet" type="text/css" href="/css/member/login.css">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/js/member/login.js"></script>
<fmt:setBundle basename="i18n/member"/>
<!DOCTYPE html>
<html>
<body>
<section class="main flex">
	<div class="phone-image">
		<div>
			<img class="phone" src="/image/member/login_phone.png">
		</div>
		<div class="phone_inner">
			<img src="/image/member/login_phone_inner1.png">
			<img src="/image/member/login_phone_inner2.png">
			<img src="/image/member/login_phone_inner3.png">
			<img src="/image/member/login_phone_inner4.png"> 
		</div>
	</div>
	<div class="login-box">
		<div class="signupForm">
			<a href="/">
				<img src="/image/header/instagram.png">
			</a>
			<form action="<c:url value='/member/login'/>" method="post">
				<input class="formInput" type="text" name="memberId" id="memberId" placeholder="아이디" value="${loginId }"><br>
				<input class="formInput" type="password" name="password" id="password" placeholder="비밀번호" value="${loginPw}"><br>
				<input type="submit" class="submit" value="로그인확인"><br>
			</form>
			<div class="inline-block line"></div>
			<span class="or">또는</span>
			<div class="inline-block line"></div><br>
			${message }<br>
			<a class="findPassword" href="/member/findMemberId">아이디 /</a>
			<a class="findPassword" href="/member/findPassword">비밀번호를 잊으셨나요?</a>
		</div>
		<div class="signupBox">
			<span>계정이 없으신가요?</span>
			<a href="/member/insert">가입하기</a>
		</div>
	</div>
</section>
</body>
</html>