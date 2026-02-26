SELECT * FROM member2;

CREATE TABLE member2(
    id VARCHAR2(20) PRIMARY KEY,
    pw VARCHAR2(20) NOT NULL,
    nickname VARCHAR(10) NOT NULL
);

INSERT INTO member2(id, pw, nickname) VALUES ('cherta42', '1234', 'Cherta');

commit;