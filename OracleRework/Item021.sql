-- [Summary] 문자열 함수 사용하기 (INSTR, SUBSTR, REPLACE, DECODE) (2022-05-18 22:00:17)


-- INSTR(컬럼, 검색어[, 시작위치])        > 못찾으면 0 반환
SELECT * FROM tblInsa WHERE INSTR(tel, '010') = 1;



-- SUBSTR(컬럼, 시작위치[, 가져올 문자수]) : 문자열 추출       > one-based index라서 첨자를 1부터 시작***
SELECT SUBSTR('ABCDEFG', 2, 3) FROM dual;   --BCD



-- REPLACE(컬럼, 찾을 문자열, 바꿀 문자열) : 문자열 치환
select 
    replace(replace(substr(ssn, 8, 1), '1', '남자'), '2', '여자') as gender
from tblInsa;



-- DECODE(컬럼, 찾을 문자열, 바꿀 문자열[, 찾을 문자열, 바꿀 문자열] X N)
--> 못찾으면 null 반환***
--> case end의 간단한 버전
select 
    decode(substr(ssn, 8, 1), '1', '남자', '2', '여자')
from tblInsa;
