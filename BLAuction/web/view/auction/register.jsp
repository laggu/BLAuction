<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Summernote API -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src="javascript/auction/register.js"></script>

<style>
input.upload1 {
	opacity: 0; /*input type="file" tag 투명하게 처리*/
	position: relative;
}

input.upload2 {
	opacity: 0; /*input type="file" tag 투명하게 처리*/
	position: relative;
}

button#replace1 { /*button tag 에 원하는 스타일 적용*/
	position: absolute;
}

button#replace2 { /*button tag 에 원하는 스타일 적용*/
	position: absolute;
}
</style>

<script>
	$(document).ready(function() {
		$("#replace1").click(function() {
			$("#upload1").trigger('click');
		});
		$("#replace2").click(function() {
			$("#upload2").trigger('click');
		});
		
		$("#upload1").on('change', function() {
	        //Get count of selected files
	        var countFiles = $(this)[0].files.length;
	        var imgPath = $(this)[0].value;
	        var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	        var image_holder = $("#register_pic1");
	        image_holder.empty();
	        if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	          if (typeof(FileReader) != "undefined") {
	            //loop for each file selected for uploaded.
	            for (var i = 0; i < countFiles; i++) 
	            {
	              var reader = new FileReader();
	              reader.onload = function(e) {
	                $("<img />", {
	                  "src": e.target.result,
	                  "class": "thumb-image",
	                  "style" : "height: 248.021px; width:288.021px;"
	                }).appendTo(image_holder);
	              }
	              image_holder.show();
	              reader.readAsDataURL($(this)[0].files[i]);
	            }
	          } else {
	            alert("지원되지 않는 브라우저 입니다.");
	          }
	        } else {
	          alert("사진형식의 파일만 첨부해주세요.");
	        }
	      });
		
		$("#upload2").on('change', function() {
	        //Get count of selected files
	        var countFiles = $(this)[0].files.length;
	        var imgPath = $(this)[0].value;
	        var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
	        var image_holder = $("#register_pic2");
	        image_holder.empty();
	        if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
	          if (typeof(FileReader) != "undefined") {
	            //loop for each file selected for uploaded.
	            for (var i = 0; i < countFiles; i++) 
	            {
	              var reader = new FileReader();
	              reader.onload = function(e) {
	                $("<img />", {
	                  "src": e.target.result,
	                  "class": "thumb-image",
	                  "style" : "height: 248.021px; width:288.021px;"
	                }).appendTo(image_holder);
	              }
	              image_holder.show();
	              reader.readAsDataURL($(this)[0].files[i]);
	            }
	          } else {
	            alert("지원되지 않는 브라우저 입니다.");
	          }
	        } else {
	          alert("사진형식의 파일만 첨부해주세요.");
	        }
	      });
	});
</script>
<title>BLAuction_경매 등록</title>
</head>
<body>

	<!-- Content -->
	<div id="register_area">
		<div class="col-sm-10 text-left">
			<!-- Page Start -->
			<h3>
				<img src="img/auction.png" id="register_logo"></img>경매 등록
			</h3>
			<div class="panel panel-default" id="register_panel">
				<div class="panel-body">
					<form class="form-horizontal" enctype="multipart/form-data" action="createAuctionimpl.bla">
						<div id="register_top">
							<div id="register_pic1">
								<button type="button" class="btn btn-default" id="replace1">사진등록</button>
								<input type="file" value="파일 업로드" class="upload1" id="upload1" name="upload1">
							</div>
							<div id="register_pic2">
								<button type="button" class="btn btn-default" id="replace2">사진등록</button>
								<input type="file" value="파일 업로드" class="upload2" id="upload2" name="upload2">
							</div>
							<div id="register_info1">
								<div>
									<div class="form-group">
										<h4>#카테고리</h4>
										<select class="form-control" id="registerCategory"
											name="registerCategory">
											<option value="1">의류/잡화</option>
											<option value="2">뷰티/미용</option>
											<option value="3">스포츠/레저</option>
											<option value="4">디지털/가전</option>
											<option value="5">생활/가구</option>
											<option value="6">기타</option>
										</select>
									</div>
								</div>
								<div>
									<div class="form-group">
										<h4>#경매종류</h4>
										<select class="form-control" id="registerKind"
											name="registerKind">
											<option value="1">올림경매</option>
											<option value="2">내림경매</option>
											<option value="3">비밀경매</option>
										</select>
									</div>
								</div>

							</div>
						</div>

						<div id="register_bottom">
							<div class="form-group" id="register_title">
								<h4>경매 제목:</h4>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="registerTitle" name="registerTitle"
										placeholder="원하는 제목을 20자 내로 작성해주세요:)">
								</div>
							</div>

							<div style="margin-left: -2%; margin-bottom: 4%;"
								class="form-group" id="start_price">
								<h4>경매 시작 가격:</h4>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="startPrice" name="startPrice"
										placeholder="0.001 Ether">
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
								<input type="text" class="form-control" id="registerTags" name="registerTags"
									placeholder="#패션 #시계 #저렴이 #고렴이 #명품">
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-danger" id="register_btn">
										<h4>등 록 하 기</h4>
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>


	</div>

</body>
</html>