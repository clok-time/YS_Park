<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movieRank</title>

</head>
<body>
<div id="mBody">
	<table>
	
		<h1 id="h1Tag" onclick="goMovieRank();">Movie Rank</h1>
		<br>
		
		<br>
		<tr>
			<td><input id="movieInput" placeholder="ex)20220205"
				autocomplete="off" autofocus="autofocus">
				<button id="mBtn">Get Rank!</button></td>
		</tr>
	</table>
	<table id="rankTbl" style="opacity: 0;">
	</table>
	</div>
</body>
</html>