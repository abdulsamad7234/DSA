# Write your MySQL query statement below
SELECT firstName, lastName, NULLIF(city, '') AS city, NULLIF(state, '') AS state FROM Person p LEFT JOIN Address a ON p.personId = a.personId;