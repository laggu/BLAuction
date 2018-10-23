<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BLAuction</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest JQuery -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Web3.js -->
<script src="javascript/web3.js"></script>
<script>
	$(document).ready(function (){
		$('#load').hide();
	})
</script>
</head>

<body>
<!-- Header -->
<!-- ********************************************************************************************* -->
<nav class="navbar navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="main.bla"><img src="img/logo.PNG"></a>
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">     
	  <div class="input-group" id="searchingbar_main">
	  	<form method="post" action="searchimpl.bla">
	  		<input type="text" class="form-control" placeholder="#" name="searchText">
	  	</form>
	  </div>

      <ul class="nav navbar-nav navbar-right" id="rightNav">
      	
      	<c:choose>
        	<c:when test="${loginStatus == null}">    		
        		<li><a href="login.bla"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        		<li><a href="register.bla"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
        	</c:when>
        	<c:otherwise>
        		<li><a href="createAuction.bla"><img src="img/auction.png"></img>경매등록</a></li>
      			<li><a href="mypage.bla"><img src="img/info.png"></img>마이페이지</a></li>
        		<li><a href="logout.bla"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        		<script>
        			var member_id_session = "${member_id}";
        			var member_account_session = "${member_account}";
        			var name_session = "${name}";
        		</script>
        	</c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>

<!-- Center -->
<!-- ********************************************************************************************* -->	 
<div class="container-fluid text-center">   
  <div class="row content">
  
    <!-- Menu Navigation -->
    <div class="col-sm-2 sidenav" id="menu">
      <div>
      	<p><a href="allCategory.bla"><strong>전체 카테고리</strong></a></p>
      </div>
      <div id="menu_category">
	    <p><a href="category.bla?category=1">의류/잡화</a></p>
	    <p><a href="category.bla?category=2">뷰티/미용</a></p>
	    <p><a href="category.bla?category=3">스포츠/레저</a></p>
	    <p><a href="category.bla?category=4">디지털/가전</a></p>
	    <p><a href="category.bla?category=5">생활/가구</a></p>
	    <p><a href="category.bla?category=6">기타</a></p>
      </div>
    </div>
    <!-- Content -->
    <!-- ***************************************************************************************** -->	
    	<c:choose>
    		<c:when test="${centerpage != null}">
    			<jsp:include page="${centerpage }.jsp"></jsp:include>
    		</c:when>
    		<c:otherwise>
    			<jsp:include page="center.jsp"></jsp:include>
    		</c:otherwise>
    	</c:choose>
    <!-- ***************************************************************************************** -->	 
  </div>
</div>

<!-- Footer -->
<!-- ********************************************************************************************* -->
<footer class="container-fluid text-center">
  <p>created by Team20's designed by Eileen</p>
</footer>

<!-- Loading bar -->
<div id="load">
	<img src="img/loading.gif" alt="loading">
</div>

</body>
</html>