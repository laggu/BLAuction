<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction 의류/잡화</title>
</head>
<body>

	<!-- Content -->
	<div id="list_area">
		<div class="col-sm-10 text-left">

			<!-- sorting method -->
			<div class="dropdown" id="sortingMethod">
				<button class="btn btn-default dropdown-toggle" type="button"
					data-toggle="dropdown">
					경매 정렬 기준 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">최신 등록순</a></li>
					<li><a href="#">마감 입박순</a></li>
				</ul>
			</div>

			<!-- Cards -->

			<div class="card group" id="category_group">




				<c:forEach var="item" items="${list }">

				<!-- Row -->
				<div class="card-columns">

					<div class="card" style="width: 18rem;">
						<h5 class="card-title" id="time_limit">마감시간 : ${item.getDuedate() }</h5>
						<a href="auctiondetail.bla?auctionid=${item.getAuction().getAuct_id() }"><img
							class="card-img-top" src="${item.getPhoto_path_1() }" alt="Card image cap"></a>
						<div class="card-body">
							<a href="auctiondetail.bla?auctionid=${item.getAuction().getAuct_id() }" class="card-text"
								id="auction_name">제목 : ${item.getAuction().getAuct_title() }</a>
							<p class="card-text" id="auction_price"> 현재 입찰가 : ${item.getMax_price() }</p>
						</div>
					</div>
					
				</div>
				
				</c:forEach>
				
				
				
				
				
				
				
				
				
				
				

			</div>
		</div>

		<!-- Pagination -->
		<div class="container" id="pagination_area">
			<ul class="pagination">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item"><a class="page-link" href="#">6</a></li>
				<li class="page-item"><a class="page-link" href="#">7</a></li>
				<li class="page-item"><a class="page-link" href="#">8</a></li>
				<li class="page-item"><a class="page-link" href="#">9</a></li>
				<li class="page-item"><a class="page-link" href="#">10</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</div>
	</div>
</body>
</html>