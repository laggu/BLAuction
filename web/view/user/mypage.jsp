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
  				
  			</div>
		</div>
		
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
	  
	</div>
</div>
    
</body>
</html>