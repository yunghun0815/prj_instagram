<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>
<body>
<form action="/member/update" enctype="multipart/form-data" method="post"> 
	아아디 : <input type="text" name="memberId" value="${member.memberId }" 
	${empty member.memberId ? "" : "readonly"}
	placeholder='<fmt:message key="MEMBER_ID"/>' required="required">
	
	비밀번호<input type="password" name="password" 
		title='<fmt:message key="PASSWORD_TITLE"/>'
		value="${member.password }"
		required="required">
	
	비밀번호 확인<input type="password" name="password_re" 
	value="${member.password }"
	required="required">
	
	닉네임<input type="text" name="nickname"
	value="${member.nickname }">
	
	휴대폰<input type="text" name="phoneNumber"
	value="${member.phoneNumber }">
	<c:if test="${empty fileNo }">
		<input type="hidden" name="fileNo" value=0>
	</c:if>
	<c:if test="${not empty fileNo }">
		<input type="hidden" name="fileNo" value="${fileNo }"> 
	</c:if>
	사진<input type="file" name="file">
	
	<input type="submit" value="수정">
</form>
</body>
</html>