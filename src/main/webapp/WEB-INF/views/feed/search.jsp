<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Instagram_search</title>


<style>
table {
	/* border: 1px solid #444444; */
	margin-left: auto;
	margin-right: auto;
}

th, td {
	border: 1px solid #444444;
	padding: 20px;
}
</style>
</head>

<jsp:include page="../common/header.jsp"></jsp:include>
<body>

	<div class="card"
		style="text-align: center; margin: 80px 20px 20px 20px;">

		<div class="card-header">

			<ul class="nav nav-pills nav-fill">
				<li class="nav-item"><a class="nav-link text-dark" href="#"
					aria-disabled="true">계 정</a></li>
				<li class="nav-item"><a class="nav-link text-dark" href="#"
					aria-disabled="true">태 그</a></li>
			</ul>

		</div>
		<div class="card-body">
			<div class="row">
				<div class="col">
					<c:forEach var="member" items="${memberList}">
						<div class="row card m-1">
							<div class="col card-body" style="height: 80px; line-height: 48px;">
								아이디:<a href='<c:url value="/userfeed/${member.memberId}"/>'>${member.memberId}</a>
								이름:<a href='<c:url value="/userfeed/${member.memberId}"/>'>${member.nickname}</a>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="col">
					<c:forEach var="hashtag" items="${hashtagList}">
						<div class="row card m-1">
							<div class="col card-body" style="height: 80px;">
								<span>해시태그: <a
									href='<c:url value="/filelist/${hashtag.hashtag}"/>'>${hashtag.hashtag}</a></span>
								<br /> <span style="font-size: 8pt;">카운트: ${hashtag.cnt}</span>
							</div>
						</div> 
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
</body>
</html>