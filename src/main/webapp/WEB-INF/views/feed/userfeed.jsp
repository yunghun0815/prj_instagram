<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<input type="hidden" value="${memberId}" id="toId">
<input type="hidden" value="${sessionScope.memberId}" id="fromId">
<div style="margin-top: 60px;">
<h1>개인피드</h1>
멤버아이디 ${memberId}<br>
게시글 수${contentCount }<br>
팔로워 수${followerCount}<br>
팔로우 수 ${followCount }<br>
멤버 닉네임 ${nickname }<br>
이름 ${name }<br>
<table>
<c:forEach var="followerList" items="${ followerList}">
	<tr>
		<td>${followerList }</td>
	</tr>
</c:forEach>
</table>
<table>
<c:forEach var="followList" items="${ followList}">
	<tr>
		<td>${followList }</td>
	</tr>
</c:forEach>
</table>


<c:if test="${sessionScope.memberId eq memberId}">
	<a href='<c:url value="/writefeed/${memberId}"/>'>새글쓰기</a><br>
	<a href='<c:url value="/member/update"/>'>정보수정</a>
</c:if>
<c:if test="${sessionScope.memberId ne memberId}">
	<button id="btn" onclick="changeFollowing()"></button>
</c:if>
</div>
</body>
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