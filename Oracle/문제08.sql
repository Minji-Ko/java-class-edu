-- 1. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select 
    name, buseo, jikwi, (basicpay + sudang) as salary, rownum 
from (select * from tblInsa where substr(ssn, 8, 1) = 1 order by (basicpay + sudang) desc);

-- 2. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select 
    name, buseo, jikwi, (basicpay + sudang), rownum
from (select * from tblInsa where substr(ssn, 8, 1) = 2 order by (basicpay + sudang) asc);

-- 3. tblInsa. 여자 인원수가 (가장 많은 부서 및 인원수) 가져오시오.
-- 3.1 여자인원수
select 
    buseo,
    count(*) as 여자인원수
from tblInsa
    where substr(ssn, 8, 1) = 2
        group by buseo
            having count(*) = (select max(count(*)) from tblInsa where substr(ssn, 8, 1) = 2 group by buseo);

-- 3.2 총인원수
select buseo, a
from (select buseo, count(decode(substr(ssn, 8, 1), 2, 1)) as w, count(*) as a from tblInsa group by buseo)
    where w = (select max(count(decode(substr(ssn, 8, 1), 2, 1))) from tblInsa group by buseo);

select buseo, count(*) 
from tblInsa
    group by buseo
        having count(decode(substr(ssn, 8, 1), 2, 1)) = (select max(count(decode(substr(ssn, 8, 1), 2, 1))) from tblInsa group by buseo);

-- 4. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)
select city, 인원수, rownum from
(select city, count(*) as 인원수
from tblInsa
    group by city
        order by count(*) desc);

-- 5. tblInsa. 부서별 인원수가 가장 많은 부서 및원수 출력.
select *
    from (select buseo, count(*) as count from tblInsa group by buseo order by count(*) desc) 
        where rownum = 1 or count = (select c from (select buseo, count(*) as c from tblInsa group by buseo order by count(*) desc) where rownum = 1);


-- 6. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select 
    name, buseo, jikwi, (basicpay + sudang), rnum
from(select i.*, rownum as rnum 
    from (select * from tblInsa where substr(ssn, 8, 1) = 1 order by (basicpay + sudang) desc) i)
        where rnum between 3 and 5;


-- 7. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.
select *
    from(select * from tblInsa order by ibsadate) 
        where rownum <= 5;

-- 8. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.
select * from 
    (select h.*, price * qty as pay from tblhousekeeping h order by pay desc)  -- as pay를 쓴 후에도 (price*qty)로 정렬하면 tblhousekeeping 에서 다시계산됨 ***
        where rownum < 4;


-- 9. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.
select * from tblInsa where buseo = 
    (select buseo from 
        (select buseo, rownum as rnum from 
            (select buseo, avg(basicpay) pay 
                from tblInsa group by buseo order by pay desc)) where rnum = 2);
      
      
-- 10. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.
select * 
    from (select * from tblTodo order by (completedate - adddate) asc)
        where rownum <= 5;


-- 11. tblinsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마인가?
select max(basicpay) - min(basicpay) from
    (select i.*, rownum as rnum from 
        (select * from tblInsa where substr(ssn, 8, 1) = 1 order by basicpay desc) i)
            where rnum = 3 or rnum = 9;
            
select sum(decode(rnum, 3, basicpay, 9, -basicpay)) from
    (select i.*, rownum as rnum from 
        (select * from tblInsa where substr(ssn, 8, 1) = 1 order by basicpay desc) i);


