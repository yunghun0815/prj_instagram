<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty email or empty memberId}">
<form action="/member/findPassword" method="post">
아이디 <input type="text" name="memberId">
이메일  <input type="email" name="email">
<input type="submit" value="확인">
</form>
</c:if>

<c:if test="${not empty email or empty memberId }">
<h4>${memberId }</h4>
<h4>${password }</h4>
</c:if>

</body>
</html>