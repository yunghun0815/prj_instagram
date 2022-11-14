
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<c:if test="${empty email or empty memberId}">
<form action="/member/findPassword" method="post">
<h4>못찾음</h4>
아이디 <input type="text" name="memberId">
이메일  <input type="text" name="email">
<input type="submit" value="확인">
</form>
</c:if>

<c:if test="${not empty email or not empty memberId }">
<h4>찾음</h4>
<h4>${memberId }</h4>
<h4>${password }</h4>
</c:if>

</body>
