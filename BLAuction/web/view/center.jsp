<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction</title>
</head>
<body>

<!-- Content -->
<div id="list_area">
 <div class="col-sm-8 text-left">
 	
 	 <!-- Carousel -->
	 <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="img/nike.jpg" alt="...">
	      <div class="carousel-caption">
	      </div>
	    </div>
	    <div class="item">
	      <img src="img/digital.jpg" alt="...">
	      <div class="carousel-caption">
	      </div>
	    </div>
	    
	    <div class="item">
	      <img src="img/furniture.jpg" alt="...">
	      <div class="carousel-caption">
	      </div>
	    </div>
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
 	
 
 
 	<!-- Cards -->
 	
	<div class="card group" id="card_group">
	
	<div class="card-columns">
	
	  <div class="card" style="width: 18rem;">
	  	<h5 class="card-title" id="time_limit">12:00:00</h5>
		  <a href="auctiondetail.bla?auctionid=auctionid"><img class="card-img-top" src="img/se.jpg" alt="Card image cap"></a>
		  <div class="card-body">
		    <a href="auctiondetail.bla?auctionid=auctionid" class="card-text" id="auction_name">iPhone SE(rose gold)</a>
		    <p class="card-text" id="auction_price">38</p>
		  </div>
	  </div>
	  
	  <div class="card" style="width: 18rem;">
	  	<h5 class="card-title" id="time_limit">12:00:00</h5>
		  <a href="auctiondetail.bla?auctionid=auctionid"><img class="card-img-top" src="img/se.jpg" alt="Card image cap"></a>
		  <div class="card-body">
		    <a href="auctiondetail.bla?auctionid=auctionid" class="card-text" id="auction_name">iPhone SE(rose gold)</a>
		    <p class="card-text" id="auction_price">38</p>
		  </div>
	  </div>
	  
	 </div>
	</div>
</div>
</div>
  
</body>
</html>