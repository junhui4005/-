<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/team3/css/board/boardwrite.css">

</head>
<body>

<%@include file="../header.jsp"%>
<div class="container content_wrap">
	<div class="board_wrap">
	<h1 id="header">글 작성</h1>
	<form  id ="form_board" action="/team3/board/boardwrite" method="post" enctype="multipart/form-data" >
		<div class="input_wrap">
			<input id="btitle" name="btitle" type="text" placeholder="제목"> 
			<textarea id="bcontent" name="bcontent" style="resize: none;"></textarea> 
			<input id ="bimg" name="bimg" type="file"> 
			<div style="width:30%"><img id="preview" width="100%"></div>
			<div><input id="anonymous" type="radio" value="아이디" name="anonymous" checked="checked">아이디</div>
			<div><input id="anonymous" type="radio" value="익명" name="anonymous">익명</div>
			
			<div class="btn_area">
			<button id="bwrite" type="button" onclick="writecheck()">등록</button>
			<a href="/team3/board/boardlist.jsp"><button id="bwrite" type="button">취소</button></a>
			
			</div>
		</div>
		
	</form>
	
	
	</div>
	
	</div>
	<div class="footer bb">
		<div class="container">
			<div class="row p-5">
				<p class="p1">개인정보처리방침 | 대학정보 | 전화번호안내 | 통합서비스센터</p>
				<div class="col-md-4 offset-2 line12"> 
					<h3> oo대학교 </h3>
					<p>경기도 안산시 ㅇㅇ구 ㅇㅇ로 1234-1</p>
				</div>
				<div class="col-md-5 offset-1"> 
					<h3> 전화문의 </h3>
					<p>
						123-1234-1234 <br>
					</p>
					
				</div>
			</div>
		</div>
	</div>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="../js/board/board.js"></script>

</body>
</html>