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
	$(".chart").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#searchRanking").show();
	
	

};

function visitorCount(param){
	
}
//날짜별 좋아요 수 차트
function likeCount(param){
	$(".chart").hide();
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
	$(".chart").hide();
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
	$(".chart").hide();
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
	table{
		box-shadow:  7px 7px 10px #8e8e8e;
	}
	table, tr, td, th{
	border-collapse: collapse;
	border: 2px solid gray;
	text-align: center;
	}
	#searchRanking h1{
		text-align: center;
		margin-bottom: 20px;
	}
	#searchRanking table tr:first-child{
	    background-color: rgb(100,100,100);
    	color: white;
	}
	#searchRanking table tr th:first-child{
		width: 30%;
	}
	#searchRanking, table{
		width: 600px;
	    margin: 0 auto;
	    height: 350px;
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
				<div id="searchRanking" class="chart">
					<h1>연령대별 검색어 1위</h1>	
					<table>
						<tr>
							<th>연령대</th>
							<th>키워드</th>
						</tr>
						<tr>
							<td>전체</td>
							<td>축구</td>
						</tr>
						<tr>
							<td>10대</td>
							<td>뉴진스</td>
						</tr>
						<tr>
							<td>20대</td>
							<td>축구</td>
						</tr>
						<tr>
							<td>30대</td>
							<td>asdfqwer</td>
						</tr>
						<tr>
							<td>40대</td>
							<td>골프</td>
						</tr>
						<tr>
							<td>50대</td>
							<td>hello</td>
						</tr>
						<tr>
							<td>60대</td>
							<td>-</td>
						</tr>
					</table>
				</div>
				<canvas id="likeCount" class="chart"></canvas>
				<canvas id="visitorCount" class="chart"></canvas>
				<canvas id="genderRatio" class="chart"></canvas>
			</div>
		</div>
	</section>
</body>
</html>
