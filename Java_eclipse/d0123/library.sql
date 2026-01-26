SELECT * FROM library;
SELECT * FROM libmember;

DROP TABLE library;
DROP TABLE libmember;

-- 도서관 책 관련
CREATE TABLE library(
    bcode VARCHAR2(20) PRIMARY KEY,
    bname VARCHAR2(40) NOT NULL,
    bdate VARCHAR2(20) NOT NULL,
    bsituation VARCHAR2(50) CHECK (bsituation IN('대출 중','미 대출')),
    blocation VARCHAR2(20) NOT NULL
);

INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0001', '마침내멸망하는여름', '26/01/26', '미 대출', '1번');
INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0124', 'bbb', '26/01/23', '미 대출', '6번');
INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0125', 'wjfew', '26/01/23', '미 대출', '3번');
INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0126', '전독시', '26/01/23', '미 대출', '2번');
INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0127', 'kkk', '26/01/23', '미 대출', '4번');
INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0128', 'aaa', '26/01/23', '미 대출', '5번');
INSERT INTO library(bcode, bname, bdate, bsituation, blocation) VALUES('d0129', 'aaaaa', '26/01/23', '미 대출', '5번');

    
-- 회원(일반회원, 관리자)
-- 회원가입을 하면 관리자인지 아닌지 표시만 해야하나? - 관리자는 1 회원은 0?
CREATE TABLE libmember(
    lid VARCHAR2(20) PRIMARY KEY,
    lpw VARCHAR2(20) NOT NULL,
    lname VARCHAR2(20) NOT NULL,
    lbname VARCHAR2(20),
    lmanager NUMBER CHECK (lmanager IN(0, 1))
);
    
INSERT INTO libmember(lid, lpw, lname, lbname, lmanager) VALUES ('cherta42', '1234', 'Cherta', '', 1);

UPDATE libmember set lmanager = 1 where lid = 'lumina';


commit;
