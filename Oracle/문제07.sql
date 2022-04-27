-- employees. 'Munich' 도시에 위치한 부서에 소속된 직원들 명단?
select 
    e.employee_id,
    e.first_name || ' ' || e.last_name as fullname,
    e.email,
    e.phone_number,
    e.hire_date,
    e.job_id,
    e.salary
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
                    where l.city = 'Munich';
    


-- tblMan. tblWoman. 서로 짝이 있는 사람 중 남자와 여자의 정보를 모두 가져오시오.
--    [남자]        [남자키]   [남자몸무게]     [여자]    [여자키]   [여자몸무게]
--    홍길동         180       70              장도연     177        65
--    아무개         175       null            이세영     163        null
--    ..
select 
    m.name as 남자,
    m.height as 남자키,
    m.weight as 남자몸무게,
    w.name as 여자,
    w.height as 여자키,
    w.weight as 여자몸무게
from tblMan m
    inner join tblWoman w
        on m.couple = w.name; 

    
    

-- tblAddressBook. 가장 많은 사람들이 가지고 있는 직업은 주로 어느 지역 태생(hometown)인가?
create or replace view vwjob
as
select job
from tblAddressBook
    group by job
        having count(*) = (select max(count(*)) from tblAddressBook group by job);

select hometown
from tblAddressBook
    where job in (select * from vwjob)
        group by hometown
            having count(*) = (select max(count(*)) from tblAddressBook where job in (select * from vwjob) group by hometown);


-- tblAddressBook. 이메일 도메인들 중 평균 아이디 길이가 가장 긴 이메일 사이트의 도메인은 무엇인가?
select substr(email, instr(email, '@') + 1) from tblAddressBook
    group by substr(email, instr(email, '@') + 1)
        having avg(length(substr(email, 1, instr(email, '@') - 1))) = (select max(avg(length(substr(email, 1, instr(email, '@') - 1))))
                                                                            from tblAddressBook
                                                                                group by substr(email, instr(email, '@') + 1));

            
            

-->> tblAddressBook. 평균 나이가 가장 많은 (hometown)들이 가지고 있는 직업 중 가장 많은 직업은?
create or replace view vwhometown
as
select 
   hometown
from tblAddressBook 
    group by hometown
        having avg(age) = (select max(avg(age)) from tblAddressBook group by hometown);

select
    job,
    count(*)
from tblAddressBook
    where hometown in (select * from vwhometown)
        group by job
            having count(*) = (select max(count(*)) from tblAddressBook  where hometown in (select * from vwhometown) group by job);


--> tblAddressBook. 남자 평균 나이보다 나이가 많은 서울 태생 + 직업을 가지고 있는 사람들을 가져오시오.
select *
from tblAddressBook
    where age > (select avg(age) from tblAddressBook where gender = 'm')
        and hometown = '서울'
        and job not in ('취업준비생', '백수')
            order by age asc , job asc;



--> tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오.
select
    decode(gender, 'f', '여자', 'm', '남자') as 성별,
    count(case when age like '1_' then 10 end) as "10대",
    count(case when age like '2_' then 20 end) as "20대",
    count(case when age like '3_' then 30 end) as "30대",
    count(case when age like '4_' then 40 end) as "40대"
from tblAddressBook
    where email like '%@gmail.com' 
    group by gender;


select
    decode(gender, 'f', '여자', 'm', '남자') as 성별,
    decode(substr(age, 1, 1), '1', '10대', '2', '20대', '3', '30대', '4', '40대') as 나이,
    count(*) as 인원수
from tblAddressBook
    where email like '%@gmail.com' 
    group by gender, substr(age, 1, 1)
    order by 성별, 나이;


-- tblAddressBook. 가장 나이가 많으면서 가장 몸무게가 많이 나가는 사람과 같은 직업을 가지는 사람들을 가져오시오.
select *
from tblAddressBook
    where job = (select job
                from tblAddressBook
                    where age = (select max(age) from tblAddressBook)
                        and weight = (select max(weight) from tblAddressBook));



-->> tblAddressBook.  동명이인이 여러명 있습니다. 이 중 가장 인원수가 많은 동명이인(모든 이도윤)의 명단을 가져오시오.
select 
    *
from tblAddressBook
    where name in (select name 
                    from tblAddressBook 
                        group by name
                            having count(*) = (select max(count(*)) from tblAddressBook group by name));



-->> tblAddressBook. 가장 사람이 많은 직업의(332명) 세대별 비율을 구하시오.
--    [10대]       [20대]       [30대]       [40대]
--    8.7%        30.7%        28.3%        32.2%
select 
    job, 
    round((count(case when age between 10 and 19 then 1 end) / count(*)) * 100 ,1) || '%' as "10대",
    round((count(case when age between 20 and 29 then 1 end) / count(*)) * 100 ,1) || '%' as "20대",
    round((count(case when age between 30 and 39 then 1 end) / count(*)) * 100 ,1) || '%' as "30대",
    round((count(case when age between 40 and 49 then 1 end) / count(*)) * 100 ,1) || '%' as "40대"
from tblAddressBook
    group by job
        having count(*) = (select max(count(*)) from tblAddressBook group by job);



-- tblStaff, tblProject. 현재 재직중인 모든 직원의 이름, 주소, 월급, 담당프로젝트명을 가져오시오.
select 
    s.name as 이름,
    s.address as 주소,
    s.salary as 월급,
    p.project as 담당프로젝트명
from tblProject p
    inner join tblStaff s
        on p.staff_seq = s.seq;

       
--> tblVideo, tblRent, tblMember. '뽀뽀할까요' 라는 비디오를 빌려간 회원의 이름은?
select 
    v.name as 비디오명,
    m.name as 대여자
from tblRent r
    inner join tblVideo v
        on r.video = v.seq
         inner join tblMember m
            on r.member = m.seq
                where v.name = '뽀뽀할까요' 
                    and r.retdate is null;

    
    
-- tblStaff, tblProejct. 'TV 광고'을 담당한 직원의 월급은 얼마인가?
select name, salary
from tblstaff s
    where s.seq = (select staff_seq from tblProject where project = 'TV 광고');
    
    
-- tblVideo, tblRent, tblMember. '털미네이터' 비디오를 빌려갔던 회원들의 이름은?
select 
    m.name
from tblRent r
    inner join tblVideo v
        on r.video = v.seq
            inner join tblMember m
                on r.member = m.seq
                    where v.name = '털미네이터';
                
-- tblStaff, tblProject. 서울시에 사는 직원을 제외한 나머지 직원들의 이름, 월급, 담당프로젝트명을 가져오시오.
select 
    s.name,
    s.salary,
    p.project
from tblProject p
    inner join tblStaff s
        on p.staff_seq = s.seq
            where s.address not like '서울%';
            
            
    
    
-- tblCustomer, tblSales. 상품을 2개(단일상품) 이상 구매한 회원의 연락처, 이름, 구매상품명, 수량을 가져오시오.
select
    c.tel as 연락처, 
    c.name as 이름, 
    s.item as 구매상품명, 
    s.qty as 수량
from tblSales s
    inner join tblCustomer c
        on s.cseq = c.seq
            where c.seq in (select distinct cseq from tblSales where qty >= 2);
                
                
-- tblVideo, tblRent, tblGenre. 모든 비디오 제목, 보유수량, 대여가격을 가져오시오.
select          
    v.name as 제목,
    avg(v.qty) - count(case
        when r.rentdate is not null then 1
    end) as 보유수량, 
    avg(g.price) as 대여가격
from tblRent r
    right outer join tblVideo v
        on r.video = v.seq
            inner join tblGenre g
                on v.genre = g.seq
                    where r.retdate is null
                        group by v.name;
                    
select          
    v.name as 제목,
    v.qty - (select count(*) from tblRent where video = v.seq and retdate is null) as 보유수량,
    (select price from tblGenre where seq = v.genre) as 대여가격
from tblVideo v;
                
     
--> tblVideo, tblRent, tblMember, tblGenre. 2007년 2월에 대여된 구매내역을 가져오시오. 회원명, 비디오명, 언제, 대여가격
select 
    m.name as 회원명, 
    v.name as 비디오명, 
    r.rentdate as 대여일, 
    g.price as 대여가격 
from tblRent r
    inner join tblVideo v
        on r.video = v.seq
            inner join tblGenre g
                on v.genre = g.seq
                    inner join tblMember m 
                        on r.member = m.seq
                             where r.rentdate between '07-02-01' and '07-02-28';
--                           where instr(rentdate, '07/02') = 1;

        
--> tblVideo, tblRent, tblMember. 현재 반납을 안한 회원명과 비디오명, 대여날짜를 가져오시오.
select 
    m.name as 회원명, 
    v.name as 비디오명, 
    r.rentdate as 대여일
from tblRent r
    inner join tblVideo v
        on r.video = v.seq
            inner join tblMember m 
                on r.member = m.seq
                    where r.retdate is null;
    
    
-- employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.
select 
    e.first_name || ' ' || e.last_name as 이름, 
    e.department_id as 부서번호, 
    (select department_name from departments where department_id = e.department_id) as 부서명 
from employees e;
        
        
-- employees, jobs. 사원들의 정보와 직업명을 가져오시오.
select 
    e.first_name || ' ' || e.last_name as 이름,
    e.phone_number as 전화번호,
    e.hire_date as 입사일,
    e.salary as 월급,
    j.job_title as 직업명
from employees e
    inner join jobs j
        on e.job_id = j.job_id;
        
        
-- employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.
select 
    *
from employees e
    inner join jobs j
        on e.job_id = j.job_id
            where e.salary = j.max_salary;

        
    
    
-- departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.
select 
    d.department_name,
    l.city
from departments d
    inner join locations l
        on d.location_id = l.location_id;
        
        
-- locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.
select 
    (select city from countries where country_id = l.country_id) 
from locations l
    where l.location_id = 2900;
    
            
-- employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
select 
    first_name||' '||last_name as 이름,
    salary as 급여,
    department_id as 부서번호
from employees
    where department_id in (select distinct department_id from employees where salary >= 12000);
        
        
-- employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 가져오시오.
select 
    e.first_name||' '||e.last_name as 이름,
    d.department_id as 부서번호,
    d.department_name as 부서이름
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
                    where city = 'Seattle';
    
    
-- employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.
select *
from employees
    where department_id = (select department_id from employees where first_name = 'Jonathon');
    
    
-- employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.
select 
    e.first_name||' '||e.last_name as 이름,
    (select department_name from departments where department_id = e.department_id) as 부서명,
    e.salary as 월급
from employees e
    where e.salary >= 3000;          
            
-- employees, departments. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.
select 
    e.department_id as 부서번호,
    d.department_name as 부서이름,
    e.salary as 월급
from employees e
    inner join departments d
        on e.department_id = d.department_id
            where e.department_id = 10;
            
            
-- departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.
select 
    h.start_date as 입사일,
    h.end_date as 퇴사일,
    (select department_name from departments where department_id = h.department_id) as 부서이름
from job_history h;
        
        
-- employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 
-- 각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.
select 
    e.employee_id as 사원번호,
    e.first_name||' '||e.last_name as 사원이름,
    e.manager_id as 관리자번호,
    (select first_name||' '||last_name from employees where employee_id = e.manager_id) as 관리자이름
from employees e;
        
        
-->> employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 년도를 기준으로 오름차순 정렬.
select 
    e.hire_date as 입사년도, 
    to_char((select avg(salary) from employees where hire_date = e.hire_date), '99,999') as "입사년도 평균급여"
from employees e
    inner join jobs j
        on e.job_id = j.job_id
            where j.job_title = 'Sales Manager'
                order by e.hire_date;
            
            
select 
    distinct e.hire_date as 입사년도, 
    avg(e.salary) as "입사년도 평균급여"
from employees e
    inner join jobs j
        on e.job_id = j.job_id
            group by e.hire_date
                having e.hire_date in (select e.hire_date 
                                            from employees e inner join jobs j 
                                                on e.job_id = j.job_id
                                                  where j.job_title = 'Sales Manager');


-->> employees, departments. locations. 
-- 각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 사원수를 가져오시오. 
-- 단, 도시에 근무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.
select 
    l.city as 도시명,
    to_char(avg(e.salary), '99,999') as 평균연봉,
    count(*) as 사원수
from employees e 
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on d.location_id = l.location_id
                    group by l.city
                        having count(*) < 10
                            order by avg(e.salary) asc;

            
            
-- employees, jobs, job_history. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 
-- 현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것.
select 
    e.employee_id as 사원번호,
    e.first_name || ' ' || e.last_name as 이름
from job_history h
    inner join jobs j
        on h.job_id = j.job_id
            inner join employees e
                on h.employee_id = e.employee_id 
                    where j.job_title = 'Public Accountant';
    
    
-- employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.
select 
    e.first_name,
    e.last_name,
    d.department_name as 부서명,
    d.location_id,
    l.city
from employees e
    inner join departments d
        on  d.department_id = e.department_id
            inner join locations l
                on d.location_id = l.location_id
                    where e.commission_pct is not null;
    
    
-- employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.
select 
    e.first_name,
    e.last_name,
    e.hire_date
from employees e
    where e.hire_date < (select hire_date from employees where employee_id = e.manager_id);

select
    e.first_name,
    e.last_name,
    e.hire_date,
    m.hire_date
from employees e
    inner join employees m
        on e.manager_id = m.employee_id
            where m.hire_date > e.hire_date;
