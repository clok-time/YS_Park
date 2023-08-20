<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/home.css">
<link rel="stylesheet" href="resources/css/movie.css">
<link rel="stylesheet" href="resources/css/join.css">

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/Park_jQuery.js"></script>
<script type="text/javascript" src="resources/js/ParkValidChecker.js"></script>
<script type="text/javascript" src="resources/js/ParkChecker.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<h1>Movie Park</h1>
	<table id="siteMenuArea">
		<tr>
			<td align="center"><table id="siteMenuArea2">
					<tr>
						<td align="center"><a href="/project2">HOME</a></td>
						<td align="center"><a href="sns.go">SNS</a></td>
						<td align="center"><a href="movie.go">Movie Rank</a></td>
					</tr>
				</table></td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td><div id="r">${r }</div></td>
			</tr><tr>
			<td><jsp:include page="${loginPage }" /></td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center"><jsp:include page="${contentPage }" /></td>
		</tr>
	</table>
</body>
</html>