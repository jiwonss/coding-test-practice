-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (NOT GENOTYPE & 2) AND ((GENOTYPE & 1) OR (GENOTYPE & 4));