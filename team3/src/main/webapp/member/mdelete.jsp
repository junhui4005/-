<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- member css -->
	<link href="/team3/css/member/member.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<%
		String mid = (String)session.getAttribute("login");
		Member member =  MemberDao.getMemberDao().getmemberinfo(mid);
	%>
	<div class="container">
		<div class="deletebox container col-md-6 offset-3">
			<h3 class="menutitle">회원탈퇴</h3>
			<div>
				<h5>정말 탈퇴하시겠습니까?</h5>
				<input class="form-control" type="password" id="mpassword" name="mpassword" placeholder="비밀번호를 입력해주세요.">
			</div>
			<div class="deletebtn row my-4">
				<div class="col-md-6">
					<button onclick="mdelete()" type="submit" class="form-control btn btn-outline-secondary">탈퇴</button>
				</div>
				<div class="col-md-6">
					<a href="/team3/member/memberinfo.jsp"><button class="form-control btn btn-outline-secondary" >취소</button></a>
				</div>
			</div>
		</div>
		
		<input type="hidden" value="<%=member.getMpassword()%>" id="password">
	</div>
	<br><br><br><br><br><br><br>
	<%@include file="../footer.jsp"%>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/member/login.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>