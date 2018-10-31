<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction 모든카테고리</title>
<script>
	var clothing = 0;
	var beauty = 0;
	var sports = 0;
	var digital = 0;
	var furniture = 0;
	var enc = 0;
	
	function print_category(due_date, auct_id, photo_path_1, auct_title, max_price, category_id) {
		if(category_id == 1){
			clothing++;
			if(clothing < 5){
				$("#list_div"+category_id).append(''+
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
		}else if(category_id == 2){
			beauty++;
			if(beauty < 5){
				$("#list_div"+category_id).append(''+
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
		}else if(category_id == 3){
			sports++;
			if(sports < 5){
				$("#list_div"+category_id).append(''+
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
		}else if(category_id == 4){
			digital++;
			if(digital < 5){
				$("#list_div"+category_id).append(''+
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
		}else if(category_id == 5){
			furniture++;
			if(furniture < 5){
				$("#list_div"+category_id).append(''+
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
		}else if(category_id == 6){
			enc++;
			if(enc < 5){
				$("#list_div"+category_id).append(''+
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
		}
		
		
	}
</script>
<script>
$(document).ready(function(){
	$("#thelatest").on("click", function(event){
	});
	$("#closedeadline").on("click", function(event){
	});
});
</script>
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
					<li><a href="#" id="thelatest">최신 등록순</a></li>
					<li><a href="#" id="closedeadline">마감 입박순</a></li>
				</ul>
			</div>

			<!-- Cards -->

			<div class="card group" id="card_group">
			
			<h2>의류 / 잡화</h2>
				<div id="list_div1" class="card-columns" style="height: 400px"></div>

				<h2>뷰티 / 미용</h2>
				<div id="list_div2" class="card-columns" style="height: 400px"></div>

				<h2>스포츠 / 레저</h2>
				<div id="list_div3" class="card-columns" style="height: 400px"></div>

				<h2>디지털 / 가전</h2>
				<div id="list_div4" class="card-columns" style="height: 400px"></div>

				<h2>생활 / 가구</h2>
				<div id="list_div5" class="card-columns" style="height: 400px"></div>

				<h2>기타</h2>
				<div id="list_div6" class="card-columns" style="height: 400px"></div>
			
				<c:forEach var="item" items="${list }">
				
					<script>
						print_category("${item.getDuedate() }", "${item.getAuction().getAuct_id() }", "${item.getPhoto_path_1() }", "${item.getAuction().getAuct_title() }", "${item.getMax_price() }", "${item.getAuction().getCategory_id() }");
					</script>
				
				</c:forEach>
				
			</div>
		</div>
	</div>
	
</body>
</html>