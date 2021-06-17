# ex.1
create database football;
use football;

create table coaches 
(
id int primary key auto_increment,
first_name varchar(10) not null,
last_name varchar(20) not null,
salary decimal(10,2) not null,
coach_level int not null
);

create table countries
(
id int primary key auto_increment,
`name` varchar(45) not null
);

create table towns
(
id int primary key auto_increment,
`name` varchar(45) not null,
country_id int,
constraint fk_towns_countries
foreign key (country_id)
references countries(id)
);

create table stadiums
(
id int primary key auto_increment,
`name` varchar(45) not null,
capacity int not null,
town_id int,
constraint fk_stadiums_towns
foreign key (town_id)
references towns(id)
);

create table teams 
(
id int primary key auto_increment,
`name` varchar(45) not null,
established date not null,
fan_base bigint not null,
stadium_id int,
constraint fk_teams_stadiums
foreign key (stadium_id)
references stadiums(id)
);

create table skills_data
(
id int primary key auto_increment,
dribbling int,
pace int,
passing int,
shooting int,
speed int,
strength int 
);

create table players
(
id int primary key auto_increment,
first_name varchar(10) not null,
last_name varchar(20) not null,
age int not null,
position char(1) not null,
salary decimal(10,2) not null,
hire_date datetime,
skills_data_id int,
team_id int,
constraint fk_players_skills_data
foreign key (skills_data_id)
references skills_data(id),
constraint fk_players_teams
foreign key (team_id)
references teams(id)
);

create table players_coaches
(
player_id int,
coach_id int,
constraint pk_players_coaches
primary key (player_id, coach_id),
constraint pf_players_coaches_players
foreign key (player_id)
references players(id),
constraint fk_players_coaches_coaches
foreign key (coach_id)
references coaches(id)
);	

# ex.2

insert into coaches (first_name, last_name, salary, coach_level)
select first_name, last_name, salary, char_length(first_name)
from players
where age >= 45;

# ex.3

update coaches as c
join players_coaches as pc
on c.id = pc.coach_id
set coach_level = coach_level + 1
where first_name like 'A%';

# ex.4

delete from players
where  age >= 45;

# ex.5

select first_name, age, salary
from players
order by salary desc;

# ex.6

select p.id, concat_ws(' ', first_name, last_name) as full_name, p.age, p.`position`, p.hire_date
from players as p
join skills_data as sd
on p.skills_data_id = sd.id
where position = 'A'
and p.hire_date is null
and p.age < 23
and sd.strength > 50
order by salary, age; 

# ex.7

select t.`name`, t.established, t.fan_base, 
(select count(*) from players where team_id = t.id) as cnt
from teams as t
order by cnt desc, fan_base desc;

# ex.8

select max(sd.speed) as max_speed, ts.`name` as town_name 
from players as p
join skills_data as sd
on skills_data_id = sd.id
right join teams as t
on t.id = team_id
join stadiums as s
on s.id = t.stadium_id
join towns as ts
on ts.id = s.town_id
where t.`name` != 'Devify'
group by ts.`name`
order by max_speed desc, ts.`name`;

# ex.9

select countries.name, count(players.id) as total_count_of_players,  sum(salary) as total_sum_of_salaries
from players
right join teams 
on teams.id = players.team_id
join stadiums
on stadiums.id = teams.stadium_id
join towns
on towns.id = stadiums.town_id
right join countries
on countries.id = towns.country_id
group by countries.name
order by total_count_of_players desc, countries.name;

# ex.10

delimiter $$
create function udf_stadium_players_count (stadium_name VARCHAR(30)) 
returns varchar(30)
deterministic
begin
	return (select count(*)
    from players as p
	join teams as t
    on t.id = p.team_id
    join stadiums as s
    on s.id = t.stadium_id
    where s.name = stadium_name);
   
end $$
delimiter ;

select udf_stadium_players_count('Jaxworks');
SELECT udf_stadium_players_count ('Linklinks') as `count`; 

select count(*)
    from players as p
	join teams as t
    on t.id = p.team_id
    join stadiums as s
    on s.id = t.stadium_id
    where s.name = 'JaxWorks';



