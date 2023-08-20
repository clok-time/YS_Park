<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess.jsp</title>
</head>
<body>
	<table id="loginSuccessTbl" align="right">
		<tr>
			<td><img id="loginMemberImg"
				src="resources/img/${sessionScope.loginMember.p_photo }"></td>
		</tr>
		<tr>
			<td id="loginMemberID" align="center">${sessionScope.loginMember.p_name }</td>
		</tr>
		<tr>
			<td align="right"><button onclick="return goInfo();">회원정보</button>
				<button onclick="return goLogOut();">로그아웃</button></td>

		</tr>
	</table>
</body>
</html>