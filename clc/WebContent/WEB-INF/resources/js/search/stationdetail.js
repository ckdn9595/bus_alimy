$(document).ready(function(){
	// 즐겨찾기 추가 버튼을 누를 경우
	$('.stBkAdd').click(function(){
		// 해당 정류소 아이디 값 가져오고
		var station_id = $('.stBkAdd').attr('id');
		var valtype = "sta";
		
		
		$.ajax({
			url:'/clc/member/bookaddproc.clc',
			type:'post',
			dataType:'json',
			data:{
				addid:station_id,
				type: valtype
			},
			success:function(data){
				if(data.result == 'OK'){
					$('.stBkAdd').removeClass('w3-blue');
					$('.stBkAdd').addClass('w3-teal');
				} else {
					
				}
			},
			error:function(){
				alert('##에러당');
			}
		});
	});
});