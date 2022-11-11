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
    
<%-- 전부 수정해야 함 한 번에 화면에 나오게.. --%>  

<style>
	table {
	margin: 200px;
	}
	th, td {
	padding: 20px;
	}
</style>
</head>

<jsp:include page="../common/header.jsp"></jsp:include>
<body>
<div>
<table>
    <tr>
    	<th>계정</th>
       <td>  <c:forEach var="member" items="${ memberList}">
                  </c:forEach></td>
       <td>  아이디: ${memberId}  이름: ${nickname}<br/>  </td>

  
      	<th>태그</th>
      	<td>
		<c:forEach var="hashtag" items="${ hashtagList}">
				</c:forEach></td>
	<td>		해시태그: ${ hashtag} </td>

	</tr>
</table>
</div>

</body>
</html>