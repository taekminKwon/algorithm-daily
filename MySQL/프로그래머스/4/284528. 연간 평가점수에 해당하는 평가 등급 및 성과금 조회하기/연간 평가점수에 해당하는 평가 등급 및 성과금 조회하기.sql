-- 코드를 작성해주세요
SELECT EMP_NO, EMP_NAME, GRADE, (CASE
        WHEN GRADE = 'S' THEN SAL * 0.2
        WHEN GRADE = 'A' THEN SAL * 0.15
        WHEN GRADE = 'B' THEN SAL * 0.1
        ELSE 0
    END) AS BONUS
FROM
    (SELECT 
        E.EMP_NO,
        E.EMP_NAME,
        (CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END) AS GRADE,
        SAL
    FROM HR_GRADE G
    JOIN HR_EMPLOYEES E
    ON G.EMP_NO = E.EMP_NO
    GROUP BY EMP_NO) AS T
ORDER BY EMP_NO