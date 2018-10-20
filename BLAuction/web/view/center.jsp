<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="col-sm-10 text-left">

			<!-- Carousel -->
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/nike.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="img/digital.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>

					<div class="item">
						<img src="img/furniture.jpg" alt="...">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>


			<!-- Cards -->

			<div class="card group" id="card_group">

					<!-- Row -->
					<div class="card-columns" style="height:400px">
						<h2>Best of the week</h2>
						<c:forEach var="item" items="${list }">
						<div class="card" style="width: 18rem;">
							<h5 class="card-title" id="time_limit">마감시간 :
								${item.getDuedate() }</h5>
							<a href="auctiondetail.bla?auctionid=${item.getAuction().getAuct_id() }"><img
								class="card-img-top" src="${item.getPhoto_path_1() }"
								alt="Card image cap"></a>
							<div class="card-body">
								<a
									href="auctiondetail.bla?auctionid=${item.getAuction().getAuct_id() }"
									class="card-text" id="auction_name">제목 :
									${item.getAuction().getAuct_title() }</a>
								<p class="card-text" id="auction_price">현재 입찰가 :
									${item.getMax_price() }</p>
							</div>
						</div>
						</c:forEach>
					</div>

					<!-- Row -->
					<div class="card-columns">
						<h2>Recommendation</h2>
						<c:forEach var="item" items="${list }">
						<div class="card" style="width: 18rem;">
							<h5 class="card-title" id="time_limit">마감시간 :
								${item.getDuedate() }</h5>
							<a
								href="auctiondetail.bla?auctionid=${item.getAuction().getAuct_id() }"><img
								class="card-img-top" src="${item.getPhoto_path_1() }"
								alt="Card image cap"></a>
							<div class="card-body">
								<a
									href="auctiondetail.bla?auctionid=${item.getAuction().getAuct_id() }"
									class="card-text" id="auction_name">제목 :
									${item.getAuction().getAuct_title() }</a>
								<p class="card-text" id="auction_price">현재 입찰가 :
									${item.getMax_price() }</p>
							</div>
						</div>
						</c:forEach>
					</div>

				
			</div>
		</div>
	</div>
</body>
</html>