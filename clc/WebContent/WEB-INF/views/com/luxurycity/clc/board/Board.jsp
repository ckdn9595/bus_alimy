<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- (로그인, 회원가입 제외) 모든 페이지에 공통으로 적용될 탬플릿 -->
<title>문의게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/clc/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/clc/js/board/board.js"></script>
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
      <img src="/clc${AVT.dir}${AVT.afile}" class="w3-circle w3-card-4 w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s8">
      <span>Welcome, <strong>${SID}</strong></span><br>
      <a href="/clc/member/logout.clc" class="w3-col m9 w3-tiny w3-round w3-button w3-orange w3-text-white" style="margin-top: 5px;">Logout</a>
    </div>
  </div>
</c:if>

	<!-- 로그인 하지 않을 경우 -->

<c:if test="${empty SID}">
  <div class="w3-container w3-row">
    <div class="w3-col w3-center">
      <span>로그인 후 이용해주세요.</span><br>
      <div class="w3-bar w3-center w3-margin-top">
	      <a href="/clc/member/login.clc" class="w3-bar-item w3-button w3-small w3-green w3-round w3-margin-right">Login</a>
	      <a href="/clc/member/join.clc" class="w3-bar-item w3-small w3-button w3-red w3-round">Join</a>
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
    <a href="/clc/board/board.clc" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i>  문의게시판</a>
    <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-map-marker fa-fw" aria-hidden="true"></i>  지도 검색</a>
 <!-- 마이페이지는 로그인 했을 경우에만 뜨도록 한다 -->
<c:if test="${not empty SID}">
    <div class="w3-dropdown-hover">
	    <div class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i>  마이페이지 <i class="fa fa-caret-down w3-right"></i></div>
    	<div class="w3-dropdown-content w3-bar-block">
    		<a href="/clc/member/mypage.clc" class="w3-bar-item w3-button"><span class="w3-col m11 w3-right"><i class="fa fa-star fa-fw" aria-hidden="true"></i>&nbsp;&nbsp;즐겨찾기</span></a>
    		<a href="/clc/member/myinfo.clc" class="w3-bar-item w3-button"><span class="w3-col m11 w3-right"><i class="fa fa-info-circle fa-fw" aria-hidden="true"></i>&nbsp;&nbsp;회원정보</span></a>
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
  
  
  <hr>
	
	<!-- 게시글 수정 창(모달창) -->
	  <div id="id01" class="w3-modal">
	    <div class="w3-modal-content w3-animate-top w3-card-4">
	      <header class="w3-container w3-pink w3-center"> 
	        <span onclick="document.getElementById('id01').style.display='none'" 
	        class="w3-button w3-display-topright">&times;</span>
	        <h2>Board Edit</h2>
	      </header>
	      <div class="w3-container">
			<div class="w3-col w3-padding-large w3-white">
				<div class="w3-col m2"><img src="/clc/img/avatar/img_avatar1.png" class="w3-round" width="110px;" height="auto"></div>
				<textarea rows="4" cols="auto" placeholder="내용을 입력하세요!" class="w3-col m8 w3-input w3-border w3-round" style="resize: none;"></textarea>
				<div class="w3-cell w3-col m2" style="padding-left: 20px; padding-top: 8px;">
					<div class="w3-col w3-button w3-dark-gray w3-margin-bottom w3-round rbtn">reset</div>
					<div class="w3-col w3-button w3-blue-gray w3-round" id="ebtn">edit</div>
				</div>
			</div>
	      </div>
	    </div>
	  </div>
	  
	  
	<!-- 이 영역에 데이터를 추가하면 됩니다 -->
	<div class="w3-container">
	<!-- 문의 게시판 -->
		<h5 class="w3-margin-bottom"><b><i class="fa fa-pencil"></i> 문의게시판</b></h5>
		
		<div class="w3-content w3-row-padding w3-margin-bottom" style="max-width: 800px;">
<c:if test="${empty SID}">		
			<div class="w3-col w3-padding-large w3-card-2 w3-white w3-margin-bottom">
				<div class="w3-col m2"><img src="/clc/img/avatar/img_avatar1.png" class="w3-round" width="110px;" height="auto"></div>
				<textarea rows="4" cols="auto" placeholder="로그인 후 이용하세요." class="w3-col m8 w3-input w3-border w3-round" style="resize: none;" disabled></textarea>
				<div class="w3-cell w3-col m2" style="padding-left: 20px; padding-top: 8px;">
					<div class="w3-col w3-dark-gray w3-margin-bottom w3-round">reset</div>
					<div class="w3-col w3-blue-gray w3-round">write</div>
				</div>
			</div>
</c:if>

<c:if test="${not empty SID}">
			<div class="w3-col w3-padding-large w3-card-2 w3-white w3-margin-bottom">
				<div class="w3-col m2"><img src="/clc/img/avatar/img_avatar1.png" class="w3-round" width="110px;" height="auto"></div>
				<textarea rows="4" cols="auto" placeholder="내용을 입력하세요!" class="w3-col m8 w3-input w3-border w3-round" style="resize: none;"></textarea>
				<div class="w3-cell w3-col m2" style="padding-left: 20px; padding-top: 8px;">
					<div class="w3-col w3-button w3-dark-gray w3-margin-bottom w3-round rbtn">reset</div>
					<div class="w3-col w3-button w3-blue-gray w3-round" id="wbtn">write</div>
				</div>
			</div>
</c:if>
		<div class="w3-col w3-margin-bottom"><hr style="border-top: 1px solid lightgray;"></div>
		
		<!-- 게시글 반복해서 뿌려주기 -->
		<c:forEach var="LIST" items="${LIST}">	
			<div class="w3-col w3-padding-large w3-card-2 w3-white w3-margin-bottom w3-display-container">
			<!-- 게시글 삭제 버튼 -->
				<div class="w3-display-topright w3-button w3-small w3-text-red"><i class="fa fa-times" aria-hidden="true"></i></div>
				
				<div class="w3-col m2"><img src="/clc/img/avatar/img_avatar1.png" class="w3-round" width="110px;" height="auto"></div>
				<div class="w3-col m10">
					<div class="w3-col w3-border-bottom w3-left w3-text-grey" style="padding-left: 16px; padding-bottom: 3px;">
						<div class="w3-cell w3-left">${LIST.sid}</div>
						<div class="w3-cell w3-right" style="margin-right: 20px;">${LIST.swdate}</div>
					</div>
			<!-- 아이디 수정하세요! -->		
					<div class="w3-col w3-padding w3-left-align" id="${LIST.bno}">${LIST.body}</div>
			<!-- 삭제 & 수정 버튼은 해당 아이디 소유자만 보여야 한다. -->
<%-- 			<c:if test="${SID eq LIST.sid}">		 --%>
					<div class="w3-button w3-right w3-round" id="dbtn"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;delete</div>
			<!-- 게시글 수정 버튼 -->
					<div class="w3-button w3-right w3-round" onclick="document.getElementById('id01').style.display='block'" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;edit</div>
<%-- 			</c:if>		 --%>
				</div>
			</div>
		</c:forEach>


			<!-- 기능이 완성되면 삭제해주세요. -->
<!-- 			<div class="w3-col w3-padding-large w3-card-2 w3-white w3-margin-bottom w3-display-container"> -->
<!-- 			<!-- 게시글 삭제 버튼 -->
<!-- 				<div class="w3-display-topright w3-button w3-small w3-text-red"><i class="fa fa-times" aria-hidden="true"></i></div> -->
				
<!-- 				<div class="w3-col m2"><img src="/clc/img/avatar/img_avatar1.png" class="w3-round" width="110px;" height="auto"></div> -->
<!-- 				<div class="w3-col m10"> -->
<!-- 					<div class="w3-col w3-border-bottom w3-left w3-text-grey" style="padding-left: 16px; padding-bottom: 3px;"> -->
<!-- 						<div class="w3-cell w3-left">dolphini0727</div> -->
<!-- 						<div class="w3-cell w3-right" style="margin-right: 20px;">2020/11/23 14:14</div> -->
<!-- 					</div> -->
<!-- 					<div class="w3-col w3-padding w3-left-align">글내용</div> -->
<!-- 			<!-- 게시글 수정 버튼 -->
<!-- 					<div class="w3-button w3-right w3-round"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;edit</div> -->
					
<!-- 				</div> -->
<!-- 			</div> -->
			
<!-- 			<div class="w3-col w3-padding-large w3-card-2 w3-white w3-margin-bottom w3-display-container"> -->
<!-- 			<!-- 게시글 삭제 버튼 -->
<!-- 				<div class="w3-display-topright w3-button w3-small w3-text-red"><i class="fa fa-times" aria-hidden="true"></i></div> -->
				
<!-- 				<div class="w3-col m2"><img src="/clc/img/avatar/img_avatar1.png" class="w3-round" width="110px;" height="auto"></div> -->
<!-- 				<div class="w3-col m10"> -->
<!-- 					<div class="w3-col w3-border-bottom w3-left w3-text-grey" style="padding-left: 16px; padding-bottom: 3px;"> -->
<!-- 						<div class="w3-cell w3-left">dolphini0727</div> -->
<!-- 						<div class="w3-cell w3-right" style="margin-right: 20px;">2020/11/23 14:14</div> -->
<!-- 					</div> -->
<!-- 					<div class="w3-col w3-padding w3-left-align">글내용</div> -->
<!-- 			<!-- 게시글 수정 버튼 -->
<!-- 					<div class="w3-button w3-right w3-round"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;edit</div> -->
					
<!-- 				</div> -->
<!-- 			</div> -->
			
			
		</div>
		
		<!-- 게시글 내용 전송하기 -->
		<form method="post" id="frm">
			<input type="hidden" id="body" name="body">
			<input type="hidden" id="bno" name="bno">
		</form>
		
		<!-- 페이징 처리 -->
		<div class="w3-bar w3-center">
			<form method="post" name="pfrm" id="pfrm">
				<input type="hidden" name="nowPage" id="nowPage">
			 </form>
				
		<!-- 이전버튼 -->
	<c:if test="${PAGE.startPage != 1}">
			<span class="w3-button pbtn" id="${PAGE.startPage-1}">&laquo;</span>
	</c:if>	
	<c:if test="${PAGE.startPage == 1}">
			<span class="pbtn" id="${PAGE.startPage-1}">&laquo;</span>
	</c:if>
			
			<!-- 기능이 완성되면 주석을 풀어주세요. -->
	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
		  	<span class="w3-button pbtn">${page}</span>
	</c:forEach>
			
		<!-- 다음버튼 -->
	<c:if test="${PAGE.endPage == PAGE.totalPage}">
		 	<span class="pbtn" id="${PAGE.endPage+1}">&raquo;</span>
	 </c:if> 
	<c:if test="${PAGE.endPage != PAGE.totalPage}">
		 	<span class="w3-button pbtn" id="${PAGE.endPage+1}">&raquo;</span>
	 </c:if> 
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
