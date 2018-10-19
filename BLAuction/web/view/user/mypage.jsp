<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_마이페이지</title>

<script src="javascript/user/delivery.js?version=1"></script>

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

	function registerPhone(f){
		var nphone = document.querySelector('#changedPhone');
		
		if(nphone.value.length != 0) {
			f.method = 'post';
			f.action = 'phoneupdateimpl.bla';
			f.submit();
		}
		
	};
	
	function registerAddress(f){
		var naddress = document.querySelector('#changedAddress');
		
		if(naddress.value.length != 0) {
			f.method = 'post';
			f.action = 'addressupdateimpl.bla';
			f.submit();
		}
		
	};
</script>
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
	  						<div id="mygrade"><img src="img/info.png"></div>
	  						<div><span id="myname"><strong>${member.name }</strong></span></div>
	  						<div><span id="myemail"><strong>${member.email }</strong></span></div>
	  				
			  				<!-- Trigger the modal with a button -->
			  				<div><button type="button" class="btn btn-warning" id="changePw_btn" 
			  				data-toggle="modal" data-target="#ChangePwModal"><strong>비밀번호 변경</strong></button></div>
	  						
	  					</div>
	  					<div id="leftInfo">
	  						<div><h4><strong>내 정보</strong></h4></div>
	  						<div>
	  						핸드폰 번호: <span id="myphone">${member.phone }</span>
	  						<button type="button" class="btn btn-warning" id="changePhone_btn"
	  						data-toggle="modal" data-target="#ChangePhoneModal"><strong>번호 변경</strong></button>
	  						</div>
	  						<div>
	  						주소: <span id="myaddress">${member.address }</span>
	  						<button type="button" class="btn btn-warning" id="changeAddress_btn"
	  						data-toggle="modal" data-target="#ChangeAddressModal"><strong>주소 변경</strong></button>
	  						</div>
	  					</div>
	  				</div>
	  			</div>
			</div>
			
			<ul class="nav nav-tabs" id="mylist_tabs">
			  <li class="active"><a data-toggle="tab" href="#home">입찰 리스트</a></li>
			  <li><a data-toggle="tab" href="#menu1">낙찰 리스트</a></li>
			  <li><a data-toggle="tab" href="#menu2">내가 올린 경매</a></li>
			</ul>
			
			<div class="tab-content" id="mylist_panel">
			  <div id="mybiddinglists" class="tab-pane fade in active">
			  	<!-- Panel -->
			    <div class="panel panel-default" id="mybidding_panel">
		  			<div class="panel-body">
		  				<div id="mybiddingImg"><img src="img/se.jpg"></div>
		  				<div id="mybiddingInfo">
		  					<div><h4><strong>경매 물품 이름</strong></h4></div>
	  						<div>내 입찰가: <span id="mybiddingPrice">0.1 Ether</span></div>
	  						<div>현재 최고가: <span id="currenthighestPrice">10.0 Ether</span>
	  						<button type="button" class="btn btn-danger" id="rebidding_btn" 
	  						data-toggle="modal" data-target="#RebiddingModal"><strong>재입찰하기</strong></button>
	  						</div>
		  				</div>
		  			</div>
				</div>
				<div class="panel panel-default" id="winningbid_panel">
		  			<div class="panel-body">
		  				<div id="winningbidImg"><img src="img/se.jpg"></div>
		  				<div id="winningbidInfo">
		  					<div>
			  					<h4><strong>경매 물품 이름</strong></h4>
			  					<button type="button" class="btn btn-default" id="winningbidStatus" disabled>경매 완료</button>
		  					</div>
	  						<div>
	  							낙찰가: <span id="winningbidPrice">0.1 Ether</span>		
	  						</div>
	  						<div>
	  							판매자 이름: <span id="bidsellerName">한나영</span>
	  							/   판매자 전화번호: <span id="bidsellerPhone">010-1234-5678</span>
	  						</div>
	  						<div>
	  							택배사: <span id="deliverycompany">cj 대한통운</span>
	  							/   운송장 번호: <span id="invoice">777-777777-7</span>
	  						</div>
	  						<div>
	  							<button type="button" class="btn btn-warning" id="deliveryStatus_Btn" onclick="getDeliveryStatus(index,auction_address);">택배 상태 조회</button>	
	  							<span id="Delivery_Status"+index></span>
	  						</div>
		  				</div>
		  			</div>
				</div>
				<div class="panel panel-default" id="myauction_panel">
		  			<div class="panel-body">
		  				<div id="myauctionImg"><img src="img/se.jpg"></div>
		  				<div id="myauctionInfo">
		  					<div id="myauctionTitle">
			  					<h4><strong>경매 물품 이름</strong></h4>
			  					<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>경매 완료</button>
		  					</div>
		 
	  						<div>낙찰가: <span id="myauctionPrice">0.1 Ether</span></div>
	  						<div>
		  						낙찰자 이름: <span id="winnerName">한나영</span> 
		  						/   낙찰자 전화번호: <span id="winnerPhone">010-1234-5678</span>
	  						</div>
	  						<div>낙찰자 주소: <span id="winnerAddress">서울시 강남구 테헤란로 212 멀티캠퍼스 1004호</span></div>
	  						<div>운송장 정보: <span id="winnerInvoice">777-777777-7</span>&nbsp;(<span id="winnerDeliverycompany">cj 대한통운</span>)
	  						<button type="button" class="btn btn-warning" id="deliveryInfo_btn"
	  						data-toggle="modal" data-target="#deliveryInfoModal"><strong>택배 정보 입력</strong></button>
	  						</div>
		  				</div>
		  				
		  			</div>
				</div>
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
					<form action="pwdupdateimpl.bla" method="post" name="frmm"
						id="frmm">
						<div>
							<h4>현재 비밀번호:</h4>
							<input type="text" id="currentPw" name="userPasswd"
								onblur="checkPwd();">
							<div id="spwd"></div>
						</div>
						<div>
							<h4>변경할 비밀번호:</h4>
							<input type="text" id="changedPw" name="changed_Pw"
							>
						</div>

						<div>
							<h4>비밀번호 확인:</h4>
							<input type="text" id="rechangedPw" name="rechanged_Pw"
							onblur="newCheckPwd();">
						</div>
						
						<div id="spwdCheck"></div>
						

						<button type="submit" class="btn btn-danger" id="changePasswd_btn" onclick="registerPwd(this.form);">변경하기</button>
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
					<form action="">
						<h4>변경된 핸드폰 번호:</h4>
						<input type="text" id="changedPhone" name="changed_phone">
						<button type="submit" class="btn btn-danger" id="changePhone_Btn" onclick="registerPhone(this.form);">변경하기</button>
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
					<button onClick="goPopup();" value="팝업"><img src="img/map.png"></button>
                     		<!--도로명주소 전체(포맷)<input type="text" id="roadFullAddr" name="roadFullAddr" /><br>
							도로명주소 <input type="text" id="roadAddrPart1" name="roadAddrPart1" /><br>
							고객입력 상세주소<input type="text" id="addrDetail" name="addrDetail" /><br>
							참고주소<input type="text" id="roadAddrPart2" name="roadAddrPart2" /><br>
							우편번호<input type="text" id="zipNo" name="zipNo" /> -->
					<button type="submit" class="btn btn-danger" id="changeAddress_Btn" onclick="registerAddress(this.form);">변경하기</button>
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

						<h4>현재 입찰가: <span id="Current_Price"></span></h4>
						
						<div id="sgbidding_area">
							<h4>입찰 제시 가격:&nbsp;</h4>
							<input id="SuggestedPrice" type="number" class="form-control" 
								min="0.001"  step="0.001" name="suggested_Price">
						</div>
					
						<h4>경매 마감 시간: <span id="auction_Due_date"></span></h4>
						<h4>마감까지 남은 시간: <span id="Current_Timelimit"></span></h4>
				
					<button type="submit" class="btn btn-danger" id="Bidding_Submit_btn">재입찰하기</button>
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
					<div>						
						<div class="dropdown">
						  <button class="btn btn-default dropdown-toggle" type="button" id="selectedDeliveryCompany" 
						  data-toggle="dropdown" aria-expanded="true">택배사를 선택하세요
						    <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">우체국택배 (01)</a></li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CJ대한통운 (04)</a></li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">한진택배 (05)</a></li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">로젠택배 (06)</a></li>
						    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">롯데택배 (08)</a></li>
						  </ul>
						</div>							
					</div>
					
					<div>
						<h4>운송장 번호:</h4>
						<input type="text" class="form-control" id="invoiceNum" name="invoice_num">
					</div>
				
					<button type="submit" class="btn btn-danger" id="deliveryInfo_Btn">택배 정보 등록</button>
				</form>

	        </div>
	        
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  
</body>
</html>