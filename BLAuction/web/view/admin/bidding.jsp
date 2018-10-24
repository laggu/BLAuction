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
$(document).ready(function(){
	$("#delete_null_bidding").click(function(){
		deleteNullBidding();
	})		
})

function deleteNullBidding(){
	console.log("deleteNull()")
	$.ajax({
		type:'POST',
		url:'/BLAuction/admin_delete_null_bidding.bla',
		processData: false,
        contentType: false,
		success:function(data){
			alert("Successfully Deleted");
			location.reload();
		},
		error:function(data){
			alert("Failed");
		}
	})
}
</script>
</head>
<body>

    <!-- Data Table area Start-->
    <div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Bidding List</h2>
                            <hr>
                          	<button id="delete_null_bidding" class="btn">DELETE</button>
                          	<p><span style="color:red;">Delete</span> the biddings unconfirmed in 24 hrs</p>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Bidding ID</th>
                                        <th>Member ID</th>
                                        <th>Member Account</th>
                                        <th>Auction ID</th>
                                        <th>Price</th>
                                        <th>Time</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                <c:forEach var="item" items="${list }">
	                                    <tr>
	                                        <td>${item.getBidding().getBid_id() }</td>
	                                        <td><a href="admin_member_detail.bla?id=${item.getBidding().getMember_id() }">${item.getBidding().getMember_id() }</a></td>
	                                        <td>${item.getBidding().getBidder_account() }</td>
	                                        <td><a href="admin_auction_detail.bla?id=${item.getBidding().getBidder_account() }">${item.getBidding().getAuct_id() }</a></td>
	                                        <td>${item.getBidding().getPrice() }</td>
	                                        <td>${item.getDuedate() }</td>
	                                        <td>${item.getBidding().getBid_conf_status() }</td>
	                                    </tr>
	                             </c:forEach>  
	                             </tbody>
                                
                                <tfoot>
                                    <tr>
                                        <th>Bidding ID</th>
                                        <th>Member ID</th>
                                        <th>Member Account</th>
                                        <th>Auction ID</th>
                                        <th>Price</th>
                                        <th>Time</th>
                                        <th>Status</th>
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