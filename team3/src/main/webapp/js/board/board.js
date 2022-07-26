function writecheck() {
	
	let title = $("#btitle").val()
	let content = $("#bcontent").val()
	
	if(title=="" ||content==""){
		alert("제목과 내용을 입력해주세요");
		return false;
	} else {
		$("#form_board").submit();
	}
}

$("#bimg").change( function( e ) { 
	/* 클라이언트가 업로드시 업로드파일의 경로 알기 */
	let reader = new FileReader();	/* 파일 읽어오는 클래스 */
	reader.readAsDataURL( e.target.files[0] ); /* readAsDataURL( 파일 ); 해당 파일 경로 찾기 */
	reader.onload = function( e ){	/* 찾은 파일의 경로 실행 -> 데이터 읽어오기 */
		$("#preview").attr( "src" , e.target.result );
	}
});

function filedelete( bno ){
	
	// HTML에서 JS 로 변수 이동[통신]
		// 1. 메소드 인수로 이동 
		// 2. 태그의 value 혹은 html 이동  [ $("#bno").val();]
	alert("파일만삭제");
	// 비동기통신 = 페이지 전환이 없는 상태 DB통신 
	// JQUERY라이브러리의 AJAX 사용 
	$.ajax({
		url : "/team3/board/filedelete", /*서블릿통신 */ 
		data : { "bno" : bno }, /* 통신 데이터 : { 변수명 : 값 , 변수명2 : 값  } */
		success : function( result ){
			if( result == "1" ){ 
				alert("첨부파일삭제성공 ");
				location.reload(); // 현재 페이지 새로고침
			}
			else { alert("첨부파일삭제실패[관리자에게문의]")}
		}
		
	});
}

