-- ex04_operator.sql

/*
    연산자, Operator
    
    1. 산술 연산자
        - +, -, *, /
        - % > 없음 > 함수로 제공(mod())
        
    2. 문자열 연산자
        - +(X) > ||(O)
    
    3. 비교연산자
        - =(==), <>(!=>)    
        - 논리값 반환 > 명시적으로 표현 가능한 자료형이 아니다(boolean 존재하지 않음) > 조건이 필요한 상황에서만 내부적으로 사용
        - 컬럼 리스트에서 사용 불가
        - 조건절에서 사용 가능
        
    4. 논리연산자
        - and(&&), or(||), not(!)
        - 컬럼 리스트에서 사용 불가
        - 조건절에서 사용 가능 
        
    5. 대입연산자
        - = 
        - 컬럼 = 값
        - UPDATE문에서 사용
        
    6. 3항 연산자
        - 없음
        - 제어문 없음
    
    7. 증감연산자
        - 없음
        
    8. SQL 연산자
        - 자바: instanceof, typeof 등
        - in, between, like, is 등 > 연산자 = 구 = 절
*/

-- ORA-01722: invalid number
select name + capital from tblCountry;
select name || capital from tblCountry;

-- ORA-00923: FROM keyword not found where expected
-- select name <> capital from tblCountry;
-- select population > area from tblCountry;



select * from tblMan;
select * from tblWoman;


-- 컬럼의 별칭(Alias)만들기
-- 컬럼명 as 별칭
select name as 남자이름, couple as 여자이름 from tblMan;

desc tblMan;

select name, weight, weight + 5 as maxWeight from tblMan;

-- 이름이 똑같아서 java등으로 가져가면 문제가 생김! developer가 보여줄때만 임의로 다르게 표현한 것
-- 반드시 as를 붙여야함
select name, name as name2 from tblMan; 


select name as "남자 이름" from tblMan; -- 식별자에 공백을 넣을 때 "" 사용
select name as "10+20+30" from tblMan;
select name as "select" from tblMan;


-- 테이블 별칭 만들기
select 
    name,
    capital,
    population
from tblCountry;


select 
    tblCountry.name, 
    tblCountry.capital,
    tblCountry.population
from hr.tblCountry; -- 테이블 앞의 소유주가 생략되어있음


select 
    tblCountry.name, 
    tblCountry.capital,
    tblCountry.population
from hr.tblCountry; 


-- 다른 DB는 as c로 하지만, 오라클은 바로 c 
-- 테이블 별칭은 테이블 이름을 반복해서 사용할 때 코드량을 줄이기 위함 > 보통 한글자
select 
    --tblCountry.name,
    c.name, 
    c.capital,
    c.population
from tblCountry.c; 
-- 별칭이 실행순서가 from부터임을 보여줌 
-- 사실 Alias는 별칭이 아님 > 기존 테이블 이름과 함께 사용불가



