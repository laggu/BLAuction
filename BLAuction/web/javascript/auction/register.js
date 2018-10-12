// 필요 작성 기능
// 1. summernote 이미지 업로드 ------ http://devofhwb.tistory.com/67
//     ------   음....... 꽤 복잡해질듯. 사진 여러개 처리해야됨
//     ------             블로그 소스방식은 게시판이 만들어지기 전에 이미지를 업로드 하게 됨.. 취소하면?
// 2.

var IMAGE_PATH = 'http://localhost:80/summernote-develop/examples/';

$(document).ready(function() {
	$('#summernote').summernote({
		height : 250,
		minHeight: 250,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		// 이 함수가 실행되는 시점이 최종 submit일때면 일이 쉬워짐
		onImageUpload : function(files, editor, welEditable) { 
	    	alert("function in")
	    	console.log("function in")
	        sendFile(files[0], editor, welEditable);
	    },
	    
	    lang : 'ko-KR'
	});
});

function sendFile(file, editor, welEditable) {
    data = new FormData();
    data.append("image", file);
    console.log('image upload:', file, editor, welEditable);
    console.log(data);
    $.ajax({
        data : data,
        type : "POST",
        url : "/imageUpload.bla",
        cache : false,
        contentType : false,
        processData : false,
        success : function(data) {
            editor.insertImage(welEditable, data.url);
        }
    });
}
