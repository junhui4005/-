
let jsonarray;

function lecturelist(lno){
	
	$.ajax({
		url : '/team3/review/reviewaddcheck' ,
		data: {"lno": lno},
		success : function( re ){
			if(re==1){
				alert("기존에 입력한 기록이 있습니다.");
			}
			else{
				$.ajax({
				url : '/team3/review/getlecture' ,
				data: {"lno": lno},
				success : function( json ){
					jsonarray = json;	/* 응답받은 데이터를 전역변수에 넣어주기 */
					tableview();
					$("#lno").val(lno);
		}
	});
			}
		}
	});
	
	
	
}

function tableview(){
			let tr = '';
			for( let i = 0 ; i<jsonarray.length; i++ ){
				let division = "";
				if(jsonarray[i]["ldivision"]==0){
					division="전공";}
				else{division="교양"}
				
				tr += 
				'<div class="tableviewbox">'+
				'<div class="row">'+
				'<input type="hidden" id="lno">'+
				'	<div class="col-md-3" id="lecture">'+
				'		<span class="lname">'+jsonarray[i]["lname"]+'</span><br>'+
				'		<span>'+jsonarray[i]["lprofessor"]+'교수</span><br>'+
				'		<span>'+jsonarray[i]["lcredit"]+'학점</span><br>'+
				'		<span class="lcollege">'+division+' : : </span>'+
				'		<span class="lcollege">'+jsonarray[i]["lcollege"]+'</span><br><br>'+
				'	</div>'+
				'	<div class="col-md-9">'+
				'		과제 <br>'+
				'<input type="hidden" id="homework">'+
				'	<span id="homelist">'+
						'<button class="selectbtn" type="button" onclick="home1()">없음</button>'+
						'<button class="selectbtn" type="button" onclick="home2()">보통</button>'+
						'<button class="selectbtn" type="button" onclick="home3()">많음</button><br>'+
					'</span>'+
				'		시험횟수 <br>'+
				'<input type="hidden" id="test">'+
				'	<span id="testlist">'+
						'<button class="selectbtn" type="button" onclick="test1()">없음</button>'+
						'<button class="selectbtn" type="button" onclick="test2()">한번</button>'+
						'<button class="selectbtn" type="button" onclick="test3()">두번</button>'+
						'<button class="selectbtn" type="button" onclick="test4()">세번이상</button><br>'+
					'</span>'+
				'		조모임 <br>'+
				'<input type="hidden" id="team">'+
				'	<span id="teamlist">'+
					'<button class="selectbtn" type="button" onclick="team1()">없음</button>'+
					'<button class="selectbtn" type="button" onclick="team2()">보통</button>'+
					'<button class="selectbtn" type="button" onclick="team3()">많음</button><br>'+
					'</span>'+
				'	<br>'+
				'	</div>'+
				'</div>'+
				'<div class="row">'+
				'	<div class="col-md-3" >'+
				'		총평<br>'+
				'<input type="hidden" id="star">'+
				'	<span id="starlist">'+
				'		<img class="별" alt="" src="img/회색별.png" onclick="star1()">'+
				'		<img class="별" alt="" src="img/회색별.png" onclick="star2()">'+
				'		<img class="별" alt="" src="img/회색별.png" onclick="star3()">'+
				'		<img class="별" alt="" src="img/회색별.png" onclick="star4()">'+
				'		<img class="별" alt="" src="img/회색별.png" onclick="star5()"><br>'+
					'</span>'+
				'		<br>'+
				'	</div>'+
				'	<div class="col-md-9">'+
				'		<textarea class="textarea" rows="10" cols="100%" id="text" placeholder="이 강의에 대한 총평을 작성해주세요.                                                                            (등록 후에는 수정 및 삭제가 불가능하므로 신중히 적어주세요.)"></textarea><br>'+
				'	</div>'+
			'	</div>'+
			'</div>'+
			'<button class="submitbtn" type="button" onclick="reviewsubmit()">완료</button>'
			}
			
			$("#tableviewbox").html( tr );
}

////////////////////////////////////과제버튼//////////////////////////////////////////////////////////////////
function home1(){
	$("#homework").val(1);
	$("#homelist").html( 
		'<span id="homelist">'
		+'<button class="home1" type="button" onclick="home1()">없음</button>'+
		'<button class="selectbtn" type="button" onclick="home2()">보통</button>'+
		'<button class="selectbtn" type="button" onclick="home3()">많음</button><br>'+
		'</span>'
	 );
}


function home2(){
	$("#homework").val(2);
	$("#homelist").html( 
		'<span id="homelist">'
		+'<button class="selectbtn" type="button" onclick="home1()">없음</button>'+
		'<button class="home1" type="button" onclick="home2()">보통</button>'+
		'<button class="selectbtn" type="button" onclick="home3()">많음</button><br>'+
		'</span>'
	 );
}



function home3(){
	$("#homework").val(3);
	$("#homelist").html( 
		'<span id="homelist">'
		+'<button class="selectbtn" type="button" onclick="home1()">없음</button>'+
		'<button class="selectbtn"  type="button" onclick="home2()">보통</button>'+
		'<button class="home1" type="button" onclick="home3()">많음</button><br>'+
		'</span>'
	 );
}



///////////////////////////////////////////////////과제횟수////////////////////////////////////////////////////
function test1(){
	$("#test").val(1);
	$("#testlist").html( 
		'	<span id="testlist">'+
					'<button class="home1" type="button" onclick="test1()">없음</button>'+
					'<button class="selectbtn" type="button" onclick="test2()">한번</button>'+
					'<button class="selectbtn" type="button" onclick="test3()">두번</button>'+
					'<button class="selectbtn" type="button" onclick="test4()">세번이상</button><br>'+
			'</span>'
	 );
}

function test2(){
	$("#test").val(2);
	$("#testlist").html( 
		'	<span id="testlist">'+
					'<button class="selectbtn" type="button" onclick="test1()">없음</button>'+
					'<button class="home1" type="button" onclick="test2()">한번</button>'+
					'<button class="selectbtn" type="button" onclick="test3()">두번</button>'+
					'<button class="selectbtn" type="button" onclick="test4()">세번이상</button><br>'+
			'</span>'
	 );
}

function test3(){
	$("#test").val(3);
	$("#testlist").html( 
		'	<span id="testlist">'+
					'<button class="selectbtn" type="button" onclick="test1()">없음</button>'+
					'<button class="selectbtn" type="button" onclick="test2()">한번</button>'+
					'<button class="home1" type="button" onclick="test3()">두번</button>'+
					'<button class="selectbtn" type="button" onclick="test4()">세번이상</button><br>'+
			'</span>'
	 );
}

function test4(){
	$("#test").val(4);
	$("#testlist").html( 
		'	<span id="testlist">'+
					'<button class="selectbtn" type="button" onclick="test1()">없음</button>'+
					'<button class="selectbtn" type="button" onclick="test2()">한번</button>'+
					'<button class="selectbtn" type="button" onclick="test3()">두번</button>'+
					'<button class="home1" type="button" onclick="test4()">세번이상</button><br>'+
			'</span>'
	 );
}


/////////////////////////조모임////////////////////////////////
function team1(){
	$("#team").val(1);
	$("#teamlist").html( 
	'	<span id="teamlist">'+
				'<button class="home1" type="button" onclick="team1()">없음</button>'+
				'<button class="selectbtn" type="button" onclick="team2()">보통</button>'+
				'<button class="selectbtn" type="button" onclick="team3()">많음</button><br>'+
		'</span>'
	 );
}
function team2(){
	$("#team").val(2);
	$("#teamlist").html( 
	'	<span id="teamlist">'+
				'<button class="selectbtn" type="button" onclick="team1()">없음</button>'+
				'<button  class="home1" type="button" onclick="team2()">보통</button>'+
				'<button class="selectbtn" type="button" onclick="team3()">많음</button><br>'+
		'</span>'
	 );
}
function team3(){
	$("#team").val(3);
	$("#teamlist").html( 
	'	<span id="teamlist">'+
				'<button class="selectbtn" type="button" onclick="team1()">없음</button>'+
				'<button class="selectbtn" type="button" onclick="team2()">보통</button>'+
				'<button  class="home1" type="button" onclick="team3()">많음</button><br>'+
		'</span>'
	 );
}


/////////////////별//////////////////////////

function star1(){
	$("#star").val(1);
	$("#starlist").html( 
		'	<span id="starlist">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star1()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star2()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star3()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star4()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star5()"><br>'+
		'</span>'
	 );
}
function star1(){
	$("#star").val(1);
	$("#starlist").html( 
		'	<span id="starlist">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star1()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star2()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star3()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star4()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star5()"><br>'+
		'</span>'
	 );
}
function star2(){
	$("#star").val(2);
	$("#starlist").html( 
		'	<span id="starlist">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star1()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star2()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star3()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star4()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star5()"><br>'+
		'</span>'
	 );
}
function star3(){
	$("#star").val(3);
	$("#starlist").html( 
		'	<span id="starlist">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star1()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star2()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star3()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star4()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star5()"><br>'+
		'</span>'
	 );
}
function star4(){
	$("#star").val(4);
	$("#starlist").html( 
		'	<span id="starlist">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star1()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star2()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star3()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star4()">'+
			'		<img class="별" alt="" src="img/회색별.png" onclick="star5()"><br>'+
		'</span>'
	 );
}
function star5(){
	$("#star").val(5);
	$("#starlist").html( 
		'	<span id="starlist">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star1()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star2()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star3()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star4()">'+
			'		<img class="별" alt="" src="img/노란별.png" onclick="star5()"><br>'+
		'</span>'
	 );
}



/////////////////////////////////강의평제출
function reviewsubmit(){
	let team = $("#team").val();
	let star = $("#star").val();
	let test = $("#test").val();
	let home = $("#homework").val();
	let text = $("#text").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
	let lno = $("#lno").val();
	if(homework==""){alert("과제여부를 선택해주세요");return;}
	else if(team==""){alert("조모임을 선택해주세요");return;}
	else if(star==""){alert("별을 1~5 중 선택해주세요");return;}
	else if(test==""){alert("시험횟수를 선택해주세요");return;}
	else if(text==""){alert("총평을 입력해주세요");return;}
	else{
		$.ajax({
			url: "/team3/review/reviewadd",
			data: {"lno": lno ,"home": home , "test": test,"team": team, "star" :star , "text": text},
			success: function(re){
				if(re==1){
					alert("강의평등록완료");
					location.href = "/team3/review/reviewlist.jsp" ;
				}
				else{alert("강의평등록실패");}
			}
		});
	}
}


