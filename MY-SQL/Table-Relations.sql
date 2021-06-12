# ex.1

create table `mountains`(
id int primary key auto_increment,
name varchar(40)
);

create table peaks(
id int primary key auto_increment,
name varchar(40),
mountain_id int
);

alter table peaks
add constraint fk_peaks_mountains 
foreign key (mountain_id)
references peaks(id);

# ex.2

select c.id as driver_id, v.vehicle_type, CONCAT(first_name, ' ', last_name)
from campers as c
join vehicles as v
on v.driver_id = c.id;

# ex.3

select r.starting_point, 
r. end_point, r.leader_id, concat(c.first_name, ' ', last_name) as `leader_name`
from routes as r
join campers as c
on r.leader_id = c.id;

# ex.4

create table `mountains`(
id int primary key auto_increment,
name varchar(40)
);

create table peaks(
id int primary key auto_increment,
name varchar(40),
mountain_id int
);

alter table peaks
add constraint fk_peaks_mountains 
foreign key (mountain_id)
references mountains(id)
on delete cascade;


insert into mountains(id,name) values(1,"Pirin"),(2,"Rila");
insert into peaks(id,name,mountain_id) values(1, "Vihren",1),(2, "Kutelo",1),(4, "Musala",2);
delete from mountains where id = 1;
select * from peaks;

# ex.5

create table clients
(
id int primary key auto_increment,
client_name varchar(100)
);

create table projects 
(
id int primary key auto_increment,
client_id INT,
project_lead_id int,
constraint fk_projects_clients
foreign key (client_id)
references clients(id) 
);


create table employees
(
id int primary key auto_increment,
f_name varchar(50),
l_name varchar(50),
project_id int,
constraint fk_emp_proj
foreign key (project_id)
references projects(id)
);


alter table projects
add constraint fk_projects_emp
foreign key (project_lead_id)
references employees(id);




