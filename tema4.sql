create database orm1;

create table person(
id int primary key auto_increment,
username varchar(255),
email varchar(255)
);
select * from person;

create table user(
id int primary key auto_increment,
email varchar(255),
password varchar(255)
);
select * from user;

create database hibernate_demo;
select*from address;
select*From user;

create database masini_marca;
select*from marca_masina;
select*from masina1;
insert into products values(null, 'telefon samsung', 4000.00);
select *from products;
insert into product values(null, 'apple', 'iphone11', 3000.00);
insert into product values(null, 'apple', 'iphone13', 7000.00);
insert into product values(null, 'Samsung', 'A50', 2500.00);
insert into product values(null, 'Xiaomi', 'Redmi11', 1000.00);
select*from product
