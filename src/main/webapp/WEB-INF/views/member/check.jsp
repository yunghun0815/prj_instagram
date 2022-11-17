<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html {
	display: flex;
	justify-content: center;
	flex-direction: column;
	height: 100%;
}

body {
	background-color: #fafafa;
}

.check_total {
	width: 400px;
	height: 300px;
	text-align: center;
	border: 1px solid #dadada;
	background-color: #ffffff;
	margin: 0 auto;
}

.check_content {
	width: 350px;
	height: 95px;
	margin: auto;
}

.care_content {
	font-size: 13px;
	text-align: initial;
	margin-top: 25px;
	margin-left: 65px;
}

h2 {
padding-top: 15px;
	padding-bottom: 20px;
}

h3 {
	display: inline-block;
	float: left;
	margin: auto;
	margin-left: -5px;
}

.input_name {
	float: left;
	margin-left: 22px;
	font-size: 13px;
}

.input_pw {
	float: left;
	float: left;
	margin-top: 9px;
	width: 278px;
	height: 22px;
	margin-left: 15px;
	border: 1px solid #dbdbdb;
	border-radius: 3px;
	margin-top: 9px;
	width: 278px;
}

.total_input {
	width: 432px;
	height: 66px;
	padding-top: 46px;
}

.submit_button {
	background-color: #0095fa;
	color: #ffffff;
	font-weight: bold;
	font-size: 14px;
	border: 1px solid #0095fa;
	border-radius: 3px;
	padding: 3px 8px;
}

.message {
	margin: auto;
	float: left;
	font-size: 12px;
	color: red;
	margin-left: 18px;
}
</style>
</head>
<body>
	<div class="check_total">
		<form action="/member/check" method="post">
			<div class="check_content">
				<h2>비밀번호 확인</h2>
				<h3>${memberId }</h3>
				<p class="care_content">님의 회원정보를 안전하게 보호하기 위해 비밀번호를 한번 더 확인해
					주세요.</p>
			</div>
			<div class="total_input">
				<p class="input_name">비밀번호</p>
				<input type="password" name="password" class="input_pw">
				<p class="message">${message}</p>
			</div>
			<input type="submit" value="확인" class="submit_button">
		</form>
	</div>
</body>
</html>