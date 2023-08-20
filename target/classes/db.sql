--DB

create table park_member (

p_id varchar2(10char) primary key,
p_pw varchar2(10char) not null,
p_name varchar2(20char) not null,
p_addr varchar2(200char) not null,
p_photo varchar2(200char) not null,
p_role char(1char) not null
)
drop table park_member

create sequence park_member_seq
drop sequence park_member_seq

insert into park_member values('clok', 'qwer!','않히이게외않되','부산광역시 영도구 일산봉로 52 미주아파트 402호', 'qwer.jpg',
'관')
update park_member set p_photo = 'qwer.jfif' where p_id = 'clok' 

select*from park_member 

create table park_sns (
p_no number(4) primary key,
p_owner varchar2(10char) not null,
p_when date not null,
p_txt varchar2(300char) not null,
p_color char(7) not null
);

create sequence park_sns_seq;

select*from park_sns order by p_when
select count(*) from park_sns, park_member where p_id = p_owner

insert into park_sns values(park_sns_seq.nextval, 'clok', sysdate, '인생은 아름다워!', '#58FAF4');
insert into park_sns values(park_sns_seq.nextval, 'clok', sysdate, '폭풍우 치는 밤에', '#58F000');
insert into park_sns values(park_sns_seq.nextval, 'qwer', sysdate, '지아이조', '#58F000');
insert into park_sns values(park_sns_seq.nextval, 'qwer', sysdate, '쇼생크탈출', '#58F000');

select*from park_sns_reply

create table park_sns_reply(
pr_no number(5) primary key, 
pr_p_no number(4) not null,
pr_owner varchar2(10char) not null,
pr_txt varchar2(200char) not null,
pr_when date not null,
constraint sns_reply_fr_key foreign key(pr_p_no) references park_sns(p_no)
on delete cascade
);
create sequence park_sns_reply_seq;
drop sequence park_sns_reply_seq;
drop table park_sns_reply
insert into park_sns_reply values(park_sns_reply_seq.nextval, '1', 'qwer', '눈물없이 보기 힘들지', sysdate );

select * from ( select rownum as rn, p_photo, p_owner, p_txt, p_when, p_color, p_no
		from( select*from park_member, park_sns 
		where p_id=p_owner 
		and(p_txt like '%qwer%' or p_id like '%qwer%')
		order by p_when desc)) 
		where rn > = 1 and rn < = 7



