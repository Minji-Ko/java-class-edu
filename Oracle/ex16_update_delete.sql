--ex16_update_delete.sql

/*
    UPDATE
    - DML
    - 원하는 행의 원하는 컬럼값을 수정하는 명령어
    - UPDATE 테이블명 SET 컬럼명=값 [,컬럼명=값] [WHERE절]
    
    DELETE
    - DML
    - 원하는 행을 삭제하는 명령어
    - DELETE [FROM] 테이블명 [WHERE절]
*/

commit;
rollback;

select * from tblCountry;

--대한민국: 서울 > 세종
-- ******************** WHERE절 없이 쓰는거 진짜 주의!!!!!!!!!!!! *****************************
update tblCountry set capital = '세종'; 
-- **********************************************************************************************

update tblCountry set capital = '세종' where name = '대한민국';

--전체 레코드 업데이트
update tblCountry set population = population * 1.1;

update tblCountry set capital = '부산', continent = 'EU', area = 30 where name = '대한민국'; 


-- tblInsa
select * from tblInsa;

-- 구조조정
-- basicpay 180~200만원
delete from tblInsa where basicpay between 1800000 and 2000000;


update tblInsa set tel = null where num = 1001; -- 행의 일부만 삭제는 delete가 아닌 update


























