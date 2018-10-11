DROP TABLE PHOTO;
DROP TABLE TAG;
DROP TABLE SUCCESSFUL_BID;
DROP TABLE DELIVERY;
DROP TABLE BIDDING;
DROP TABLE AUCTION;
DROP TABLE CATEGORY_TYPE;
DROP TABLE AUCTION_TYPE;
DROP TABLE MEMBER;

create table MEMBER(
member_id number(5) not null PRIMARY KEY,
email   varchar2(40) not null,
pw   varchar2(10) not null,
name   varchar2(20) not null,
address varchar2(100) not null,
phone   varchar2(13) not null,
birth   varchar2(7) not null,
score   number(4) null,
likes   number(4) null,
member_account   varchar2(160) not null
);

create table CATEGORY_TYPE(
cate_type_id number(5) not null PRIMARY KEY,
cate_type_name varchar2(20) not null
);

create table AUCTION_TYPE(
auct_type_id number(5) not null PRIMARY KEY,
auct_type_name varchar2(10) not null
);

create table DELIVERY(
delivery_code varchar2(50) not null PRIMARY KEY,
delivery_status varchar2(10) not null,
payment_status varchar2(10) not null
);

create table AUCTION(
auct_id number(5) not null PRIMARY KEY,
member_id number(5) not null,
duedate number(20) not null,
auct_type_id number(5) not null,
start_price number(10) not null,
seller_account varchar2(160) not null,
cate_type_id number(5) not null,
description varchar2(255) not null,
down_price number(10) null,
down_term number(10) null,
auction_status varchar2(10) not null,
auction_address varchar2(160) not null,
auct_conf_status number(1) default 0 not null,
CONSTRAINT FK_AUCTION_member FOREIGN KEY(member_id)
REFERENCES MEMBER(member_id),
CONSTRAINT FK_AUCTION_auct_type FOREIGN KEY(auct_type_id)
REFERENCES AUCTION_TYPE(auct_type_id),
CONSTRAINT FK_AUCTION_cate_type FOREIGN KEY(cate_type_id)
REFERENCES CATEGORY_TYPE(cate_type_id)
);

create table PHOTO(
photo_id number(5) not null PRIMARY KEY,
photo_name varchar2(20) not null,
photo_path varchar2(255) not null,
auct_id number(5) not null,
CONSTRAINT FK_PHOTO_auct FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id)
);

create table TAG(
tag_id number(5) not null PRIMARY KEY,
tag_name varchar2(50) not null,
auct_id number(5) not null,
CONSTRAINT FK_TAG_auct FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id)
);

create table BIDDING(
bid_id      number(5) not null PRIMARY KEY,
member_id   number(5) not null,
auct_id      number(5) not null,
price      number(10) not null,
time      number(10) not null,
bidder_account   varchar2(160) not null,
bid_conf_status	number(1) default 0 not null,
CONSTRAINT FK_BIDDING_member FOREIGN KEY(member_id)
REFERENCES MEMBER(member_id),
CONSTRAINT FK_BIDDING_auct FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id)
);

create table SUCCESSFUL_BID(
auct_id   number(5) not null PRIMARY KEY,
bid_id   number(5) null,
review   varchar2(255) null,
delivery_code varchar2(50) null,
CONSTRAINT FK_SUCCESSFUL_BID_bid FOREIGN KEY(bid_id)
REFERENCES BIDDING(bid_id),
CONSTRAINT FK_SUCCESSFUL_BID_delivery FOREIGN KEY(delivery_code)
REFERENCES DELIVERY(delivery_code),
CONSTRAINT FK_SUCCESSFUL_BID_auct_id FOREIGN KEY(auct_id)
REFERENCES AUCTION(auct_id)
);


DROP SEQUENCE SEQ_MEMBER;
CREATE SEQUENCE SEQ_MEMBER
MINVALUE 1 START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SEQ_AUCT;
CREATE SEQUENCE SEQ_AUCT 
MINVALUE 1 START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SEQ_BID;
CREATE SEQUENCE SEQ_BID 
MINVALUE 1 START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SEQ_PHOTO;
CREATE SEQUENCE SEQ_PHOTO 
MINVALUE 1 START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SEQ_TAG;
CREATE SEQUENCE SEQ_TAG 
MINVALUE 1 START WITH 1 INCREMENT BY 1;


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

//테스트용 회원
INSERT INTO MEMBER VALUES(1,'crysis1@naver.com','1234','최다훈','서울특별시 관악구 봉천동 1523-25','01092557434','931217',0,0,'0x9671652cf6fba11f7576b341b95bff03ad27d581');
COMMIT;