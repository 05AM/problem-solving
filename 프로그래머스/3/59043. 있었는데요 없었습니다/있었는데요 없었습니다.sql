-- 코드를 입력하세요
SELECT ai.animal_id, ai.name
from animal_ins ai
join animal_outs ao using(animal_id)
where ai.datetime > ao.datetime
order by ai.datetime;