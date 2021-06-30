/*
# 테이블 구조 변경
작성한 테이블에서 구조를 변경하는경우 사용
종류
- 컬럼 추가
- 컬럼 삭제
- 컬럼 변경
- 제약조건 변경	
*/

-- 컬럼 추가
-- alter table 테이블명 add 컬럼명 데이터유형 [default 디퐅트데이터 제약조건]
CREATE TABLE emp116
AS SELECT * FROM emp;
ALTER TABLE emp116
ADD testcol NUMBER DEFAULT 0;
SELECT * FROM emp116;

-- 컬럼 제거
-- alter table 테이블명 drop column 컬럼명
ALTER TABLE emp116
DROP COLUMN testcol;
SELECT * FROM emp116;