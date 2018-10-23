<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BLAuction_로그인</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- login and register button font -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">



<script>
$(document).ready(function() {
	
	$('#registerBTN').click(function(){
		location.href="register.bla";
	});
	
});



</script>

<script type="text/javascript">
$(function(){
   if(typeof web3 !== 'undefined'){
        web3 = new Web3(web3.currentProvider);
        //alert(web3.currentProvider) //현재 이더리움 네트워크에 연결된 커넥션
        $("#member_account").val(web3.eth.accounts[0]);
    }
    else{
        alert('metamask를 준비하세요');
        alert('없으면 수동으로 이더리움넷에 접속합니다.');
        web3 = new Web3(Web3.providers.HttpProvider('이더리움 넷 주소'))
    }
   
   
})


</script>

<script type="text/javascript">
    
        var openWin;
    
        function openChild()
        {
            // window.name = "부모창 이름"; 
            window.name = "parentForm";
            // window.open("open할 window", "자식창 이름", "팝업창 옵션");
            openWin = window.open("email.bla",
                    "childForm", "width=570, height=350, resizable = no, scrollbars = no");
        }
        
        function setChildText(){
            openWin.document.getElementById("cInput").value = document.getElementById("pInput").value;
        }
 
   </script>


<style type="text/css">

.login_body{

position:absolute;
top:100px;
left:200px;
margin-right:100px;
margin-left:100px;
margin-top:50px;
}


.form-control.logins{
font-family: 'Noto Sans KR', sans-serif;
font-size:10px;
margin:0 auto;
}
.ins{
width:150%;
margin-top:30px;
margin-bottom:30px;
}

.row{
height:50px;
}

#userNAME{
	margin:0 auto;
}
.login_panel{
width:500px;
height:500px;
}


</style>
</head>
<body>
	<div class="login_body">
		<img src="img/logo.PNG">
		<div>
		    <div>
	            <div class="login_panel">
	                <form action="loginimpl.bla" method="POST">
	                	<div class="ins">
	                        <input type="text" id="email" class="form-control logins" name="email" placeholder="EMAIL" autofocus>
	                	</div>
	                    
	                    <div class="ins">
	                        <input type="password" id="pw" class="form-control logins" name="pw" placeholder="Password">
	                    </div>
	                    
	                    <div class="ins">
	                        <button type="submit" id="loginBTN" class="form-control logins btn btn-danger">로그인</button>
	                    </div>
	                    
	                    <div class="ins">
	                        <input type="button" id="registerBTN" class="form-control logins btn btn-danger" value="회원가입">
	                    </div>
	                    
	                    <div class="ins">
	                    	<input class="form-control logins btn btn-danger" type="button" value="아이디와 비밀번호를 잊어버리셨나요?" onclick="openChild()"><br>
	                    </div>
	                    
	                    <input type="hidden" id="member_account" name="member_account">
	                </form>
	            </div>
		    </div>
		</div>
	</div>



</body>
</html>