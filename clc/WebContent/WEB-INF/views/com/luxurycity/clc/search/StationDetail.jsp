<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<title>StationDetail</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/clc/css/cls.css">
<script type="text/javascript" src="/clc/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/clc/js/search/stationdetail.js"></script>
<style>
html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
a:link {
  text-decoration: none;
}
a:visited {
  text-decoration: none;
}
#routeNm{
	border-radius: 10px;
	height: 50px;
	border: 0px solid white!important;
}
.btnword{
	background-color: white;
	height: 50px;
	color: lightgrey;
	padding-top: 15px;
	border-radius: 10px;
}
.btnword1{
	background-color: white;
	color: dimgray;
	height: 45px;
	padding-top: 10px;

	border-radius: 10px;
}
.btndi{
	border-radius: 9px;
	
}
.text{
	background-color: white;
	font-size: 10pt;
}
.textred{
	background-color: white;
	color: red;
}
.textgreen{
	background-color: white;
	color: green;
}
h6{
	font-size: 10pt;
}
.title{
	display: inline-block;
}
</style>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
  <a href="/clc/main.clc" class="w3-bar-item w3-right"><i class="fa fa-bus fa-fw" aria-hidden="true"></i>&nbsp;LuxuryCity</a>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>

	<!-- 로그인 했을 경우 -->
<c:if test="${not empty SID}">
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="/clc${AVT.dir}${AVT.afile}" class="w3-circle w3-margin-right" style="width:46px">
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
    <a href="" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i>  문의게시판</a>
    <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-map-marker fa-fw" aria-hidden="true"></i>  지도 검색</a>
 <!-- 마이페이지는 로그인 했을 경우에만 뜨도록 한다 -->
<c:if test="${not empty SID}">
    <div class="w3-dropdown-hover">
	    <div class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i>  마이페이지 <i class="fa fa-caret-down w3-right"></i></div>
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
  
  
  <hr>
<!-- 데이터가 넘어가는 영역 -->
<form method="post" id="frm">
	<input type="hidden" name="stationid" id="stationid" value="">
</form>

	<!-- 이 영역에 데이터를 추가하면 됩니다 -->
	<div class="w3-container">
		<div class="w3-content w3-center w3-padding" style="max-width: 600px;">
			<div class="w3-col">
				<div class="w3-col">${SDATA.mobile_no}</div>
				<div class="w3-col" id="stationiNm"><h3>${SDATA.station_nn}</h3></div>
				<!-- <div class="w3-col">처인구정후문 방면</div>  -->
			<div class="w3-right w3-button w3-round w3-blue w3-margin-bottom stBkAdd" id="${SDATA.station_id}">즐겨찾기 추가</div>
			</div>
			
			<div class="w3-col w3-padding w3-border w3-left-align">
				도착까지 5분 미만
			</div>
			<div class="w3-col h50 textred w3-left-align">
				<h6 class="title w3-text-red"><b> - </b></h6>
				<h6 class="title w3-text-red"><b> - </b></h6>
			</div>
			<div class="w3-col w3-padding w3-border w3-left-align">
				도착까지 5분 이상
			</div>
			<div class="w3-col h50 textgreen w3-left-align">
				<h6 class="title w3-text-green"><b> - </b></h6>
				<h6 class="title w3-text-green"><b> - </b></h6>
			</div>
			<div class="w3-col w3-padding w3-border w3-left-align">
				경유 노선 정보
			</div>
			<div class="w3-col text w3-left-align">
				<div class="w3-col">
<!-- 정류소 경유노선 리스트 -->					
			<c:forEach var="rlist" items="${ROUTELIST}">		
					<div class="w3-col w3-white w3-border-bottom" id="${rlist.route_id}">
						<div class="w3-col w3-padding">
							<div class="w3-col w3-border-bottom w3-border-blue w3-text-gray">${rlist.route_tp}</div>
							<div class="w3-col m10" style="padding-top: 5px;">
								<div class="w3-col m4 w3-border-right w3-border-blue">
									<div class="w3-col"><span style="font-size: 32px;">${rlist.route_nm}</span> ( ${rlist.region} )</div>
									<div class="w3-col">${rlist.ed_sta_nm} 방면</div>
								</div>
								<div class="w3-col m8 w3-padding">
									<div class="w3-col"><b>약 <span style="font-size: 20px;"> - </span>분 [ - 번째 전, 여유]</b></div>
									<div class="w3-col"><b>약 <span style="font-size: 20px;"> - </span>분 [ - 번째 전, 여유]</b></div>
								</div>
							</div>
							
						</div>
					</div>
			</c:forEach>
					
				</div>
			</div>
		</div>
	</div>


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

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");
// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");
// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}
// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>

</body>
</html>