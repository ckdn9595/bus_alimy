$(docuemnt).ready(function() {
	
	// 버스 혹은 정류소 추가
	$('#add').click(function() {
		
		$('#frm').attr('action', '/clc/member/mypage.clc');
		$('#frm').submit();
	});
});