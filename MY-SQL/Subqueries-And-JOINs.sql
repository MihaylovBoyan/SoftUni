# ex.1

select e.employee_id, concat(e.first_name, ' ', e.last_name), d.department_id, d.name
from departments as d
left join employees as e
on d.manager_id = e.employee_id
order by employee_id
limit 5;

# ex.2

select t.town_id, t.name, a.address_text
from addresses as a
left join towns as t
on t.town_id = a.town_id
where t.`name` in ('San Francisco', 'Sofia', 'Carnation')
order by t.town_id, a.address_id;

# ex.3

select employee_id, first_name, last_name, department_id, salary
from employees
where manager_id is null;

# ex. 4

select count(*) 
from employees
where salary > (select avg(salary) from employees);