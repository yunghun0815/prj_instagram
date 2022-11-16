	$(function(){
		//0~3
		var idx = 0;
		var object = $(".phone_inner img");
		setInterval( fadeImage, 5000);
		
		function fadeImage(){
			/* object.css("display", "none"); */
			$(".phone_inner img:not(:nth-child("+ idx +"))").css("display", "none");
			object.eq(idx).fadeIn(3000);
			if(idx == 3){
				idx = 0
			}else{
				idx += 1;
			}
			object.eq(idx).fadeOut(3000);
		}
		$(".submit").click(function () {
			let memberId = $('#memberId').val();
			let password = $('#password').val();
			
			$.ajax({
				url : "/member/loginCheck",
				type : "post",
				data : {
					memberId : memberId,
					passowrd : passowrd
				},
				dataType : 'json',
				success : function() {
					
				} 
			})
	 	})	 
	});