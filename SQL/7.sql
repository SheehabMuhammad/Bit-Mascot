/*
1. This will return the name of names with their frequency
*/

SELECT name, COUNT(name) AS Frequency from employees GROUP BY name ORDER BY COUNT(name) DESC;


/*
1. This will return the name of 1 most frequent employee
*/

SELECT name from employees GROUP BY name ORDER BY COUNT(name) DESC LIMIT 1;


/*
1. This will return the names of 2 most frequent employee
*/
SELECT name from employees GROUP BY name ORDER BY COUNT(name) DESC LIMIT 2;