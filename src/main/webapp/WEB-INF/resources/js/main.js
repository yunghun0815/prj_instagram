$(function(){
	var memberId = $("#memberId").val();
	
	$.ajax({
		url:"/mainfeed/"+memberId+"/0",
		type: "GET", 
		success: function(result){
			for(let i=0; i<result.length; i++){
				let feed = result[i]['feed']['feed'];
				let member = result[i]['member']['member'];
				let uploadFiles = result[i]['uploadFiles'];
				let reply = result[i]['reply'];
				
				function hashtagList(){
					let hashtag = '';
					
					if(feed['hashtagList'].length > 0){
						for(let j=0; j<feed['hashtagList'].length; j++){
							hashtag += '#' + feed['hashtagList'][j] + ' ';
						}
					}
					
					return hashtag;
				}
				
				function replyList(){
					let replyText = '';
					
					if(reply.length > 0){
						for(let k=0; k<reply.length; k++){
							replyText += `
								<div>
									<img src="/file/`+ reply[k]['fileNo'] +`" class="reply-profile" onerror="this.src='/image/profile_null.jpg';">
									<p class="inline-block">
										<span class="bold">`+ reply[k]['nickname'] +`</span>
										<span>`+ reply[k]['replyContent'] +`</span><!-- 댓글내용  --><br>
										<span class="upload-date">`+ reply[k]['replyDate'] +`</span>
									</p>
								</div>
							`;
						}
					}
					return replyText;
				}
				
				
				let view= `
					<li class="feed-li flex"> <!-- DB에서 값 받아서 반복해야 함 --> 
					<div class="feed-img-box"><!-- 게시물 상단바 , 프로필사진, 아이디 --> 
						<div class="feed-header">
							<img class="profile-img " src="/file/`+ member['fileNo'] +`" onerror="this.src='/image/profile_null.jpg';">
							<p class=`+ `${feed['placeDetail'] == null ? "nullPlace" : ""}` +`>
								<a href="#"><span>`+ member['nickname'] +`</span></a><br>
								<a href="#">
									<span id="placeTitle" class="place"  data-bs-toggle="modal" data-bs-target="#modal-map">`+ `${feed['placeDetail'] == null ? "" : feed['placeDetail']}` +`</span>									<input type="hidden" value="`+ feed['placeDetail'] +`">
								</a>
							</p>
						</div>
						<img class="feed-img" src="/image/sample.jpg">				
					</div>
					<div class="feed-desc-box">
						<ol>
							<li><span class="bold">`+ member['nickname'] +`</span>
							    <span>`+ feed['feedContent'] +`</span><br>
							    <span class="hashtag"> ${hashtagList()} </span>
							</li>
							<li>
								<img id="heart_blank" src="/image/heart.png" onclick="like(this)">
								<img id="heart_color" src="/image/heart_color.png" style="display: none" onclick="likeCancel(this)">
								<img src="/image/speech.png" onclick="replyFocus(this)">
								<img src="/image/plane.png">
							</li>
							<li>
								<span class="bold">좋아요<span id="like_count">`+ feed['likeCount'] +`</span>개</span>	
								<span class="upload-date">`+ feed['uploadDate'] +`</span>	
							</li>
							<li class="reply-list">
								${replyList()}
							</li>
						</ol>
						<div><!-- 댓글달기 -->
							<form action="/" method="post">
								<img src="/image/face.png">
								<input id="replyInput" type="text" placeholder="댓글 달기...">
								<input type="submit" value="게시" >
							</form> 
						</div>
					</div>
				</li>
			`;
				
				$(".feed-ul").append(view);
			}
		}
	});
	
	// var memberId = $("#member_id").val(); //회원 아이디
	
	$("#placeTitle").click(function(){
		var placeTitle = $(this).html(); //보이는 Title 값 
		var placeDetail = $(this).next().val(); //DB 저장된 주소
		
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //최초 지도 객체 생성 중심좌표
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		 
		// 0.3초 딜레이 줌 ---> modal 생성 이후 kakao map 생성
		setTimeout(function() {
			
			// 주소-좌표 변환 객체를 생성
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색
			geocoder.addressSearch(placeDetail, function(result, status) {
					
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {

			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });

			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ placeTitle +'</div>'
			        });
			        infowindow.open(map, marker);

			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			}); 
			
			map.relayout();
		}, 300);
	});
	
	
	/* 스크롤 이벤트 html 추가 */
 	var pageNo = 0;
	$(window).scroll(function(){
		var scrollTop = $(window).scrollTop(); //스크롤 위
	    var documentHeight = $(document).height(); //전체 높이
	    var windowHeight = $(window).height(); //현재 높이
	    if(scrollTop + windowHeight >= documentHeight){
	    	pageNo ++;
	    	$.ajax({
	    		url:"/mainfeed/test/"+memberId+"/"+pageNo,
	    		type: "GET", 
	    		success: function(result){
	    			if(result.length >0){
		    			for(let i=0; i<result.length; i++){
		    				let feed = result[i]['feed']['feed'];
		    				let member = result[i]['member']['member'];
		    				let uploadFiles = result[i]['uploadFiles'];
		    				let reply = result[i]['reply'];
		    				
		    				function hashtagList(){
		    					let hashtag = '';
		    					
		    					if(feed['hashtagList'].length > 0){
		    						for(let j=0; j<feed['hashtagList'].length; j++){
		    							hashtag += feed['hashtagList'][j];
		    						}
		    					}
		    					
		    					return hashtag;
		    				}
		    				
		    				function replyList(){
		    					let replyText = '';
		    					
		    					if(reply.length > 0){
		    						for(let k=0; k<reply.length; k++){
		    							replyText += `
		    								<div>
		    									<img src="/file/`+ reply[k]['fileNo'] +`" class="reply-profile" onerror="this.src='/image/profile_null.jpg';">
		    									<p class="inline-block">
		    										<span class="bold">`+ reply[k]['nickname'] +`</span>
		    										<span>`+ reply[k]['replyContent'] +`</span><!-- 댓글내용  --><br>
		    										<span class="upload-date">`+ reply[k]['replyDate'] +`</span>
		    									</p>
		    								</div>
		    							`;
		    						}
		    					}
		    					return replyText;
		    				}
		    				
		    				
		    				let view= `
		    					<li class="feed-li flex"> <!-- DB에서 값 받아서 반복해야 함 -->
		    					<div class="feed-img-box"><!-- 게시물 상단바 , 프로필사진, 아이디 -->
		    						<div class="feed-header">
		    							<img class="profile-img " src="/file/`+ member['fileNo'] +`" onerror="this.src='/image/profile_null.jpg';">
		    							<p>
		    								<a href="#"><span>`+ member['nickname'] +`</span></a><br>
		    								<a href="#">
		    									<span id="placeTitle" class="place"  data-bs-toggle="modal" data-bs-target="#modal-map">`+ feed['placeDetail'] +`</span>
		    									<input type="hidden" value="`+ feed['placeDetail'] +`">
		    								</a>
		    							</p>
		    						</div>
		    						<img class="feed-img" src="/image/sample.jpg">				
		    					</div>
		    					<div class="feed-desc-box">
		    						<ol>
		    							<li><span class="bold">`+ member['nickname'] +`</span>
		    							    <span>`+ feed['feedContent'] +`</span><br>
		    							    <span class="hashtag"> ${hashtagList()} </span>
		    							</li>
		    							<li>
		    								<img id="heart_blank" src="/image/heart.png" onclick="like(this)">
		    								<img id="heart_color" src="/image/heart_color.png" style="display: none" onclick="likeCancel(this)">
		    								<img src="/image/speech.png" onclick="replyFocus(this)">
		    								<img src="/image/plane.png">
		    							</li>
		    							<li>
		    								<span class="bold">좋아요<span id="like_count">`+ feed['likeCount'] +`</span>개</span>	
		    								<span class="upload-date">`+ feed['uploadDate'] +`</span>	
		    							</li>
		    							<li class="reply-list">
		    								${replyList()}
		    							</li>
		    						</ol>
		    						<div><!-- 댓글달기 -->
		    							<form action="/" method="post">
		    								<img src="/image/face.png">
		    								<input id="replyInput" type="text" placeholder="댓글 달기...">
		    								<input type="submit" value="게시" >
		    							</form> 
		    						</div>
		    					</div>
		    				</li>
		    			`;
		    				
		    				$(".feed-ul").append(view);
		    			}
	    			}else{
	    				pageNo--;
	    			}
	    		}
	    	});
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
	