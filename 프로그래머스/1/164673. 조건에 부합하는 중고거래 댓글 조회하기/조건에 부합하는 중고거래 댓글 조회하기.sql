SELECT u.TITLE, u.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
FROM USED_GOODS_BOARD u JOIN USED_GOODS_REPLY r
ON u.BOARD_ID = r.BOARD_ID
WHERE DATE_FORMAT(u.CREATED_DATE, "%Y-%m") = '2022-10'
ORDER BY r.CREATED_DATE ASC, u.TITLE ASC;