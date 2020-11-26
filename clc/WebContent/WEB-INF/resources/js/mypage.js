$(document).ready(function(){
	
	$('#delbtn').click(function(){
		
		$('.ckbox').removeClass('w3-hide');
		$('#redelbtn').removeClass('w3-hide');
		$('#deletebtn').removeClass('w3-hide');
		$(this).addClass('w3-hide');
	});
	$('#redelbtn').click(function(){
		$('.ckbox').addClass('w3-hide');
		$('#delbtn').removeClass('w3-hide');
		$('#deletebtn').addClass('w3-hide');
		$(this).addClass('w3-hide');
	});
	$('#srcstation').click(function() {
		// 검색한 내용이 없으면 리턴
		var stationid = $('#stationid').val();
		var stationnm = $('#stationnm').val();
		var x = $('#x').val();
		var y = $('#y').val();
		var mobile = $('#mobile').val();
		var retion = $('#region').val();
		if(!stationid){
			alert('검색할 내용을 입력하세요.');
			return;
		}
		// 정류소 검색 버튼을 누르면 정류소 상세 페이지로 이동
		$('#stationfrm').attr('action', '/clc/search/stationdetail.clc');
		$('#stationfrm').submit();
	});
	// 최종 삭제 버튼
	$('#deletebtn').click(function(){
		
		var check = confirm('삭제하시겠습니까?');
		if(!check){
			return;
		}
		
		$('#frm').attr('action', '/clc/member/bookdelproc.clc');
		$('#frm').submit();
	})

});