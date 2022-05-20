-- [Summary] 수학함수 사용하기 (ABS, POWER, SQRT) (2022-05-17 02:07:12)

-- ABS()        > 절대값 
SELECT 
    ABS(10),        --10
    ABS(-10),       --10
FROM dual;



-- POWER()      > 제곱
SELECT 
    POWER(2, 2),    --4
    POWER(2, 4),    --16
FROM dual;



-- SQRT()       > 제곱근(루트)
SELECT 
    SQRT(4),        --2
    SQRT(16)        --4
FROM dual;