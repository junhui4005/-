
let boardlist;
let comentcount;
$( function(){
	getboardlist();
	 $("input").keyup(function() {
                   getsearchlist()
                });
	

}); 



let viewcount = 10; // 현재 화면에 보이는 주문 개수 

// 스크롤 이벤트 
let sss =$(window).scroll( function(){ 
	
	// 만약에 스크롤이 바닥에 닿았을때 계산 
		// $(window).scroll : 브라우저(인터넷창) 스크롤
		// $(window).scrollTop() : 스크롤막대의 상단 위치
		// $(document).height() : 현재 보고 있는 문서내 높이 
		// $(window).height() : 현재 보고 있는 화면 높이 
	if( $(window).scrollTop() >= $(document).height() - $(window).height()  ){
		// 현재 스크롤의 상단 위치  >=  현재 보고 있는 문서내 높이   -  현재 보고 있는 화면 높이 
		viewcount++; // 스크롤 바닥에 닿을때 마다 출력하는 주문개수를 증가
		view(); // 새로고침
		
	}
});



function getboardlist(){
	$.ajax({ 
		url : "/team3/board/boardlist" , 
		success : function( result ){
			boardlist = result;   console.log( boardlist );
			//alert(boardlist.length)
			view();
			
		}
	});
}





function getsearchlist(){
	
	
	let key = $("#key").val()
	let keyword = $("#keyword").val()
		$.ajax({ 
		url : "/team3/board/boardlist" ,
		data : {"key" : key, "keyword" : keyword}, 
		success : function( result ){
			boardlist = result;   console.log( boardlist );
			//alert(boardlist.length)
			//searchview();
			
			view();
		}
	});
	
}


function boardbest() {
	
	$.ajax({
		url : "/team3/board/bestlist",
		
		success : function (result) {
			boardlist = result;
			view();
		}
	});
}

function view() {
	let html ="";
	
	var today = new Date();
	formatDate(today);
	let date = formatDate(today);
	
	
	
	
	for(let i = 0; i<boardlist.length; i++) {
		console.log("ㄴ스플릿"+boardlist[i]["bdate"])
		console.log("스플릿"+boardlist[i]["bdate"].split(" ")[1])
	
	if(boardlist[i]["bdate"].split(" ")[0]==date) {
		boardlist[i]["bdate"] = boardlist[i]["bdate"].split(" ")[1]
		
	} else {
		boardlist[i]["bdate"] = boardlist[i]["bdate"].split(" ")[0]
	}
	
		
		if( i >= viewcount ) break; // 만약에 i가 화면에 표시할 주문수와 동일하면 출력 금지 
		html += 
		'<div id="list" style="cursor: pointer;" onclick="location.href=\'boardview.jsp?bno='+boardlist[i]["bno"]+'\'">'+
		'<span style="font-size : 12px; color:#999; float:right; margin-right:10px;margin-top: 5px; margin-bottom: 35px;" >' +boardlist[i]["bdate"]+  '</span>'+
		'<div style="margin-top:5px; margin-bottom: 5px;">'+
		'<span style="font-size : 20px;">'+boardlist[i]["btitle"]+'</span>'+
		
		'</div>'+
		'<span style="font-size:12px; padding-left:10px;">'+boardlist[i]["bnickname"]+'</span>'+
		'<div style="margin-top: 5px; margin-bottom: 5px;">'+
		'<span id="like"><i class="far fa-thumbs-up"></i> '+boardlist[i]["blike"]+' </span>'+
		'<span id="coment" style="margin-left :15px;"><i class="far fa-comment-alt"></i> '+boardlist[i]["rcount"]+' </span>'+
		'</div>'+
		'</div>'
		
	}
	$("#listbox").html(html);
}

/*
function view2() {
	let html ="";
	
	for(let i = 0; i<searchlist.length; i++) {
		if( i == viewcount ) break; // 만약에 i가 화면에 표시할 주문수와 동일하면 출력 금지 
		html += 
		'<div class="list"> '+
		'<h2>'+searchlist[i]["btitle"]+'</h2>'+
		'<span>'+searchlist[i]["bnickname"]+'</span><span>'+searchlist[i]["bdate"]+'</span>'+
		'</div>'
		
	}
	$("#listbox").html(html);
}
*/

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}





