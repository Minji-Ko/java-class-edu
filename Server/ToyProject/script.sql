-- 회원 테이블
create table tblMember (
    id varchar2(30) primary key,
    pw varchar2(30) not null,
    name varchar2(30) not null,
    lv char(1) not null,                            -- 등급(1.회원, 2.관리자)
    pic varchar2(100) default 'pic.png' not null,
    regdate date default sysdate not null,
    active char(1) default 'y' not null             -- 탈퇴유무(y. 활동중, n.탈퇴)
);

insert into tblMember (id, pw, name, lv, pic, regdate) values ('hong', '1111', '홍길동', '1', default, default);
insert into tblMember (id, pw, name, lv, pic, regdate) values ('admin', '1111', '관리자', '2', default, default);

select * from tblMember;

commit;


-- 게시판
create table tblBoard (
    seq number primary key,
    subject varchar2(300) not null,
    content varchar2(4000) not null,
    id varchar2(300) not null references tblMember(id),
    regdate date default sysdate not null,
    readcount number default 0 not null,
    thread number not null,
    depth number not null,
    filename varchar2(100) null,
    orgfilename varchar2(100) null
);

create sequence seqBoard;


insert into tblBoard(seq, subject, content, id , regdate, readcount) values (seqBoard.nextVal, 'subject', 'content', 'hong', default, default);



select * from tblBoard;







select * from (select b.*, rownum as rnum from vwBoard b) where rnum between 1 and 10;


create or replace view vwBoard
as
select seq, subject, content, id, 
        (select name from tblMember where id = tblBoard.id) as name,
        regdate, readcount, thread, depth,
        (select count(*) from tblComment where pseq = tblBoard.seq) as commentcount,
        (sysdate - regdate) as isnew,
        filename, orgfilename
    from tblBoard order by thread desc;

select * from vwBoard;

select b.*, (select name from tblMember where id = b.id) from tblBoard b where seq = 11;

update tblBoard set readcount = readcount + 1 where seq = 11;
update tblBoard set filename = 'back.jpg', orgfilename ='back.jpg' where seq = 287;
commit;
-- 댓글 테이블
create table tblComment (
    seq number primary key,
    content varchar2(1000) not null,
    id varchar2(30) not null references tblMember(id),
    regdate date default sysdate not null,
    pseq number not null references tblBoard(seq)
);



create sequence seqComment;

drop table tblComment;

insert into tblComment(seq, content, id, regdate, pseq) values (seqComment.nextVal, 'content', 'hoho', default, 11);

select * from tblComment;

select tblComment.*, 
    (select name from tblMember where id = tblComment.id) as name 
from tblComment where pseq = 8 order by regdate desc ;

commit;


-- 해시 태그 테이블
create table tblHashTag(
    seq number primary key,
    tag varchar2(100) unique not null
);

-- 게시글 <-> 해시 태그
create table tblTagging (
    seq number primary key,
    bseq number not null references tblBoard(seq),
    hseq number not null references tblHashTag(seq)
);



