package com.web.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.spring.service.WebService_manage;
import com.web.spring.service.WebService_risk;
import com.web.spring.vo.RiskSch;


@Controller
public class WebController_manage {
	@Autowired(required = false)
	private WebService_manage service;
	
	// 리스크 리스트 화면
	// http://localhost:2222/riskList
	@RequestMapping("riskManage.do")
	public String riskList(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("riskList", service.riskList(sch));
		return "risk_manage";
	}
	


}
