<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction_admin</title>
<script>
	
</script>
</head>
<body>
	<!-- Breadcomb area Start-->
	<div class="data-table-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="data-table-list">
						<h2>${member.getName() }</h2>
						<hr>
						<table class="table table-striped">
							<tbody>
								<tr>
									<th>Member ID</th>
									<td>${member.getMember_id() }</td>
									<th>Birth</th>
									<td>${member.getBirth() }</td>
								</tr>
								<tr>
									<th>Phone</th>
									<td>${member.getPhone() }</td>
									<th>Email</th>
									<td>${member.getEmail() }</td>
								</tr>
								<tr>
									<th>Address</th>
									<td colspan="3">${member.getAddress() }</td>
								</tr>
								<tr>
									<th>Account</th>
									<td colspan="3">${member.getMember_account() }</td>
								</tr>
								<tr>
									<th>Score</th>
									<td>${member.getScore() }</td>
									<th>Likes</th>
									<td>${member.getLikes() }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcomb area End-->
	
	<!-- Data Table area Start-->
	<div class="data-table-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Created Auction List</h2>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Auction ID</th>
                                        <th>Due date</th>
                                        <th>Type</th>
                                        <th>Category</th>
                                        <th>Start Price</th>
                                        <th>Current Price</th>
                                        <th>Down Price</th>
                                        <th>Down Term</th>
                                        <th>Status</th>
                                        <th>Contract Address</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                <c:forEach var="item" items="${created_list }">
	                                    <tr>
	                                        <td><a href="admin_auction_detail.bla?id=${item.getAuction().getAuct_id() }">${item.getAuction().getAuct_id() }</a></td>
	                                        <td>${item.getDuedate() }</td>
	                                        <td>${item.getAuction().getType() }</td>
	                                        <td><a href="admin_category.bla?id=${item.getAuction().getCategory_id() }">${item.getAuction().getCategory_id() }</a></td>
	                                        <td>${item.getAuction().getStart_price() }</td>
	                                        <td>${item.getMax_price() }</td>
	                                        <td>${item.getAuction().getDown_price() }</td>
	                                        <td>${item.getAuction().getDown_term() }</td>
	                                        <td><a href="admin_status.bla?status=${item.getAuction().getAuction_status() }">${item.getAuction().getAuction_status() }</a></td>
                                        	<td>${item.getAuction().getAuction_address() }</td>
	                                    </tr>
	                             </c:forEach>  
	                             </tbody>
                                
                                <tfoot>
                                    <tr>
                                        <th>Auction ID</th>
                                        <th>Due date</th>
                                        <th>Type</th>
                                        <th>Category</th>
                                        <th>Start Price</th>
                                        <th>Current Price</th>
                                        <th>Down Price</th>
                                        <th>Down Term</th>
                                        <th>Status</th>
                                        <th>Contract Address</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Bid Auction List</h2>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Auction ID</th>
                                        <th>Due date</th>
                                        <th>Type</th>
                                        <th>Category</th>
                                        <th>Start Price</th>
                                        <th>Current Price</th>
                                        <th>Down Price</th>
                                        <th>Down Term</th>
                                        <th>Status</th>
                                        <th>Contract Address</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                <c:forEach var="item" items="${bid_list }">
	                                    <tr>
	                                        <td><a href="admin_auction_detail.bla?id=${item.getAuction().getAuct_id() }">${item.getAuction().getAuct_id() }</a></td>
	                                        <td>${item.getDuedate() }</td>
	                                        <td>${item.getAuction().getType() }</td>
	                                        <td><a href="admin_category.bla?id=${item.getAuction().getCategory_id() }">${item.getAuction().getCategory_id() }</a></td>
	                                        <td>${item.getAuction().getStart_price() }</td>
	                                        <td>${item.getMax_price() }</td>
	                                        <td>${item.getAuction().getDown_price() }</td>
	                                        <td>${item.getAuction().getDown_term() }</td>
	                                        <td><a href="admin_status.bla?status=${item.getAuction().getAuction_status() }">${item.getAuction().getAuction_status() }</a></td>
                                        	<td>${item.getAuction().getAuction_address() }</td>
	                                    </tr>
	                             </c:forEach>  
	                             </tbody>
                                
                                <tfoot>
                                    <tr>
                                        <th>Auction ID</th>
                                        <th>Due date</th>
                                        <th>Type</th>
                                        <th>Category</th>
                                        <th>Start Price</th>
                                        <th>Current Price</th>
                                        <th>Down Price</th>
                                        <th>Down Term</th>
                                        <th>Status</th>
                                        <th>Contract Address</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
			</div>
		</div>
	</div>
	<!-- Data Table area End-->

</body>
</html>