<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/userfeedcss.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div id="maindiv_outer">
	<div id="maindiv_inner">
	
		<input type="hidden" value="${memberId}" id="toId">
		<input type="hidden" value="${sessionScope.memberId}" id="fromId">
	<div style="margin-top: 60px;"></div>
	<div id="feed_top">
		<div id="img_div">
			<img id="myProfileImg" src="/file/${memberProfileFileId}" onerror="this.src='/image/profile_null.jpg';">
		</div><div id="info_div">
				<div id="info1_div">
					<div style="display: inline-block; margin-top:30px">
					<label id="nickname">${nickname }</label>
					<c:if test="${sessionScope.memberId eq memberId}">
						<span id="updateprofile"><a href='<c:url value="/member/update"/>'>프로필 편집</a></span>
						<span id="insertspan"><a href='<c:url value="/writefeed/${memberId}"/>'><img src="../image/add.png" ></a></span>
					</c:if>
					<c:if test="${sessionScope.memberId ne memberId}">
						<button id="btn" onclick="changeFollowing()"></button>
					</c:if>
					</div>
				</div>
				<div id="info2_div">
					<label style="margin-right:10px">게시글 수 </label><label style="font-family:'segoe'; font-weight:700"> ${contentCount } </label>
					<label>팔로워 수 <button class="followsbtn" id="followerbtn">${followerCount}</button></label>
						
					<label>팔로우 수 <button class="followsbtn" id="followbtn">${followCount }</button></label> <br>
					<label style="font-family:'segoe'; font-weight:400; font-size:17px;">${name }</label><br>
				</div>
		</div> <!-- info_div-end -->
	</div>	
		<hr>	
			
									
<div class="black_bg"></div>
<div id="follower_modal">
	<c:forEach var="followerList" items="${ followerList}">
		<div>${followerList }</div>
	</c:forEach>
 	<div class="modal_close" id="modal_close1"><a href="#">close</a></div>
</div>

<div class="black_bg"></div>
<div id="follow_modal">
	<c:forEach var="followList" items="${ followList}">
		<div>${followList }</div>
	</c:forEach>
	<div class="modal_close" id="modal_close2"><a href="#">close</a></div>
</div>


<div id="content_table">
<table >
<c:forEach var="file"  items="${contentList }">
	
			<a href='<c:url value="/feed/detail/${file.feedNo}"/>'><img id="content_img" src='<c:url value="/file/${file.fileNo }"/>' ></a>
		
</c:forEach>
</table>
</div>


	</div><!-- main div-inner-end -->
</div><!-- main div-outer-end -->
</body>

<script>
    window.onload = function() {
 
    function onClick() {
        document.querySelector('#follower_modal').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }   
    function offClick() {
        document.querySelector('#follower_modal').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }
 
    document.getElementById('followerbtn').addEventListener('click', onClick);
    document.querySelector('#modal_close1').addEventListener('click', offClick);
    
    
    function onClick2() {
        document.querySelector('#follow_modal').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }   
    function offClick2() {
        document.querySelector('#follow_modal').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }
 
    document.getElementById('followbtn').addEventListener('click', onClick2);
    document.querySelector('#modal_close2').addEventListener('click', offClick2);
 
    
};
</script>


<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
var fromIdEl = $("#fromId");
var toIdEl = $("#toId");

var fromId = fromIdEl.val();
var toId = toIdEl.val();

var isFollowing = false;

$(function(){
	
	$.ajax({
		type: "GET",
		url: "/isfollowing/"+toId,
		dataType: "json",
		success: function(result, status, xhr){
			isFollowing = result;
			console.log("isFollowing: "+isFollowing);
			const btn = document.getElementById('btn');
			if(isFollowing == true){
				console.log("if문");
				btn.innerText = '언팔로우';
			} else {
				console.log("else문");
				btn.innerText = '팔로우';
			}
		}
	})
	

})

	function changeFollowing(){
		const btn = document.getElementById('btn');
		if(isFollowing == true){
			$.ajax({
				type: "GET",
				url: "/unfollow/"+toId,
				success: function(){
					console.log(toId+"를 언팔로우 함");
					btn.innerText = '팔로우';
					isFollowing = false;
				}
			})
		} else {
			$.ajax({
				type: "GET",
				url: "/follow/"+toId,
				success: function(){
					console.log(toId+"를 팔로우 함");
					btn.innerText = '언팔로우';
					isFollowing = true;					
				}
			})
		}
	}
</script>
</html>