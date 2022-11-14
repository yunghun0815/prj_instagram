<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:setBundle basename="i18n/member" />
<!DOCTYPE html>
<html>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>

<style type="text/css">
	.error{
	color:Red
	}
</style>
<body>
	<form:form action="/member/insert" method="post" modelAttribute="member">

		<fmt:message key="MEMBER_ID" />
		<form:input path="memberId" required="required"/><br>
		<form:errors path="memberId" class="error"/><br>
		
		비밀번호<form:input type="password" path="password" required="required"/><br>
		<form:errors path="password" class="error"/> <br>
		
		닉네임<form:input path="nickname" required="required"/><br>
		<form:errors path="nickname" class="error"/><br>
		 
		이름<form:input path="name" required="required"/><br>
		<form:errors path="name" class="error"/><br>
		 
		성별 <input type="radio" name="gender" value="female" checked="checked" required="required"/>여자
		 <input type="radio" name="gender" value="male"/>남자<br>
		 
		 이메일 <form:input path="email" required="required"/><br>
		 <form:errors path="email" class="error"/><br>
		 
		 
		생년월일 <form:input type="date" path="birth" required="required"/><br>
		<form:errors path="birth" class="error"/><br>
		 
		핸드폰 번호<form:input path="phoneNumber" required="required"/><br>
		<form:errors path="phoneNumber" class="error"/> <br>
		<input type="submit" value="전송"> 
		<input type="reset" value="취소">

	</form:form>
</body>
