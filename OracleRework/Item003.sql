-- [Summary] ANSI-SQL 자료형 (2022-05-13 00:30:34)

-- 숫자형
-- number
-- number(precision) : 전체 자릿수
-- number(precision, scale) : 전체 자릿수 + 소수이하 자릿수

-- 문자형
-- char vs nchar > n의 의미? UTF-16으로 동작하게 함
-- char vs varchar > 
    -- var의 의미? 가변 자릿수 문자열로 공간(컬럼)의 크기가 변함
    -- 모자란 길이만큼 스페이스(공백문자)를 채워넣는다
-- char(n), nchar(n)
-- varchar2(n), nvarchar2(n)
-- clob, nclob : 대용량 텍스트

-- 날짜/시간형
-- date : 년월일시분초
-- timestamp : 년월일시분초 + 밀리초 + 나노초
-- interval : 틱값 저장용

-- 이진 데이터형
-- blob 