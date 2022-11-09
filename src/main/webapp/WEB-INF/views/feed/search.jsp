<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <fmt:setBundle basename="앞으로만들폴더명/board"> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/header.jsp"></jsp:include>
<body>
<div class="container">

	<div class="content" style="margin: 100px;">
	<!-- 테스트용 소스코드 : 나중에 필요없어지면 지우자-->
	테스트용 -> ${attribute1}
	<br/>
	<br/>
	검색결과 : ↓
	<br/>
	<c:forEach var="member" items="${memberList}">

<span>아이디: ${member.memberId}</span> <span>이름: ${member.name}</span> <br/>

	</c:forEach>
	
</div>
			
				

</div>
</body>
</html>