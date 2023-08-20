<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sns.jsp</title>
</head>
<body>
	<c:if test="${curPage != 1 }">
		<table id="snsL">
			<tr>
				<td align="center" onclick="snsPageChange(${curPage - 1 });">&lt;</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${curPage != allPageCount }">
		<table id="snsR">
			<tr>
				<td align="center" onclick="snsPageChange(${curPage + 1 });">&gt;</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${sessionScope.loginMember != null }">
		<table id="snsWriteArea">
			<tr>
				<td>
					<form action="sns.search" name="snsSearchForm" method="POST"
						onsubmit="return snsSearchCheck();">
						<table id="snsSearchTable">
							<tr>
								<td id="sstTd1"><input name="search" maxlength="10"
									autocomplete="off" placeholder="찾기"></td>
								<td id="sstTd2"><input type="image"
									src="resources/img/search.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
				<td id="snsWriteAreaSummoner" align="center" rowspan="2"
					style="background-color: #191970; border-radius: 0px 20px 20px 0px; cursor: pointer;">
					<img src="resources/img/menu.png" style="width: 30px"onclick="return connectSNSWriteAreaSummonEvent();">
				</td>
			</tr>
			<tr>
				<td align="center">
					<form action="sns.write" name="snsWriteForm" method="POST">
						<input name="token" value="${token }" type="hidden">
						<table id="snsWriteTable">
							<tr>
								<td id="swtTd1"><textarea name="p_txt" placeholder="내용"
										maxlength="250"></textarea></td>
								<td id="swtTd2"><input type="image"
									src="resources/img/write.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	<c:forEach var="sm" items="${msgs }">
		<table class="sm" style="box-shadow: 5px 5px 5px ${sm.p_color};">
			<tr>
				<td rowspan="5" align="center" valign="top" style="width: 95px;">
					<img class="smPhoto" src="resources/img/${sm.p_photo }"
					style="box-shadow: 3px 3px 3px ${sm.p_color};">
				</td>
				<td class="smOwner" style="color: ${sm.p_color};">${sm.p_owner }</td>
			</tr>
			<tr>
				<td class="smDate" align="right"><fmt:formatDate
						value="${sm.p_when }" type="both" dateStyle="long"
						timeStyle="short" /></td>
			</tr>
			<tr>
				<td class="smTxt"><textarea id="formerTxt">${sm.p_txt }</textarea></td>
			</tr>
			<tr>
				<td id="smReplyArea"><c:forEach var="sr"
						items="${sm.p_replys }">
						<c:choose>
							<c:when test="${sr.pr_owner == sessionScope.loginMember.p_id }">
								<span ondblclick="snsReplyDelete('${sr.pr_no}');"
									class="smReplyID" style="color:${sm.p_color}; cursor:pointer;">${sr.pr_owner }</span>
							</c:when>
							<c:otherwise>
								<span class="smReplyID" style="color:${sm.p_color}">${sr.pr_owner }</span>
							</c:otherwise>
						</c:choose>
						${sr.pr_txt }(<fmt:formatDate value="${sr.pr_when }" type="both"
							dateStyle="short" timeStyle="short" />)<br>
					</c:forEach> 
					<c:if test="${sessionScope.loginMember != null }">
						<hr color="${sm.p_color }">
						<form action="sns.reply.write" method="POST">
							<input name="token" value="${token }" type="hidden"> <input
								name="pr_p_no" value="${sm.p_no }" type="hidden"> <span
								class="" style="color:${sm.p_color}">${sessionScope.loginMember.p_id }</span>
							<input name="pr_txt"
								style="border-bottom:${sm.p_color} solid 2px;" maxlength="100"
								placeholder="댓글내용" autocomplete="off">
							<button style="color:${sm.p_color}; font-weight:900;">쓰기</button>
						</form>

					</c:if></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><c:if
						test="${sm.p_owner == sessionScope.loginMember.p_id }">
						<button onclick="snsMsgUpdate(${sm.p_no}, '${sm.p_txt }');"
							style="color: ${sm.p_color};" id="updateBtn">수정</button>
						<button onclick="snsMsgDelete(${sm.p_no});"
							style="color: ${sm.p_color};">삭제</button>
					</c:if></td>
			</tr>
		</table><br>
	</c:forEach>

</body>
</html>