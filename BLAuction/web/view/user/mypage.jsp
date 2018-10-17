<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_마이페이지</title>

</head>
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
  						<div>
  							등록한 경매:  <span id="numofRegauction">0</span>회
  							 ♥좋아요  <span id="numofLikes">0</span>회
  						</div>
  						<div>
  							완료된 경매:  <span id="numofComplitedauction">0</span>회
  						</div>
  					</div>
  				</div>
  			</div>
		</div>
		
		<!-- MyLists -->
		<!-- Tabs -->
		<div id="mylist_area">
		
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
	  						<button type="button" class="btn btn-danger" id="rebidding_btn"><strong>재입찰하기</strong></button>
	  						</div>
		  				</div>
		  			</div>
				</div>
				<div class="panel panel-default" id="winningbid_panel">
		  			<div class="panel-body">
		  				<div id="winningbidImg"><img src="img/se.jpg"></div>
		  				<div id="winningbidInfo">
		  					<div><h4><strong>경매 물품 이름</strong></h4></div>
	  						<div>
	  							낙찰가: <span id="winningbidPrice">0.1 Ether</span>
	  							<button type="button" class="btn btn-default" id="winningbidStatus" disabled>경매 완료</button>	
	  						</div>
	  						<div>
	  							판매자 이름: <span id="bidsellerName">한나영</span>
	  							/   판매자 전화번호: <span id="bidsellerPhone">010-1234-5678</span>
	  						</div>
	  						<div>
	  							택배사: <span id="deliverycompany">cj 대한통운</span>
	  							/   운송장 번호: <span id="invoice">777-777777-7</span>
	  						</div>
		  				</div>
		  			</div>
				</div>
				<div class="panel panel-default" id="myauction_panel">
		  			<div class="panel-body">
		  				<div id="myauctionImg"><img src="img/se.jpg"></div>
		  				<div id="myauctionInfo">
		  					<div><h4><strong>경매 물품 이름</strong></h4></div>
	  						<div>낙찰가: <span id="myauctionPrice">0.1 Ether</span></div>
	  						<div>
		  						낙찰자 이름: <span id="winnerName">한나영</span> 
		  						/   낙찰자 전화번호: <span id="winnerPhone">010-1234-5678</span>
	  						</div>
	  						<div>낙찰자 주소: <span id="winnerAddress">서울시 강남구 테헤란로 212 멀티캠퍼스 1004호</span></div>
	  						<div>운송장 정보: <span id="winnerInvoice">777-777777-7</span>&nbsp;(<span id="winnerDeliverycompany">cj 대한통운</span>)
	  						<button type="button" class="btn btn-warning" id="deliveryInfo_btn"><strong>택배 정보 입력</strong></button>
	  						</div>
		  				</div>
		  				
		  			</div>
				</div>
				
			  </div>
			  <div id="winningbidlists" class="tab-pane fade">
			    <!-- Panel -->
			    <div class="panel panel-default" id="winningbid_panel">
		  			<div class="panel-body">
		  				
		  			</div>
				</div>
			  </div>
			  <div id="myauctionlists" class="tab-pane fade">
			    <!-- Panel -->
			    <div class="panel panel-default" id="myauction_panel">
		  			<div class="panel-body">
		  				
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
		  					<div><h4><strong>경매 물품 이름</strong></h4></div>
	  						<div>
	  							낙찰가: <span id="sellingbidPrice">1.0 Ether</span>
	  							<button type="button" class="btn btn-default" id="sellingbidStatus" disabled>경매 완료</button>	
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
					<button type="submit" class="btn btn-danger" id="changePhone_Btn">변경하기</button>
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
					<button type="submit" class="btn btn-danger" id="changeAddress_Btn">변경하기</button>
				</form>
	        </div>
	        
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  
	  
	  
	  <!-- Re-bidding Modal -->
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
	  
	  
	    <!-- Input DeliveryInfo Modal -->
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
	  
	  
    
</body>
</html>