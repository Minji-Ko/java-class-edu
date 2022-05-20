-- [Summary] SQL연산자 IN (2022-05-13 01:46:17)

-- column_list IN (value1, value2, value3...)  > value 중 하나와 일치하면 만족

SELECT * FROM tblInsa WHERE buseo IN ('홍보부', '개발부', '총무부');
