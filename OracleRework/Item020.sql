-- [Summary] 문자열 함수 사용하기 (LENGTH, UPPER, LPAD, TRIM) (2022-05-18 22:00:17)


-- LENGTH(컬럼) : 문자열 길이
SELECT name FROM tblCountry ORDER BY LENGTH(name) DESC;



-- UPPER(컬럼), LOWER(컬럼), INITCAP(컬럼) : 대소문자 변환
SELECT 
    UPPER('ko minji'),  --KO MINJI
    LOWER('ko minji'),  --ko minji
    INITCAP('ko minji') --Ko Minji
FROM dual;



-- LPAD(컬럼, 자릿수[, 문자]), RPAD(컬럼, 자릿수[, 문자])
SELECT 
    LPAD('1', 3),          --"  1"
    LPAD('1', 3, '0'),     --"001"
    RPAD('1', 3, 'A')      --"1AA"
FROM dual;



-- TRIM(컬럼), LTRIM(컬럼), RTRIM(컬럼)
select 
    trim('    1    2    3    '),    -- "1    2    3"
    ltrim('    1    2    3    '),   -- "1    2    3    "
    rtrim('    1    2    3    ')    -- "    1    2    3"
from dual;




