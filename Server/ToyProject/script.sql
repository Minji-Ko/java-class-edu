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
    readcount number default 0 not null
);

create sequence seqBoard;



insert into tblBoard(seq, subject, content, id , regdate, readcount) values (seqBoard.nextVal, 'subject', 'content', 'hong', default, default);


select * from tblBoard;






