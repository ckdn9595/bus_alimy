<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- (로그인, 회원가입 제외) 모든 페이지에 공통으로 적용될 탬플릿 -->
<title>Login</title>
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
    <h2><b> LOGIN </b></h2>
  </header>

  <form method="POST" class="w3-content w3-row-padding w3-margin-bottom" style="max-width: 500px;">
  	<!-- 이 input tag에 아이디 찾기를 누르면 idCk를, 비번찾기를 누르면 pwCk를 value값으로 설정하고 보낸다. -->
  	<input type="hidden" name="findType" id="findType">
    <div class="w3-col"><input type="text" id="id" name="id" class="w3-input w3-border w3-round w3-padding-large" placeholder="UserId"></div>
    <div class="w3-col"><input type="password" id="pw" name="pw" class="w3-input w3-border w3-round w3-padding-large w3-margin-top w3-margin-bottom" placeholder="Password"></div>
  	<div class="w3-col"><div class="w3-col w3-button w3-blue w3-round w3-margin-top w3-padding-large" id="lbtn">LOGIN</div></div>
  	
  	<div class="w3-content w3-center" style="max-width: 300px;">
	  	<div class="w3-col w3-center" style="font-size: 14px; margin-top: 20px;">
	  	<!-- 아이디 찾기와 비번 찾기의 href는 javascript단에서 처리하기로 한다. -->
	  		<div class="w3-third w3-text-gray"><a href="/clc/member/findpage.clc" id="idCk">아이디찾기</a></div>
	  		<div class="w3-third w3-text-gray"><a href="/clc/member/findpage.clc" id="pwCk">비밀번호찾기</a></div>
	  		<div class="w3-third w3-text-gray"><a href="/clc/member/join.clc">회원가입</a></div>
	  	</div>
	</div>
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
