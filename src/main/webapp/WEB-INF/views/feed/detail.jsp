	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="https://malsup.github.io/jquery.form.js"></script> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f15e87f34a476fe8fa135f049ed1d36b&libraries=services"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<!-- <script type="text/javascript" src="/js/main.js"></script> -->
<script type="text/javascript" src="/js/feed/detail.js"></script>
<meta charset="UTF-8">
<html>
<head>
	<title>상세페이지</title>
</head>
<style>
	body{
		height: 0 !important;
	}
	.main{
		padding-bottom: 100px !important;
		margin-top: 70px !important;
		 
	}
	.editBox{
		width: 800px;
	    margin: 0 auto;
	    text-align: right;
	    position: relative;
	    top: 20px;
	    height: 30px;
	}
	.editBtn{
		color: gray;
    	font-weight: bold;
	}
</style>
<jsp:include page="../common/header.jsp"></jsp:include>
<body>

	<input type="hidden" value="${feedNo}" id="feedNo">
	<section class="main">
		<div class="editBox">
		</div>
		<ul class="feed-ul"> 
		</ul>
	</section>
	
	<div class="modal" id="delmodal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Delete Feed</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>게시물을 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <a href="/feed/delete?feedNo=${feedNo}"><button type="button" class="btn btn-primary">Delete</button></a>
      </div>
    </div>
  </div>
</div>
</body>
<!-- kakao map modal -->
<div class="modal fade" id="modal-map" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<div id="map" style="width: 500px; height: 400px;"></div>
				<ul style=" width:525px; margin:0 auto;">
					<!-- 사진 리스트 -->
				</ul>
			</div>
		</div>
	</div>
</div>
</html>