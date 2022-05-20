-- [Summary] 컬럼과 테이블 별칭만들기(Alias) (2022-05-13 01:24:59)

-- 컬럼 별칭
SELECT name AS "man_name", couple AS "woman_name" FROM tblMan;

-- 테이블 별칭
SELECT 
    m.name, 
    m.couple
FROM tblMan m; 