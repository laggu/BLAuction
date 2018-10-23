/**
 * 
 */


function setDeliveryCode(){
	//모달 보여주고
	var auct_id = $("#successAuct_id").val();
	var deliveryCode = $("#invoiceNum").val();
	var companyCode = $("#companyCode").val();
	$.ajax({
		type:'POST',
		url:'deliveryimpl.bla',
		data:{
			"delivery_code": deliveryCode,
			"company_code": companyCode,
			"auct_id": auct_id
		},
		datatype:'json',
		success:function(data){
			var deliveryCode = $('#winnerInvoice'+data.auct_id);
			var companyCode = $('#winnerDeliverycompany'+data.auct_id);
			
			//var deliveryStatus = $('#winnerDeliverycompany'+data.auct_id);
			
			var deliveryCodeVal = data.delivery_code;
			var companyCodeVal = data.company_code;
			//var deliveryStatusVal = data.delivery_status;
			
			companyCode.text(companyCodeVal);
			deliveryCode.text(deliveryCodeVal);
			
			$('#deliveryInfoModal').modal('hide');
		},
		error:function(data){
			alert("택배에러")
		}
	})
}


function getDeliveryStatus(index, auction_address){
//	var companyCode = $("#companyCode"+index).text();
//	var deliveryCode = $("#deliveryCode"+index).text();
	
	var companyCode = '04';
	var deliveryCode = '346409383282';
		
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
			var s;
			switch (data.level) {
			  case "1":
				  s = "배송준비중"
			    break;
			  case "2":
				  s = "집화완료"
			    break;
			  case "3":
				  s = "배송중"
			    break;
			  case "4":
				  s = "지점 도착"
			    break;
			  case "5":
				  s = "배송출발"
			    break;
			  case "6":
				  setDeliveryStatus(auction_address);
				  s = "배송 완료"
			    break;
			}
			$("#Delivery_Status"+index).text(s);
		},
		error:function(data){
			alert('error');
		}
	})
}