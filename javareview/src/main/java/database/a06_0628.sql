/*
데이터 삭제
delete문을 사용하여 테이블에 저장된 데이터 삭제
where 조건문을 붙이지 않는다면 테이블의 모든 데이터 삭제
delete from 테이블명
where 조건명
*/
CREATE TABLE emp105
AS SELECT * FROM emp;
SELECT * FROM emp105;
DELETE FROM emp105
WHERE nvl(comm,0) = 0;
/*
merge
한번의 조건에 따라 여러가지 dml을 분기적으로 사용할때 사용 - oracle에서만 지원하는 sql
merge into 테이블 a
using 테이블 b
on a.컬럼 = b.컬럼
when matched then
	update set 수정할 구문
when not matched then
	insert values
*/
CREATE TABLE emp106
AS SELECT * FROM emp
WHERE to_char(hiredate,'Q') IN ('1','2');
MERGE INTO emp106 a
USING emp b
ON (a.empno = b.empno)
WHEN MATCHED THEN 
	UPDATE SET a.job = b.job,
			   a.sal = b.sal,
			   a.hiredate = to_date(to_char(sysdate,'YYYY')||to_char(hiredate,'MMDD'),'YYYYMMDD')
WHEN NOT MATCHED THEN 
	INSERT (empno,job,sal,hiredate)
	VALUES (b.empno,b.job,b.sal,sysdate);
SELECT * FROM emp106;
/*
merge
가상테이블로 외부에서 입력된 데이터를 처리할수 있다
입력된 데이터가 있으면 update, 없을때는 insert 
*/
-- 입력된 데이터와 일치할때
CREATE TABLE emp107
AS SELECT * FROM emp;
MERGE INTO emp107 e
USING dual
ON (e.empno = 7499)
WHEN MATCHED THEN 
	UPDATE SET ename = '홍길동',
			   sal = 3000,
			   comm = sal*0.1
WHEN NOT MATCHED THEN 
	INSERT (empno,ename,sal,comm)
-- 입력된 데이터와 불일치할때
CREATE TABLE emp107
AS SELECT * FROM emp;
MERGE INTO emp107 e
USING dual
ON (e.empno = 9000)
WHEN MATCHED THEN 
	UPDATE SET ename = '홍길동',
			   sal = 3000,
			   comm = sal*0.1
WHEN NOT MATCHED THEN 
	INSERT (empno,ename,sal,comm)
	values (9000,'고길동',2800,500);
SELECT * FROM emp107;