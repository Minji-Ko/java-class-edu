-- [Summary] 수학함수 사용하기 (ROUND, FLOOR, CEIL, MOD) (2022-05-17 01:51:08)


-- ROUND(컬럼명[, 소수이하자릿수])            
SELECT 
    height / weight,            -- 2.73846153
    ROUND(height / weight),     -- 3
    ROUND(height / weight, 0),  -- 3
    ROUND(height / weight, 2)   -- 2.74
FROM tblComedian;



-- FLOOR(컬럼명)
-- TRUNC(컬럼명[, 소수이하자릿수])
SELECT 
    height / weight,            -- 2.73846153
    FLOOR(height / weight),     -- 2
    TRUNC(height / weight, 0)   -- 2
    TRUNC(height / weight, 2)   -- 2.73
FROM tblComedian;



-- CEIL(컬럼명)
SELECT 
    CEIL(height / weight)       -- 3
FROM tblComedian;



-- MOD(피제수, 제수)
select 
    floor(10 / 3) as "몫",
    mod(10, 3) as "나머지"
from dual;



