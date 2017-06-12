<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="item" value="${aclist }"></c:set>
	<c:if test="${!empty userAuth }">		<!-- 로그인 -->
		${userAuth }님. 반갑습니다.
		<a href="logout.do">로그아웃</a>
		<a href="changepwd.do">암호변경</a>
		<a href="listart.do">게시글 목록 보기</a>
		<a href="write.do">게시글작성</a>
	</c:if>
	<c:if test="${empty userAuth }"> <!-- 로그인 하기전 -->
	<a href="join.do">회원가입</a>
	<a href="login.do">로그인</a>
	</c:if>
	<c:if test="${userAuth.equals('master') }">
	<a href="list.do">회원보기</a>
	</c:if>
	<!-- <script>
		location.href = "list.do";
	</script> -->

</body>
</html>