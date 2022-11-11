<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
<c:if test="${empty member }">
<form:form action="/member/findMemberId" method="post" @modelAttribute="findMemberId">
이메일  : <form:input type="text" path="email" />
<form:errors path="email" class="error"/>
<input type="submit" value="확인"> 
</form:form>
</c:if>

<c:if test="${not empty member }">
<h1>${member.email}</h1>
<h4>이메일에 대한 아이디는</h4>
<h1>${member.memberId}</h1>
</c:if>
</body>
