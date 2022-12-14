<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setBundle basename="i18n/main"/>
<!DOCTYPE html>
<html>
<title>Instagram</title>
<style type="text/css">
.error {
	color: red
}
body{
background-color: #fafafa;
}
html{
	display: flex;
    justify-content: center;
    flex-direction: column;
    height: 100%;
}
.total_update {
	border: solid 1px #dbdbdb;
	width: 400px;
	height: 450px;
	padding-top: 3%;
	padding-left: 3%;
	background-color: #ffffff;
	margin: 0 auto;
}

#update_profileImg {
	border: 1px solid #fafafa;
	border-radius: 40px;
	width: 50px;
	height: 50px;
	display: inline-block;
}
/* label스타일 조정 */
.input_file {
	display: flex;
	justify-content: center;
}

label {
	cursor: pointer;
	font-size: 1em;
}
/* input숨기기 */
#chooseFile {
	visibility: hidden;
}

.file_style {
	width: 53px;
	height: 53px;
	/* 	display: inline-block; */
	float: left;
	padding-right: 10%;
	margin-top: 2.2%;
}

.update_inputId {
	border: none;
	font-size: 20px;
}

label {
	width: 400px;
	font-size: 13px;
	color: #0095f6;
	font-weight: bold;
}

.update_name {
	display: inline-block;
	float: left;
	padding-right: 5%;
	padding-left: 6%;
	padding-top: 1%;
	font-weight: bold;
}

.input_box {
	width: 250px;
	height: 25px;
	float: right;
	margin-right: 50px;
	border-radius: 3px;
    border: 1px solid #afafaf;
}

.udpate_input {
	height: 100%;
}

.total_input {
	height: 20%;
	padding-top: 15px;
	margin-left: -25px;
}

p {
	font-size: 11px;
	display: inline-block;
	width: 258px;
	margin-left: 28%;
	margin-top: 3px;
	margin-bottom: auto;
}
.button_submit{
    text-align: center;
    width: 15%;
    height: 25px;
    background: #0095f6;
    border: 1px solid #0095f6;
    border-radius: 3px;
    color: #fff;
    margin-left: 40%;
    margin-top: 5%;
}
span{
	font-size: 11px;
    display: inline-block;
    width: 258px;
    margin-left: 28%;
}
.member-delete{
    position: relative;
    left: 101px;
    top: 62px;
    text-decoration: none;
    color: black;
    font-size: 12px;
    font-weight: bold;
    display: inline-block;
    background-color: white;
    border: 1px solid rgb(219,219,219);
    width: 71px;
    height: 25px;
    text-align: center;
    padding-top: 8px;
    border-radius: 5px;
}
</style>
<%-- <jsp:include page="/WEB-INF/views/common/header.jsp"/> --%>
<body>
	<form:form action="/member/update" enctype="multipart/form-data"
		method="post" modelAttribute="memberUpdate">
		<div class="total_update">
			<div class="total_input2">
				<div class="file_style">
					<c:if
						test="${fileNo==0 }">
						<img class="profile-img" id="update_profileImg" src="/image/profile_null.jpg">
						<input type="hidden" name="fileNo" value="${fileNo }">
					</c:if>
					<c:if
						test="${fileNo != 0}">
						<img id="update_profileImg" src="/file/${sessionScope.fileNo}">
						<input type="hidden" name="fileNo" value="${fileNo }">
					</c:if>
				</div>
				<div class="total_input">
					<div class="update_input">
						<input type="text" name="memberId" class="update_inputId"
							value="${sessionScope.memberId }"
							${empty sessionScope.memberId ? "" : "readonly"}
							required="required" />
					</div>
				</div>
				<div class="input_file">
					<label for="chooseFile"><fmt:message key="CHANGE_PROFILE"/></label>
					<!--accept 속성은 image/*하면 image 파일만 선택되도록 만들 수 있다-->
					<input type="file" name="file" id="chooseFile" accept="image/*">
				</div>
			</div>
			<div class="total_input">
				<div class="update_name"><fmt:message key="NICKNAME"/></div>
				<div class="update_input">
					<form:input type="text" path="nickname" value="${member.nickname }"
						class="input_box" />
					<p><fmt:message key="CHANGE_NICKNAME"/></p>
					<form:errors path="nickname" class="error" />
				</div>
			</div>
			<div class="total_input">
				<div class="update_name"><fmt:message key="PW"/></div>
				<div class="update_input">
					<form:input type="password" path="password"
						value="${member.password }" required="required" class="input_box" />
					<p><fmt:message key="CHANGE_PW"/></p>
					<form:errors path="password" class="error" />
				</div>
			</div>
			<div class="total_input">
				<div class="update_name"><fmt:message key="PHONE"/></div>
				<div class="update_input">
					<form:input type="text" path="phoneNumber"
						value="${member.phoneNumber }" class="input_box" />
					<p><fmt:message key="CHANGE_PHONE"/></p>
					<form:errors path="phoneNumber" class="error" />
				</div>
			</div>
				<input type="submit" class="button_submit" value="<fmt:message key='SUBMIT'/> ">
				<a class="member-delete" href="/member/delete"><fmt:message key="EXIT_MEMBER"/></a>
		</div>
	</form:form>
</body>
</html>