/*
# 테이블 구조 변경
컬럼 타입,크기,기본값 변경 가능
데이터가 있는경우에는 다른 타입으로 변경 불가능,char -> varchar2는 가능
데이터가 없는경우는 변환이 자유롭다
형식 - alter table 테이블명 modify 컬럼명
*/
-- 데이터가 없는경우
CREATE TABLE emp0001
AS SELECT * FROM emp WHERE 1=0;
-- 크기 변경
ALTER TABLE emp0001
MODIFY ename varchar2(3000);
-- 타입 변경
ALTER TABLE emp0001
MODIFY empno varchar2(50);

-- 데이터가 있느 경우
CREATE TABLE emp0002
AS SELECT * FROM emp;
-- 크기 변경(단 기존의 값보다 작은수로는 불가능)
ALTER TABLE emp0002
MODIFY ename varchar2(100);
-- 컬럼의 최대 크기구하느법
SELECT max(LENGTH(ename)) FROM emp0002; -- 6
-- 카피테이블을 만든후 데이터유형을 바꾼후 update하여 다시 데이터를 넣는법
-- 1. 카피테이블 만들기(가져올 컬럼과, join할 컬럼 1개이상 필수)
CREATE TABLE cp_emp0002
AS SELECT empno, sal FROM emp0002;
-- 2. update 로 데이터유형을 바꾸려는 컬럼의 데이터들을 null 처리
UPDATE emp0002
	SET sal = NULL;
-- 3. 데이터 유형 변경
ALTER TABLE emp0002
MODIFY sal varchar2(4);
-- 4. update로 데이터 입력
UPDATE emp0002 a
	SET sal = (
		SELECT sal
		FROM cp_emp0002 b
		WHERE a.empno = b.empno
	);
SELECT * FROM emp0002;
/*
# 컬럼 이름변경, 테이블 이름변경
rename 테이블명 to 변경할 테이블명
alter table 테이블명
rename column 컬럼명 to 변경할 컬럼명
*/
RENAME emp0002 TO emp0003;
ALTER TABLE emp0003
RENAME COLUMN sal TO salary;
SELECT * FROM emp0003;
/*
# index(인덱스)
조회성 데이터의 처리 속도를 향상시키기 위해 컬럼에 대해 생성하는 객체
형식 
create index 인덱스명
on table(컬럼명)
index정보를 확인하는 sql
select *
from user_ind_columns
where table_name = 테이블명
*/
select *
from user_ind_columns
where table_name = 'EMP';
CREATE INDEX idx_emp0003_empno
ON emp0003(empno);
select *
from user_ind_columns
where table_name = 'EMP0003';
/*
고유 인덱스
유일한 값을 가지는 컬럼에 대해 생성하는 인덱스로 모든 테이블에 하나씩은 연결됨
형식
create unique index 인덱스명
on table(컬럼명)
index정보를 확인하는 sql
*/ 
CREATE TABLE emp0004
AS SELECT * FROM emp;
CREATE UNIQUE INDEX idx_emp0004_empno
ON emp0004(empno);
/*
단일인덱스 - 하나의 컬럼만 들어간 경우
결합인덱스 - 두 개 이상의 컬럼을 결합하여 생성하는 인덱스 
형식
create index 인덱스명
on 테이블명(컬럼명1, 컬럼명2)
*/
CREATE TABLE emp0005
AS SELECT * FROM emp;
CREATE INDEX idx_emp0005_ename_hiredate
ON emp0005(ename, hiredate);
select *
from user_ind_columns
where table_name = 'EMP0005';
/*
descending index
컬럼별로 정렬 순서를 별도로 지정하여 결합 인덱스
형식
create index 인덱스명 
on 테이블명(컬럼명1 desc, 컬럼명2 asc);
*/
CREATE TABLE emp0006
AS SELECT * FROM emp;
CREATE INDEX idx_emp0005_empno_sal
ON emp0005(empno desc, sal asc);
select *
from user_ind_columns
where table_name = 'EMP0006';
/*
함수기반 인덱스
컬럼에 대한 연산이나 함수의 계산 결과를 인덱스로 생성하는 것
2insert, update시에 새로운 값을 인덱스에 추가
형식
create index 인덱스명 on 테이블(함수(컬럼))
*/
CREATE TABLE emp0007
AS SELECT * FROM emp;
CREATE INDEX lowercase_idx
ON emp0007(lower(job));
select *
from user_ind_columns
where table_name = 'EMP0007';
/*
# 데이터 베이스 사용자 생성과 권한 생성
사용자를 생성하려면 관리자 계정이나 사용자 생성권한을 가진 계정으로 접근하여 생성/권한을 부여한다
사용자 생성 형식
create user 사용자명 indentified by 비밀번호
권한 종류
1. create user : 사용자를 새롭게 생성하는 권한
2. drop user : 사용자를 삭제하는 권한
3. drop any table : 테이블을 삭제하는 권한
4. query rewrite : 함수 기반 인덱스 생성 권한
5. backup any table : 테이블 백업 권한
6 .create session : 데이터베이스에 접속할 수 있는 권한
7. create table/view/sequence/procedure 데이터베이스의 객체들을 생성하는 권한
권한 부여 방법
1. 테이블 생성 권한 부여
	grant create table to 계정명
	ex) grant create table to orauser01;
2. 전체 oracle에서 사용되는 여러객체(테이블,index,sequence..)에 대한 권한 부여
	grant resource to 계정명;
3. 전체적인 계정에 대한 권한 부여 내용 확인하는 테이블
	dba_users
4. tablespace - 저장공간을 할당
	alter user 사용자명 default tablespace users; - 사용자가 사용할 tablespace 설정
	alter user 사용자명 quota unlimited on users; - 사용자가 사용할 tablespace의 용량을 설정

*/