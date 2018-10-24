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

	<div class="login-content">
		<!-- Login -->
		<div class="nk-block toggled" id="l-login">
		<form action="admin_loginimpl.bla" method="POST">
			<div class="nk-form">
				<div class="input-group mg-t-15">
					<span class="input-group-addon nk-ic-st-pro"><i
						class="notika-icon notika-edit"></i></span>
					<div class="nk-int-st">
						
						<input type="password" name="admin_code" class="form-control" placeholder="Admin Code">
						
					</div>
					
				</div>
				<button type="submit"
					class="btn btn-login btn-success btn-float"><i
					class="notika-icon notika-right-arrow right-arrow-ant"></i></button>
			</div>
			<c:if test="${admin_status == 0}">
				<script>
					alert("Please Check the Code..")
				</script>
			</c:if>
			</form>
		</div>
	</div>

</body>
</html>