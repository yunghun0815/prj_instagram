<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
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
</body>
</html>