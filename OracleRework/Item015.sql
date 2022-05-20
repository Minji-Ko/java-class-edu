-- [Summary] 컬럼리스트 조건 사용하기, CASE END (2022-05-13 02:01:47)

select
    name,
    continent,
    case
        when continent = 'AS' then '아시아' 
        when continent = 'NA' then '북아메리카'
        when continent = 'EU' then '유럽'
        else continent
    end as continentName         -- 모든 조건에 불일치 > null 반환(***)
 from tblCountry;


 
 