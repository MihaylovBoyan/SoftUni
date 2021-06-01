# ex.1

SELECT *
FROM departments
ORDER BY department_id;

# ex.2 

SELECT `name` FROM departments
ORDER BY department_id;

# ex.3

SELECT first_name, last_name, salary 
FROM employees
ORDER BY employee_id;

# ex.4

SELECT first_name, middle_name, last_name 
FROM employees
ORDER BY employee_id;

# ex.5

SELECT concat(first_name, '.', last_name, '@', 'softuni.bg') 
AS full_email_address
FROM employees;

# ex.6

SELECT DISTINCT salary
FROM employees
ORDER BY employee_id;

# ex.7

SELECT * FROM employees
WHERE job_title = 'Sales Representative'
ORDER BY employee_id;

# ex.8

SELECT first_name, last_name, job_title
FROM employees
WHERE salary BETWEEN 20000 AND 30000
ORDER BY employee_id;

# ex.9

SELECT CONCAT_WS(' ', first_name, middle_name, last_name) 
AS 'Full Name' 
FROM employees
WHERE salary IN (25000,14000,12500,23600);

# ex. 10

SELECT first_name, last_name FROM employees
WHERE manager_id IS NULL;

# ex. 11

SELECT first_name, last_name, salary 
FROM employees
WHERE salary > 50000
ORDER BY salary desc;

# ex.12

SELECT first_name, last_name 
FROM employees
ORDER BY salary DESC
LIMIT 5;

# ex.13

SELECT first_name, last_name
FROM employees
WHERE department_id != 4;

# ex.14

SELECT * FROM employees
ORDER BY salary DESC, first_name,
last_name DESC, middle_name;


# ex.15

CREATE VIEW v_employees_salaries AS
SELECT first_name, last_name, salary
FROM employees;

# ex.16

CREATE VIEW v_employees_job_titles AS 
SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS full_name, job_title
FROM employees;


# ex.17

SELECT DISTINCT job_title
FROM employees
ORDER BY job_title;

# ex.18

SELECT * FROM projects
ORDER BY start_date, `name`, project_id
LIMIT 10;

# ex.19

SELECT first_name, last_name, hire_date
FROM employees
ORDER BY hire_date DESC
LIMIT 7;

# ex.20

UPDATE employees
SET salary = salary * 1.12
WHERE department_id IN (1,2,4,11);

# ex.21

SELECT peak_name FROM peaks
ORDER BY peak_name;

# ex.22

SELECT country_name, population
FROM countries
WHERE continent_code = 'EU'
ORDER BY population DESC, country_name
LIMIT 30;

# ex.23

SELECT country_name, country_code,
IF(currency_code = 'EUR', 'Euro', 'Not Euro')
FROM countries
ORDER BY country_name;

# ex.24

SELECT  `name`
FROM characters
ORDER BY `name`;




