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
	$.ajax({
		url:"jsonMemberList.do",
		type:'get',
		dataType:"json",
		success:function(data){
			console.log(data);
			$(data).each(function(i, element) {
				var $liObj = $("<li>");
				$liObj.html(element.memberId);
				
				$("#test ul").append($liObj);
			})
		}
	})
});	
</script>
</head>
<body>
	<h1>Json Test</h1>
	<div id="test">
		<ul>
		</ul>
	</div>
</body>
</html>