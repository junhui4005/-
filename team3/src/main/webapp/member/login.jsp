<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- member css -->
	<script src="https://kit.fontawesome.com/d77abffe02.js" crossorigin="anonymous"></script>
	<link href="/team3/css/member/member.css" rel="stylesheet">
</head>

<body>

	<div class="container mainbox">
		<div class="loginbox">
			<span><i class="fas fa-school 아이콘"></i><span class="설명">나의 </span><span class="blue">학업관리<span class="설명">를 한번에!</span></span></span>
			<form action="/team3/member/login" method="post">
				<div> 
					<input class="form-control my-2" type="text" id="mid" name="mid" placeholder="아이디">
				</div>
				<div>
					<input class="form-control my-2" type="password" id="mpassword" name="mpassword" placeholder="비밀번호">
				</div>
				<input class="form-control my-4 btnlogin" type="submit" value="로그인하기">
			</form>
			<div class="text-center my-2">
				<a class="searchlink" href="/team3/member/findid.jsp">아이디찾기</a>|
				<a class="searchlink" href="/team3/member/findpw.jsp">비밀번호찾기</a>|
				<a class="searchlink" href="/team3/member/signup.jsp">회원가입</a>
			</div>
		</div>
	</div>
	
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>