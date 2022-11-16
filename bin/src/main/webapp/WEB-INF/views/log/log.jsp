<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/log/log.css">
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript" src="/js/log/log.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<meta charset="UTF-8">
<html>
<head>
	<title>Log</title>
</head>
<jsp:include page="../common/header.jsp"></jsp:include>
<body>
	<section class="main">
		<div class="log-box flex">
			<ul class="log-nav">
				<li class="log-nav-title">전체</li>
				<li id="menuSearchRanking" class="log-nav-content" onclick="searchRanking(this)">실시간 검색순위</li>
				<li class="log-nav-title">내 피드</li>
				<li class="log-nav-content" onclick="likeCount(this)">날짜별 좋아요 수 조회</li>
				<!-- <li class="log-nav-content" onclick="visitorCount(this)">날짜별 방문자 수 조회</li> -->
				<li class="log-nav-content" onclick="genderRatio(this)">좋아요 성비 조회</li>
			</ul>
			<div class="chart-box">
				<div id="searchRanking" class="chart">
					<h1>연령대별 검색어 1위</h1>	
					<table id ="searchTable">
						<tr>
							<th>연령대</th>
							<th>키워드</th>
						</tr>
						<tr>
							<td>10대</td>
							<td class="10">-</td>
						</tr>
						<tr>
							<td>20대</td>
							<td class="20">-</td>
						</tr>
						<tr>
							<td>30대</td>
							<td class="30">-</td>
						</tr>
						<tr>
							<td>40대</td>
							<td class="40">-</td>
						</tr>
						<tr>
							<td>50대</td>
							<td class="50">-</td>
						</tr>
						<tr>
							<td>60대</td>
							<td class="60">-</td>
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
