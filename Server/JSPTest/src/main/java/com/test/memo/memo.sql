create table tblMemo (
    seq number primary key,
    subject varchar2(100) not null,
    content varchar2(1000) not null,
    name varchar2(30) not null,
    pw varchar2(30) not null,
    regdate date default sysdate not null
);

create sequence seqMemo;

-- 업무 SQL
insert into tblMemo (seq, subject, content, name, pw, regdate)
    values (seqMemo.nextVal, '메모입니다.', '내용입니다.', '홍길동', '1111', default);

select * from tblMemo order by seq desc;

select count(*) from tblMemo where seq = 1 and pw = '1111'; -- 인증(허가)

update tblMemo set subject = '메모입니다.2', content = '내용입니다.2', name = '홍길동2' where seq = 1;

delete tblMemo where seq = 1;



