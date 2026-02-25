SELECT * FROM tbl_product_202101;
DELETE FROM tbl_product_202101 WHERE pcode='AA05';

SELECT * FROM tbl_shop_202101;

SELECT * FROM tbl_order_202101;

commit;

/* tbl_product_202101 테이블 생성
-------------------------------------------------------------------------------------------*/
CREATE TABLE tbl_product_202101(
    pcode char(4) PRIMARY KEY,
    pname varchar2(30),
    cost NUMBER
);
INSERT INTO tbl_product_202101(pcode, pname, cost) VALUES ('AA01', '삼각김밥', 1000);
INSERT INTO tbl_product_202101(pcode, pname, cost) VALUES ('AA02', '도시락', 2500);
INSERT INTO tbl_product_202101(pcode, pname, cost) VALUES ('AA03', '봉지만두', 3000);
INSERT INTO tbl_product_202101(pcode, pname, cost) VALUES ('AA04', '컵라면', 1500);
INSERT INTO tbl_product_202101(pcode, pname, cost) VALUES ('AA05', '아메리카노', 2000);
INSERT INTO tbl_product_202101(pcode, pname, cost) VALUES ('AA06', '콜라', 800);

/* tbl_shop_202101 테이블 생성
-------------------------------------------------------------------------------------------*/
CREATE TABLE tbl_shop_202101(
    shopno char(4) PRIMARY KEY,
    shopname VARCHAR2(20),
    discount NUMBER
);
INSERT INTO tbl_shop_202101(shopno, shopname, discount) VALUES('S001', 'AA할인점', 10);
INSERT INTO tbl_shop_202101(shopno, shopname, discount) VALUES('S002', 'BB할인점', 15);
INSERT INTO tbl_shop_202101(shopno, shopname, discount) VALUES('S003', 'CC할인점', 10);
INSERT INTO tbl_shop_202101(shopno, shopname, discount) VALUES('S004', 'DD할인점', 15);

/* tbl_order_202101 테이블 생성
-------------------------------------------------------------------------------------------*/
CREATE TABLE tbl_order_202101(
    orderno CHAR(8) PRIMARY KEY,
    shopno CHAR(4),
    orderdate char(8),
    pcode CHAR(4),
    amount NUMBER(5),
    FOREIGN KEY(pcode) REFERENCES tbl_product_202101(pcode),
    FOREIGN KEY(shopno) REFERENCES tbl_shop_202101(shopno)
);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210001', 'S001', '20210302', 'AA01', 50);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210002', 'S001', '20210302', 'AA02', 30);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210003', 'S001', '20210302', 'AA03', 20);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210004', 'S002', '20210303', 'AA01', 50);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210005', 'S002', '20210303', 'AA02', 40);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210006', 'S002', '20210303', 'AA03', 60);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210007', 'S001', '20210304', 'AA01', 60);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210008', 'S001', '20210304', 'AA02', 70);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210009', 'S001', '20210304', 'AA03', 80);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210010', 'S002', '20210305', 'AA01', 30);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210011', 'S002', '20210305', 'AA02', 40);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210012', 'S002', '20210305', 'AA03', 50);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210013', 'S001', '20210306', 'AA01', 30);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210014', 'S001', '20210306', 'AA02', 20);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('20210015', 'S001', '20210306', 'AA03', 50);
INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount)
    VALUES ('123', 'S001', '20260225', 'AA01', 123);
    


SELECT A.shopno, B.shopname, A.orderno, A.orderdate, A.pcode,
C.pname, A.amount, C.cost, A.amount*C.cost AS price, A.amount*C.cost/100*(100-B.discount)AS sale
FROM tbl_order_202101 A
JOIN tbl_shop_202101 B ON A.shopno = B.shopno
JOIN tbl_product_202101 C ON A.pcode = C.pcode
ORDER BY A.orderno ASC;


SELECT  B.shopno, C.pcode, C.pname, SUM(A.amount) AS total_amount
FROM tbl_order_202101 A
JOIN tbl_shop_202101 B ON A.shopno = B.shopno
JOIN tbl_product_202101 C ON A.pcode = C.pcode
GROUP BY C.pname, C.pcode, B.shopno
ORDER BY B.shopno ASC;

SELECT pcode, pname, cost, cost/100*90, cost/100*85
FROM tbl_product_202101
ORDER BY pcode ASC;