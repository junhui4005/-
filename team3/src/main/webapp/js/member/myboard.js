let boardlist;

let viewcount = 10;
$(window).scroll(function(){
	if($(window).scrollTop() + 50 >= $(document).height() - $(window).height()){
		viewcount++; 
		view();
	}
});

$(function(){
	$.ajax({
		url : "/team3/member/myboardlist",
		success : function(jsonarray) {
			boardlist = jsonarray;  
			view();
		}
	});
})
function view() {
	let html ="";
	var today = new Date();
	formatDate(today);
	let date = formatDate(today);
	
	for(let i = 0; i<boardlist.length; i++) {
		if(boardlist[i]["bdate"].split(" ")[0]==date) {
			boardlist[i]["bdate"] = boardlist[i]["bdate"].split(" ")[1]
		} else {
			boardlist[i]["bdate"] = boardlist[i]["bdate"].split(" ")[0]
	}
		if( i >= viewcount ) break;
		html += 
		'<div class="boardbox" onclick="location.href=\'/team3/board/boardview.jsp?bno='+boardlist[i]["bno"]+'\'">'+
'			<div class="boardtitle">'+boardlist[i]["btitle"]+'</div>'+
'			<div class="boardinfo">'+boardlist[i]["bdate"]+' | 조회수 '+boardlist[i]["rcount"]+' | 추천수 '+boardlist[i]["blike"]+'</div>'+
'		</div>';
		
	}
	$("#myboardlist").html(html);
}
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
