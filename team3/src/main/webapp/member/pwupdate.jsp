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
	<%
		String mid = (String)session.getAttribute("login");
		Member member =  MemberDao.getMemberDao().getmemberinfo(mid);
	%>
	<%@include file="../header.jsp" %>
	<div class="container">
		<div class="container col-md-6 offset-3">
			<h3 class="menutitle">비밀번호 변경</h3>
			<div class="my-4">
				<h5>현재 비밀번호</h5>
				<input class="form-control" type="password" id="oldpassword" name="oldpassword" placeholder="현재 비밀번호를 입력해주세요.">
			</div>
			<div>
				<h5>새로운 비밀번호</h5>
				<input class="form-control" type="password" id="mpassword" name="mpassword" placeholder="비밀번호를 입력해주세요.">
				<span id="passwordcheck1" class="check">영문, 숫자, 특수문자 포함 6~15글자 입력해주세요.</span>
				<h5>새 비밀번호 확인</h5>
				<input class="form-control" type="password" id="mpasswordcheck" placeholder="비밀번호를 입력해주세요.">
			</div>
			<div class="row my-4">
				<div class="col-md-4">
					<a href="/team3/member/memberinfo.jsp"><button class="form-control btn btn-outline-secondary" >취소</button></a>
				</div>
				<div class="col-md-8">
					<button onclick="updatepw()" type="submit" class="form-control btn btn-dark ">수정</button>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br>
	<%@include file="../footer.jsp"%>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/member/signup.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>