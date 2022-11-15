<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/member/model/userIdSearchModal.jsp"%>
	<div class="sub-title font-weight-bold text-white">
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
			<label class="font-weight-bold text-white" for="inputEmail_1">이메일</label>
			<div>
				<input type="text" class="form-control" id="inputEmail_1"
					name="email" placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<button id="searchBtn" type="button" onclick="idSearch_click()"
				class="btn btn-primary btn-block">확인</button>
			<a class="btn btn-danger btn-block"
				href="${pageContext.request.contextPath}">취소</a>
		</div>
	</div>

	<!-- 	비밀번호 찾기 -->
	<div id="searchP" style="display: none;">
		<div class="form-group">
			<label class="font-weight-bold text-white" for="inputId"> 아이디
			</label>
			<div>
				<input type="text" class="form-control" id="inputId" name="memberId"
					placeholder="id">
			</div>
		</div>
		<div class="form-group">
			<label class="font-weight-bold text-white" for="inputEmail_2">이메일</label>
			<div>
				<input type="email" class="form-control" id="inputEmail_2"
					name="email" placeholder="email">
			</div>
		</div>
		<div class="form-group">
			<button id="searchBtn2" type="button"
				class="btn btn-primary btn-block" onclick="pwSearch_click">확인</button>
			<a class="btn btn-danger btn-block"
				href="${pageContext.request.contextPath}">취소</a>
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
		//이메일 값 받고 출력하는 ajax
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
					if (member == 0) {
						$('#id_value').text('회원정보를 확인해주세요!');
					} else if (member == '1') {
						$('#id_value').text('이메일을 입력해주세요.')
					} else {
						$('#id_value').text(member);
						//아이디 값 별도로 저장(비밀번호 찾기에 아이디 값이 자동으로 입력되도록 data값을 저장)
						email = member;
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
				success : function (member) {
					if (member==0) {
						$('#id_value').text('회원정보를 확인해 주세요!');
					}else if (member == '1') {
						$('#id_value').text('이메일/아이디를 입력해 주세요.');
					}else {
						$('#id_value').text(member);
					}
				}
			});
		}
	</script>
</body>