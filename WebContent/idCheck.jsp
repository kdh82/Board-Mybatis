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
			url:"idCheck.do",
			type:'get',
			dataType:"json",
			data:{"id":$("input[name='id']").val()},
			success:function(data){
				console.log(data);
				
				var result = (data.result);
				
				if(result == "duplicated"){
					$("#result").html("아이디가 있습니다.");
				}else{
					$("#result").html("사용가능한 아이디입니다.");
				}
			}
		});
	});
});
</script>
</head>
<body>
	<h1>중복 ID 테스트</h1>
	<div>
		<input type="text" name="id">
		<button id="btn">중복체크</button>
	</div> 
	<p id="result"></p>
</body>
</html>