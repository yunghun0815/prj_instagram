<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<meta charset="UTF-8">
<html>
<head>
	<title>Instagram</title>
</head>
<jsp:include page="common/header.jsp"></jsp:include>
<body>
	<section class="main">
		<ul class="feed-ul"> 
			<li class="feed-li flex"> <!-- DB에서 값 받아서 반복해야 함 -->
				<div class="feed-img-box"><!-- 게시물 상단바 , 프로필사진, 아이디 -->
					<div class="feed-header">
						<!-- <div class="profile-img" style="background-image: url('/image/dog.png')"></div> -->
						<img class="profile-img " src="/image/dog.png">
						<span>hyeonu_0407</span>
					</div>
					<img class="feed-img" src="/image/sample.jpg">				
				</div>
				<div class="feed-desc-box">
					<ol>
						<li><span class="bold">hoon1234</span>
						    <span>게시글내용</span><br>
						    <span class="hashtag">#골프 #안녕</span>
						</li>
						<li>
							<img id="heart_blank" src="/image/heart.png" onclick="like(this)">
							<img id="heart_color" src="/image/heart_color.png" style="display: none" onclick="likeCancel(this)">
							<img src="/image/speech.png" onclick="replyFocus(this)">
							<img src="/image/plane.png">
						</li>
						<li>
							<span class="bold">좋아요<span id="like_count">90</span>개</span>	
							<span class="upload-date">2022년 11월 1일</span>	
						</li>
						<li class="reply-list">
							<div>
								<img src="/image/bear.png" class="profile-img reply-profile">
								<p class="inline-block"><!-- 최대 24개 가능  -->
									<span class="bold">sdkfo2494</span><!-- 아이디 -->
									<span>안녕하세요~</span><!-- 댓글내용  --><br>
									<span class="upload-date">2022-11-02</span>
								</p>
							</div>
						</li>
					</ol>
					<hr class="gray-line">
					<div><!-- 댓글달기 -->
						<form action="/" method="post">
							<img src="/image/face.png">
							<input id="replyInput" type="text" placeholder="댓글 달기...">
							<input type="submit" value="게시" >
						</form> 
					</div>
				</div>
			</li>
			<li class="feed-li flex"> <!-- DB에서 값 받아서 반복해야 함 -->
				<div class="feed-img-box"><!-- 게시물 상단바 , 프로필사진, 아이디 -->
					<div class="feed-header">
						<!-- <div class="profile-img" style="background-image: url('/image/dog.png')"></div> -->
						<img class="profile-img " src="/image/dog.png">
						<span>hyeonu_0407</span>
					</div>
					<img class="feed-img" src="/image/sample.jpg">				
				</div>
				<div class="feed-desc-box">
					<ol>
						<li><span class="bold">hoon1234</span>
						    <span>게시글내용</span><br>
						    <span class="hashtag">#골프 #안녕</span>
						</li>
						<li>
							<img id="heart_blank" src="/image/heart.png" onclick="like(this)">
							<img id="heart_color" src="/image/heart_color.png" style="display: none" onclick="likeCancel(this)">
							<img src="/image/speech.png" onclick="replyFocus(this)">
							<img src="/image/plane.png">
						</li>
						<li>
							<span class="bold">좋아요<span id="like_count">90</span>개</span>	
							<span class="upload-date">2022년 11월 1일</span>	
						</li>
						<li class="reply-list">
							<div>
								<img src="/image/bear.png" class="profile-img reply-profile">
								<p class="inline-block"><!-- 최대 24개 가능  -->
									<span class="bold">sdkfo2494</span><!-- 아이디 -->
									<span>안녕하세요~</span><!-- 댓글내용  --><br>
									<span class="upload-date">2022-11-02</span>
								</p>
							</div>
						</li>
					</ol>
					<hr class="gray-line">
					<div><!-- 댓글달기 -->
						<form action="/" method="post">
							<img src="/image/face.png">
							<input id="replyInput" type="text" placeholder="댓글 달기...">
							<input type="submit" value="게시">
						</form> 
					</div>
				</div>
			</li>
		</ul>
	</section>
</body>
</html>