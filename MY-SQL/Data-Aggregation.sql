# ex.1

select department_id, count(id) as `Number of employees`
from employees
group by department_id
order by department_id, `Number of employees`;

# ex.2

select department_id,
ROUND(AVG(salary), 2) as `Average`
from employees
group by department_id
order by department_id;

# ex.3

select department_id,
round(MIN(salary), 2) as `Min salary`
from employees
group by department_id
having `Min salary` > 800;

# ex.4

select count(*) as `count`
from products
where category_id = 2
and price > 8;

# ex.5

select category_id, round(avg(price),2) as `Average Price`,
round(min(price),2) as `Cheapeset Product`,
round(max(price),2) as `Most Expensive Product`
from products
group by category_id;
