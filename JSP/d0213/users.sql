CREATE TABLE users (
    id NUMBER PRIMARY KEY,
    username VARCHAR2(50) NOT NULL UNIQUE,
    password VARCHAR2(255) NOT NULL,
    email VARCHAR2(100),
    created_at DATE DEFAULT SYSDATE
);

CREATE SEQUENCE users_seq
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER users_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT users_seq.NEXTVAL
    INTO :NEW.id
    FROM dual;
END;
/


INSERT INTO users(username, password, email) VALUES('cherta42', '1234', 'Cherta4242.github.com');

SELECT * FROM users;

commit;
