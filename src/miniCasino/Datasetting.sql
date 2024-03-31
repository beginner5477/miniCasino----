show tables;
create table cstInfo(
	idx int not null primary key auto_increment,
	name varchar(20) not null,
	id varchar(20) not null unique key,
	password varchar(30) not null,
	cash int not null,
	payed int not null,
	grade char(3) not null unique key,
	foreign key(grade) references level(grade)
);
create table level(
	grade char(3) not null primary key,
	discnt double not null
);
desc cstInfo;
desc level;
select * from cstInfo;
select * from level;
insert into cstInfo values(default,'김dhdhdhdd완','okm5477','ehdhks5477@',0,0,'A');
update cstInfo set payed = payed + 2000 where id = 'okm5477';
update cstInfo set payed = 0 where id = 'okm5477';
delete  from cstInfo;
update level set discnt = 1 where grade = 'A';
insert into level values('A',0.95);
insert into level values('S',0.9);
insert into level values('SS',0.8);
insert into level values('SSS',0.7);
update cstInfo set name = '김도완' where id = 'okm5477';
select c.id, c.grade, l.discnt from cstInfo c, level l where c.grade = l.grade && c.id = 'okm5477'; 