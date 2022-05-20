-- [Summary] SQL연산자 BETWEEN (2022-05-13 01:46:17)


-- column_list BETWEEN min AND max;  > min과 max를 포함!

-- 1. 숫자형 
SELECT * FROM tblInsa WHERE basicpay BETWEEN 1500000 AND 2000000;

-- 2. 문자형
SELECT * FROM tblInsa WHERE name BETWEEN '박' AND '유';

-- 3. 날짜형
SELECT * FROM tblInsa WHERE ibsadate BETWEEN '2010-01-01' AND '2010-12-31';