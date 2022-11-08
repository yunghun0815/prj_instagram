<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/common/common.css">
<meta charset="UTF-8">
<header>
	<section class="header">
		<input type="hidden" id="memberId" value="${memberId }">
		<div class="flex header-inner between">
			<a href="/">
				<img class="logo" src="/image/header/instagram.png">
			</a>
			<div> <!-- 검색바 -->
				<form action="memberlist" method="post">
					<input class="search-bar" type="text" name="keyword" placeholder="검색">
					<input type="submit" style="display: none;">
				</form>
			</div>
			<div class="menu-img">
				<a href="/log"><img src="/image/header/chart.png"></a>	
				<img src="/image/header/house.png" onclick="window.scrollTo(0,0);">
				<img src="/image/header/plane.png">
				<img src="/image/header/plus.png">
				<img src="/image/header/compass.png">
				<img src="/image/header/heart.png">
				<c:if test="${empty sessionScope.fileNo || sessionScope.fileNo ==0}">
					<a href="#"> <!-- ${sessionScope.nickname} -->
						<img class="profile-img" src="/image/profile_null.jpg">
					</a>				
				</c:if>
				<c:if test="${not empty sessionScope.fileNo && sessionScope.fileNo != 0}">
					<a href="#">
						<img id="myProfileImg" src="/file/${sessionScope.fileNo}">
					</a>
				</c:if>
			</div>
		</div>
	</section>
</header>