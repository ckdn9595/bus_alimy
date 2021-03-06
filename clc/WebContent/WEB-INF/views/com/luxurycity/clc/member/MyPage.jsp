<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- (로그인, 회원가입 제외) 모든 페이지에 공통으로 적용될 탬플릿 -->
<title>LuxuryCity Main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/clc/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/clc/js/mypage.js"></script>
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
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <a href="/clc/main.clc" class="w3-bar-item w3-right"><i class="fa fa-bus fa-fw" aria-hidden="true"></i>&nbsp;LuxuryCity</a>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>

	<!-- 로그인 했을 경우 -->
<c:if test="${not empty SID}">
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="/ysun/img/avatar/img_avatar2.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8">
      <span>Welcome, <strong>회원이름</strong></span><br>
      <a href="#" class="w3-col m9 w3-tiny w3-round w3-button w3-orange w3-text-white" style="margin-top: 5px;">Logout</a>
    </div>
  </div>
</c:if>

	<!-- 로그인 하지 않을 경우 -->

<c:if test="${empty SID}">
  <div class="w3-container w3-row">
    <div class="w3-col w3-center">
      <span>로그인 후 이용해주세요.</span><br>
      <div class="w3-bar w3-center w3-margin-top">
	      <a href="#" class="w3-bar-item w3-button w3-small w3-green w3-round w3-margin-right">Login</a>
	      <a href="#" class="w3-bar-item w3-small w3-button w3-red w3-round">Join</a>
      </div>
    </div>
  </div>
</c:if>


  <hr>
<!-- 메뉴 영역 -->
  <div class="w3-container">
    <h5>Menu</h5>
  </div>
  <div class="w3-bar-block">
    <a href="" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i>  문의게시판</a>
    <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-map-marker fa-fw" aria-hidden="true"></i>  지도 검색</a>
<c:if test="${not empty SID}">
    <div class="w3-dropdown-hover">
	    <div class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i>  마이페이지 <i class="fa fa-caret-down w3-right"></i></div>
    	<div class="w3-dropdown-content w3-bar-block">
    		<a href="" class="w3-bar-item w3-button"><span class="w3-col m11 w3-right"><i class="fa fa-star fa-fw" aria-hidden="true"></i>&nbsp;&nbsp;즐겨찾기</span></a>
    		<a href="" class="w3-bar-item w3-button"><span class="w3-col m11 w3-right"><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i>&nbsp;&nbsp;회원정보</span></a>
    	</div>
    </div>
</c:if>
  </div>
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <!-- 필요할 것 같아 남겨둔 영역 -->
<!--   <header class="w3-container" style="padding-top:22px"> -->
<!--     <h5><b><i class="fa fa-dashboard"></i> Dashboard</b></h5> -->
<!--   </header> -->

<!--   <div class="w3-row-padding w3-margin-bottom"> -->
<!--     <div class="w3-quarter"> -->
<!--       <div class="w3-container w3-red w3-padding-16"> -->
<!--         <div class="w3-left"><i class="fa fa-comment w3-xxxlarge"></i></div> -->
<!--         <div class="w3-right"> -->
<!--           <h3>52</h3> -->
<!--         </div> -->
<!--         <div class="w3-clear"></div> -->
<!--         <h4>Messages</h4> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="w3-quarter"> -->
<!--       <div class="w3-container w3-blue w3-padding-16"> -->
<!--         <div class="w3-left"><i class="fa fa-eye w3-xxxlarge"></i></div> -->
<!--         <div class="w3-right"> -->
<!--           <h3>99</h3> -->
<!--         </div> -->
<!--         <div class="w3-clear"></div> -->
<!--         <h4>Views</h4> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="w3-quarter"> -->
<!--       <div class="w3-container w3-teal w3-padding-16"> -->
<!--         <div class="w3-left"><i class="fa fa-share-alt w3-xxxlarge"></i></div> -->
<!--         <div class="w3-right"> -->
<!--           <h3>23</h3> -->
<!--         </div> -->
<!--         <div class="w3-clear"></div> -->
<!--         <h4>Shares</h4> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="w3-quarter"> -->
<!--       <div class="w3-container w3-orange w3-text-white w3-padding-16"> -->
<!--         <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div> -->
<!--         <div class="w3-right"> -->
<!--           <h3>50</h3> -->
<!--         </div> -->
<!--         <div class="w3-clear"></div> -->
<!--         <h4>Users</h4> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
  
  
<!--   <hr> -->
  
	<!-- 이 영역에 데이터를 추가하면 됩니다 -->
	<div class="w3-container w3-center w3-gray">--- 마이페이지 ---</div>


  <hr>
  <div class="w3-container w3-dark-grey w3-padding-32">
    <div class="w3-row">
      <div class="w3-container w3-half">
        <h5 class="w3-bottombar w3-border-green">버스</h5>
<%--         <c:forEach data="data" items="${BUSLIST}"> --%>
<%--   	      <p>${data. } ${data. }</p> --%>
<%--         </c:forEach> --%>
		<c:forEach begin="1" end="3" varStatus="st">
       	 <input type="checkbox" name="delbus" id="delbus${st.count}" class="w3-hide tmp" value="delbus${st.count}"><p>${st.count}번째 버스</p>
		</c:forEach>
      
      </div>
      
      <div class="w3-container w3-half">
        <h5 class="w3-bottombar w3-border-orange">정류소</h5>
<%--         <c:forEach data="data" items="${STATIONLIST}"> --%>
<%--   	      <p>${data. } ${data. }</p> --%>
<%--         </c:forEach> --%>
        <c:forEach begin="1" end="3" varStatus="st">
       	 <input type="checkbox" name="delstation" id="delstation${st.count}" class="w3-hide tmp" value="delstation${st.count}"><p>${st.count}번째 정류소</p>
		</c:forEach>
      </div>
    </div>
    <div class="w3-row-third">
  			<div class="w3-container">
       			 <h5 class="w3-button w3-right w3-green" id="delbtn">삭제</h5>
       			 <h5 class="w3-button w3-right w3-green w3-hide" id="deletebtn">삭제</h5>
       			 <h5 class="w3-button w3-border-right w3-right w3-green w3-hide" id="redelbtn">취소</h5>
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