-- [Summary] 집계함수로 사용하기 (COUNT, SUM, AVG, MAX, MIN) (2022-05-16 09:14:34)

-- COUNT(컬럼명)
SELECT
    COUNT(*) as "전체인원수",
    COUNT(CASE WHEN gender = 'm' THEN gender END) AS "남자인원수", --> null은 COUNT제외
    COUNT(CASE WHEN gender = 'f' THEN gender END) AS "여자인원수"
FROM tblComedian;



-- SUM(컬럼명)      > 숫자형만
SELECT 
    SUM(basicpay)   AS "지출 급여 합", 
    SUM(sudang)     AS "지출 수당 합",
    SUM(basicpay) + SUM(sudang) AS "총 지출"
FROM tblInsa;



-- AVG(컬럼명)      > NULL 제외(***)
SELECT 
    AVG(population),                   
    SUM(population) / COUNT(*),         -- count = 14 
    SUM(population) / COUNT(population) -- count = 13 > AVG(population)
FROM tblCountry;



-- MAX(컬럼명)      
-- MIN(컬럼명)      > 숫자형, 문자형, 날짜형
SELECT MAX(ibsadate), MIN(ibsadate) FROM tblInsa;


-- 주의할점
-- 1. ORA-00937: not a single-group group function     > 집합값과 개인값 동시 사용불가
-- 2. ORA-00934: group function is not allowed here    > WHERE절에 집합값 사용불가
