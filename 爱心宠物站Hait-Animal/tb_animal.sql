drop table if exists tb_animal;

create table tb_animal(
	id int primary key auto_increment,
	animal_name varchar(255),
	sex varchar(255),
	is_live varchar(255),
	description varchar(255),
	likes int 
);

insert into tb_animal values(null,'沙滩小金毛','雄性','健在','皮毛光泽美丽，太阳下闪闪发光',1);

insert into tb_animal values(null,'狸花猫','雄性','健在','黑白渐变的小猫咪，不太粘人',1);

insert into tb_animal values(null,'大橘猫','雌性','健在','黑白橙三种渐变，非常好看',1);

insert into tb_animal values(null,'白色狸花猫','雄性','前往喵星','比较高冷，不粘人，容易抓人',1);

insert into tb_animal values(null,'黑白渐变小猫咪','雌性','健在','比较高冷，但还算贴近人，不喜欢被抚摸',1);

insert into tb_animal values(null,'大橘','雄性','健在','比较高冷，爱抓人，不爱贴亲人，但被同学成为校园代表猫',1);

insert into tb_animal values(null,'大橘','雄性','健在','比较高冷，爱抓人，不爱贴亲人，但被同学成为校园代表猫',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

insert into tb_animal values(null,'豆豆','雄性','健在','吃饭睡觉打豆豆',1);

select * from tb_animal;

