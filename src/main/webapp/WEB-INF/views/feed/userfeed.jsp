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
	<div style="margin-top: 100px;"></div>
	<div id="feed_top">
		<div id="img_div">
			<img class="myProfileImg" src="/file/${memberProfileFileId}" onerror="this.src='/image/profile_null.jpg';">
		</div><div id="info_div">
				<div id="info1_div">
					<div style="display: inline-block; margin-top:30px">
					<label id="nickname">${nickname }</label>
					<c:if test="${sessionScope.memberId eq memberId}">
						<span id="updateprofile"><a href='<c:url value="/member/update"/>'>프로필 편집</a></span>
						
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
		
			
									
<div class="black_bg"></div>
<div id="follower_modal">
	<h4 style="       font-family: 'segoe-b';margin: 10px 80px 10px 120px;display: inline-block;">팔로워
	</h4><div class="modal_close" id="modal_close1"><img src="../image/x.png" style="width: 20px; display: inline-block;height: 21px;margin: 10px 20px 10px 10px;float: right; "><a href="#"></a></div>
	<hr>
	<c:forEach var="follower" items="${ followerList}">
		<div onclick="location.href='<c:url value="/userfeed/${follower.memberId }"/>'" class="listhover" id="listhover"><span class="follow_nickname">${follower.nickname}</span><span class="follow_name">${follower.name}</span> </div>
	</c:forEach>
 	
</div>

<div class="black_bg"></div>
<div id="follow_modal">
<h4 style="font-family: 'segoe-b';margin: 10px 80px 10px 120px;display: inline-block;">팔로우
	</h4><div class="modal_close" id="modal_close2"><img src="../image/x.png" style="width: 20px; display: inline-block;height: 21px;margin: 10px 20px 10px 10px;float: right; "><a href="#"></a></div>
	<hr>
	<c:forEach var="follow" items="${ followList}">
		<div onclick="location.href='<c:url value="/userfeed/${follow.memberId }"/>'" class="listhover" id="listhover"><span class="follow_nickname">${follow.nickname}</span><span class="follow_name">${follow.name}</span></div>
	</c:forEach>
</div>


<div id="content_table">

<c:forEach var="file"  items="${contentList }">
	
			<a href='<c:url value="/feed/detail/${file.feedNo}"/>'><img id="content_img" src='<c:url value="/file/${file.fileNo }"/>' ></a>
			
</c:forEach>

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