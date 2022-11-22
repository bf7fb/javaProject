drop table if exists tb_message;
create table tb_message(
	id int primary key auto_increment,
	name varchar(255),
	tel varchar(255),
	description varchar(255)
);

insert into tb_message values(null,'王振','15093471703','狸花猫需要猫粮');

insert into tb_message values(null,'田浩宇','2133213212','小金毛需要救助');

insert into tb_message values(null,'区腾飞','21767813212','大橘猫被带到医院救治了，不在校园');

select * from tb_message;