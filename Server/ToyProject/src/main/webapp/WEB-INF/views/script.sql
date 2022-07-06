-- 설문조사 DB
-- 설문(질문) <-> 설문(항목)
-- 설문(질문) <-> 선택

-- 정규화(X) 버전
create table tblResearch (
    seq number primary key,
    question varchar2(500) not null,
    item1 varchar2(300) not null,   -- 질문
    item2 varchar2(300) not null,
    item3 varchar2(300) not null,
    item4 varchar2(300) not null,   
    cnt1 number default 0 not null, -- 선택
    cnt2 number default 0 not null,
    cnt3 number default 0 not null,
    cnt4 number default 0 not null
);

insert into tblResearch values (1, '가장 잘 사용하는 프로그래밍 언어는?', 
                                        'JAVA', 'Python', 'Visual C++', 'Node.js', default, default, default, default);
                                                                            
select * from tblResearch;

update tblResearch set cnt1 = 10, cnt2 = 17, cnt3 = 3, cnt4 = 10 where seq = 1;
commit;


 
