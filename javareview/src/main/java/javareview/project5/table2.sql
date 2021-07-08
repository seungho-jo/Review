--상품테이블
CREATE TABLE sproduct(
   pcode varchar2(8) PRIMARY KEY,
   pname varchar2(70) CONSTRAINT sproduct_pname_nn NOT NULL,
   pbrand varchar2(50) CONSTRAINT sproduct_pbrand_nn NOT NULL,
   color varchar2(50),
   price NUMBER,
   pdate DATE
);
DROP TABLE SPRODUCT;
SELECT * FROM SPRODUCT P, STOCK S WHERE P.PCODE = S.PCODE;
--아우터
INSERT INTO sproduct VALUES('OT001','스탠다드 후드 스웨트 집업','멜란지','그레이',39900,TO_DATE('2021-06-01', 'yyyy-mm-dd'));
INSERT INTO sproduct VALUES('OT002','2WAY 스웻 후드 집업','토피','블랙',45000,TO_DATE('2021-06-02', 'yyyy-mm-dd'));
INSERT INTO sproduct VALUES('OT003','오버사이즈 트렌치 코트','드로우핏','블랙',189000,TO_DATE('2021-06-03', 'yyyy-mm-dd'));
--상의
INSERT INTO sproduct VALUES('TP001','어센틱 로고 티셔츠','커버낫','블랙',39000,TO_DATE('2021-06-01', 'yyyy-mm-dd'));
INSERT INTO sproduct VALUES('TP002','빅 트위치 로고 티셔츠','리','화이트',35000,TO_DATE('2021-06-02', 'yyyy-mm-dd'));
INSERT INTO sproduct VALUES('TP003','쿠퍼 로고 티셔츠','커버낫','네이비',39000,TO_DATE('2021-06-03', 'yyyy-mm-dd'));
INSERT INTO sproduct VALUES('TP004','에디 오버핏 반팔 티셔츠','제멋','블랙',35800,TO_DATE('2021-06-04', 'yyyy-mm-dd'));
INSERT INTO sproduct VALUES('TP005','사인로고 반팔 티셔츠','마크 곤잘레스','블랙',35000,TO_DATE('2021-06-05', 'yyyy-mm-dd'));

--재고테이블
CREATE TABLE stock(
   pcode varchar2(8) CONSTRAINT sproduct_pcode_fk REFERENCES sproduct(pcode),
   psize varchar2(8),
   stock NUMBER
);
-- 품절 테이블
CREATE TABLE soldOut(
	pcode varchar2(8) CONSTRAINT soldOut_pcode_fk REFERENCES sproduct(pcode),
	pname varchar2(70) CONSTRAINT soldOut_pname_nn NOT NULL,
	pbrand varchar2(50) CONSTRAINT soldOut_pbrand_nn NOT NULL,
   	color varchar2(50),	
   	psize varchar2(8)
);
-- 삭제 상품
CREATE TABLE dropProduct(
	pcode varchar2(8) PRIMARY KEY,
  	pname varchar2(70) CONSTRAINT dropProduct_pname_nn NOT NULL,
	pbrand varchar2(50) CONSTRAINT dropProduct_pbrand_nn NOT NULL,
	color varchar2(50),
	price NUMBER,
	pdate DATE
);
select count(p.pcode) from sproduct p,stock s where p.pcode = s.pcode;
ALTER TABLE DROPPRODUCT
DROP COLUMN stock;
SELECT * FROM dropProduct;
INSERT INTO dropProduct values('TP006','쿨 코튼 2-PACK 티셔츠','커버 낫','블랙',34000,sysdate);
select count(pcode) from dropPrduct;
INSERT INTO soldOut values('OT002','2WAY 스웻 후드 집업','토피','블랙','L');
SELECT count(p.pcode) FROM sproduct p, stock t WHERE p.pcode = t.pcode AND stock != '0';
SELECT sum(stock) FROM sproduct p, stock t WHERE p.pcode = t.pcode;
SELECT p.pcode,pname,sum(stock) FROM sproduct p, stock t WHERE p.pcode = t.pcode GROUP BY p.pcode,PNAME ;
INSERT INTO stock VALUES('OT001','S','10');
INSERT INTO stock VALUES('OT001','M','10');
INSERT INTO stock VALUES('OT001','L','10');
INSERT INTO stock VALUES('OT002','S','10');
INSERT INTO stock VALUES('OT002','M','10');
INSERT INTO stock VALUES('OT002','L','0');
INSERT INTO stock VALUES('OT003','M','10');
INSERT INTO stock VALUES('OT003','L','10');
INSERT INTO stock VALUES('TP001','S','10');
INSERT INTO stock VALUES('TP001','M','10');
INSERT INTO stock VALUES('TP001','L','10');
INSERT INTO stock VALUES('TP002','S','10');
INSERT INTO stock VALUES('TP002','M','10');
INSERT INTO stock VALUES('TP002','L','10');
INSERT INTO stock VALUES('TP003','S','10');
INSERT INTO stock VALUES('TP003','M','10');
INSERT INTO stock VALUES('TP003','L','10');
INSERT INTO stock VALUES('TP004','S','10');
INSERT INTO stock VALUES('TP004','M','10');
INSERT INTO stock VALUES('TP004','L','10');
INSERT INTO stock VALUES('TP005','S','10');
INSERT INTO stock VALUES('TP005','M','10');
INSERT INTO stock VALUES('TP005','L','10');

SELECT * FROM stock;
SELECT * FROM SPRODUCT;
SELECT * FROM sorder;
SELECT * FROM SARUWA_MEM;
--주문조회 sql
SELECT o.ordercode 주문번호,m.memid 아이디,p.pname 상품명,m.phone 번호,p.pbrand 브랜드,p.color 색상,p.price 가격,s.psize 사이즈,o.cnt 수량,o.address 주소,o.orderdate 주문일자
FROM sproduct p, stock s, saruwa_mem m, sorder o
WHERE p.pname = o.pname
AND m.memid = o.memid
AND s.psize = o.psize
AND o.ORDERCODE = '11111111';

--구매테이블 (주문번호, 아이디, 이름, 폰, 브랜드, 색상, 가격, 갯수, 주소, 주문일)
DROP TABLE sorder;
create table sorder (
   ordercode number(8) NOT NULL,
   memid varchar2(15) NOT NULL,
    address varchar2(20) not null,
    pname varchar2(70) NOT NULL,
    color varchar2(50) NOT NULL,
    psize varchar2(8) NOT NULL,
    cnt NUMBER not null,
    orderdate Date default sysdate
);
INSERT INTO sorder VALUES(11111111,'265926','서울시송파구','어센틱 로고 티셔츠','블랙','L',1,TO_DATE('2021-06-20', 'yyyy-mm-dd'));
INSERT INTO sorder VALUES(11111112,'hihiman','서울시강남구','빅 트위치 로고 티셔츠','화이트','M',3,TO_DATE('2021-06-21', 'yyyy-mm-dd'));
INSERT INTO sorder VALUES(11111113,'goodgirl','부천시원미구','쿠퍼 로고 티셔츠','네이비','L',4,TO_DATE('2021-06-22', 'yyyy-mm-dd'));
INSERT INTO sorder VALUES(11111114,'tjddnjs12','인천시계양구','오버사이즈 트렌치 코트','블랙','M',5,TO_DATE('2021-06-23', 'yyyy-mm-dd'));
INSERT INTO sorder VALUES(11111115,'soisoi99','서울시강동구','스탠다드 후드 스웨트 집업','그레이','L',6,TO_DATE('2021-06-24', 'yyyy-mm-dd'));
INSERT INTO sorder VALUES(11111116,'soisoi99','서울시강동구','어센틱 로고 티셔츠','블랙','L',7,TO_DATE('2021-06-24', 'yyyy-mm-dd'));

SELECT * FROM sorder;
SELECT * FROM SARUWA_MEM;
SELECT *
FROM SARUWA_MEM s , sorder o
WHERE s.MEMID = o.MEMID ;

--상품필터
--신상품순
SELECT pcode, pname, pbrand, color, price, pdate
FROM sproduct
ORDER BY pdate DESC ;

--가격낮은순
SELECT pcode, pname, pbrand, color, price, pdate
FROM sproduct
ORDER BY price;

--가격높은순
SELECT pcode, pname, pbrand, color, price, pdate
FROM sproduct
ORDER BY price DESC ;

--판매량 높은순
SELECT pcode, pname, pbrand, color, price, pdate
FROM sproduct;

SELECT sum(cnt), pname
FROM (
      SELECT cnt, pname
      FROM sorder s) 
group BY pname
ORDER BY sum(cnt) desc;

SELECT pcode, pname, pbrand, color, price, pdate
FROM sproduct;

SELECT * FROM sorder;
SELECT a.pname, pcode, pbrand,color,price,pdate,b.cnt
FROM sproduct a,(SELECT cnt, pname
FROM (SELECT sum(cnt) cnt, pname
	FROM sorder
	GROUP BY pname)) b
WHERE a.pname = b.pname
ORDER BY cnt desc;
SELECT cnt, pname
FROM (SELECT sum(cnt) cnt, pname
	FROM sorder
	GROUP BY pname);
/*SELECT cnt, pname
FROM SORDER s2
WHERE pname = '어센틱 로고 티셔츠';

SELECT sum(cnt)
FROM (
SELECT cnt, pname
FROM SORDER s2
WHERE pname = '어센틱 로고 티셔츠');*/
-- 좋아요
CREATE TABLE saruwa_like(
   pcode varchar2(8) CONSTRAINT saruwa_like_pcode_fk REFERENCES sproduct(pcode),
   memid varchar2(15) CONSTRAINT saruwa_like_memid_fk REFERENCES saruwa_mem(memid)
);
SELECT * FROM sorder;
create table sorder (
	ordercode number(8) NOT NULL,
	memid varchar2(15) NOT NULL,
    address varchar2(20) not null,
    pname varchar2(70) NOT NULL,
    color varchar2(50) NOT NULL,
    psize varchar2(8) NOT NULL,
    cnt NUMBER not null,
    orderdate Date default sysdate
);
DELETE FROM SPRODUCT
WHERE pcode = 'OT005';
	