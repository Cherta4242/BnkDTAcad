CREATE TABLE customers(
    cus_id NUMBER PRIMARY KEY, 
    cus_name VARCHAR2(10) NOT NULL,
    cus_ph VARCHAR2(14) NOT NULL UNIQUE
);

CREATE TABLE things(
    th_id NUMBER PRIMARY KEY,
    th_name VARCHAR2(10) NOT NULL,
    th_price NUMBER(8)NOT NULL 
);

CREATE TABLE orders(
    ord_num NUMBER,
    cus_id NUMBER NOT NULL,
    th_id NUMBER NOT NULL,
    ord_qtt NUMBER NOT NULL,
    PRIMARY KEY(ord_num, cus_id, th_id),
    CONSTRAINT ord_cus_fk FOREIGN KEY (cus_id) REFERENCES customers(cus_id),
    CONSTRAINT ord_th_fk FOREIGN KEY(th_id) REFERENCES things(th_id)    
);

INSERT INTO customers (cus_id, cus_name, cus_ph) VALUES (1, '장진우', '010-1111-1111');
INSERT INTO customers (cus_id, cus_name, cus_ph) VALUES (2, '아이요', '010-2222-2222');

INSERT INTO things (th_id, th_name, th_price) VALUES (1, '마우스', '40000');
INSERT INTO things (th_id, th_name, th_price) VALUES (2, '키보드', '50000');
INSERT INTO things (th_id, th_name, th_price) VALUES (3, '모니터', '200000');
INSERT INTO things (th_id, th_name, th_price) VALUES (4, '패드', '140000');

INSERT INTO orders(