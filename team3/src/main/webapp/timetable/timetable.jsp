<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/css/bootstrap-select.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css">
	
	<link href="/team3/css/timetable/timetable.css" rel="stylesheet">
	<!-- Latest compiled and minified CSS -->
	


</head>
<body>

	<%String mid = (String)session.getAttribute("login"); %>

	<%@include file = "../header.jsp" %>
	
	<div class="container">
	
		<input type="text" value="<%=mid%>" id="mid" style="display: none">
	
		<div class="container-lecture">
			
			<!-- 헤드라인 -->
			<section class="header_timetable">
				<h3 class="headline">시간표</h3>
			</section>
			
			<!-- 단과대 / 학과 선택 -->
			<div class="row">
			
				<div class="col-md-6 selectbox" style="border-bottom: 1px;">
				
					<div class="row" style="margin-right: -60px; margin-left: -2px; margin-top: 40px;">
					
						<div id="collegebox_wrap" class="col-sm-4"> </div>
						
						<div id="departmentbox_wrap" class="col-sm-4"></div> 
					
					</div>
					
				</div>
				
			</div>

			<!-- 강의선택 navigation bar -->
			<section class="section-nav">
			
				<form id="search-form" class="form-search">
				
					<input type="text" placeholder="강의검색" class="form-control" onkeyup="filter()" id="value">
					
					<span><i class="material-icons ic-search">search</i></span>
					
				</form>
				
				<div id="lecturelist_wrap">
				
				</div>
			
			</section>
			
			<!-- 시간표 -->
			<section class="section-list" style="float: right;">
			
	        <div class="container-xl">
	        
	            <div class="table-schedule">
	            
	                <div class="timeline">
	                
	                    <ul>
	                        <li><span>09:00</span></li>
	                        <li><span>09:30</span></li>
	                        <li><span>10:00</span></li>
	                        <li><span>10:30</span></li>
	                        <li><span>11:00</span></li>
	                        <li><span>11:30</span></li>
	                        <li><span>12:00</span></li>
	                        <li><span>12:30</span></li>
	                        <li><span>13:00</span></li>
	                        <li><span>13:30</span></li>
	                        <li><span>14:00</span></li>
	                        <li><span>14:30</span></li>
	                        <li><span>15:00</span></li>
	                        <li><span>15:30</span></li>
	                        <li><span>16:00</span></li>
	                        <li><span>16:30</span></li>
	                        <li><span>17:00</span></li>
	                        <li><span>17:30</span></li>
	                        <li><span>18:00</span></li>
	                        <li><span>18:30</span></li>
	                        <li><span>19:00</span></li>
	                        <li><span>19:30</span></li>
	                        <li><span>20:00</span></li>
	                    </ul>
	                    
	                </div>
	
	                <div class="table-schedule-subject">
	                
	                    <ul class="list-lecture-item">
	                    
	                        <li class="timeline-vertical">
	                        
	                            <div class="top-info today">
	                                <h4 class="day_mon">Mon</h4>
	                            </div>
	                            
	                            <ul class="mon">
	                            	<li class="lecture_time_list" value="월&#47;1"></li>
	                            	<li class="lecture_time_list" value="월&#47;2"></li>
	                            	<li class="lecture_time_list" value="월&#47;3"></li>
	                            	<li class="lecture_time_list" value="월&#47;4"></li>
	                            	<li class="lecture_time_list" value="월&#47;5"></li>
	                            	<li class="lecture_time_list" value="월&#47;6"></li>
	                            	<li class="lecture_time_list" value="월&#47;7"></li>
	                            	<li class="lecture_time_list" value="월&#47;8"></li>
	                            	<li class="lecture_time_list" value="월&#47;9"></li>
	                            	<li class="lecture_time_list" value="월&#47;10"></li>
	                            	<li class="lecture_time_list" value="월&#47;11"></li>
	                            </ul>
	                            
	                        </li>
	
	                        <li class="timeline-vertical">
	                        
	                            <div class="top-info">
	                                <h4 class="day">Tue</h4>
	                            </div>
	                            
	                            <ul class="tue">
	                            	<li class="lecture_time_list" value="화&#47;1"></li>
	                            	<li class="lecture_time_list" value="화&#47;2"></li>
	                            	<li class="lecture_time_list" value="화&#47;3"></li>
	                            	<li class="lecture_time_list" value="화&#47;4"></li>
	                            	<li class="lecture_time_list" value="화&#47;5"></li>
	                            	<li class="lecture_time_list" value="화&#47;6"></li>
	                            	<li class="lecture_time_list" value="화&#47;7"></li>
	                            	<li class="lecture_time_list" value="화&#47;8"></li>
	                            	<li class="lecture_time_list" value="화&#47;9"></li>
	                            	<li class="lecture_time_list" value="화&#47;10"></li>
	                            	<li class="lecture_time_list" value="화&#47;11"></li>
	                                
	                            </ul>
	                            
	                        </li>
	
	                        <li class="timeline-vertical">
	                        
	                            <div class="top-info">
	                                <h4 class="day">Wed</h4>
	                            </div>
	
	                            <ul class="wed">
	                            	<li class="lecture_time_list" value="수&#47;1"></li>
	                            	<li class="lecture_time_list" value="수&#47;2"></li>
	                            	<li class="lecture_time_list" value="수&#47;3"></li>
	                            	<li class="lecture_time_list" value="수&#47;4"></li>
	                            	<li class="lecture_time_list" value="수&#47;5"></li>
	                            	<li class="lecture_time_list" value="수&#47;6"></li>
	                            	<li class="lecture_time_list" value="수&#47;7"></li>
	                            	<li class="lecture_time_list" value="수&#47;8"></li>
	                            	<li class="lecture_time_list" value="수&#47;9"></li>
	                            	<li class="lecture_time_list" value="수&#47;10"></li>
	                            	<li class="lecture_time_list" value="수&#47;11"></li>
	
	                            </ul>
	                            
	                        </li>
	
	                        <li class="timeline-vertical">
	                        
	                            <div class="top-info">
	                                <h4 class="day">Thu</h4>
	                            </div>
	
	                            <ul class="thu">
	                            	<li class="lecture_time_list" value="목&#47;1"></li>
	                            	<li class="lecture_time_list" value="목&#47;2"></li>
	                            	<li class="lecture_time_list" value="목&#47;3"></li>
	                            	<li class="lecture_time_list" value="목&#47;4"></li>
	                            	<li class="lecture_time_list" value="목&#47;5"></li>
	                            	<li class="lecture_time_list" value="목&#47;6"></li>
	                            	<li class="lecture_time_list" value="목&#47;7"></li>
	                            	<li class="lecture_time_list" value="목&#47;8"></li>
	                            	<li class="lecture_time_list" value="목&#47;9"></li>
	                            	<li class="lecture_time_list" value="목&#47;10"></li>
	                            	<li class="lecture_time_list" value="목&#47;11"></li>
	
	                            </ul>
	                            
	                        </li>
	
	                        <li class="timeline-vertical">
	                        
	                            <div class="top-info">
	                                <h4 class="day">Fri</h4>
	                            </div>
	
	                            <ul class="fri">
	                            	<li class="lecture_time_list" value="금&#47;1"></li>
	                            	<li class="lecture_time_list" value="금&#47;2"></li>
	                            	<li class="lecture_time_list" value="금&#47;3"></li>
	                            	<li class="lecture_time_list" value="금&#47;4"></li>
	                            	<li class="lecture_time_list" value="금&#47;5"></li>
	                            	<li class="lecture_time_list" value="금&#47;6"></li>
	                            	<li class="lecture_time_list" value="금&#47;7"></li>
	                            	<li class="lecture_time_list" value="금&#47;8"></li>
	                            	<li class="lecture_time_list" value="금&#47;9"></li>
	                            	<li class="lecture_time_list" value="금&#47;10"></li>
	                            	<li class="lecture_time_list" value="금&#47;11"></li>
	                                
	                            </ul>
	                            
	                        </li>
	                        
	                    </ul>
	                    
	                </div>
	                
	            </div>
	            
	        </div>
	        
	    </section>
			
			<!-- 강의선택 Modal -->
			<div class="modal fade" id="modal-lecture-info" role="dialog" aria-hidden="true">
			
				<div class="modal-dialog">
				
					<div class="modal-content"> 
					
						<div class="modal-header">
						
							 <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
						
						</div>
						
						<div class="modal-body">
						
							<h3 class="lecture_title">1</h3>
							
							<ul class="lecture-info">
							
									<li class="lecture-time">
									
										<i class="material-icons ic-lecture-info">access_alarm</i>
										강의시간 : <span class="lecture_time">1</span><span class="lecture_time_db" style="display: none;"></span>
										
									</li>
									
									<li class="">
										<i class="material-icons ic-lecture-info">code</i>
										교과목 코드 : <span class="lecture_code">1</span> 
									</li>
									
									<li class="">
										<i class="material-icons ic-lecture-info">school</i>
										담당 교수 : <span class="lecture_professor">1</span>
									</li>
									
								</ul>
								
								<div class="lecture-description">
									<p class="txt-description">텍스트디스크립션</p>
								</div>
								
						</div>
						
						<div class="modal-footer">
						
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" id="btn_regist">과목 등록하기</button>
						
						</div>
					
					</div>
				
				</div>
				
			</div>
			
			<!-- 시간표 강의 선택 Modal -->
			<div class="modal fade" id="modal-lecture-task" role="dialog" aria-hidden="true" data-bs-focus="false" data-bs-backdrop="static" data-bs-keyboard="false">
			
			    <div class="modal-dialog" role="document">
			    
			        <div class="modal-content">
			        
			            <div class="modal-header">
			            
			                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			                
			            </div>
			            
			            <div class="modal-body">
			            
			                <h3 class="lecture_title"></h3>
			                
			                <ul class="lecture-info">
			                
			                    <li class="lecture-time">
			                    
			                        <i class="material-icons ic-lecture-info">access_alarm</i>
			                        강의시간 : <span class="lecture_time"></span>
			                        
			                    </li>
			                    
			                    <li class="lecture-code">
			                        <i class="material-icons ic-lecture-info">code</i>
			                        교과목코드 : <span class="lecture_code"></span>
			                    </li>
			                    
			                    <li class="lecture-code">
			                        <i class="material-icons ic-lecture-info">school</i>
			                        담당교수 : <span class="lecture_professor"></span>
			                    </li>
			                    
			                </ul>
			                
			                <div class="lecture-description">
			                    <p class="txt-description">강의내용 간략히
			                    </p>
			                </div>
			
			                <div class="lecture-memo">
			                
			                    <h5 class="memo-header">메모</h5>
			                    
			                    <ul>
			                    
			                        <li class="memo-list">
			                        
			                            <div class="memo-content" data-bs-toggle="tooltip" data-bs-placement="bottom" title="간단한 툴팁">
			                                <i class="material-icons ic-lecture-noti">assignment</i>
			                                <span class="lecture-noti-title">메모내용 간략히</span>
			                            </div>
			                            
			                            <div class="memo-btn">
			                                <a href="javascript:void(0)"><i class="material-icons ic-lecture-noti">delete</i></a>
			                            </div>
			                            
			                        </li>
			                        
			                    </ul>
			                    
			                </div>
			                
			            </div>
			            
			            <div class="modal-footer">
			            
			                <div class="left">
			                    <a class="btn btn-light-primary" role="button" data-bs-toggle="popover" data-bs-trigger="click" data-bs-placement="right" tabindex="0" >
			                        메모 등록
			                    </a>
			                    
			                </div>
			                
			                <div class="right">
			                
			                    <button type="button" class="btn btn-light" data-bs-dismiss="modal">확인</button>
			                    <button type="button" class="btn btn-danger" id="delete_lecture">과목 삭제하기</button>
			                    
			                </div>
			                
			            </div>
			            
			        </div>
			        
			    </div>
			    
			    <!-- 메모 pop over -->
				<div id="PopoverContent" style="visibility: hidden;">
				
				    <h5 class="schedule-title">메모 등록하기</h5>
				    
				    <div class="form-group">
				    
				        <label for="message-text" class="col-form-label">메모</label>
				        
				        <textarea class="form-control" id="message-text" placeholder="메모를 입력해주세요"></textarea>
				        
				    </div>
				    
				    <button id="memo1" onclick="memoregist(this)" class="btn btn-primary btn-save">등록</button>
				    
				</div>
			    
			</div>
			
			
			
		</div>
	
	</div>
	
	
	
<%@include file="../footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="/team3/js/timetable.js" type="text/javascript"></script>
	<script src="https://kit.fontawesome.com/d77abffe02.js"></script>
	

</body>
</html>