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
	<div class="w3-content mw650 w3-margin-top">
		<div class="w3-col w3-border w3-grey h100 w3-padding w3-margin-top w3-card-4">
			<input type="text" placeholder="내용을 입력하세요" id="search" name="search" class="w3-col m9">
			<span class="w3-button w3-blue w3-col m3 h30">검색</span>
			<div class="w3-col w3-margin-top">
				<span class="w3-button w3-green w3-col m6 w3-border-right">버스</span>
				<span class="w3-button w3-green w3-col m6">정류소</span>
			</div>
		</div>
		<br>
		<div class="w3-grey h300 w3-border w3-card-4 w3-col mt25">
			<div class="w3-col m6 w3-padding">
				<img src="/" class="imgbox2" id="img" name="img">
			</div>

			<div class="w3-col m6 w3-padding w3-center">
				<div class="mt60">
					<span class="w3-button w3-blue h70 w3-margin-bottom w200 txtloc" id="login">login</span>
					<span class="w3-button w3-blue h70 w3-margin-top w200 txtloc" id="join">join</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>