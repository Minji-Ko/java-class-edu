-- [Summary] SQL연산자 LIKE (2022-05-13 01:46:17)

/*

- column_list LIKE '패턴 문자열'

                    '패턴 문자열' 구성 요소
                    1. _ : 임의의 문자 1개
                    2. % : 임의의 문자 N개 (0~무한대)

*/

SELECT name FROM tblInsa WHERE name LIKE '김__';
SELECT name FROM tblInsa WHERE name LIKE '김%';

SELECT * FROM tblInsa WHERE tel LIKE '010-____-____';
SELECT * FROM tblInsa WHERE tel LIKE '010%';