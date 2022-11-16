$(function(){
	searchRanking($("#menuSearchRanking"));
});

function searchRanking(param){
	$(".chart").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#searchRanking").show();
	
	
	$.ajax({
		url: "/log/search/keyword",
		type: "GET",
		success: function(result){
			for(var i=10; i<70; i=i+10){
				for(var j=0; j<result.length; j++){
					if(result[j]['age'] == i+'대'){
						var searchTable = $('#searchTable tr .'+i);
						var view = result[j]['keyword'];
						searchTable.html(view);
					}					
				}
			}
		} //로그 반복문 해야함
	});	

};
//날짜별 좋아요 수 차트
function likeCount(param){
	
	$.ajax({
		url: "/log/likeCount/date",
		type: "GET",
		success: function(result){
			console.log(result);
			$(".chart").hide();
			var object = $(param);
			$(".log-nav-content").css("font-weight", "500");
			object.css("font-weight", "bold");
			$("#likeCount").show();
			
			const d = new Date();
			const year = d.getFullYear(); 
			const month = d.getMonth();   
			const day = d.getDate();     
			
			const date = [];
			const likeData = [0,0,0,0,0,0,0];
			for(var i=6; i>=0; i--){
				date.push(new Date(year, month, day - i).toLocaleDateString());
			}
			for(var j=0; j<result.length; j++){
				for(var k=0; k<7; k++){
					if(result[j]['logDate'] == date[k]){
						likeData[k] = result[j]['likeCount'];	
					}					
				}
			}
				 const data = {
				   labels: date,
				   datasets: [{
				     label: '좋아요 수',
				     backgroundColor: 'rgb(255, 99, 132)',
				     borderColor: 'rgb(255, 99, 132)',
				     data: likeData
				   }]
				 };
				
				 const config = {
				   type: 'line',
				   data: data,
				    options: {
				        scales: {
				            y: {
				                suggestedMin: 0,
				            }
				        }
				    }
				 };
				 const myChart = new Chart(
						 $("#likeCount"),
					    config
					  );	
		
		}
	});
	
	
};
//날짜별 방문자 수 차트
function visitorCount(param){
	$(".chart").hide();
	var object = $(param);
	$(".log-nav-content").css("font-weight", "500");
	object.css("font-weight", "bold");
	$("#visitorCount").show();
	
	const d = new Date();
	const year = d.getFullYear(); 
	const month = d.getMonth();   
	const day = d.getDate();     
	
	const date = [];
	for(var i=6; i>=0; i--){
		date.push(new Date(year, month, day - i).toLocaleDateString());
	}
	
		
		 const data = {
		   labels: date,
		   datasets: [{
		     label: '방문자 수',
		     backgroundColor: 'black',
		     borderColor: 'black',
		     data: [102, 43, 110, 55, 21, 20, 60]
		   }]
		 };
		
		 const config = {
		   type: 'line',
		   data: data,
		    options: {
		        scales: {
		            y: {
		                suggestedMin: 0,
		            }
		        }
		    }
		 };
		 const myChart = new Chart(
				 $("#visitorCount"),
			    config
			  );	
};
//성별
function genderRatio(param){
	$.ajax({
		url: "/log/likeCount/gender",
		type: "GET",
		success: function(result){
			var male = result['MALE'];			
			var female = result['FEMALE'];
			
			$(".chart").hide();
			var object = $(param);
			$(".log-nav-content").css("font-weight", "500");
			object.css("font-weight", "bold");
			$("#genderRatio").show();
			
			const data = {
			  labels: ['남자', '여자'],
			  datasets: [{
			    label: '좋아요 비율',
			    data: [Math.round(male/(male+female)*100), Math.round(female/(male+female)*100)],
			    backgroundColor: [
			      'rgba(36, 103, 203, 0.5)',
			      'rgba(233, 18, 90, 0.5)'
			    ],
			    borderColor: [
			      'rgb(36, 103, 203)',
			      'rgb(233, 18, 90)'
			    ],
			    borderWidth: 1
			  }]
			};
			
			const config = {
					  type: 'bar',
					  data: data,
					  options: {
					    scales: {
					      y: {
					    	  suggestedMin: 0,
					    	  suggestedMax: 100
					      }
					    }
					  },
					};
			 const myChart = new Chart(
					 $("#genderRatio"),
				    config
				  );	
		}
	});
}