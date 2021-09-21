--ошибки в расписании
select *
from (select film_name                                                                      as first_film_name,
             film_duration                                                                  as first_film_duration,
             start_time,
             lead(film_name) over (order by start_time)                                     as second_film_name,
             lead(film_duration) over (order by start_time)                                 as second_film_duration,
             lead(start_time) over (order by start_time)                                    as second_film_start_time,
             timestampdiff(MINUTE, start_time, lead(start_time) over (order by start_time)) as time_diff
      from films
               join sessions on idfilms = film_id
      order by time_diff) as time_diff_table
where time_diff < first_film_duration;

--статистика по каждому фильму/итого
CREATE
OR REPLACE
VIEW `dt` as
select film_name         as 'film name',
       sum(sessions_sum) as profit,
       sum(seats_sum)    as visitors,
       avg(seats_sum)    as avg_visitors
from films f
         left join (select sum(price) sessions_sum, count(idsessions) seats_sum, idsessions, film_id
                    from sessions
                             join orders on idsessions = session_id
                    group by idsessions) as sum_table
                   on idfilms = film_id
group by film_name
ORDER BY profit DESC;
(
select *
from dt)
union
(
select "total" as film_name,
    sum(profit) as profit,
    sum(visitors) as visitors,
    avg(avg_visitors) as visitors
from dt);

--посетители и сборы по времени начала фильма
CREATE
OR REPLACE
view `sessions_view` as
select sum(price) sessions_sum, count(idsessions) seats_sum, idsessions, start_time
from sessions
         join orders on idsessions = session_id
group by idsessions;

(
select "from 9 to 15" as time_period, sum(sessions_sum) as profit, sum(seats_sum) as visitors
from sessions_view
where hour(start_time) >= 9 && (hour(start_time)<15))
union
(
select "from 15 to 18" as time_period, sum(sessions_sum) as profit, sum(seats_sum) as visitors
from sessions_view
where hour(start_time)>=15 && (hour(start_time)<18))
union
(
select "from 18 to 21" as time_period, sum(sessions_sum) as profit, sum(seats_sum) as visitors
from sessions_view
where hour(start_time)>=18 && (hour(start_time)<21))
union
(
select "from 21 to 24" as time_period, sum(sessions_sum) as profit, sum(seats_sum) as visitors
from sessions_view
where hour(start_time)>=21 && (hour(start_time)<24))