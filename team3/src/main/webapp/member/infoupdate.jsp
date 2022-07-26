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
		<h3 class="menutitle">회원정보 수정</h3>
		<div>
			<table class="table">
				<tr>
					<td>이름</td><td colspan="2"><%=member.getMname()%></td>
				</tr>
				<tr>
					<td>학번</td><td colspan="2"><%=member.getMcode()%></td>
				</tr>
				<tr>
					<td>아이디</td><td colspan="2"><%=member.getMid()%></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input value="<%=member.getMemail()%>" class="form-control mb-2" type="text" id="memail" name="memail" placeholder="이메일을 입력해주세요."></td>
					<td id="emailcheck" style="color: #999999;" >이메일 형식을 지켜주세요</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input value="<%=member.getMphone()%>" class="form-control mb-2" type="text" id="mphone" name="mphone" placeholder="전화번호 11자리를 입력해주세요.(- 제외)"></td>
					<td id="phonecheck" style="color: #999999;">하이픈(-)을 제외한 숫자만 입력해주세요</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input class="form-control mb-2" type="password" id="mpassword" name="mpassword" placeholder="비밀번호를 입력해주세요."></td>
					<td style="color: #999999;">정보를 수정 하시려면 기존 비밀번호를 입력하시기 바랍니다.</td>
				</tr>
			</table>
			<div class="row">
				<div class="col-md-2 offset-4">
					<button class="form-control btn btn-dark" onclick="update()" type="submit">수정</button>
				</div>
				<div  class="col-md-2">
					<a href="/team3/member/memberinfo.jsp"><button class="form-control btn btn-outline-secondary">취소</button></a>
				</div>
			</div>
			<input type="hidden" value="<%=member.getMemail()%>" id="email">
			<input type="hidden" value="<%=member.getMphone()%>" id="phone">
			<input type="hidden" value="<%=member.getMpassword()%>" id="password">
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