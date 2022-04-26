-- ex19_join.sql

/*
    관계형 데이터베이스 시스템이 지양하는 것들
    1. 테이블에 기본키가 없는 상태 > 데이터 조작 곤란
    2. null이 많은 상태의 테이블 > 공간 낭비 > (추후 학습)
    3. 데이터가 중복되는 상태 > 공간 낭비 + 데이터 관리 곤란
    4. 하나의 속성값이 원자값이 아닌 상태 > 더 이상 쪼개지지 않는 값을 넣어야 한다.
    
    => 테이블 다시 수정해야 고쳐지는 것들
*/

create table tblTest (
    name varchar2(30) not null,
    age number(3) not null,
    nick varchar2(30) not null,
    id varchar2(30) not null
);

-- 1.
-- 홍길동,20,바보,hong
-- 아무개,25,천재,any
-- 테스트,22,멍멍이,test
-- 홍길동,20,바보,hong   > 물리적 문제? 없음

-- 홍길동 별명 수정
    update tblTest set nick = '고양이' where 조건?
-- 홍길동 탈퇴
    delete from tblTest where 조건?
    
    

create table tblTest(
    name varchar2(30) primary key,
    age number(3) not null,
    hobby1 varchar2(300) null,
    hobby2 varchar2(300) null,
    ..
    hobby8 varchar2(300) null,
);

-- 2.
--홍길동,20,독서,null,null,null,null,null,null,null
--아무개,25,러닝,헬스,게임,null,null,null,null,null
--테스트,22,러닝,헬스,게임,독서,낮잠,맛집,여행,코딩
--홍나비,23,독서,null,null,null,null,null,null,null


-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지, 담당프로젝트)
create table tblStaff(
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null, -- 거주지
    project varchar2(300) null      -- 담당프로젝트
);

insert into tblStaff(seq, name, salary, address, project)
    values (1, '홍길동', 300, '서울특별시', '홍콩 수출');
insert into tblStaff(seq, name, salary, address, project)
    values (2, '아무개', 250, '인천광역시', 'TV 광고');
insert into tblStaff(seq, name, salary, address, project)
    values (3, '하하하', 350, '부산광역시', '매출 분석');


-- '홍길동'에게 담당 프로젝트가 1건 추가 > '고객 관리'
insert into tblStaff(seq, name, salary, address, project)
    values (4, '홍길동', 300, '서울특별시', '고객 관리');


-- '호호호' 직원 추가 + '게시판 관리, 회원 응대'
insert into tblStaff(seq, name, salary, address, project)
    values (5, '호호호', 250, '서울특별시', '게시판 관리,회원 응대');
        
    
-- 'TV 광고' 담당자 호출
select * from tblStaff where project = 'TV 광고';

-- 'TV 광고' > 'SNS 광고'
update tblStaff set project = 'SNS 광고' where project = 'TV 광고'; -- unique(x) > 상황에 따라 오답일수도 있음 
    
-- '회원 응대' 담당자 호출
-- 문제점!! > 데이터가 원자값이 아니다;;;
select * from tblStaff where project = '회원 응대';
select * from tblStaff where instr(project, '회원 응대') > 0;  --'고객 회원 응대 처리'등도 같이 검색됨

-- '회원 응대' > '고객 불만 대응'
update tblStaff set project = '고객 불만 대응' where instr(project, '회원 응대') > 0;

-- 쿼리를 짤게 아니라 테이블을 다시 생성해야한다!!!!!!!!!*********************************


-- '홍길동' > 연봉 인상 > 350만원
update tblStaff set salary = 350 where seq = 1;

-- 급여 지금 > 담당자 > '홍길동' 급여 확인
-- 문제점!!! > 같은 데이터를 2번 이상 저장 > 테이블 설계문제 
select * from tblStaff where name = '홍길동';


select * from tblStaff;   




drop table tblStaff;

-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지)
create table tblStaff(
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null -- 거주지
); --부모 테이블

-- 프로젝트 정보
-- 프로젝트(프로젝트명)
create table tblProject (
    seq number primary key,             -- 프로젝트 번호(PK)
    project varchar2(30) not null,      -- 담당프로젝트
--  staff_seq number not null           -- 직원번호
    staff_seq number not null references tblStaff(seq)
); --자식 테이블


insert into tblStaff(seq, name, salary, address) values (1, '홍길동', 300, '서울특별시');
insert into tblStaff(seq, name, salary, address) values (2, '아무개', 250, '인천광역시');,
insert into tblStaff(seq, name, salary, address) values (3, '하하하', 350, '부산광역시');

insert into tblProject(seq, project, staff_seq) values(1, '홍콩 수출', 1);
insert into tblProject(seq, project, staff_seq) values(2, 'TV 광고', 2);
insert into tblProject(seq, project, staff_seq) values(3, '매출 분석', 3);
insert into tblProject(seq, project, staff_seq) values(4, '노조 협상', 1);
insert into tblProject(seq, project, staff_seq) values(5, '대리점 분양', 2);

-- 1. 원자값 보장
-- 2. 데이터 중복 x
select * from tblStaff;
select * from tblProject;


-- A. 신입 사원 입사 > 신규 프로젝트 담당
-- A.1 신입 사원 추가(o)
insert into tblStaff (seq, name, salary, address) values (4, '호호호', 250, '성남시');


-- A.2 신규 프로젝트 추가(o)
insert into tblProject (seq, project, staff_seq) values (6, '자제 매입', 4);

-- A.3 신규 프로젝트 추가 -> 문제 발생!!! > 유령 직원?!?!
-- ORA-02291: integrity constraint (HR.SYS_C007148) violated - parent key not found
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5); -- *** 논리 오류: 존재하지 않는 직원이 프로젝트를 담당하고 있음

-- 사장님: '고객 유치' 담당자!!
select * from tblStaff where seq = (select staff_seq from tblProject where project = '고객 유치'); 



-- B. '홍길동' 퇴사
-- B.1 '홍길동' 삭제 -> 문제발생!
-- ORA-02292: integrity constraint (HR.SYS_C007148) violated - child record found
delete from tblStaff where seq = 1;
select * from tblStaff where seq = (select staff_seq from tblProject where project = 'TV 광고');
select * from tblStaff where seq = (select staff_seq from tblProject where project = '홍콩 수출'); --??!

select * from tblProject where staff_seq = 1; -- 존재하지 않는 직원이 프로젝트를 담당하고 있음



update tblProject 
    set staff_seq = (select seq from tblStaff where name = '하하하')
    where staff_seq = (select seq from tblStaff where name = '홍길동');



-- B.2 '아무개' 퇴사 > 인수 인계(위임)
update tblProject 
    set staff_seq = (select seq from tblStaff where name = '하하하')
    where staff_seq = (select seq from tblStaff where name = '아무개');
-- B.3 '아무개' 퇴사 > 삭제
delete from tblStaff where seq = 2;

select * from tblStaff;
select * from tblProject;




-- 고객 테이블
create table tblCustomer(
    seq number primary key,         --고객번호(PK)
    name varchar2(30) not null,     --고객명
    tel varchar2(15) not null,      --연락처
    address varchar2(100) not null  --주소
);

-- 판매 내역 테이블
create table tblSales(
    seq number primary key,                         --판매번호(PK)
    item varchar2(50) not null,                     --제품명
    qty number not null,                            --구매수량
    regdate date default sysdate not null,          --판매날짜
    cseq number not null references tblCustomer(seq)--판매한 고객번호(FK)        
);


select * from tblCustomer;
select * from tblSales;

--[비디오 대여점]
-- 장르 테이블
create table tblGenre (
    seq number primary key,         --장르 번호(PK)
    name varchar2(30) not null,     --장르명   
    price number not null,          --대여가격
    period number not null          --대여기간(일)
);

-- 비디오 테이블
create table tblVideo(
    seq number primary key,                         --비디오 번호(PK)
    name varchar2(100) not null,                    --비디오 제목
    qty number not null,                            --보유 수량
    company varchar2(50) null,                      --제작
    director varchar2(50) null,                     --감독
    major varchar2(50) null,                        --주연배우
    genre number not null references tblGenre(seq)  --장르번호(FK)
);


-- 고객 테이블 
create table tblMember (
    seq number primary key,         --회원번호
    name varchar2(30) not null,     --고객명
    grade number(1) not null,       --고객등급(1,2,3)
    byear number(4) not null,       --생년
    tel varchar2(15) not null,      --연락처
    address varchar2(300) null,     --주소
    money number not null           --예치금
);


-- 대여 테이블
create table tblRent(
    seq number primary key,                             --대여번호(PK)
    member number not null references tblMember(seq),   --회원번호(FK)
    video number not null references tblVideo(seq),     --비디오번호(FK)
    rentdate date default sysdate not null,             --대여시각
    retdate date null,                                  --반납시각
    remark varchar2(500) null                           --비고
);

-- 장르 <- 비디오 <- 대여 -> 고객

select * from tblGenre;
select * from tblVideo;
select * from tblMember;
select * from tblRent;

/*
    조인, Join
    - (서로 관계를 맺은) 2개(1개) 이상의 테이블을 1개의 결과셋을 만드는 기술
    
    조인의 종류
    1. 단순 조인, CROSS JOIN, 카치션곱(데카르트곱)
    2. 내부 조인, INNER JOIN *****
    3. 외부 조인, OUTER JOIN *****
    4. 셀프 조인, SELF JOIN
    5. 전체 외부 조인, FULL OUTER JOIN
    
*/

/* 
    1. 단순 조인, CROSS JOIN, 카치션곱(데카르트곱)
        - 결과셋(A CROSS JOIN B) 레코드 개수 = A 테이블 레코드 개수 X B 테이블 레코드 개수 
        - 쓸모없다. > 가치있는 행과 가치없는 행이 뒤섞여 있어서..
*/

select * from tblCustomer;  --3명
select * from tblSales; --9건


-- 결과셋의 행 개수(카디날리티) > 27개
-- 결과셋의 컬럼 개수(차수) > 9개
select * from (tblCustomer cross join tblSales); --ANSI-SQL(추천)
select * from tblCustomer, tblSales; -- Oracle



/*
    2. 내부 조인, INNER JOIN *****
        - 단순 조인에서 유효한 레코드만 추출한 조인
        
    - ANSI-SQL
        SELECT 컬럼리스트 FROM 테이블A INNER JOIN 테이블B ON 테이블A.PK=테이블B.PK;
                                                    ** ON은 사실상 WHERE의 의미                                            
        SELECT 
            컬럼리스트 
        FROM 테이블A 
            INNER JOIN 테이블B 
                ON 테이블A.PK=테이블B.PK; --조인 조건                                           
                                                    
    - Oracle                                                
        SELECT 컬럼리스트 FROM 테이블A, 테이블B WHERE 테이블A.PK=테이블B.PK;
*/

--직원 테이블, 프로젝트 테이블

-- 직원명단을 가져오시오.(+담당하는 프로젝트명을 포함해서)
select * from tblStaff inner join tblProject
    on tblStaff.seq = tblProject.staff_seq;

select * from tblStaff cross join tblProject;


-- 고객 정보와 판매내역을 가져오기 > 고객명, 연락처, 어떤 물건, 몇개
-- 대부분의 상황에서 > 내부 조인의 결과는 자식 테이블 레코드와 동일한 레코드가 나온다. > 스스로 생각
-- 대부분의 상황에서 > 내부 조인의 결과는 부모 테이블 레코드가 반복되는 현상이 생긴다. 
select 
    name, 
    tel, 
    item, 
    qty
from tblCustomer 
    inner join tblSales 
        on tblCustomer.seq = tblSales.cseq; 
        -- on 부모테이블.PK = 자식테이블.FK



select * from tblGenre; --Parent Table
select * from tblVideo; --Child Table

-- 비디오 제목과 대여 가격을 가져오시오.
-- ORA-00918: column ambiguously defined
select  
    tblGenre.name, tblVideo.name, price
from tblGenre               --부모테이블  > 경험상 순서를 정해놓는 습관은 알아보기가 편함
    inner join tblVideo     --자식테이블
        on tblGenre.seq = tblVideo.genre;


select  
    tblVideo.name, 
    tblGenre.price          -- 하나에 테이블명을 붙이면 나머지도 다 붙임! > 그런데 피곤함
from tblGenre               
    inner join tblVideo     
        on tblGenre.seq = tblVideo.genre;



select                      -- 3
    v.name, 
    g.price                   
from tblGenre g       
    inner join tblVideo v   -- 1
        on g.seq = v.genre; -- 2



select * from tblMan;
select * from tblWoman;

-- 커플 테이블  
select 
    m.name as "남자",
    w.name as "여자"
from tblMan m 
    inner join tblWoman w
        on m.couple = w.name;


-- inner join x sub query => 겹치는 부분이 아주 쪼금! 근데 자주쓰는 부분이 겹쳐서 많게 느껴짐
-- 고객명 + 판매물품명 가져오시오.
-- 1. 조인 > 고비용 + 속도 느림
select * from tblCustomer;
select * from tblSales;

select 
    c.name as "고객명", 
    s.item as "판매물품명"
from tblCustomer c inner join tblSales s
    on c.seq = s.cseq;

-- 2. 서브 쿼리 > 저비용 + 속도 빠름 > 비용문제때문에 둘다 가능하면 2번을 권장하는 회사도 있음.
select 
    (select name from tblCustomer where seq = tblSales.cseq) as "고객명",
    item as "판매물품명"
from tblSales; --반드시 자식테이블!


select * from tblGenre; -- 부모
select * from tblVideo; -- 자식  부모
select * from tblRent;  --       자식

-- 3개의 테이블을 조인
select 
    v.name,
    r.rentdate,
    g.price
from tblGenre g                         -- g x v
    inner join tblVideo v               -- g x v
        on g.seq = v.genre              -- g x v
            inner join tblRent r        --     v x r
               on v.seq = r.video;      --     v x r
                                        -- g x v x r
select * from tblRent;

select  --얘는 되고
    v.name,
    r.rentdate,
    g.price
from tblGenre g                         -- g x v
    inner join tblVideo v               -- g x v
       inner join tblRent r        --     v x r 
            on v.seq = r.video      --     v x r
               on g.seq = v.genre;              -- g x v
                                        -- g x v x r

select  --얘는 안돼???? 실행순서???
    v.name,
    r.rentdate,
    g.price
from tblGenre g                         -- g x v
    inner join tblVideo v               -- g x v
       inner join tblRent r        --     v x r 
             on g.seq = v.genre              -- g x v
                on v.seq = r.video;      --     v x r
                                        -- g x v x r                                    


select 
    v.name,
    r.rentdate,
    g.price
from tblGenre g, tblVideo v, tblRent r
    where g.seq = v.genre 
        and v.seq = r.video;



-- 4개의 테이블을 조인 > 결과셋은 가장 하위 자식의 행의 개수 > 여기서는 데이터가 이상함.
select 
--  * -- 조인의 결과에는 *를 잘 사용하지 않는다!!
    c.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "대여일",
    g.price as "가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblCustomer c
                        on c.seq = r.member;
                        
select * from tblRent;
select * from tblCustomer;






-- 남남 테이블 조인
-- 100% 쓸모없는 결과
select * from tblStaff; --직원
select * from tblSales; --판매

select *
from tblStaff f
    inner join tblSales e
        on f.seq = e.cseq; --아무 상관없는 관계
        
    
-- HR > 7개
select * from employees;    -- 직원
select * from jobs;         -- 직원의 직업
select * from departments;  -- 직원의 부서
select * from locations;    -- 부서가 위치한 지역
select * from countries;    -- 지역이 속한 국가
select * from regions;      -- 국가가 속한 대륙
select * from job_history;  -- 직원들의 이직이력

select 
    e.first_name || ' ' || e.last_name as "직원명", --직원명
    d.department_name as "부서명",
    l.city          as "도시명",
    c.country_name  as "국가명",
    r.region_name   as "대륙명",
    j.job_title     as "직업"
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id
                    inner join countries c
                        on c.country_id = l.country_id
                            inner join regions r
                                on r.region_id = c.region_id
                                    inner join jobs j
                                        on j.job_id = e.job_id;
               



/*
    3. 외부조인, OUTER JOIN *****
    - 내부 조인의 반대(X)
    - 내부 조인의 결과 + 결과 셋에 포함되지 못한부모 테이블의 나머지 레코드를 합하는 행동
    
    SELECT 컬럼리스트 
    FROM 테이블A
        INNER JOIN 테이블B
            ON 테이블A.컬럼 = 테이블B.컬럼;

    SELECT 컬럼리스트 
    FROM 테이블A
        (LEFT|LIGHT) OUTER JOIN 테이블B
            ON 테이블A.컬럼 = 테이블B.컬럼;


*/

select * from tblCustomer; --3명
select * from tblSales;    --9건

insert into tblCustomer values (4, '호호호', '010-1234-5687', '서울시');


-- tblSales 9개 > 9개
-- 문장: 절의 실행 순서대로 읽는 연습!!!**********  + 부드럽게 표현
-- 물건을 한번이라도 구매한 이력이 있는 고객의 정보와 그 고객이 사간 판매내역을 같이 가져오시오.(***********************)

-- 내부 조인 > 두 테이블에 동시에 존재하는 정보만 가져온다(**********)
--           > 회원정보 o + 그 회원 구매한 정보 o -> 가져옴 
select *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;







