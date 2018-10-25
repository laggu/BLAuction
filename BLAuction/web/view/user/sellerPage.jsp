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
<script>
$(document).ready(function(){	
	//Tab 전환
	$(".nav-tabs a").click(function(){
	        $(this).tab('show');
	});
	$('#load').show();
	
	var seller_id = '${seller_info.member_id}';
	var salesAmount = 0;
	var completeAmount = 0;
	
	//판매자가 올린 경매 리스트
	$.ajax({
		type : 'POST',
		url : 'myauctionlist.bla', /* DB로 접근 */
		data: {
			'seller_id':seller_id
		},
		datatype : 'json',
		success : function(data) {
			
			var sellinglists = $('#sellinglists');
				
			var sellinglist = '';

			var before = data.before;
			var proceeding = data.proceeding;
			var end = data.end;
			var cancel = data.cancel;
			var failbid = data.failbid;
			
			for(i in before){
				salesAmount++;
				sellinglist += '<div class="panel panel-default" id="selling_panel">';
				sellinglist += '<div class="panel-body">';
				sellinglist += '<div id="sellingImg"><a href="auctiondetail.bla?auctionid='+before[i].auct_id+'" id="beforeA'+i+'"><img style="width:240px;height:200px;" id="beforeImg'+i+'" src="'+before[i].photoPath0+before[i].photoName0+'"></a></div>';
				
				if(before[i].photoPath1 != 'undefined'){
					$('#beforeA'+i).on('hover',function(){
						$('#beforeImg'+i).attr("src",before[i].photoPath1+before[i].photoName1);
					});
				}
				
				sellinglist += '<div id="sellingInfo">';
				sellinglist += '<div id="sellingInfoTitle"><h4><strong>'+before[i].auct_title+'</strong></h4><button type="button" class="btn btn-default" id="sellingbidStatus" disabled>입찰전</button></div>';
				sellinglist += '<div>입찰 시작가: <span id="sellingbidPrice">'+before[i].start_price*0.001+' Ether</span></div>';
				sellinglist += '</div></div></div>';
			}
			
			for(i in end){
				salesAmount++;
				completeAmount++;
				sellinglist += '<div class="panel panel-default" id="selling_panel">';
				sellinglist += '<div class="panel-body">';
				sellinglist += '<div id="sellingImg"><a href="auctiondetail.bla?auctionid='+end[i].auct_id+'"><img style="width:240px;height:200px;" src="'+end[i].photoPath0+end[i].photoName0+'"></a></div>';
				sellinglist += '<div id="sellingInfo">'; 
				sellinglist += '<div id="sellingInfoTitle">';
				sellinglist += '<h4><strong>'+end[i].auct_title+'</strong></h4>';
				sellinglist += '<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>경매 완료</button></div>';
				sellinglist += '</div></div></div>';
			}
			
			for(i in proceeding){
				salesAmount++;
				sellinglist += '<div class="panel panel-default" id="selling_panel">';
				sellinglist += '<div class="panel-body">';
				sellinglist += '<div id="sellingImg"><a href="auctiondetail.bla?auctionid='+proceeding[i].auct_id+'"><img style="width:240px;height:200px;" src="'+proceeding[i].photoPath0+proceeding[i].photoName0+'"></a></div>';
				sellinglist += '<div id="sellingInfo">';		
				sellinglist += '<div id="sellingInfoTitle"><h4><strong>'+proceeding[i].auct_title+'</strong></h4>';
				sellinglist += '<button type="button" class="btn btn-default" id="myauctionbidStatus" disabled>입찰 중</button></div>';
				sellinglist += '<div>현재 최고가: <span id="sellingbidPrice">'+proceeding[i].bidMaxPrice*0.001+' Ether</span></div>';	
				sellinglist += '<div>경매 마감 시간: <span id="sellingbidDuedate">'+proceeding[i].dueDate+'</span></div>';
				sellinglist += '</div></div></div>';
				
			}
			
			for(i in cancel){
				salesAmount++;
				sellinglist +='<div class="panel panel-default" id="selling_panel">';
				sellinglist +='<div class="panel-body">';
				sellinglist +='<div id="sellingImg"><a href="auctiondetail.bla?auctionid='+cancel[i].auct_id+'"><img style="width:240px;height:200px;" src="'+cancel[i].photoPath0+cancel[i].photoName0+'"></a></div>';
				sellinglist +='<div id="sellingInfo">';
				sellinglist +='<div id="sellingInfoTitle"><h4><strong>'+cancel[i].auct_title+'</strong></h4>';
				sellinglist +='<button type="button" class="btn btn-default" id="sellingbidStatus" disabled>취소된 경매</button></div>';
				sellinglist +='</div></div></div>';
				
			}
			
			for(i in failbid){
				salesAmount++;
				sellinglist +='<div class="panel panel-default" id="selling_panel">';
				sellinglist +='<div class="panel-body">';
				sellinglist +='<div id="sellingImg"><a href="auctiondetail.bla?auctionid='+failbid[i].auct_id+'" id="failbidA'+i+'"><img style="width:240px;height:200px;" id="failbidImg'+i+'" src="'+failbid[i].photoPath0+failbid[i].photoName0+'"></a></div>';
				sellinglist +='<div id="sellingInfo">';
				sellinglist +='<div id="sellingInfoTitle"><h4><strong>'+failbid[i].auct_title+'</strong></h4>';
				sellinglist +='<button type="button" class="btn btn-default" id="sellingbidStatus" disabled>유찰된 경매</button></div>';
				sellinglist +='</div></div></div>';
			}
			
			sellinglists.append(sellinglist);
			$('#load').hide();
			
			var numofRegauction = $('#numofRegauction');
			numofRegauction.text(salesAmount);
			var numofComplitedauction = $('#numofComplitedauction');
			numofComplitedauction.text(completeAmount);
		},
		error : function(data) {
			alert("판매 리스트를 불러오는데 실패했습니다. 새로고침 해주세요");
		}
	});
	
	//후기 리스트 띄어주기.
	$.ajax({
		type : 'POST',
		url : 'sellerReview.bla', /* DB로 접근 */
		data: {
			'seller_id':seller_id
		},
		datatype : 'json',
		success : function(data) {
			var reviewLists = $('#reviewlists');
			var reviewList = '';
			for(i in data){
				reviewList +='<div class="panel panel-default" id="review_panel">';
				reviewList += '<div class="panel-body">';
				reviewList += '<div id="reviewImg"><img style="width:240px;height:200px;" src="'+data[i].photoPath0+data[i].photoName0+'"></div>';
				reviewList += '<div id="reviewInfo">';
				reviewList += '<div><h4><strong>'+data[i].name+'</strong></h4></div>';
				reviewList += '<div>낙찰가: <span id="successfulbidPrice">'+data[i].price*0.001+' Ether</span></div>';
				reviewList += '<div class="form-group">';
				reviewList += '<textarea class="form-control" rows="2" id="reviewComment" disabled>'+data[i].review+'</textarea>';
				reviewList += '</div></div></div></div>';
			}
			
			reviewLists.append(reviewList);
			
  			
						
		},
		error : function(data) {
			alert("후기리스트를 불러오는데 문제가 생겼습니다. 새로고침 해주세요");
		}
	});
	
	
	
});
</script>
<style>
</style>
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
			    
			  </div>
			  <div id="sellinglists" class="tab-pane fade">
			    <!-- Panel -->
			    
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