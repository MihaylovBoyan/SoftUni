# ex.1 
delimiter $$
CREATE FUNCTION `ufn_count_employees_by_town` (town_name_param varchar(45))
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN (select count(*)
from employees as e
join addresses as a
using(address_id)
join towns as t
using(town_id)
where t.name = town_name_param
group by t.name);

END $$
delimiter ;

# ex.2
delimiter $$
create procedure usp_raise_salaries(dep_name VARCHAR(40))
begin

update employees
join departments as d
using(department_id)
set salary = salary * 1.05
where d.`name` = dep_name;

end $$
delimiter ;

# ex.3
delimiter $$
CREATE PROCEDURE `usp_raise_salary_by_id` (emp_id int)
BEGIN

update employees
set salary = salary * 1.05
where employee_id = emp_id;

END $$
delimiter ;

# ex.4

CREATE TABLE deleted_employees(

employee_id INT PRIMARY KEY AUTO_INCREMENT,

first_name VARCHAR(20),

last_name VARCHAR(20),

middle_name VARCHAR(20),

job_title VARCHAR(50),

department_id INT,

salary DOUBLE

);

delimiter $$
create trigger tr_deleted_employees
after delete
on employees
for each row
begin
	insert into deleted_employees(first_name, last_name,
    middle_name, job_title, department_id, salary)
    
    values(old.first_name, old.last_name, old.middle_name,
    old.job_title, old.department_id, old.salary);
end $$
delimiter ;


DELETE FROM employees WHERE employee_id IN (1);

