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
                            <h2>Member List</h2>
                        </div>
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>E-mail</th>
                                        <th>Name</th>
                                        <th>Address</th>
                                        <th>Phone</th>
                                        <th>Birth</th>
                                        <th>Score</th>
                                        <th>Likes</th>
                                        <th>Account</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                <c:forEach var="item" items="${list }">
	                                    <tr>
	                                        <td><a href="admin_member_detail.bla?id=${item.getMember_id() }">${item.getMember_id() }</a></td>
	                                        <td>${item.getEmail() }</td>
	                                        <td>${item.getName() }</td>
	                                        <td>${item.getAddress() }</td>
	                                        <td>${item.getPhone() }</td>
	                                        <td>${item.getBirth() }</td>
	                                        <td>${item.getScore() }</td>
	                                        <td>${item.getLikes() }</td>
	                                        <td>${item.getMember_account() }</td>
	                                    </tr>
	                             </c:forEach>  
	                             </tbody>
                                
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>E-mail</th>
                                        <th>Name</th>
                                        <th>Address</th>
                                        <th>Phone</th>
                                        <th>Birth</th>
                                        <th>Score</th>
                                        <th>Likes</th>
                                        <th>Account</th>
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