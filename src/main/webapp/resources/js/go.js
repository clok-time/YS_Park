/**
 * go.js
 */

function goJoin() {
	location.href = "member.join.go";
}

function goInfo() {
	location.href = "member.info.go"
}
function goLogOut() {
	var logout = confirm("로그아웃 하시겠습니까?");
	if (logout) {

		location.href = "member.logout"
	}
}
function goSignOut() {
	var sss = confirm("회원을 탈퇴하시겠습니까?");
	if (sss) {
		var www = confirm("정말로 탈퇴하시겠습니까?")
		if (www) {

			location.href = "member.signout";
		}
	}
}
function goMovieRank(){
	location.href="movie.go";
}

function snsMsgDelete(no){
	if (confirm("삭제하시겠습니까?")) {
		location.href="sns.delete?p_no="+no;
	}
}
function snsMsgUpdate(no, txt){
	if (confirm("수정하시겠습니까?")) {
		location.href="sns.update?p_no="+no+"&p_txt="+txt;
	}
}
function snsReplyDelete(no){
if (confirm("삭제하시겠습니까?")) {
	
	location.href="sns.reply.delete?pr_no="+no;
	}
}
function snsPageChange(page){
	location.href="sns.page.change?p="+page;
}
