/* 삭제 및 조회
----------------------------------------------------------*/
DROP TABLE member_tbl_02;
DROP SEQUENCE member_seq;
DROP TABLE money_tbl_02;
DROP SEQUENCE money_seq;

SELECT * FROM member_tbl_02;
SELECT * FROM money_tbl_02;
SELECT member_seq.CURRVAL FROM dual;

commit;

/* 테이블 생성
----------------------------------------------------------*/
CREATE TABLE member_tbl_02(
    custno NUMBER PRIMARY KEY,
    custname VARCHAR2(20),
    phone VARCHAR2(20),
    address VARCHAR2(60),
    joindate date,
    grade char(1),
    city char(2)
);

/* 회원 번호 증가 시퀀스
----------------------------------------------------------*/
CREATE SEQUENCE member_seq
    START WITH 100001
    INCREMENT BY 1
    NOCYCLE
    NOCACHE;

/* 회원정보 샘플 데이터
----------------------------------------------------------*/
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)  VALUES(member_seq.NEXTVAL, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '2015-12-02', 'A', '01');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)  VALUES(member_seq.NEXTVAL, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', '2015-12-06', 'B', '01');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)  VALUES(member_seq.NEXTVAL, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '2015-10-01', 'B', '30');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)  VALUES(member_seq.NEXTVAL, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '2015-12-02', 'A', '30');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)  VALUES(member_seq.NEXTVAL, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '2015-12-25', 'B', '60');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)  VALUES(member_seq.NEXTVAL, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '2015-12-11', 'C', '60');

/* 회원매출정보 테이블 생성
----------------------------------------------------------*/
CREATE TABLE money_tbl_02(
    custno NUMBER NOT NULL,
    salenol NUMBER NOT NULL,
    pcost NUMBER,
    amount NUMBER,
    price NUMBER,
    pcode VARCHAR2(4),
    sdate date,
    PRIMARY KEY(custno, salenol),
    FOREIGN KEY(custno) REFERENCES member_tbl_02(custno)
);

/* 판매번호 증가 시퀀스 생성
----------------------------------------------------------*/
CREATE SEQUENCE money_seq
    START WITH 20160001
    INCREMENT BY 1
    NOCYCLE
    NOCACHE;

/* 회원매출정보 샘플 데이터 
----------------------------------------------------------*/
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100001, money_seq.NEXTVAL, 500, 5, 2500, 'A001', '2016-01-01');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100001, money_seq.NEXTVAL, 1000, 4, 4000, 'A002', '2016-01-01');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100001, money_seq.NEXTVAL, 500, 3, 1500, 'A008', '2016-01-01');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100002, money_seq.NEXTVAL, 2000, 1, 2000, 'A004', '2016-01-02');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100002, money_seq.NEXTVAL, 500, 1, 500, 'A00', '2016-01-03');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100003, money_seq.NEXTVAL, 1500, 2, 3000, 'A003', '2016-01-03');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100004, money_seq.NEXTVAL, 500, 2, 1000, 'A001', '2016-01-04');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100004, money_seq.NEXTVAL, 300, 1, 300, 'A005', '2016-01-04');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100004, money_seq.NEXTVAL, 600, 1, 600, 'A006', '2016-01-04');
INSERT INTO money_tbl_02(custno, salenol, pcost, amount, price, pcode, sdate) VALUES(100004, money_seq.NEXTVAL, 3000, 1, 3000, 'A007', '2016-01-06');
