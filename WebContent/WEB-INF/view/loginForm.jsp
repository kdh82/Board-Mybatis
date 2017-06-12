<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
</script>
<script src="js/common.js">  // 제이쿼리 먼저들어가고 난 이후에 제이쿼리 함수들어간 파일
</script>
<script>
$(function(){
	$("form[name='f1']").submit(function(){
		if(checkInputEmpty($("input[name]")) == false){
			return false;
		}
	});
	
	$("#join").click(function() {
		location.href = "join.do";
	})
});
</script>
</head>
<body>
	<form name="f1" action="login.do" method="post">
		<p>
			<label>아이디</label><input type="text" name="id" value="">
			<span class="error">ID를 입력하세요</span>
		</p>
		<p>
			<label>암호</label><input type="password" name="password">
			<span class="error">Password를 입력하세요</span>
		</p>
		<p>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" id="join">
		</p>
	</form>
	<c:if test="${notJoin }">
	<p class="error2">회원이 아닙니다. 회원가입을 해주세요.</p>
	</c:if>
	<c:if test="${noMatchPassword }">
		<p class="error2">비밀번호가 틀렸습니다. 다시 입력해주세요.</p>
	</c:if>
</body>
</html>