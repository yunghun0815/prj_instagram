<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해시태그눌렀을때나올피드</title>

<jsp:include page="../common/header.jsp"></jsp:include>

<style>
table {
	border: 1px solid #444444;
	margin-top: 100px;
	margin-left: auto;
	margin-right: auto;
}

th, td {
	border: 1px solid #444444;
	padding: 20px;
}
</style>

<body>
 
<div style="margin-top: 80px;">
<h1>피드리스트</h1>
	해시태그: ${hashtag} 피드
	<table>
		<tr>
			<th colspan="3">피드 리스트</th>
		</tr>
		<c:forEach var="file" items="${fileList}" varStatus="status">
		
			<c:if test="${(status.index % 3) eq 0}">
				<tr>
			</c:if>
			<td>                     
				<a href='<c:url value="/feed/detail/${file.feedNo}"/>'><img src='<c:url value="/file/${file.fileNo}"/>' width="200"></a>
			</td>
			<c:if test="${(status.index % 3) eq 2 || status.last}">
				</tr>
			</c:if>
			
		</c:forEach>
	</table>	
</div>

</body>
</html>