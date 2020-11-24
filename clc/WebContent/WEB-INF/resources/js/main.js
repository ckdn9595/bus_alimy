$(document).ready(function(){
	$('#bsbtn').click(function(){
		$('#bus').addClass('w3-hide');
		$('#busstop').removeClass('w3-hide');
		$('#blist').css('display', 'none');
	});
	$('#busbtn').click(function(){
		$('#bus').removeClass('w3-hide');
		$('#busstop').addClass('w3-hide');
		$('#bslist').css('display', 'none');
	});
	
	$("#bsearch").focus(function(){
		$('#blist').css('display', 'block');
	});
	var tmp = $('.buslist').html();
	var tmp2 = tmp.substr(0,93);
	$("#bsearch").on("change keyup paste", function() {
	$('.buslist').html('');
	var oldVal = '';
    var bus = $(this).val();
    if(bus == oldVal) {
        return;
    }
 	else{
		 $.ajax({
   		url: '/clc/search/relationlist.clc',
   		type: 'POST',
   		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
   		data: {
   			name: bus
   		},
   		success:function(data){
//				var obj = JSON.parse(data);
				var searchList = data.searchList;
//				var Count = obj.Count;
				var tmp3 = "";
				for(var i = 0 ; i < searchList.length; i++){
					tmp3 += tmp2 + searchList[i].name + '|' + searchList[i].type + '</div>';
				}
				$('.buslist').append(tmp3);
			},
   		error: function(){
				alert('### 통신 실패 ###');
		}
   
	});
	}
    oldVal = bus;
   
	
	});
	
	$('#bsearch').focusout(function() {
		$('#blist').css('display', 'none');
	});

	$('#bssearch').focus(function() {
		$('#bslist').css('display', 'block');
	});
	
	$('#bssearch').focusout(function() {
		$('#bslist').css('display', 'none');
	});
	
	$('#login').click(function(){
		$(location).attr('href','/clc/member/login.clc');
	});
});