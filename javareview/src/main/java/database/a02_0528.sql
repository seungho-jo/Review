/*
select문의 표준 형식
select 컬럼명, ... : 열 단위로 나타날 데이터(컬럼명)
from 테이블명 : 대상 테이블 
where 조건문 : 행 단위로 나타날 데이터 필터링처리
group by 그룹화 컬럼지정 : 특정 컬럼 기준으로 합산, 갯수, 최대/최소
having 그룹의 조건 지정 : 그룹 컬럼의 조건
order by 정렬할 우선순위 컬럼 - desc(역순정렬), 없을경우 정순졍렬

where 조건문
관계대수(=,<=,>=,<,>),and,or,subquery(중첩질의),비교연산자(!=,is not null,is null)들을 사용하여 행 단위로 나타낼 데이터 정렬
*/
SELECT * FROM emp;
SELECT * FROM emp
WHERE sal >= 2000;
SELECT * FROM emp
WHERE sal < 5000;
SELECT * FROM emp
WHERE sal >= 2000 AND sal < 5000;
SELECT * FROM emp
WHERE ename != 'JONES';
SELECT comm FROM emp
WHERE deptno IS NOT null;
