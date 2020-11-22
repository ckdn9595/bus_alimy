$(document).ready(function(){
	$('#join').click(function(){
		$(location).attr('href','/clc/member/join.clc');
	});
	$('#login').click(function(){
		$(location).attr('href','/clc/member/login.clc');
	});
})