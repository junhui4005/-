<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bookstore css -->
	<link href="/team3/css/bookstore/bookstore.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<h3 class="text-center my-4">내 책 조회</h3>
	<div class="container">
		<div id="booklistbox" class="col-md-10 offset-1">
		</div>
	</div>
	<br><br><br><br><br><br><br>
	<%@include file="../footer.jsp"%>
	<script src="/team3/js/member/mybook.js" type="text/javascript"></script>
</body>
</html>