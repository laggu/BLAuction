<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_마이페이지</title>
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
<body>

<!-- Content -->
<div id="sellerpage_area">
	<div class="col-sm-10 text-left">
	
		<!-- Page Start -->	
		<!-- SellerInfo Panel -->
		<div class="panel panel-default" id="sellerinfo_panel">
  			<div class="panel-body">
 				<div id="personalInfo">
  					<div id="rightInfo">
  						<div id="sellergrade"><img src="img/info.png"></div>
  						<div><span id="sellerName"><strong>${member.name }</strong></span></div>
  						<div><span id="myemail"><strong>${member.email }</strong></span></div>
  						
  					</div>
  					<div id="leftInfo">
  						<div><h4><strong>판매자 정보</strong></h4></div>
  						<div id="numofSellerInfo">
  							<h4>등록한 경매:  <span id="numofRegauction">0</span>회</h4>
  							<h4>완료된 경매:  <span id="numofComplitedauction">0</span>회</h4>
  						</div>
  						<div>
  							<button type="button" class="btn btn-link" id="report_btn">신고하기</button>
  						</div>
  					</div>
  				</div>
  			</div>
		</div>
		

		<!-- Seller Lists -->
		<!-- Tabs -->
		<div id="sellerlist_area">
		
			<ul class="nav nav-tabs" id="sellerlist_tabs">
			  <li class="active"><a data-toggle="tab" href="#home">후기 리스트</a></li>
			  <li><a data-toggle="tab" href="#menu1">판매 리스트</a></li>
			</ul>
			
			<div class="tab-content" id="sellerlist_panel">
			  <div id="reviewlists" class="tab-pane fade in active">
			  	<!-- Panel -->
			    <div class="panel panel-default" id="review_panel">
		  			<div class="panel-body">
		  				<div id="reviewImg"><img src="img/se.jpg"></div>
		  				<div id="reviewInfo">
		  					<div><h4><strong>낙찰자 이름</strong></h4></div>
	  						<div>낙찰가: <span id="successfulbidPrice">2.0 Ether</span></div>
	  						<div class="form-group">
								<textarea class="form-control" rows="2" id="reviewComment">옷이 너무 잘 맞아요!</textarea>
	  						</div>
		  				</div>
		  			</div>
				</div>
				<div class="panel panel-default" id="selling_panel">
		  			<div class="panel-body">
		  				<div id="sellingImg"><img src="img/se.jpg"></div>
		  				<div id="sellingInfo">
		  					<div>
		  						<h4><strong>경매 물품 이름</strong></h4>
		  						<button type="button" class="btn btn-default" id="sellingbidStatus" disabled>경매 완료</button>	
		  					</div>
	  						<div>
	  							낙찰가: <span id="sellingbidPrice">1.0 Ether</span>
	  						</div>
		  				</div>
		  			</div>
				</div>
				
			  </div>
			  <div id="sellinglists" class="tab-pane fade">
			    <!-- Panel -->
			    <div class="panel panel-default" id="selling_panel">
		  			<div class="panel-body">
		  				
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
				<form action="">
					<div>
						<h4>현재 비밀번호:</h4>
						<input type="text" id="currentPw" name="userPasswd">
					</div>
					<div>
						<h4>변경할 비밀번호:</h4>
						<input type="text" id="changedPw" name="changed_Pw">
					</div>
					
					<div>
						<h4>비밀번호 확인:</h4>
						<input type="text" id="rechangedPw" name="rechanged_Pw">
					</div>
				
					<button type="submit" class="btn btn-danger" id="changePasswd_btn">변경하기</button>
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
	  
	
	  
	  
    
</body>
</html>