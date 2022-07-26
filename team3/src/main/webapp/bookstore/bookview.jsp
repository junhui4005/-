<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BookstoreDao"%>
<%@page import="dto.Textbook"%>
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
	<%@include file = "../header.jsp" %>
	<%
		int tno = Integer.parseInt(request.getParameter("tno"));
		Textbook textbook = BookstoreDao.getBookstoreDao().getBook(tno);
	%>
	<div class="bviewbox">
		<h3 class="text-center my-4">책방</h3>
		<div class="contentbox"><!-- 상세정보 -->
			<h5 class="ttitle"><%=textbook.getTtitle() %></h5>
			<%
					String bookcondition = "";
					if(textbook.getTcondition()==1){
						bookcondition = "상";
					}else if(textbook.getTcondition()==2){
						bookcondition = "중";
					}else{
						bookcondition = "하";
					}
					DecimalFormat format = new DecimalFormat("###,###");
					String price = format.format(textbook.getTprice());
				%>
			<table>
				<tr class="content_table_tr"><td class="table_col1">저자</td><td><%=textbook.getTauthor() %></td><tr>
				<tr class="content_table_tr"><td class="table_col1">출판사</td><td><%=textbook.getTcompany()%></td><tr>
				<tr class="content_table_tr"><td class="table_col1">출판년도</td><td><%=textbook.getTyear() %></td><tr>
				<tr class="content_table_tr"><td class="table_col1">사용한 수업</td><td><%=textbook.getTclass()%></td><tr>
				<tr class="content_table_tr"><td class="table_col1">희망가격</td><td class="tprice"><%=price %></td><tr>
			</table>
		</div>
		<div class="contentbox"><!-- 책 상태, 이미지 -->
			<div>
				<span>책 상태</span><span class="bookconditon"><%=bookcondition%></span>
			</div>
			<img width="150px" alt="" src="/team3/bookstore/bookimg/<%=textbook.getTimg()%>">
		</div>
		<div class="contentbox"><!-- 상세 설명, 쪽지버튼 -->
			<div class="row">
				<span>상세설명</span><span class="tcontent"><%=textbook.getTcontent()%></span>
				
			</div>
				<%
				if(textbook.getMno()== MemberDao.getMemberDao().getmno(loginid)){ %>
				<div class="row">
					<div class="col-md-6">
						<a href="/team3/bookstore/bookupdate.jsp?tno=<%=textbook.getTno() %>">
							<button class="btnbook " onclick="bookupdate()">수정하기</button>
						</a>
					</div>
					<div class="col-md-6">
						<a href="/team3/bookstore/bookdelete?tno=<%=textbook.getTno()%>"><button class="form-control">삭제하기</button></a>
					</div>
				</div>
			<%}else{ %>
				<div>
					<button class="btnbook"  data-bs-toggle="modal" data-bs-target="#read">판매자에게 쪽지 보내기</button>
				</div>
			<%} %>
		</div>
	</div>
	<!-- 쪽지 모달 -->	
	<div class="modal" tabindex="-1" id="read">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">쪽지 보내기</h5>
	        <a href="bookview.jsp"><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></a>
	      </div>
	      <div class="modal-body" id="mcontent1">
	      	<div class="modal-body" id="mcontent">
				<div class="container">
					<p><%=MemberDao.getMemberDao().getmid(textbook.getMno())%> 님,</p>
					<input type="hidden" id="getno" value="<%=textbook.getMno()%>">
				<textarea class="ctext" rows="" cols="" id="content"></textarea>
			</div>
		</div>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" id="send" class="btn btn-primary" onclick="reply()">보내기</button>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <div id="send1">
	      	</div>
	      </div>
	    </div>
	  </div>
	</div>
	<br><br><br><br><br>
	<%@include file="../footer.jsp" %>
	<script src="/team3/js/message/message.js" type="text/javascript"></script>
	<script src="/team3/js/bookstore/bookstore.js" type="text/javascript"></script>
</body>
</html>