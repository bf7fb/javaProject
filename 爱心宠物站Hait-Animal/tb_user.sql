drop table if exists tb_user;

create table tb_user(
	id int primary key auto_increment,
	username varchar(255) not null,
	password varchar(255) not null
);

insert into tb_user values(null,'wangzhen','123456');

insert into tb_user values(null,'wangkun','123456..');

select * from tb_user;