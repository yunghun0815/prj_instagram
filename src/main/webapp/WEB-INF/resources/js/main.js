$(function(){
	// var memberId = $("#member_id").val(); //회원 아이디
	var test = `
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
					<img id="heart_blank" src="/image/heart.png" onclick="like(this)" >
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
	`;
	/* 스크롤 이벤트 html 추가 */
 	var pageNo = 0;
	$(window).scroll(function(){
		var scrollTop = $(window).scrollTop(); //스크롤 위
	    var documentHeight = $(document).height(); //전체 높이
	    var windowHeight = $(window).height(); //현재 높이
	    if(scrollTop + windowHeight >= documentHeight){
	    	pageNo ++;
	    	$(".feed-ul").append(test);
	    	console.log(pageNo);
	    	//ajax 
	    }
	}); 
	  
});

	function like(param){
		var object = $(param);
		object.hide(); //색 없는 하트 없앰
		object.next().show(); //색 있는 하트 보여줌
		//현재 피드 좋아요 객체
		var likeCountHtml = object.parent().next().find($("span #like_count"));
		//현재 피드 좋아요 수
		var likeCount = parseInt(object.parent().next().find($("span #like_count")).html());
		//좋아요 클릭 시 +1 
		likeCountHtml.html(likeCount+1);
	}
	
	function likeCancel(param){
		var object = $(param);
		object.hide();
		object.prev().show();
		//현재 피드 좋아요 객체
		var likeCountHtml = object.parent().next().find($("span #like_count"));
		//현재 피드 좋아요 수
		var likeCount = parseInt(object.parent().next().find($("span #like_count")).html());
		//좋아요 클릭 시 -1 
		likeCountHtml.html(likeCount-1);
		//비동기로 좋아요 테이블 해당 아이디 삭제
		/* $.ajax({
			url:,
			type: "POST",
			success: function(result){
				
			}
		});*/
	}
	
	function replyFocus(param){
		var object = $(param);
		var text = object.parent().parent().parent().find($("div #replyInput")).focus();
	}
	