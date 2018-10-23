<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_마이페이지</title>

<script src="javascript/user/delivery.js"></script>
<script src="javascript/user/mypage.js?version=2"></script>
<script type="text/javascript">
$(document).ready(function(){	
   $('#load').hide(); //첫 시작시 로딩바를 숨겨둠
	})
	.ajaxStart(function(){
		$('#load').show(); //ajax실행시 로딩바를 보여줌
	})
	.ajaxStop(function(){
		$('#load').hide(); //ajax종료시 로딩바를 숨겨줌
});
</script>
<script type="text/javascript">

// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다.
// (＂팝업 API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";
function goPopup(){
//경로는 시스템에 맞게 수정하여 사용
//호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를
//호출하게 됩니다.
var pop = window.open("jusoPopup.bla","pop","width=570,height=420, scrollbars=yes, resizable=yes");
//** 2017년 5월 모바일용 팝업 API 기능 추가제공 **/
// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서
// 실제 주소검색 URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
// var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
// 2017년 2월 제공항목이 추가되었습니다. 원하시는 항목을 추가하여 사용하시면 됩니다.
document.form.roadFullAddr.value = roadFullAddr;
document.form.roadAddrPart1.value = roadAddrPart1;
document.form.roadAddrPart2.value = roadAddrPart2;
documentform.addrDetail.value = addrDetail;
document.form.zipNo.value = zipNo;
}
</script>
</head>

<script>
	var pwdFlag = 0;
	var phoneFlag = 0;
	function checkPwd() {
		//현재 비밀번호와 일치하는지
		var pwd = document.querySelector('#pw')//db저장 비밀번호
		var cpwd = document.querySelector('#currentPw');//입력한 비밀번호

		if (pwd.value != cpwd.value) {
			spwd.innerHTML = '<span class="text-danger">비밀번호가 일치하지 않습니다.</span>'
			pwdFlag = 0;
			return;
		}

	}

	function newCheckPwd() {
		//새로운 비밀번호 체크
		var npwd = document.querySelector('#changedPw')
		var npwdCheck = document.querySelector('#rechangedPw');

		if (npwd.value == npwdCheck.value) {
			spwdCheck.innerHTML = '<span class="text-success">비밀번호가 확인되었습니다.</span>'
			pwdFlag = 1;
			return;
		}

		if (npwd.value != npwdCheck.value) {
			spwdCheck.innerHTML = '<span class="text-danger">비밀번호를 다시 확인해주세요.</span>'
			pwdFlag = 0;
			return;
		}

	}

	function registerPwd(f) {
		var pwd = document.querySelector('#currentPw');
		var npwd = document.querySelector('#changedPw');
		var npwdCheck = document.querySelector('#rechangedPw');

		if (npwdCheck.value.length != 0 && pwd.value.length != 0
				&& pwdFlag == 1) {
			f.method = 'post';
			f.action = 'pwdupdateimpl.bla';
			f.submit();
		}
	};

	function registerPhone(f) {
		var nphone = document.querySelector('#changedPhone');

		if (nphone.value.length != 0) {
			f.method = 'post';
			f.action = 'phoneupdateimpl.bla';
			f.submit();
		}

	};

	function registerAddress(f) {
		var naddress = document.querySelector('#changedAddress');

		if (naddress.value.length != 0) {
			f.method = 'post';
			f.action = 'addressupdateimpl.bla';
			f.submit();
		}

	};

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
			
			var deliveryCodeVal = data.delivery_code;
			var companyCodeVal = data.company_code;
			
			companyCode.text(companyCodeVal);
			deliveryCode.text(deliveryCodeVal);
			
			$('#deliveryInfoModal').modal('hide');
		},
		error:function(data){
			alert("택배에러")
		}
	})
}

//Tab 전환
	
	function registerReview(){
		//후기 등록하기
		var review = $('#textReview').val();
		var auct_id = $('#auct_id').val();
		
		$.ajax({
			type : 'POST',
			url : 'registerReview.bla', /* DB로 접근 */
			data : {
				"review":review,
				"auct_id":auct_id,
			},
			datatype : 'json',
			success : function(data) {
				$("#createReviewModal").modal('hide');
				alert(data.result);
			},
			error : function(data) {
				alert("biddingimpl.bla error")
			}
		})
	}

function setAuctId(auct_id){
		$('#auct_id').val(auct_id);
	}
function setSuccessAuctId(auct_id){
	$('#successAuct_id').val(auct_id);
}

$(document).ready(function() {
	//ajax 3개 실행! myBidList, successfulbidlist, myAuctionList

	//내가 입찰한 경매 리스트
	$.ajax({
		type : 'POST',
		url : 'mybiddinglist.bla', /* DB로 접근 */
		datatype : 'json',
		success : function(data) {
			for (i in data) {
				if(data[i].auction_status == 'proceeding'){
					var mybiddinglists = $('#mybiddinglists');

					var mybiddinglist = '';
					mybiddinglist += '<div class="panel panel-default" id="mybidding_panel">';
					mybiddinglist += '<div class="panel-body">';
					mybiddinglist += '<div id="mybiddingImg"><a href="auctiondetail.bla?auctionid='+data[i].auct_id+'"><img src="'+data[i].photoPath0+data[i].photoName0+'"></a></div>';
					mybiddinglist += '<div id="mybiddingInfo">';
					mybiddinglist += '<div>';
					mybiddinglist += '<h4><strong>' + data[i].title + '</strong></h4>';
					mybiddinglist += '<a href="sellerpage.bla?seller_id=' + data[i].seller_id + '">';
					mybiddinglist += '<button type="button" class="btn btn-link" id="mybidding_seller_btn"><strong>판매자 정보 확인</strong></button></a>';
					mybiddinglist += '</div>';
					mybiddinglist += '<div>내 입찰가: <span id="mybiddingPrice">' + data[i].memberMaxPrice * 0.001 + ' Ether</span></div>';
					mybiddinglist += '<div>현재 최고가: <span id="currenthighestPrice">' + data[i].bidMaxPrice * 0.001 + ' Ether</span></div>';
					mybiddinglist += '<div>';
					mybiddinglist += '<button type="button" class="btn btn-danger" onclick="web3_withdraw(\''+ data[i].auction_address+'\');" id="refund_btn"><strong>환불받기</strong></button>';
					mybiddinglist += '</div></div></div></div>';
					mybiddinglists.append(mybiddinglist);
				}
			}
		},
		error : function(data) {
			alert("biddingimpl.bla error")
		}
	});
	
	//내가 낙찰된 경매 리스트
	$.ajax({
		type : 'POST',
		url : 'mysuccessbidlist.bla', /* DB로 접근 */
		datatype : 'json',
		success : function(data) {
			var failBid = data.failBid;
			var successfulBid = data.successfulBid;
			
			var winningbidlists = $('#winningbidlists');
			var winningbidlist = '';
			
			for(i in failBid){
				winningbidlist += '<div class="panel panel-default" id="winningbid_panel">';
				winningbidlist += '<div class="panel-body">';
				winningbidlist += '<div id="winningbidImg"><a href="auctiondetail.bla?auctionid='+failBid[i].auct_id+'"><img src="'+failBid[i].photoPath0+failBid[i].photoName0+'"></a></div>';
				winningbidlist += '<div id="winningbidInfo">';
				winningbidlist += '<div>';
				winningbidlist += '<h4><strong>' + failBid[i].auct_title + '</strong></h4>';
				winningbidlist += '<button type="button" class="btn btn-default" id="winningbidStatus" disabled>유찰된 경매</button>';
				winningbidlist += '</div>';
				winningbidlist += '<div>환불가: <span id="winningbidPrice">' + failBid[i].my_bid_price * 0.001 + ' Ether</span></div>';
				winningbidlist += '<div><button type="button" class="btn btn-danger" id="refund_btn"><strong>환불받기</strong></button></div>';	
				winningbidlist += '</div></div></div>';	
				
			}
			
			for (i in successfulBid) {
				winningbidlist += '<div class="panel panel-default" id="winningbid_panel">';
				winningbidlist += '<div class="panel-body">';
				winningbidlist += '<div id="winningbidImg"><a href="auctiondetail.bla?auctionid='+successfulBid[i].auct_id+'"><img src="'+successfulBid[i].photoPath0+successfulBid[i].photoName0+'"></a></div>';
				winningbidlist += '<div id="winningbidInfo">';
				winningbidlist += '<div>';
				winningbidlist += '<h4><strong>' + successfulBid[i].title + '</strong></h4>';
				winningbidlist += '<a href="sellerpage.bla?seller_id=' + successfulBid[i].seller_id + '">';
				winningbidlist += '<button type="button" class="btn btn-default" id="winningbidStatus" disabled>경매 완료</button>';
				winningbidlist += '</div>';
				winningbidlist += '<div>낙찰가: <span id="winningbidPrice">' + successfulBid[i].price * 0.001 + ' Ether</span></div>';
				winningbidlist += '<div>판매자 이름: <span id="bidsellerName">'+ successfulBid[i].seller_name+'</span> / 판매자 전화번호: <span id="bidsellerPhone">'+ successfulBid[i].seller_phone+'</span> ';
				winningbidlist += '<a href="sellerpage.bla?seller_id='+successfulBid[i].seller_id+'"><button type="button" class="btn btn-link" id="winningbidding_seller_btn"> <strong>판매자 정보 확인</strong> </button></a>';
				winningbidlist += '</div>';
				winningbidlist += '<div>택배사: <span id="deliverycompany">'+successfulBid[i].company_code+'</span> / 운송장 번호: <span id="invoice">'+successfulBid[i].delivery_code+'</span> </div>';
				winningbidlist += '<div><button type="button" class="btn btn-warning" id="deliveryStatus_Btn" onclick="getDeliveryStatus(' + successfulBid[i].auct_id + ',\'' + successfulBid[i].auct_address +'\',\''+ successfulBid[i].delivery_code + '\',\'' + successfulBid[i].company_code + '\');">';
				winningbidlist += '<strong>택배 상태 조회</strong></button>';				
				winningbidlist += '<span id="Delivery_Status'+successfulBid[i].auct_id+'"></span></div>';
				winningbidlist += '<div><button type="button" class="btn btn-warning" id="createReview_btn" onclick="setAuctId('+successfulBid[i].auct_id+')" data-toggle="modal" data-target="#createReviewModal"><strong>후기 작성</strong> </button></div></div></div></div>';
				
			}
			winningbidlists.append(winningbidlist);
		},
		error : function(data) {
			alert("낙찰된 경매물품이 없습니다.");
		}
	});
	
	//내가 올린 경매 리스트
	$.ajax({
		type : 'POST',
		url : 'myauctionlist.bla', /* DB로 접근 */
		datatype : 'json',
		success : function(data) {
			var myauctionlists = $('#myauctionlists');
				
			var myauctionlist = '';

			var before = data.before;
			var proceeding = data.proceeding;
			var end = data.end;
			var cancel = data.cancel;
			var failbid = data.failbid;
			
			for(i in before){
				myauctionlist += '<div class="panel panel-default" id="myauction_panel">';
				myauctionlist += '<div class="panel-body">';
				myauctionlist += '<div id="myauctionImg"><a href="auctiondetail.bla?auctionid='+before[i].auct_id+'" id="beforeA'+i+'"><img id="beforeImg'+i+'" src="'+before[i].photoPath0+before[i].photoName0+'"></a></div>';
				if(before[i].auction_status == 'null'){
					myauctionlist += '<div id="myauctionTitle"><h4><strong>'+before[i].auct_title+'</strong></h4><button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>컨펌이 안된 경매</button></div>';
					myauctionlist += '</div></div></div>';
				}else{
					myauctionlist += '<div id="myauctionInfo">';
					myauctionlist += '<div id="myauctionTitle"><h4><strong>'+before[i].auct_title+'</strong></h4><button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>입찰전</button></div>';
					myauctionlist += '<div>입찰 시작가: <span id="myauctionPrice">'+before[i].start_price * 0.001+' Ether</span></div>';
					myauctionlist += '<div><button type="button" class="btn btn-danger" id="myauctionCancle" onclick="auctionCancel('+before[i].auct_id+');">경매 취소</button></div></div></div></div>';
				}
				
			}
			
			for(i in end){
				myauctionlist += '<div class="panel panel-default" id="myauction_panel">';
				myauctionlist += '<div class="panel-body">';
				myauctionlist += '<div id="myauctionImg"><a href="auctiondetail.bla?auctionid='+end[i].auct_id+'"><img src="'+end[i].photoPath0+end[i].photoName0+'"></a></div>';
				myauctionlist += '<div id="myauctionInfo">'; 
				myauctionlist += '<div id="myauctionTitle">';
				myauctionlist += '<h4><strong>'+end[i].auct_title+'</strong></h4>';
				myauctionlist += '<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>경매 완료</button></div>';
				myauctionlist += '<div>낙찰가: <span id="myauctionPrice">'+end[i].successfulBidPrice * 0.001+' Ether</span></div>';
				myauctionlist += '<div>낙찰자 이름: <span id="winnerName">'+end[i].successfulBidMember_name+'</span> / 낙찰자 전화번호: <span id="winnerPhone">'+end[i].successfulBidMemberPhone+'</span></div>';		
				myauctionlist += '<div>낙찰자 주소: <span id="winnerAddress">'+end[i].successfulBidAddress+'</span></div>';	
				
				if(String(end[i].delivery_code) == 'null'){
					myauctionlist += '<button type="button" class="btn btn-warning" id="deliveryInfo_btn" onclick="setSuccessAuctId('+end[i].auct_id+')" data-toggle="modal" data-target="#deliveryInfoModal"><strong>택배 정보 입력</strong></button>';	
				}else{
					myauctionlist += '<div>운송장 정보: <span id="winnerInvoice'+end[i].auct_id+'">'+end[i].delivery_code+'</span>&nbsp;(<span id="winnerDeliverycompany'+end[i].auct_id+'">'+end[i].company_code+'</span>)';
					myauctionlist += '<div><button type="button" class="btn btn-warning" id="ownerWithdraw_btn" onclick="getDeliveryStatus(' + end[i].auct_id + ',\'' + end[i].auct_address +'\',\''+ end[i].delivery_code + '\',\'' + end[i].company_code + '\');"><strong>택배 상태 확인</strong></button>';
					myauctionlist += '<span id="Delivery_Status'+end[i].auct_id+'"></span></div>';
					myauctionlist += '</div>';
				} 
				var fee = 5;
				if(end[i].delivery_status == '6'){
					myauctionlist += '<button type="button" class="btn btn-warning" id="ownerWithdraw_btn" onclick="web3_withdraw_for_owner(' + fee + ",\'" + end[i].auct_address +'\');"><strong>판매금 받기</strong></button>';
				}
				myauctionlist += '</div></div></div>';
				//택배 운송 번호를 입력한 뒤에 환불받기 버튼이 필요한것인가..?
			}
			
			for(i in proceeding){
				myauctionlist += '<div class="panel panel-default" id="myauction_panel">';
				myauctionlist += '<div class="panel-body">';
				myauctionlist += '<div id="myauctionImg"><a href="auctiondetail.bla?auctionid='+proceeding[i].auct_id+'"><img src="'+proceeding[i].photoPath0+proceeding[i].photoName0+'"></a></div>';
				myauctionlist += '<div id="myauctionInfo">';		
				myauctionlist += '<div id="myauctionTitle"><h4><strong>'+proceeding[i].auct_title+'</strong></h4>';
				if(proceeding[i].auct_type == 2){
					myauctionlist += '<div>경매 마감 시간: <span id="myauctionDuedate">'+proceeding[i].dueDate+'</span></div>';
					if(proceeding[i].auction_address == 'null'){
						myauctionlist += '<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>컨펌이 안된 경매</button></div>';
					}else{
						myauctionlist += '<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>입찰전</button></div>';
						myauctionlist += '<div><button type="button" class="btn btn-danger" id="myauctionCancle" onclick="auctionCancel('+proceeding[i].auct_id+');">경매 취소</button></div></div></div></div>';
					}
				}else{
					myauctionlist += '<div>현재 최고가: <span id="myauctionPrice">'+proceeding[i].bidMaxPrice * 0.001+' Ether</span></div>';	
					myauctionlist += '<div>경매 마감 시간: <span id="myauctionDuedate">'+proceeding[i].dueDate+'</span></div>';
				}
				myauctionlist += '</div></div></div>';
				
			}
			
			for(i in cancel){
				myauctionlist +='<div class="panel panel-default" id="myauction_panel">';
				myauctionlist +='<div class="panel-body">';
				myauctionlist +='<div id="myauctionImg"><a href="auctiondetail.bla?auctionid='+cancel[i].auct_id+'"><img src="'+cancel[i].photoPath0+cancel[i].photoName0+'"></a></div>';
				myauctionlist +='<div id="myauctionInfo">';
				myauctionlist +='<div id="myauctionTitle"><h4><strong>'+cancel[i].auct_title+'</strong></h4>';
				myauctionlist +='<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>취소된 경매</button></div>';
				myauctionlist +='</div></div></div>';
				
			}
			
			for(i in failbid){
				myauctionlist +='<div class="panel panel-default" id="myauction_panel">';
				myauctionlist +='<div class="panel-body">';
				myauctionlist +='<div id="myauctionImg"><a href="auctiondetail.bla?auctionid='+failbid[i].auct_id+'" id="failbidA'+i+'"><img id="failbidImg'+i+'" src="'+failbid[i].photoPath0+failbid[i].photoName0+'"></a></div>';
				myauctionlist +='<div id="myauctionInfo">';
				myauctionlist +='<div id="myauctionTitle"><h4><strong>'+failbid[i].auct_title+'</strong></h4>';
				myauctionlist +='<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>유찰된 경매</button></div>';
				myauctionlist +='</div></div></div>';
			}
			
			myauctionlists.append(myauctionlist);
			
		},
		error : function(data) {
			alert("경매를 불러오는데 실패했습니다.");
		}
	});
	
	$(".nav-tabs a").click(function() {
		$(this).tab('show');

	});

});
</script>
<style>
#myauctionCancle{
		position:absolute;
		bottom:10px;
		right:15px;
	}
</style>
<body>

	<!-- Content -->
	<div id="mypage_area">
		<div class="col-sm-10 text-left">



			<!-- Page Start -->
			<!-- Myinfo Panel -->
			<div class="panel panel-default" id="myinfo_panel">
				<div class="panel-body">
					<div id="personalInfo">
						<div id="rightInfo">
							<div id="mygrade">
								<img src="img/info.png">
							</div>
							<div>
								<span id="myname"><strong>${member.name }</strong></span>
							</div>
							<div>
								<span id="myemail"><strong>${member.email }</strong></span>
							</div>

							<!-- Trigger the modal with a button -->
							<div>
								<button type="button" class="btn btn-warning" id="changePw_btn"
									data-toggle="modal" data-target="#ChangePwModal">
									<strong>비밀번호 변경</strong>
								</button>
							</div>

						</div>
						<div id="leftInfo">
							<div>
								<h4>
									<strong>내 정보</strong>
								</h4>
							</div>
							<div>
								<strong>핸드폰 번호: </strong><span id="myphone">${member.phone }</span>
								<button type="button" class="btn btn-warning"
									id="changePhone_btn" data-toggle="modal"
									data-target="#ChangePhoneModal">
									<strong>번호 변경</strong>
								</button>
							</div>
							<div>
								<strong>주소: </strong><span id="myaddress">${member.address }</span>
								<button type="button" class="btn btn-warning"
									id="changeAddress_btn" onClick="goPopup();" value="팝업">
									<strong>주소 변경</strong>
								</button>
							</div>

						</div>
					</div>
				</div>
			</div>


			<!-- Tabs -->
			<ul class="nav nav-tabs" id="mylist_tabs">
				<li class="active"><a data-toggle="tab" href="#mybiddinglists">입찰
						리스트</a></li>
				<li><a data-toggle="tab" href="#winningbidlists">낙찰/유찰 리스트</a></li>
				<li><a data-toggle="tab" href="#myauctionlists">내가 올린 경매</a></li>
			</ul>

			<!-- First -->
			<div class="tab-content" id="mylist_panel">

				<div id="mybiddinglists" class="tab-pane fade in active">
					<!-- Panel -->
				</div>

				<!-- Second -->
				<div id="winningbidlists" class="tab-pane fade">
					<!-- Panel -->
					
				</div>

				<!-- Third -->
				<div id="myauctionlists" class="tab-pane fade">
					<!-- Panel -->
					
				</div>

			</div>
		</div>

	</div>


	<!-- Modal -->

	<!-- ChangePw Modal -->
	<div class="modal" id="ChangePwModal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>

				<div class="modal-body">
					<form action="pwdupdateimpl.bla" method="post" name="frmm" id="frmm">
						
						<div class="form-group">
							<h4 style="display:inline">변경할 비밀번호:</h4>
							<input type="text" id="changedPw" name="changed_Pw" class="form-control">
						</div>

						<div class="form-group">
							<h4 style="display:inline">비밀번호 확인:</h4>
							<input type="text" id="rechangedPw" name="rechanged_Pw" class="form-control" onblur="newCheckPwd();">
						</div>

						<div id="spwdCheck"></div>


						<button type="submit" class="btn btn-danger" id="changePasswd_btn"
							onclick="registerPwd(this.form);">변경하기</button>
					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>






	<!-- ChangePhone Modal -->
	<div class="modal" id="ChangePhoneModal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>

				<div class="modal-body">
					<form action="phoneupdateimpl.bla" method="post" name="frmm2" id="frmm2">
						<div class="form-group">
						<h4>변경된 핸드폰 번호:</h4>
						<input type="tel" id="changedPhone" name="changed_phone" class="form-control" placeholder="010-1234-5678" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required/>
						<button type="submit" class="btn btn-danger" id="changePhone_Btn"
							onclick="registerPhone(this.form);">변경하기</button>
						</div>
					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<!-- ChangeAddress Modal -->
	<div class="modal" id="ChangeAddressModal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>

				<div class="modal-body">
					<form action="">
						<h4>변경된 주소 입력:</h4>
						<input type="text" id="changedAddress" name="changed_address">
						<button onClick="goPopup();" value="팝업">
							<img src="img/map.png">
						</button>
						<!--도로명주소 전체(포맷)<input type="text" id="roadFullAddr" name="roadFullAddr" /><br>
							도로명주소 <input type="text" id="roadAddrPart1" name="roadAddrPart1" /><br>
							고객입력 상세주소<input type="text" id="addrDetail" name="addrDetail" /><br>
							참고주소<input type="text" id="roadAddrPart2" name="roadAddrPart2" /><br>
							우편번호<input type="text" id="zipNo" name="zipNo" /> -->
						<button type="submit" class="btn btn-danger"
							id="changeAddress_Btn" onclick="registerAddress(this.form);">변경하기</button>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>



	<!-- Re-bidding Modal -->
	<div class="modal" id="RebiddingModal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>

				<div class="modal-body">
					<form action="biddingimpl.bla?auct_id=">

						<h4>
							현재 입찰가: <span id="Current_Price"></span>
						</h4>

						<div id="sgbidding_area">
							<h4>입찰 제시 가격:&nbsp;</h4>
							<input id="SuggestedPrice" type="number" class="form-control"
								min="0.001" step="0.001" name="suggested_Price">
						</div>

						<h4>
							경매 마감 시간: <span id="auction_Due_date"></span>
						</h4>
						<h4>
							마감까지 남은 시간: <span id="Current_Timelimit"></span>
						</h4>

						<button type="submit" class="btn btn-danger"
							id="Bidding_Submit_btn">재입찰하기</button>
					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<!-- Input DeliveryInfo Modal -->
	<div class="modal" id="deliveryInfoModal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>

				<div class="modal-body">
					<form action="" class="form-horizontal">
						<div id="selectedDeliveryCompany">
							<select id="companyCode">
							  <option value="01">우체국택배 (01)</option>
							  <option value="04">CJ대한통운 (04)</option>
							  <option value="05">한진택배 (05)</option>
							  <option value="06">로젠택배 (06)</option>
							  <option value="08">롯데택배 (08)</option>
							</select>	
						</div>

						<div>
							<h4>운송장 번호:</h4>
							<input type="text" class="form-control" id="invoiceNum"
								name="invoice_num">
						</div>
						<input type= "hidden" name="successAuct_id" id="successAuct_id" value="">
						<button type="button" class="btn btn-danger" id="deliveryInfo_Btn" onclick = "setDeliveryCode();">택배
							정보 등록</button>
					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
	<!-- Create Review Modal -->
	<div class="modal" id="createReviewModal">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>

				<div class="modal-body">
					<form action="" class="form-horizontal">
					
						<div>
							<h4>후기 등록하기</h4>
  							<textarea class="form-control" rows="5" id="textReview"></textarea>

						</div>
						<input type= "hidden" name="auct_id" id="auct_id" value="">
						<button type="button" class="btn btn-danger" id="createReview_Btn" onclick="registerReview()">후기 등록</button>
					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
<!-- Loading bar -->
<div id="load">
	<img src="img/loading.gif" alt="loading">
</div>

</body>
</html>