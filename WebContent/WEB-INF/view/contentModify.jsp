<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modify.do" method="post">
		<label>번호:</label><br>
		<input type="text" name="id" value="${article.number }" readonly="readonly"><br> 
		<label>제목:</label><br>
		<input type="text" name="title" value="${article.title }" readonly="readonly"><br> 
		<label>제목:</label><br>		
		<textarea rows="5" cols="100" name="content">${articlecontent.content }</textarea><br>	
		<input type="submit" value="글 수정">	 
</form>

</body>
</html>