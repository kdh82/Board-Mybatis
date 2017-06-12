<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<style>
form{
	width: 500px;
}
</style>
</head>
<body>
	<form action="write.do" method="post" name="f1">
		<p>
			<label>제목</label><input type="text" name="title">
			<span class="error">제목을 입력하세요</span>
		</p>
		<p>
			<label>내용</label><textarea rows="10" cols="50" name="content"></textarea>
			<span class="error">내용을 입력하세요</span>
		</p>
		<p>
			<input type="submit" value="추가">
		</p>
	</form>
</body>
</html>