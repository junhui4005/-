<%@page import="dao.MessageDao"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link href="/team3/css/header.css" rel="stylesheet" >
</head>
<body>
	<%String loginid = (String)session.getAttribute("login");
	int mno1 = MemberDao.getMemberDao().getmno(loginid);
	%>
	<div class="container">
		<div class="row header" id="header">
			<div class="col-md-3 d-flex align-self-center">
				<a href="/team3/main.jsp" class="logo">캠퍼스타임</a>
			</div>
			<div class="navbar navbar-expand-md col-md-6 d-flex justify-content-around">
				<ul class="navbar-nav">
					<li class="nav-item"><a href="/team3/timetable/timetable.jsp">시간표</a></li>
					<li class="nav-item"><a href="/team3/board/boardlist.jsp">자유게시판</a></li>
					<li class="nav-item"><a href="/team3/review/reviewlist.jsp?keyword=">강의평</a></li>
					<li class="nav-item"><a href="/team3/bookstore/booklist.jsp">책방</a></li>
					<li class="nav-item"><a href="/team3/calculator/calculator.jsp">학점계산기</a></li>
				</ul>
			</div>
			<div class="col-md-3 navbar navbar-expand-md d-flex justify-content-end">
				<ul class="navbar-nav">
					<li class="nav-item"><a href="/team3/member/memberinfo.jsp">내정보</a></li>
					<li class="nav-item">
					<%
						int mcount= MessageDao.getMessageDao().getcount(mno1);
						%>
						<a href="/team3/message/getmessage.jsp">쪽지</a>
						
						<a href="/team3/message/getmessage.jsp"><%=mcount %></a>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="https://kit.fontawesome.com/d77abffe02.js" crossorigin="anonymous"></script>
</body>
</html>