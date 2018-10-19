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
<script src="javascript/auction/register.js?version=1"></script>

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
					<form id="auction_form" class="form-horizontal" enctype="multipart/form-data">
					
						<div id="register_top">
							<!-- Pic 1 -->
							<div id="register_pic1">
								<button type="button" class="btn btn-default" id="replace1">사진등록</button>
							</div>
								<input type="file" class="upload1" id="upload1" name="upload1">
							<!-- Pic 2 -->	
							<div id="register_pic2">
								<button type="button" class="btn btn-default" id="replace2">사진등록</button>
							</div>
								<input type="file" class="upload2" id="upload2" name="upload2">
							
							<div id="register_info1">
								<div>
									<div class="form-group">
										<h4>#카테고리</h4>
										<select class="form-control" id="registerCategory"
											name="category_id">
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
											name="type" onchange="checkRegisterKind(this)">
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
									<input type="text" class="form-control" id="registerTitle" name="auct_title"
										placeholder="원하는 제목을 20자 내로 작성해주세요:)">
								</div>
							</div>

							<div style="margin-left: -2%; margin-bottom: 4%;"
								class="form-group" id="start_price">
								<h4>경매 시작 가격:</h4>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="startPrice" min="0.001" step="0.001">
								</div>
								<input type="number" class="form-control" name="start_price" id="startPriceFinney">
							</div>
							
							<div style="margin-left: -2%; margin-bottom: 4%;"
								class="form-group" id="due_date">
								<h4>경매 마감 시간:</h4>
								<div class="col-sm-8">
									<div class="col-sm-4">
										<input type="datetime-local" class="form-control" id="dueDate" name="due_date">
									</div>
									<div class="col-sm-4">
										<input type="time" class="form-control" id="dueTime" name="due_time">
									</div>	
								</div>
							</div>
							
							<div style="margin-bottom: 4%;"
								class="form-group" id="down_price" hidden="false">
									<h4>내림 가격:</h4>
									<div class="col-sm-4">
										<input type="number" class="form-control" id="downPrice" min="0.001"  step="0.001">
									</div>
									<input type="number" class="form-control" name="down_price" id="downPriceFinney" >
									<h4>내림 시간 간격(시):</h4>
									<div class="col-sm-4">
										<input type="number" class="form-control" id="downTerm" name="down_term" 
										min="1" max="6">
									</div>	
							</div>

							<div>
								<div class="form-group">
									<h4>상세 내용</h4>
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
									<button type="button" class="btn btn-danger" id="register_btn">
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