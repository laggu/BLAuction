drop table MEMBER cascade constraints;
create table MEMBER(
member_id number(5) not null,
email   varchar2(40) not null,
pw   varchar2(10) not null,
name   varchar2(20) not null,
address varchar2(100) not null,
phone   varchar2(13) not null,
birth   varchar2(7) not null,
score   number(4) null,
likes   number(4) null,
member_account   varchar2(160) not null,
CONSTRAINT PK_MEMBER PRIMARY KEY(member_id)
);


drop table BIDDING cascade constraints;
//참고
ALTER TABLE EMP1 ADD CONSTRAINT EMP1_FK(FK이름) FOREIGN KEY(필드1, 필드2, 필드3) 
  REFERENCES EMP2(필드1, 필드2, 필드3);
//
//나중에 추가
ALTER TABLE BIDDING ADD CONSTRAINT FK_BIDDING_auct FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id);

//

create table BIDDING(
bid_id      number(5) not null,
member_id   number(5) not null,
auct_id      number(5) not null,
price      number(10) not null,
time      number(10) not null,
bidder_account   varchar2(160) not null,
CONSTRAINT PK_BIDDING PRIMARY KEY(bid_id),
CONSTRAINT FK_BIDDING_member FOREIGN KEY(member_id)
REFERENCES MEMBER(member_id)
);

drop table SUCCESSFUL_BID cascade constraints;
//나중에 추가
ALTER TABLE SUCCESSFUL_BID ADD CONSTRAINT FK_SUCCESSFUL_BID_delivery FOREIGN KEY(delivery_code)
REFERENCES DELIVERY(delivery_code);
//

create table SUCCESSFUL_BID(
auct_id   number(5) not null,
bid_id   number(5) null,
review   varchar2(255) null,
delivery_code varchar2(50) null,
CONSTRAINT PK_SUCCESSFUL_BID PRIMARY KEY(auct_id),
CONSTRAINT FK_SUCCESSFUL_BID_bid FOREIGN KEY(bid_id)
REFERENCES BIDDING(bid_id)
);

drop table DELIVERY cascade constraints;
create table DELIVERY(
delivery_code varchar2(50) not null,
delivery_status varchar2(10) not null,
payment_status varchar2(10) not null,
CONSTRAINT PK_DELIVERY_auct PRIMARY KEY(delivery_code)
);

drop table AUCTION_TYPE cascade constraints;
create table AUCTION_TYPE(
auct_type_id number(5) not null,
auct_type_name varchar2(10) not null,
CONSTRAINT PK_AUCTION_TYPE_auct_type PRIMARY KEY(auct_type_id)
);

drop table AUCTION cascade constraints;
//추가
ALTER TABLE AUCTION ADD CONSTRAINT FK_AUCTION_cate_type FOREIGN KEY(cate_type_id)
REFERENCES CATEGORY_TYPE(cate_type_id);
//
create table AUCTION(
auct_id number(5) not null,
member_id number(5) not null,
duedate number(10) not null,
auct_type_id number(5) not null,
start_price number(10) not null,
seller_account varchar2(160) not null,
cate_type_id number(5) not null,
description varchar2(255) not null,
down_price number(10) null,
down_term number(10) null,
auction_status varchar2(10) not null,
auction_address varchar2(160) not null,
CONSTRAINT PK_AUCTION_auct PRIMARY KEY(auct_id),
CONSTRAINT FK_AUCTION_member FOREIGN KEY(member_id)
REFERENCES MEMBER(member_id),
CONSTRAINT FK_AUCTION_auct_type FOREIGN KEY(auct_type_id)
REFERENCES AUCTION_TYPE(auct_type_id)
);

drop table CATEGORY_TYPE cascade constraints;
create table CATEGORY_TYPE(
cate_type_id number(5) not null,
cate_type_name varchar2(20) not null,
CONSTRAINT PK_CATEGORY_TYPE_cate_type PRIMARY KEY(cate_type_id)
);

drop table PHOTO cascade constraints;
create table PHOTO(
photo_id number(5) not null,
photo_name varchar2(20) not null,
photo_path varchar2(255) not null,
auct_id number(5) not null,
CONSTRAINT PK_PHOTO_photo PRIMARY KEY(photo_id),
CONSTRAINT FK_PHOTO_auct FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id)
);

drop table TAG cascade constraints;
create table TAG(
tag_id number(5) not null,
tag_name varchar2(50) not null,
auct_id number(5) not null,
CONSTRAINT PK_TAG_tag PRIMARY KEY(tag_id),
CONSTRAINT FK_TAG_auct FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id)
);

//회원 ID 시퀀스 삭제 및 생성 => ID 겹치는 경우가 발생하지않게 정적인 데이터를 제외하고 부터 시퀀스 시작, 홀수
DROP SEQUENCE SEQ_MEMBER;

CREATE SEQUENCE SEQ_MEMBER
MINVALUE 1 START WITH 11 INCREMENT BY 2;

//옥션 및 관련 테이블 ID 시퀀스 삭제 및 생성 => ID 겹치는 경우가 발생하지않게 정적인 데이터를 제외하고 부터 시퀀스 시작 그리고 회원 시퀀스랑 겹치지 않게 짝수
DROP SEQUENCE SEQ_AUCT;

CREATE SEQUENCE SEQ_AUCT 
MINVALUE 1 START WITH 10 INCREMENT BY 2;

//카테고리 테이블 정적인 데이터 삽입
INSERT INTO CATEGORY_TYPE VALUES(1,'clothing');
INSERT INTO CATEGORY_TYPE VALUES(2,'beauty');
INSERT INTO CATEGORY_TYPE VALUES(3,'sports');
INSERT INTO CATEGORY_TYPE VALUES(4,'digital');
INSERT INTO CATEGORY_TYPE VALUES(5,'furniture');
INSERT INTO CATEGORY_TYPE VALUES(6,'etc');

//경매 종류 데이터 삽입
INSERT INTO AUCTION_TYPE VALUES(7,'up');
INSERT INTO AUCTION_TYPE VALUES(8,'down');
INSERT INTO AUCTION_TYPE VALUES(9,'secret');

COMMIT;
