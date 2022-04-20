-- ex02_datatype.sql


/*
ANSI-SQL 자료형  > ** 자바와 비교하지 말 것 
- 오라클 자료형


1. 숫자형
    - 정수, 실수
    a. number
        -(유효자리)38자리 이하의 숫자를 표현하는 자료형
        - 12345678901234567890123456789012345678 > 10^38 -1 까지만 저장할 수 있는게 아님**
        - 5~22byte (가변) 
        - 1x10^-130 ~ 9.9999x10^125
        
        - number
        - number(precision) : 전체 자릿수
        - number(precision, scale) : 전체 자릿수 + 소수이하 자릿수
        
        
2. 문자형
    - 문자, 문자열
    - char + Strnig > 자바의 String과 유사
    - char vs nchar > n의 의미?
    - char vs varchar > var의 의미?
    a. char
        - 고정 자릿수 문자열 > 공간(컬럼)의 크기가 불변
        - char(n): n자리 문자열, n(바이트)
        - 최소 크기 : 1byte 
        - 최대 크기 : 2000byte
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 스페이스로 채운다.
        
    b. nchar
        - n : national > 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16으로 동작하게 함
        - 고정 자릿수 문자열
        - nchar(n): n자리 문자열, n(글자수) > UTF-16은 영어나 한글이나 모두 2byte
        - 최소 크기 : 1글자
        - 최대 크기 : 1000글자
        
    c. varchar2 ♡♥
        - 다른 DB의 varchar랑 같음 > 오라클에 이미 varchar가 있어서 충돌문제 때문에 2를 붙임
        - 가변 자릿수 문자열 > 공간의 크기가 가변
        - varchar2(n): n자리 문자열, n(바이트)
        - 최소 크기 : 1byte
        - 최대 크기 : 4000byte
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 즉, 데이터의 크기가 공간의 크기가 된다.
        - 요즘에는 char을 잘 쓰지 않음 > 회사마다 다르긴 함 > 처음에는 char가 훨씬 빨랐지만 기술이 발전함
        
    d. nvarchar2
        - n : national > 오라클 인코딩과 상관없이 해당 컬럼을 UTF-16으로 동작하게 함
        - 가변 자릿수 문자열 > 공간의 크기가 가변
        - nvarchar2(n): n자리 문자열, n(문자수)
        - 최대 크기 : 1글자
        - 최대 크기 : 2000글자
        - 주어진 공간을 데이터가 채우지 못하면 나머지 공간을 버린다. 즉, 데이터의 크기가 공간의 크기가 된다.
    
    e. clob, nclob '씨롭'
        - character large object
        - 대용량 텍스트
        - 128TB
        - 2000 글자가 넘어가면 clob을 사용하면 되지만 잘 사용 안함 > 위의 자료형이 값형이라면 이건 참조형
        
        
3. 날짜/시간형
    - 자바의 Calendar, Date..
    
    a. date ♡♥
        - 년월일시분초
        - 7byte
        - 기원전 4712년 1월 1일 ~ 9999년 12월 31일
    
    b. timestamp
        - 년월일시분초 + 밀리초 + 나노초
    
    c. interval
        - 시간
        - 틱값 저장용
        - number를 대신 사용하는 경우가 많음
        
        
4. 이진 데이터형
    - 비 텍스트 데이터
    - 이미지, 영상, 음악, 파일 등..
    - ex) 게시판(첨부파일), 회원가입(사진) > 파일명+경로 정도만(문자열) 저장
    -   > 속도가 상대적으로 느려짐, DB가 커짐
    a. blob 
        - byte large object
        - 최대 128TB

결론)
1. 숫자 > number
2. 문자 > varchar2 + char
3. 날짜 > date

    
*/


-- 테이블 선언(생성)
/*

    create table 테이블명 (
        컬럼 선언
        컬럼명 자료형
    );

*/
-- *** 오라클은 사용자가 정의한 모든 식별자를 DB에 저장할 때 항상 대문자로 변환해서 저장한다(****)
-- 식별자: 접두어
create table tblType ( -- tbl_type, type으로 적는 사람도 있음  
    --num number -- 자바랑 순서가 반대
    --num number(3) -- 자리수 제한 > 정수타입
    --num number(4,2) -- 문장종결자(;)를 쓰면 안됌
    
    -- str1 char(10), -- str1 컬럼에는 최대 10byte 크기의 문자를 저장가능
    -- str2 varchar2(10)
    
    str1 nchar(10)

)

-- 테이블 삭제
-- drop table 테이블명;
drop table tblType;

-- 확인
select * from tabs; --table > 현재 계정이 소유하고 있는 테이블 정보

select * from tabs where table_name = 'tblType'; -- (X) > 데이터의 대/소문자는 구분***
select * from tabs where table_name = 'TBLTYPE';

--데이터 추가하기
insert into tblType (num) values (100);  -- 정수형 리터럴
insert into tblType (num) values (3.14); -- 실수형 리터럴
insert into tblType (num) values (123456789012345678901234567890123456789123); -- 유효자리수


-- num number(3)
-- ORA-01438: value larger than specified precision allowed for this column
insert into tblType(num) values (1234);
insert into tblType(num) values (123);
insert into tblType(num) values (-1000);
insert into tblType(num) values (-999);


-- num number(4,2) 
insert into tblType(num) values (3.12345);
insert into tblType(num) values (3.12945); -- 반올림
insert into tblType(num) values (3.9);
insert into tblType(num) values (100);
insert into tblType (num) values (99.99); -- 전체자리수가 4자리


-- str1 char(10)
insert into tblType (str1) values ('A'); 
insert into tblType (str1) values ('ABC'); 
insert into tblType (str1) values ("ABC"); 
insert into tblType (str1) values ('ABCABCABCA'); 
-- ORA-12899: value too large for column "HR"."TBLTYPE"."STR1" (actual: 11, maximum: 10)
insert into tblType (str1) values ('ABCABCABCAB'); 

insert into tblType (str1) values ('가나다'); -- 한 글자당 3byte
insert into tblType (str1) values ('가나다라');


-- str1 char(10), str2 varchar2(10)
insert into tblType (str1, str2) values ('ABC', 'ABC');
insert into tblType (str1, str2) values ('ABCABCABCA', 'ABCABCABCA');
-- ORA-12899: value too large for column "HR"."TBLTYPE"."STR2" (actual: 11, maximum: 10)
insert into tblType (str1, str2) values ('ABCABCABCA', 'ABCABCABCAB');

-- @ABC       @ : char > 최대 크기에 모자란 길이만큼 스페이스(공백문자)를 채워넣는다. > 10byte
-- @ABC@        : varchar2 > 최대 크기와 상관없이 데이터만 들어가고 나머지 공간은 삭제 > 3byte


insert into tblType (str1) values ('가나다');
insert into tblType (str1) values ('가나다라마바'); 
insert into tblType (str1) values ('가나다라마바사아자차'); 
-- ORA-12899: value too large for column "HR"."TBLTYPE"."STR1" (actual: 11, maximum: 10)
insert into tblType (str1) values ('가나다라마바사아자차카'); 

insert into tblType (str1) values ('ABCDEFGHIJ');
-- ORA-12899
insert into tblType (str1) values ('ABCDEFGHIJK'); 



--데이터 가져오기
select * from tblType;




