<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
</head>
<body>
	<table id="joinTbl">
		<form action="member.update" method="post"
			enctype="multipart/form-data" onsubmit="return memberUpdateCheck();"
			name="memberUpdateForm">
			<tr>
				<th>ID</th>
				<td align="center" colspan="2"><input
					value="${sessionScope.loginMember.p_id }" name="p_id"
					placeholder="ID" class="i1" autocomplete="off" readonly="readonly"
					autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td align="center" colspan="2"><input type="password"
					value="${sessionScope.loginMember.p_pw }" name="p_pw"
					placeholder="PW" class="i1" autocomplete="off" maxlength="16"></td>
			</tr>
			<tr>
				<th>PW 확인</th>
				<td align="center" colspan="2"><input type="password"
					value="${sessionScope.loginMember.p_pw }" name="p_pwChk"
					placeholder="PW" class="i1" autocomplete="off" maxlength="16"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td align="center" colspan="2"><input
					value="${sessionScope.loginMember.p_name }" name="p_name"
					placeholder="이름" class="i1" autocomplete="off" maxlength="10"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td align="center" colspan="2"><input id="join_p_addr1"
					value="${addr[0]}" name="p_addr1" placeholder="우편번호" class="i1"
					autocomplete="off" readonly="readonly"><br> <input
					name="p_addr2" value="${addr[1] }" placeholder="주소"
					autocomplete="off" readonly="readonly"><br> <input
					name="p_addr3" value="${addr[2] }" placeholder="상세주소"
					autocomplete="off"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td align="center" style="width: 100px;"></td>
				<td><br>
				<img src="resources/img/${sessionScope.loginMember.p_photo }"
					style="max-width: 30%;"><br> 
					<input name="p_photo"
					type="file" style="font-size: 13pt;" src="resources/img/${sessionScope.loginMember.p_photo }"></td>
			</tr>
			<tr>
				<td style="" colspan="2" align="center"><button>수정</button></td></tr>
		</form>
		<tr>
		<td colspan="2" align="center">
			<button onclick="return goSignOut();" >탈퇴</button>
		</td>
		</tr>

	</table>
</body>
</html>