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

select name from tblCountry;  -- 정렬은 어떻게 하려나??
select capital from tblCountry;
select population from tblCountry;

select name, capital from tblcountry;

















