-- 페이지 수를 구하는 쿼리
select ROUND(count(*)/5+0.499999,0)
from member
;
-- rownum 구한뒤
-- 페이지당 회원의 id 만 보여주는 쿼리
SELECT B.*
FROM (
SELECT 
	ROWNUM NO,
	A.*
FROM (
	SELECT MEM_ID
	FROM MEMBER
	) A
ORDER BY NO DESC
) B
WHERE B.NO BETWEEN 1 AND 5  <!-- 시작번호 1+(page-1)*5/끝번호 page*5 -->
;

-----
SELECT T.*
FROM (SELECT ROWNUM SEQ, M.*
FROM MEMBER M
ORDER BY SEQ DESC
) T
WHERE T.SEQ BETWEEN 1 AND 5
;
