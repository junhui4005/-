<%@page import="dao.MessageDao"%>
<%@page import="dto.Message"%>
<%@page import="dao.ReviewDao"%>
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
	<link href="/team3/css/message/message.css" rel="stylesheet">

</head>
<body>
	
	<%
	String mid = (String)session.getAttribute("login");
	int mno = ReviewDao.getreviewDao().getmno(mid);
	int totalrow = MessageDao.getMessageDao().gettotal(mno);
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
	
%>

	<% 
	
	ArrayList<Message> sendmessage = MessageDao.getMessageDao().sendmessage(mno,startrow,listsize); 
	%>

	<%@include file="../header.jsp"%>
	<h3 class="mess">보낸쪽지함</h3>
	<%@include file="messagebar.jsp"%>
	
	<div class="container">
		<div class="tablebox">
			<table class="table">
					<tr>
						<th>받은이</th><th class="내용">내용</th><th>작성일</th><th class="ing">상태</th>
					</tr>
				<%for(Message message : sendmessage){ 
					int sendno = message.getMgetno();
					String sendid= MessageDao.getMessageDao().getmid(sendno);
					if(message.getMactive()==1){
				%>
					<tr class="td" onclick="confirm(<%=message.getMnum() %>)" data-bs-toggle="modal" data-bs-target="#read">
						<td><%=sendid %></td><td><span class="mcontent1"><%=message.getMcontent()%></span></td><td><%=message.getMtime() %></td><td>읽지않음</td>
					</tr>
				<%}else{ %>
					<tr class="td" onclick="confirm(<%=message.getMnum() %>)" data-bs-toggle="modal" data-bs-target="#read">
						<td><%=sendid %></td><td><span class="mcontent"><%=message.getMcontent() %></span></td><td><%=message.getMtime() %></td><td>읽음</td>
					</tr>
				<%}} %>
			</table>
			<div class="col-md-4 offset-4 d-flex justify-content-center">	<!--  d-flex justify-content-center : 박스권 내에서 가운데 배치 -->
							 <ul class="pagination">
							
							 <!-- 이전 버튼 -->
							 <%if( currentpage == 1  ){ // 현재페이지가 1이면 0페이지로 요청 못하게 제한두기  %>
							 	<li class="page-item">  <a class="page-link pagenum" href="sendmessage.jsp">이전</a></li>
							 <%}else{ %>
							 	<li class="page-item">  <a class="page-link pagenum" href="sendmessage.jsp?pagenum=<%=currentpage-1%> ">이전</a></li>
							 <%} %>
							 
							 <!-- 페이징 버튼 -->
							 	<% for( int i = startbtn  ; i<=endhtn ; i++ ){ %>
							 		<li class="page-item"> 
								 		<a class="page-link pagenum" href="sendmessage.jsp?pagenum=<%=i%>"> 
								 			<%=i %> 
								 		</a> 
							 		</li>
								<%} %>
							
							<!-- 다음 버튼 --> 
							 <%if( currentpage == lastpage  ){ // 현재페이지가 마지막페이지 이면 마지막페이지 이상으로 요청 못하게 제한두기  %>
							 	<li class="page-item"> <a class="page-link pagenum" href="sendmessage.jsp?pagenum=<%=currentpage%>">다음</a></li>
							 <%}else{ %>
							 	<li class="page-item"> <a class="page-link pagenum" href="sendmessage.jsp?pagenum=<%=currentpage+1%>">다음</a></li>
							 <%} %>
							 </ul>
						</div>
			</div>
	</div>
	

<div class="modal" tabindex="-1" id="read">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">보낸쪽지</h5>
        <a href="sendmessage.jsp"><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></a>
      </div>
      <div class="modal-body" id="mcontent1">
      
      </div>
      <div class="modal-footer">
        <a href="sendmessage.jsp"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button></a>
        <div id="send1">
      	</div>
      </div>
    </div>
  </div>
</div>

<div class="modal" tabindex="-1" id="send">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">보낸쪽지</h5>
        <a href="sendmessage.jsp"><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></a>
      </div>
      <div class="modal-body" id="mcontent1">
      
      </div>
      <div class="modal-footer">
        <a href="sendmessage.jsp"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button></a>
        <div id="send1">
      	</div>
      </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp"%>

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/team3/js/message/message.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>