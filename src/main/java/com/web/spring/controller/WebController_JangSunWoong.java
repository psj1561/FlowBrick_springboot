package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.web.spring.service.WebService_JangSunWoong;
import com.web.spring.vo.DataBetweenMrAndRep;
import com.web.spring.vo.DataBetweenRepAndMr;
import com.web.spring.vo.Gantt_Links;
import com.web.spring.vo.Gantt_Task;
import com.web.spring.vo.HumanResource;
import com.web.spring.vo.MaterialResource;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.Repository;



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
		service.changePrjName(mrsch.getPrjNo());
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
	@RequestMapping("getDetailMR.do")
	String getDetailMR(@RequestParam("materialresourceno") int materialresourceno, Model d) {
		d.addAttribute("detailedMR",service.getDetailMR(materialresourceno));
		return "pageJsonReport";
	}
	
	// 물적자원 삭제
	@RequestMapping("delMaterialResource.do")
	String delMaterialResource(@RequestParam("materialresourceno") int materialresourceno, Model d) {
		d.addAttribute("msg",service.delMaterialResource(materialresourceno));
		return "pageJsonReport";
	}
	
	//물적자원 변경
	@RequestMapping("uptMaterialResource.do")
	String uptMaterialResource(@ModelAttribute("uptMR")MaterialResource uptMR, Model d) {
		d.addAttribute("msg",service.uptMR(uptMR));
		return "pageJsonReport";
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
	
	// 인적자원 상세정보 출력
	@RequestMapping("getDetailHR.do")
	String getDetailHR(@RequestParam("tel") String tel , Model d) {
		d.addAttribute("detailedHR",service.getDetailHR(tel));
		return "pageJsonReport";
	}
	
	// 인적자원 삭제
	@RequestMapping("delHumanResource.do")
	String delHumanResource(@RequestParam("tel") String tel, Model d) {
		d.addAttribute("msg",service.delHumanResource(tel));
		return "pageJsonReport";
	}

	
	//인적자원 변경
	@RequestMapping("uptHumanResource.do")
	String uptHumanResource(@ModelAttribute("uptHR")HumanResource uptHR, Model d) {
		d.addAttribute("msg",service.uptHR(uptHR));
		return "pageJsonReport";
	}
	
	
	
	
	
	
	
	//materialresource.jsp에서 비품창고 버튼 누르면 prjNo와 prjname만 전달되어 온다.
	//비품창고 리스트 출력
	@RequestMapping("repositoryList.do")
	String getRepositoryList(@ModelAttribute("mrsch") MaterialResource mrsch, @ModelAttribute("repositorySch") Repository repositorySch, Model d) {
		
		d.addAttribute("mrList",service.getMRList(mrsch));
		
		d.addAttribute("repositoryList",service.getRepositoryList(repositorySch));
		
		d.addAttribute("prjNoPermanent",mrsch.getPrjNo());
		
		int totalMR = 0;
		if(service.getMRList(mrsch)!=null && service.getMRList(mrsch).size()!=0 ) {
			totalMR=service.totalPriceMr(mrsch);
		}
		d.addAttribute("totalPriceMr",totalMR);

		return "j05_repositoryPage";
	}
	
	
	
	//비품창고 리스트 출력(데이터 ajax 전송을 위한 pageJsonReport리턴 메소드)
	@RequestMapping("repositoryList2.do")
	String getRepositoryList2(@ModelAttribute("mrsch") MaterialResource mrsch, @ModelAttribute("repositorySch") Repository repositorySch, @RequestParam(value="repno",defaultValue="0") int repno, @RequestParam(value="index",defaultValue="") String index, Model d) {
		
		d.addAttribute("mrList",service.getMRList(mrsch));
		
		d.addAttribute("repositoryList",service.getRepositoryList(repositorySch));
		
		int totalMR = 0;
		if(service.getMRList(mrsch)!=null && service.getMRList(mrsch).size()!=0 ) {
			totalMR=service.totalPriceMr(mrsch);
		}
		d.addAttribute("totalPriceMr",totalMR);
		
		if(!index.equals(""))
		{
			if(index.equals("MRTOREP"))
			{
				System.out.println("index는 MRTOREP 입니다.");
				if(mrsch.getMaterialresourceno()>0) {
					d.addAttribute("mrCnt",service.getMRCnt(mrsch.getMaterialresourceno()));
					d.addAttribute("materialresourceno",mrsch.getMaterialresourceno());
				}

			}
			
			if(index.equals("REPTOMR"))
			{
				System.out.println("index는 REPTOMR 입니다.");
				if(repno>0) {

					d.addAttribute("repositoryCnt",service.getRepCnt(repno));
				}
			}
		}
		return "pageJsonReport";
	}
	
	
	
	@RequestMapping("transferToRepository.do")
	public String transferToRepository(DataBetweenRepAndMr dbram, Model d) {
		d.addAttribute("msg","실패 : 보유 자원 갯수를 초과합니다.");
		if(service.getMRCnt(dbram.getMaterialresourceno())>=dbram.getCntInput()) {
			service.transferToRepositoryStep1(dbram);
			service.transferToRepositoryStep2(dbram);
			d.addAttribute("msg","성공");
			service.deleteZeroCntMR();
			service.deleteZeroCntRepository();
		}
		return "pageJsonReport";
	}
	

	@RequestMapping("transferToMaterialResource.do")
	public String transferToMaterialResource(DataBetweenMrAndRep dbmar, Model d) {
		d.addAttribute("msg","실패 : 보유 자원 갯수를 초과합니다.");
		if(service.getRepCnt(dbmar.getRepno())>=dbmar.getCntInputRepToMr()) {
			service.transferToMaterialResourceStep1(dbmar);
			service.transferToMaterialResourceStep2(dbmar);
			d.addAttribute("msg","성공");
			service.deleteZeroCntMR();//이거 위치 재조정하자.
			service.deleteZeroCntRepository();//이거 위치 재조정하자.
		}
		return "pageJsonReport";
	}
	
	
	
	
	
	

	

	
	
	

	
	
	/*
	// 주의하자 spring boot에서 pageJsonReport로 그대로 화면 출력 불가능하다. 단, 데이터 추출은 가능하다.
	@RequestMapping("getGanttTask.do")
	public String getGanttTask(Model d) {
		d.addAttribute("tasks",service.getGanttTask());
		return "pageJsonReport";
	}
	
	@RequestMapping("getGanttLinks.do")
	public String getGanttLinks(Model d) {
		d.addAttribute("links",service.getGanttLinks());
		return "pageJsonReport";
	}
	*/
	
	/*
	@RequestMapping("getGanttTask.do")
	public ResponseEntity<?> getGanttTask() {
		return ResponseEntity.ok(service.getGanttTask());
	}
	
	@RequestMapping("getGanttLinks.do")
	public ResponseEntity<?> getGanttLinks() {
		return ResponseEntity.ok(service.getGanttLinks());
	}
	*/
	
	@RequestMapping("getGanttChart.do") 
	public String getGanttChart(Model d) {
		d.addAttribute("tasks",service.getGanttTask());
		d.addAttribute("links",service.getGanttLinks());
		return "pageJsonReport";
	}
	
	
// http://localhost:2222/gantt.do
	@RequestMapping("gantt.do")
	public String gantt() {
		return "j06_ganttChart";
	}
}

