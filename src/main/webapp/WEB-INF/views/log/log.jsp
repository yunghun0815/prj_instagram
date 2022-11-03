<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/log.css">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/js/log.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<meta charset="UTF-8">
<html>
<head>
	<title>Log</title>
</head>
<script type="text/javascript">
$(function(){
	searchRanking($("#menuSearchRanking"));
});

function searchRanking(param){
	$("canvas").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#searchRanking").show();
	const d = new Date();
	const year = d.getFullYear(); 
	const month = d.getMonth();   
	const day = d.getDate();     
	
/* 	const date = [];
	for(var i=6; i>=0; i--){
		date.push(new Date(year, month, day - i).toLocaleDateString());
	}
		 const data = {
		   labels: date,
		   datasets: [{
		     label: '날짜별 내 피드 좋아요 수',
		     backgroundColor: 'rgb(255, 99, 132)',
		     borderColor: 'rgb(255, 99, 132)',
		     data: [10, 7, 10, 5, 2, 20, 30]
		   }]
		 };
		
		 const config = {
		   type: 'line',
		   data: data,
		   options: {}
		 };
		 const myChart = new Chart(
				 $("#likeCount"),
			    config
			  );	 */
};

function visitorCount(param){
	
}
//날짜별 좋아요 수 차트
function likeCount(param){
	$("canvas").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#likeCount").show();
	
	const d = new Date();
	const year = d.getFullYear(); 
	const month = d.getMonth();   
	const day = d.getDate();     
	
	const date = [];
	for(var i=6; i>=0; i--){
		date.push(new Date(year, month, day - i).toLocaleDateString());
	}
	
		
		 const data = {
		   labels: date,
		   datasets: [{
		     label: '좋아요 수',
		     backgroundColor: 'rgb(255, 99, 132)',
		     borderColor: 'rgb(255, 99, 132)',
		     data: [43, 77, 110, 55, 62, 20, 60]
		   }]
		 };
		
		 const config = {
		   type: 'line',
		   data: data,
		    options: {
		        scales: {
		            y: {
		                suggestedMin: 0,
		            }
		        }
		    }
		 };
		 const myChart = new Chart(
				 $("#likeCount"),
			    config
			  );	
};
//날짜별 방문자 수 차트
function visitorCount(param){
	$("canvas").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#visitorCount").show();
	
	const d = new Date();
	const year = d.getFullYear(); 
	const month = d.getMonth();   
	const day = d.getDate();     
	
	const date = [];
	for(var i=6; i>=0; i--){
		date.push(new Date(year, month, day - i).toLocaleDateString());
	}
	
		
		 const data = {
		   labels: date,
		   datasets: [{
		     label: '방문자 수',
		     backgroundColor: 'black',
		     borderColor: 'black',
		     data: [102, 43, 110, 55, 21, 20, 60]
		   }]
		 };
		
		 const config = {
		   type: 'line',
		   data: data,
		    options: {
		        scales: {
		            y: {
		                suggestedMin: 0,
		            }
		        }
		    }
		 };
		 const myChart = new Chart(
				 $("#visitorCount"),
			    config
			  );	
};
function genderRatio(param){
	$("canvas").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#genderRatio").show();
	
	const data = {
	  labels: ['남자', '여자'],
	  datasets: [{
	    label: '좋아요 비율',
	    data: [65, 35],
	    backgroundColor: [
	      'rgba(36, 103, 203, 0.5)',
	      'rgba(233, 18, 90, 0.5)'
	    ],
	    borderColor: [
	      'rgb(36, 103, 203)',
	      'rgb(233, 18, 90)'
	    ],
	    borderWidth: 1
	  }]
	};
	
	const config = {
			  type: 'bar',
			  data: data,
			  options: {
			    scales: {
			      y: {
			    	  suggestedMin: 0,
			    	  suggestedMax: 100
			      }
			    }
			  },
			};
	 const myChart = new Chart(
			 $("#genderRatio"),
		    config
		  );	
}
</script>
<style>
	.log-box{
		width: 1300px;
		margin: 200px auto 0;
	}
	.log-nav{
	    width: 220px;
	    margin: 0px 35px 0 80px;
	    background-color: white;
	    border: 1px solid rgb(219,219,219);
	    border-radius: 8px;
	    padding-left: 15px;
	}
	.chart-box{
		width: 900px;
	    height: 500px;
	    border: 1px solid rgb(219, 219, 219);
	    border-radius: 8px;
	    padding: 50px;
	}	
	body{
		height: 70% !important;
	}
	.log-nav-title{
	    font-weight: bold;
    	font-size: 20px;
    	margin-top: 20px;
	}
	.log-nav-content{
		margin-left: 20px;
	    font-size: 16px;
	    color: #8e8e8e;
	    cursor: pointer;
	    margin-top: 5px;
	}
	canvas{
		display: none;
	}
</style>
<jsp:include page="../common/header.jsp"></jsp:include>
<body>
	<section class="main">
		<div class="log-box flex">
			<ul class="log-nav">
				<li class="log-nav-title">전체</li>
				<li id="menuSearchRanking" class="log-nav-content" onclick="searchRanking(this)">실시간 검색순위</li>
				<li class="log-nav-title">내 피드</li>
				<li class="log-nav-content" onclick="likeCount(this)">날짜별 좋아요 수 조회</li>
				<li class="log-nav-content" onclick="visitorCount(this)">날짜별 방문자 수 조회</li>
				<li class="log-nav-content" onclick="genderRatio(this)">좋아요 성비 조회</li>
			</ul>
			<div class="chart-box">	
				<canvas id="searchRanking"></canvas>
				<canvas id="likeCount"></canvas>
				<canvas id="visitorCount"></canvas>
				<canvas id="genderRatio"></canvas>
			</div>
		</div>
	</section>
</body>
</html>
