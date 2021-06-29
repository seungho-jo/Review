/*
# 데이터 무결성 제약조건
데이터의 정확성과 일관성을 보장하기위해 설정
종류
- not null : 열에 null값이 존재할수 없음
- unique key : 데이터 값이 테이블에서 고유한 값이어야 한다
- primary key : not null과 unique key 가 결합된 조건
- check : 데이터를 범위나 조건을 걸어 그 외의값은 넣지 못한다
- foreign key : 한 열과 참조된 테이블의 열간에 외래 키 관계 설정
*/

-- not null
CREATE TABLE test1(
	name varchar2(50) CONSTRAINT test1_name_nn NOT NULL,
	age NUMBER NOT null
);
INSERT INTO test1 VALUES('홍길동',27);
INSERT INTO test1 VALUES('마길동',0);
INSERT INTO test1 VALUES(null,25);
-- SQL Error [1400] [23000]: ORA-01400: cannot insert NULL into ("SCOTT"."TEST1"."NAME")
INSERT INTO test1 values('홍길동',30);
SELECT * FROM test1;
-- *null 값만 등록이 안되며 중복값은 허용

-- unique key
CREATE TABLE test2(
	name varchar2(50) CONSTRAINT test2_name_uk UNIQUE,
	age NUMBER unique
);
INSERT INTO test2 VALUES('홍길동',27);
INSERT INTO test2 VALUES('마길동',27);
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT.SYS_C007177) violated
INSERT INTO test2 VALUES(null,25);
INSERT INTO test2 VALUES(null,26);
SELECT * FROM test2;
-- *중복된 값은 등록이 안되며 null은 중복되어도 등록 가능하다

-- primary key
/*
CREATE TABLE test3(
	name varchar2(50) CONSTRAINT test3_name_pk PRIMARY KEY,
	age NUMBER PRIMARY key
);
SQL Error [2260] [42000]: ORA-02260: table can have only one primary key
primary key는 테이블에서 1개만 존재할수 있다
*/
CREATE TABLE test3(
	name varchar2(50) CONSTRAINT test3_name_pk PRIMARY KEY,
	age NUMBER 
);
INSERT INTO test3 values('홍길동',27);
INSERT INTO test3 values(null,27);
--SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT.TEST3_NAME_PK) violated
INSERT INTO test3 values('홍길동',30);
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT.TEST3_NAME_PK) violated
SELECT * FROM test3;
-- *중복(x),null(x) 둘다 등록 불가능

-- check
CREATE TABLE test4(
	gender varchar2(1) CHECK (gender IN ('F','M')),
	age NUMBER CONSTRAINT test4_age_ck check( age BETWEEN 1 AND 55)
);
INSERT INTO test4 values('F',30);
INSERT INTO test4 values('M',30);
INSERT INTO test4 values(NULL,27);
INSERT INTO test4 values('F',30);
INSERT INTO test4 values('R',30);
-- SQL Error [2290] [23000]: ORA-02290: check constraint (SCOTT.SYS_C007179) violated
SELECT * FROM test4;
-- null값은 등록가능하지만 지정한 조건 외의 정보는 등록 불가능

-- foreign key
CREATE TABLE teacher02(
	tno NUMBER PRIMARY KEY
);
INSERT INTO teacher02 values(10);
INSERT INTO teacher02 values(11);
INSERT INTO teacher02 values(12);
SELECT * FROM teacher02;
CREATE TABLE student09(
	name varchar2(50),
	tno NUMBER CONSTRAINT student09_tno_fk REFERENCES teacher01(tno)
);
INSERT INTO student09 values('홍길동',10);
INSERT INTO student09 values('신길동',11);
INSERT INTO student09 values('마길동',13);
-- SQL Error [2291] [23000]: ORA-02291: integrity constraint (SCOTT.STUDENT08_TNO_FK) violated - parent key not found
INSERT INTO student09 values('오길동',12);
SELECT * FROM student09;

/*
# sequence
유일한 식별자 데이터를 만들기 위한 객체, 여러 테이블에서 공유가 가능하다
	create sequence 시퀀스명
		increment by 증가단위
		start with 시작번호
		maxvalue 최대값 | nomaxvalue
		minvalue 최소값 | nominvalue
		cycle | nocycle -- 반복여부 설정
		cache n | nocache -- 속도 개선을 위해 메모리 캐쉬 시퀀스 수 
선언된 시퀀스 사용	
	1) 시퀀스명.nextval : 현재 시퀀스번호를 출력하면서 다음 시퀀스 넘버링 처리
	2) 시퀀스명.currval : 현재 시퀀스번호 출력
*/
CREATE SEQUENCE seq1
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 999999;
SELECT seq1.currval
FROM dual;