function checkInputEmpty($obj){
	var count = 0;
	// i : index
	// element: object
	// 제이쿼리 each에서는 if문은 밖으로 나와야 됨 리턴 펄스는 나와야됨
	$obj.each(function(i, element) {
		if($(element).val() == ""){
			var $next = $(element).next(".error");
			$next.css("display","block");
			count++;
			//return false; //break;
		}
	})
	if(count > 0 ){
		return false;
	}
	return true;
}