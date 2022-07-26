<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Lecture"%>
<%@page import="org.json.JSONArray"%>
<%@page import="dao.ReviewDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link href="css/review.css" rel="stylesheet">
	

</head>
<body>
	
	<%
	
	int lno = Integer.parseInt(request.getParameter("lno"));
	
	int totalrow = ReviewDao.getreviewDao().gettotal(lno);
	int currentpage = 1;
		String pagenum = request.getParameter("pagenum");
		if( pagenum == null ){ // 만약에 페이지번호 요청이 없으면
			currentpage = 1; // 1페이지
		}else{
			currentpage = Integer.parseInt( pagenum ); 
		}
		
	int listsize = 12;	
	
	int startrow = (currentpage-1)*listsize; 
	
	int lastpage = 0;
	if( totalrow % listsize == 0 ){ 
		// 전체게시물 와 화면표시게시물수 나누기 했을때 나머지가 0이면
		lastpage = totalrow / listsize; 
	}else{
		lastpage = totalrow / listsize +1; 
		// 나머지가 있으면 나머지 게시물을 표시할 페이지 +1
	}
	
	int btnsize = 5;
	int startbtn = ( (currentpage-1) / btnsize ) * btnsize + 1 ;
				
	int endhtn = startbtn + btnsize-1;
	if( endhtn > lastpage ) endhtn = lastpage;
	
	
	Lecture lecture = ReviewDao.getreviewDao().lecture(lno);
	JSONArray json= ReviewDao.getreviewDao().getreview(lno, startrow, listsize);
	int 이수구분 = lecture.getLdivision();
	String ldivision = null;
	if(이수구분==0){ldivision= "전공";}
	else{ldivision= "교양";}
	
	
	String reviewrate= "reviewrate";
	String reviewhome= "reviewhome";
	String reviewteam= "reviewteam";
	String reviewtest= "reviewtest";
	double star = ReviewDao.getreviewDao().review(lno, reviewrate);
	
	DecimalFormat df = new DecimalFormat("0.0"); 
	String st = df.format(star);
	
	double home = ReviewDao.getreviewDao().review(lno, reviewhome);
	double team = ReviewDao.getreviewDao().review(lno, reviewteam);
	double test = ReviewDao.getreviewDao().review(lno, reviewtest);
	
	///////과제평균
	String 과제 =null;
	if(home>=2.5){
		과제 = "많음";
	}
	else if(home<2.5&&home>=1.5){
		과제 = "보통";
	}
	else{
		과제 = "없음";
	}
///////시험평균
	String 시험 =null;
	if(test>=3.5){
		시험 = "세번이상";
	}
	else if(test<3.5&&test>=2.5){
		시험 = "두번";
	}
	else if(test<2.5&&test>=1.5){
		시험 = "한번";
	}
	else{
		시험 = "없음";
	}
///////조모임평균
	String 조모임 =null;
	if(team>=2.5){
		조모임 = "많음";
	}
	else if(team<2.5&&team>=1.5){
		조모임 = "보통";
	}
	else{
		조모임 = "없음";
	}
	
	
%>

	<%@include file="../header.jsp"%>
	
	<div class="container">
		<div class="row">
			<h3 class="강의평가">강의평가</h3>
			<div class="box1"><!-- 강의 -->
				<h4><%=lecture.getLname() %></h4>
				교수명: <%=lecture.getLprofessor() %><br>
				이수구분: <%=ldivision %>
			</div>
			<div class="box2">
				<div class="rline"><!-- 강의평평균 -->
					<h4>강의평</h4>
					<div class="row">
						<div class="col-md-3">
					<%if(5==star){ %>
						<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
					<%} %>
					<%if(5>star&&star>=4.5){ %>
						<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색반별.png">
					<%} %>
					<%if(4.5>star&&star>=4){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(4>star&&star>=3.5){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색반별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(3.5>star&&star>=3){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(3>star&&star>=2.5){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색반별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(2.5>star&&star>=2){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(2>star&&star>=1.5){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색반별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(1.5>star&&star>=1){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색반별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(1>star&&star>=0.5){ %>
									<img class="star" alt="" src="img/회색반별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%if(0.5>star&&star>=0){ %>
									<img class="star" alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
					<%} %>
					<%=st %><br><br>
					<span class="학점"><%=lecture.getLcredit()%>학점</span>
					</div>
					<div class="col-md-9">
					과제: <%=과제 %><br>
					시험: <%=시험 %><br>
					조모임: <%=조모임 %>
					</div>
					</div>
				</div>
				<div><!-- 강의평리스트 -->
					<div>
						<table class="table">
						
						<% 
						
						for(int j=0; j<json.length();j++){
							int rhome = (int)json.getJSONObject(j).get("reviewhome");
							String r과제 = null;
							if(rhome==1){r과제="없음";}
							else if(rhome==2){r과제="보통";}
							else if(rhome==3){r과제="많음";}
							int rtest = (int)json.getJSONObject(j).get("reviewtest");
							String r시험 = null;
							if(rtest==1){r시험="없음";}
							else if(rtest==2){r시험="한번";}
							else if(rtest==3){r시험="두번";}
							else if(rtest==4){r시험="세번이상";}
							int rteam = (int)json.getJSONObject(j).get("reviewteam");
							String r조모임 = null;
							if(rteam==1){r조모임="없음";}
							else if(rteam==2){r조모임="보통";}
							else if(rteam==3){r조모임="많음";}
					%>
							<tr>
								<td class="tableheight">
								
								<%if(json.getJSONObject(j).get("reviewrate").equals(1)){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
								<%} %>
								<%if(json.getJSONObject(j).get("reviewrate").equals(2)){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
								<%} %>
								<%if(json.getJSONObject(j).get("reviewrate").equals(3)){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
									<img class="star"  alt="" src="img/회색별.png">
								<%} %>
								<%if(json.getJSONObject(j).get("reviewrate").equals(4)){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/회색별.png">
								<%} %>
								<%if(json.getJSONObject(j).get("reviewrate").equals(5)){ %>
									<img class="star" alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
									<img class="star"  alt="" src="img/노란별.png">
								<%} %>
								<br>
								<%=json.getJSONObject(j).get("reviewcontent") %><br>
								<span class="개별평가">과제: <%=r과제 %></span>
								<span class="개별평가">시험: <%=r시험 %></span>
								<span class="개별평가">조모임: <%=r조모임 %></span>
							</td>
							</tr>
							<%} %>
						</table>
					</div>
					<div class="col-md-4 offset-4 d-flex justify-content-center">	<!--  d-flex justify-content-center : 박스권 내에서 가운데 배치 -->
							 <ul class="pagination">
							 <!-- 이전 버튼 -->
							 <%if( currentpage == 1  ){ // 현재페이지가 1이면 0페이지로 요청 못하게 제한두기  %>
							 	
							 <%}else{ %>
							 	<li class="page-item">  <a class="page-link pagenum" href="review.jsp?lno=<%=lno%>&pagenum=<%=currentpage-1%> ">이전</a></li>
							 <%} %>
							 
							 <!-- 페이징 버튼 -->
							 	<% for( int i = startbtn  ; i<=endhtn ; i++ ){ %>
							 		<li class="page-item"> 
								 		<a class="page-link pagenum" href="review.jsp?lno=<%=lno%>&pagenum=<%=i%>"> 
								 			<%=i %> 
								 		</a> 
							 		</li>
								<%} %>
							
							<!-- 다음 버튼 --> 
							 <%if( currentpage == lastpage  ){ // 현재페이지가 마지막페이지 이면 마지막페이지 이상으로 요청 못하게 제한두기  %>
							 	
							 <%}else{ %>
							 	<li class="page-item"> <a class="page-link pagenum" href="review.jsp?lno=<%=lno%>&pagenum=<%=currentpage+1%>">다음</a></li>
							 <%} %>
							 </ul>
						</div>
					</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>