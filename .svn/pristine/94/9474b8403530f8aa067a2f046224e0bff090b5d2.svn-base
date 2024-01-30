package com.web.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.Dao_project;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.ProjectSch;


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
	
	public String insertProjectBasic(ProjectBasic ins) {
		String msg = dao.insertProjectBasic(ins)>0?"기본정보 등록성공":"등록 실패";
		return msg;
	}
		
}
