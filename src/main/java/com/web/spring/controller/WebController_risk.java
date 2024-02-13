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
	
	// 리스크 리스트 화면
	// http://localhost:2222/riskList
	@RequestMapping("riskList")
	public String riskList(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("riskList", service.riskList(sch));
		return "risk_list";
	}

	// 리스크 상세 화면
	@GetMapping("riskDetail")
	public String getRiskDetail(int riskNo, Model d) {
		d.addAttribute("riskDetail", service.getRiskDetail(riskNo));
		return "risk_detail";
	}
	
	// 리스크 등록 화면
	// http://localhost:2222/insertRiskFrm
	@RequestMapping("insertRiskFrm")
	public String insertRiskFrm(Risk risk) {
		return "risk_insert";
	}
	
	// 로그인 세션에 해당하는 포르젝트 리스트 출력
    @ModelAttribute("projectListByEmp")
    public List<ProjectBasic> getProjectList(HttpSession session) {
    	return service.getProjectByEmp(session);
    }
	
    @ModelAttribute("projectByPrjNo")
    public List<ProjectBasic> getProjectByPrjNo(Risk sch) {
    	return service.getProjectByPrjNo(sch);
    }
    
    // 리스크 등록 처리
	@PostMapping("insertRisk")
	public String insertRisk(Risk ins, Model d) {
		d.addAttribute("msg", service.insertRisk(ins));
		return "risk_insert";
	}
	
	// 리스크 수정
	@PostMapping("updateRisk")
	public String updateRisk(Risk upt, Model d) {
		// 수정 처리
		d.addAttribute("proc", "upt");
		d.addAttribute("msg", service.updateRisk(upt));
		// 수정 후 데이터 조회
		d.addAttribute("riskDetail", service.getRiskDetail(upt.getRiskNo()));
		return "risk_detail";
	}
	
	// 리스크 삭제
	@PostMapping("deleteRisk")
	public String deleteRisk(int riskNo, Model d) {
		d.addAttribute("proc", "del");
		d.addAttribute("msg", service.deleteRisk(riskNo));
		return "risk_detail";
	}
	
	// 파일 다운로드
	@RequestMapping("downloadFile")
	public String downloadFile(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadViewer";
	}

}
