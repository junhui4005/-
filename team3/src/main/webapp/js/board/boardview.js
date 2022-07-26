var blank_pattern = /^\s+|\s+$/g;
function saveblike(mid){
	// 
	let bno = $("#bno").val();
	
	
	$.ajax({
		url : "/team3/board/saveblike",
		data : {'mid' : mid, 'bno' : bno},
		success : function(re) {
				if (re == 1){
					alert("좋아요 등록 완료")
				}
				else if (re == 2){
					alert("좋아요 취소")
					}
				else if (re == 3){
					alert("오류발생 관리자에게문의")
					}
				// 특정 태그 새로고침 
				
				$("#like_area").load(location.href +" #like_area")
		}
	})
}

function saverelike(mid,rno){
	
	
	$.ajax({
		url : "/team3/board/saverelike",
		data : {'mid' : mid, 'rno' : rno},
		success : function(re) {
				if (re == 1){
					alert("좋아요 등록 완료")
				}
				else if (re == 2){
					alert("좋아요 취소")
					}
				else if (re == 3){
					alert("오류발생 관리자에게문의")
					}
				// 특정 태그 새로고침 
				
				$("#wrap").load(location.href +" #wrap")
				
				
		}
	})
}




// 댓글 등록
function replywrite(bno) {
	let rcontent = $("#rcontent").val();
	var anonymous = $('input:checkbox[id="anonymous"]').is(':checked');
	
	if(rcontent==""|| rcontent.replace( blank_pattern, '' ) == "" ) {
		alert("내용을입력해주세요");
		return
	} else {
		$.ajax({
		url: "/team3/board/replywrite" ,
		data: { "bno":bno , "rcontent" : rcontent ,"anonymous" :anonymous} ,
		success : function( result ){
			if( result == 1 ){
				 alert("댓글작성 되었습니다."); // 성공 메시지 알림 
				 $("#rcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#wrap").load( location.href+" #wrap"); // 특정 태그 새로고침
				 
				
			}
			else{ alert("댓글작성이 실패했습니다."); }
		}
	});
		
	}
	
}

// 대댓글 등록
function rereplywrite(rno,bno) {
	let rcontent = $("#rrcontent").val();
	var anonymous = $('input:checkbox[id="anonymous"]').is(':checked');
	if(rcontent==" " ||rcontent.replace( blank_pattern, '' ) == "") {
		alert("내용을입력해주세요");
		return;
	}
	
	$.ajax({
		url: "/team3/board/rereplywrite" ,
		data: {"rno":rno, "bno":bno , "rrcontent" : rcontent ,"anonymous" :anonymous} ,
		success : function( result ){
			if( result == 1 ){
				 alert("댓글작성 되었습니다."); // 성공 메시지 알림 
				 $("#rcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#wrap").load( location.href+" #wrap"); // 특정 태그 새로고침
				 
				
			}
			else{ alert("댓글작성이 실패했습니다."); }
		}
	});
}


// 댓글 수정창 줄력


function updateview(rno,rcontent,bno){ // 댓글수정창 표시 메소드 
	
	// JS 작성 공간 에서는 HTML 작성 불가능 --> HTML 문자처리 
		$("#"+rno).html(
			'<div class="rwirte_area">'+
				'<textarea  rows="2" cols="30" name="upcontent" id="upcontent"  > '+rcontent+'</textarea>'+
			'<button type="button" id="rwrite" onclick="replyupdate('+rno+','+bno+')">등록</button>'+	
			'</div>'+	
			'<span> <input id="anonymous" type="checkbox" value="익명" name="anonymous"> 익명</span>'
		);	
}

// 대댓글 입력창 출력
function rereplyview( rno,bno ){ // 대댓글 입력창 표시 메소드 
	// ' '  or " "	: 문자처리 	// '문자열' + 변수 + '문자열'

	// JS 작성 공간 에서는 HTML 작성 불가능 --> HTML 문자처리 
		$("#"+rno).html(
			'<div class="rwirte_area">'+
				'<textarea  rows="2" cols="30" name="rrcontent" id="rrcontent"  > </textarea>'+
			'<button type="button" id="rrwrite" onclick="rereplywrite('+rno+','+bno+')">등록</button>'+	
			'</div>'+	
			'<span> <input id="anonymous" type="checkbox" value="익명" name="anonymous"> 익명</span>'
		);	
}

// 대댓글 수정창 출력
function reupdateview(rno,rcontent,bno){ // 댓글수정창 표시 메소드 
	
	// JS 작성 공간 에서는 HTML 작성 불가능 --> HTML 문자처리 
		$("#"+rno).html(
			'<div class="rwirte_area2">'+
				'<textarea  rows="2" cols="30" name="upcontent2" id="upcontent2"  > '+rcontent+'</textarea>'+
			'<button type="button" id="rwrite" onclick="rereplyupdate('+rno+','+bno+')">등록</button>'+	
			'</div>'+	
			'<span> <input style="margin-left:50px" id="anonymous" type="checkbox" value="익명" name="anonymous"> 익명</span>'
		);	
}





function replydelete( rno,bno ){
	
	$.ajax({

		url : "/team3/board/replydelete" , 
		data : { "rno" : rno ,"bno":bno} , 
		success : function( result ){
			if( result == 1 ){
				alert("댓글 삭제 되었습니다.");
				$("#wrap").load( location.href+" #wrap"); // 특정 태그 새로고침
			}
			else{ alert("삭제 실패(관리자에게 문의)"); } 
		}
	});
}

// 댓글수정
function replyupdate(rno ,bno){ // 수정쓰기메소드
	let upcontent= $("#upcontent").val();
	var anonymous = $('input:checkbox[id="anonymous"]').is(':checked');
	
	if(upcontent == "" ||upcontent.replace( blank_pattern, '' ) == "") {
		alert("내용을입력해주세요")	;
		return;
	} else {
		$.ajax({
		url : "/team3/board/replyupdate" , 
		data : { "rno" : rno ,"upcontent":upcontent,"bno":bno ,"anonymous" :anonymous } ,
		success : function( result ){
			if( result ==1 ){
				alert("댓글 수정 되었습니다.");
				 $("#rcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#wrap").load( location.href+" #wrap"); // 특정 태그 새로고침
			}
			else{ alert("수정 실패했습니다."); }
		}
	});
		
	}
	
}

// 대댓글 수정
function rereplyupdate(rno ,bno){ // 수정쓰기메소드
	let upcontent2= $("#upcontent2").val();
	var anonymous = $('input:checkbox[id="anonymous"]').is(':checked');
	
	
	if(upcontent2.replace( blank_pattern, '' ) == "") {
		alert("내용을입력해주세요")	;
		return;
	}
	else {
		
		$.ajax({
		url : "/team3/board/rereplyupdate" , 
		data : { "rno" : rno ,"upcontent2":upcontent2,"bno":bno ,"anonymous" :anonymous } ,
		success : function( result ){
			if( result ==1 ){
				alert("댓글 수정 되었습니다.");
				 $("#rcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#wrap").load( location.href+" #wrap"); // 특정 태그 새로고침
			}
			else{ alert("수정 실패했습니다."); }
		}
	});
		
	}
	
}


