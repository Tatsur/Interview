--ошибки в расписании
select * from
(select film_name as first_film_name, film_duration as first_film_duration, start_time,
    lead(film_name) over(order by start_time) as second_film_name, lead(film_duration) over(order by start_time) as second_film_duration,
    lead(start_time) over(order by start_time) as second_film_start_time,
	timestampdiff(MINUTE,start_time,lead(start_time) over(order by start_time))  as time_diff
from films
join sessions on idfilms = film_id
order by time_diff) as time_diff_table
where time_diff < first_film_duration;