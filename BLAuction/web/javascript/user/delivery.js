/**
 * 
 */

function setDeliveryCode(){
	//모달 보여주고
	var deliveryCode = $('#???').text();
	var companyCode = $('#???').text();
	var params = {
			"deliveryCode ": deliveryCode,
			"companyCode ": companyCode,
		}
	
	$.ajax({
		type:'POST',
		url:'jusoPopup.bla',
		data:params,
		datatype:'json',
		success:function(data){
			alert(data)
		},
		error:function(data){
			alert(data)
		}
	})
}


function getDeliveryStatus(index){
	var companyCode = $("#companyCode"+index).text();
	var deliveryCode = $("#deliveryCode"+index).text();
	
	var params = {
			"t_key": '',
			"t_code": companyCode,
			"t_invoice": deliveryCode
		}
	$.ajax({
		type:'POST',
		url:'http://info.sweettracker.co.kr/api/v1/trackingInfo',
		data:params,
		datatype:'json',
		success:function(data){
			alert(data)
		},
		error:function(data){
			alert(data)
		}
	})
}