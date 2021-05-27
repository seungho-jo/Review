SELECT * FROM emp;
SELECT empno, ename FROM emp;
SELECT empno AS "사원번호", ename "사원명" FROM emp;
SELECT '사원번호: ' || empno || ', 사원명: ' || ename FROM emp;
SELECT '보너스(연봉10%): ' || sal*0.1 "보너스" FROM emp;
-- 한줄 주석
/*
 * 다중 주석
 */
