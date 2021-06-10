# ex.1

select count(*) as `count`
from wizzard_deposits;

# ex.2

select magic_wand_size as `longest_magix_wand`
from wizzard_deposits
order by magic_wand_size DESC
limit 1;

select MAX(magic_wand_size)
from wizzard_deposits;

# ex.3

select deposit_group, max(magic_wand_size) as max_size
from wizzard_deposits
group by deposit_group
order by max_size, deposit_group;

# ex.4

select deposit_group
from wizzard_deposits
GROUP BY deposit_group
order by avg(magic_wand_size)
limit 1;

# ex.5

select deposit_group, sum(deposit_amount) as total_sum
from wizzard_deposits
GROUP BY deposit_group
ORDER BY total_sum;

# ex.6

select deposit_group, sum(deposit_amount)
from wizzard_deposits
where magic_wand_creator like '%ollivander%'
group by deposit_group
order by deposit_group;

# ex.7

select deposit_group, sum(deposit_amount) as total_sum
from wizzard_deposits
where magic_wand_creator = 'ollivander family'
group by deposit_group
having total_sum < 150000
order by total_sum desc;

# ex.8

select deposit_group, magic_wand_creator, min(deposit_charge)
from wizzard_deposits
group by deposit_group, magic_wand_creator
order by magic_wand_creator, deposit_group;

# ex.9

select(
	case
		when `age` between 0 and 10 then '[0-10]'
		when `age` between 11 and 20 then '[11-20]'
		when `age` between 21 and 30 then '[21-30]'
		when `age` between 31 and 40 then '[31-40]'
		when `age` between 41 and 50 then '[41-50]'
		when `age` between 51 and 60 then '[51-60]'
        else '[61+]'
    
    end
) as `age_group`, count(*) as wizard_count
from `wizzard_deposits`
group by age_group
order by age_group;

# ex.10

select substr(first_name, 1 ,1) as first_char
from wizzard_deposits
where deposit_group = 'Troll Chest'
group by first_char
order by first_char;

# ex.11

select deposit_group, is_deposit_expired, 
avg(deposit_interest) as avg_interest
from wizzard_deposits
where deposit_start_date > '1985-01-02'
group by deposit_group, is_deposit_expired
order by deposit_group desc, is_deposit_expired;

# ex. 12

select department_id, min(salary)
from employees
where hire_date > '2000-01-02'
and department_id IN (2,5,7)
group by department_id
order by department_id asc;

# ex.13

create table `hpe` as
select * from employees
where salary > 30000
and manager_id != 42;

update hpe
set salary = salary + 5000
where department_id = 1;

select department_id, avg(salary) as avg_salary
from hpe
group by department_id
order by department_id;


# ex.14

select department_id, max(salary) as max_salary
from employees
group by department_id
having max_salary > 70000 or max_salary < 30000
order by department_id;


# ex.15

select count(*)
from employees
where manager_id is null;

# ex.16

select e.`department_id`, (

select distinct e2.salary
from employees as e2
where e2.department_id = e.department_id
order by e2.salary desc
limit 1 offset 2

) as `ths`
from employees as e
group by e.department_id
having ths is not null
order by e.department_id;

# ex.17

select e.first_name, e.last_name, e.department_id 
from employees as e
where e.salary > 
(
select avg(e2.salary)
from employees as e2
where e2.department_id = e.department_id
) 
order by department_id, employee_id
limit 10;

# ex.18

select department_id, sum(salary)
from employees
group by department_id
order by department_id;










