<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Summernote API -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src="javascript/auction/register.js"></script>

<title>BLAuction_경매 등록</title>
</head>
<body>

<!-- Content -->
<div id="register_area">
	<div class="col-sm-10 text-left">
		<!-- Page Start -->
		<h3><img src="img/auction.png" id="register_logo"></img>경매 등록</h3>
		<div class="panel panel-default" id="register_panel">
  			<div class="panel-body">
  			
	  			<div id="register_top">
		  				<div id="register_pic1"><button type="button" class="btn btn-default">사진등록</button></div>
		  				<div id="register_pic2"><button type="button" class="btn btn-default">사진등록</button></div>
		  				<div id="register_info1">
		  					<div>
		  						<div class="form-group">
								  <h4>#카테고리 </h4>
								  <select class="form-control" id="registerCategory">
								    <option>의류/잡화</option>
								    <option>뷰티/미용</option>
								    <option>스포츠/레저</option>
								    <option>디지털/가전</option>
								    <option>생활/가구</option>
								    <option>기타</option>
								  </select>
								</div>
		  					</div>
		  					<div>
		  						<div class="form-group">
								  <h4>#경매종류 </h4>
								  <select class="form-control" id="registerKind">
								    <option>올림경매</option>
								    <option>내림경매</option>
								    <option>비밀경매</option>
								  </select>
								</div>
		  					</div>
		  					
		  				</div>
	  				</div>
	  				
	  				<div id="register_bottom">
		  				<form class="form-horizontal" action="createAuctionimpl.bla">
		  					<div class="form-group" id="register_title">
							    <h4>경매 제목: </h4>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="registerTitle" placeholder="원하는 제목을 20자 내로 작성해주세요:)">
							    </div>
							</div>

		  					<div style="margin-left:-2%;margin-bottom:4%;" class="form-group" id="start_price">
		  						<h4>경매 시작 가격: </h4>
		  						<div class="col-sm-6">
							      <input type="text" class="form-control" id="startPrice" placeholder="0.001 Ether">
							    </div>
		  					</div>
		  					
		  					<div>
		  						<div class="form-group">
								  <h4>상세 내용</h4>
								  <!-- <textarea class="form-control" rows="9" id="comment"></textarea> -->
								  <div id="summernote">summernote</div>
								</div>
		  					</div>
		  					
		  					<div class="form-group">
							    <h4>연관 태그</h4>
							    <input type="text" class="form-control" id="registerTags" placeholder="#패션 #시계 #저렴이 #고렴이 #명품">
							  </div>
		  					
		  						<div class="form-group"> 
								    <div class="col-sm-offset-2 col-sm-10">
								      <button type="submit" class="btn btn-danger" id="register_btn"><h4>등 록 하 기</h4></button>
								    </div>
								</div>
		  					</form>
		  				</div>
	  				</div>
	  					
  				
  			</div>
		</div>
	  

</div>
    
</body>
</html>