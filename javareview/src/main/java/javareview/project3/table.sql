CREATE TABLE travel(
	nation varchar2(20),
	korName varchar2(50),
	engName varchar2(50),
	loc varchar2(100),
	clip NUMBER,
	content varchar(1000),
	category varchar(50),
	pnum varchar2(20),
	web varchar2(50)
);
INSERT INTO travel VALUES ('하와이','와이키키 해변','Waikiki Beach','2353 Kalakaua Avenue, Honolulu, HI 96815, USA',
449,'호놀룰루 남쪽 해안에 자리 잡은 하와이의 랜드마크 해변이다. 하와이 말로 용솟음치는 물 로 알려진 와이키키는 오아후의 주요 호텔과 리조트들이 들어서 있는 중심 지역이 되었다.',
'랜드마크, 해변/항구',NULL,'');
INSERT INTO travel VALUES ('하와이','하나우마 베이','Hanauma Bay','Catafalque Drive, Honolulu, HI 96825, USA',
329,'영화 블루 하와이의 촬영지로 바닷물의 투명도가 높은덕에 최고의 스노클링 포인트이다.',
'해변/항구',1-808-396-4229,'');
SELECT * FROM travel;
DELETE FROM travel WHERE korName = '하나우마 베이';
ALTER TABLE travel MODIFY pnum VARCHAR2(20);
INSERT INTO travel VALUES ('하와이','하나우마 베이','Hanauma Bay','Catafalque Drive, Honolulu, HI 96825, USA',
329,'영화 블루 하와이의 촬영지로 바닷물의 투명도가 높은덕에 최고의 스노클링 포인트이다.',
'해변/항구','1-808-396-4229','');
INSERT INTO travel VALUES ('하와이','다이아몬드 헤드','Diamond Head','4302 Diamond Head Road, Honolulu, HI 96816, USA',
292,'오아후섬 남동 해안에 있는 화산으로 높이는 232m이다. 바닷물의 침식작용으로 형성된 낭떠러지가 발달되어 경치가 아름답고, 정상에 오르면 와이키키와 호놀룰루시 전경이 한눈에 들어온다. 분화구 꼭대기의 암석들이 햇빛을 받아 반짝이는 것이 다이아몬드처럼 보인다 해서 붙여졌다.',
'랜드마크, 산/숲','1-808-587-0300','');
INSERT INTO travel VALUES ('하와이','지오반니 새우 트럭 (할레이와점)','Giovanni'||chr(39)||'s Shrimp Truck (Haleiwa Branch)','Catafalque Drive, Honolulu, HI 96825, USA',
245,'하와이에서 꼭 먹어봐야 할 음식 중 하나인 지오반니 새우 트럭. 양념에 조리한 새우를 밥에 곁들여 먹는 음식이다.',
'해산물','1-808-293-1839','www.giovannisshrimptruck.com');
UPDATE travel SET loc = '4302 Diamond Head Road, Honolulu, HI 96816, USA' WHERE korName = '다이아몬드 헤드';
INSERT INTO travel VALUES ('하와이','와이켈레 프리미엄 아울렛','Waikele Premium Outlets','94 Paioa Place, Waipahu, HI 96797, USA',
255,'미국 브랜드를 중심으로 저렴하게 구매할 수 있다.',
'아울렛','1-808-676-5656','www.premiumoutlets.com');
CREATE TABLE country(
name varchar2(50),
city varchar2(50),
location varchar2(50),
Introduce varchar2(300)
);
INSERT INTO country values('영국','런던','북아일랜드','영국의 수도는 런던이고 영국의 정식명칭은 그레이트브리튼 및 북아일랜드 연합왕국이며, 약칭으로 브리튼이라고 한다');
INSERT INTO country values('뉴질랜드','오클랜드 ','남서태평양','뉴질랜드 또는 아오테아로아는 남서 태평양에 있는 섬나라이고 수도는 웰링턴이다');
INSERT INTO country values('브라질','상파울루','남아메리카','브라질 연방 공화국 줄여서 브라질 또는 파서국은 남아메리카에 있는 연방 공화국이며 수도는 브라질리아이다');
INSERT INTO country values('일본','도쿄','동아시아','일본국 약칭 일본은 동아시아에 있는 국가이다. 태평양에 있는 일본 열도의 네 개의 큰 섬과 이들 주변에 산재한 작은 섬들로 구성되어 있고 수도는 도쿄이다');
INSERT INTO country values('미국','뉴욕','북아메리카','미합중국 약칭 합중국 또는 미국은 주 50개와 특별구 1개로 이루어진 연방제 공화국이다 수도는 워싱턴DC이다');
SELECT * FROM COUNTRY;
SELECT * FROM travel;
INSERT INTO travel VALUES ('하와이','알라모아나 비치 파크','Ala Moana Beach Park','163 Ala Moana Park Drive, Honolulu, HI 96814, USA',
260,'하와이 최대의 가족공원으로 넓은 잔디밭이 드넓게 펼쳐져 있으며, 백사장도 1km나 펼쳐져 있다. 테니스장과 간단한 운동기구, 조깅코스도 있어 관광객뿐만 아니라 현지인들도 많이 찾는 곳이다.',
'해변/항구','	1-808-768-4611',null);
CREATE TABLE changingInfo(
name varchar2(50),
category varchar2(50),
content varchar2(300)
);
SELECT * FROM changingInfo;
INSERT INTO changingInfo values('와이키키 해변','명칭','이름이 와이키키3번지로 변경되었어요');
INSERT INTO changingInfo values('와이키키 해변','주소','주소가 ###시로 변경되었어요');
INSERT INTO changingInfo values('와이키키 해변','기타','웹 사이트가 폐쇠되었어요');
CREATE TABLE travelUser(
email varchar2(100),
pass varchar2(50),
name varchar2(50),
gender char(1)
);
CREATE TABLE question(
writer varchar2(50),
name varchar2(50),
title varchar2(50),
content varchar2(1000),
tag varchar2(50),
writeDate date
);
INSERT INTO question values('나길동','와이키키 해변','여행','일정에 추가할만 한가요?','주변',sysdate);
INSERT INTO question values('고길동','에펠탑','여행지','야경이 좋은곳이 어딘가요','주변',sysdate);
INSERT INTO question values('조승호','와이키키 해변','서핑','서핑할수 있나요?','주변',sysdate);
INSERT INTO question values('다길동','와이키키 해변','','이곳 근처에 괜찮은 맛집 있나요?','주변',sysdate);
SELECT * FROM question JOIN travel ON travel.KORNAME = question.NAME ;
INSERT INTO travelUser VALUES('jsh95320@naver.com','1111','조승호','M');
INSERT INTO travelUser VALUES('admin@naver.com','0000','홍길동','M');
SELECT * FROM QUESTION Q JOIN TRAVELUSER T ON Q.writer = T.name;
CREATE TABLE travelReview(
	name varchar2(50),
	wdate DATE,
	feeling varchar2(30),
	place varchar2(50),
	review varchar2(2000)
);
INSERT INTO travelReview values('조승호',sysdate,'좋아요!','와이키키 해변','바다 뷰가 너무 좋아요!!');
INSERT INTO travelReview values('홍길동',sysdate,'괜찮아요!','와이키키 해변','좋긴한데 지저분하네요.');
INSERT INTO travelReview values('고길동',sysdate,'별로에요!','와이키키 해변','쓰레기가 너무 많고 사람이 너무 많이 붐벼요');
INSERT INTO travelReview values('가길동',sysdate,'좋아요!','와이키키 해변','서핑을 즐길수 있어서 좋네요');
INSERT INTO travelReview values('나길동',sysdate,'좋아요!','에펠탑','매시 정각,반짝이는 불빛의 에펠탑을 놓치치마세요!!');
SELECT * FROM QUESTION;
CREATE TABLE country(
name varchar2(20),
city varchar2(20),
location varchar2(20)
);
SELECT * FROM QUESTION q ;
SELECT * FROM emp;