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
	$("#delete_null_auction").click(function(){
		deleteNullAuction();
	})		
})

function deleteNullAuction(){
	console.log("deleteNull()")
	$.ajax({
		type:'POST',
		url:'/BLAuction/admin_delete_null_auction.bla',
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
                            <h2>Auction List</h2>
                            <c:if test="${unconfirmed != null}">
                            	<hr>
                            	<button id="delete_null_auction" class="btn">DELETE</button>
                            	<p><span style="color:red;">Delete</span> the auctions unconfirmed in 24 hrs</p>
                            </c:if>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Auction ID</th>
                                        <th>Host ID</th>
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
                                <c:forEach var="item" items="${list }">
	                                    <tr>
	                                        <td><a href="admin_auction_detail.bla?id=${item.getAuction().getAuct_id() }">${item.getAuction().getAuct_id() }</a></td>
	                                        <td><a href="admin_member_detail.bla?id=${item.getAuction().getMember_id() }">${item.getAuction().getMember_id() }</a></td>
	                                        <td>${item.getDuedate() }</td>
	                                        <td><a href="admin_type.bla?id=${item.getAuction().getType() }">${item.getAuction().getType() }</a></td>
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
                                        <th>Host ID</th>
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