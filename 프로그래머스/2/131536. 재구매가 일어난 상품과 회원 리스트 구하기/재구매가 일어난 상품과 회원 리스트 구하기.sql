SELECT o.USER_ID, o.PRODUCT_ID 
FROM ONLINE_SALE o 
GROUP BY o.USER_ID, o.PRODUCT_ID
HAVING COUNT(o.USER_ID AND o.PRODUCT_ID) > 1
ORDER BY o.USER_ID ASC, o.PRODUCT_ID DESC;