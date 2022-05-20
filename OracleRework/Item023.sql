-- [Summary] 계층형 쿼리 사용하기 (2022-05-18 23:40:07)

-- 자기 참조를 하는, 상하 수직 구조의, 테이블에 사용
-- ex) 조직도, 카테고리



-- 계층형 쿼리                      > 오라클 전용
-- start with : 최상위 노드 지정 
-- connect by : 자식 레코드와 부모 레코드를 연결하는 조건


-- 계층형 쿼리 의사컬럼
-- prior : 자신과 연관된 부모 레코드를 참조
-- level : depth(세대)


select 
    seq,
    lpad(' ', (level-1) * 5) || name as "부품명",
    prior name as "부모부품명"
from tblComputer
    start with pseq is null
        connect by prior seq = pseq; 







-- 테이블 데이터
create table tblComputer(
    seq number primary key,
    name varchar2(30) not null,
    qty number not null,
    pseq number null
);

insert into tblComputer values (1, '컴퓨터', 1, null);

insert into tblComputer values (2, '본체', 1, 1);
insert into tblComputer values (3, '메인보드', 1, 2);
insert into tblComputer values (4, '그래픽카드', 1, 2);
insert into tblComputer values (5, '랜카드', 1, 2);
insert into tblComputer values (6, 'CPU', 1, 2);
insert into tblComputer values (7, '메모리', 2, 2);

insert into tblComputer values (8, '모니터', 1, 1);
insert into tblComputer values (9, '보호필름', 1, 8);
insert into tblComputer values (10, '모니터암', 1, 8);

insert into tblComputer values (11, '프린터', 1, 1);
insert into tblComputer values (12, 'A4용지', 100, 11);