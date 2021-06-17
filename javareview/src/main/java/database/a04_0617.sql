/*
# join
sql 명령문에서 하나의 테이블만 검색하는것이 아니라 2개이상의 테이블을 
사용하여 조회할수 있는 기능이다
기본 구성
select 컬럼명
from 테이블 별칭, 테이블 별칭
where 별칭.컬럼 = 별칭.컬럼
*/
SELECT *
FROM emp e,dept d
WHERE e.deptno = d.deptno;
/*
기본 구성에 추가로 조건을 걸거나, 그룹화하여 사용가능
*/
SELECT dname, loc, ename, to_char(hiredate,'Q') 분기
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND to_char(hiredate,'Q') = '1';
SELECT loc, avg(sal)
FROM emp e,dept d
WHERE e.DEPTNO = d.DEPTNO 
GROUP BY loc;
/*
non equl join 
컬럼값이 완전일치하지 않아도 범위 안에 존재한다면 결합되는 join문이다
*/
SELECT ename, sal, grade
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal;
/*
outer join
기본 join에서는 두 테이블간 컬럼값이 일치하여야 join이 되고 null이 존재할경우 그 데이터를
제외하고 출력하지만 outer join의 경우 null이 존재하더라도 우선 결합시키는 방식이다
*/
SELECT e.ename, e.deptno, d.deptno, dname
FROM emp e, dept d
WHERE e.DEPTNO(+) = d.DEPTNO ;
/*
self join 
하나의 테이블에서 상관관계가 존재하는 컬럼끼리를 비교하여 결과를 도출하는 join이다
*/
SELECT e.empno,e.ename,e.mgr,m.ename msg
FROM emp e, emp m
where e.mgr = m.empno;
/*
# subquery
하나의 SQL 명령문의 결과를 다른 SQL 명령문에 전달하기 위해 두 개 이상의 SQL 명령문을
하나의 SQL명령문으로 연결하여 처리하는 방법 
*/
SELECT * 
FROM EMP
WHERE deptno = (
	SELECT deptno
	from emp
	WHERE ename = 'SMITH'
);
/*
단일행비교 : 비교연산자( = , > , < , >= , <= )
다중행비교 : in, any, some, all, exists
*/
-- 단일행비교
SELECT * 
FROM emp
WHERE sal = (
	SELECT max(sal)
	FROM emp
	WHERE deptno = 10
);
-- 다중행 비교
SELECT * 
FROM emp
WHERE sal = (
	SELECT max(sal)
	FROM emp
	WHERE deptno = 10
);
-- 다중행 비교
SELECT *
FROM emp
WHERE (deptno, sal) in (
	SELECT deptno, max(sal)
	FROM emp
	GROUP BY deptno
);
SELECT *
FROM emp
WHERE exists(
	SELECT *
	FROM emp
	WHERE comm = 2422
);
-- 그외 subquery
SELECT *
FROM (
	SELECT deptno,ename,empno, sal
	FROM emp
	WHERE sal BETWEEN 2000 AND 4000
) a, dept d
WHERE a.deptno = d.deptno;