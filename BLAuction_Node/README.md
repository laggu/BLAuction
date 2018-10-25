<h2 align="center">
    <br>
    <img src="https://raw.githubusercontent.com/Team20s/BLAuction/master/BLAuction/web/img/logo.PNG" alt="BLAuction" width=400">
    <br>
    <br>
    Spring을 이용한 블록체인 기반 중고 경매 웹 사이트 제작
    <br>
</h2>

# Node.js

## 개발환경

운영체제
>+ Redhat Fedora 7.5
<br/>

개발 언어
>+ Node.js 10.12
>+ web3.js 1.0
<br/>

데이터베이스
>+ 오라클 11g
<br/>

## 실행방법
1. auction.js 파일 410 line var auction_manager_address 변수 주소를 배포한 auction_manager contract 주소로 수정
2. node app.js 로 서버 실행

## 주요기능
컨트랙트에서 발생하는 이벤트를 확인하여 데이터베이스를 업데이트
>+ 경매 이벤트 : 이벤트 발생시 데이터베이스에 경매 주소를 저장
>+ 입찰 이벤트 : 이벤트 발생시 데이터베이스에 컨펌 유무를 저장
