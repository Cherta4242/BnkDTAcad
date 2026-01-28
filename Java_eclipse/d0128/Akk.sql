-- 학생 테이블
DROP TABLE enrol;
DROP TABLE student;
DROP TABLE subject;

SELECT * FROM student;
SELECT * FROM subject;
SELECT * FROM enrol;

Create TABLE student(
    stu_no CHAR(9),
    Stu_name VARCHAR2(20),
    stu_dept VARCHAR2(20),
    stu_grade NUMBER,
    stu_class CHAR(1),
    stu_gender CHAR(1) CHECK (stu_gender IN('M','F')),
    stu_height number(5,2),
    stu_weight NUMBER(5,2),
    CONSTRAINT p_stu_no PRIMARY KEY (stu_no)
);

-- 과목 테이블 생성
CREATE TABLE subject(
    sub_no CHAR(3),
    sub_name VARCHAR2(30),
    sub_prof VARCHAR2(20),
    sub_grade NUMBER(1),
    sub_dept VARCHAR2(20),
    CONSTRAINT p_sub_no PRIMARY KEY (sub_no)
);


-- 수강 테이블 생성
CREATE TABLE enrol(
    sub_no CHAR(3),
    stu_no CHAR(9),
    enr_grade NUMBER(3),
    CONSTRAINT p_enrol PRIMARY KEY(sub_no, stu_no),
    CONSTRAINT fk_enrol_sub
        FOREIGN KEY (sub_No)
        REFERENCES subject(sub_no),
    CONSTRAINT fk_enrol_stu
        FOREIGN KEY (stu_no)
        REFERENCES student(stu_no)
);
    
-- 학생 데이터 입력
INSERT INTO student VALUES ('20153075', '옥한빛', '기계', 1, 'C', 'M', 177, 80);
INSERT INTO student VALUES ('20153088', '이태연', '기계', 1, 'C', 'F', 162, 50);
INSERT INTO student VALUES ('20143054', '유가인', '기계', 2, 'C', 'F', 154, 47);
INSERT INTO student VALUES ('20152088', '조민우', '전기전자', 1, 'C', 'M', 188, 90);
INSERT INTO student VALUES ('20142021', '심수정', '전기전자', 2, 'A', 'F', 168, 45);
INSERT INTO student VALUES ('20132003', '박희철', '전기전자', 3, 'B', 'M', null, 63);
INSERT INTO student VALUES ('20151062', '김인중', '컴퓨터정보', 1, 'B', 'M', 166, 67);
INSERT INTO student VALUES ('20141007', '진현무', '컴퓨터정보', 2, 'A', 'M', 174, 64);
INSERT INTO student VALUES ('20131001', '김종헌', '컴퓨터정보', 3, 'C', 'M', null, 72);
INSERT INTO student VALUES ('20131025', '옥성우', '컴퓨터정보', 3, 'A', 'F', 172, 63);

-- 과목 데이터 입력
INSERT INTO subject VALUES('111', '데이터베이스', '이재영', 2, '컴퓨터정보');
INSERT INTO subject VALUES('110', '자동제어', '정순정', 2, '전기전자');
INSERT INTO subject VALUES('109', '자동화설계', '박민영', 2, '기계');
INSERT INTO subject VALUES('101', '컴퓨터개론', '강종영', 3, '컴퓨터정보');
INSERT INTO subject VALUES('102', '기계공작법', '김태영', 1, '기계');
INSERT INTO subject VALUES('103', '기초전자실험', '김유석', 1, '전기전자');
INSERT INTO subject VALUES('104', '시스템분석설계', '강석현', 3, '컴퓨터정보');
INSERT INTO subject VALUES('105', '기계요소설계', '김명성', 1, '기계');
INSERT INTO subject VALUES('106', '전자회로실험', '최영민', 3, '전기전자');
INSERT INTO subject VALUES('107', 'CAD응용실습', '구봉규', 2, '기계');
INSERT INTO subject VALUES('108', '소프트웨어공학', '권민성', 1, '컴퓨터정보');

--수강 데이터 입력
INSERT INTO enrol VALUES ('101', '20131001', 80);
INSERT INTO enrol VALUES ('104', '20131001', 56);
INSERT INTO enrol VALUES ('106', '20132003', 72);
INSERT INTO enrol VALUES ('103', '20152088', 45);
INSERT INTO enrol VALUES ('101', '20131025', 65);
INSERT INTO enrol VALUES ('104', '20131025', 65);
INSERT INTO enrol VALUES ('108', '20151062', 81);
INSERT INTO enrol VALUES ('107', '20143054', 41);
INSERT INTO enrol VALUES ('102', '20153075', 66);
INSERT INTO enrol VALUES ('105', '20153075', 56);
INSERT INTO enrol VALUES ('102', '20153088', 61);
INSERT INTO enrol VALUES ('105', '20153088', 78);



-- DISTINCT 중복제거 
SELECT DISTINCT stu_dept FROM student;

-- 수강테이블 학생 번호, 과목번호, 점수+10,
SELECT DISTINCT stu_no as "학생 번호", sub_no as "과목 번호", enr_grade as "원점수", enr_grade+10  FROM enrol;

-- 별칭 부여하기
SELECT stu_no AS ID, stu_name AS name FROM student;

-- 2개 이상의 열을 합쳐서 검색
SELECT stu_dept || stu_name AS 학과명 FROM student;
SELECt stu_dept || ',' || stu_name || '입니다' AS 학과명 FROM student;

-- WHERE 절 
-- 학생테이블에서 컴퓨터정보과 학생 목록 조회
SELECT * FROM student
where stu_dept = '컴퓨터정보';

-- WHERE 절 
-- 학생테이블에서 컴퓨터정보과 아닌 학생 목록 조회 != , <>, ^=
SELECT *FROM student
where stu_dept != '컴퓨터정보';

SELECT *FROM student
where stu_dept <> '컴퓨터정보';

SELECT *FROM student
where stu_dept ^= '컴퓨터정보';

SELECT *FROM student
where NOT stu_dept = '컴퓨터정보';

-- 학생테이블에서 '컴퓨터정보'학과 2학년인 학생의 이름, 학과명, 학년, 반 정보를 조회 AND
SELECT stu_name, stu_dept, stu_grade, stu_class 
FROM student
WHERE stu_dept = '컴퓨터정보' AND stu_grade = 2;


-- 학생테이블에서 2학년이거나 3학년인 학생 OR
SELECT *
FROM student
WHERE stu_grade =2 OR stu_grade=3
ORDER BY  stu_grade desc; 

-- 2학년이나 3학년 이면서 여학생만
SELECT *
FROM student
WHERE stu_gender = 'F' AND stu_grade IN (2, 3);

SELECT *
FROM student
WHERE (stu_grade = 2 OR stu_grade = 3) AND stu_gender IN('F');


-- 학생테이블에서 체중이 60이상 70이하인 학생들 조회
SELECT *
FROM student
WHERE stu_weight >= 60 AND stu_weight <=70;

SELECT *
FROM student
WHERE stu_weight BETWEEN 60 AND 70;

-- like 사용하기 %는 몇글자든 상관 x, _ 는 한글자로 인식 
SELECT *
FROM student
WHERE stu_name LIKE '김%';

SELECT *
FROM student
WHERE stu_name LIKE '_한%';

-- 학번이 2014로 시작하는 학생정보를 조회하시오
SELECT *
FROM student
WHERE stu_no LIKE '2014%';

-- 학생들의 키를 ft(feet)로 표시하시오
SELECT stu_name, ROUND((stu_height / 30.48),2) as ft
FROM student
WHERE stu_height IS not NULL;

-- 학생의 키 정보가 없는 학생들만 조회하시오.
SELECT stu_name, stu_height
FROM student
WHERE stu_height is NULL;
-- NULL 일때 기본값 부여 (NVL)
select stu_height FROM student;
Select NVL(stu_height,0) FROM student;

-- 여러개 조건 값 중 하나만 만족할 때
-- 컴퓨터정보 또는 기계과 학생들의 학번, 이름을 조회하시오
SELECT stu_no, stu_name FROM student WHERE stu_dept IN('컴퓨터정보','기계');

-- 정렬 ORDER By
-- 학생번호 순으로 학생정보를 조회하시오
SELECT * FROM student ORDER BY stu_no ASC; --오름차순
SELECT * FROM student ORDER BY stu_no DESC; -- 내림차순
--  학과 정렬 먼저하고 target정렬 (학과정렬 하고 몸무게순 정렬)
SELECT stu_no, stu_name, stu_dept, stu_weight -5 AS target FROM student
ORDER BY stu_dept, target;

-- ROUND 함수 dual은 임시테이블 
--          반올림          반올림              소수점자리수       일의자리반올림
SELECT ROUND(345.479),ROUND(345.479,0), ROUND(345.659,1), ROUND(345.679,-1)
FROM dual;

-- TURNC 함수
SELECT TRUNC(345.679),TRUNC(345.679,0),TRUNC(345.679,1),TRUNC(345.679,-1)
FROM dual;

-- MOD 함수
SELECT MOD(10,7) FROM dual;

--ABS 함수
SELECT ABS(-100) FROM dual;

-- FLOOR 함수
SELECT FLOOR(123.656) FROM dual;

-- LOWER 함수
SELECT LOWER('KOREA') FROM dual;

-- UPPER 함수
SELECT UPPER('korea') FROM dual;

-- INITCAP 함수
SELECT INITCAP('hello') FROM dual;

-- CONCAT 함수
SELECT CONCAT('ABC', 'def') FROM dual;

-- LENGTH 함수
SELECT LENGTH('ABCD') FROM dual;

-- SUBSTR 함수
SELECT SUBSTR('ABCDEFG', 4, 3) FROM dual;

-- INSTR 함수
SELECT INSTR('ABCABCABC', 'A', 2, 1) FROM dual;

-- LPAD 함수
SELECT LPAD('ABCD', 10, '&') FROM dual;

-- RPAD 함수
SELECT RPAD('ABCD', 10, '&') FROM dual;

-- 날짜 함수
SELECT SYSDATE FROM dual;
SELECT NEXT_DAY(SYSDATE, 7) FROM dual;
SELECT NEXT_DAY(SYSDATE, '토') FROM dual;

-- 반올림하기
SELECT ROUND(SYSDATE, 'YEAR') FROM dual;
SELECT ROUND(SYSDATE, 'MON') FROM dual;
SELECT ROUND(SYSDATE, 'DAY') FROM dual;

SELECT ADD_MONTHS(SYSDATE, 3) FROM dual;
SELECT LAST_DAY(SYSDATE) FROM dual;
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2025-12-28', 'YYYY-MM-DD'))FROM dual;




-- TO_CHAR 함수
SELECT empno, ename, TO_CHAR(hiredate, 'yyyy-mm') AS 입사년월 FROM emp;

-- TO_NUMBER 함수
SELECT TO_CHAR(TO_NUMBER('1234.5678'),'9999.999') FROM dual;
SELECT empno, ename, TO_CHAR(TO_NUMBER(sal), '$9999') salary FROM emp;


-- TO_DATE 함수
SELECT empno, ename FROM emp WHERE hiredate = TO_DATE('1980-12-17', 'yy-mm-dd');

-- NVL2
select * from emp;
SELECT ename, NVL2(comm, sal+comm, sal) FROM emp;

SELECT NULLIF('a', 'a') FROM dual;

SELECT NVL(nullif('A', 'A'), '널값') FROM dual;

SELECT COALESCE(1, NULL, 10, 100, NULL) FROM dual;

SELECT empno, ename, job, sal,
    CASE job WHEN 'SALESMAN' THEN SAL * 1.1
             WHEN 'CLERK' THEN SAL * 1.15
             WHEN 'MANAGER' THEN SAL * 1.2
             ELSE sal
    END AS 급여인상
FROM emp;


-- 그룹함수
-- MAX(), MIN()
SELECT MAX(enr_grade), MIN(enr_grade) FROM enrol;

-- COUNT()
SELECT COUNT(*), COUNT(stu_height) FROM student;
SELECT * FROM student;

-- SUM(), AVG()
SELECT SUM(stu_weight), TO_CHAR(AVG(stu_weight), '9999.99') FROM student group by TO_CHAR(AVG(stu_weight), '9999.99')
WHERE stu_dept = '컴퓨터정보';


-- GROUP BY
SELECT stu_dept, AVG(stu_weight) FROM student
GROUP BY stu_dept;

-- 체중이 50키로그램 이상인 학생들의 인원수를 구하시요(학과별로)
select * from student;

SELECT stu_dept, 
COUNT(*) FROM student where stu_weight>=50 group by stu_dept;









-- 해보는거
-- 인사관리의 사원(emp), 부서(dept), 급여(salgrade)를 이용하여 질의문을 작성하시오.

-- 1. 사원(emp) 테이블의 구조를 검색하라.
SELECT * FROM EMP;

-- 2. 사원들의 사원번호, 사원이름, 사원직무를 검색하시오.
SELECT empno, ename, job FROM emp;

-- 3. 사원들의 입사일 중복을 제거하고 검색하시오.
SELECT DISTINCT ename, hiredate FROM emp;

-- 4. 사원들의 6개월 급여의 합을 검색하라.
SELECT ename, sal*6 FROM emp;

-- 5. 사원들의 6개월 커미션의 합을 검색하라.
SELECT ename, comm*6 FROM emp;

-- 6. 사원이름을 'Name'으로, 사원의 급여를 'Salary'로 열의 이름을 부여하여 검색하시오.
SELECT ename AS Name, sal AS Salary FROM emp;

-- 7. 사원의 직무와 사원이름을 합쳐서 검색하라
SELECT CONCAT(job, ename) FROM emp;

-- 8. 10번 부서에 근무하는 사원이름을 검색하라.
SELECT ename FROM emp WHERE deptno = 10;

-- 9. 급여가 2000 이상인 사원들의 사원번호, 사원이름을 검색하라.
SELECT empno, ename FROM emp WHERE sal >= 2000;

-- 10. 사원직무가 'CLERK'인 사원들의 사원번호, 사원이름을 검색하라.
SELECT empno, ename FROM emp WHERE job = 'CLERK';

-- 11. 1980년 12월 17일에 입사한 사원의 이름을 검색하라.
SELECT ename FROM emp WHERE hiredate = '1980/12/17';

-- 12. 부서번호 30 이외의 부서이름과 지역을 검색하라.

-- 13. 10번 부서에 근무하는 MANAGER의 사원이름을 검색하라.
SELECT ename FROM emp WHERE deptno = 10 AND job = 'MANAGER';

-- 14. 급여가 2000이상이며, 30번 부서에 근무하는 사원들의 사원번호와 사원이름을 검색하라.
SELECT empno, ename FROM emp WHERE sal >=2000 AND deptno = 30;

-- 15. 사원직무가 'CLERK'이며, 81년 이후에 입사한 사원들의 사원번호와 이름을 검색하라.
SELECT empno, ename FROM emp WHERE job = 'CLERK' AND hiredate > TO_DATE(1981, 'YYYY');

-- 16. 사원직무가 'SALESMAN'이며 급여가 1500 이상인 사원이름을 검색하라.
SELECT ename FROM emp WHERE job = 'SALESMAN' AND sal >= 1500;

-- 17. 급여가 1000 이상이며, 2500 이하인 사원의 사원번호, 사원이름, 급여를 검색하라.
SELECT empno, ename, sal FROM emp WHERE 1000 <= sal AND sal<= 2500;

-- 18. 사원번호가 75XX인 사원의 사원번호, 사원이름, 부서번호를 검색하라.
SELECT empno, ename, deptno FROM emp WHERE empno LIKE '75__';

-- 19. 부서번호가 10 또는 30에 근무하는 사원들의 사원이름과 급여를 검색하라.
SELECT ename, sal FROM emp WHERE deptno = 10 OR deptno = 30;

-- 20. 상급자사원번호가 76으로 시작하는 사원들의 사원이름을 검색하라.
SELECT ename FROM emp WHERE mgr LIKE '76%';

-- 21. 사원번호가 79로 시작하는 사원들의 사원이름, 급여, 커미션을 검색하라.
SELECT ename, sal, comm FROM emp WHERE empno LIKE '79%';

-- 22. 1981년 2월에 입사한 사원의 사원번호, 사원이름, 부서번호를 검색하라.
SELECT empno, ename, deptno FROM emp WHERE hiredate > TO_DATE('1981/02', 'YYYY/mm') AND hiredate < TO_DATE('1981/03', 'YYYY/mm');

-- 23. 사원이름 중간에 'A'가 들어있는 사원의 사원번호와 사원이름을 검색하라.
SELECT empno, ename FROM emp WHERE ename LIKE '_A%_';

-- 24. 상급자사원번호가 NULL인 사원의 사원번호와 사원이름을 검색하라.
SELECT empno, ename FROM emp WHERE mgr IS NULL;

-- 25. 상급자사원번호가 NULL이 아닌 사원의 사원번호, 이름, 상급자사원번호를 검색하라.
SELECT empno, ename, mgr FROM emp WHERE mgr IS NOT NULL;

-- 26. 사원번호가 7902 또는 7781인 사원이름을 검색하시오.
SELECT ename FROM emp WHERE empno = 7902 OR empno = 7781;

-- 27. 상급자 사원번호가 7698 또는 7839인 사원의 사원번호와 사원이름을 검색하시오.
SELECT empno, ename FROM emp WHERE mgr = 7698 or mgr = 7839;

-- 28. 사원들의 사원번호와 사원이름을 사원번호 순으로 검색하라.(오름차순)
SELECT empno, ename FROM emp ORDER BY empno ASC;

-- 29. 사원들의 사원번호와 사원이름을 부서번호별 이름순으로 검색하라.
SELECT empno, ename FROM emp ORDER BY ename ASC;

-- 30. 사원들의 정보를 부서별 급여가 많은 순으로 검색하라.
SELECT * FROM emp ORDER BY sal DESC;

-- 31. 사원들의 정보를 부서번호, 사원직무, 급여 순으로 정렬하여 검색하라.
SELECT * FROM emp ORDER BY empno, job, sal ASC;

-- 32. 사원들의 사원이름, 사원직무를 소문자로 검색하라.
SELECT LOWER(ename), LOWER(job) FROM emp;

-- 33. 사원들의 사원이름, 사원직무를 대문자로 검색하라.
SELECT UPPER(ename), UPPER(job) FROM emp;

-- 34. 사원들의 사원이름을 첫 자만 대문자로 검색하라.
SELECT INITCAP(ename) FROM emp;

-- 35. 사원들의 사원이름과 사원직무를 연결하여 검색하라(concat 이용)
SELECT CONCAT(ename, job) FROM emp;

-- 36. 사원들의 사원이름과 사원이름의 첫 두 글자를 검색하라.
SELECT ename, SUBSTR(ename, 1, 2) FROM emp;

-- 37. 사원들의 사원이름과 사원이름의 길이를 검색하라.
SELECT ename, LENGTH(ename) FROM emp;

-- 38. 사원들의 이름에 'A'가 몇 번째 위치에 있는지 검색하라.
SELECT ename, INSTR(ename, 'A', 1, 1) FROM emp;

-- 39. 사원이름을 15자리로 하고, 뒤에 '&'를 채워 검색하시오.
SELECT RPAD(ename, 15, '&') FROM emp;

-- 40. 사원직무를 20자리로 하고, 앞에 '%'를 채워 검색하시오.
SELECT LPAD(ename, 20, '&') FROM emp;

-- 41. 사원의 사원번호, 사원이름, 급여를 검색하시오.(급여는 두 번째 자리에서 반올림함)
SELECT empno, ename, ROUND(sal, -2) FROM emp;

-- 42. 사원의 사원번호, 사원이름, 급여를 검색하라.(급여는 두 번째 자리에서 절삭함)
SELECT empno, ename, TRUNC(sal, -2) FROM emp;

-- 43. 사원번호와 급여를 100으로 나눈 나머지를 검색하라.
SELECT empno, MOD(sal, 100) FROM emp;

-- 44. 사원번호, 사원이름, 입사일, 입사 후 100일의 날짜를 검색하라.
SELECT empno, ename, hiredate, hiredate + 100 FROM emp;

-- 45. 사원번호, 사원이름, 입사일, 근무 일자(workdate)를 계산하여 검색하라.
SELECT empno, ename, hiredate, TRUNC(sysdate - hiredate) FROM emp;

-- 46. 사원들의 입사일에서 3달째 되는 날짜를 검색하라.
SELECT hiredate, ADD_MONTHS(hiredate, 3) FROM emp group by hiredate;

-- 47. 사원들의 입사일 다음 토요일의 날짜를 검색하라.
SELECT ename, hiredate, NEXT_DAY(hiredate, 7)AS 다음토요일 FROM emp;

-- 48. 사원들의 입사월의 마지막 날짜를 검색하라.
SELECT ename, hiredate, LAST_DAY(hiredate) FROM emp;

-- 49. 사원들의 입사일을 년을 기준으로 반올림하여 검색하라.
SELECT ename, hiredate, ROUND(hiredate, 'YEAR') FROM emp;

-- 50. 사원들의 입사일을 년을 기준으로 절삭하여 검색하라.
SELECT ename, hiredate, TRUNC(hiredate, 'YEAR') FROM emp;

-- 51. 상급자사원번호가 없는 사원의 경우 '상급자 없음'을 나타내도록 하는 질의문을 작성하라.
SELECT ename, NVL(TO_CHAR(mgr), '상급자 없음') FROM emp;

-- 52. 커미션을 포함한 급여를 사원번호, 사원이름과 함께 검색하라.
SELECT empno, ename, NVL2(comm, sal+comm, sal) FROM emp;

-- 53. 상급자사원번호가 NULL 인 경우 'CEO'로 바꾸어 사원번호, 사원이름, 상급자사원번호를 검색하라.
SELECT empno, ename, NVL(TO_CHAR(mgr), 'CEO') FROM emp;

-- 54. 커미션이 0인 사람은 100으로 설정하여 컬럼명을 'recomm'으로 하여 'SALESMAN'이면 커미션을 2배 인상하고,
--      CLERK이면 3배, ANALYST면 4배로 인상하고, 인상결과를 사원번호, 사원이름, 직무, 커미션,  재설정커미션(recomm) 컬럼과 함께 
--      '커미션인상'이라는 컬럼으로 표시하시오.
SELECT empno, ename, job, comm, NVL(comm, 100)AS recomm,
    CASE job WHEN 'SALESMAN' THEN SAL * 2
             WHEN 'CLERK' THEN SAL * 3
             WHEN 'MANAGER' THEN SAL * 4
             ELSE sal
    END AS 커미션인상
FROM emp;

-- 55. 전체 사원의 사원이름 중 MAX와 MIN 값을 검색하라.
SELECT MAX(ename) FROM emp;
SELECT MIN(ename) FROM emp;

-- 56. 상급자사원번호 열의 개수를 검색하라.
SELECT COUNT(*) FROM emp WHERE mgr is not null;

-- 57. 사원 테이블의 튜플 수를 검색하라.
SELECT COUNT(*) FROM emp;

-- 58. 부서별 사원들의 인원수를 검색하라.
SELECT deptno, COUNT(*) FROM emp GROUP BY deptno;

-- 59. 상급자사원별 사원들의 인원수를 검색하라. 상급자사원번호가 NULL이면 999로 표시한다.
SELECT NVL(mgr, 999), COUNT(*) FROM emp group by mgr;

-- 60. 부서별 사원들의 인원수를 인원수가 많은 순으로 검색하라.
SELECT deptno, COUNT(*) FROM emp group by deptno ORDER BY deptno DESC;

-- 61. 부서별, 사원직무별 사원의 급여 합을 많은 순으로 검색하라.
SELECT deptno, job, SUM(sal) FROM emp GROUP BY deptno, job ORDER BY SUM(sal) DESC;

-- 62. 부서별 사원들의 평균 급여를 평균 급여 순으로 검색하라.
SELECT deptno, TRUNC(AVG(sal), 0) FROM emp group by deptno ORDER BY TRUNC(AVG(sal), 0) DESC;

-- 63. 부서별, 사원직무별 사원들의 평균 급여를 평균 급여가 많은 순으로 검색하라.
SELECT deptno, job, ROUND(AVG(sal)) FROM emp group by deptno, job ORDER BY ROUND(AVG(sal)) DESC;


-- SUBQUERY
-- 단일 행 서브쿼리 

-- Jones 보다 급여가 높은 사원
SELECT empno, ename, sal
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'JONES'
);
SELECT * FROM emp;

-- 다중 행 서브쿼리
SELECT empno, ename, deptno
FROM emp
WHERE deptno IN (
    SELECT deptno
    FROM dept
    WHERE loc = 'DALLAS' or loc = 'NEW YORK'
);

-- FROM 절 서브쿼리(Inline View)
SELECT d.deptno, d.avg_sal
FROM (
    SELECT deptno, to_CHAR(AVG(sal), '9999.99') AS avg_sal
    FROM emp
    GROUP BY deptno
)d
WHERE d.avg_sal>2000;

-- 평균 급여가 2000 이상인 부서
SELECT deptno, AVG(sal) AS avg_sal FROM emp GROUP BY deptno HAVING AVG(sal) >= 2000;
-- 사원수가 5명 이상인 부서 조회
SELECT deptno, COUNT(*) AS emp_cnt FROM emp GROUP BY deptno HAVING COUNT(*) >= 5 ORDER BY emp_cnt DESC;

-- 전체 평균급여보다 평균 급여가 높은 부서
SELECT deptno, AVG(sal) AS avg_sal FROM emp GROUP BY deptno HAVING AVG(sal) >= AVG(sal);


-- 64. '컴퓨터정보'과 학생 중 가장 키가 큰 학생의 키는?

-- 65. 옥성우 학생보다 키가 큰 학생은 몇 명인가?

-- 66. 박희철 학생과 같은 체중을 가지고 있는 학생의 정보를 구하시오.

-- 67. 학생 테이블에서 '컴퓨터정보'학과 학생과 같은 반인 다른 학과의 학생 정보를 IN을 이용하여 구하기

-- 68. 10.20번 부서 사원들 중 최고 급여를 받는 사원의 사원번호, 사원이름, 급여를 검색하라.

-- 69. 30번 부서의 사원 중 최저 급여를 받는 사원의 사원번호, 사원이름, 급여를 검색하라.

-- 70. 전체 사원들 중 최고 커미션을 받는 사원의 사원번호, 사원이름, 급여를 검색하라.

-- 71. 전체 사원들 중 최저 커미션을 받는 사원의 사원번호, 사원이름, 커미션을 검색하라.


