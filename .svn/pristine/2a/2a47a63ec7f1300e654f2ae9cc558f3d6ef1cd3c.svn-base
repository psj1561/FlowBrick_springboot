package com.web.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.Dao_Dashboard;
import com.web.spring.vo.Wizet_PrjList;
import com.web.spring.vo.Wizet_PrjStep;

@Service
public class WebService_dashboard {
	@Autowired(required = false)
	private Dao_Dashboard dao;
	
	// 프로젝트 목록
	public List<Wizet_PrjList> getPrjList(int empno) {
		
		return dao.getPrjList(empno);
	}
	
	// 프로젝트 진행도
	public Wizet_PrjStep getPrjStep(int empno) {
		Wizet_PrjStep test = dao.getPrjStep(empno);
		
		return test;
	} 
	 
}
