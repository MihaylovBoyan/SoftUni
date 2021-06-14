# ex.1

select e.employee_id,  e.job_title, a.address_id, a.address_text
from employees as e
join addresses as a
on e.address_id = a.address_id
order by address_id
limit 5;	

# ex.2

select e.first_name, e.last_name, t.name, a.address_text
from employees as e
join addresses as a
on a.address_id = e.address_id
join towns as t
on t.town_id = a.town_id
order by e.first_name, e.last_name
limit 5;

# ex.3

select e.employee_id, e.first_name, e.last_name, d.name
from employees as e
join departments as d
on d.department_id = e.department_id
where d.name = 'Sales'
order by e.employee_id desc;

# ex.4

select e.employee_id, e.first_name, e.salary, d.name
from employees as e
join departments as d
on d.department_id = e.department_id
where e.salary > 15000
order by d.department_id desc
limit 5;

# ex.5

select e.employee_id, e.first_name
from employees as e
left join employees_projects as ep
on e.employee_id = ep.employee_id 
where ep.project_id is null
order by e.employee_id desc
limit 3;

# ex.6

select e.first_name, e.last_name, e.hire_date, d.name
from employees as e
join departments as d
on e.department_id = d.department_id
where d.name = 'Finance' OR d.name = 'Sales'
and e.hire_date > 1999-01-01
order by e.hire_date;

# ex.7

select e.employee_id, e.first_name, p.name
from employees as e
join employees_projects as ep
on e.employee_id = ep.employee_id
join projects as p
on p.project_id = ep.project_id
where DATE(p.start_date) > '2002-08-13'
and p.end_date is null
order by e.first_name, p.name
limit 5;

# ex.8

select e.employee_id, e.first_name, if(year(p.start_date) > 2004, null, p.name)
from employees as e
join employees_projects as ep
on e.employee_id = ep.employee_id
join projects as p
on p.project_id = ep.project_id
where e.employee_id = 24
order by p.name
limit 5;

# ex.9

select e.employee_id, e.first_name, e.manager_id, m.first_name
from employees as e
join employees as m
on e.manager_id = m.employee_id
where e.manager_id IN (3, 7)
order by e.first_name;

# ex.10

select e.employee_id, 
concat_ws(' ',e.first_name, e.last_name) as emp_name, 
concat_ws(' ',m.first_name, m.last_name) as manager_name,
d.name
from employees as e
join employees as m
on e.manager_id = m.employee_id
join departments as d
on e.department_id = d.department_id
order by e.employee_id
limit 5;

# ex.11

select department_id, avg(salary) as avs
from employees
group by department_id
order by avs
limit 1;

# ex.12

select c.country_code, m.mountain_range, p.peak_name, p.elevation
from countries as c
join mountains_countries as mc
on c.country_code = mc.country_code
join mountains as m
on mc.mountain_id = m.id
join peaks as p
on p.mountain_id = m.id
where c.country_code = 'BG'
and p.elevation > 2835
order by p.elevation desc;

# ex.13

select mc.country_code, count(m.id) as m_count
from mountains as m
join mountains_countries as mc
on mc.mountain_id = m.id
where mc.country_code in ('BG', 'RU', 'US')
group by mc.country_code
order by m_count desc;

# ex.14

select c.country_name, r.river_name
from countries as c
left join countries_rivers as cr
on c.country_code = cr.country_code
left join rivers as r
on cr.river_id = r.id
where c.continent_code = 'AF'
order by country_name
limit 5;

# ex.16

select count(*)
from countries as c
left join mountains_countries as mc
on c.country_code = mc.country_code
left join mountains as m
on  mc.mountain_id = m.id
where mc.mountain_id is null;

# ex.17

select c.country_name, MAX(p.elevation) as m_elevation,
 MAX(r.length) as m_length
from countries as c
join countries_rivers as cr
on cr.country_code = c.country_code
join rivers as r
on r.id = cr.river_id
join mountains_countries as mc
on c.country_code = mc.country_code
join mountains as m
on mc.mountain_id = m.id
join peaks as p
on p.mountain_id = m.id
group by c.country_code
order by m_elevation desc, m_length desc, 
c.country_name
limit 5;








