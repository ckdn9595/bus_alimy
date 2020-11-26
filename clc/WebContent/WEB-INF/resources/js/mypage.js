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