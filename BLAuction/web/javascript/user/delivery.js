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
			var s = 'data.complete ' + data.complete + '\n' +
					'data.invoiceNo ' + data.invoiceNo + '\n' +
					'data.orderNumber ' + data.orderNumber + '\n' +
					'data.itemName ' + data.itemName + '\n' +
					'data.receiverName ' + data.receiverName + '\n' +
					'data.receiverAddr ' + data.receiverAddr + '\n' +
					'data.result ' + data.result + '\n' +
					'data.productInfo ' + data.productInfo + '\n' +
					'data.adUrl ' + data.adUrl + '\n' +
					'data.level ' + data.level + '\n' +
					'data.lastDetail ' + data.lastDetail + '\n' +
					'data.lastStateDetail ' + data.lastStateDetail + '\n' +
					'data.estimate ' + data.estimate + '\n';
			for(td in data.trackingDetails){
				var temp = '\n{' + td + ' ';
				for(t in td){
					temp += t;
				}
				temp += '}\n'; 
				s += temp;
			}
			alert(s);
			var str = '';
			for(var d in data){
				if(typeof d == 'object'){
					for(var f in d){
						str += d + '.' + f + ' ' + data[d][f] + '\n';
					}
				}
				else{
					str += d + ' ' + data[d] + '\n';
				}
			}
			alert(str);
		},
		error:function(data){
			alert('error');
		}
	})
}