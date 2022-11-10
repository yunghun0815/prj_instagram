<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<style type="text/css">
.error{
	color:red
}
</style>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>
<body>
<form:form action="/member/update" enctype="multipart/form-data" method="post" modelAttribute="memberUpdate"> 

	아아디 : <input type="text" name="memberId" value="${sessionScope.memberId }" 
	${empty sessionScope.memberId ? "" : "readonly"} required="required" />
	
	비밀번호<form:input type="password" path="password" value="${member.password }"
		required="required"/>
		<form:errors path="password" class="error"/><br>
	
	닉네임<form:input type="text" path="nickname"
	value="${member.nickname }"/>
	<form:errors path="nickname" class="error"/><br>
	
	휴대폰<form:input type="text" path="phoneNumber"
	value="${member.phoneNumber }"/>
	<form:errors path="phoneNumber" class="error"/><br>
	<c:if test="${empty fileNo }">
		<input type="hidden" name="fileNo" value=0>
	</c:if>
	<c:if test="${not empty fileNo }">
		<input type="hidden" name="fileNo" value="${fileNo }"> 
	</c:if>
	사진<input type="file" name="file">
	
	<input type="submit" value="수정">
</form:form>
</body>
</html>