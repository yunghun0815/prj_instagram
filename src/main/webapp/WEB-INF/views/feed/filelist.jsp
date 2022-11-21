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
	border: 0px solid #444444;
	margin-left: auto;
	margin-right: auto;
	width: 800px;
}

th, td {
	border: 0px solid #444444;
	padding: 15px;
}

#content_img {
	position: relative;
	display: inline-block;
	float: left;
	width: 293px;
	height: 293px;
}

#content_table {
	width: 1000px;
	border-top: 1px solid rgb(230, 230, 230);
}
</style>
<body>
	<div class="container" style="margin-top: 60px;">
		<table>
			<tr>
				<th colspan="2" style="text-align: left;">
					<a href='javascript:history.back();'>
						<img class="back-img" src="/image/sample/back.png" style="width: 50px; height: 50px; float: left;">
					</a>
					<span style="font-size: 38px; font-weight: bold;">&nbsp;#${hashtag}
					</span>
				</th>
				<th style="text-align: right;">
					<span style="font-size: 20pt; color: #4f4848bf;">게시물수: ${hashcount}</span>
					<br/>
					<span style="font-size: 10pt; color: #4f4848bf;">게시물을 확인해보세요</span>
				</th>
			</tr>
			<tr>
				<th colspan="3" style="border-bottom: 1px solid #C6C6C6; padding: 0px;"></th>
			</tr>
			<c:forEach var="file" items="${fileList}" varStatus="status">
				<c:if test="${(status.index % 3) eq 0}">
					<tr>
				</c:if>
				<td><a href='<c:url value="/feed/detail/${file.feedNo}"/>'><img
						id="content_img" src='<c:url value="/file/${file.fileNo}"/>'
						width="200"></a></td>
				<!-- 첫번째칸이 마지막칸인 경우는 2칸추가 -->
				<c:if test="${(status.index % 3) eq 0 && status.last}">
					<td>
						<div style="width: 293px; height: 293px;"></div>
					</td>
					<td>
						<div style="width: 293px; height: 293px;"></div>
					</td>
				</c:if>
				<!-- 두번째칸이 마지막칸인 경우는 1칸추가 -->
				<c:if test="${(status.index % 3) eq 1 && status.last}">
					<td>
						<div style="width: 293px; height: 293px;"></div>
					</td>
				</c:if>
				<c:if test="${(status.index % 3) eq 2}">
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
</body>
</html>