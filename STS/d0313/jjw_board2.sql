CREATE TABLE jjw_board2(
    jbno NUMBER,
    jbid VARCHAR2(18) PRIMARY KEY,
    jbpw VARCHAR2(20),
    jbname VARCHAR2(14)
);

CREATE SEQUENCE jb_seq
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;
    
INSERT INTO jjw_board2 VALUES (jb_seq.NEXTVAL, 'cherta42', '1234', 'Cherta');
INSERT INTO jjw_board2 VALUES (jb_seq.NEXTVAL, 'lumina', '1234', 'Lumina');
INSERT INTO jjw_board2 VALUES (jb_seq.NEXTVAL, 'aaa', '1234', 'AAA');

SELECT * FROM jjw_board2 WHERE jbid='cherta42' AND jbpw='1234';

SELECT * FROM jjw_board2;


CREATE TABLE jjw_board2_board(
    jbbno NUMBER,
    jbbtitle VARCHAR2(30),
    jbbcontent VARCHAR2(300),
    jbid VARCHAR2(18),
    FOREIGN KEY (jbid) REFERENCES jjw_board2(jbid)
);

CREATE SEQUENCE jbb_seq
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;


INSERT INTO jjw_board2_board VALUES (jbb_seq.NEXTVAL, '전지적 독자 시점', '멸망한 세계에서 살아남는 3가지 방법이 있다. 그 중 몇 가지는 잊어버렸다. 하지만 분명한건, 이 글을 읽는 당신이 살아남을것이라는 사실이다.', 'cherta42');
INSERT INTO jjw_board2_board VALUES (jbb_seq.NEXTVAL, 'Title Test!', '내용 Test!', 'lumina');
INSERT INTO jjw_board2_board VALUES (jbb_seq.NEXTVAL, 'More Title Test!', '내용 Test more!!', 'aaa');



SELECT * FROM jjw_board2_board;


// 전체 출력용
SELECT jbb.jbbno, jbb.jbbtitle AS 제목, jbb.jbbcontent AS 내용, jb.jbname AS 작성자
FROM jjw_board2_board jbb
JOIN jjw_board2 jb
ON jb.jbid = jbb.jbid;

// 목록용
SELECT jbb.jbbno, jbb.jbbtitle, jb.jbname
FROM jjw_board2_board jbb
JOIN jjw_board2 jb
ON jb.jbid = jbb.jbid;


drop table jjw_board2;
drop sequence jb_seq;

commit;