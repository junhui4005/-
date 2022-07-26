
//사진 미리보기
$("#timg").change(function(e){
	let reader = new FileReader();
	reader.readAsDataURL(e.target.files[0]);
	reader.onload = function(e){
		$("#preview").attr("src",e.target.result);
	}
});
//사진 변경
function bimgupdate(){
	addimg();
	console.log($("#timg").val());
}
function bookadd(){
	let timg = $("#timg").val();
	let ttitle = $("#ttitle").val();
	let tcontent = $("#tcontent").val();
	let tprice = $("#tprice").val();
	let tcondition = $('input[tcondition]:checked').val();
	let tauthor = $("#tauthor").val();
	let tcompany = $("#tcompany").val();
	let tyear = $("#tyear").val();
	let tclass = $("#tclass").val();
	
	if(timg =="" ||ttitle =="" ||tcontent =="" ||tprice =="" ||tcondition =="" ||tauthor =="" ||tcompany =="" ||tyear =="" ||tclass ==""){
		alert("항목을 모두 입력해주세요");
		return false;
	}else{
		$("#bookform").submit();
	}
}