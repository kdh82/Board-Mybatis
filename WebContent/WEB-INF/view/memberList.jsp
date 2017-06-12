<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bm.css">
</head>
<body>
	<a href="join.do">회원가입하기</a>
	<a href="index.jsp">초기화면</a>
	<br>
	<hr>
	<!-- page 영역에 viewDate가 선언 -->
	<%-- 	<c:set var="viewDate" value="<%=viewDate %>"/> --%>
	<c:if test="${viewData.size() == 0 }">
		등록된 메시지가 없습니다.
	</c:if>
	<c:if test="${viewData.size() > 0 }">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>비번</td>
				<td>가입날짜</td>
			</tr>
			<c:forEach var="item" items="${viewData}">
				<tr>
					<td>${item.memberId }</td>
					<td>${item.name }</td>
					<td>${item.password }</td>
					<td>${item.regDate }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>