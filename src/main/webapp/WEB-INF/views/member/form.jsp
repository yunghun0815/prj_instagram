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
.error {
	color: Red
}
</style>
<body>
	<form:form action="/member/insert" method="post"
		modelAttribute="member">

		<fmt:message key="MEMBER_ID" />
		<form:input path="memberId" required="required" class="memberId" />
		<span id="checkId"></span>
		<br>
		<form:errors path="memberId" class="error" />
		<br>
		
		비밀번호<form:input type="password" path="password" required="required" />
		<br>
		<form:errors path="password" class="error" />
		<br>
		
		닉네임<form:input path="nickname" required="required" class="nickname" />
		<span id="ckeckNickname"></span>
		<br>
		<form:errors path="nickname" class="error" />
		<br>
		 
		이름<form:input path="name" required="required" />
		<br>
		<form:errors path="name" class="error" />
		<br>
		 
		성별 <input type="radio" name="gender" value="female" checked="checked"
			required="required" />여자
		 <input type="radio" name="gender" value="male" />남자<br>
		 
		 이메일 <form:input path="email" class="email" required="required" />
		<span id="checkEmail"></span>
		<br>
		<form:errors path="email" class="error" />
		<br>
		 
		 
		생년월일 <form:input type="date" path="birth" required="required" />
		<br>
		<form:errors path="birth" class="error" />
		<br>
		 
		핸드폰 번호<form:input path="phoneNumber" required="required" />
		<br>
		<form:errors path="phoneNumber" class="error" />
		<br>
		<button type="submit" class="submit">전송</button>
		<input type="reset" value="취소">

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
		$(".email").focusout(function () {
			let email = $('.email').val();
			
			$.ajax({
				url : "/member/checkEmail",
				type : "post",
				data : {
					email : email
				},
				dataType : 'json',
				success : function (emailCheck) {
					if (emailCheck == 0) {
						$("#checkEmail").html('사용할 수 없는 이메일입니다.');
						$("#checkEmail").attr('color', 'red');
						$(".submit").prop('disabled', true);
					}else {
						$("#checkEmail").html('사용할 수 있는 이메일입니다.');
						$("#checkEmail").attr('color', 'green');
						$(".submit").prop("disabled", false);
					}
				}
			})
		})
		
	</script>

</body>