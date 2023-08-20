<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>

</head>
<body>
	<h1>회원가입</h1>
	<form action="member.join" method="POST" enctype="multipart/form-data"
		onsubmit="return joinCheck();" name="joinForm">
		<table id="joinTbl">
			<tr>
				<td align="center" class="joinTd">아이디</td>
			</tr>
			<tr>
				<td align="center"><input name="p_id"
					placeholder="4~10자리 / 영문,숫자 사용 가능" maxlength="10"
					autofocus="autofocus" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"class="joinTd">비밀번호</td>
			</tr>
			<tr>
				<td align="center"><input name="p_pw" type="password"
					placeholder="8~16자리 / 영문 대소문자, 특수문자 조합" maxlength="16"
					autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"class="joinTd">비밀번호 확인</td>
			</tr>
			<tr>
				<td align="center"><input name="p_pwChk" type="password"
					placeholder="비밀번호와 동일하게 작성하세요" maxlength="16" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"class="joinTd">이름</td>
			</tr>
			<tr>
				<td align="center"><input name="p_name" placeholder="이름입력"
					maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"class="joinTd">주소</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
				
				<input id="join_p_addr1" name="p_addr1" placeholder="우편번호" class="i1" autocomplete="off"><br>
					
				<input id="join_p_addr2" name="p_addr2" placeholder="주소" class="i1" autocomplete="off"><br> 
					
				<input name="p_addr3" maxlength="50" placeholder="상세주소" class="i1" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center"class="joinTd">사진</td>
			</tr>
			<tr>
				<td align="center"><input name="p_photo" type="file" id="fileInput"></td>
			</tr>
			<tr>
				<td align="center" colspan="2" align="center"><button>가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>