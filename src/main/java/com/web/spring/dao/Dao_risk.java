package com.web.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.ProjectTeam;
import com.web.spring.vo.Risk;
import com.web.spring.vo.RiskSch;
import com.web.spring.vo.TeamMate;

@Mapper
public interface Dao_risk {
	// 총 리스크 건수
	public int cntRisk(RiskSch sch);
	
	// 리스크 리스트
	public List<Risk> riskList(RiskSch sch);
	
	// 리스크 생성
	public int insertRisk(Risk ins);
	
}



