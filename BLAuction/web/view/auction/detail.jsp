<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_물품 상세</title>
<script src="javascript/auction/detail.js"></script>
</head>
<script>
$(document).ready(function(){
    $("#bidding_btn").click(function(){
         //$("#biddingModal").modal();
    });
});

</script>
<body>

<!-- Content -->
<div id="detail_area">
	<div class="col-sm-10 text-left">
		<!-- Page Start -->
		<h3><img src="img/auction.png" id="detail_logo"></img>물품 상세</h3>
		<div class="panel panel-default" id="detail_panel">
  			<div class="panel-body">
  			
  				<div id="detail_top">
	  				<div id="detail_pic"><img src="${photo1 }"></div>
	  				<div id="first_info">
	  					<div><h4>카테고리: <span id="detailCategory">${category }</span></h4></div>
	  					<div><h4>경매종류: <span id="detailKind">${auction_type }</span></h4></div>
	  					<div><h4>경매제목: <span id="detailTitle">${auction.auct_title }</span></h4></div>
	  				</div>
  				</div>
  				
  				<div id="detail_bottom">
	  				<div id="second_info">
	  					<div id="oneLine">
	  						<div><h4>경매 마감 시간: <span id="auctionDuedate">${due_date }</span></h4></div>
	  						<div><h4>현재 입찰가: <span id="currentPrice">${cur_price }</span></h4></div>
	  					</div>
	  					<div style="border-bottom:1px solid #A6A6A6"><h4>마감까지 남은 시간: <span id="currentTimelimit"></span></h4></div>
	  					<div style="border-bottom:1px solid #A6A6A6"><h4>연관태그: <span id="relatedTags">${auction.tag }</span></h4></div>
	  					<div>
	  						<div class="form-group">
							  <h4>상세 내용</h4>
							  <div class="form-control" rows="9" id="comment" disabled>${auction.description }</div>
							</div>
	  					</div>
	  				</div>
  				</div>
  				
  				<!-- Trigger the modal with a button -->
  				<button type="button" class="btn btn-danger" id="bidding_btn" data-toggle="modal" data-target="#biddingModal"><h4>입 찰 하 기</h4></button>
				
				  <!-- Modal -->
				  <div class="modal" id="biddingModal">
				    <div class="modal-dialog modal-lg modal-dialog-centered">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title"></h4>
				        </div>
				        
				        <div class="modal-body">  
							<form action="biddingimpl.bla?auct_id=">
								<div>
									<h4>현재 입찰가: <span id="currentPrice"></span></h4>
								</div>
							
								<div id="inputPriceArea">
									<h4>입찰 제시 가격:&nbsp;</h4>
									<div>
										<input id="suggestedPrice" type="number" class="form-control" 
										min="0.001"  step="0.001" name="suggested_price">
									</div>
								</div>
								
								<div>
									<h4>경매 마감 시간: <span id="auctionDuedate"></span></h4>
								</div>
								
								<div>
									<h4>마감까지 남은 시간: <span id="currentTimelimit"></span></h4>
								</div>
							
								<button type="submit" class="btn btn-danger" id="bidding_submit_btn">입찰하기</button>
							</form>

				        </div>
				        
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>
				      
				    </div>
				  </div>
  				
  			</div>
		</div>
	</div>
	
	
	<div class="col-sm-10 text-left">
		<!-- Page Start -->
		<h3 style="margin-left:2%;"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;입찰 리스트</h3>
		<div class="panel panel-default" id="biddingList_panel">
  			<div class="panel-body">
  				<div class="panel panel-default" id="DBlist">
  				<h4><strong>DataBase Info</strong></h4>
  				<table border="1">
  					<tr>
	  					<th>입찰자</th>
	  					<th>입찰가</th>
	  					<th>입찰 시간</th>
	  					<th>트랜잭션 상태</th>
  					</tr>
  					<tr>
  						<td id="BidderName">회원1</td>
  						<td id="BiddersPrice">10</td>
  						<td id="BiddingTimestamp">12:00</td>
  						<td id="transactionStatus">Confirmed</td>
  					</tr>
  				</table>
  				</div>
  				
  				<div class="panel panel-default" id="Contractlist">
  				<h4><strong>Contract Info</strong></h4>
  				<table border="1">
  					<tr>
	  					<th>입찰자</th>
	  					<th>입찰가</th>
	  					<th>입찰 시간</th>
  					</tr>
  					<tr>
  						<td id="Bidder_Name">회원1</td>
  						<td id="Bidders_Price">10</td>
  						<td id="Bidding_Timestamp">12:00</td>
  					</tr>
  				</table>
  				
  				</div>
  			</div>
  		</div>
  	</div>
	
	
</div>



</body>
</html>