-- ex17_group_by.sql

/*
    GROUP BY
    - GROUP BY 컬럼명
    - GROUP BY 컬럼명, 컬럼명, 컬럼명
    - 레코드들을 특정 컬럼값(1~N)으로 그룹을 나누는 역할
    - 그룹을 왜 나누는지? > 각각의 나눠진 그룹을 대상 > 집계 함수를 적용하기 위해서(*********)
    
    
    SELECT 컬럼리스트 --4     
    FROM 테이블       --1
    WHERE 조건        --2
    GROUP BY 기준     --3
    ORDER BY 기준     --5
    
    
    
*/

-- tblInsa. 부서별 평균 급여?
select * from tblInsa;

select round(avg(basicpay)) from tblInsa; --155만원. 60명

select distinct buseo from tblInsa; --7개 

select round(avg(basicpay)) from tblInsa where buseo = '총무부' ; --171
select round(avg(basicpay)) from tblInsa where buseo = '개발부' ; --138
select round(avg(basicpay)) from tblInsa where buseo = '영업부' ; --160
select round(avg(basicpay)) from tblInsa where buseo = '기획부' ; --185
select round(avg(basicpay)) from tblInsa where buseo = '인사부' ; --153
select round(avg(basicpay)) from tblInsa where buseo = '자재부' ; --141
select round(avg(basicpay)) from tblInsa where buseo = '홍보부' ; --145

-- group by를 사용하면 컬럼리스트
-- 1. 집계 함수
-- 2. group by 기준 > 칼럼
select 
    round(avg(basicpay)), --집합값(여러명의 값을 가지고 결과)
    buseo --집합값(여러명의 값을 가지고 결과)
    --name --개별값(개인의 데이터)
from tblInsa
    group by buseo;
    
    
    
select 
    count(*) as "부서별 인원수",
    sum(basicpay) as "부서별 지급액",
    round(avg(basicpay)) as "부서별 평균급여",
    max(ibsadate) as "부서별 막내 입사일",
    min(ibsadate) as "부서별 최고참 입사일"
from tblInsa
    group by buseo;
    
        
select 
    count(*) as "전체 인원수",
    sum(basicpay) as "전체 지급액",
    round(avg(basicpay)) as "전체 평균급여",
    max(ibsadate) as "전체 막내 입사일",
    min(ibsadate) as "전체 최고참 입사일"
from tblInsa
    group by buseo;


-- 남자? 여자?
select * from tblComedian;
  
--(횡) 8 2  
select 
    count(decode(gender, 'm', 1)) as "남자수",
    count(decode(gender, 'f', 1)) as "여자수"
from tblComedian;

--(종)
--m 8
--f 2
select
    gender,
    count(*) 
from tblComedian
    group by gender;
    
--(횡) : (종) = 2 : 8 > 어떤 프로그램이냐에 따라 달라지나, 둘다 알고 있어야 함    
    

select 
    city,
    count(*) as cnt
from tblInsa
    group by city
        order by cnt desc;
    
    
select 
    continent,
    count(*),
    sum(population)
from tblCountry
    group by continent;
    

select 
    gender,
    max(height),
    min(height),
    max(weight),
    min(weight)
from tblComedian
    group by gender;

select 
    buseo,
    jikwi,
    city,
    count(*)
from tblInsa
    group by buseo, jikwi, city
        order by buseo asc, jikwi asc;
        
        
-- 급여별 그룹
-- 100만원 이하
-- 100만원 ~ 200만원
-- 200만원 

select  
    basicpay, 
    count(*)
from tblInsa
    group by basicpay;
    
select
    (floor(basicpay / 1000000) +1) * 100 || '만원 이하' ,
    count(*)
from tblInsa
    group by floor(basicpay / 1000000)
        order by floor(basicpay / 1000000) asc;
        
        
-- tblTodo. 한일의 개수? 안한 일의 개수?
select
    count(case
        when completedate is not null then 'o'
    end),
    count(case
        when completedate is null then 'o'
    end)
from tblTodo;


select
    count(*)
from tblTodo
    group by case
                when completedate is not null then 'o'
                else 'x' 
            end;


-- 지역별 인원수?
select distinct city from tblInsa;

-- 모든 지역을 수동으로 작성!!!! x 11번 작성;;;;
-- 신입 사원 입사 > "강릉" 거주
-- 새로운 데이터/ 수정된 데이터에 아주 취약한 방식!!!!! > 정적인 데이터에는 무난~
select 
    count(decode(city, '서울', 1)) as "서울",
    count(decode(city, '인천', 1)) as "인천",
    count(decode(city, '경기', 1)) as "경기"
from tblInsa;

-- 새로운 데이터 / 수정된 데이터에 아주 강함~ > 정적/동적인 데이터 모두에 무난~    
select 
    city,
    count(*)
from tblInsa
    group by city;
    

-- pivot(새로로 나온 데이터 -> 가로로)    
    
    
/*
    HAVING
    - 반드시 GROUP BY와 같이 사용
    - GROUP BY의 조건절 역할
    - ?????
    
    SELECT 컬럼리스트 --5     
    FROM 테이블       --1
    WHERE 조건        --2
    GROUP BY 기준     --3
    HAVING 조건       --4
    ORDER BY 기준     --6
        
*/

select count(*) from tblInsa where basicpay >= 1500000;

-- 부서별 평균 급여 150만원 넘는 결과
select                          --4. 평균 급여 < 사전조건(150만원 이상인 사람들)
    buseo,
    round(avg(basicpay))
from tblInsa                    --1. 60명의 데이터를 가져온다.
    where basicpay >= 1500000   --2. 60명을 대상으로 조건 검사
        group by buseo;         --3. 2번을 통과한 사람들을 대상으로 그룹형성

select                          --4 
    buseo,
    round(avg(basicpay))
from tblInsa                    --1.  60명의 데이터를 가져온다.
    group by buseo              --2. 60명을 대상으로그룹 형성
    having avg(basicpay) >= 1500000; -- 그룹을 대상으로 조건


select                          --4 
    buseo,
    round(avg(basicpay))
from tblInsa                    --1.  60명의 데이터를 가져온다.
    where basicpay >= 1500000
    group by buseo              --2. 60명을 대상으로그룹 형성
    having avg(basicpay) >= 2200000 -- 그룹을 대상으로 조건
    order by 2; -- 숫자붙이는게 좋은 버릇은 아님
    

-- 서울 직원 > 남/녀 그룹> 그룹별 평균 급여 155만원 > 각 그룹의 인원수?
-- 읽는 연습 > 순서대로 쓰는 연습도 자연스럽게 됨!
select
    substr(ssn, 8, 1),
    count(*)
from tblInsa
    where city = '서울'
    group by substr(ssn, 8, 1)
    having avg(basicpay) > 1550000;
    

-- tblCountry
-- 대륙별로 최대인구수, 최소인구수, 평균인구수를 가져오시오.
select 
    continent,
    max(population),
    min(population),
    avg(population)
from tblCountry
    group by continent;


-- employees
-- 직업별(job_id) 직원수를 가져오시오.
select
    job_id,
    count(*)
from employees
    group by job_id;



-- tblInsa
-- 부서별 부서인원수, 최고급여, 최저급여, 평균 급여
select
    buseo,
    count(*),
    max(basicpay),
    min(basicpay),
    avg(basicpay)
from tblInsa
    group by buseo;
    
    
-- tblInsa
-- 부서별 직급의 인원수를 가져오시오.
-- [부서명] [총인원] [부장] [과장] [대리] [사원]
-- 기획부      6        1      1      2      2
-- 영업부     13        1      2      4      6
select 
    buseo as 부서명,
    count(*) as 총인원,
    count(decode(jikwi, '부장', 1)) as 부장,
    count(decode(jikwi, '과장', 1)) as 과장,
    count(decode(jikwi, '대리', 1)) as 대리,
    count(decode(jikwi, '사원', 1)) as 사원
from tblInsa
    group by buseo
    order by buseo;
    
    
/*
    group by + having + rollup + cube
    
    rollup()
    - group by의 결과에서 집계 결과를 좀 더 자세하게 반환
    - 그룹별로 중간 통계를 내고자 할 때 사용
    
*/

select
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup(buseo);
    

select
    buseo,
    jikwi,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup (buseo, jikwi);
    
select
    jikwi,
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by rollup (jikwi, buseo);
    
    
    
/*
    cube()
    - group by의 결과에서 집계 결과를 더 자세하게 반환
    - 그룹별 중간 통계를 내고 싶을 때 사용
    

*/


select
    jikwi,
    buseo,
    count(*),
    round(avg(basicpay))
from tblInsa
    group by cube(jikwi, buseo);

















