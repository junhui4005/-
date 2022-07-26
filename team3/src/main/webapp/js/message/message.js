let jsonarray;
let jsonarray1;
function read(mnum){
		
		
	
	
			$.ajax({
			url : '/team3/message/getmessage' ,
			data: {"mnum": mnum},
			success : function( json ){
				jsonarray = json;	
				
				
				$.ajax({
				url : '/team3/message/read' ,
				data: {"mnum": mnum},
				success : function( result ){
					tableview();
					}
				});
				
				
	}});
	
}

function confirm(mnum){
		
		
	
			$.ajax({
			url : '/team3/message/sendmessage' ,
			data: {"mnum": mnum},
			success : function( json ){
				jsonarray1 = json;	
				tableview1();
				
				
	}});
	
}

function delete1(mnum){
	
	
	$.ajax({
			url : '/team3/message/deletemessage' ,
			data: {"mnum": mnum },
			success : function( result ){
				alert("메시지를 성공적으로 삭제했습니다.");
				location.reload();
			}
		});
}

function delete2(mnum){
	$.ajax({
			url : '/team3/message/deletemessage1' ,
			data: {"mnum": mnum },
			success : function( result ){
				alert("메시지를 성공적으로 삭제했습니다.");
				location.reload();
			}
		});
}

function tableview1(){
			let tr = '';
			let bt = '';
			for( let i = 0 ; i<jsonarray1.length; i++ ){
					
				tr += 
				'<div class="modal-body" id="mcontent1">'+
						'<div class="row"><div class="col-md-3"><span>'+jsonarray1[i]["mid"]+'님</span></div>'+
						'<div class="col-md-9 d-flex justify-content-end"><span>'+jsonarray1[i]["mtime"]+'</span></div></div>'+
				       	'<div><p class="p">'+jsonarray1[i]["mcontent"]+'</p></div>'+
			   ' </div>';
			  
			}
			for( let i = 0 ; i<jsonarray1.length; i++ ){
				
			   bt+=
			   '<button type="button" id="delete1" class="btn btn-primary btnpa" onclick="delete1('+jsonarray1[i]["mnum"]+')">삭제</button>'+
			  '<button type="button" id="send1" class="btn btn-primary" onclick="send1(\''+jsonarray1[i]["mid"]+'\','+jsonarray1[i]["mgetno"]+')">보내기</button>';
			   
			}
		
			$("#mcontent1").html( tr );
			$("#send1").html(bt );
}

function tableview(){
			let tr = '';
			let bt = '';
			for( let i = 0 ; i<jsonarray.length; i++ ){
					
				tr += 
				'<div class="modal-body" id="mcontent">'+
						'<div class="row"><div class="col-md-3"><span>'+jsonarray[i]["mid"]+'님</span></div>'+
						'<div class="col-md-9 d-flex justify-content-end"><span>'+jsonarray[i]["mtime"]+'</span></div></div>'+
				       	'<div><p class="p">'+jsonarray[i]["mcontent"]+'</p></div>'+
			   ' </div>';
			  
			}
			for( let i = 0 ; i<jsonarray.length; i++ ){
				
			   bt+=
			   '<button type="button" id="delete" class="btn btn-primary btnpa" onclick="delete2('+jsonarray[i]["mnum"]+')">삭제</button>'+
			  '<button type="button" id="send" class="btn btn-primary" onclick="send(\''+jsonarray[i]["mid"]+'\','+jsonarray[i]["msendno"]+')">답장</button>'
			   
			}
		
			$("#mcontent").html( tr );
			$("#send").html(bt );
}

function send(mid,sendno){
	$("#mcontent").html( 
	'<div class="modal-body" id="mcontent">'+
	'<div class="container">'+
			'<p>'+mid+'님</p>'+
			'<input type="hidden" id="getno" value="'+sendno+'">'+
			'<textarea class="ctext" rows="" cols="" id="content"></textarea>'+
		'</div>'+
	'</div>'
);
	$("#send").html( 
	 '<button type="button" id="send" class="btn btn-primary" onclick="reply()">답장</button>'
);

}

function send1(mid,sendno){
	$("#mcontent1").html( 
	'<div class="modal-body" id="mcontent1">'+
	'<div class="container">'+
			'<p>'+mid+'님</p>'+
			'<input type="hidden" id="getno1" value="'+sendno+'">'+
			'<textarea class="ctext" rows="" cols="" id="content1"></textarea>'+
		'</div>'+
	'</div>'
);
	$("#send1").html( 
	 '<button type="button" id="send1" class="btn btn-primary" onclick="reply1()">보내기</button>'
);


}

function reply(){
	let mcontent = $("#content").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
	let getno = $("#getno").val();
	
	if(mcontent==""){alert("메시지를 입력해주세요");}
	else{
	$.ajax({
			url : '/team3/message/send' ,
			data: {"getno": getno , "mcontent": mcontent },
			success : function( result ){
				alert("메시지를 성공적으로 보냈습니다.");
				location.reload();
			}
		});
	}
}
function reply1(){
	let mcontent =  $("#content1").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
	let getno = $("#getno1").val();
	if(mcontent==""){alert("메시지를 입력해주세요");}
	else{
	$.ajax({
			url : '/team3/message/send' ,
			data: {"getno": getno , "mcontent": mcontent },
			success : function( result ){
				alert("메시지를 성공적으로 보냈습니다.");
				location.reload();
			}
		});
	}
}

