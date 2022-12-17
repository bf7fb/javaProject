drop database if exists music;

create database music;

use music;


#user表
drop table if exists tb_user;

create table tb_user(
	user_id int primary key auto_increment,
	username varchar(255) not null,
	password varchar(255) not null
	
);

select * from tb_user;


#管理员表
drop table if exists tb_admin;

create table tb_admin(
	user_id int primary key auto_increment,
	username varchar(255) not null,
	password varchar(255) not null

);

insert into tb_admin(username,password) values('7777777','wz521102..');

select * from tb_admin;


#音乐与user关联表
drop table if exists tb_relations;

create table tb_relations(
	id int primary key auto_increment,
	user_id int,
	music_id int
); 

select * from tb_relations;