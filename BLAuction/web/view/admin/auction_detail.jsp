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
										<h2>${auction.getAuct_title() }</h2>
										<hr>
										<table class="table table-striped">
											<tbody>
												<tr>
													<th>Host Account</th>
													<td colspan="3">${auction.getSeller_account() }</td>
												</tr>
												<tr>
													<th>Auction ID</th>
													<td>${auction.getAuct_id() }</td>
													<th>Host ID</th>
													<td>${auction.getMember_id() }</td>
												</tr>
												<tr>
													<th>Type ID</th>
													<td>${auction.getType() }</td>
													<th>Category ID</th>
													<td>${auction.getCategory_id() }</td>
												</tr>
												<tr>
													<th>Due Date</th>
													<td>${due_date }</td>
													<th>Register Date</th>
													<td>${register_date }</td>
												</tr>
												<c:if test="${auction.getCategory_id() == 2 }">
												<tr>
													<th>Down Price</th>
													<td>${auction.getDown_price() }</td>
													<th>Down Term</th>
													<td>${auction.getDonw_term() }</td>
												</tr>
												</c:if>
												<tr>
													<th>Current Price</th>
													<td>${cur_price }</td>
													<th>Start Price</th>
													<td>${auction.getStart_price() }</td>
												</tr>
											</tbody>
										</table>
										<div>${auction.getDescription() }</div>
										<p>Tag : ${auction.getTag() }</p>
										<br>
										<div id="detail_pic"><img src="${photo1 }"></div>
										<div id="detail_pic"><img src="${photo2 }"></div>
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
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Bidding List</h2>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Bidding ID</th>
                                        <th>Member ID</th>
                                        <th>Price</th>
                                        <th>Time</th>
                                        <th>Status</th>
                                        <th>Member Account</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                <c:forEach var="item" items="${list }">
	                                    <tr>
	                                        <td>${item.getBidding().getBid_id() }</td>
	                                        <td>${item.getBidding().getMember_id() }</td>
	                                        <td>${item.getBidding().getPrice() }</td>
	                                        <td>${item.getDuedate() }</td>
	                                        <td>${item.getBidding().getBid_conf_status() }</td>
	                                        <td>${item.getBidding().getBidder_account() }</td>
	                                    </tr>
	                             </c:forEach>
	                             </tbody>
                                
                                <tfoot>
                                    <tr>
                                        <th>Bidding ID</th>
                                        <th>Member ID</th>
                                        <th>Price</th>
                                        <th>Time</th>
                                        <th>Status</th>
                                        <th>Member Account</th>
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