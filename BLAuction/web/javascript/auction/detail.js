// 필요 작성 기능
// 1. 초기 데이터 뿌리기 ----- 서버사이드 에서 실행
// 2. 경매 입찰 ---- by web3 and ajax
// 3. 실시간으로 경매 시간 refresh. 서버시간 이용하기!
// 4. 내림 경매일 경우 시간이 지남에 따라 가격 변동 보여주기
// 5. 비밀 경매의 경우 한 사람이 여러번 입찰 하는 것이 필요 할 거 같음
//       --- 그러면 올림 경매일 경우에는??
// 6. 입찰 버튼 클릭시 입찰 모달 보여주기 ----- 경매 종류에 따라 다르게

var date;
var dtA;
var timeInterval;


function srvTime(auct_id) {
	  $.ajax({
	    type: 'GET',
	    cache: false,
	    url: '/timestamp.bla',
	    complete: function (req, textStatus) {
	      var dateString = req.getResponseHeader('Date');
	      if (dateString.indexOf('GMT') === -1) {
	        dateString += ' GMT';
	      }
	      date = new Date(dateString);
	      var timediff = dtA.getTime() - date.getTime();
	      
	      if(timediff <= 0){
	          $("#currentTimelimit").text('경매완료');
	          window.clearInterval(timeInterval);
  			  window.location.reload();
  			  
	          return;
	      }
	      
	      timediff /= 1000;
	      var s = '';
	      
	      if(parseInt(timediff/86400) >= 1){
	      	s += parseInt(timediff/86400) + '일 '
	          timediff %= 86400;
	      }
	      if(parseInt(timediff/3600) >= 1){
	      	s += parseInt(timediff/3600) + '시간 '
	          timediff %= 3600;
	      }
	      if(parseInt(timediff/60) >= 1){
	      	s += parseInt(timediff/60) + '분 '
	          timediff %= 60;
	      }
	      s += Math.floor(timediff) + '초';
	      $("#currentTimelimit").text(s);
	      $("#currentTimelimitModal").text(s);
	    }
	  });
}

function getTimeStamp(d) {
	  var s =
	    leadingZeros(d.getMonth() + 1, 2) + '-' +
	    leadingZeros(d.getDate(), 2) + ' ' +

	    leadingZeros(d.getHours(), 2) + ':' +
	    leadingZeros(d.getMinutes(), 2) + ':' +
	    leadingZeros(d.getSeconds(), 2);

	  return s;
	}

function leadingZeros(n, digits) {
var zero = '';
n = n.toString();

if (n.length < digits) {
  for (i = 0; i < digits - n.length; i++)
    zero += '0';
}
return zero + n;
}


function getBidList(auction_id, auction_address){
	getBidListFromDB(auction_id);
	getBidListFromContract(auction_address);
}

function getBidListFromDB(auction_id){
	var params = {
			"auction_id":Number(auction_id)
		}
	$('#load').show();
	$.ajax({
		type:'POST',
		url:'auctionbidlist.bla', /* DB로 접근 */
		data:params,
		datatype:'json',
		success:function(data){
			var databaseTable = $("#databaseTable");
			databaseTable.empty();
			databaseTable.append("<tr><th>입찰자</th><th>입찰가</th><th>입찰 시간</th><th>트랜잭션 상태</th></tr>");
			for(i in data){
				s = "<tr>";
				s += "<td id=BidderName" + i +"> "+ data[i].bid_member_name + "</td>";
				s += "<td id=BiddersPrice" + i +"> "+ (data[i].bid_price * 0.001).toFixed(3) + "</td>";
				s += "<td id=BiddingTimestamp" + i +"> "+ getTimeStamp(new Date(data[i].bid_time)) + "</td>";
				try {
					s += "<td id=transactionStatus" + i +"> "+ data[i].bid_conf_status + "</td>";
				}
				catch(exception){
				}
				s += "</tr>";
				
				databaseTable.append(s);
			}
			$('#load').hide();
		},
		error:function(data){
			alert('auctionbidlist.bla error')
		}
	})

}

	
function getBidListFromContract(auctionAddress){
	bidList = [];
	$('#load').show();
	var printList = function(){
		var contractTable = $("#contractTable");
		contractTable.empty();
		contractTable.append('<tr><th>입찰자</th><th>입찰가</th><th>입찰 시간</th></tr>');
		
		bidList.sort(function (a, b) { 
			return a.time < b.time ? -1 : a.time > b.time ? 1 : 0;  
		});
		
		for(var i = 0; i < bidList.length; ++i){
			s = "<tr>";
			s += "<td id=CBidderName" + i +"> "+ bidList[i].name + "</td>";
			s += "<td id=CBiddersPrice" + i +"> "+ (bidList[i].price * 0.000000000000000001).toFixed(3) + "</td>";
			s += "<td id=CBiddingTimestamp" + i +"> "+ getTimeStamp(new Date(Number(bidList[i].time))) + "</td>";
			s += "</tr>"
			contractTable.append(s);
		}
		$('#load').hide();
	}
	web3_getBidList(auctionAddress, bidList, printList);
}

function getDownPrice(){
	var downPrice = Number($("#auctionDownPrice").text());
	var downTerm = Number($("#auctionDownTerm").text());
	var originalPrice = Number($("#currentPrice").text());
	var originalTime = new Date(Number($("#registerDate").text())).getTime();;
	var now = new Date().getTime();;

	var termPast = Math.floor((now - originalTime) / (3600000 * downTerm));
	
	var currentPrice = originalPrice - downPrice * termPast;
	currentPrice = Math.floor(currentPrice * 1000) / 1000;
	
	if(currentPrice <= 0){
		currentPrice = 0;
	}

	return currentPrice;
}

function setDownPrice(){
	price = getDownPrice();
	if(price != 0){
		$("#currentPrice").text(price);
	}
	var downInterval = window.setInterval(function(){
		price = getDownPrice();
		if(price != 0){
			$("#currentPrice").text(price);
		}else{
			window.clearInterval(downInterval);
		}
	},60000);
}

function makebidding(auction_id, auct_type, user_name, user_id, auction_address){
	var price = $("#suggestedPrice").val();
	var cur_price = Number($("#currentPrice").text()) * 1000;

	$("#biddingModal").hide();
	$('#load').show();
	price *= 1000;
	
	if(price ==0){
		alert("가격을 입력하세요");
		return;
	}
	if(auct_type==1){
		if(price <= cur_price){
			alert("현재 가격보다 높은 가격을 입력하세요");
			return;
		}
	}
	
	var callback = function(params){
		$.ajax({
			type:'POST',
			url:'biddingimpl.bla', /* DB로 접근 */
			data:params,
			datatype:'json',
			success:function(data){
				$('#load').hide();
				window.location.reload();
			},
			error:function(data){
				alert("biddingimpl.bla error")
			}
		})
	}
	
	web3_bidding(auction_id, price, date.getTime(), user_name, user_id, auction_address, callback);
}

function makebiddingDown(auction_id, user_name, user_id, auctionAddress){
	price = getDownPrice()*1000;
	$('#load').show();
	var callback = function(params){
		$.ajax({
			type:'POST',
			url:'biddingimpl.bla', /* DB로 접근 */
			data:params,
			datatype:'json',
			success:function(data){
				var param = {
		      			"auct_id":auction_id
		      		}
		          
		          $.ajax({
		      		type:'POST',
		      		url:'successfulbiddingimpl.bla', /* DB로 접근 */
		      		data:param,
		      		datatype:'json',
		      		success:function(data){
		      			window.clearInterval(timeInterval);
		      			$('#load').hide();
		    			window.location.reload();
	      			},
		      		error:function(data){
		      			alert('successfulbiddingimpl error')
		      		}
		      	  })
				window.location.reload();
			},
			error:function(data){
				alert("biddingimpl.bla error")
			}
		})
	}
	
	web3_bidding(auction_id, price, date.getTime(), user_name, user_id, auctionAddress, callback);
}
