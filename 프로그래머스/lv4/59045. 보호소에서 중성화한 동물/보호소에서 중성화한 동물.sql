-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME 
from ANIMAL_INS a INNER JOIN ANIMAL_OUTS o
on a.ANIMAL_ID = o.ANIMAL_ID
where not a.SEX_UPON_INTAKE = o.SEX_UPON_OUTCOME
order by a.ANIMAL_ID