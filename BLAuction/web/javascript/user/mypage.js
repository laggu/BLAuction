// 필요 작성 기능
// 1. ajax 이용하여 필요 데이터 불러오고 화면에 데이터 뿌려주기
// 2. 각 버튼 클릭시 ajax 함수 실행
// 3. 제일 초기 화면 데이터는 어떻게?? ajax로 한번에 처리??
//     -----  ajax로 모든 기능 다 처리하여 하나의 mypage.jsp 파일에서 내정보와 다른 유저 정보 둘다 볼수 있게 하기????
//     -----  아니면 둘다 만들어서 하는것도 나을듯. 내정보와 다른 사람 정보는 보여질 태그가 다름
// 4. 주소, 핸드폰, 비밀번호 변경 ajax 처리. 모달 띄어줘야 할거같음.

function auctionCancel(auct_id){
	
	$.ajax({
		type:'POST',
		url:'auctioncancel.bla',
		data:{
			"auct_id":auct_id
		},
		datatype:'json',
		success:function(data){
			window.location.reload();
		},
		error:function(data){
			arlert("auctionCancel error");
		}
	})
}

