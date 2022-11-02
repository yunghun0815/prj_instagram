<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/common/common.css">
<meta charset="UTF-8">
<header>
	<section class="header">
		<div class="flex header-inner between">
			<a href="/">
				<img class="logo" src="/image/header/instagram.png">
			</a>
			<div> <!-- 검색바 -->
				<form action="#" method="get">
					<input class="search-bar" type="text" placeholder="검색">
					<input type="submit" style="display: none;">
				</form>			
			</div>
			<div class="menu-img">
				<img src="/image/header/house.png">
				<img src="/image/header/plane.png">
				<img src="/image/header/plus.png">
				<img src="/image/header/compass.png">
				<img src="/image/header/heart.png">
				<div class="profile-img" style="background-image: url('/image/dog.png')"></div>
			</div>
		</div>
	</section>
</header>