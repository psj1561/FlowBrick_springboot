package com.web.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.spring.service.WebService_dashboard;
import com.web.spring.service.WebService_notice;
import com.web.spring.vo.Emp;
import com.web.spring.vo.NoticeSch;

import jakarta.servlet.http.HttpSession;

@Controller
public class WebController_dashboard {
	@Autowired(required = false)
	private WebService_dashboard service;
	@Autowired(required = false)
	private WebService_notice Nservice;
	
	// http://211.63.89.67:2222/index.do	
	// http://localhost:2222/index.do
	@RequestMapping("index.do")
	public String index(HttpSession session, Model d) {
		// 로그인 정보 받아오기
		Emp emp = (Emp) session.getAttribute("empResult");
		
		// 공지사항 위젯
		NoticeSch sch = new NoticeSch();
		d.addAttribute("noticeList", Nservice.noticeList(sch));
		Date now = new Date(); // 현재시간 객체
		d.addAttribute("now", now);
		
		// 내 프로젝트 위젯
		d.addAttribute("prjList", service.getPrjList(emp.getEmpno()));
		
		// 프로젝트 진행도 위젯
		d.addAttribute("prj_chart", service.getPrjStep(emp.getEmpno()));
		return "index";
	}


}
