<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cls Project Join Form</title>
<link rel="stylesheet" type="text/css" href="/clc/css/w3.css">
<link rel="stylesheet" type="text/css" href="/clc/css/cls.css">
<script type="text/javascript" src="/clc/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/clc/js/main.js"></script>
</head>
<body>
	<div class="w3-button w3-deep-purple w3-hover-purple w3-margin w3-right" id="login">로그인</div>
	<div class="w3-gray w3-border w3-card-4" style="width: 150px; height: 300px; margin-top: 300px; position: fixed;">
		<div class="w3-col w3-red w3-hover-orange w3-button" style="margin-top: 36px; height: 50px; line-height: 30px;">마이페이지</div>
		<div class="w3-col w3-green w3-hover-lime w3-button" style="margin-top: 36px; height: 50px; line-height: 30px;">지도</div>
		<div class="w3-col w3-blue w3-hover-aqua w3-button" style="margin-top: 36px; height: 50px; line-height: 30px;">1:1 문의</div>
	</div>
	
	<div class="w3-content mw650">
		<div class="w3-col" style="margin-top: 150px; text-align: center; font-size: 65pt; color: purple; font-weight: bold; font-style: italic;">우아한 도시</div>
		<div class="w3-col w3-card-4 w3-light-gray" style="padding: 20px; margin-top: 50px; boder: 1px solid gray; border-radius: 20px;">
			
			<form method="POST" action="">
			
			<!-- 버스 검책창 -->
			<div class="w3-col" style="padding: 0px; margin: 0px;" id="bus">
				<input type="text" placeholder="버스번호를 입력하세요." id="bsearch" name="search" style="display: inline-block; width: 85%; height: 50px;">
				<span class="w3-button w3-green" style="width: 14%; height: 50px; margin-bottom: 3px;" id="src">검색</span>
			</div>
			<div class="w3-card-2" style="width: 610px; float: left; background-color: white; display: none; margin-top: 50px; position: absolute;" id="blist">
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">첫번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">두번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">세번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">넷번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">다섯번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">여섯번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">일곱번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">여덟번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">아홉번째 버스 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">열번째 버스 리스트</div>
			</div>
			
			<!-- 정류소 검책창 -->
			<div class="w3-col" style="padding: 0px; margin: 0px; display: none;" id="busstop">
				<input type="text" placeholder="정류소를 입력하세요." id="bssearch" name="search" style="display: inline-block; width: 85%; height: 50px;">
				<span class="w3-button w3-yellow" style="width: 14%; height: 50px; margin-bottom: 3px;" id="src">검색</span>
			</div>
			
			<div class="w3-card-2" style="width: 610px; float: left; background-color: white; display: none; margin-top: 50px; position: absolute;" id="bslist">
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">첫번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">두번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">세번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">넷번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">다섯번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">여섯번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">일곱번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">여덟번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">아홉번째 정류소 리스트</div>
				<div class="w3-col w3-button w3-hover-gray" style="text-align: left;">열번째 정류소 리스트</div>
			</div>
		
			</form>
			
			<div class="w3-col w3-margin-top">
				<span class="w3-button w3-green w3-col m6 w3-border-right" id="busbtn">버스</span>
				<span class="w3-button w3-yellow w3-col m6" id="bsbtn">정류소</span>
			</div>
		</div>
	</div>
</body>
</html>

