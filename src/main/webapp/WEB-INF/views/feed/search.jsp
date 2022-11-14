<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <fmt:setBundle basename="앞으로만들폴더명/board"> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
table {
   border: 1px solid #444444;
   margin-top: 100px;
   margin-left: auto;
   margin-right: auto;
}

div {
	display
}

th, td {
   border: 1px solid #444444;
   padding: 20px;
}
</style>
</head>

<jsp:include page="../common/header.jsp"></jsp:include>
<body>
<!--    <div style="width:45%; float:left";> -->
<div>
   <div class="inline-block">
      <table>
         <tr>
            <th>계정</th>
         </tr>
         <c:forEach var="member" items="${memberList}">
            <tr>
               <td>아이디: ${member.memberId} 이름: ${member.nickname}</td>
            </tr>
         </c:forEach>
      </table>
      </div>
   <!-- <div style="width:45%; float:left";> -->
   <div class="inline-block">
      <table>
         <tr>
            <th>태그</th>
         </tr>
         <c:forEach var="hashtag" items="${hashtagList}">
            <tr>
               <td>
                  <span>해시태그: ${hashtag.hashtag}</span><br/>
                  <span style="font-size: 8pt;">카운트: ${hashtag.cnt}</span>
               </td>
            </tr>
         </c:forEach>
      </table>
   </div>
  </div>
</body>
</html>