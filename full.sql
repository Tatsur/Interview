BEGIN;

drop table if exists students CASCADE;
create table students (id bigserial PRIMARY KEY,name VARCHAR(255),mark int);
insert into students (name,mark) values
('John Doe',5),
('Tim Burton',4);

COMMIT;