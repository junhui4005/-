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
	<div class="container mainbox">
		<div class="container loginbox" style="width: 400px;">
			<h3 class="text-center my-4 blue">비밀번호 찾기</h3>
			<form >
				<div> 
					<input class="form-control my-2" type="text" id="mid" name="mid" placeholder="아이디">
				</div>
				<div>
					<input class="form-control my-2" type="text" id="memail" name="memail" placeholder="이메일">
				</div>
				<input class="form-control btn my-4 btnlogin" onclick="findpw()" value="비밀번호 찾기">
			</form>
			<div class="text-center my-2">
				<a class="searchlink" href="/team3/member/findid.jsp">아이디 찾기</a>|
				<a class="searchlink" href="/team3/member/login.jsp">로그인하러 가기</a>
			</div>
		</div>
	</div>
	
	
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/member/login.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>