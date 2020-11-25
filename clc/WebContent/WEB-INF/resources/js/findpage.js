$(document).ready(function(){
	// 아이디 찾기 버튼을 클릭했을 경우
	$('#logbtn').click(function(){
		$(location).attr('href','/clc/member/login.clc');
	});
	$('#fIdbtn').click(function(){
		var smail = $('#mail').val();
		var pat = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var result = pat.test(smail);
		// 이메일을 입력하지 않은 경우
		if(!smail){
			alert('이메일을 입력해주세요.');
			return;
		}
		// 이메일 형식에 맞지 않는 경우
		if(!result){
			alert('이메일 형식에 맞지 않습니다.');
			return;
		}
		// 데이터를 서버에 보내서 응답을 받는다.
		$.ajax({
			url: '/clc/member/findidpageproc.clc',
			type: 'POST',
			dataType: 'json',
			data: {
				mail: smail
			},
			success: function(data){
				if(data.result == 'OK'){
					$('#fIdmsg').html('<span>회원님의 아이디는 <span><b>'+ data.id +'</b></span> 입니다.');
					$('#fIdmsg').removeClass('w3-text-red');
					$('#fIdmsg').stop().slideDown(200);
				} else {
					$('#fIdmsg').html('<b>회원목록에 존재하지 않는 이메일입니다.</b>');
					$('#fIdmsg').addClass('w3-text-red');
					$('#fIdmsg').stop().slideDown(200);
				}
			},
			error: function(){
				alert('### 통신에 실패했습니다. ###');
			}
		});
	});
	
	// 모달 창 닫을 때
	$('#mclose').click(function(){
		$('#pwModal').css('display', 'none');
	});
	
	$('#fPwbtn').click(function(){
		var sid = $('#id').val();
		var sanswer = $('#answer').val();
		var sqno = $('#quest option:selected').val();
		
		if(!sid){
			alert('아이디를 입력해주세요.');
			$('#id').focus();
			return;
		}
		if(!sqno){
			alert('질문을 선택 해주세요.');
			return;
		}
		if(!sanswer){
			alert('답변을 입력해주세요.');
			$('#answer').focus();
			return;
		}
		
		$.ajax({
			url: '/clc/member/findpwpageproc.clc',
			type: 'POST',
			dataType: 'json',
			data: {
				id: sid,
				answer: sanswer,
				qno: sqno
			},
			success:function(data){
				if(data.result == 'OK'){
					$('#pw').val('');
					$('#pwconf').val('');
					$('#pw').css('background-color', '');
					$('#pwconf').css('background-color', '');
					$('#pwModal').css('display', 'block');
				} else {
					alert('질문과 정답이 일치하지 않습니다.');
				}
			},
			error:function(){
				alert('### 통신에 실패했습니다. ###');
			}
		});
	});
	
	
	$('#pw').keyup(function(){
		var spw = $('#pw').val();
		var pwPat =  /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/; //비밀번호 8자리 이상, 숫자 포함 ,영대 문자 포함, 영소 문자 포함, 특수문자 포함
		var result = pwPat.test(spw);
		
		if(!result){
			$('#pw').css('background-color', 'MistyRose');
		} else {
			$('#pw').css('background-color', 'HoneyDew');
		}
	});
	
	$('#pwconf').keyup(function(){
		var spwconf = $('#pwconf').val();
		var spw = $('#pw').val();
		
		if(spwconf != spw){
			$('#pwconf').css('background-color', 'MistyRose');
		} else {
			$('#pwconf').css('background-color', 'HoneyDew');
		}
	});
	
	$('#pwEditbtn').click(function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		var spwconf = $('#pwconf').val();
		var pwPat =  /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/;
		
		var pattest = pwPat.test(spw);
		
		// 내용을 입력하지 않은 경우
		if(!spw){
			$('#pw').focus();
			return;
		}
		if(!spwconf){
			$('#pwconf').focus();
			return;
		}
		// 형식화 검사가 false 인 경우
		if(!pattest){
			alert('비밀번호는 8자리 이상 20자리 이하, 숫자 포함 ,영대 문자 포함, 영소 문자 포함, 특수문자 포함 이어야 합니다.');
			return;
		}
		// 비밀번호 확인이 일치하지 않는 경우
		if(spw != spwconf){
			alert('비밀번호 확인이 일치하지 않습니다.');
			return;
		}
		
		// 비밀번호 변경 요청
		$.ajax({
			url: '/clc/member/editpwproc.clc',
			type: 'POST',
			dataType: 'json',
			data: {
				id: sid,
				pw: spw
			},
			success:function(data){
				if(data.result == 'OK'){
					alert('비밀번호가 변경되었습니다. 로그인해주시길 바랍니다.');
					$('#pwModal').css('display', 'none');
					$(location).attr('href', '/clc/member/login.clc');
				} else {
					alert('비밀번호 변경에 실패했습니다. 다시 시도해주시길 바랍니다.');
					$('#pwModal').css('display', 'none');
					$(location).attr('href', '/clc/member/login.clc');
				}
			},
			error:function(){
				alert('### 통신에 실패했습니다. ###');
			}
		});
	});
});