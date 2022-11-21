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
				<input class="formInput" type="text" name="memberId" id="memberId" placeholder="<fmt:message key='MEMBER_ID'/>" value="${loginId }"/><br>
				<input class="formInput" type="password" name="password" id="password" placeholder="<fmt:message key='MEMBER_PW'/>" value="${loginPw}"/><br>
				<input type="submit" class="submit" value="<fmt:message key='LOGIN'/>"/><br>
			</form>
			<div class="inline-block line"></div>
			<span class="or">또는</span>
			<div class="inline-block line"></div><br>
			<c:if test="${not empty message}">
				<span class="error_message">
					<fmt:message key="${message}"/>
				</span><br>
			</c:if>
			<a class="findPassword" href="/member/findMemberId"><fmt:message key="FIND_ACCOUNT"/></a>
		</div>
		<div class="signupBox">
			<span><fmt:message key="SIGN_UP"/></span>
			<a href="/member/insert"><fmt:message key="INSERT_MEMBER_INFO"/></a>
		</div>
	</div>
</section>
</body>
</html>