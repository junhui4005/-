<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/team3/css/board/boardlist.css">
</head>
<body>
<%
	ArrayList<Board> boardlist
	= BoardDao.getBoardDao().getboardlist();
String mid = (String)session.getAttribute("login");
String best = "best";

%>



<!-- ---------------------- 테이블 구역 -------------------------- -->

<%@include file="../header.jsp"%>

	<div class="container content_wrap">

	
		<div class="board_category">
		<div><button onclick="getboardlist()">전체글</button></div>
		<div><button onclick="boardbest()">인기글</button></div>
		<div><a href="boardwirte.jsp"><button>글쓰기</button></a></div>
		
		
	</div>
	
		<div class="search_area">
		
				<div  class="search_area"> <!-- 키 선택 -->
					<select class="form_select" id="key">
						<option value="btitle">제목</option>
						<option value="bcontent">내용</option>
						<option value="bnickname">작성자</option>
					</select>
					<input type="text" class="serach_input" id="keyword"> <!-- 키워드입력창 -->
					<input type="button" class="search_button" value="검색" onclick="getsearchlist()">
				</div>
			</div>
		
	
	
		<!-- 인기글 전체글 선택 -->
	
	
		
		
		
	
			
			
		<div id="listbox"  >
		
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
<script type="text/javascript" src="/team3/js/board/boardlist.js"></script>


</body>
</html>