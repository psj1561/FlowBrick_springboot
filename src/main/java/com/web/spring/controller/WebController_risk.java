package com.web.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.WebService_project;
import com.web.spring.service.WebService_risk;
import com.web.spring.vo.Emp;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.ProjectPaging;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.ProjectTeam;
import com.web.spring.vo.Risk;
import com.web.spring.vo.RiskSch;
import com.web.spring.vo.TeamEmp;
import com.web.spring.vo.TeamMate;

import jakarta.servlet.http.HttpSession;

@Controller
public class WebController_risk {
	@Autowired(required = false)
	private WebService_risk service;
	
	// http://localhost:2222/riskList
	@RequestMapping("riskList")
	public String riskList(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("riskList", service.riskList(sch));
		return "risk_list";
	}
	
	// http://localhost:2222/insertRiskFrm
	@RequestMapping("insertRiskFrm")
	public String insertRiskFrm(Risk risk) {
		return "risk_insert";
	}
	
    @ModelAttribute("projectList")
    public List<ProjectBasic> getProjectList(HttpSession session) {
    	return service.getProject(session);
    }
	
	@PostMapping("insertRisk")
	public String insertRisk(Risk ins, Model d) {
		d.addAttribute("msg", service.insertRisk(ins));
		return "risk_insert";
	}

}
