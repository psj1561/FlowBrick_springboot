package com.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.WebService_JangSunWoong;
import com.web.spring.vo.HumanResource;
import com.web.spring.vo.MaterialResource;
import com.web.spring.vo.ProjectBasic;

@Controller
public class WebController_JangSunWoong {

	@Autowired(required = false)
	private WebService_JangSunWoong service;
	
	
	// 프로젝트 상세화면 조회
	// http://localhost:7080/pms/getProjectBasic.do?prjNo=1
	@RequestMapping("getProjectBasic.do")
	public String getProjectBasic(@RequestParam("prjNo") int prjNo, Model d) {
		d.addAttribute("project", service.getProjectBasic(prjNo));
		return "j01_prjDetail";
	}
	
	
	
	//http://localhost:7080/pms/uptPrjBasic.do
	// 프로젝트 수정처리
	@RequestMapping("uptPrjBasic.do")
	public String uptPrjBasic(ProjectBasic upt, Model d) {
		d.addAttribute("proc","upt");
		d.addAttribute("msg",service.uptPrjBasic(upt));
		d.addAttribute("project",service.getProjectBasic(upt.getPrjNo()));
		//매개변수 한개다.
		//그리고 getProjectBasic와 uptPrjBasic모두 project라는 같은 모델명을 공통적으로 사용한다.
		
	
		return "j01_prjDetail";
	}
	
	
	// 프로젝트 삭제처리
	@RequestMapping("delPrjBasic.do")
	public String delPrjBasic(int prjNo, Model d) {
		d.addAttribute("proc","del");
		d.addAttribute("msg",service.delPrjBasic(prjNo));
		return "j01_prjDetail";
	}
	
	
	
	// 프로젝트 자원페이지이동
	@RequestMapping("resource.do")
	public String resource(@RequestParam("prjNo")int prjNo, Model d) {
		d.addAttribute("prjNo",prjNo);
		d.addAttribute("prjname",service.getPrjName(prjNo));
		return "j02_resourcePage";
	}
	
	// 물적자원 리스트 이동
	@RequestMapping("MRList.do")
	public String MRList(@ModelAttribute("mrsch") MaterialResource mrsch, Model d){
		mrsch.showAll();
		d.addAttribute("mrList",service.getMRList(mrsch));
		int totalMR = 0;
		if(service.getMRList(mrsch)!=null && service.getMRList(mrsch).size()!=0 ) {
			totalMR=service.totalPriceMr(mrsch);
		}
		d.addAttribute("totalPriceMr",totalMR);
		return "j03_materialResourcePage";
	}
	
	// 물적자원 리스트에 항목 추가
	@RequestMapping("insertMR.do")
	String insertMR(MaterialResource mrIns, Model d) {
		d.addAttribute("msg",service.insertMR(mrIns));
		return "j03_materialResourcePage";
	}
	
	// 물적자원 상세정보 출력
	@RequestMapping("")
	String getDetailMR(int materialresourceno, Model d) {
		
		d.addAttribute("detailedMR",service.getDetailMR(materialresourceno));
		return "j03_materialResourcePage";
	}

	
	
	
	
	
	
	
	
	
	// 인적자원 리스트 이동
	@RequestMapping("HRList.do")
	public String HRList(@ModelAttribute("hrsch") HumanResource hrsch, Model d){
		
		d.addAttribute("hrList",service.getHRList(hrsch));
		
		int totalHR = 0;
		if(service.getHRList(hrsch)!=null && service.getHRList(hrsch).size()!=0 ) {
			totalHR=service.totalPriceHr(hrsch);
		}
		
		d.addAttribute("totalPriceHr",totalHR);
		
		return "j04_humanResourcePage";
	}
	
	
	
	// 인적자원 리스트에 항목 추가
	@RequestMapping("insertHR.do")
	String insertHR(HumanResource hrIns, Model d) {
		d.addAttribute("msg",service.insertHR(hrIns));
		return "j04_humanResourcePage";
	}
	
	

}
