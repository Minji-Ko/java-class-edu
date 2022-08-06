
-- C:\class\server\SpringREST\script.sql

select * from tblAddress;

drop table tblAddress;
drop sequence seqAddress;

create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    tel varchar2(15) not null,
    address varchar2(100) not null
);

create sequence seqAddress;

