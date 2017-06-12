<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<script src="js/common.js"></script>
</head>
<body>
	<form name="f1" action="changepwd.do" method="post">
		<p>
			<label>현재 암호:</label><input type="password" name="password" value="">
			<span class="error">현재 암호를 입력하세요</span>
		</p>
		<p>
			<label>새 암호:</label><input type="password" name="chpassword" value="">
			<span class="error">새 암호를 입력하세요</span>
		</p>
		<p>
			<input type="submit" value="암호 변경">
		</p>
	</form>
<%-- 	<c:if test="${notJoin }">
	<p class="error2">회원이 아닙니다. 회원가입을 해주세요.</p>
	</c:if> --%>
	<c:if test="${noMatchPassword }">
		<p class="error2">비밀번호가 틀렸습니다. 다시 입력해주세요.</p>
	</c:if>	
</body>
</html>