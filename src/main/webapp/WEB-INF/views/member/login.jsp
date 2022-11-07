<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<<fmt:setBundle basename="i18n/member"/>
<!DOCTYPE html>
<html>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>
<body>
<c:if test="${empty sessionScope.memberId}">
<form action="<c:url value='/member/login'/>" method="post">
아이디<input type="text" name="memberId" >
비밀번호<input type="password" name="password">

<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
</c:if>
<c:if test="${not empty sessionScope.memberId}">
<h4>${memberId }</h4>
<h4>${email }</h4>
<a href="<c:url value='/member/update'/>">수정</a>
<a href="<c:url value='/member/logout'/>">로그아웃</a>
<a href="<c:url value='/'/>">회원탈퇴</a>
</c:if>
</body>
</html>