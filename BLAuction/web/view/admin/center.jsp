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

    <!-- Data Table area Start-->
    <div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                        <div class="basic-tb-hd">
                            <h2>Basic Example</h2>
                            <p>It's just that simple. Turn your simple table into a sophisticated data table and offer your users a nice experience and great features without any effort.</p>
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
	                                        <td>${item.getAuction().getAuct_id() }</td>
	                                        <td>${item.getAuction().getMember_id() }</td>
	                                        <td>${item.getDuedate() }</td>
	                                        <td>${item.getAuction().getType() }</td>
	                                        <td>${item.getAuction().getCategory_id() }</td>
	                                        <td>${item.getAuction().getStart_price() }</td>
	                                        <td>${item.getMax_price() }</td>
	                                        <td>${item.getAuction().getDown_price() }</td>
	                                        <td>${item.getAuction().getDown_term() }</td>
	                                        <td>${item.getAuction().getAuction_status() }</td>
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