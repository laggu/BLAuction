/**
 * 
 */



function getDeliveryStatus(index, auction_address, deliveryCode, companyCode){
		
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
				},
				error:function(data){
					alert('택배 상태 변경 error');
				}
			})

			switch (data.level) {
			  case 1:
				  s = "배송 준비중입니다."
			    break;
			  case 2:
				  s = "집화 완료되었습니다."
			    break;
			  case 3:
				  s = "배송중입니다."
			    break;
			  case 4:
				  s = "지점에 도착하였습니다."
			    break;
			  case 5:
				  s = "배송이 출발하였습니다."
			    break;
			  case 6:
				  s = "배송이 완료되었습니다."
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