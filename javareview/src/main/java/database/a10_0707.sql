/*
# 집합관계
종류
union - 합집합, 중복된 데이터 출력x
	sql1 union sql2
union all - 합집합이지만 중복된 데이터도 출력
	sql1 union all sql2
intersect - 교집합
	sql1 intersect sql2
minus - 먼저 위치한 조회문을 기준으로 다른 조회문과 공통된 데이터를 제외한 항목만 출력
	sql1 minus sql2
*/
-- union
SELECT '홍길동' name, 75 kor FROM dual
union
SELECT '김길동' name, 80 kor FROM dual
union
SELECT '신길동' name, 90 kor FROM dual
union
SELECT '홍길동' name, 75 kor FROM dual;
--union all
SELECT '홍길동' name, 75 kor FROM dual
UNION all
SELECT '김길동' name, 80 kor FROM dual
UNION all
SELECT '신길동' name, 90 kor FROM dual
UNION all
SELECT '홍길동' name, 75 kor FROM dual;
-- intersect 
SELECT ename, job, deptno, sal
FROM emp
WHERE sal BETWEEN 1000 AND 3000
INTERSECT 
SELECT ename, job, deptno, sal
FROM emp
WHERE sal BETWEEN 2000 AND 5000;
-- minus
SELECT ename, job, deptno, sal
FROM emp
WHERE sal BETWEEN 1000 AND 3000
MINUS 
SELECT ename, job, deptno, sal
FROM emp
WHERE sal BETWEEN 2000 AND 5000;
/*
# view 
- 하나 이상의 기본 테이블이나 다른 view를 이용하여 생성되는 가상 테이블
- 권한이 있는 사람만이 전체 테이블을 보고 그 외는 뷰를 통해서 허용된 테이블만 볼수있어서 데이터 보호에 좋다
query결과로 view를 만들었기 떄문에 가상테이블로 sql을 조회할 수 있다
생성
create [or replace] view 뷰이름
 		as (subquery - select * from ***)
종류
- 단순view
	하나의 테이블로 생성
	그룹 함수의 사용이 불가능 - 실제테이블의 데이터가 아니기에
	distinct 사용일때 불가능
	dml(insert, update, delete) 사용가능
- 복합view
	여러 개의 테이블로 설정
	그룹 함수의 사용이 가능
	distinct 사용이 가능
	dml(insert, update, delete)사용 불가능
*/
-- 단순view
DROP TABLE emp31;
CREATE TABLE emp31
AS SELECT * FROM emp;
CREATE VIEW view_emp31
AS SELECT empno, ename, sal, deptno
FROM emp31
WHERE deptno = 10;
SELECT * FROM view_emp31;
-- 복합view
DROP TABLE dept31;
CREATE TABLE dept31
AS SELECT * FROM dept;
CREATE VIEW view_emp_dept
AS 
SELECT e.empno,e.ename,e.sal,e.deptno,d.dname,d.loc
FROM emp31 e, dept31 d
WHERE e.deptno = d.deptno
ORDER BY empno DESC;
SELECT * FROM view_emp_dept;