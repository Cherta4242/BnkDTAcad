CREATE TABLE jjw_board(
    id NUMBER PRIMARY KEY,
    mbid VARCHAR2(14) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(500) NOT NULL,
    image BLOB,
    FOREIGN KEY (mbid) REFERENCES jjw_member(mbid)
);

CREATE TABLE jjw_coment(
    cmid NUMBER PRIMARY KEY,
    id NUMBER NOT NULL,
    mbid VARCHAR2(14) NOT NULL,
    coment VARCHAR2(100) NOT NULL,
    FOREIGN KEY (mbid) REFERENCES jjw_member(mbid),
    FOREIGN KEY (id) REFERENCES jjw_board(id)
);

CREATE TABLE jjw_member(
    mbid VARCHAR2(14) PRIMARY KEY,
    mbpw VARCHAR2(20) NOT NULL,
    name VARCHAR2(15) NOT NULL UNIQUE
);

CREATE SEQUENCE jjw_board_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO jjw_board(id, mbid, title, content)
VALUES (jjw_board_seq.NEXTVAL, 'cherta42', '전독시 본편 중...', '「멸망한 세계에서 살아남는 세 가지 방법이 있다. 이제 몇 개는 잊어버렸다. 그러나 한 가지는 확실하다. 그것은 지금 이 글을 읽는 당신이 살아남을 거란 사실이다」');
INSERT INTO jjw_board(id, mbid, title, content) VALUES (jjw_board_seq.NEXTVAL, 'lumina', '테스트!', '테스트용으로 만드는겁니다!');


INSERT INTO jjw_member(mbid, mbpw, name) VALUES ('cherta42', '1234', 'Cherta');


SELECT * FROM jjw_member WHERE mbid = 'cherta42' AND mbpw = '1234';


SELECT id, title FROM jjw_board;
SELECT * FROM jjw_board;
SELECT * FROM jjw_member;
SELECT * FROM jjw_coment;


drop table jjw_member;
drop table jjw_coment;
drop table jjw_board;
drop sequence jjw_board_seq;

SELECT jb.id AS id, jm.name AS name, jb.title AS title, jb.content AS content FROM jjw_board jb JOIN jjw_member jm ON jb.mbid = jm.mbid WHERE jb.id = 2;




UPDATE jjw_board SET name='Cherta42', title='전독시', content='나는 언제까지고 영원히, 너를 위한 종장을 쓰겠다고.' WHERE id=2;
DELETE jjw_board WHERE id=6;

commit;

