-- [Summary] 연산자 사용하기 (2022-05-13 01:13:41)


-- 1. 산술 연산자 : - +, -, *, /, mod()[→ %]
SELECT salary + 10000 FROM employees;


-- 2. 문자열 연산자 : || 
SELECT first_name || last_name FROM employees;


-- 3. 비교연산자 : =[→ ==], <>[→ !=]               
--> 컬럼 리스트에서 사용 불가, 조건절에서 사용 가능
SELECT * FROM employees WHERE job_id = 'AD_PRES'; 


-- 4. 논리연산자 : and[→ &&], or[→ ||], not[→ !]   
--> 컬럼 리스트에서 사용 불가, 조건절에서 사용 가능
SELECT * FROM employees WHERE job_id = 'AD_PRES' AND salary >= 20000; 


-- 5. 대입연산자 : =                               
--> UPDATE문에서 사용
UPDATE employees SET first_name = 'Angela' WHERE employee_id = 100;


-- 6. SQL 연산자 : in, between, like, is

-- *** 3항 연산자, 증감연산자는 없음