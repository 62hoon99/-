-- 코드를 입력하세요
SELECT A.PRODUCT_ID, B.PRODUCT_NAME, SUM(A.AMOUNT) * B.PRICE AS TOTAL_SALES
FROM FOOD_ORDER A
JOIN FOOD_PRODUCT B USING(PRODUCT_ID)
WHERE MONTH(A.PRODUCE_DATE) = 5
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC;