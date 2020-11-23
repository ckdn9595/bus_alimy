$(document).ready(function(){
	$('#bsbtn').click(function(){
		$('#bus').css('display', 'none');
		$('#busstop').css('display', '');
		$('#bsearch').val('');
		$('#blist').css('display', 'none');
	});
	$('#busbtn').click(function(){
		$('#bus').css('display', '');
		$('#busstop').css('display', 'none');
		$('#bssearch').val('');
		$('#bslist').css('display', 'none');
	});
	
	$('#bsearch').focus(function() {
		$('#blist').css('display', '');
	});
	
	$('#bsearch').focusout(function() {
		$('#blist').css('display', 'none');
	});

	$('#bssearch').focus(function() {
		$('#bslist').css('display', '');
	});
	
	$('#bssearch').focusout(function() {
		$('#bslist').css('display', 'none');
	});
	
	$('#login').click(function(){
		$(location).attr('href','/clc/member/login.clc');
	});
});