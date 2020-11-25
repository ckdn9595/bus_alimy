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
		$(this).val('');
	});
	var tmp = $('.buslist').html();
	var tmp2 = tmp.substr(0,92);
	var busoldVal = '';
	
	var autocomplete = $('.buslist');
	
	$("#bsearch").keyup(function() {
	
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
	
				var searchList = data.searchList;
	
				$.each(searchList, function(index, item) {
					var tmp = "번호: " +item.name+" | 노선유형: " + item.type+" | 기점 : "+item.stname+" | 종점 : "+item.edname;
					$('<li class="w3-col w3-button w3-left-align" id="'+item.id+'" onclick="busdetail(this)"></li>').text(tmp).insertAfter(autocomplete);
				});
				
			},
	  		error: function(){
	//				alert('### 통신 실패 ###');
			}
	   
			});
		}
	    busoldVal = bus;
   
	
	});
	

	$('#bssearch').focus(function() {
		$('#bslist').css('display', 'block');
		$(this).val('');
	});
	var staoldVal = '';
	
	var autocomplete2 = $('.stalist');
	
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
					
				$.each(searchList, function(index, item) {
					var tmp = item.name+", "+item.x+", "+item.y+", "+item.mobile+", "+item.region;
					$('<li class="w3-col w3-button w3-left-align" id="'+item.id+'" onclick="stationdetail(this)"></li>').text(tmp).insertAfter(autocomplete2);
				});
				
			},
	   		error: function(){
//					alert('### 통신 실패 ###');
			}
	   
		});
	}
    staoldVal = sta;
   
	
	});
	
	// 검색 이동
	$('#srcroute').click(function() {
		$('#routefrm').submit();
	});
	$('#srcstation').click(function() {
		$('#stationfrm').submit();
	});
	
	$('#login').click(function(){
		$(location).attr('href','/clc/member/login.clc');
	});
});
	