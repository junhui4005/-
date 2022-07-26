<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link type="text/css" href="/team3/css/calculator/common.css" rel="stylesheet">
	<link type="text/css" href="/team3/css/calculator/partial.css" rel="stylesheet">
	
	<link type="text/css" href="/team3/css/calculator/calculator.css" rel="stylesheet">
	<link type="text/css" href="/team3/css/calculator/modal.css" rel="stylesheet">

	<style type="text/css">
		
		#container div.section{
			 height : 100vh !important; 
			 color: #666; 
			 font-family: "맑은 고딕", 돋움, tahoma ; 
			 _font-family: 돋움, tahoma; 
			 font-size: 12px; 
			 letter-spacing: -0.5px; "
		}
	
	</style>

</head>
<body style>
	<jsp:include page="../header.jsp" flush="true"/>
	
		<div id="container" class="calculator">
		
			<div class="section">
			
				<div class="chart empty">
				
					<article class="overview">
					
						<div class="column gpa">
						
							<h4>전체평점</h4>
							<p class="value">0</p>
							<p class="total"> / 4.5 <span class="button">변경</span></p>
						
						</div>
						
						<div class="column major">
						
							<h4>전공평점</h4>
							<p class="value">0</p>
							<p class="total"> / 4.5 </p>
						
						</div>
						
						<div class="column acquisition">
						
							<h4>취득 학점</h4>
							<p class="value">0</p>
							<p class="total" title="졸업 학점 설정">/ 150</p>
						
						</div>
					
					</article>
					
					<article class="semester">
					
          				<div class="series">
          				
            				<div class="legend">
            					<table style="font-size:smaller;color:#545454">
            						<tbody>
            							<tr>
            								<td class="legendColorBox">
            									<div style="border:1px solid transparent;padding:1px">
            										<div style="width:4px;height:0;border:5px solid rgb(198,41,23);overflow:hidden"></div>
            									</div>
            								</td>
            								
            								<td class="legendLabel">
            									<span style="color: rgb(198,41,23)">전체</span>
            								</td>
            								
            								<td class="legendColorBox">
            									<div style="border:1px solid transparent;padding:1px">
            										<div style="width:4px;height:0;border:5px solid rgb(166,166,166);overflow:hidden"></div>
            									</div>
            								</td>
            								
            								<td class="legendLabel">
            									<span style="color: rgb(166,166,166)">전공</span>
            								</td>
            							</tr>
            						</tbody>
            					</table>
            				</div>
            				
            				<div class="plot" style="padding: 0px; position: relative;">
            				
            					<canvas class="flot-base" width="365" height="129" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 365px; height: 129px;"></canvas>
            					
            					<div class="flot-text" style="position: absolute; inset: 0px; font-size: smaller; color: rgb(84, 84, 84);">
            					
            						<div class="flot-y-axis flot-y1-axis yAxis y1Axis" style="position: absolute; inset: 0px; display: block;">
            						
            							<div style="position: absolute; top: 90px; font: 400 12px / 14px &quot;맑은 고딕&quot;, 돋움, tahoma; color: rgb(166, 166, 166); left: 0px; text-align: right;">2.0</div>
            							<div style="position: absolute; top: 55px; font: 400 12px / 14px &quot;맑은 고딕&quot;, 돋움, tahoma; color: rgb(166, 166, 166); left: 0px; text-align: right;">3.0</div>
            							<div style="position: absolute; top: 20px; font: 400 12px / 14px &quot;맑은 고딕&quot;, 돋움, tahoma; color: rgb(166, 166, 166); left: 0px; text-align: right;">4.0</div>
            							
            						</div>
            						
            					</div>
            					
            					<canvas class="flot-overlay" width="365" height="129" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 365px; height: 129px;"></canvas>
            					
            				</div>
          				</div>
					<ul class="ratioplot"><li><span class="grade">A+</span><div class="ratiowrapper"><div class="ratiobar" style="width: calc(41.6667%); height: 4px; background-color: rgb(242, 133, 114);"></div><span class="ratiotext" style="left: calc(41.6667%); color: rgb(242, 133, 114);">17%</span></div></li><li><span class="grade">A0</span><div class="ratiowrapper"><div class="ratiobar" style="width: calc(41.6667%); height: 4px; background-color: rgb(236, 197, 92);"></div><span class="ratiotext" style="left: calc(41.6667%); color: rgb(236, 197, 92);">17%</span></div></li><li><span class="grade">B+</span><div class="ratiowrapper"><div class="ratiobar" style="width: calc(41.6667%); height: 4px; background-color: rgb(160, 198, 97);"></div><span class="ratiotext" style="left: calc(41.6667%); color: rgb(160, 198, 97);">17%</span></div></li><li><span class="grade">B0</span><div class="ratiowrapper"><div class="ratiobar" style="width: calc(41.6667%); height: 4px; background-color: rgb(130, 209, 194);"></div><span class="ratiotext" style="left: calc(41.6667%); color: rgb(130, 209, 194);">17%</span></div></li><li><span class="grade">C+</span><div class="ratiowrapper"><div class="ratiobar" style="width: calc(41.6667%); height: 4px; background-color: rgb(122, 158, 224);"></div><span class="ratiotext" style="left: calc(41.6667%); color: rgb(122, 158, 224);">17%</span></div></li></ul>
				</article>
					
					
				
				</div>
				
				<div class="menu">
				
				</div>
				
				<table class="subjects">
				
					<caption>
					
						<h3>이번학기</h3>
						
						<dl class="information">
						
							<dt> 평점 </dt>
							<dd class="gpa">0</dd>
							<dt> 전공 </dt>
							<dd class="major">0</dd>
							<dt> 취득 </dt>
							<dd class="acquisition">0</dd>
						
						</dl>
						
						<a class="import">시간표 불러오기</a>
					
					</caption>
					
					<thead>
					
						<tr>
							<th class="name">과목명</th>
							<th class="credit">학점</th>
							<th class="grade">성적</th>
							<th class="major">전공</th>
						</tr>
					
					</thead>
					
					<tbody>
					
						<tr>
							<td>
								<input name="name" maxlength="50">
							</td>
							
							<td>
								<input name="credit" type="number" maxlength="4" value="0">
							</td>
							
							<td>
								<select name="grade">
									<option value="A+" selected="selected">A+</option>
									<option value="A0">A0</option>
									<option value="B+">B+</option>
									<option value="B0">B0</option>
									<option value="C+">C+</option>
									<option value="C0">C0</option>
									<option value="D+">D+</option>
									<option value="D0">D0</option>
									<option value="F">F</option>
									<option value="P">P</option>
									<option value="NP">NP</option>
								</select>
							</td>
							
							<td>
								<label>
									<input name="major" type="checkbox"><span></span>
								</label>
							</td>
						</tr>
						

						
						
					
					</tbody>
					
					<tfoot>
					
						<tr>
						
							<td colspan="4">
								<a class="new">더 입력하기</a>
								<a class="reset">초기화</a>
							</td>
						</tr>
					
					</tfoot>
				
				</table>
			
			</div>
			
			
			
			<form id="requiredCreditForm" class="modal_f" style="margin-left: -200px; margin-top: -92.5px; display: none;">
				<a title="닫기" class="close"></a>
				<h3>졸업 학점 설정</h3>
				<p>
			  		<label>졸업 학점</label>
			  	<input type="number" name="required_credit" maxlength="3" class="text">
				</p>
				<input type="button" value="저장" class="button">
			</form>
			
			
		
		</div>
		
		
	<%@include file="../footer.jsp" %>
	

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/team3/js/calculator/calculator.js"></script>
	<script  src="https://cdn.jsdelivr.net/npm/underscore@1.13.4/underscore-umd-min.js"></script>
	
	
	
	
	
	
</body>
</html>