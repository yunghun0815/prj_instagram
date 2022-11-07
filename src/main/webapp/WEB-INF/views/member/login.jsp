<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="/css/common/common.css">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<fmt:setBundle basename="i18n/member"/>
<!DOCTYPE html>
<html>
<style>
	html{
		background-color: rgb(250, 250, 250);
	}
	body{
		height: 700px;
	}
	.main{
		width: 1000px;
		margin: 150px auto;
	}
	.phone{
	    width: 410px;
   	 	height: 560px;
	}
	.phone_inner{
		position: relative;
	}
	.phone_inner img{
        position: absolute;
	    bottom: 57px;
	    width: 224px;
	    height: 480px;
	    left: 135px;
	    display: none;
       /*  opacity: 0;
        visibility: hidden; */
	}
	.phone_inner img:first-child{
		display: inline;
	}
	.phone_inner img:not(:nth-child(1)) {
	}
	.signupForm{
	    border: 1px solid rgb(219,219,219);
	    width: 350px;
	    height: 390px;
	    text-align: center;
	    background-color: white;
	    padding-top: 50px;
	    margin-bottom: 20px;
	}
	.signupForm form{
		margin-bottom: 20px;
	}
	.formInput{
	    width: 250px;
	    height: 40px;
	    padding-left: 10px;
	    background-color: #fafafa;
	    border: 1px solid rgb(219,219,219);
		margin-top: 10px;
	}
	.signupForm>img{
		margin-bottom: 15px;
	}
	.signupForm input[type="submit"]{
	    width: 250px;
	    background-color: rgb(0, 149, 246);
	    border: none;
	    height: 30px;
	    color: white;
	    border-radius: 6px;
	    margin-top: 15px;
	    font-weight: bold;
	    cursor: pointer;
	}
	.findPassword{
		color: gray;
	    font-weight: bold;
	    font-size: 12px;
        display: inline-block;
 	    margin-top: 30px;
	}
	.line{
	    background-color: #dbdbdb;
	    height: 1px;
	    width: 100px;
	    margin-bottom: 5px;
    }
    
	.or{
	    color: #8e8e8e;
	    font-size: 13px;
	    font-weight: bold;
	}
	.signupBox{
	    width: 350px;
	    height: 60px;
	    background-color: white;
	    margin-top: 15px;
	    border: 1px solid rgb(219,219,219);
	    text-align: center;
	    font-size: 13px;
	    padding-top: 20px;
	}
	.signupBox a{
	    color: #0095f6;
    	font-weight: bold;
	}
</style>
<script type="text/javascript">
 	$(function(){
		//0~3
		var idx = 0;
		var object = $(".phone_inner img");
		setInterval( fadeImage, 5000);
		
		function fadeImage(){
			/* object.css("display", "none"); */
			$(".phone_inner img:not(:nth-child("+ idx +"))").css("display", "none");
			object.eq(idx).fadeIn(3000);
			if(idx == 3){
				idx = 0
			}else{
				idx += 1;
			}
			object.eq(idx).fadeOut(3000);
		}
		 
	});
</script>
<body>
<section class="main flex">
	<div>
		<div>
			<img class="phone" src="/image/member/login_phone.png">
		</div>
		<div class="phone_inner">
			<img src="/image/member/login_phone_inner1.png">
			<img src="/image/member/login_phone_inner2.png">
			<img src="/image/member/login_phone_inner3.png">
			<img src="/image/member/login_phone_inner4.png"> 
		</div>
	</div>
	<div>
		<div class="signupForm">
			<a href="/">
				<img src="/image/header/instagram.png">
			</a>
			<form action="<c:url value='/member/login'/>" method="post">
				<input class="formInput" type="text" name="memberId" placeholder="아이디"><br>
				<input class="formInput" type="password" name="password" placeholder="비밀번호"><br>
				<input type="submit" value="로그인"><br>
			</form>
			<div class="inline-block line"></div>
			<span class="or">또는</span>
			<div class="inline-block line"></div><br>
			<a class="findPassword" href="#">비밀번호를 잊으셨나요?</a>
		</div>
		<div class="signupBox">
			<span>계정을 없으신가요?</span>
			<a href="/member/insert">가입하기</a>
		</div>
	</div>
</section>


<%-- <c:if test="${not empty sessionScope.memberId}">
<h4>${memberId }</h4>
<h4>${email }</h4>
<a href="<c:url value='/member/update'/>">수정</a>
<a href="<c:url value='/member/logout'/>">로그아웃</a>
<a href="<c:url value='/'/>">회원탈퇴</a>
</c:if> --%>
</body>
</html>