CREATE TABLE adMember(
	id varchar2(16),
	pass number,
	name varchar2(50),
	adrank varchar2(30) 
);
INSERT INTO adMember values('himan',1111,'홍길동','마스터');
INSERT INTO adMember values('higirl',1111,'마길동','중간관리자');
INSERT INTO adMember values('admin',1111,'고길동','하위관리자');
SELECT * FROM ADMEMBER;
COMMIT;
CREATE TABLE saruwa_mem(
   memid varchar2(15),
   mpass varchar2(30) NOT NULL,
   email varchar2(50),
   phone number(8),
   mkagr number(1) check(mkagr IN (1,2)),
   PRIMARY key(memid, email, phone)
);
-- mkagr 이벤트 수신 동의여부 1:수신동의 2:수신비동의
SELECT * FROM saruwa_mem;
INSERT INTO saruwa_mem values('265926', 'qlalfqjsgh1*', '265926@gmail.com', 12345678, 1); 
INSERT INTO saruwa_mem values('hihiman', 'qlalfqlal55*', 'hihiman@naver.com', 28193729, 1);
INSERT INTO saruwa_mem values('goodgirl', 'rntrjfdla22!', 'goodgood@daum.net', 10284718, 2);
INSERT INTO saruwa_mem values('tjddnjs12', 'tjddnjsdl10$', 'qlqlw12@gmail.com', 35917293, 1);
INSERT INTO saruwa_mem values('soisoi99', 'thgnldla5;', 'soymilk@gmail.com', 29938102, 2);
INSERT INTO saruwa_mem values('admin','')
ALTER TABLE saruwa_mem ADD mdate date;
UPDATE saruwa_mem
   SET mdate = sysdate
   WHERE mdate IS null;
UPDATE saruwa_mem
	SET mdate = SYSDATE - 20
WHERE memid = 'tjddnjs12';
SELECT * FROM saruwa_mem;
SELECT *
FROM saruwa_mem
wheRE mdate BETWEEN trunc(sysdate,'MM') AND trunc(sysdate+(INTERVAL '1' MONTH),'MM') ; -- 월간
SELECT * FROM SARUWA_MEM;
SELECT COUNT(memid), FROM saruwa_mem;
select TRUNC(sysdate,'iw')-1,trunc(sysdate,'iw')+5 from dual;
SELECT *
FROM saruwa_mem
wheRE mdate BETWEEN TRUNC(sysdate,'iw') AND trunc(sysdate+7,'iw')-(0.5/12/60/60); -- 주간
SELECT trunc(sysdate,'YY'), trunc(sysdate+(INTERVAL '1' YEAR),'YY')-(0.5/12/60/60) FROM dual; -- 1년간 가입자
CREATE TABLE drop_saruwa_mem(
	memid varchar2(15),
   	mpass varchar2(30) NOT NULL,
   	email varchar2(50),
   	phone number(8),
  	mdate DATE NOT NULL,
  	PRIMARY key(memid, email, phone)
);
INSERT INTO drop_saruwa_mem values('jsh95320','154792135%','himan@naver.com',45791249,sysdate);
INSERT INTO drop_saruwa_mem values('shr57813','3278321sd$','hirman@naver.com',03354897,sysdate-20);
INSERT INTO drop_saruwa_mem values('024drsts','jhjh12348s','good@naver.com',12347893,sysdate-(INTERVAL '1' YEAR));
INSERT INTO drop_saruwa_mem values('BinChu','1268aw413','bin@naver.com',22648792,sysdate-31);
INSERT INTO drop_saruwa_mem values('WindDog','0554park1','WindDog@naver.com',21783124,sysdate-(INTERVAL '5' MONTH));
SELECT * FROM DROP_SARUWA_MEM ;
SELECT * FROM 
(SELECT *
FROM saruwa_mem
ORDER BY mdate desc)
WHERE rownum <=3;
select * from saruwa_mem where to_char(mdate,'YYYY/MM/DD') = to_char(sysdate,'YYYY/MM/DD');
SELECT * FROM saruwa_mem ORDER BY mdate;
SELECT COUNT(PCODE) FROM sproduct WHERE pcode like 'OT%';
CREATE TABLE cp_sproduct
AS SELECT * FROM sproduct WHERE 1=0;
CREATE TABLE cp_stock
AS SELECT * FROM stock WHERE 1=0;
SELECT * FROM sproduct;
SELECT * FROM cp_stock;
INSERT ALL
INTO cp_sproduct values('OT001','스탠다드 후드 스웨트 집업','멜란지','그레이',39900,TO_DATE('2021-06-01', 'yyyy-mm-dd'))
INTO cp_stock vales('OT001','S','10')
SELECT * FROM dual;
select p.*, s.psize, s.stock from sproduct p,stock s where p.pcode = s.pcode and pname like '%어센틱%';
select p.pcode, pname, price, stock
from sproduct p,(
SELECT pcode, sum(stock) stock 
FROM stock
GROUP BY pcode) s
where p.pcode = s.pcode;