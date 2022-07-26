<%@page import="dao.ReviewDao"%>
<%@page import="dao.LectureDao"%>
<%@page import="dto.Lecture"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link href="css/reviewwrite.css" rel="stylesheet">
</head>
<body>
	
	<!-- 검색기능 -->
	<%
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		if( keyword !=null){
			session.setAttribute("keyword", keyword);
		}else{
			keyword = (String)session.getAttribute("keyword");
		}
		
		%>
	
	<%
		ArrayList<Lecture> lecturelist = ReviewDao.getreviewDao().getlecturelist(keyword);
	
		String 이수구분 = "전공";
	%>
	
	<%@include file="../header.jsp"%>
	<div class="container">
		<h3 class="text" style="margin-top: 40px">강의평등록</h3>
		<div class="row">
			<div class="col-md-4">
				<div>
					<form action="reviewwrite.jsp">
					<div class="searchbox">
						<input class="search" type="text" name="keyword" placeholder="강의명을 입력해주세요">
						<input class="searchbtn" type="submit" value="검색">
					</div>
					</form>
				</div><!-- 강의검색 -->
				<div class="lecturetable" style="overflow-y:scroll; height: 500px; margin: 0 auto;">
					<div id="up" class="list-group">
						<% for (int i=0; i<lecturelist.size();i++){
						int ldivision = lecturelist.get(i).getLdivision();
						if(ldivision==0){
							이수구분="전공";
						}else{이수구분="교양";}
						%>
						<button type="button" class="list_1" onclick="lecturelist(<%=lecturelist.get(i).getLno() %>)">
							<span><%=lecturelist.get(i).getLname() %></span><br>
							<span class="교수명"><%=lecturelist.get(i).getLprofessor() %> 교수님</span><br>
							<span class="이수구분"><%=이수구분 %>:<%=lecturelist.get(i).getLcredit() %>학점</span>
						</button>
						<%}%>
						<a class="up" href="#up"><i class="fa-solid fa-circle-arrow-up"></i></a>
					</div>
					
				</div>
			</div>
			<div class="col-md-8">
				<div id="tableviewbox">
				</div>
			</div>
		</div>
	</div>
	
	
	<%@include file="../footer.jsp"%>
	
	
	<script src="/team3/js/review/reviewadd.js" type="text/javascript"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>