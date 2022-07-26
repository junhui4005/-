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
		<div class="row mt-3 infobox">
			<div class="col-md-4">
				<div class="memberbox">
					<h4>내프로필</h4>
					<div class="mdetailbox">
						<p class="mname"><%=member.getMname() %></p>
						<div class="">
							<p><%=member.getMcode() %></p>
							<p><%=member.getMid() %></p>
							<p><%=member.getMphone() %></p>
							<p><%=member.getMemail() %></p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<h4 class="mboxtitle1">나의 활동</h4>
				<div class="accountbox">
					<div>
						<h5><a href="/team3/member/myboard.jsp">내가 쓴 글</a></h5>
					</div>
					<div>
						<h5><a href="/team3/member/mybook.jsp">내 책 조회</a></h5>
					</div>
					<div>
						<h5><a href="/team3/message/getmessage.jsp">쪽지함</a></h5>
					</div>
				</div>
				<h4 class="mboxtitle2">계정</h4>
				<div class="accountbox">
					<div>
						<h5><a href="/team3/member/infoupdate.jsp">정보 수정</a></h5>
					</div>
					<div>
						<h5><a href="logout">로그아웃</a></h5>
					</div>
					<div>
						<h5><a href="/team3/member/pwupdate.jsp">비밀번호 변경</a></h5>
					</div>
					<div>
						<h5><a href="/team3/member/mdelete.jsp">회원탈퇴</a></h5>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br>
	<%@include file="../footer.jsp"%>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>