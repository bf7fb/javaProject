drop database if exists college;

create database college;

use college;

drop table if exists dorm;

create table dorm(
	dorm_id int primary key auto_increment,
	dorm_name varchar(255)
);

insert into dorm(dorm_name) values("静苑404");

insert into dorm(dorm_name) values("静苑104");

insert into dorm(dorm_name) values("静苑204");

insert into dorm(dorm_name) values("静苑304");

insert into dorm(dorm_name) values("静苑504");

select * from dorm;

drop table if exists student;

create table student(
	stu_id int primary key auto_increment,
	stu_name varchar(255),
	stu_sex varchar(255),
	stu_age int,
	stu_class varchar(255),
	stu_num varchar(255),
	stu_photo varchar(255),
	stu_dorm_id int,
	foreign key(stu_dorm_id) references dorm(dorm_id)

);

insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_dorm_id) values('王振','男','19','软工一班','2107361139',1);

insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_dorm_id) values('李俊','男','19','软工一班','2107361129',1);

insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_dorm_id) values('郑义军','男','19','软工一班','2107361114',1);

insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_dorm_id) values('龚超','男','19','软工一班','2107361122',1);

insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_dorm_id) values('田浩宇','男','19','软工一班','2107361135',1);

insert into student(stu_name,stu_sex,stu_age,stu_class,stu_num,stu_dorm_id) values('去腾飞','男','19','软工一班','2107361137',1);

select * from student;