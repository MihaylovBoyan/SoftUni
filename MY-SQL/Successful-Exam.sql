# ex.1

create table addresses
(
id int primary key auto_increment,
`name` varchar(100) not null
);

create table categories
(
id int primary key auto_increment,
`name` varchar(10) not null
);


create table clients
(
id int primary key auto_increment,
`full_name` varchar(50) not null,
phone_number varchar(20) not null
);


create table drivers
(
id int primary key auto_increment,
`first_name` varchar(30) not null,
`last_name` varchar(30) not null,
age int not null,
rating float default 5.5
);

create table cars
(
id int primary key auto_increment,
make varchar(20) not null,
model varchar(20),
`year` int not null default 0,
mileage int default 0,
`condition` char(1) not null,
category_id int not null,
constraint fk_cars_categories
foreign key (category_id)
references categories(id)
);


create table courses
(
id int primary key auto_increment,
from_address_id int not null,
start datetime not null,
car_id int not null,
client_id int not null,
bill decimal(10,2) default 10,
constraint fk_courses_addresses
foreign key (from_address_id)
references addresses(id),
constraint fk_courses_cars
foreign key (car_id)
references cars(id),
constraint fk_courses_client
foreign key (client_id)
references clients(id)
);


create table cars_drivers
(
car_id int not null,
driver_id int not null,
constraint fk_cars_drivers
primary key (car_id, driver_id),
constraint fk_cd_cars
foreign key (car_id)
references cars(id),
constraint fk_cd_drivers
foreign key (driver_id)
references drivers(id)
);


# ex.2

insert into clients (full_name, phone_number)
select concat_ws(' ', d.first_name, d.last_name) as full_name, concat('(088) 9999', d.id * 2) as phone_number
from drivers as d
where d.id between 10 and 20;


select * from clients;

# ex.3

update cars
set `condition` = 'C'
where mileage >= 80000 or
mileage is null
and year <= 2010
and make not in('Mercedes-Benz');

# ex.4

delete from clients 
where char_length(full_name) > 3
and id not in(select client_id from courses);

# ex.5

select make, model, `condition`
from cars
order by id;

# ex.6

select d.first_name, d.last_name, c.make, c.model, c.mileage
from drivers as d
join cars_drivers as cd
on cd.driver_id = d.id
join cars as c
on c.id = cd.car_id
where c.mileage is not null
order by mileage desc, first_name;

# ex.7

select c.id, c.make, c.mileage, count(co.id) as cnt, round(avg(co.bill),2)
from cars as c
left join courses as co
on c.id = co.car_id
group by c.id
having count(co.id) != 2
order by cnt desc, c.id;

# ex.8

select c.full_name, count(ca.id) as cnt, sum(bill) as sum
from clients as c 
join courses as co
on c.id = co.client_id
join cars as ca
on co.car_id = ca.id
where full_name like '_a%'
group by c.id
having count(ca.id) > 1
order by c.full_name;

# ex.9
select a.`name`,  c.bill, cli.full_name, ca.make, ca.model, cat.`name`
from courses as c
join addresses as a 
on a.id = c.from_address_id
join cars as ca
on ca.id = c.car_id
join categories as cat
on cat.id = ca.category_id
join clients as cli
on cli.id = c.client_id
group by c.id
order by c.id;

(if select hour(c.`start`) between 6 and 20, then 'Day', 'Night' );

# ex.10

delimiter $$
create function udf_courses_by_client (phone_num VARCHAR (20)) 
returns varchar(20)
deterministic
begin

return (select count(co.id) from clients as c
join courses as co
on c.id = co.client_id
where phone_number = phone_num
group by c.id);


end $$
delimiter ;


select count(co.id) from clients as c
join courses as co
on c.id = co.client_id
where phone_number = '(803) 6386812'
group by c.id;

# ex.11

delimiter $$
create procedure udp_courses_by_address(address_name varchar(100)) 
begin
select a.`name`,  cli.full_name, (select (
		case
        when c.bill <= 20
        then 'Low'
		when c.bill <=30 and c.bill > 20
        then 'Medium'
        else 'High'
        end
        )), ca.make, ca.`condition`, cat.`name`
from addresses as a
join courses as c
on c.from_address_id = a.id
join clients as cli
on cli.id = c.client_id
join cars as ca
on ca.id = c.car_id
join categories as cat
on cat.id = ca.category_id
where a.name = address_name
order by ca.make, cli.full_name;

end $$
delimiter ;




