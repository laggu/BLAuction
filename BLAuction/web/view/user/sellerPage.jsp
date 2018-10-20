<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_마이페이지</title>
<script>
//Tab 전환
$(document).ready(function(){
	
	$(".nav-tabs a").click(function(){
        $(this).tab('show');
    });
	
});
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
  						<div><span id="sellerName"><strong>${seller_info.name }</strong></span></div>
  						<div><span id="myemail"><strong>${seller_info.email }</strong></span></div>
  						
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
			  <li class="active"><a data-toggle="tab" href="#reviewlists">후기 리스트</a></li>
			  <li><a data-toggle="tab" href="#sellinglists">판매 리스트</a></li>
			</ul>
			
			<div class="tab-content" id="sellerlist_panel">
			<!-- First -->
			  <div id="reviewlists" class="tab-pane fade in active">
			  	<!-- Panel -->
			    <div class="panel panel-default" id="review_panel">
		  			<div class="panel-body">
		  				<div id="reviewImg"><img src="img/se.jpg"></div>
		  				<div id="reviewInfo">
		  					<div><h4><strong>낙찰자 이름</strong></h4></div>
	  						<div>낙찰가: <span id="successfulbidPrice">2.0 Ether</span></div>
	  						<div class="form-group">
								<textarea class="form-control" rows="2" id="reviewComment" disabled>옷이 너무 잘 맞아요!</textarea>
	  						</div>
		  				</div>
		  			</div>
				</div>
				
			  </div>
			  <div id="sellinglists" class="tab-pane fade">
			    <!-- Panel -->
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