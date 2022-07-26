<%@page import="dao.MemberDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/team3/css/member/myboard.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">
		<h3 class="text-center my-4">내가 쓴 글</h3>
		<div id="myboardlist" class="col-md-10 offset-1">
		</div>
	</div>
	<script src="/team3/js/member/myboard.js" type="text/javascript"></script>
</body>
</html>