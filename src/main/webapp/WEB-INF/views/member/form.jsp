<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n/member"/>
<!DOCTYPE html>
<html>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>
<body>
<form action="<c:url value='/member/insert'/>" method="post">

<fmt:message key="MEMBER_ID"/>
<input type="text" name="memberId"
title="<fmt:message key='MEMBER_TITLE'/>"
placeholder='<fmt:message key="MEMBER_ID"/>' required="required"><br>

비밀번호<input type="password" name="password"><br>
닉네임<input type="text" name="nickname"><br>
이름<input type="text" name="name"><br>
성별 <input type="radio" name="gender" value="female">여자
<input type="radio" name="gender" value="male">남자<br>
이메일 <input type="text" name="email"><br>
생년/월/일 <input type="date" name="birth"><br>
핸드폰 번호<input type="text" name="phoneNumber"><br>

<input type="submit" value="전송">
<input type="reset" value="취소">

</form>
</body>
</html>