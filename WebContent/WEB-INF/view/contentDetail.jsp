<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$("#del").click(function(e){
		e.preventDefault();
		var result = confirm("정말 삭제하시겠습니까?");
		var number = ${item.number};
		if(result == true){
			location.href = "delete.do?no=" + number;	
		}
	});
});
</script>
<style>
td{
	width: 700px;
}
table{
	border-collapse: collapse;
}
</style>
</head>
<body>
<table border="1">
<c:set var="item" value="${aclist }"></c:set>
<c:set var="item2" value="${acclist }"></c:set>	
	<tr>
		<th>번호</th>
		<td>${item.number }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${item.name }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${item.title }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${item2.content }</td>
	</tr>
	
	
</table>
<hr>
<a href="listart.do">목록</a>
<c:if test="${userAuth == item.id }">
<a href="modify.do?no=${item.number }">[게시글수정]</a>
<a href="delete.do?no=${item.number }" id="del">[게시글삭제]</a>
</c:if>
</body>
</html>