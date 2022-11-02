<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<meta charset="UTF-8">
<html>
<head>
	<title>Instagram</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<jsp:include page="common/header.jsp"></jsp:include>
<script type="text/javascript">
	$(function(){
		var heartBlank = $("#heart_blank"); //색 없는 하트(좋아요 버튼)
		var heartColor = $("#heart_color"); //색 있는 하트(좋아요 취소 버튼)
		
		heartColor.hide();
		
		heartBlank.click(function(){ //좋아요
			$(this).hide(); //색 없는 하트 없앰
			$(this).next().show(); //색 있는 하트 보여줌
			//현재 피드 좋아요 객체
			var likeCountHtml = $(this).parent().parent().find($("#like_count"));
			//현재 피드 좋아요 수
			var likeCount = parseInt($(this).parent().parent().find($("#like_count")).html());
			//좋아요 클릭 시 +1 
			likeCountHtml.html(likeCount+1);
			//비동기로 좋아요 테이블에 해당 아이디
			/* $.ajax({ 
				url:,
				type: "POST",
				data: {
					feedNo: "", 
					id: ""
				},
				success: function(result){
					
				}
			}); */
		});
		
		heartColor.click(function(){ //좋아요 취소
			$(this).hide();
			$(this).prev().show();
			//현재 피드 좋아요 객체
			var likeCountHtml = $(this).parent().parent().find($("#like_count"));
			//현재 피드 좋아요 수
			var likeCount = parseInt($(this).parent().parent().find($("#like_count")).html());
			//좋아요 클릭 시 -1 
			likeCountHtml.html(likeCount-1);
			//비동기로 좋아요 테이블 해당 아이디 삭제
			/* $.ajax({
				url:,
				type: "POST",
				success: function(result){
					
				}
			}); */
		});
	});
</script>
<body>
	<section class="main">
		<ul class="feed-ul"> 
			<li class="feed-li flex"> <!-- DB에서 값 받아서 반복해야 함 -->
				<div class="feed-img-box"><!-- 게시물 상단바 , 프로필사진, 아이디 -->
					<div class="feed-header">
						<div class="profile-img" style="background-image: url('/image/dog.png')"></div>
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
							<img id="heart_blank" src="/image/heart.png">
							<img id="heart_color" src="/image/heart_color.png">
							<img src="/image/speech.png">
							<img src="/image/plane.png">
						</li>
						<li>
							<span class="bold">좋아요<span id="like_count">90</span>개</span>	
							<span class="upload-date">2022년 11월 1일</span>	
						</li>
						<li class="reply-list">
							<div>
								<div class="profile-img" style="background-image: url('/image/bear.png')"></div>
								<p class="inline-block"><!-- 최대 24개 가능  -->
									<span class="bold">sdkfo2494</span><!-- 아이디 -->
									<span>안녕하세요~</span><!-- 댓글내용  --><br>
									<span class="upload-date">2022-11-02</span>
								</p>
							</div>
							<div>
								<div class="profile-img" style="background-image: url('/image/bear.png')"></div>
								<p class="inline-block"><!-- 최대 24개 가능  -->
									<span class="bold">bbmba22</span><!-- 아이디 -->
									<span>ㅊㅋㅊㅋ</span><!-- 댓글내용  --><br>
									<span class="upload-date">2022-11-03</span>
								</p>
							</div>
						</li>
					</ol>
					<div><!-- 댓글달기 -->
						<form action="/" method="post">
							<img src="/image/face.png">
							<input type="text" placeholder="댓글 달기...">
							<input type="submit" value="게시">
						</form> 
					</div>
				</div>
			</li>
		</ul>
	</section>
</body>
</html>
