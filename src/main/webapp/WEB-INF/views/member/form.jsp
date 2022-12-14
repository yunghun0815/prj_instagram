<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="i18n/member" />
<!DOCTYPE html>
<html>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>

<style type="text/css">
html{
	display: flex;
    justify-content: center;
    flex-direction: column;
    height: 100%;
}
.error {
	color: Red
}
.total_main{
	width: 350px;
	height: 100%;
	margin: auto;
	flex-direction: column;
}
body {
	background-color: #fafafa;
}

img {
	margin-top: 5%;
	position: relative;
	margin-left: 25%;
}

.instagram_title {
	font-size: 17px;
	color: #8e8e8e;
	width: 75%;
	text-align: center;
	margin-left: 10%;
	font-size: 17px;
	color: #8e8e8e;
	position: relative;
}

.main_sign {
	border: solid 1px #dbdbdb;
	width: 350px;
	height: 740px;
	background-color: #ffffff;
}

.input_form {
	height: 50px;
	text-align: center;
}

#input_box {
	width: 258px;
	height: 22px;
	background-color: #fafafa;
	border: 0.5px solid #dbdbdb;
	border-radius: 3px;
}

.info_name {
	position: relative;
	margin-left: 12%;
	font-size: 12px;
}

.radio_style {
	display: inline-block;
	float: left;
	margin-left: 23%;
	position: relative;
	margin-top: 3%;
}

#sigup_button {
	width: 268px;
	height: 30px;
	background-color: #0095f6;
	border: 0.5px solid #0095f6;
	border-radius: 3px;
	color: #ffff;
	font-weight: bold;
}

span {
	font-size: 12px;
	display: inline-block;
	float: left;
	position: relative;
	margin-left: 12%;
	color: red;
}

.user_check {
	position: relative;
	border: 1px solid;
	width: 350px;
	margin-top: 2%;
	border: solid 1px #dbdbdb;
}

.user_check {
	background-color: #ffffff;
}

.yes_user {
	text-align: center;
	font-size: 14px;
	color: #262626;
}

a {
	text-decoration: none;
	color: #0095f6;
	font-weight: bold;
}
</style>
<body>
	<form:form action="/member/insert" method="post"
		modelAttribute="member">
		<div class="total_main">
			<div class="main_sign">
				<a href="/member/login"><img src="/image/header/instagram.png" ></a>
				<h2 class="instagram_title"><fmt:message key="SIGN_UP_ANNOUNCE"/></h2>
				<div class="input_total">
					<div class="info_name">
						<fmt:message key="MEMBER_ID" />
					</div>
					<div class="input_form">
						<form:input path="memberId" required="required" class="memberId"
							id="input_box" />
						<br> <span id="checkId"></span>
						<form:errors path='memberId' class='error' />
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_PW" /></div>
					<div class="input_form">
						<form:input type="password" path="password" required="required"
							id="input_box" />
						<br>
						<form:errors path="password" class="error" />
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_NICKNAME" /></div>
					<div class="input_form">
						<form:input path="nickname" required="required" class="nickname"
							id="input_box" />
						<span id="ckeckNickname"></span> <br>
						<form:errors path="nickname" class="error" />
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_NAME" /></div>
					<div class="input_form">
						<form:input path="name" required="required" id="input_box" />
						<br>
						<form:errors path="name" class="error" />
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_GENDER" /></div>
					<div class="input_form">
						<div class="radio_box">
							<div class="radio_style">
								<input type="radio" name="gender" value="female"
									checked="checked" required="required" /><fmt:message key="FEMALE" />
							</div>
							<div class="radio_style">
								<input type="radio" name="gender" value="male" /><fmt:message key="MALE" />
							</div>
						</div>
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_EMAIL" /></div>
					<div class="input_form">
						<form:input path="email" class="email" required="required"
							id="input_box" />
						<span id="checkEmail"></span> <br>
						<form:errors path="email" class="error" />
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_BIRTH" /></div>
					<div class="input_form">
						<form:input type="date" path="birth" required="required"
							id="input_box" />
						<br>
						<form:errors path="birth" class="error" />
					</div>
				</div>
				<div class="input_total">
					<div class="info_name"><fmt:message key="MEMBER_PHONE" /></div>
					<div class="input_form">
						<form:input path="phoneNumber" class="phoneNumber" required="required" id="input_box" />
						<br>
						<span id="checkPhoneNumber"></span> <br>
						<form:errors path="phoneNumber" class="error" />
						<br>
					</div>
				</div>
				<div class="input_form">
					<button type="submit" class="submit" id="sigup_button"><fmt:message key="SIGN_UP_SUBMIT" /></button>
				</div>
			</div>
			<div class="user_check">
				<p class="yes_user">
					<fmt:message key="HAVE_ACCOUNT" /> <a href="/member/login"><fmt:message key="LOGIN" /></a>
				</p>
			</div>
		</div>
	</form:form>
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('.memberId').focusout(function() { //포커스를 잃을 때 실행
			let memberId = $('.memberId').val(); //mebmerId에 입력되는 값
			$.ajax({
				url : "/member/checkId",
				type : "post",
				data : {
					memberId : memberId
				},
				dataType : 'json',
				success : function(idCheck) {
					if (idCheck == 0) {
						$("#checkId").html('사용할 수 없는 아이디입니다.');
						$("#checkId").attr('color', 'red');
						$(".submit").prop("disabled", true);
					} else {
						$('#checkId').html('사용할 수 있는 아이디입니다');
						$('#checkId').attr('color', 'green');
						$(".submit").prop("disabled", false);
					}
				},
				error : function(xhr, status, error) {
					alert("실패");
				}
			})
		}), $('.nickname').focusout(function() {
			let nickname = $(".nickname").val();

			$.ajax({
				url : "/member/checkNickname",
				type : "post",
				data : {
					nickname : nickname
				},
				dataType : 'json',
				success : function(nicknameCheck) {
					if (nicknameCheck == 0) {
						$("#ckeckNickname").html('사용할 수 없는 닉네임입니다.');
						$("#ckeckNickname").attr('color', 'red');
						$('.submit').prop("disabled", true);
					} else {
						$("#ckeckNickname").html('사용할 수 있는 닉네임입니다.');
						$("#ckeckNickname").attr('color', 'green');
						$(".submit").prop('disabled', false);
					}
				},
				error : function() {
					alert("닉네임 실패");
				}
			})
		})
		$(".email").focusout(function() {
			let email = $('.email').val();

			$.ajax({
				url : "/member/checkEmail",
				type : "post",
				data : {
					email : email
				},
				dataType : 'json',
				success : function(emailCheck) {
					if (emailCheck == 0) {
						$("#checkEmail").html('사용할 수 없는 이메일입니다.');
						$("#checkEmail").attr('color', 'red');
						$(".submit").prop('disabled', true);
					} else {
						$("#checkEmail").html('사용할 수 있는 이메일입니다.');
						$("#checkEmail").attr('color', 'green');
						$(".submit").prop("disabled", false);
					}
				}
			})
		})
		$(".phoneNumber").focusout(function() {
			let phoneNumber = $('.phoneNumber').val();
			
			$.ajax({
				url : "/member/phoneNumber",
				type : "post",
				data : {
					phoneNumber : phoneNumber
				},
				dataType : 'json',
				success : function(phoneNumberCheck){
					if (phoneNumberCheck == 0) {
						$('#checkPhoneNumber').html('사용할 수 없는 전화번호입니다.');
						$('.submit').prop('disabled', true);
					}else {
						$("#checkPhoneNumber").html('사용할 수 있는 전화번호입니다.');
						$(".submit").prop('disabled', false);
					}
				}
				
			})
		})
	</script>