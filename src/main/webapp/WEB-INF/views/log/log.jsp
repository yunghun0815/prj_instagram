<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/main"/>
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
				<li class="log-nav-title"><fmt:message key="COMMON"/></li>
				<li id="menuSearchRanking" class="log-nav-content" onclick="searchRanking(this)"><fmt:message key="REALTIME"/></li>
				<li class="log-nav-title"><fmt:message key="MYFEED"/></li>
				<li class="log-nav-content" onclick="likeCount(this)"><fmt:message key="LIKES_DATE"/></li>
				<!-- <li class="log-nav-content" onclick="visitorCount(this)">날짜별 방문자 수 조회</li> -->
				<li class="log-nav-content" onclick="genderRatio(this)"><fmt:message key="LIKES_GENDER"/></li>
			</ul>
			<div class="chart-box">
				<div id="searchRanking" class="chart">
					<h1><fmt:message key="REALTIME_TITLE"/></h1>	
					<table id ="searchTable">
						<tr>
							<th><fmt:message key="AGE_GROUP"/></th>
							<th><fmt:message key="KEYWORD"/></th>
						</tr>
						<tr>
							<td><fmt:message key="AGE_10"/></td>
							<td class="10">-</td>
						</tr>
						<tr>
							<td><fmt:message key="AGE_20"/></td>
							<td class="20">-</td>
						</tr>
						<tr>
							<td><fmt:message key="AGE_30"/></td>
							<td class="30">-</td>
						</tr>
						<tr>
							<td><fmt:message key="AGE_40"/></td>
							<td class="40">-</td>
						</tr>
						<tr>
							<td><fmt:message key="AGE_50"/></td>
							<td class="50">-</td>
						</tr>
						<tr>
							<td><fmt:message key="AGE_60"/></td>
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
