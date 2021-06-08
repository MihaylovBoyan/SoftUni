# ex.1

SELECT title FROM books
WHERE substring(title, 1, 3) = 'The'
ORDER BY id;

# ex.2

SELECT replace(title, 'The', '***') as title
FROM books
where substr(title, 1, 3) = 'The'
ORDER BY id;

# ex.3

SELECT round(SUM(cost),2)
FROM books;

# ex.4

SELECT concat_ws(' ', first_name, last_name),
 timestampdiff(day, born, died) as 'days lived'
 from authors;

# ex.5

SELECT title FROM books
WHERE title LIKE "%HARRY%" 
ORDER BY id;




