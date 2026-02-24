SELECT * FROM viewing;
DROP TABLE viewing;
DROP SEQUENCE viewing_seq;

commit;

CREATE TABLE viewing(
    veno NUMBER,
    veid VARCHAR2(20) PRIMARY KEY,
    vepw VARCHAR2(30),
    vename VARCHAR2(20),
    veph VARCHAR2(20)
);

CREATE SEQUENCE viewing_seq
    START WITH 1
    INCREMENT BY 1
    NOCYCLE
    NOCACHE;


INSERT INTO viewing(veno, veid, vepw, vename, veph) VALUES(viewing_seq.NEXTVAL, 'cherta42', '1234', 'Cherta', '010-0000-0000');
INSERT INTO viewing(veno, veid, vepw, vename, veph) VALUES(viewing_seq.NEXTVAL, 'lumina', '1234', 'Lumina', '010-1111-1111');
