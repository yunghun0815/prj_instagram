<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html{
	display: flex;
    justify-content: center;
    flex-direction: column;
    height: 100%;
}
body {
	background-color: #fafafa;
}
.delete_total {
	border: solid 1px #dbdbdb;
	width: 400px;
	height: 400px;
    padding-left: 75px;
    padding-top: 55px;
	background-color: #ffffff;
	margin: 0 auto;
}

.delete_title {
	width: 400px;
	height: 80px;
	text-align: center;
}

h3 {
	display: inline-block;
	float: left;
	margin-top: 9%;
}

h1 {
	display: inline-block;
	float: left;
}

p {
	width: 85%;
	font-size: 14px;
}

.delete_name {
	font-size: 14px;
	font-weight: bold;
	padding-bottom: 5px;
}
</style>
</head>
<style type="text/css">
.error {
	color: Red
}

.input_delete {
	width: 80%;
	height: 25px;
	border: 1px solid #dadada;
	border-radius: 3px;
	display: block;
}

a {
	text-decoration: none;
	color: #0095fa;
	font-size: 14px;
	font-weight: bold;
	display: block;
	padding-top: 10px;
}

.submit_button {
	margin-top: 10%;
	margin-left: 27%;
	background-color: #0095fa;
	color: #ffffff;
	font-weight: bold;
	border: 1px solid #0095fa;
	border-radius: 3px;
	padding-top: 6px;
	padding-right: 10px;
	padding-left: 10px;
	padding-bottom: 6px;
}
.password_wrong{
    margin: auto;
    float: left;
    font-size: 12px;
    color: red;
    margin-left: 18px;

}
</style>
<body>
	<div class="delete_total">
		<form action="/member/delete" method="post">
			<div class="delete_title">
				<h1>${memberId }</h1>
				<h3>님!</h3>
			</div>
			<p>계정이 삭제된 후에는 동일한 사용자 이름으로 다시 가입하거나 해당 사용자 이름을 다른 계정에 추가할 수
				없습니다.</p>
			<div class="delete_name">비밀번호를 다시 입력하세요</div>

			<input type="password" name="password" required="required"
				class="input_delete" /> 
				<p class="password_wrong">${message }</p>
				<a href="/member/findMemberId"
				class="link_findPw">비밀번호를 잊으셨나요?</a> <input type="submit"
				value="${memberId}  삭제" class="submit_button">
		</form>
	</div>
</body>
</html>