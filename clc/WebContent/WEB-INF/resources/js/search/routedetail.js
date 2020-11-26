$(document).ready(function(){
	$('#add').click(function(){
		var valtype = "bus";
		var routeid = $('#routeid').val();
		
		alert(routeid);
		$.ajax({
			url:'/clc/member/bookaddproc.clc',
			type:'post',
			dataType:'json',
			data:{
				addid:routeid,
				type: valtype
			},
			success:function(data){
				if(data.result == 'OK'){
					$('#add').removeClass('w3-pale-red');
					$('#add').addClass('w3-teal');
				} else {
					$('#add').removeClass('w3-teal');
					$('#add').addClass('w3-pale-red');
				}
			},
			error:function(){
				alert('##에러당');
			}
		});
		
	});
});