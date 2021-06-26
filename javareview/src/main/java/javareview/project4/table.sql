CREATE TABLE BookStore(
	kind varchar2(10),
	name varchar2(50),
	pnum varchar2(20),
	loc varchar2(100),
	web varchar2(100),
	sns varchar2(100)
);
INSERT INTO BookStore values('새책방','1984','02-325-1984','마포구 마포구 동교로 194 혜원빌딩 1층','','https://www.instagram.com/1984store');
INSERT INTO BookStore values('새책방','21세기문고','02-3463-1880','강남구 강남구 남부순환로359길 31','','');
INSERT INTO BookStore values('새책방','C&S서점','02-2190-2178','강남구 강남구 남부순환로 2806 군인공제회관 지하 1층','','');
INSERT INTO BookStore values('새책방','Poetic Humans Club(PHC)','','마포구 성미산로 127 2층','','');
INSERT INTO BookStore values('새책방','SK문고','02-945-1959','강북구 솔샘로 205 2층','','');
INSERT INTO BookStore values('헌책방','Yes24 중고매장(강서NC점)','1566-4295','강서구 강서로56길 17 NC백화점 강서점 8, 9층',
'http://www.yes24.com/Mall/UsedStore/Det','');
INSERT INTO BookStore values('헌책방','강동헌책방','02-471-0272','강동구 강동구 구천면로 257','','');
INSERT INTO BookStore values('헌책방','개똥이네(가양점)','02-2658-2982','강서구 강서구 양천로 431 지하 1층','','');
INSERT INTO BookStore values('헌책방','고시책사랑','02-871-5550','관악구 관악구 호암로26길 27','','');
INSERT INTO BookStore values('헌책방','공씨책방(성수점)','010-4350-4970','성동구 광나루로 130 106호-라','','');
SELECT kind,name,nvl(pnum,'-') pnum,nvl(loc,'-') loc,nvl(web,'-') web,nvl(sns,'-') sns FROM bookStore
WHERE upper(name) LIKE upper('%%') AND kind like '%%' AND loc like '%%';
CREATE TABLE evtDataPrg(
	title varchar2(50),
	writer varchar2(20),
	wdate DATE,
	visit NUMBER,
	evtyear	NUMBER,
	content varchar2(2000)
);
SELECT * FROM evtDataPrg;
ALTER TABLE evtDataPrg MODIFY title varchar2(500);
INSERT INTO evtDataPrg values('서울지식이음축제 -Link Revolution(아이디어톤대회)','김OO',sysdate,0,
2019,'아이디어톤 대회 11.24(일) 10:00-19:30 서울시청 다목적홀','이미지.PNG');
INSERT INTO evtDataPrg values('서울지식이음축제- 이색독서 외','김OO',to_Date('2021-01-21','YYYY-MM-DD'),0,
2019,'이글루프탑 11.23(토),24(일) 10:00-20:00 서울도서관 5층 하늘뜰','이미지.PNG');
INSERT INTO evtDataPrg values('서울지식이음축제-체험 및 전시 프로그램','김OO',to_Date('2021-01-21','YYYY-MM-DD'),255,
2019,'지식랜드 11.23(토),24(일) 11:00-18:00 서울도서관 3층 서울자료실','이미지.PNG');
INSERT INTO evtDataPrg values('서울지식이음축제- 각종 강연 프로그램','김OO',to_Date('2021-01-21','YYYY-MM-DD'),261,
2019,'워킹&토킹 11.23(토) 14:00-18:00 서울도서관 일반자료실1,2','이미지.PNG');
ALTER TABLE evtDataPrg ADD kind varchar2(50);
INSERT INTO evtDataPrg(kind) values('프로그램');
DELETE evtDataPrg WHERE kind = '프로그램';
update evtDataPrg set kind = '프로그램' where writer = '김OO';
INSERT INTO evtDataPrg VALUES('[news1] 공연·전시가 있는 ''시끌벅적'' 도서관…서울도서관 축제','김OO',to_date('2020-01-17','YYYY-MM-DD'),210,
2019,'공연·전시가 있는 ''시끌벅적'' 도서관…서울도서관 축제 /2019.11.17
서울도서관이 각종 공연과 전시를 함께 펼치는 책 읽기 축제를 개최한다.
서울시는 2008년부터 지난해까지 열린 ''서울 북 페스티벌''을 개편한 ''2019 서울지식이음축제''를 오는 23~24일 서울도서관에서 개최한다.
올해 주제는 도서관에 대한 기존 고정관념에 도전하며 도서관의 혁신과 사회적 역할을 모색하기 위해 ''비욘드 라이브러리''(Beyond Library)로 정했다.
출처 : [news1] http://news1.kr/articles/?3770863','','보도자료');
UPDATE evtDataPrg SET visit = visit+1 WHERE title = '서울지식이음축제- 이색독서 외';
SELECT to_date('','YYYY-MM-DD') FROM dual;
SELECT * FROM EVTDATAPRG;
select * from evtDataPrg where evtyear LIKE 2019 AND title like '%%' AND content like '%%' AND 
wdate between to_date('2021-01-01','YYYY-MM-DD') and to_date('2021-06-17','YYYY-MM-DD');
CREATE TABLE library(
	kind varchar2(10),
	name varchar2(50),
	usetime varchar2(40),
	closedDay varchar2(40),
	pnum varchar2(20),
	web varchar2(100),
	loc varchar2(100),
	bookjoin varchar2(30)
);
SELECT * FROM library;
ALTER TABLE library MODIFY closedDay varchar2(70);
INSERT INTO library values('대표도서관','서울도서관','평일 : 09:00~21:00, 주말 : 09:00~18:00','월요일 및 법정공휴일','02-2133-0300',
'https://lib.seoul.go.kr/','서울특별시 중구 세종대로 110 태평로1가','참여');
INSERT INTO library values('국립도서관','국립어린이청소년도서관','평일 : 09:00~18:00, 주말 : 09:00~18:00','매월 둘째넷째 월요일, 일요일을 제외한 공휴일','02-3413-4800 ',
'http://www.nlcy.go.kr/','서울특별시 강남구 테헤란로7길 21','미참여');
INSERT INTO library values('국립도서관','국립중앙도서관','평일 : 09:00~18:00, 주말 : 09:00~18:00','둘째,넷째 월요일/법정공휴일(일요일제외)','02-535-4142',
'http://www.nl.go.kr','서울특별시 서초구 반포대로 201','미참여');
INSERT INTO library values('공공도서관','4.19혁명기념도서관','평일 : 09:00~17:00, 주말 : 09:00~12:30','정부지정 공휴일(일요일 포함)','02-730-4190',
'http://library.419revolution.org','서울특별시 종로구 새문안로 17','미참여');
INSERT INTO library values('공공도서관','가락몰도서관','평일 : 09:00~18:00, 주말 : 09:00~18:00','매주 월요일 및 법정공휴일','02-3435-0950, 0956',
'http://www.splib.or.kr','서울특별시 송파구 양재대로 932 서울시농수산식품공사 가락몰 업무동 4층','참여');
INSERT INTO library values('작은 도서관','&Lounge작은도서관','평일 : 09:00~18:00, 주말 : 10:00~18:00','둘째·넷째 일요일, 공휴일','070-4239-2722',
'-','서울특별시 동대문구 고산자로36길 3, 경동시장 신관 2층','미참여');
INSERT INTO library values('작은 도서관','7단지 작은도서관','평일 : 13;00~17:30','토,일,공휴일','02-2646-2367',
'-','서울특별시 양천구 목동로 212(목동)','미참여');
INSERT INTO library values('장애인 도서관','IT로 열린도서관','평일 : 09:00~18:00','토,일,공휴일','02-3471-3434',
'http://www.itlo.org/','서울특별시 서초구 방배로 36, 이삭빌딩 301호','미참여');
INSERT INTO library values('장애인 도서관','강서점자도서관','평일 : 09:30~17:30, 주말 : 09:30~13:00','토요일(첫째, 셋째주), 일요일, 법정공휴일','02-2661-2278,2291',
'http://www.ksbl.or.kr/','서울특별시 강서구 공항대로 206 801~803호','미참여');
INSERT INTO library values('전문 도서관','(사)국민문화연구소 자료실','-','-','02-765-7651~2',
'-','서울특별시 종로구 이화동 율곡로13가길 19-5','미참여');
INSERT INTO library values('전문 도서관','KBS도서관','평일 : 09:00~20:00, 주말 : 휴관일','토요일, 일요일, 법정공휴일','02-781-1661',
'-','서울특별시 영등포구 여의공원로 13 한국방송공사 내','미참여');
CREATE TABLE books(
	name varchar2(100),
	writer varchar2(50),
	pdate NUMBER,
	ISBN NUMBER,
	publisher varchar2(100),
	datatype varchar2(30),
	loc varchar2(100),
	libname varchar2(100),
	loan varchar2(100),
	lib varchar2(100)
);
INSERT INTO books VALUES('Java의 정석:최신 Java 8.0 포함.1','남궁성 지음',2016,9788994492032,'도우','도서','005.135-ㄴ48ㅈ3-1','쌍문태움도서관','대출가능',
'도봉구 25개 도서관');
INSERT INTO books VALUES('Java 프로그래밍 면접, 이렇게 준비한다','마크엄,노엘',2015,null,'서울:한빛미디어,2015','일반단행본','005.135 마877ㅈ','개봉도서관','대출가능',
'구로구 36개 도서관');
INSERT INTO books VALUES('Java 프로그래밍 = Java programming','정재현',2017,9788920020346,'Knou Press','단행본','005.135 김97ㅈ2','등빛도서관','대출가능',
'강서구 35개 도서관');
INSERT INTO books VALUES('Java의 정석:기초편','남궁성 지음',2019,9788994492049,'도우','','[솔샘]종합자료실','솔샘문화정보도서관','대출가능',
'강북구 8개 도서관');
INSERT INTO books VALUES('맛있는 MongoDB:Javascript와 함꼐하는 NoSQL DBMS','정승호 지음',2019,9791190014687,'','','금나래종합자료실','금나래도서관','',
'금천구립금나래도서관');
SELECT * FROM Books where name like '%Java%' AND writer LIKE '%남궁성%' and pdate between 1984 and 2021;
SELECT * FROM Books where name like '%Java%' and writer like '%남궁성%' and pdate between 1984 and 2021;
CREATE TABLE smlmember (
   loginmail varchar2(50),
   loginpass varchar2(50),
   name varchar2(50),
   phonenum varchar2(50),
   address varchar2(70),
   mobilememnum varchar2(50)
);
INSERT INTO smlmember VALUES ('himan','112233445566','홍길동','010-2222-3333','서울시 송파구','11112333356666');
INSERT INTO smlmember VALUES ('goodman','qwerty12345','김길동','010-2255-4444','서울시 중구','11112333356667');
INSERT INTO smlmember VALUES ('primera','asdfgh12345','이자바','010-2266-5555','서울시 강동구','11112333356668');
INSERT INTO smlmember VALUES ('emulsion','zxcvbn12345','김워터','010-2277-6666','부천시 원미구',null);
INSERT INTO smlmember VALUES ('sssjdw','qazwsx12345','임토너','010-2288-7777','인천시 계양구','11112333356669');
CREATE TABLE mysearch(
	loginmail varchar2(50),
	searchname varchar2(100),
	library varchar2(50)
);
SELECT * FROM mysearch;
SELECT * FROM emp where ename LIKE '%SM%' AND JOB LIKE '%%';
ALTER TABLE mysearch MODIFY library varchar2(4000);
update mysearch set library = library||',서초도서관' where loginmail = 'himan';
