-- Member 테이블 확인 코드.
SELECT * FROM Member;

-- Member 테이블 생성.
CREATE TABLE Member(
    id VARCHAR2(20) PRIMARY KEY,
    password VARCHAR2(20) NOT NULL,
    name VARCHAR2(20) NOT NULL
);

-- Member 테이블에 초기 값 넣어주기.
INSERT INTO Member (id, password, name) VALUES ('cherta42', 'jjw3125', 'Cherta');

-- 커밋
commit;