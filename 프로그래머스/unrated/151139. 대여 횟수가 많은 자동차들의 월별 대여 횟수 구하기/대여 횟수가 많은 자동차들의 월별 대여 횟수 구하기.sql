-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN
(SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
 WHERE MONTH(START_DATE) BETWEEN 8 AND 10
 GROUP BY CAR_ID HAVING COUNT(*) >= 5)
GROUP BY CAR_ID, MONTH(START_DATE)
HAVING RECORDS > 0 AND MONTH BETWEEN 8 AND 10
ORDER BY MONTH(START_DATE) ASC, CAR_ID DESC;