
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style type="text/css">
html{
	height: 100%;
}
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	height: 100%;
	background-color: #fafafa;
}

/* ------------아이디 찾기css------------- */
.find-info-main {
	border: solid 1px #dbdbdb;
	width: 388px;
	height: 537px;
	text-align: center;
	margin: auto;
	padding-top: 30px;
	background-color: #ffff;
}

img {
	width: 70px;
	height: 70px;
}

.custom-control {
	display: inline-block;
}

.form-control {
	border: 0.5px solid #dbdbdb;
	background-color: #fafafa;
	width: 290px;
	height: 30px;
	border-radius: 5px;
}

.label_findId_email {
	
}

.label_content {
	width: 295px;
	margin: auto;
	text-align: left;
	margin-top: 2%;
}

a {
	text-decoration: none;
	color: #262626;
	font-size: 14px;
}

.label_cancel {
	padding-top: 3%;
	padding-bottom: 3%;
}

#searchBtn, #searchBtn2 {
	width: 298px;
	height: 30px;
	border-radius: 5px;
	border: 0.5px solid #0095f6;
	background-color: #0096f6;
	color: #ffff;
}

.input_id {
	margin-top: 10px;
}

.form-group {
	height: 80px;
	margin-top: 30px;
}

.line {
	background-color: #dbdbdb;
	height: 1.5px;
	margin-bottom: 5px;
	width: 130px;
	display: inline-block;
}

.or {
	color: #8e8e8e;
	font-size: 14px;
	font-weight: bold;
	padding: 5%;
}

.link_signup {
	padding-top: 3%;
	font-weight: bold;
}

.font_link_login {
	display: inline-block;
	margin-top: 3%;
	font-weight: bold;
}

.login_link {
	border: 1px solid #dbdbdb;
	height: 44px;
	margin-top: 15%;
	background-color: #fafafa;
}
/* ------------비밀번호 찾기css------------- */
#inputId {
	margin-top: 1%;
}

#inputEmail_2 {
	margin-top: 1%;
}

.pw_main {
	
}

.form-pwbutton {
	margin-top: 4%;
}

.font_link_login2 {
	display: inline-block;
	margin-top: 3%;
	font-weight: bold;
}

.login_link2 {
	border: 1px solid #dbdbdb;
	height: 44px;
	margin-top: 5%;
	background-color: #fafafa;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/model/userIdSearchModal.jsp"%>
	<div class="find-info-main">
		<div class="sub-title font-weight-bold text-white">
			<img src="/image/member/find_lock.png">
			<h3>아이디/비밀번호 찾기</h3>
			<p>정보를 입력해 주세요</p>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
			<input type="radio" class="custom-control-input" id="search_1"
				name="search_total" onclick="search_check(1)" checked="checked">
			<!-- label for는 type이 radio같이 누르기 힘든 걸 input에 있는 id와 연결해 클릭이 가능하게 해준다 -->
			<!-- 그래서 input id와 label for이 같아야 한다 -->
			<label class="custom-control-label font-weight-bold text-white"
				for="search_1"> 아이디 찾기 </label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
			<input type="radio" class="custom-control-input" id="search_2"
				name="search_total" onclick="search_check(2)"> <label
				class="custom-control-label font-weight-bold text-white"
				for="search_2"> 비밀번호 찾기 </label>
		</div>
		<div id="searchI">
			<div class="form-group">
				<div class="label_content">
					<label class="label_findId_email" for="inputEmail_1">이메일</label>
				</div>
				<div class="input_id">
					<input type="text" class="form-control" id="inputEmail_1"
						name="email" placeholder="Email">
				</div>
			</div>
			<div class="ok_button">
				<button id="searchBtn" type="button" onclick="idSearch_click()"
					class="btn btn-primary btn-block">확인</button>
				<div class="label_cancel">
					<a class="btn btn-danger btn-block"
						href="${pageContext.request.contextPath}">취소</a>
				</div>
			</div>
			<div class="inline-block line"></div>
			<span class="or">또는</span>
			<div class="inline-block line"></div>
			<br>
			<div class="link_signup">
				<a href="/member/insert" id="font_link">새 계정 만들기</a>
			</div>
			<div class="login_link">
				<a href="/member/login" id="font_link" class="font_link_login">로그인으로
					돌아가기</a>
			</div>
		</div>

		<!-- 	비밀번호 찾기 -->
		<div id="searchP" style="display: none;">
			<div class="pw_main">
				<div class="input_findpw_id">
					<div class="label_content">
						<label class="font-weight-bold text-white" for="inputId">
							아이디 </label>
					</div>
					<div>
						<input type="text" class="form-control" id="inputId"
							name="memberId" placeholder="id">
					</div>
				</div>
				<div class="input_findpw_email">
					<div class="label_content">
						<label class="font-weight-bold text-white" for="inputEmail_2">이메일</label>
					</div>
					<div>
						<input type="email" class="form-control" id="inputEmail_2"
							name="email" placeholder="email">
					</div>
				</div>
			</div>
			<div class="form-pwbutton">
				<button id="searchBtn2" type="button"
					class="btn btn-primary btn-block" onclick="pwSearch_click()">확인</button>
				<div class="label_cancel">
					<a class="btn btn-danger btn-block"
						href="${pageContext.request.contextPath}">취소</a>
				</div>
				<div class="inline-block line"></div>
				<span class="or">또는</span>
				<div class="inline-block line"></div>
				<div class="link_signup">
					<a href="/member/insert" id="font_link">새 계정 만들기</a>
				</div>
				<div class="login_link2">
					<a href="/member/login" id="font_link" class="font_link_login2">로그인으로
						돌아가기</a>
				</div>
			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		function search_check(num) {
			if (num == '1') {
				document.getElementById("searchP").style.display = "none";
				document.getElementById("searchI").style.display = "";
			} else {
				document.getElementById("searchI").style.display = "none";
				document.getElementById("searchP").style.display = "";
			}
		}
		// 	모달기능
		$(document).ready(function() {
			// 1.모달 창 히든 불러오기
			// 확인 버튼(#searchBtn)이 클릭 되면 modal실행
			$('#searchBtn').click(function() {
				$('#background_modal').show();
			});
			// 2.모달 창 닫기 버튼
			$('.close').on('click', function() {
				$('#background_modal').hide();
			});
			// 3.모달 창,윈도우 클릭 시 닫기
			//event.target은 이벤트가 발생한 요소를 반환해준다.
			//즉 window(event.target)가  #background_modal' 와 같으면 이라는 뜻
			$(window).on('click', function() {
				if (event.target == $('#background_modal').get(0)) {
					$('#background_modal').hide();
				}
			});
		});
		// 	모달기능
		$(document).ready(function() {
			// 1.모달 창 히든 불러오기
			// 확인 버튼(#searchBtn)이 클릭 되면 modal실행
			$('#searchBtn2').click(function() {
				$('#background_modal').show();
			});
			// 2.모달 창 닫기 버튼
			$('.close').on('click', function() {
				$('#background_modal').hide();
			});
			// 3.모달 창,윈도우 클릭 시 닫기
			//event.target은 이벤트가 발생한 요소를 반환해준다.
			//즉 window(event.target)가  #background_modal' 와 같으면 이라는 뜻
			$(window).on('click', function() {
				if (event.target == $('#background_modal').get(0)) {
					$('#background_modal').hide();
				}
			});
		});
		//이메일 값 받고 출력하는 ajax
		var idv = "";
		var idSearch_click = function() {
			var email = $("#inputEmail_1").val();
			$.ajax({
				type : "post",
				url : "/member/findMemberId",
				data : {
					//email 값 controller의 파라미터로 전달
					email : email
				},
				dataType : 'json',
				//member는 controller에 있는 return값
				success : function(member) {
					$('#change_content').text('회원님의 아이디는?')
					if (member == 0) {
						$('#id_value').text('회원정보를 확인해주세요!');
					} else if (member == '1') {
						$('#id_value').text('이메일을 입력해주세요.')
					} else {
						$('#id_value').text(member);
						//아이디 값 별도로 저장(비밀번호 찾기에 아이디 값이 자동으로 입력되도록 data값을 저장)
						idv = member;
					}
				}
			});
		}
		var pwSearch_click = function() {
			var memberId = $("#inputId").val();
			var email = $("#inputEmail_2").val();
			$.ajax({
				type : "post",
				url : "/member/findPassword",
				data : {
					memberId : memberId,
					email : email
				},
				dataType : 'json',
				success : function(member) {
					$('#change_content').text('회원님의 비밀번호는?')
					if (member == 0) {
						$('#id_value').text('회원정보를 확인해 주세요!');
					} else if (member == '1') {
						$('#id_value').text('아이디/이메일을 입력해 주세요.');
					} else {
						$('#id_value').text(member);
					}
				}
			});
		}
		var 
	</script>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style type="text/css">
html{
	height: 100%;
}
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	height: 100%;
	background-color: #fafafa;
}

/* ------------아이디 찾기css------------- */
.find-info-main {
	border: solid 1px #dbdbdb;
	width: 388px;
	height: 537px;
	text-align: center;
	margin: auto;
	padding-top: 30px;
	background-color: #ffff;
}

img {
	width: 70px;
	height: 70px;
}

.custom-control {
	display: inline-block;
}

.form-control {
	border: 0.5px solid #dbdbdb;
	background-color: #fafafa;
	width: 290px;
	height: 30px;
	border-radius: 5px;
}

.label_findId_email {
	
}

.label_content {
	width: 295px;
	margin: auto;
	text-align: left;
	margin-top: 2%;
}

a {
	text-decoration: none;
	color: #262626;
	font-size: 14px;
}

.label_cancel {
	padding-top: 3%;
	padding-bottom: 3%;
}

#searchBtn, #searchBtn2 {
	width: 298px;
	height: 30px;
	border-radius: 5px;
	border: 0.5px solid #0095f6;
	background-color: #0096f6;
	color: #ffff;
}

.input_id {
	margin-top: 10px;
}

.form-group {
	height: 80px;
	margin-top: 30px;
}

.line {
	background-color: #dbdbdb;
	height: 1.5px;
	margin-bottom: 5px;
	width: 130px;
	display: inline-block;
}

.or {
	color: #8e8e8e;
	font-size: 14px;
	font-weight: bold;
	padding: 5%;
}

.link_signup {
	padding-top: 3%;
	font-weight: bold;
}

.font_link_login {
	display: inline-block;
	margin-top: 3%;
	font-weight: bold;
}

.login_link {
	border: 1px solid #dbdbdb;
	height: 44px;
	margin-top: 15%;
	background-color: #fafafa;
}
/* ------------비밀번호 찾기css------------- */
#inputId {
	margin-top: 1%;
}

#inputEmail_2 {
	margin-top: 1%;
}

.pw_main {
	
}

.form-pwbutton {
	margin-top: 4%;
}

.font_link_login2 {
	display: inline-block;
	margin-top: 3%;
	font-weight: bold;
}

.login_link2 {
	border: 1px solid #dbdbdb;
	height: 44px;
	margin-top: 5%;
	background-color: #fafafa;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/model/userIdSearchModal.jsp"%>
	<div class="find-info-main">
		<div class="sub-title font-weight-bold text-white">
			<img src="/image/member/find_lock.png">
			<h3>아이디/비밀번호 찾기</h3>
			<p>정보를 입력해 주세요</p>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
			<input type="radio" class="custom-control-input" id="search_1"
				name="search_total" onclick="search_check(1)" checked="checked">
			<!-- label for는 type이 radio같이 누르기 힘든 걸 input에 있는 id와 연결해 클릭이 가능하게 해준다 -->
			<!-- 그래서 input id와 label for이 같아야 한다 -->
			<label class="custom-control-label font-weight-bold text-white"
				for="search_1"> 아이디 찾기 </label>
		</div>
		<div class="custom-control custom-radio custom-control-inline">
			<input type="radio" class="custom-control-input" id="search_2"
				name="search_total" onclick="search_check(2)"> <label
				class="custom-control-label font-weight-bold text-white"
				for="search_2"> 비밀번호 찾기 </label>
		</div>
		<div id="searchI">
			<div class="form-group">
				<div class="label_content">
					<label class="label_findId_email" for="inputEmail_1">이메일</label>
				</div>
				<div class="input_id">
					<input type="text" class="form-control" id="inputEmail_1"
						name="email" placeholder="Email">
				</div>
			</div>
			<div class="ok_button">
				<button id="searchBtn" type="button" onclick="idSearch_click()"
					class="btn btn-primary btn-block">확인</button>
				<div class="label_cancel">
					<a class="btn btn-danger btn-block"
						href="${pageContext.request.contextPath}">취소</a>
				</div>
			</div>
			<div class="inline-block line"></div>
			<span class="or">또는</span>
			<div class="inline-block line"></div>
			<br>
			<div class="link_signup">
				<a href="/member/insert" id="font_link">새 계정 만들기</a>
			</div>
			<div class="login_link">
				<a href="/member/login" id="font_link" class="font_link_login">로그인으로
					돌아가기</a>
			</div>
		</div>

		<!-- 	비밀번호 찾기 -->
		<div id="searchP" style="display: none;">
			<div class="pw_main">
				<div class="input_findpw_id">
					<div class="label_content">
						<label class="font-weight-bold text-white" for="inputId">
							아이디 </label>
					</div>
					<div>
						<input type="text" class="form-control" id="inputId"
							name="memberId" placeholder="id">
					</div>
				</div>
				<div class="input_findpw_email">
					<div class="label_content">
						<label class="font-weight-bold text-white" for="inputEmail_2">이메일</label>
					</div>
					<div>
						<input type="email" class="form-control" id="inputEmail_2"
							name="email" placeholder="email">
					</div>
				</div>
			</div>
			<div class="form-pwbutton">
				<button id="searchBtn2" type="button"
					class="btn btn-primary btn-block" onclick="pwSearch_click()">확인</button>
				<div class="label_cancel">
					<a class="btn btn-danger btn-block"
						href="${pageContext.request.contextPath}">취소</a>
				</div>
				<div class="inline-block line"></div>
				<span class="or">또는</span>
				<div class="inline-block line"></div>
				<div class="link_signup">
					<a href="/member/insert" id="font_link">새 계정 만들기</a>
				</div>
				<div class="login_link2">
					<a href="/member/login" id="font_link" class="font_link_login2">로그인으로
						돌아가기</a>
				</div>
			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		function search_check(num) {
			if (num == '1') {
				document.getElementById("searchP").style.display = "none";
				document.getElementById("searchI").style.display = "";
			} else {
				document.getElementById("searchI").style.display = "none";
				document.getElementById("searchP").style.display = "";
			}
		}
		// 	모달기능
		$(document).ready(function() {
			// 1.모달 창 히든 불러오기
			// 확인 버튼(#searchBtn)이 클릭 되면 modal실행
			$('#searchBtn').click(function() {
				$('#background_modal').show();
			});
			// 2.모달 창 닫기 버튼
			$('.close').on('click', function() {
				$('#background_modal').hide();
			});
			// 3.모달 창,윈도우 클릭 시 닫기
			//event.target은 이벤트가 발생한 요소를 반환해준다.
			//즉 window(event.target)가  #background_modal' 와 같으면 이라는 뜻
			$(window).on('click', function() {
				if (event.target == $('#background_modal').get(0)) {
					$('#background_modal').hide();
				}
			});
		});
		// 	모달기능
		$(document).ready(function() {
			// 1.모달 창 히든 불러오기
			// 확인 버튼(#searchBtn)이 클릭 되면 modal실행
			$('#searchBtn2').click(function() {
				$('#background_modal').show();
			});
			// 2.모달 창 닫기 버튼
			$('.close').on('click', function() {
				$('#background_modal').hide();
			});
			// 3.모달 창,윈도우 클릭 시 닫기
			//event.target은 이벤트가 발생한 요소를 반환해준다.
			//즉 window(event.target)가  #background_modal' 와 같으면 이라는 뜻
			$(window).on('click', function() {
				if (event.target == $('#background_modal').get(0)) {
					$('#background_modal').hide();
				}
			});
		});
		//이메일 값 받고 출력하는 ajax
		var idv = "";
		var idSearch_click = function() {
			var email = $("#inputEmail_1").val();
			$.ajax({
				type : "post",
				url : "/member/findMemberId",
				data : {
					//email 값 controller의 파라미터로 전달
					email : email
				},
				dataType : 'json',
				//member는 controller에 있는 return값
				success : function(member) {
					$('#change_content').text('회원님의 아이디는?')
					if (member == 0) {
						$('#id_value').text('회원정보를 확인해주세요!');
					} else if (member == '1') {
						$('#id_value').text('이메일을 입력해주세요.')
					} else {
						$('#id_value').text(member);
						//아이디 값 별도로 저장(비밀번호 찾기에 아이디 값이 자동으로 입력되도록 data값을 저장)
						idv = member;
					}
				}
			});
		}
		var pwSearch_click = function() {
			var memberId = $("#inputId").val();
			var email = $("#inputEmail_2").val();
			$.ajax({
				type : "post",
				url : "/member/findPassword",
				data : {
					memberId : memberId,
					email : email
				},
				dataType : 'json',
				success : function(member) {
					$('#change_content').text('회원님의 비밀번호는?')
					if (member == 0) {
						$('#id_value').text('회원정보를 확인해 주세요!');
					} else if (member == '1') {
						$('#id_value').text('아이디/이메일을 입력해 주세요.');
					} else {
						$('#id_value').text(member);
					}
				}
			});
		}
	</script>
</body>