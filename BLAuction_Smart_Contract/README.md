<h2 align="center">
    <br>
    <img src="https://raw.githubusercontent.com/Team20s/BLAuction/master/BLAuction/web/img/logo.PNG" alt="BLAuction" width=400">
    <br>
    <br>
    Spring을 이용한 블록체인 기반 중고 경매 웹 사이트 제작
    <br>
</h2>

# Smart Contract

## 개발 환경

운영체제
>+ Windows10
<br/>

개발 언어
>+ solidity 0.4.24
<br/>

IDE
>+ Remix
<br/>


## 주요 기능
Auction_Manager Contract
>1. 경매 생성 : 유저가 지정한 값들을 바탕으로 경매를 배포함
>2. 경매 주소 찾기 : 경매의 id를 이용하여 해당 경매의 address return

Auction Contract
>1. 입찰 : 유저의 입찰 내용을 컨트랙트에 저장
>2. 환불 : 입찰 받지 못한 유저들의 이더를 환불
>3. 판매금 받기 : 경매가 끝난후 판매자가 판매금을 받음
