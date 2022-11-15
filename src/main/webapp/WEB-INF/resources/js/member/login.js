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
		 
	});