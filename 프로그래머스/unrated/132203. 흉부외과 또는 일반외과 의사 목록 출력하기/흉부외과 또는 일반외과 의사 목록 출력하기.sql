SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS' -- 진료과가 흉부외과(CS)이거나 일반외과(GS)
ORDER BY 4 DESC, 1 ASC;
