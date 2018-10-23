/**
 * 
 */



function getDeliveryStatus(index, auction_address){
	var companyCode = $("#winnerDeliverycompany"+index).text();
	var deliveryCode = $("#winnerInvoice"+index).text();
		
	var params = {
			"t_key": 'A4LwNiLjK5hB69I9mWEs1Q',
			"t_code": companyCode,
			"t_invoice": deliveryCode
		}
	$.ajax({
		type:'GET',
		url:'http://info.sweettracker.co.kr/api/v1/trackingInfo/',
		data:params,
		datatype:'json',
		success:function(data){
			var s = '';
			var level = data.level;
			//ajax로 택배 status 변경
			$.ajax({
				type:'POST',
				url:'updateDeliveryStatus.bla',
				data:{
					"level":level,
					"auct_id":index
				},
				datatype:'json',
				success:function(data){
					alert("성공");
				},
				error:function(data){
					alert('error');
				}
			})
			
			switch (data.level) {
			  case 1:
				  s = "배송준비중"
			    break;
			  case 2:
				  s = "집화완료"
			    break;
			  case 3:
				  s = "배송중"
			    break;
			  case 4:
				  s = "지점 도착"
			    break;
			  case 5:
				  s = "배송출발"
			    break;
			  case 6:
				  s = "배송 완료"
				  $("#Delivery_Status"+index).text(s);
				  web3_setDeliveryStatus(auction_address);
			    break;
			}
		},
		error:function(data){
			alert('error');
		}
	})
}