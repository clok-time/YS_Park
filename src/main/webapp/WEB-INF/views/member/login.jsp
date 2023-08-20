<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<table id="loginTbl"  align="right">
		<form action="member.login" method="POST">
			<tr>
				<td colspan="2">ID:  <input name="p_id" autocomplete="off" ></td>
			</tr>
			<tr>
				<td colspan="2">PW: <input name="p_pw" type="password"></td>
			</tr>
			<tr>
				<td align="center"><button>Log In</button>
		</td>
		</form>
		<td align="center">
			<button onclick="goJoin();">회원가입</button>
		</td>
		</tr>
	</table>
</body>
</html>