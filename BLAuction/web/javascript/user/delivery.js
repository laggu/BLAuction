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