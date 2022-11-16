<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	.box{
		width: 200px;
		height: 200px;
	}
	#idBox, #pwBox{
		width: 500px;
		height: 500px;
		border: 1px solid black;
	}
	#pwBox{
		display: none;
	}
	.findId, .findPw{
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	$(function(){
		$(".findId").click(function(){
			$("#pwBox").hide();
			$("#idBox").show();
		});	
		$(".findPw").click(function(){
			$("#idBox").hide();
			$("#pwBox").show();
		});	
		$(".slick").slick();
	});
</script>

<body>
	<div class="box">
		<span class="findId">아이디 찾기</span><br>
		<span class="findPw">비밀번호 찾기</span>
	</div>
	<div>
		<div id="idBox"><!-- 아이디찾기 -->
			<h3>아이디 찾기</h3>
			<form action="#" method="post">
				이메일 : <input type="text" name="email">
				<input type="submit" value="찾기">
			</form>
		</div>
		<div id="pwBox"><!-- 비밀번호 찾기  -->
			<h3>비밀번호 찾기</h3>
			<form action="#" method="post">
				아이디 : <input type="text"><br>
				이메일 : <input type="text"><br>
				<input type="submit" value="찾기">
			</form>	
		</div>
	</div>
	<div class="slick">
		<div>이미지3</div>
	    <div>이미지3</div>
	    <div>이미지3</div>
	</div>
</body>
</html>