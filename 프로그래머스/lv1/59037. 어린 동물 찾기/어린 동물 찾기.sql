-- 코드를 입력하세요
# SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE INTAKE_CONDITION != "Aged" ORDER ANIMAL_ID;

select animal_id, name from animal_ins where intake_condition != "Aged" order by animal_id;