CREATE TABLE jjw_board(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(10) NOT NULL,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(500) NOT NULL,
    image BLOB
);

CREATE SEQUENCE jjw_board_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO jjw_board(id, name, title, content) VALUES (jjw_board_seq.NEXTVAL, 'Cherta42', '전독시 본편 중...', '「멸망한 세계에서 살아남는 세 가지 방법이 있다. 이제 몇 개는 잊어버렸다. 그러나 한 가지는 확실하다. 그것은 지금 이 글을 읽는 당신이 살아남을 거란 사실이다. <br><br>―멸망한 세계에서 살아남는 세 가지 방법 完」');


SELECT id, title FROM jjw_board;
SELECT * FROM green.jjw_board;

drop table jjw_board;
drop sequence jjw_board_seq;

commit;
