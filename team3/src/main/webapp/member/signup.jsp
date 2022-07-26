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
	<div class="container">
		<h3 class="text-center mt-4 blue">회원가입</h3>
		<div class="container col-md-6 offset-3">
			<form class="signupform" id="signupform" action="/team3/member/signup" method="post">
				
				<div>
					<span>이름</span>
					<input class="form-control mb-2" type="text" id="mname" name="mname" placeholder="이름을 입력해주세요.">
					<div id="namecheck" class="check">한글로 입력해주세요</div>
				</div>
				<div>
					<span>학번</span>
					<input class="form-control mb-2" type="text" id="mcode" name="mcode" placeholder="학번을 입력해주세요">
					<div id="codecheck" class="check">입학년도 4자리 + 학과번호 3자리+ 학생번호 3자리 숫자</div>
				</div>
				<div>
					<span>전화번호</span>
					<input class="form-control mb-2" type="text" id="mphone" name="mphone" placeholder="전화번호 11자리를 입력해주세요.(- 제외)">
					<div id="phonecheck" class="check"> 하이픈(-)을 제외한 숫자만 입력해주세요</div>
				</div>
				<div >
					<span>이메일</span>
					<input class="form-control mb-2" type="text" id="memail" name="memail" placeholder="이메일을 입력해주세요.">
					<div id="emailcheck" class="check">이메일 형식을 지켜주세요</div>
					<div>
						<span>아이디</span>
						<input class="form-control mb-2" type="text" id="mid" name="mid" placeholder="아이디를 입력해주세요.">
						<div id="idcheck" class="check">영어, 숫자로 5~15자리 입력가능합니다</div>
					</div>
				</div>
				<div>
					<span>비밀번호</span>
					<input class="form-control mb-2" type="password" id="mpassword" name="mpassword" placeholder="비밀번호를 입력해주세요.">
					<div id="passwordcheck1" class="check">영문, 숫자, 특수문자 포함 6~15글자 입력해주세요.</div>
				</div>
				<div>
					<span>비밀번호 확인</span>
					<input class="form-control mb-2" type="password" id="mpasswordcheck" placeholder="비밀번호를 입력해주세요.">
					<div id="passwordcheck2" class="check">비밀번호를 다시 입력해주세요.</div>
				</div>
				<div class="row my-4">
					<div class="col-md-4">
						<a href="/team3/member/login.jsp"><button class="form-control btn btn-outline-secondary" type="button">로그인하기</button></a>
					</div>
					<div class="col-md-8">
						<button class="form-control btnlogin" onclick="signup()" type="button">가입하기</button>
					</div>
				</div>
			</form>
		</div>
		<br><br><br><br><br><br><br>
	<%@include file="../footer.jsp"%>
	</div>
	<!-- jquery cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/member/signup.js" type="text/javascript"></script>
	<!-- 부트스트랩 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>