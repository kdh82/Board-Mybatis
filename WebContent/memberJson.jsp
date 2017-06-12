<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
	$("#btn").click(function(){
		$.ajax({
			url:"jsonMemberId.do",
			type:'get',
			data:{"id": "master"},    //데이터 불러올곳 key, 값
			dataType:"json",
			success:function(data){
				console.log(data);
				var id = " id : " + data.memberId + "<br>";
				var name = " name : " + data.name + "<br>";
				var pass = " pass : " + data.password + "<br>";
				/* $(data).each(function(i, element) {
					var $pObj = $("<p>");
					$pObj.html(element.memberId);
					$pObj.html(element.name);
					$pObj.html(element.password); */
					$("#test").append(id);
					$("#test").append(name);
					$("#test").append(pass);
				}
			
		});
	});
});
</script>
</head>
<body>
	<h1>Json Test</h1>
	<button id="btn">회원 가져오기</button>
	<div id="test">
	</div>
</body>
</html>