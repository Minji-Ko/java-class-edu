-- ex03_select.sql

/*
    SQL, Query(질의)
    
    Select 문
    - DML, DQL
    - 관계대수 연산 중 셀렉션 작업을 구현한 명령어
    - 대상 테이블로부터 원하는 행(튜플)을 추출하는 작업 > 데이터 주세요~(￣▽￣~)
    
    [WITH <Sub Query>]
    SELECT column_list
    FROM table_name
    [WHERE search_condition]
    [GROUP BY group_by_expression]
    [HAVING search_condition]
    [ORDER BY order_expression [ASC|DESC]]
    
    SELECT colunm_list
    FROM table_name
    
    SELECT 컬럼리스트
    FROM 테이블;
    
    SELECT를 구성하는 절의 실행 순서(************)
    1. FROM 테이블 > 데이터를 가져올 테이블을 지정한다.
    2. SELECT 컬럼리스트 > 가져올 특정 컬럼을 지정한다.
    

*/

-- SELECT : 셀렉션
-- 컬럼리스트 : 프로젝션
select first_name
from employees;


-- 명령어
-- 1. SQL 명령어 > 기억o
-- 2. SQL Plus 명령어 > 기억x > ex)desc
desc tblCountry; -- 콘솔(sqlplus) or SQL Developer(sqlplus 내장)에서만 사용가능

-- 한 개
select name from tblCountry;  
select capital from tblCountry;
select population from tblCountry;
-- 여러 개
select name, capital from tblcountry;
-- 전부 > 어떤방식으로 쓸지는 코드 컨벤션 > 가독성문제
select name, capital, population, continent, area from tblCountry; 
select * from tblCountry; 

-- 중복도 상관없음
select name, name from tblCountry; 
select name, length(name) from tblCountry; 

-- 컬럼 리스트의 순서는 원본 테이블의 컬럼 순서와 무관함 
-- > 최종사용자에게 보여지는 순서가 아님 > java등으로 수정하여 보여줌
select name, capital from tblcountry; 
select capital, name from tblcountry; 


-- 여러가지 시스템 정보 확인 > 관리자 계정으로만 가능 > 
-- > 최후의 수단 > 보통은 Document를 확인
-- 1. 사용자 정보
-- ORA-00942: table or view does not exist
select * from dba_users; 

-- 2. 특정 사용자가 소유한 테이블 정보
select * from tabs;
select * from dba_tables where owner = 'HR';

-- 3. 특정 테이블의 컬럼 정보 > 스키마
select * from dba_tab_columns where owner = 'HR' and table_name = 'TBLCOUNTRY'; 










