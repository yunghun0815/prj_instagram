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
<h1>개인피드</h1>
멤버아이디 ${memberId }<br>
게시글 수${contentCount }<br>
팔로워 수${followerCount}<br>
팔로우 수 ${followCount }<br>
멤버 닉네임 ${nickname }<br>
이름 ${name }<br>
<table>
<c:forEach var="followerList" items="${ followerList}">
	<tr>
		<td>${followerList }</td>
	</tr>
</c:forEach>
</table>
<table>
<c:forEach var="followList" items="${ followList}">
	<tr>
		<td>${followList }</td>
	</tr>
</c:forEach>
</table>
<table>
	<c:forEach var="contentList" itmes="${contentList }">
		<tr>
			<td>${contentList }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>