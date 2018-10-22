<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_물품 상세</title>
<script>
	var auctionStatus = "${auction.auction_status }";

	$(document).ready(function(){
	    $("#bidding_btn").click(function(){
	         $("#biddingModal").show();
	    });

	    dtA = new Date(parseInt($("#timestamp").text()));
	    if(auctionStatus == "before" || auctionStatus == "proceeding"){
	    	timeInterval = window.setInterval("srvTime(${auction.auct_id });",600);
	    }else if(auctionStatus == "cancel"){
	    	$("#currentTimelimit").text("경매 취소");
	    }else{
	    	$("#currentTimelimit").text("경매 완료");	
	    }
	});
</script>
<script src="javascript/auction/detail.js?version=1"></script>
</head>
<script>
	$(document).ready(function(){
		if("${auction.type}" == "2"){
			setDownPrice();
		}
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
	  					<div><h4><strong>카테고리</strong>: <span id="detailCategory">${category }</span></h4></div>
	  					<div><h4><strong>경매종류</strong>: <span id="detailKind">${auction_type }</span></h4></div>
	  					<div><h4><strong>경매제목</strong>: <span id="detailTitle">${auction.auct_title }</span></h4></div>
	  				</div>
  				</div>
  				
  				<div id="detail_bottom">
	  				<div id="second_info">
	  					<a href="sellerpage.bla?seller_id=${auction.member_id }"><button type="button" class="btn btn-warning" id="sellerInfoCheck_btn">
	  					<strong>판매자 정보 확인</strong></button></a>
	  					
	  					<div id="oneLine">	
	  						<div><h4><strong>경매 마감 시간</strong>: <span id="auctionDuedate">${due_date }</span><span hidden id='timestamp'>${timestamp }</span></h4></div>
	  						<div><h4><c:if test="${auction.type le 2}"><strong>현재 입찰가</strong>: <span id="currentPrice">${cur_price }</span></c:if><c:if test="${auction.type eq 3}"><strong>입찰 시작가</strong>: <span id="startPrice">${auction.start_price * 0.001 }</span></c:if><span> 이더</span></h4></div>
	  					</div>
	  					<!-- 다은이 마음대로 수정! 지우지만 말아줘요 --><span>경매등록시간 </span><span id="registerDate">${auction.register_date }</span>
	  					<c:if test="${auction.type eq 2}">
	  					<div id="oneLine">	
	  						<div><h4><strong>내림 가격</strong>: <span id="auctionDownPrice">${auction.down_price * 0.001 }</span><span> 이더</span></h4></div>
	  						<div><h4><strong>내림 시간 간격</strong>: <span id="auctionDownTerm">${auction.down_term }</span><span> 시간</span></h4></div>
	  					</div>
	  					</c:if>
	  					<div style="border-bottom:1px solid #A6A6A6"><h4><strong>마감까지 남은 시간</strong>: <span id="currentTimelimit"></span></h4></div>
	  					<div style="border-bottom:1px solid #A6A6A6"><h4><strong>연관태그</strong>: <span id="relatedTags">${auction.tag }</span></h4></div>
	  					<div>
	  						<div class="form-group">
							  <h4><strong>상세 내용</strong></h4>
							  <div class="form-control" rows="9" id="comment" disabled>${auction.description }</div>
							</div>
	  					</div>
	  				</div>
  				</div>
  				
  				<!-- Trigger the modal with a button -->
  				
  				<c:if test="${member_id ne auction.member_id && auction.auction_status ne 'end' && auction.auction_status ne 'cancel' && auction.auction_status ne 'failbid' && not empty auction.auction_address}">
  					<c:choose>
  						<c:when test="${auction.type eq 2}">
		  					<button type="button" class="btn btn-danger" id="bidding_btn_down" onclick="makebiddingDown(${auction.auct_id },${member_id},'${auction.auction_address}')"><h4>입 찰 하 기</h4></button>
    					</c:when>
						<c:otherwise>
		  					<button type="button" class="btn btn-danger" id="bidding_btn" data-toggle="modal" data-target="#biddingModal"><h4>입 찰 하 기</h4></button>
    					</c:otherwise>
		        	</c:choose>
	        	</c:if>
	        	
				  <!-- Modal -->
				  <div class="modal" id="biddingModal">
				    <div class="modal-dialog modal-lg modal-dialog-centered">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">`
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title"></h4>
				        </div>
				        
				        <div class="modal-body">  
				        	<c:if test="${auction.type eq 2}">
							<div>
								<h4>현재 입찰가: <span id="currentPrice">${cur_price }</span></h4>
							</div>
							</c:if>
							<div id="inputPriceArea">
								<h4>입찰 제시 가격:&nbsp;</h4>
								<div>
									<input id="suggestedPrice" type="number" class="form-control" 
									min="0.001"  step="0.001" name="suggested_price">
								</div>
							</div>
							
							<div>
								<h4>경매 마감 시간: <span id="auctionDuedate">${due_date }</span></h4>
							</div>
							
							<div>
								<h4>마감까지 남은 시간: <span id="currentTimelimitModal"></span></h4>
							</div>
						
							<button class="btn btn-danger" id="bidding_submit_btn" onclick="makebidding(${auction.auct_id },${auction.type},${member_id},'${auction.auction_address}' );">입찰하기</button>
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
	

	<c:if test="${auction.type eq 1}">
		<script>
			getBidList("${auction.auct_id }", "${auction.auction_address }");
		</script>
		<div class="col-sm-10 text-left">
			<!-- Page Start -->
			<h3 style="margin-left:2%;"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;입찰 리스트</h3>
			<div class="panel panel-default" id="biddingList_panel">
	  			<div class="panel-body">
	  				<div class="panel panel-default" id="DBlist">
	  				<h4><strong>DataBase Info</strong></h4>
	  				<table id="databaseTable" border="1">
	  					
	  				</table>
	  				</div>
	  				
	  				<div class="panel panel-default" id="Contractlist">
	  				<h4><strong>Contract Info</strong></h4>
	  				<table id="contractTable" border="1">
	  				</table>
	  				
	  				</div>
	  			</div>
	  		</div>
	  	</div>
	</c:if>
</div>



</body>
</html>