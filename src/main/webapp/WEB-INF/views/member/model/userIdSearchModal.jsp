<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.background_modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 10; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.title_text {
	text-align: center;
	padding-top: 20px;
}
/* Modal Content/Box */
.modal-body {
	border-radius: 20px;
	background-color: #fefefe;
	margin: 60% auto; /* 15% from the top and centered */
	padding: 20px;
	width: 40%; /* Could be more or less, depending on screen size */
}
</style>
</head>
<body>
	<div id="background_modal" class="background_modal"
		style="display: none;">
			<div class="modal-body">
				<div class="title_text">
					<b id="change_content"></b>
				</div>
				<h2 id="id_value" style="text-align : center;"></h2>
				<br>
		</div>
	</div>

</body>
</html>