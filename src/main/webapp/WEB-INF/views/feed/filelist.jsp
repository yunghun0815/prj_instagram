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
table {   <%-- 수정해야함 --%>
	border: 0px solid #444444;
	margin-top: 50px;
	margin-left: auto;
	margin-right: auto;
	width: 800px;
}

th, td {   <%-- 수정해야함  --%>
	border: 0px solid #444444;   
	padding: 10px;
}


img {

  width: 300px;
  object-fit: cover;
}

<%-- 수정해야 함 --%>

</style>

<body>
<div class="back-img">
 	<a href='<c:url value="/getmemberlist/{keyword}"/>'><img class="back-img" src="/image/sample/back.png"  style="width: 50px; height: 50px; float: left;  " ></a> </div>


<div style="margin-top: 90px;">



	
	
	<table>
		<tr>
			<th colspan="3"> 해시태그: ${hashtag} 피드리스트 <br> 
			<span style="font-size: 10pt; color: #4f4848bf">게시물 수: ${hashcount}</span></th>  
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