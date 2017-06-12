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
	<a href="index.jsp">초기화면</a>
	<a href="write.do">[게시글쓰기]</a>
	<hr>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>

		</tr>
		<c:forEach var="item" items="${contentData }">
			<tr>

				<td>${item.number }</td>
				<td><a href="read.do?no=${item.number }">${item.title }</a></td>
				<td>${item.name }</td>
				<td>${item.readCount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>