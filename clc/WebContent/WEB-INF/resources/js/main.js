$(document).ready(function(){
	$('#bsbtn').click(function(){
		$('#bus').addClass('w3-hide');
		$('#busstop').removeClass('w3-hide');
		$('#blist').css('display', 'none');
		$("#bsearch").val('');
	});
	$('#busbtn').click(function(){
		$('#bus').removeClass('w3-hide');
		$('#busstop').addClass('w3-hide');
		$('#bslist').css('display', 'none');
		$("#bssearch").val('');
	});
	
	$("#bsearch").focus(function(){
		$('#blist').css('display', 'block');
	});
	var tmp = $('.buslist').html();
	var tmp2 = tmp.substr(0,92);
	var busoldVal = '';
	$("#bsearch").on("change keyup paste", function() {
	$('.buslist').html('');
    var bus = $(this).val();
    if(bus == busoldVal || bus == '') {
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
					tmp3 += tmp2 + ' id='+ searchList[i].id+ '>' +searchList[i].name + ' | ' + searchList[i].type +
					' | ' + ' 출발 : ' +searchList[i].stname +' | ' +' 종료 : ' +searchList[i].edname +'</div>';
				}
				$('.buslist').append(tmp3);
			},
   		error: function(){
//				alert('### 통신 실패 ###');
		}
   
	});
	}
    busoldVal = bus;
   
	
	});
	
	$('#bsearch').focusout(function() {
		$('#blist').css('display', 'none');
	});

	$('#bssearch').focus(function() {
		$('#bslist').css('display', 'block');
	});
	var staoldVal = '';
	$("#bssearch").on("change keyup paste", function() {
		$('.stalist').html('');
		
	    var sta = $(this).val();
	    if(sta == staoldVal || sta == '') {
	        return;
	    }
	 	else{
			 $.ajax({
	   		url: '/clc/search/starelationlist.clc',
	   		type: 'POST',
	   		dataType: 'json',
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	   		data: {
	   			name: sta
	   		},
	   		success:function(data){
					var searchList = data.searchList;
					var tmp3 = "";
					for(var i = 0 ; i < searchList.length; i++){
						tmp3 += tmp2 + ' id='+ searchList[i].id+ '>' +searchList[i].name +'</div>';
					}
					$('.stalist').append(tmp3);
				},
	   		error: function(){
//					alert('### 통신 실패 ###');
			}
	   
		});
	}
    staoldVal = sta;
   
	
	});
	
	$('#bssearch').focusout(function() {
		$('#bslist').css('display', 'none');
	});
	
	$('#login').click(function(){
		$(location).attr('href','/clc/member/login.clc');
	});
});