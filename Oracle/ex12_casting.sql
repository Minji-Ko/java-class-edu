-- ex12_casting.sql

/*

    null 함수 > null value
    1. nvl(값1, 값2)
    2. nvl2(값1, 값2, 값3)
*/

-- 피연산자가 null이면 연산결과가 null을 반환
-- 자바는 null이면 에러가 남
select 
    name,
    population,
    case
        when population is not null then population
        when population is null then 0
    end,
    nvl(population, 0)
from tblCountry;


select 
    name,
    population,
    case
        when population is not null then '확인'
        when population is null then '미확인'
    end,
    nvl2(population, '확인', '미확인')
from tblCountry;



/*
    형변환 함수
    
    1. to_char()    : 숫자 > 문자
    2. to_char()    : 날짜 > 문자 ***** 
    3. to_number()  : 문자 > 숫자
    4. to_date()    : 문자 > 날짜 *****

    1. to_char()
    - char to_char(컬럼, 형식문자열)
    
    형식문자열 구성요소
    a. 9: 숫자 1개를 문자 1개로 바꾸는 역할. 빈자리는 스페이스로 치환 > %5d
    b. 0: 숫자 1개를 문자 1개로 바꾸는 역할. 빈자리는 0으로 치환      > %05d
    c. $: 통화기호 표현
    d. L: 통화기호 표현(로컬) > 설정에 따라 바뀜
    e. .
    f. ,
    
    a~d 중 b를 제외하고는 포지션이 애매함
    
*/

-- *** SQL은 아주 유연한 언어 > 자료형 > 암시적 형변환 잦음
select 
    weight,         --우측정렬(숫자)
    to_char(weight), --좌측정렬(문자)
    length(weight)   --length(문자타입) > length(to_char(weight)) > 자동형변환 발생
from tblComedian;


-- Java > String Type
-- SQL > Week Type
select
    10,
    length(10), -- 10 > '10'
    length('10'),
    2 * 2,
    '2' * 2 -- '2' > 2
from dual;



select 
    weight,    
    '@' || to_char(weight) || '@',
    '@' || to_char(weight, '99999') || '@',  --@    65@
    '@' || to_char(weight, '00000') || '@',  --@ 00065@
    '@' || to_char(-weight, '00000') || '@'  --@-00065@
from tblComedian;


select 
    100,
    --to_char(100, '$99'),
    to_char(100, '$999'),
    --to_char(100, '999달러')
    to_char(100, '999') || '달러',
    to_char(100, 'L999'),
    to_char(100, '999L')
from dual;


select 
    1234567.89,
    to_char(1234567.89, '9999999.99'),
    to_char(1234567.89, '9999999.999'),
    to_char(1234567.89, '9999999.9'),
    to_char(1234567.89, '9999999'),
    to_char(1234567.89, '9,999,999')
from dual;




/*
    2. to_char() ♡♥
    - 날짜 > 문자 ***** 
    - char to_char(컬럼, 형식문자열)
    
    형식문자열 구성요소
    a. yyyy
    b. yy
    c. month
    d. mon
    e. mm
    f. day
    g. dy
    h. ddd
    i. dd
    j. d
    k. hh
    l. hh24
    m. mi
    n. ss
    o. am(pm)
*/

select sysdate from dual;
select to_char(sysdate) from dual;
select to_char(sysdate, 'yyyy') from dual;  --2022  년(4자리) *****
select to_char(sysdate, 'yy') from dual;    --22    년(2자리)

select to_char(sysdate, 'month') from dual; --4월   월(풀네임)
select to_char(sysdate, 'mon') from dual;   --4월   월(약어) 
select to_char(sysdate, 'mm') from dual;    --04    월(2자리) *****

select to_char(sysdate, 'day') from dual;   --금요일 요일(풀네임)
select to_char(sysdate, 'dy') from dual;    --금    요일(약어)

select to_char(sysdate, 'ddd') from dual;   --112   일(올해의 며칠)
select to_char(sysdate, 'dd') from dual;    --22    일(이번달의 며칠) *****
select to_char(sysdate, 'd') from dual;     --6     일(이번주의 며칠 == 요일)

select to_char(sysdate, 'hh') from dual;    --02    시(12시간)
select to_char(sysdate, 'hh24') from dual;  --14    시(24시간) *****
select to_char(sysdate, 'mi') from dual;    --18    분 *****
select to_char(sysdate, 'ss') from dual;    --29    초 *****
select to_char(sysdate, 'am') from dual;    --오전/오후
select to_char(sysdate, 'pm') from dual;    --오전/오후


select
    sysdate,
    to_char(sysdate, 'yyyy-mm-dd'),
    to_char(sysdate, 'hh24:mi:ss'),
    to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
    to_char(sysdate, 'am hh:mi:ss')
from dual;

select
    name,
    to_char(ibsadate, 'yyyy-mm-dd') as hire_date,
    to_char(ibsadate, 'day') as day, -- 한글환경에서는 ㅇ요일로 나옴
    case
        when to_char(ibsadate, 'd') in ('7', '1') then '주말입사'
        else '평일입사'
    end
from tblInsa;


-- 2010년에 입사한 직원?
-- 2010-01-01 00:00:00 ~ 2010-12-31 00:00:00:00  > 31일 입사직원은 안나옴
select * from tblInsa
    where ibsadate between '2010-01-01' and '2010-12-31';  --오답

-- 날짜형 리터럴은 없다.
-- 아래의 포현은 문자열 리터럴이다.
-- 시분초는 0시 0분 0초로 한다.
select '2010-01-01', sysdate from dual; -- 22/04/22로 출력되지 않고 2010-01-01로 출력 > 날짜아님 > 암시적 형변환


select * from tblInsa
    where to_char(ibsadate, 'yyyy') = 2010; 

select
    name,
    to_char(ibsadate, 'yyyy-mm-dd day')
from tblInsa
    order by to_char(ibsadate, 'd') asc;



/*
    3. to_number()   > 가치 있는 함수가 아님
    - 문자 > 숫자
    - number to_number(컬럼)
*/

select 
    123 as "aaaaaaaaaaaaaaaaaaaaaa",  --우측정렬(숫자)
    '123' as"aaaaaaaaaaaaaaaaaaaaa", --좌측정렬(문자)
    to_number('123') as "aaaaaaaaaaaaaaaaaaaaa"
from dual;

select
    123 * 2,
    '123' * 2, --암시적 형변환 
    to_number('123') * 2  -- 가독성등 문제로 쓰는걸 권장하나 안쓰는 사람이 많음
from dual;

/*
    4. to_date()
    - 문자 -> 날짜
    - date to_date(컬럼, 형식문자열)
*/

select
    sysdate,
    '2022-04-22',
    to_date('2022-04-22'),
    to_date('2022-04-22', 'yyyy-mm-dd'),
    to_date('20220422', 'yyyymmdd'),
    to_date('2022/04/22', 'yyyy/mm/dd'),
    to_date('2022-04-22 15:05:30', 'yyyy-mm-dd hh24:mi:ss')
from dual;

-- 날짜 관련 함수
-- 2. 날짜 > 문자
-- 4. 문자 > 날짜




