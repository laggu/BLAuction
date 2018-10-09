<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_물품 상세</title>
</head>
<body>

<!-- Content -->
<div id="detail_area">
	<div class="col-sm-10 text-left">
		<!-- Page Start -->
		<h3><img src="img/auction.png" id="detail_logo"></img>물품 상세</h3>
		<div class="panel panel-default" id="detail_panel">
  			<div class="panel-body">
  			
  				<div id="detail_top">
	  				<div id="detail_pic"><img src="img/se.jpg"></div>
	  				<div id="first_info">
	  					<div><h4>카테고리: <span id="detailCategory"></span></h4></div>
	  					<div><h4>경매종류: <span id="detailKind"></span></h4></div>
	  					<div><h4>경매제목: <span id="detailTitle"></span></h4></div>
	  				</div>
  				</div>
  				
  				<div id="detail_bottom">
	  				<div id="second_info">
	  					<div id="oneLine">
	  						<div><h4>현재 입찰가: <span id="currentPrice"></span></h4></div>
	  						<div><h4>경매 남은 시간: <span id="currentTimelimit"></span></h4></div>
	  					</div>
	  					<div style="border-bottom:1px solid #A6A6A6"><h4>연관태그: <span id="relatedTags"></span></h4></div>
	  					<div>
	  						<div class="form-group">
							  <h4>상세 내용</h4>
							  <textarea class="form-control" rows="9" id="comment" disabled></textarea>
							</div>
	  					</div>
	  				</div>
  				</div>
  				
  				<button type="button" class="btn btn-danger" id="bidding_btn"><h4>입 찰 하 기</h4></button>
  				
  			</div>
		</div>
	  
	</div>
</div>
    
</body>
</html>