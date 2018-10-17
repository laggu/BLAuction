// 필요 작성 기능
// 1. summernote 이미지 업로드 ------ http://devofhwb.tistory.com/67
//     ------   음....... 꽤 복잡해질듯. 사진 여러개 처리해야됨
//     ------             블로그 소스방식은 게시판이 만들어지기 전에 이미지를 업로드 하게 됨.. 취소하면?
// 2.

var photo_id = [];

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
	
	$('#startPrice').on('change keyup mouseup',function(){
		var ether = $('#startPrice').val();
		$('#startPriceFinnei').text(ether * 1000);
	})
});

// Auction Kind checking function
function checkRegisterKind(auction_kind){
	if(auction_kind.value == 2){
		document.getElementById("down_price").hidden = false;
	}else{
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


alert('test');