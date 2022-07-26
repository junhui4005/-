<%@page import="dto.Textbook"%>
<%@page import="dao.BookstoreDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bookstore css -->
	<link href="/team3/css/bookstore/bookstore.css" rel="stylesheet">
	<script src="https://kit.fontawesome.com/d77abffe02.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
		<h3 class="text-center my-4">책방</h3>
		<!-- --------------------------------검색처리------------------------------------------------- -->
	<%
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		
		if (keyword != null){
			session.setAttribute("keyword", keyword);
		}else {	
			keyword = (String)session.getAttribute("keyword");
		}
	%>
		<div class="booklist-mainbox">
			<div class="row my-3 col-md-10 offset-1">
				<div class="col-md-10">
					<input id="keyword" name="keyword" class="form-control" type="text" placeholder="구매할 책을 검색하세요" onKeypress="javascript:if(event.keyCode==13) {search()}">
				</div>
				<div class="col-md-2">
					<button class="form-control" type="button" onclick="search()">검색</button>
				</div>
			</div>
			<div class="scrollbox">
				<div class="row col-md-10 offset-1">
					<span class="col-md-6">최근 올라온 책</span>
					<div class="col-md-6 d-flex justify-content-end" >
						<a href="/team3/bookstore/bookadd.jsp"><button class="sellbtn">판매하기</button></a>
					</div>
				</div>
				<div id="booklistbox" class="col-md-10 offset-1">
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br>
	<%@include file="../footer.jsp" %>
	<div id="top">
		<a href="#header"><i class="fa-solid fa-circle-arrow-up"></i></a>
	</div>
	<script src="/team3/js/bookstore/booklist.js" type="text/javascript"></script>
</body>
</html>