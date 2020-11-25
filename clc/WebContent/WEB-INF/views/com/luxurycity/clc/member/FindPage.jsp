<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- (로그인, 회원가입 제외) 모든 페이지에 공통으로 적용될 탬플릿 -->
<title>FindPage</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/clc/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/clc/js/findpage.js"></script>
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
a:link {
  text-decoration: none;
}

a:visited {
  text-decoration: none;
}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <a href="/clc/main.clc" class="w3-bar-item w3-right"><i class="fa fa-bus fa-fw" aria-hidden="true"></i>&nbsp;LuxuryCity</a>
</div>




<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-top:43px;">

  <!-- Header -->
  <!-- 필요할 것 같아 남겨둔 영역 -->
  
  <!-- 1. 아이디 찾기를 할 경우 보여주는 부분 -->
<c:if test="${TYPE eq 'idCk'}">
  <header class="w3-container w3-center" style="padding-top:22px; margin-top: 100px; margin-bottom: 30px;">
    <h2><b> 아이디 찾기 </b></h2>
  </header>
  
  <div class="w3-content w3-row-padding" style="max-width: 500px;">
  	<div class="w3-col w3-padding"><b>가입 시 등록한 이메일을 입력해주세요.</b></div>
  </div>
  <form method="POST" id="fIdfrm" class="w3-content w3-row-padding w3-margin-bottom" style="max-width: 500px;">
    <div class="w3-col"><input type="text" id="mail" name="mail" class="w3-input w3-border w3-round w3-padding-large" placeholder="Mail"></div>
  	<div class="w3-col"><div class="w3-col w3-button w3-blue w3-round w3-margin-top w3-padding-large" id="fIdbtn">찾기</div></div>
  	
    <!-- 찾기 버튼을 누르면 비동기 통신 처리를 통해 나타나는 영역 -->
    <div class="w3-col w3-margin-top w3-center w3-padding" id="fIdmsg" style="display: none;"></div>
    <div class="w3-col"><div class="w3-col w3-button w3-teal w3-round w3-margin-top w3-padding-large" id="logbtn">로그인창으로</div></div>
  </form>
</c:if>
  
  
  <!-- 2. 비밀번호 찾기를 할 경우 보여주는 부분 -->
<c:if test="${TYPE eq 'pwCk'}">
  <header class="w3-container w3-center" style="padding-top:22px; margin-top: 100px; margin-bottom: 30px;">
    <h2><b> 비밀번호 찾기 </b></h2>
  </header>
  
  <div class="w3-content w3-row-padding" style="max-width: 500px;">
  	<div class="w3-col w3-padding"><b>회원 아이디를 입력해주세요.</b></div>
  </div>
  
  <form method="POST" class="w3-content w3-row-padding w3-margin-bottom" style="max-width: 500px;">
	<div class="w3-col"><input type="text" id="id" name="id" class="w3-input w3-border w3-round w3-padding-large" placeholder="Your Id"></div>
	 
  </form>

   <form method="POST" class="w3-content w3-row-padding w3-margin-bottom" style="max-width: 500px;">
	 <div class="w3-col w3-padding"><b>비밀번호 확인 질문</b></div>
	 <div class="w3-col">
    	<select id="quest" name="quest" class="w3-select w3-border w3-round w3-padding-large">
    		    <option value="" disabled selected>Choose</option>
			<c:forEach var="list" items='${LIST}'>
			    <option value="${list.qno}" >${list.quest}</option>
			</c:forEach>
    	</select>
     </div>
	 <div class="w3-col w3-padding"><b>비밀번호 확인 답변</b></div>
	 <div class="w3-col"><input type="text" id="answer" name="answer" class="w3-input w3-border w3-round w3-padding-large" placeholder="정답"></div>

	 <div class="w3-col"><div class="w3-col w3-button w3-teal w3-round w3-margin-top w3-padding-large" id="fPwbtn">제출</div></div>
	 
   </form>
   
   <!-- 제출 버튼을 누르면 비동기 통신 처리를 통해 나타나는 영역(모달창)-->
  <div id="pwModal" class="w3-modal">
    <div class="w3-modal-content w3-animate-opacity w3-card-4">
      <header class="w3-container w3-teal"> 
        <span id="mclose" 
        class="w3-button w3-display-topright">&times;</span>
        <h2>비밀번호를 변경해주세요.</h2>
      </header>
      <form method="POST" id="pwEditfrm" name="pwEditfrm" class="w3-container">
		<div class="w3-col w3-padding"><b>New Password</b></div>
	    <div class="w3-col"><input type="password" id="pw" name="pw" class="w3-input w3-border w3-round w3-padding-large" placeholder="Password"></div>
	    
	  	<div class="w3-col w3-padding"><b>New Password Confirm</b></div>
	    <div class="w3-col w3-margin-bottom"><input type="password" id="pwconf" name="pwconf" class="w3-input w3-border w3-round w3-padding-large" placeholder="Password Check"></div>
      </form>
      <footer class="w3-container w3-teal">
          <div class="w3-col"><div class="w3-col w3-button w3-padding-large w3-hover-teal" id="pwEditbtn">변경하기</div></div>
      </footer>
    </div>
  </div>
</c:if>  
  <hr>

	<!-- 이 영역에 데이터를 추가하면 됩니다 -->
<!-- 	<div class="w3-container">--- 추가 영역 ---</div> -->

  <hr>
  <div class="w3-container w3-dark-grey w3-padding-32">
    <div class="w3-row">
      <div class="w3-container w3-third">
        <h5 class="w3-bottombar w3-border-green">Region</h5>
        <p>Seoul</p>
        <p>Gyeonggi</p>
        <p>Incheon</p>
      </div>
      <div class="w3-container w3-third">
        <h5 class="w3-bottombar w3-border-red">Information Provider</h5>
        <p>TOPIS</p>
        <p>Gbis</p>
        <p>More</p>
      </div>
      <div class="w3-container w3-third">
        <h5 class="w3-bottombar w3-border-orange">Support</h5>
        <p>Increpas</p>
      </div>
    </div>
  </div>

  <!-- Footer -->
  <footer class="w3-container w3-padding-16 w3-light-grey">
    <p>Developed by <b>Silicon Valley</b></p>
  </footer>

  <!-- End page content -->
</div>

</body>
</html>
