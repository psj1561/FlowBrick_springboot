package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController_maintenance {
	//@Autowired(required = false)
	//private WebService_notice service;
		
	// 관리페이지로 이동
	// http://211.63.89.67:2222/pms/notice.do
	// http://localhost:7080/pms/maintenanceFrm.do
	@RequestMapping("maintenanceFrm.do")
	public String managementFrm() {
		return "WEB-INF\\view\\maintenance.jsp";
	}
	

}
