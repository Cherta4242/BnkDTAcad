--72. 급여가 1000 이상 2000 이하인 사원들의 사원번호, 사원이름, 부서이름을 사원번호순으로 검색하라.
SELECT  
    e.empno,
    e.ename,
    d.loc
FROM emp e
JOIN dept d 
ON e.deptno = d.deptno WHERE e.sal >= 1000 AND e.sal <= 2000
ORDER BY d.deptno ASC;

--73. 사원직무가 SALESMAN이면서 CHICAGO 지역에 근무 중인 사원명을 검색하라.
SELECT e.ename, d.loc
FROM emp e , dept d
WHERE e.job = 'SALESMAN' AND d.loc = 'CHICAGO';

--74. NEW YORK이나 DALLAS 지역에 근무하는 사원들의 사원번호와 사원이름을 사원번호 순으로 검색하라.
SELECT e.empno, e.ename,deptno
FROM emp e
where deptno in(
    SELECT deptno
    FROM dept
    WHERE loc = 'NEW YORK' OR loc = 'DALLAS')
ORDER BY empno;

--75. 부서이름이 ACCOUNTING 이거나, 지역이 CHICAGO인 사원의 사원번호와 사원이름을 검색하라.
SELECT empno, ename
FROM emp e
JOIN dept d
ON e.deptno = d.deptno
WHERE d.loc = 'ACCOUNTING' OR d.loc = 'CHICAGO';

--76. NEW YORK이나 DALLAS 지역에 근무하는 사원들의 사원번호와 사원이름을 사원번호 순으로 검색하라.
SELECT empno, ename, deptno
FROM emp
WHERE deptno IN (
    SELECT deptno
    FROM dept
    WHERE loc = 'NEW YORK' OR loc = 'DALLAS')
ORDER BY empno;
    
--77. 부서이름이 ACCOUNTING이거나, 지역이 CHICAGO인 사원의 사원번호와 사원이름을 검색하라.
SELECT e.empno, e.ename
FROM emp e
JOIN dept d
 ON e.deptno = d.deptno
 WHERE d.loc = 'ACCOUNTING' OR d.loc = 'CHICAGO';
 
--78. 사원번호, 사원이름, 급여, 급여등급을 급여등급별 사원번호 순으로 검색하라.
SELECT *FROM salgrade;
SELECT 
e.empno, e.ename, e.sal, s.grade
FROM emp e
join salgrade s
on e.sal BETWEEN s.losal AND s.hisal
order by s.grade, e.empno;

--79. 사원번호, 사원이름, 상급자사원번호, 상급자이름을 검색하라. 구버전
SELECT e.empno, e.ename, e.mgr, m.ename
FROM emp e, emp m
WHERE e.mgr= m.empno;

--80. 사원번호, 사원이름, 상급자사원번호, 상급자 이름을 검색하라. 조인
SELECT e.empno, e.ename, e.mgr, m.ename
FROM emp e
JOIN emp m 
 ON e.mgr = m.empno;
 
--81. BLAKE 사원보다 많은 급여를 받는 사원이름을 검색하라. 서브쿼리
SELECT ename, sal
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'BLAKE');
    
--82. BLAKE 사원보다 많은 급여를 받는 사원이름을 검색하라.  셀프조인
SELECT e.ename
FROM emp e
JOIN emp m 
ON e.sal > m.sal
WHERE m.ename = 'BLAKE';
 
--83. FORD 사원과 같은 부서에 근무하는 사원이름을 검색하라.
SELECT ee.ename, ee.deptno
FROM emp e
JOIN emp ee
ON e.deptno = ee.deptno
WHERE e.ename = 'FORD';
 
--84. FORD 사원과 같은 급여를 받는 사원의 사원번호를 검색하라.
SELECT empno
FROM emp 
WHERE sal =(
    SELECT sal
    FROM emp
    WHERE ename = 'FORD');
    
--85. 부서별 인원수를 부서이름과 함께 사원이 많은 부서 순으로 검색하라
SELECT d.dname,COUNT(*)
FROM emp e
JOIN dept d
on e.deptno = d.deptno
GROUP BY d.dname
ORDER BY count(*) desc;

--86. 사원번호, 사원이름을 부하직원수가 많은 순으로 검색하라.
SELECT m.empno, m.ename, COUNT(*)
FROM emp e
JOIN emp m
on e.mgr = m.empno
GROUP BY m.empno, m.ename
ORDER BY count(*) desc;

--87. 부서이름이 'SALES'이면서 사원직무가 'MANAGER'인 사원의 사원번호 이름을 사원이름 순으로 검색하라.
SELECT *FROM dept;
SELECT *FROM emp WHERE job ='MANAGER';
SELECT e.empno, e.ename
FROM emp e
JOIN dept d
on e.deptno = d.deptno
WHERE d.dname = 'SALES' AND e.job = 'MANAGER'
ORDER BY e.ename desc;

--88. SCOTT 사원보다 많은 급여를 받는 사원 정보를 검색하라.
SELECT ename
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'SCOTT');
    
--89. ALLEN 사원보다 적은 급여를 받는 사원 정보를 검색하라.
SELECT ename
FROM emp
WHERE sal < (
    SELECT sal
    FROM emp
    WHERE ename = 'SCOTT');
    
--90. 20번 부서 사원의 사원직무와 같은 사원직무인 다른 부서의 사원 정보를 검색하라.
SELECT *
FROM emp
WHERE deptno != 20 AND job IN(
    SELECT job
    FROM emp
    WHERE deptno = 20
);

--91. 전체 사원의 평균 급여보다 급여가 많은 사원 정보를 검색하라.
SELECT *
FROM emp
WHERE sal > (
    SELECT AVG(sal)
    FROM emp
);

--92. 급여가 모든 부서들의 평균 급여보다 많은 사원 정보를 검색하라
SELECT *
FROM emp
WHERE sal > (
    SELECT AVG(sal)
    FROM emp
    WHERE deptno
);

-- 아 공부좀 더하자 진짜 모르겠다..
--93. 20번 부서의 최대 급여보다 최대급여가 큰 부서의 번호와 최대급여를 검색하라.

--94. CHICAGO 지역에 위치하는 부서에 근무하는 사원 정보를 검색하라.

--95. 학번, 이름, 과목이름, 점수를 검색하라

--96. 과목이름과 학번, 점수를 검색하라

--97. 점수가 70점 이상인 학생 이름을 검색하라.

--98. 점수가 60점 이상인 학생 이름을 검색하라.

--99. 여학생이 수강중인 과목의 과목이름을 모두 검색하라.

--100. '컴퓨터개론'과 '시스템분석서례 과목을 수강하는 학생의 학번, 이름을 학번 순으로 검색하라.