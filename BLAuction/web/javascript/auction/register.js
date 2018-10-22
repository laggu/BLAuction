// 필요 작성 기능
// 1. summernote 이미지 업로드 ------ http://devofhwb.tistory.com/67
//     ------   음....... 꽤 복잡해질듯. 사진 여러개 처리해야됨
//     ------             블로그 소스방식은 게시판이 만들어지기 전에 이미지를 업로드 하게 됨.. 취소하면?
// 2.

var photo_id = [];
var titleFlag = false;
var startPriceFlag = false;
var timeFlag = false;
var downPriceFlag = true;
var downTermFlag = true;

$(document).ready(function() {
	
	// Summernote API
	$('#summernote').summernote({
		height : 250,
		minHeight: 250,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		callbacks: {
	          onImageUpload: function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	              sendFile(files[i], this);
	            }
	          },
	          onMediaDelete : function(files, editor, $editable) {
	              console.log(files[0].src); // img 

	             // remove element in editor 
	              deleteFile(files[0],this);
	              files.remove();
	             
	          }
	        }
		,
	    lang : 'ko-KR'
	});
	
	// Thumbnail 사진 업로드시 실시간 변경 부분
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
	
	$("#register_btn").click(function(){
		if(verifyData()){
			makeAuction();
		}
	})
	
	$('#startPrice').on('change keyup mouseup',function(){
		var ether = $('#startPrice').val();
		ether *= 1000;
		if(ether == 0){
			startPriceFlag = false;
			$('#startPriceFinney').val(null);
		}else{
			startPriceFlag = true;
			ether = Math.floor(ether);
			$('#startPriceFinney').val(ether);
		}
	});
	
	$('#downPrice').on('change keyup mouseup',function(){
		var ether = $('#downPrice').val();
		ether *= 1000;
		if(ether == 0){
			downPriceFlag = false;
			$('#downPriceFinney').val(null);
		}else{
			downPriceFlag = true;
			ether = Math.floor(ether);
			$('#downPriceFinney').val(ether);
		}
	});
	
	$('#registerTitle').on('change',function(){
		var title = $('#registerTitle').val();
		if(title.length >= 20){
			alert("제목은 20자 이하이어야 합니다");
			$('#registerTitle').val(title.substring(0,20));
		}
		titleFlag = true;
	});
	
	$('#downTerm').on('change',function(){
		var term = $('#downTerm').val();
		term *= 10;
		if(term == 0){
			alert("내림 시간 간격을 입력해주세요");
			downTermFlag = false;
		}
		downTermFlag = true;
	});
	
	$('#dueDate').on('blur',function(){
		var due_date = new Date($('#dueDate').val());
		var cur_date = new Date();
		
		if(!Date.parse($('#dueDate').val())){
			alert('날짜를 제대로 입력해 주세요.');
			timeFlag = false;
		}
		else if(due_date <= cur_date){
			alert('마감 시간이 현재 시간보다 빠릅니다.');
			timeFlag = false;
		}else{
			timeFlag = true;			
		}
	});
});

// Auction Kind checking function
function checkRegisterKind(auction_kind){
	if(auction_kind.value == 2){
		document.getElementById("down_price").hidden = false;
		downPriceFlag = false;
		downTermFlag = false;
	}else{
		downPriceFlag = true;
		downTermFlag = true;
		document.getElementById("down_price").hidden = true;
		document.getElementById("downPrice").value = 0;
		document.getElementById("downTerm").value = 0;
	}
}

// Summernote API
function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: '/BLAuction/photoupload.bla',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(data) {
    	  console.log(data);
    	  photo_id.push(data.photo_id);
    	  var url = data.photo_path+'\\'+data.photo_name;
        $(el).summernote('editor.insertImage', url);
        $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');
      },
      error: function(data){
    	  alert(data);
      }
    });
  }

function deleteFile(file, el) {
    var form_data = new FormData();
    form_data.append('deletefile', file);
    $.ajax({
      data: form_data,
      type: "POST",
      url: '/BLAuction/photoDelete.bla',
      cache: false,
      contentType: false,
      enctype: 'multipart/form-data',
      processData: false,
      success: function(data) {
    	  console.log(data);/*
    	  photo_id.push(data.photo_id);
    	  var url = data.photo_path+'\\'+data.photo_name;
        $(el).summernote('editor.insertImage', url);
        $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>');*/
      },
      error: function(data){
    	  alert('오류'+data);
      }
    });
  }


function verifyData(){
	if(!titleFlag){
		alert("제목을 입력하세요");
		return false;
	}
	if(!startPriceFlag){
		alert("시작가격을 입력하세요");
		return false;
	}
	var due_date = new Date($('#dueDate').val());
	var current_time = new Date();
	
//	if(due_date != null){
//		alert("마감시간을 입력하세요");
//		return false;
//	}
//	if(due_date.getTime() - current_time.getTime() > 0){
//		alert("과거 시간은 입력할 수 없습니다.");
//		return false;
//	}
	
	if(!timeFlag){
		alert("시간을 입력하세요");
		return false;
	}
	
	if(!downPriceFlag){
		alert("내림가격을 입력하세요");
		return false;
	}if(!downTermFlag){
		alert("내림시간간격을 입력하세요");
		return false;
	}
	return true;
}