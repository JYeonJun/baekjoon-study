SELECT f.FACTORY_ID, f.FACTORY_NAME, f.ADDRESS
FROM FOOD_FACTORY f
WHERE SUBSTRING_INDEX(f.ADDRESS, ' ', 1) = '강원도'
ORDER BY f.FACTORY_ID ASC;