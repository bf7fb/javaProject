drop table if exists tb_administrator;
create table tb_administrator(
	id int primary key auto_increment,
	username varchar(255) not null,
	password varchar(255) not null
);

insert into tb_administrator values(null,'wangzhen','wangzhen123..');

select * from tb_administrator;