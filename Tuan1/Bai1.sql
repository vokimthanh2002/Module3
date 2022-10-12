use baitap;
create table Class(
id int primary key not null,
name varchar(30) not null
);
create table Teacher(
id int primary key not null,
name varchar(30) not null,
age int not null,
country varchar(100) not null
);

insert into Teacher
values(1,"vo kim thanh",12,"Quang Nam"),
      (2,"vo kim thanh",12,"Quang Nam"),
      (3,"vo kim thanh",12,"Quang Nam"),
      (4,"vo kim thanh",12,"Quang Nam");
insert into Class
values(1,"vo kim thanh"),
      (2,"vo kim thanh"),
      (3,"vo kim thanh"),
      (4,"vo kim thanh");
select * from Teacher;
select * from Class;

drop table Teacher;
drop table Class;
  
