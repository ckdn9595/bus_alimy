$(document).ready(function(){
	// 즐겨찾기 추가 버튼을 누를 경우
	$('.stBkAdd').click(function(){
		// 해당 정류소 아이디 값 가져오고
		var station_id = $('.stBkAdd').attr('id');
		
		// 폼 태그에 실어 전송
		$('#stationId').val(station_id);
		$('#frm').attr('action', '/clc/search/bookaddproc.clc');
		$('#frm').submit();
	});
});