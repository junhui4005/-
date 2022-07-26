<%@page import="dto.Reply"%>
<%@page import="dao.ReplyDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/team3/css/board/boardview.css">
<link rel="stylesheet" type="text/css" href="/team3/css/board/reply.css">
<script src="https://kit.fontawesome.com/d77abffe02.js"></script>
<!-- 폰트어썸[ 아이콘 ]  -->
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
<%
int bno = Integer.parseInt( request.getParameter("bno"));

Board board  = BoardDao.getBoardDao().getboaBoard(bno);
String mid = (String)session.getAttribute("login"); 
int mno = BoardDao.getBoardDao().getmno(mid);
String id = BoardDao.getBoardDao().getmid(mno);
int mno2 = BoardDao.getBoardDao().getnos(bno);



%>

<%@include file="../header.jsp"%>


<input type="hidden" value="<%=bno%>" id="bno">
<div class="container content_wrap">

			 <div class="view_wrap">
				<div class="view_header">
				
				<div class="board_title">
					<div class="t"><h1><%=board.getBtitle() %></h1></div>
					
					
					
						
				
				</div>
				</div>
				
				<div class="line"></div>
				
				
				
				
				<div class="user"> 
					<div class="user_h">
						<span><i class="fas fa-user"></i></span> 
						<span style="margin-left:10px;"><%=board.getBnickname() %></span> 
					</div>
					
					<div class="date"><span>  <%=board.getBdate() %> </span>
				
				</div>
					
				
				
				
				</div>
			
			
				 
					<div class="boardview_content">	
						<%=board.getBcontent() %>
					</div>
				
			
			
			<% if( board.getBimg() == null ){ // 첨부파일이 없을경우 %> 
				
			<%	}else{  %>
				 <div class="img_area"><img width="100%" alt="" src="/team3/board/upload/<%=board.getBimg()%>"> </div> <!-- 첨부파일 다운로드 -->
			<% } %>
			
			<div id="like_area">
			<%
				if(mid != null && BoardDao.getBoardDao().getblike(bno, mno)) {%>
				<button class="likeb" onclick="saveblike('<%=mid%>');"><i class="fas fa-thumbs-up"></i> <%=board.getBlike() %></button>
			<% } else {%>
			
			<button  class="likeb" onclick="saveblike('<%=mid%>');"><i class="far fa-thumbs-up"></i>  <%=board.getBlike() %></button>
			<%} %>
			
			</div>
			
		
			</div>
			
			<div class="lay">
			
				<div class="upbutton_area"> <!-- 게시물 수정삭제 버튼 구역 -->
				<% if(mno == mno2){  %>
					<a href="boardupdate.jsp?bno=<%=board.getBno()%>"><button>수정</button></a>
					<a href="boarddelete?bno=<%=board.getBno()%>"> <button>삭제</button> </a>
					<%} %>
					<a href="boardlist.jsp"><button>글목록</button></a>
				</div>
			</div>
		
			<!-- 댓글작성구역 ------------------------------------------------------------------------------------->
			
			<div class="rwrite_wrap"> <!-- row : 가로배치 -->
			<div class="rwirte_area">
				<textarea  rows="2" cols="30" name="rcontent" id="rcontent"  ></textarea>
				
				<button type="button" id="rwrite" onclick="replywrite(<%=bno%>)">등록</button>
				
			</div>
			<span> <input id="anonymous" type="checkbox" value="익명" name="anonymous"> 익명</span>
			<div>
		
			</div>
		</div>
		
		</div>		
			
			<!-- 댓글출력구역------------------------------------------------------------------------------------ -->
			<%
				ArrayList<Reply> replylist = ReplyDao.getReplyDao().replylist(bno);
				
			%>
			<div class="container" id="wrap">
			
			<% for(Reply reply : replylist) { %>
			
			<div id="reply_wrap"> <!-- 댓글출력구역 -->
			
				<div class="rbox">
				<%if (reply.getMno() == mno2) { %>
				<div class="rheader"><span><i class="fas fa-user"></i></span>  작성자   <time><%=reply.getRdate() %></time></div>
				<%} else { %>
					<div class="rheader"><span><i class="fas fa-user"></i></span>  <%=reply.getRnickname() %>   <time><%=reply.getRdate() %></time></div>
				<% } %> 
				<div class="rmain"><p class="con"><%=reply.getRcontent()%><p></div>
				<div class="rfooter">
				
					<div id="relike_area">
			<%
				if(mid != null && ReplyDao. getReplyDao().getreplylike(reply.getRno(), mno)) {%>
				 <span style="margin-right:10px;" onclick="rereplyview(<%=reply.getRno()%>,<%=reply.getBno()%>)"><i class="far fa-comment-alt"></i></span>
				<button class="likebre" onclick="saverelike('<%=mid%>',<%=reply.getRno()%>);"><i class="fas fa-thumbs-up"></i> <%=reply.getRelike() %></button>
				
			<% } else {%>
			 <span style="margin-right:10px;" onclick="rereplyview(<%=reply.getRno()%>,<%=reply.getBno()%>)"><i class="far fa-comment-alt"></i></span>
			<button class="likebre" onclick="saverelike('<%=mid%>',<%=reply.getRno()%>);"><i class="far fa-thumbs-up"></i>  <%=reply.getRelike() %></button>
			<%} %>
			
			</div>
				<div class="btn_area">
				<% int mno3 = BoardDao.getBoardDao().getnos2(reply.getRno());%>
				<%if(mno == mno3) { %>
				<div class="test"><button onclick="updateview(<%=reply.getRno()%>,'<%=reply.getRcontent()%>',<%=reply.getBno()%>)">수정</button></div>
				<div class="test"><button onclick="replydelete(<%=reply.getRno()%>,<%=reply.getBno()%>)">삭제</button></div>
				<% }%>
				</div>
				</div>
				
			</div>
			</div> 
			<!-- 수정입력창 -->
					<div class="rwrite_wrap" id=<%=reply.getRno()%>> <!-- row : 가로배치 -->
			
					</div>
					
			<!-- 대댓입력창 -->
			<div class="rwrite_wrap" id=<%=reply.getRno()%>> <!-- row : 가로배치 -->
	
			</div>
			
			<!-- 대댓글 출력 -->
			<%ArrayList<Reply> rereplylist = ReplyDao.getReplyDao().rereplylist( bno , reply.getRno() );
				for( Reply rereply : rereplylist ){%>
				<div id="reply_wrap"> <!-- 댓글출력구역 -->
			
				<div class="rbox re">
				<%if(rereply.getMno() == mno2) { %>
				<div class="rheader"><span><i class="fas fa-user"></i></span>  작성자   <time><%=reply.getRdate() %></time></div> 
				<% } else {%>
				<div class="rheader"><span><i class="fas fa-user"></i></span>  <%=rereply.getRnickname() %>   <time><%=reply.getRdate() %></time></div>
				<%} %>
				<div class="rmain"><p class="con"><%=rereply.getRcontent()%><p></div>
				<div class="rfooter">
						<div id="relike_area">
			<%
				if(mid != null && ReplyDao. getReplyDao().getreplylike(rereply.getRno(), mno)) {%>
				 <span onclick="rereplyview(<%=rereply.getRno()%>,<%=rereply.getBno()%>)"></span>
				<button class="likebre" onclick="saverelike('<%=mid%>',<%=rereply.getRno()%>);"><i class="fas fa-thumbs-up"></i><%=rereply.getRelike() %></button>
				
			<% } else {%>
			 <span onclick="rereplyview(<%=rereply.getRno()%>,<%=rereply.getBno()%>)"></span>
			<button class="likebre" onclick="saverelike('<%=mid%>',<%=rereply.getRno()%>);"><i class="far fa-thumbs-up"></i>  <%=rereply.getRelike() %></button>
			<%} %>
			
			</div>
				<div class="btn_area">
				<% int mno4 = BoardDao.getBoardDao().getnos2(rereply.getRno());%>
				<%if(mno == mno4) { %>
				<div class="test"><button onclick="reupdateview(<%=rereply.getRno()%>,'<%=rereply.getRcontent()%>',<%=rereply.getBno()%>)">수정</button></div>
				<div class="test"><button onclick="replydelete(<%=rereply.getRno()%> ,<%=rereply.getBno()%>)">삭제</button></div>
				<%} %>
				</div>
				</div>
				
			</div>
			</div> 
			
			<!-- 대댓입력창 -->
			<div class="rwrite_wrap" id=<%=rereply.getRno()%>> <!-- row : 가로배치 -->
	
			</div>
			
				
				
			<%  }  } %>
			
					
			
			
			</div>
			
			
			
			
			
			
			<div class="footer bb">
		<div class="container">
			<div class="row p-5">
				<p class="p1">개인정보처리방침 | 대학정보 | 전화번호안내 | 통합서비스센터</p>
				<div class="col-md-4 offset-2 line12"> 
					<h3> oo대학교 </h3>
					<p>경기도 안산시 ㅇㅇ구 ㅇㅇ로 1234-1</p>
				</div>
				<div class="col-md-5 offset-1"> 
					<h3> 전화문의 </h3>
					<p>
						123-1234-1234 <br>
					</p>
					
				</div>
			</div>
		</div>
	</div>
		
		

<script type="text/javascript" src="/team3/js/board/boardview.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>