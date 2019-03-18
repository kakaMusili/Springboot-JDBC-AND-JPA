/*create table person(
  id  integer(10) not null ,
  name varchar(255) not null ,
  location varchar(255),
  birth_date timestamp,
                   primary key (id)
);*/

insert into person
(id,name,location,birth_date)
values(10001,'musili','nairobi',sysdate());
insert into person
(id,name,location,birth_date)
values(10002,'joseph','malindi',sysdate());
insert into person
(id,name,location,birth_date)
values(10003,'muthui','kenya',sysdate())