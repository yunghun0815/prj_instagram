<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <fmt:setBundle basename="앞으로만들폴더명/board"> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  .tab_menu {
     position:relative;
  }
  .tab_menu .list {
    overflow:hidden;
  }
  .tab_menu .list li {
    float:left;
  }
  .tab_menu .list .btn {
    font-size:17px;
    margin-right:14px;
  }
  .tab_menu .list li.is_on .btn {
    font-weight:bold;
    color:green;
  }
    
<%-- 전부 수정해야 함 한 번에 화면에 나오게.. --%>  
  
</style>
</head>
<jsp:include page="../common/header.jsp"></jsp:include>
<body>
<div class="container">
   <div class="content" style="margin: 60px;">
      <div class="tab_menu">
        <ul class="list">
          <li class="is_on">
            <a href="#tab1" class="btn" onclick="tab1();">계 정</a>
          </li>
          <li>
            <a href="#tab2" class="btn" onclick="tab2();">태 그</a>
          </li>
        </ul>
      </div>
      <div id="divMember" style="display: block">
         <!-- 테스트용 소스코드 : 나중에 필요없어지면 지우자-->
         테스트용 -> ${attribute1}
         <br/>
         <br/>
         검색결과 : ↓
         <br/>
         <c:forEach var="member" items="${memberList}">
            <span>아이디: ${member.memberId}</span> <span>이름: ${member.name}</span> <br/>
         </c:forEach>
      </div>
      <div id="divHash" style="display: none">
         테스트 테스트 테스트
      </div>
      <!-- 이 아래 테스트용 나중에 다 하고 지울 것임 -->
      <br/><br/><br/><br/><br/>
      <span onclick="alert(searchFlag)">테스트용 버튼 테스트용 버튼!!</span>
   

</div>

</div> 
<script type="text/javascript">
function tab1() {
   document.getElementById('divMember').style.display = "block";
   document.getElementById('divHash').style.display = "none";
   searchFlag = 1;
}
function tab2() {
   document.getElementById('divMember').style.display = "none";
   document.getElementById('divHash').style.display = "block";
   searchFlag = 2;
}


const tabList = document.querySelectorAll('.tab_menu .list li');

for(var i = 0; i < tabList.length; i++){
  tabList[i].querySelector('.btn').addEventListener('click', function(e){
    e.preventDefault();
    for(var j = 0; j < tabList.length; j++){
      tabList[j].classList.remove('is_on');
    }
    this.parentNode.classList.add('is_on');
  });
}
</script>

</body>
</html>