-- [Summary] 관리자로 DB시스템 정보 확인하기 (2022-05-13 01:09:35)

-- 1. 사용자 정보
SELECT * FROM dba_users; 

-- 2. 특정 사용자가 소유한 테이블 정보
SELECT * FROM dba_tables WHERE OWNER = 'HR';

-- 3. 특정 테이블의 컬럼 정보 > 스키마
SELECT * FROM dba_tab_columns WHERE OWNER = 'HR' AND TABLE_NAME = 'TBLCOUNTRY'; 

-- 4. 특정 테이블의 레코드 정보
SELECT * FROM HR.TBLCOUNTRY;




