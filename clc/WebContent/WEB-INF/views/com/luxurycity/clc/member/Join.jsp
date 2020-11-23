<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- (로그인, 회원가입 제외) 모든 페이지에 공통으로 적용될 탬플릿 -->
<title>Join</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/clc/js/jquery-3.5.1.min.js"></script>
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
  <header class="w3-container w3-center" style="padding-top:22px; margin-top: 100px; margin-bottom: 30px;">
    <h2><b> JOIN </b></h2>
  </header>

  <form method="POST" class="w3-content w3-row-padding w3-margin-bottom" style="max-width: 500px;">
  	<div class="w3-col w3-padding"><b>Your Id</b></div>
    <div class="w3-col"><input type="text" id="id" name="id" class="w3-input w3-border w3-round w3-padding-large" placeholder="Id"></div>
    
  	<div class="w3-col w3-padding"><b>Your Password</b></div>
    <div class="w3-col"><input type="password" id="pw" name="pw" class="w3-input w3-border w3-round w3-padding-large" placeholder="Password"></div>
    
  	<div class="w3-col w3-padding"><b>Password Confirm</b></div>
    <div class="w3-col"><input type="password" id="pwconf" name="pwconf" class="w3-input w3-border w3-round w3-padding-large" placeholder="Password Check"></div>
  	
  	<div class="w3-col w3-padding w3-margin-top"><b>Name</b></div>
    <div class="w3-col"><input type="text" id="name" name="name" class="w3-input w3-border w3-round w3-padding-large" placeholder="Name"></div>
  	
  	<div class="w3-col w3-padding"><b>Mail</b></div>
    <div class="w3-col"><input type="text" id="mail" name="mail" class="w3-input w3-border w3-round w3-padding-large" placeholder="Mail"></div>
  	
  	<div class="w3-col w3-padding"><b>Gender</b></div>
    <div class="w3-col">
    	<select id="gen" name="gen" class="w3-select w3-border w3-round w3-padding-large">
    		    <option value="" disabled selected>Choose</option>
			    <option value="M">남자</option>
			    <option value="F">여자</option>
    	</select>
    </div>
    
  	<div class="w3-col w3-padding"><b>Avatar</b></div>
  	
  	<!-- 남자를 선택했을 경우 -->
  	<div class="w3-col w3-margin-bottom">
  		<div class="w3-third w3-circle w3-padding w3-center"><img src="/clc/img/avatar/img_avatar1.png" class="w3-circle w3-card-4" width="100%" height="auto"><input class="w3-radio w3-tiny" type="radio" name="avatar" value="11" checked></div>
  		<div class="w3-third w3-circle w3-padding w3-center"><img src="/clc/img/avatar/img_avatar2.png" class="w3-circle w3-card-4" width="100%" height="auto"><input class="w3-radio w3-small" type="radio" name="avatar" value="12"></div>
  		<div class="w3-third w3-circle w3-padding w3-center"><img src="/clc/img/avatar/img_avatar3.png" class="w3-circle w3-card-4" width="100%" height="auto"><input class="w3-radio w3-small" type="radio" name="avatar" value="13"></div>
  	</div>
  	<!-- 여자를 선택했을 경우 -->
  	<div class="w3-col w3-margin-bottom">
  		<div class="w3-third w3-circle w3-padding w3-center"><img src="/clc/img/avatar/img_avatar4.png" class="w3-circle w3-card-4" width="100%" height="auto"><input class="w3-radio w3-small" type="radio" name="avatar" value="14" checked></div>
  		<div class="w3-third w3-circle w3-padding w3-center"><img src="/clc/img/avatar/img_avatar5.png" class="w3-circle w3-card-4" width="100%" height="auto"><input class="w3-radio w3-small" type="radio" name="avatar" value="15"></div>
  		<div class="w3-third w3-circle w3-padding w3-center"><img src="/clc/img/avatar/img_avatar6.png" class="w3-circle w3-card-4" width="100%" height="auto"><input class="w3-radio w3-small" type="radio" name="avatar" value="16"></div>
  	</div>
  	<div class="w3-col"><div class="w3-col w3-button w3-teal w3-round w3-margin-top w3-padding-large">JOIN</div></div>
  	

  </form>
  
  
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
