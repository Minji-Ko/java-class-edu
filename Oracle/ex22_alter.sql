-- ex22_alter.sql

/*
    객체 생성: CREATE
    객체 삭제: DROP
    객체 수정: ALTER
    
    데이터 생성: INSERT
    데이터 삭제: DELETE
    데이터 수정: UPDATE

    테이블 수정하기
    - 테이블 정의 수정 > 테이블 스키마 수정 > 컬럼수정 (컬럼명 or 자료형(길이) or 제약사항)
    - 되도록 테이블 수정하는 상황을 발생시키면 안된다!!! > 설계를 반드시 완벽하게!!
  
  테이블 수정해야 하는 상황 발생!!
  1. 테이블 삭제(DROP) > 테이블 DDL(CREATE) 수정 > 수정된 DDL로 새롭게 테이블 생성
    a. 기존 테이블에 데이터가 없었을 경우 > 아무 문제 없음
    b. 기존 테이블에 데이터가 있었을 경우 > 미리 데이터 백업 > 테이블 삭제 > 수정 후 생성 > 데이터 복구
        - 개발 중에 사용 가능
        - 공부할 때 사용 가능
        - 서비스 운영중에는 거의 불가능한 방법
        
  2. ALTER 명령어 사용 > 기존 테이블의 구조 변경
    a. 기존 테이블에 데이터가 없었을 경우 > 아무 문제 없음
    b. 기존 테이블에 데이터가 있었을 경우 > 경우에 따라 무난/추가조치 필요
        - 개발 중에 사용 가능
        - 공부할 때 사용 가능
        - 서비스 운영 중 가능한 방법 > 좋은 상황이 아님!
    
    
*/

drop table tblEdit;

create table tblEdit (
    seq number primary key,
    data varchar(20) not null
);

insert into tblEdit values (1, '마우스');
insert into tblEdit values (2, '키보드');
insert into tblEdit values (3, '모니터');


-- Case 1. 새로운 컬럼을 추가하기
alter table tblEdit 
    add (price number null);

-- ORA-01758: table must be empty to add mandatory (NOT NULL) column

-- 1. 삭제 후 추가 > 추천
delete from tblEdit;

alter table tblEdit
    add (memo varchar2(100) not null);

insert into tblEdit values (1, '마우스', 3000, '로지텍');

alter table tblEdit 
    add (memo2 varchar2(100) not null);

-- 2. default
alter table tblEdit
    add (memo2 varchar2(100) default '임시' not null);

-- Case 2. 컬럼 삭제하기
alter table tblEdit
    drop column memo2;

alter table tblEdit 
    drop column memo;

alter table tblEdit
    drop column seq; -- PK 컬럼 삭제 > 절대 금지!!!


-- Case3. 컬럼 수정하기
insert into tblEdit values (4, '인텔 i7 12세대 최신형 노트북');

-- Case 3.1. 컬럼의 길이 수정하기(확장/축소)
alter table tblEdit
    modify (data varchar2(100)); -- not null유지

-- ORA-01441: cannot decrease column length because some value is too big
alter table tblEdit
    modify (data varchar(20));


-- Case 3.2 컬럼의 제약사항 수정하기
alter table tblEdit
    modify (data varchar2(100) null);
    
alter table tblEdit
    modify (data varchar2(100) not null);

-- Case 3.3 컬럼의 자료형 바꾸기 > 테이블 비우고 작업 > 최악
alter table tblEdit
    modify (data number);

alter table tblEdit
    modify (seq varchar2(100));

-- Case 3.4 컬럼명 바꾸기
alter table tblEdit
rename column data to etc;


desc tblEdit;

select * from tblEdit;

--------------------------------------------------------------------------------

-- 제약사항 수정하기 > 은근히 종종 씀

drop table tblEdit;

create table tblEdit (
    seq number,
    data varchar(20) not null,
    color varchar2(30) null
);

alter table tblEdit --> 제약은 modify로 잘 안하고 add constraint를 씀
    add constraint tbledit_seq_pk primary key(seq);

alter table tblEdit
    add constraint tbledit_color_ck
        check (color in ('red', 'yellow', 'blue'));

alter table tblEdit
    drop constraint tbledit_color_ck;

insert into tblEdit values (1, '마우스', 'red');
insert into tblEdit values (2, '키보드', 'yellow');
insert into tblEdit values (3, '모니터', 'white');

select * from tblEdit;
















