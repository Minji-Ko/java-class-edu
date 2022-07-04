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

create sequence seqHashTag;

-- 게시글 <-> 해시 태그
create table tblTagging (
    seq number primary key,
    bseq number not null references tblBoard(seq),
    hseq number not null references tblHashTag(seq)
);

create sequence seqTagging;


select * from tblHashTag; --296 
select * from tblTagging;

select b.* from tblBoard b 
    inner join  tblTagging t on t.bseq = b.seq
    inner join tblHashTag h on h.seq = t.hseq
        where h.tag = '인삿말';


--좋아요 싫어요
create table tblGoodBad (
    seq number primary key,
    id varchar2(30) not null references tblMember(id),
    bseq number not null references tblBoard(seq),
    good number default 0 not null,
    bad number default 0 not null
);

create sequence seqGoodBad;

select * from tblGoodBad;

-- 글 개수 통계
select m.id, (select name from tblMember where id = m.id) as name, (select count(*) from tblBoard where id = m.id)  as cnt
from tblBoard b right outer
    join tblMember m
        on m.id = b.id
            group by m.id;
            
            
-- 댓글 갯수 통계
select m.id, (select name from tblMember where id = m.id) as name, (select count(*) from tblComment where id = m.id) as cnt
from tblComment c right outer
    join tblMember m
        on m.id = c.id
            group by m.id;
       
            
select h.tag, (select count(*) from tblTagging where hseq = h.seq) as cnt 
from tblHashTag h left outer
    join tblTagging t 
        on h.seq = t.hseq 
            group by h.tag, h.seq;



-- 맛집 즐겨찾기
create table tblFood (
    seq number primary key,
    name varchar2(100) not null,
    lat number not null,        -- 위도(Latitude)
    lng number not null,        -- 경도(Longitude)
    star number(3) not null,    -- 별점(1~5)
    category number not null references tblCategory(seq)
);
create sequence seqFood;


create table tblCategory (
    seq number primary key,
    name varchar2(100) not null,
    marker varchar2(100) not null,
    icon varchar2(100) not null
);
insert into tblCategory values(1, '한식', 'm1', 'fa-solid fa-bowl-food');
insert into tblCategory values(2, '양식', 'm2', 'fa-solid fa-burger-cheese');
insert into tblCategory values(3, '카페', 'm3', 'fa-solid fa-mug-hot');

commit;

select * from tblFood;
select * from tblCategory;

update tblCategory set icon = 'fa-solid fa-utensils' where seq=2;
select f.*, c.marker as marker, c.icon as icon from tblFood f inner join tblCategory c on c.seq = f.category order by f.name asc;