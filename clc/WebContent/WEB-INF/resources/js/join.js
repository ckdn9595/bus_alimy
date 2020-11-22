$(document).ready(function(){
	$('#name').focusout(function(){
		var sname = $(this).val();
		var pattern = /^[가-힣]{2,10}$/;
		var result = pattern.test(sname);
		if(result){
				$('#namemsg').html('사용가능하다');
				$('#namemsg').removeClass('w3-text-red');
				$('#namemsg').addClass('w3-text-blue');
				$('#namemsg').stop().slideDown(500);
		}else{
				$('#namemsg').html('사용불가능하다');
				$('#namemsg').removeClass('w3-text-blue');
				$('#namemsg').addClass('w3-text-red');
				$('#namemsg').stop().slideDown(500);
			
		};
	});
	
	$('#id').focusout(function(){
		var sid = $(this).val();
		if(!sid){
			return;	
		};
		$.ajax({
			url:'/clc/member/idCheck.clc',
			type:'post',
			dataType:'json',
			data:{
				id:sid
			},
			success:function(data){
				if(data.result =='OK'){
					$('#idmsg').html('사용가능하다');
					$('#idmsg').removeClass('w3-text-red');
					$('#idmsg').addClass('w3-text-blue');
					$('#idmsg').stop().slideDown(500);
				}else{
					$('#idmsg').html('사용불가능하다');
					$('#idmsg').removeClass('w3-text-blue');
					$('#idmsg').addClass('w3-text-red');
					$('#idmsg').stop().slideDown(500);
				}
			},
			error:function(){
				alert('##에러당');
			}
		});
	});
	
	$('#submit').click(function(){
		$('#frm').attr('method','POST');
		$('#frm').attr('action','/clc/member/joinproc.clc');
		$('#frm').submit();
	});
});