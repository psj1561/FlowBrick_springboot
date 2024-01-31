package com.web.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.web.spring.vo.Wizet_PrjList;
import com.web.spring.vo.Wizet_PrjStep;

@Mapper
public interface Dao_Dashboard {
	
	// 모든 프로젝트 진행도
	@Select("SELECT\r\n"
			+ "		COUNT(*) AS pj,\r\n"
			+ "		COUNT(CASE WHEN PRJSTEP = '완료' THEN 1 END) AS complete,\r\n"
			+ "		COUNT(CASE WHEN PRJSTEP = '개발' THEN 1 END) AS develop,\r\n"
			+ "		COUNT(CASE WHEN PRJSTEP = '설계' THEN 1 END) AS design,\r\n"
			+ "		COUNT(CASE WHEN PRJSTEP = '테스트' THEN 1 END) AS test,\r\n"
			+ "		COUNT(CASE WHEN PRJSTEP = '디버깅' THEN 1 END) AS debug\r\n"
			+ "	FROM projectbasic")
	Wizet_PrjStep getAllPrjStep();
	
	// 해당인원의 프로젝트 진행도
	@Select("SELECT\r\n"
			+ "	COUNT(*) AS pj,\r\n"
			+ "	COUNT(CASE WHEN PRJSTEP = '완료' THEN 1 END) AS complete,\r\n"
			+ "	COUNT(CASE WHEN PRJSTEP = '개발' THEN 1 END) AS develop,\r\n"
			+ "	COUNT(CASE WHEN PRJSTEP = '설계' THEN 1 END) AS design,\r\n"
			+ "	COUNT(CASE WHEN PRJSTEP = '테스트' THEN 1 END) AS test,\r\n"
			+ "	COUNT(CASE WHEN PRJSTEP = '디버깅' THEN 1 END) AS debug\r\n"
			+ "	FROM (\r\n"
			+ "		SELECT pb.*\r\n"
			+ "		FROM PROJECTBASIC pb, PROJECTTEAM pt, TEAMMATE tm\r\n"
			+ "		WHERE 1=1\r\n"
			+ "		AND pb.PRJNO = pt.PRJNO\r\n"
			+ "		AND pt.TEAMNO = tm.TEAMNO\r\n"
			+ "		AND tm.EMPNO = #{empno}\r\n"
			+ "		)")
	Wizet_PrjStep getPrjStep(int empno);
	
	// 로그인한 사람의 프로젝트 목록
	@Select("SELECT pb.*, pt.TEAMNAME\r\n"
			+ "	FROM PROJECTBASIC pb, PROJECTTEAM pt, TEAMMATE tm\r\n"
			+ "	WHERE 1=1\r\n"
			+ "	AND pb.PRJNO = pt.PRJNO\r\n"
			+ "	AND pt.TEAMNO = tm.TEAMNO\r\n"
			+ "	AND tm.EMPNO = #{empno}")
	List<Wizet_PrjList> getPrjList(int empno);
	
}
