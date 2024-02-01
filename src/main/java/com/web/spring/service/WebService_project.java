package com.web.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.Dao_project;
import com.web.spring.vo.Emp;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.ProjectTeam;
import com.web.spring.vo.TeamEmp;
import com.web.spring.vo.TeamMate;


@Service
public class WebService_project {
	
	@Autowired(required = false)
	private Dao_project dao;
	
	public List<ProjectBasic> projectList(ProjectSch sch) {
		if(sch.getPrjName()==null) sch.setPrjName("");
		
		// 페이징 처리
		sch.setCount(dao.cntProject(sch));
		if(sch.getPageCount()==0) sch.setPageSize(10);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEndNo(sch.getCurPage()*sch.getPageSize());
		if(sch.getEndNo()>sch.getCount()) {
			sch.setEndNo(sch.getCount());
		}
		sch.setStartNo((sch.getCurPage()-1)*sch.getPageSize()+1);
		
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		
		return dao.projectList(sch);
	}
	
	public List<TeamEmp> empList(){
		return dao.empList();
	}
	
	public String insertProject(ProjectBasic pb, ProjectTeam pt, TeamMate tm) {
		int ck01 = dao.insertProjectBasic(pb);
		String msg = ck01>0?"기본정보 등록 성공":"등록 실패";
		msg += "\\n";
		
		int ck02 = dao.insertProjectTeam(pt);
		msg += ck02 + "개의 팀 등록 완료";
		
		int ck03 = dao.insertTeamMate(tm);
		msg += ck03 + "명의 팀원 등록 완료";
		
		return msg;
	}
	
	public String insertProjectBasic(ProjectBasic ins) {
		String msg = dao.insertProjectBasic(ins)>0?"기본정보 등록성공":"등록 실패";
		return msg;
	}
	
	public String insertProjectTeam(ProjectTeam ins) {
		String msg = dao.insertProjectTeam(ins)>0?"팀정보 등록성공":"등록 실패";
		return msg;
	}
	
	public String insertTeamMate(TeamMate ins) {
		return dao.insertTeamMate(ins)+"명 등록 완료";
	}
	
		
}
