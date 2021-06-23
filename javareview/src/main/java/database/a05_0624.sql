/*
데이터 조작
insert : 데이터 입력
update : 데이터 수정
delete : 데이터 삭제
merge : 병합 처리 

insert
단일행 추가 : 테이블에 한 행 추가
insert into 테이블명 values(데이터1,데이터2,...)
insert into 테이블명(컬럼1,컬럼2...) values(데이터1,데이터2,...)
다중행 추가 : 테이블에 다중 행 추가
insert into 테이블명 select 컬럼1,컬럼2... from 테이블명
insert all
first insert

복제 테이블 만들기 
create table 테이블명
as select 컬럼1,컬럼2...
from 테이블명
*/
CREATE TABLE emp100
AS SELECT * FROM emp
WHERE 1=0;
SELECT * FROM emp100;
INSERT INTO emp100 values(1001,'홍길동','Pro',9999,sysdate,3000,300,10);
INSERT INTO emp100(ename,job,sal) values('고길동','leader',6000);
INSERT INTO emp100
SELECT * FROM emp
WHERE sal>3000;
INSERT ALL
INTO emp100 values(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM emp;
/*
update : 데이터를 수정할떄 사용,where 조건문이 없을경우 테이블의 모든 데이터를 변경
update 테이블명
	set 컬럼 = 데이터
		컬럼 = 데이터
		컬럼 = 데이터
	where 조건문
null 값 조건문
is null : null인경우
is not null : null 이 아닌경우
*/
UPDATE emp100
	SET comm = 100
	WHERE comm is null;
SELECT * FROM emp100;