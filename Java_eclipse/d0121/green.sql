SELECT * FROM employees;
SELECT * FROM dept;

DROP TABLE test1;
DROP TABLE persons;
DROP TABLE employees;
DROP TABLE dept;

DELETE employees WHERE emp_id = 1;
DELETE dept WHERE dept_id = 1;

DESC test1;
DESC persons;
DESC dept;
DESC employees;


-- NOT NULL, UNIQUE
CREATE TABLE test1(
    id NUMBER(3) NOT NULL UNIQUE,
    pw VARCHAR(10) NOT NULL,
    email VARCHAR(50)UNIQUE
);
INSERT INTO test1(id, pw, email) VALUES (1, 'ABCD', NULL);
INSERT INTO test1 VALUES (2, 'BBB', 'bbb@bbb.com');
INSERT INTO test1(id, pw, email) VALUES (3, 'ABC', 'abc@abc.com');

-- check
CREATE TABLE persons(
    pid CHAR(3) PRIMARY KEY, 
    age NUMBER CHECK(age >= 0 AND age <= 1000),
    gender CHAR(1) check(gender IN('M', 'F'))
);

INSERT INTO persons(pid, age, gender) VALUES('p01', 32, 'M');
INSERT INTO persons (pid, age, gender) VALUES('p02', 1000, 'F');
INSERT INTO persons(pid, age, gender) VALUES('p03', 1000, 'S');

-- 외래키 제약조건
CREATE TABLE employees(
    emp_id NUMBER(3) PRIMARY KEY,
    emp_name VARCHAR2(20) NOT NULL,
    dept VARCHAR2(20) CHECK(dept IN('인사', '영업'))
);

INSERT INTO employees(emp_id, emp_name, dept) VALUES(1, 'James', '인사');
INSERT INTO employees(emp_id, emp_name, dept) VALUES(2, 'Ann', '영업');
INSERT INTO employees(emp_id, emp_name, dept) VALUES(3, 'David', '인사');


-- dept table 생성
CREATE TABLE dept(
    dept_id NUMBER PRIMARY KEY,
    dept_name VARCHAR2(20) NOT NULL UNIQUE
);

INSERT INTO dept(dept_id, dept_name) VALUES (1, '영업');
INSERT INTO dept(dept_id, dept_name) VALUES (2, '인사');
INSERT INTO dept(dept_id, dept_name) VALUES (3, '개발');
INSERT INTO dept(dept_id, dept_name) VALUES (4, '보안');
DELETE dept WHERE dept_id = 4;


-- employees table 생성
CREATE TABLE employees(
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(20) NOT NULL,
    dept_id NUMBER,
    CONSTRAINT emp_dept_fk FOREIGN KEY(dept_id) REFERENCES dept(dept_id)
);
-- ON DELETE CASCADE
CREATE TABLE employees(
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(20) NOT NULL,
    dept_id NUMBER,
    CONSTRAINT emp_dept_fk
    FOREIGN KEY (dept_id) REFERENCES dept(dept_id)
    ON DELETE CASCADE
);

INSERT INTO employees(emp_id, emp_name, dept_id) VALUES(1, 'James', 3);
INSERT INTO employees(emp_id, emp_name, dept_id) VALUES(2, 'Ann', 2);
INSERT INTO employees(emp_id, emp_name, dept_id) VALUES(3, 'David', 1);
INSERT INTO employees(emp_id, emp_name, dept_id) VALUES(4, 'Choi', null);
INSERT INTO employees(emp_id, emp_name, dept_id) VALUES(5, 'Cherta', 3);


-- ONDELETE SET NULL
CREATE TABLE employees(
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(20) NOT NULL,
    dept_id NUMBER,
    CONSTRAINT emp_dept_fk
    FOREIGN KEY (dept_id) REFERENCES dept(dept_id)
    ON DELETE SET NULL
);

-- JOIN
SELECT e.emp_id, e.emp_name, d.dept_name FROM employees e INNER JOIN dept d ON e.dept_id = d.dept_id;
SELECT e.emp_name, d.dept_name FROM employees e LEFT OUTER JOIN dept d ON e.dept_id = d.dept_id;
SELECT e.emp_name, d.dept_name FROM employees e RIGHT OUTER JOIN dept d ON e.dept_id = d.dept_id;