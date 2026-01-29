--join
--cross join
SELECT student.*, enrol.* FROM student cross join enrol;
SELECT *FROM student;
SELECT *FROm enrol;
--EQUI JOIN
-- 2개 이상의 테이블에 관련 있는 공통 열의 값을 이용하여 논리적으로 결합하는 연산
-- 구버전
SELECT student.stu_no, student.stu_name, student.stu_dept, enrol.enr_grade
FROM student, enrol
WHERE student.stu_no = enrol.stu_no;

-- 현재
SELECT s.stu_no, s.stu_name, s.stu_dept, e.enr_grade
FROM student s join enrol e
on s.stu_no = e.stu_no;

-- 같은열이 두개이상이면 사용가능
-- ON student.stu_no = enrol.stu_no -> using
SELECT stu_no, stu_name, stu_dept, enr_grade
FROM student join enrol
USING(stu_no);

--NATUARL JOIN - using을 자동으로 해줌 - 잘 안씀
SELECT stu_no, stu_name, stu_dept, enr_grade
FROM student NATURAL JOIN enrol;

--기본 INNER JOIN
SELECT
    s.stu_no,
    s.stu_name,
    sub.sub_no,
    sub.sub_name,
    e.enr_grade
FROM student s
JOIN enrol e
    on s.stu_no = e.stu_no
join subject sub
    on e.sub_no = sub.sub_no;
    
-- 학생 기준 조회 (수강 안 한 학생도 포함)
SELECT 
    s.stu_no,
    s.stu_name,
    sub.sub_name,
    e.enr_grade
FROM student s
LEFT JOIN enrol e
    on s.stu_no = e.stu_no
LEFT JOIN subject sub
    on e.sub_no = sub.sub_no;

--특정학생의 수강내역 조회
SELECT 
    s.stu_name,
    sub.sub_name,
    e.enr_grade
FROM student s
JOIN enrol e 
    ON s.stu_no = e.stu_no
JOIN subject sub
    ON e.sub_no = sub.sub_no
WHERE s.stu_no = '20153088';

-- 과목별 수강 학생 목록
SELECT
    sub.sub_name,
    s.stu_name,
    e.enr_grade
FROM subject sub
JOIN enrol e
    on sub.sub_no = e.sub_no
JOIN student s
    on e.stu_no = s.stu_no
ORDER BY sub.sub_name, s.stu_name;

-- 과목번호 101을 수강하는 학생의 학번과 이름을 검색하시오
SELECT student.stu_no, stu_name
FROM student, enrol
WHERE student.stu_no = enrol.stu_no
AND sub_no = 101;

SELECT s.stu_no, s.stu_name
FROM student s
join enrol e
 ON s.stu_no = e.stu_no
WHERE e.sub_no = 101;

SELECT s.stu_no, s.stu_name
FROM student s
INNER JOIN enrol e
 ON s.stu_no = e.stu_no
WHERE e.sub_no = 101;

SELECT stu_no, stu_name
FROM student
JOIN enrol
USING (stu_no)
WHERE sub_no = 101;

--LFET JOIN 으로 변경
SELECT s.stu_no, s.stu_name, e.sub_no
FROM student s
LEFT JOIN enrol e
 ON s.stu_no = e.stu_no
 AND e.sub_no =101;

-- X: 결과가 INNER JOIN과 동일
SELECT s.stu_no, s.stu_name
FROM student s
LEFT JOIN enrol e
 ON s.stu_no = e.stu_no
 WHERE e.sub_no = 101;
 
 
-- 과목번호 101을 수강하는 학생의 학번과 이름, 과목명을 검색하시오
SELECT
  s.stu_no,
  s.stu_name,
  sub.sub_name
FROM student s, enrol e, subject sub
WHERE s.stu_no = e.stu_no
 AND e.sub_no = sub.sub_no
 AND e.sub_no = 101;
 
-- 101번 과목을 수강하지 않은 학생
SELECT
s.stu_no,
s.stu_name
FROM student s
LEFT JOIN enrol e
 ON s.stu_no = e.stu_no
 AND e.sub_no = 101
WHERE e.sub_no IS NULL;

-- 과목번호 101 또는 102를 수강하는 학생의 학번과 이름을 검색하시오.
SELECT student.stu_no, stu_name
FROM student, enrol
WHERE student.stu_no = enrol.stu_no
AND (sub_no = 101 or sub_no = 102);

--컴퓨터개론 과목을 수강하는 학생들의 학번, 이름, 과목명을 검색하는 질의문을 작성하시오
SELECT student.stu_no, student.stu_name, subject.sub_name
FROM student
JOIN enrol
 ON student.stu_no = enrol.stu_no
JOIN subject
 ON enrol.sub_no = subject.sub_no
WHERE subject.sub_name = '컴퓨터개론';
desc subject;
SELECT *FROM student;
SELECT *FROM enrol;
SELECT *FROM subject;
