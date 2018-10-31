<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction</title>
<script>
	function print_category(due_date, auct_id, photo_path_1, auct_title, max_price, index) {
		$("#list_div"+index).append(''+
					'<div class="card" style="width: 18rem;">'+
					'<h5 class="card-title" id="time_limit">마감시간 : '+ due_date + '</h5>' +
					'<a href="auctiondetail.bla?auctionid=' + auct_id + '">' + 
					'<img class="card-img-top" src="' + photo_path_1 + '" alt="Card image cap"></a>'+
					'<div class="card-body">' + 
					'<a href="auctiondetail.bla?auctionid=' + auct_id + '" class="card-text" id="auction_name">' +
					'제목 : ' + auct_title + '</a>' + 
					'<p class="card-text" id="auction_price">현재 입찰가 : ' + max_price*0.001 + ' Ether</p>'+
					'</div></div>')
	}
</script>
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
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/ad1.png" alt="...">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="img/ad2.png" alt="...">
						<div class="carousel-caption"></div>
					</div>

					<div class="item">
						<img src="img/ad3.png" alt="...">
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
			
			<h2> DOWN AUCTION </h2>
			<div id="list_div1" class="card-columns" style="height: 400px"></div>
			
			<h2> 마감임박 </h2>
			<div id="list_div2" class="card-columns" style="height: 400px"></div>
			
				<c:forEach var="item" items="${down_list }">
				
					<script>
						print_category("${item.getDuedate() }", "${item.getAuction().getAuct_id() }", "${item.getPhoto_path_1() }", "${item.getAuction().getAuct_title() }", "${item.getMax_price() }", 1);
					</script>
				
				</c:forEach>
				
				<c:forEach var="item" items="${time_list }">
				
					<script>
						print_category("${item.getDuedate() }", "${item.getAuction().getAuct_id() }", "${item.getPhoto_path_1() }", "${item.getAuction().getAuct_title() }", "${item.getMax_price() }", 2);
					</script>
				
				</c:forEach>
				
			</div>
		</div>
	</div>
</body>
</html>