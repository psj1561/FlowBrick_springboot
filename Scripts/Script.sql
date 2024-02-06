SELECT * 
FROM (SELECT rownum cnt, rsk.*
	  FROM (
			SELECT p.prjname, e.ename, r.*
			FROM risk r, fb_emp e, projectbasic p
			WHERE 1=1
			AND r.riskname like '%'||''||'%'
			AND e.ename like '%'||''||'%'
			AND r.empno = e.empno
			AND p.prjName like '%'||''||'%'
			AND r.prjNo = p.prjNo) rsk
			order by cnt DESC
)
where cnt BETWEEN 1 AND 3;

SELECT *
FROM ( SELECT rownum cnt, pb.*
		FROM (
			  SELECT *
			  FROM PROJECTBASIC
			  WHERE prjname LIKE '%'||''||'%'
			  ORDER BY prjno) pb
		)
WHERE cnt BETWEEN 1 AND 3;
	
SELECT * 
FROM (
	SELECT rownum cnt, r.*
	FROM risk r, fb_emp e, projectbasic p
	WHERE 1=1
	AND r.riskname like '%'||''||'%'
	AND e.ename like '%'||''||'%'
	AND r.empno = e.empno
	AND p.prjName like '%'||''||'%'
	AND r.prjNo = p.prjNo
	order by cnt DESC 
)
where cnt BETWEEN 1 AND 2

SELECT * FROM RISK;
SELECT * FROM PROJECTBASIC;
SELECT * FROM FB_EMP;
INSERT INTO RISK VALUES(RISK_SEQ.NEXTVAL, 2, 10035, '송금 시스템 오류', '은행 계좌 검색 시, 은행 정보가 나오지 않음', '매우 위험', 
						SYSDATE, TO_DATE('2024-06-06', 'YYYY-MM-DD'), '진행중');
					
SELECT * FROM NOTICEFILE;			
CREATE TABLE riskfile(
	riskno NUMBER REFERENCES RISK(riskno) NOT NULL,
	fname VARCHAR2(100) NOT NULL,
	path VARCHAR2(500) NOT NULL,
	regdte DATE NOT NULL,
	uptdte DATE NOT NULL,
	etc VARCHAR2(1000) NOT NULL
);
SELECT * FROM RISKFILE;
