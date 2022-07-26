	
	//입력상자 유효성 확인 체크 배열	
	let pass = [false, false, false, false, false, false, false];
	
$( function(){
		
	//이름체크
	$("#mname").keyup(function(){
		let mname = $("#mname").val(); //해당 id 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/;	//한글만 2~10글자
		
		if(namej.test(mname)){
			$("#namecheck").html("사용가능한 이름입니다.");
			pass[0] = true;
		}else{
			$("#namecheck").html("한글 2~10글자로 입력해주세요");
			pass[0] = false;
		}
	}); //이름 체크 end
	
	//학번체크
	$("#mcode").keyup(function(){
		
		let mcode = $("#mcode").val(); 
		let codej = /^20+[0-9]{8}$/;	//숫자로 10자 
		if(codej.test(mcode)){
			$.ajax({
	            url : "/team3/member/codecheck" ,
	            data : { "mcode" : mcode  } ,
	            success : function( result ){
	               if( result == 1 ){ 
	                  $("#codecheck").html("이미 가입된 학번입니다.");
	                  pass[1] = false;
	               }else{ 
	                 $("#codecheck").html("사용가능한 학번입니다.");
	                  pass[1] = true;
	          	 	}
            	}
         	});
		}else{
			$("#codecheck").html("올바른 형식이 아닙니다.");
			pass[1] = false;
		}
	}); //학번 체크 end
	
	//전화번호 체크	
	$("#mphone").keyup(function(){
		
		let mphone = $("#mphone").val(); 
		let phonej = /^010([0-9]{8})$/;	//숫자만 가능 010 + 숫자8자리
		
		if(phonej.test(mphone)){
			$.ajax({
	            url : "/team3/member/phonecheck" ,
	            data : { "mphone" : mphone } ,
	            success : function( result ){
	               if( result == 1 ){ 
	                  $("#phonecheck").html("사용중인 전화번호입니다.");
	                  pass[2] = false;
	               }else{ 
	                 $("#phonecheck").html("사용가능한 전화번호입니다.");
	                  pass[2] = true;
	          	 	}
            	}
         	});
		}else{
			$("#phonecheck").html("다시 확인해주세요");
			pass[2] = false;
		}
	});	//전화번호 체크 end
	
	//이메일 체크	
	$("#memail").keyup(function(){
		let memail = $("#memail").val();
		let emailj = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
		
		if (emailj.test(memail)){
			$.ajax({
	            url : "/team3/member/emailcheck" ,
	            data : { "memail" : memail  } ,
	            success : function( result ){
	               if( result == 1 ){ 
	                  $("#emailcheck").html("사용중인 이메일입니다.");
	                  pass[3] = false;
	               }else{ 
	                 $("#emailcheck").html("사용가능한 이메일입니다.");
	                  pass[3] = true;
	          	 	}
            	}
         	});
		}else{
			$("#emailcheck").html("올바르지 않은 형식입니다.");
			pass[3] = false;
		}
		
	});
	
	//아이디 체크
	$("#mid").keyup(function(){ 
		
		let mid = $("#mid").val(); 
		let idj = /^[a-zA-Z0-9]{5,15}$/; //영문 숫자 5~15글자
		
		if(idj.test(mid)){ 
			
			$.ajax({
	            url : "/team3/member/idcheck" ,
	            data : { "mid" : mid  } ,
	            success : function( result ){
	               if( result == 1 ){ 
	                  $("#idcheck").html("사용중인 아이디입니다.");
	                  pass[4] = false;
	               }else{ 
	                 $("#idcheck").html("사용가능한 아이디입니다.");
	                  pass[4] = true;
	          	 	}
            	}
         	});
         	
		}else{
			$("#idcheck").html("영문 , 숫자 포함 5~15길이로 입력해주세요.");
			pass[4] = false;
		}
	}); //아이디 체크 end
	
	//비밀번호 체크
	$("#mpassword").keyup(function(){
		
		let mpassword = $("#mpassword").val(); 
		let mpasswordcheck = $("#mpasswordcheck").val(); 
		
		let passwordj = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,15}$/;
		
		if(passwordj.test(mpassword)){
			$("#passwordcheck1").html("사용가능한 비밀번호 입니다.");
				pass[5] = true; 
		}else{
			$("#passwordcheck1").html("영문, 숫자, 특수문자 포함 6~15글자 입력해주세요.");
			pass[5] = false;
		}
	}); //비밀번호 확인 end
	//비밀번호 일치 확인
	
	$("#mpasswordcheck").keyup(function(){
		let mpassword = $("#mpassword").val(); 
		let mpasswordcheck = $("#mpasswordcheck").val(); 
		
		if( mpassword != mpasswordcheck ){
				$("#passwordcheck2").html("비밀번호가 일치하지 않습니다.");
				pass[6] = false;
			}else{
				$("#passwordcheck2").html("비밀번호가 일치합니다.");
				pass[6] = true;
			}
		}); //비밀번호 일치 확인 end
	});
 
	 //폼전송 메소드
	 function signup(){
		let check = true;
		for(let i = 0; i <pass.length; i++){
			if(pass[i] == false) {
				check = false;
			}
		}
		if(check){
			$("#signupform").submit();
		}else {
			alert("정보를 모두 입력해주세요.");
		}
	}

//////////////////////////////////////// 회원 정보 수정
function update(){
	let memail = $("#memail").val();
	let mphone = $("#mphone").val();
	
	//안 바꿔도 통과
	if($("#memail").val() == $("#email").val()){pass[3] = true;}
	if($("#mphone").val() == $("#phone").val()){pass[2] = true;}
	
	//비밀번호 확인
	if ($("#mpassword").val()==$("#password").val()){pass[6] = true;}

	if(pass[2] == true && pass[3] == true && pass[6] == true){
		$.ajax({
			url:"/team3/member/update",
			type: 'POST',   
			data : {"memail" : memail, "mphone" : mphone},
			success : function(result){
				if(result == 1){
					alert("수정 완료");
					location.href = "/team3/member/memberinfo.jsp";
				}else{
					alert("일치하는 회원이 없습니다.");
				}
			}
		});
	}else if(pass[2] == true && pass[3] == true && pass[6] == false){
		alert("비밀번호를 다시 확인해주세요.");
	}else{
		alert("정보를 다시 확인해주세요.");
	}
		
}
//////////////////////////////////////// 비밀번호 수정
function updatepw(){
	let oldpassword = $("#oldpassword").val(); 
	let mpassword = $("#mpassword").val(); 
	let mpasswordcheck = $("#mpasswordcheck").val(); 
	if(pass[5]==true){
		$.ajax({
			url:"/team3/member/updatepw",
			type: 'POST',   
			data : {
				"mpassword" : mpassword,
				"oldpassword" : oldpassword,
				"mpasswordcheck" : mpasswordcheck,
					},
			success : function(result){
				if(result == 1){
					alert("수정 완료");
					location.href = "/team3/member/memberinfo.jsp";
				}else if(result == 2){
					alert("비밀번호 변경 오류");
				}else if(result == 3){
					alert("새로운 비밀번호를 다시 확인해 주세요.");
				}else{
					alert("기존 비밀번호가 일치하지 않습니다.");
				}
			}
		});
	}else {
		alert("사용할 수 없는 비밀번호 입니다.");
	}
		
}
