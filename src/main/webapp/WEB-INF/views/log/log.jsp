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
	const date = [
	   '2022-10-28',
	   '2022-10-29',
	   '2022-10-30',
	   '2022-10-31',
	   '2022-11-01',
	   '2022-11-02',
	   '2022-11-03',
	 ];
	
	 const data = {
	   labels: date,
	   datasets: [{
	     label: '날짜별 내 피드 좋아요 수',
	     backgroundColor: 'rgb(255, 99, 132)',
	     borderColor: 'rgb(255, 99, 132)',
	     data: [10, 7, 10, 5, 2, 20, 30],
	   },
	   {
		     label: '날짜별 내 피드 댓글 수',
		     backgroundColor: 'blue',
		     borderColor: 'blue',
		     data: [15, 3, 4, 11, 7, 7, 16], 
	   }]
	 };
	
	 const config = {
	   type: 'line',
	   data: data,
	   options: {}
	 };
	 const myChart = new Chart(
		    document.getElementById('myChart'),
		    config
		  );	
});
</script>
<style>
	.log-box{
		width: 1300px;
		margin: 200px auto 0;
	}
	.log-nav{
		width: 200px;
   		margin: 0 50px;	
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
	
	}
	.log-nav-content{
	
	}
</style>
<jsp:include page="../common/header.jsp"></jsp:include>
<body>
	<section class="main">
		<div class="log-box flex">
			<ul class="log-nav">
				<li class="log-nav-title">전체</li>
				<li class="log-nav-content">실시간 검색순위</li>
				<li class="log-nav-title">내 피드</li>
				<li class="log-nav-content">날짜별 좋아요 수 조회</li>
				<li class="log-nav-content">좋아요 성비 조회</li>
			</ul>
			<div class="chart-box">	
			  <canvas id="myChart"></canvas>
			</div>
		</div>
	</section>
</body>
</html>
