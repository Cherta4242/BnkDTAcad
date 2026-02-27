CREATE TABLE cultural(
    culno NUMBER PRIMARY KEY,
    address1 VARCHAR2(60),
    admin_name VARCHAR2(20),
    jijung_date DATE,
    myongching VARCHAR2(50),
    myongching_hanmun VARCHAR2(40),
    myonjuk VARCHAR2(30),
    sidae VARCHAR2(40),
    soyuja_name VARCHAR2(40),
    utmk_x VARCHAR2(30),
    utmk_y VARCHAR2(30),
    content VARCHAR2(5000)
);

INSERT INTO cultural(culno, address1, admin_name, jijung_date, myongching, myongching_hanmun, myonjuk, sidae, soyuja_name, utmk_x, utmk_y, content) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);


CREATE TABLE cult(
    cultnum NUMBER PRIMARY KEY,
    address VARCHAR2(60),
    myongching VARCHAR2(50)
);

INSERT INTO cult(cultnum, address, myongching) VALUES (?, ?, ?);
