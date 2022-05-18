-- ex32_synonym.sql

/*

    동의어, Synonym
    - 데이터베이스 객체의 별칭(Alias와 차이 있음)
    - 다른 사용자 소유의 객체를 접근 > 별칭
    
    - 테이블 등 자원은 계정 소속이다.
    
*/


-- hr
show user;

select * from tabs where table_name = 'TBLINSA';

-- system
-- 다른 계정의 자원을 접근할 권한이 있다.
show user;

select * from tblInsa;      --X
select * from hr.tblInsa;   --O

-- hr
select fnSum(10, 20) from dual; 
select hr.fnSum(10, 20) from dual; 


-- 일반 다른 계정 > scott
create user scott identified by java1234;

grant connect, resource to scott;

-- 관리자 >scott에게 hr.tblInsa에 접근할 수 있는 권한 부여
grant select, delete on hr.tblInsa to scott;

-- scott
select * from tabs;

select * from hr.tblInsa; -- 다른 계정의 자원은 접근 불가능

update hr.tblInsa set basicpay = 30000000 where num = '홍길동'; --일반키 > 비인덱스
update hr.tblInsa set basicpay = 30000000 where num = 1001; --PK > 인덱스

delete from hr.tblInsa where num = 1010;  --계정을 바꾸면 transaction이 새로시작???


--관리자 > scott에게 접근권한 회수
revoke delete on hr.tblInsa from scott;



-- 개발용 > dev
-- 용도별 계정 > xxx


-- 영구적으로 hr의 tblInsa를 scott이 접근해야 하는 경우 > Synonym
select * from hr.tblInsa;
select i.name from hr.tblInsa i;


--관리자
grant create synonym to scott;

--create synonym 별칭 for 자원;
create synonym insa for hr.tblInsa;

select * from hr.tblInsa;
select * from insa; --소유주 명시x

select * from tabs;

-- priavte synonym 
-- public synonym > 모든 계정이 synonym사용 가능 > 잘 안씀


-- dual, tabs > public synonym
select sysdate from dual;
select * from tabs;