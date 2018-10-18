// 필요 작성 기능
// 1. 초기 데이터 뿌리기 ----- 서버사이드 에서 실행
// 2. 경매 입찰 ---- by web3 and ajax
// 3. 실시간으로 경매 시간 refresh. 서버시간 이용하기!
// 4. 내림 경매일 경우 시간이 지남에 따라 가격 변동 보여주기
// 5. 비밀 경매의 경우 한 사람이 여러번 입찰 하는 것이 필요 할 거 같음
//       --- 그러면 올림 경매일 경우에는??
// 6. 입찰 버튼 클릭시 입찰 모달 보여주기 ----- 경매 종류에 따라 다르게

var xmlHttp;
function srvTime() {
    try {
        //FF, Opera, Safari, Chrome
        xmlHttp = new XMLHttpRequest();
    }
    catch (err1) {
        //IE
        try {
            xmlHttp = new ActiveXObject('Msxml2.XMLHTTP');
        }
        catch (err2) {
            try {
                xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
            }
            catch (eerr3) {
                //AJAX not supported, use CPU time.
                alert("AJAX not supported");
            }
        }
    }
    xmlHttp.open('HEAD', window.location.href.toString(), false);
    xmlHttp.setRequestHeader("Content-Type", "text/html");
    xmlHttp.send('');
    var date = new Date(xmlHttp.getResponseHeader("Date"));
    var dtA = new Date('10/19/2018 12:00:00');
    var timediff = dtA.getTime() - date.getTime();
    $("#currentTimelimit").text(getTimeStamp(date)  + '\n' + timediff);
    //alert(timediff);
}

window.setInterval("srvTime();",100);

function makeBid(){
	var price = 5//$('#??').text();
	var auction_id = 1//= "<%=(String)session.getAttribute('member_id')%>";
	alert("makeBid");
	bidding(auction_id, price);
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
