CREATE TABLE cinemember(
    ciid VARCHAR2(30) PRIMARY KEY,
    cipw VARCHAR2(30) NOT NULL,
    ciname VARCHAR2(40) NOT NULL
);

CREATE TABLE seat(
    seatnum NUMBER PRIMARY KEY,
    reserve VARCHAR2(20) DEFAULT '공석' CHECK(reserve IN('공석', '예약'))
);

CREATE TABLE cinema(
    moviename VARCHAR2(80) NOT NULL,
    movietime VARCHAR2(20) NOT NULL,
    moviesttim TIMESTAMP NOT NULL,
    movieentim TIMESTAMP NOT NULL,
    seatnum NUMBER,
    FOREIGN KEY (seatnum) REFERENCES seat(seatnum),
    PRIMARY KEY(moviename, seatnum)
);

SELECT * FROM cinemember;
SELECT * FROM seat;
SELECT * FROM cinema;

INSERT INTO cinemember(ciid, cipw, ciname) VALUES ('cherta42', '1234', 'Cherta');
INSERT INTO seat(seatnum, reserve) VALUES(10,'공석');

INSERT INTO cinema (moviename, movietime, moviesttim, movieentim, seatnum) VALUES('전독시', '2시간', TO_DATE('26/10/10 05/10/00', 'yy/mm/dd HH/MI/ss'), TO_DATE('26/10/10 07/10/00', 'yy/mm/dd HH/MI/ss'), 3);

DROP TABLE cinema;
