create database softuni;
use softuni;

create table pictures
(
id int primary key auto_increment,
url varchar(100) not null,
added_on datetime not null
);

create table categories
(
id int primary key auto_increment,
`name` varchar(40) not null unique
);

create table products
(
id int primary key auto_increment,
`name` varchar(40) not null unique,
best_before date,
price decimal(10,2) not null,
description text,
category_id int not null,
picture_id int not null,
constraint fk_products_pictures
foreign key (picture_id)
references pictures(id),
constraint fk_products_categories
foreign key (category_id)
references categories(id)
);

create table towns
(
id int primary key auto_increment,
`name` varchar(20) not null unique
);

create table addresses
(
id int primary key auto_increment,
`name` varchar(50) not null unique,
town_id int not null,
constraint fk_addresses_towns
foreign key (town_id)
references towns(id)
);

create table stores
(
id int primary key auto_increment,
`name` varchar(20) not null,
rating float not null,
has_parking tinyint(1),
address_id int
);

alter table stores
add CONSTRAINT fk_stores_addresses
foreign key (address_id)
references addresses(id);

create table products_stores
(
product_id int not null,
store_id int not null,
constraint pk_products_stores
primary key (product_id, store_id),
constraint fk_product_stores_stores
foreign key (product_id)
references stores(id),
constraint fk_products_stores_products
FOREIGN KEY (store_id)
references products(id)
);

create table employees
(
id int primary key auto_increment,
first_name varchar(15) not null,
middle_name char(1),
last_name varchar(20) not null,
salary decimal(19,2) not null default 0,
hire_date date not null,
manager_id int,
store_id int not null,
constraint fk_employees_stores
foreign key (store_id)
references stores(id),
constraint fk_employees_empoyees
foreign key (manager_id)
references employees(id)
);

# ex.2

insert into products_stores
select p.id, 1 from products as p
left join products_stores as ps
on ps.product_id = p.id
where store_id is null;

/*insert into products_stores
select p.id, 1
from products as p
where p.id not in
(select ps.product_id from products_stores as ps);
*/

# ex.3

update employees as e
join stores as s
on s.id = e.store_id
set e.salary = e.salary - 500, manager_id = 3
where year(hire_date) > 2003
and s.`name` not in ('Cardguard', 'Veribet');

/*
update employees as e
set e.salary = e.salary - 500, manager_id = 3
where year(hire_date) > 2003
and e.store_id not in (select s.id from stores as s where s.name in ('Veribet','Cardguard'));
*/

# ex.4

delete from employees
where manager_id is not null 
and salary >= 6000;

# ex.5

select first_name, middle_name, last_name, salary, hire_date
from employees 
order by hire_date desc;

# ex.6 

select p.`name`, p.price, p.best_before, (select concat(substr(p.description , 1, 10), '...')) as short_description, pic.url
from products as p
join pictures as pic
on pic.id = p.picture_id
where char_length(p.`description`) > 100
and year(pic.added_on) < 2019
and p.price > 20
order by p.price desc;

# ex.7

select s.`name`, count(p.id) as cnt, round(avg(p.price),2)  as `avg`
from stores as s
left join products_stores as ps
on s.id = ps.store_id
left join products as p
on p.id = ps.product_id
group by s.`name`
order by cnt desc, `avg` desc, s.id;

# ex.8

select concat_ws(' ', e.first_name, e.last_name) as full_name,
s.`name`, a.`name`, e.salary
from employees as e
join stores as s
on s.id = e.store_id
join addresses as a
on a.id = s.address_id
where e.salary < 4000
and a.`name` like '%5%'
and char_length(s.`name`) > 8
and e.last_name like '%n';

# ex.9

select reverse(s.`name`) as reversed_name,
concat_ws('-', UPPER(t.`name`), a.`name`) as full_address,
count(e.id)
from employees as e
join stores as s
on s.id = e.store_id
join addresses as a
on a.id = s.address_id
join towns as t
on t.id = a.town_id
group by s.id
order by full_address asc;

# ex.10

delimiter $$
create function udf_top_paid_employee_by_store(store_name VARCHAR(50))
returns varchar(50)
deterministic
begin
	return (select concat(e.first_name, " ", e.middle_name, ". ", e.last_name, " ", 'works in store for', " ", (select  2020 - EXTRACT(YEAR FROM hire_date))," ", 'years') as full_info
from employees as e
join stores as s
on s.id = e.store_id
where s.`name` = store_name
order by e.salary desc
limit 1);
	

end $$
delimiter ;

SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';
SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';

# ex.11

delimiter $$
create procedure udp_update_product_price (address_name VARCHAR (50))
begin
	
	declare increase_level int;
    if address_name like '0%' then set increase_level = 100;
    else set increase_level = 200;
    end if;
    
     update products  as p
    set price = price + increase_level
    where p.id in (
		select ps.product_id from addresses a
        join stores as s on a.id = s.address_id 
        join products_stores as ps on ps.store_id = s.id
        where a.name = address_name
    );
    
end $$
delimiter ;

    update products as p
    set price = price + increase_level
    where p.id in (
		select ps.product_id from addresses a
        join stores as s on a.id = s.address_id = s.id
        join products_stores as ps on ps.store_id = s.id
        where a.name = address_name
    );

    