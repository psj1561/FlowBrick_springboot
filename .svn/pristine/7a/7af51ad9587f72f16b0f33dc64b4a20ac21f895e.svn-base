package com.web.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.Dao_JangSunWoong;
import com.web.spring.vo.HumanResource;
import com.web.spring.vo.MaterialResource;
import com.web.spring.vo.ProjectBasic;

@Service
public class WebService_JangSunWoong {

	@Autowired(required = false)
	private Dao_JangSunWoong dao;
	
	// 상세화면 클릭시
	public ProjectBasic getProjectBasic(int prjNo) {
		return dao.getProjectBasic(prjNo);
	}

	// 수정기능
	public String uptPrjBasic(ProjectBasic upt) {
		return dao.uptPrjBasic(upt)>0?"수정성공":"수정실패";
	}
	
	//삭제기능
	public String delPrjBasic(int prjNo) {
		return dao.delPrjBasic(prjNo)>0?"삭제성공":"삭제실패";
	}
	
	//프로젝트이름 추출
	public String getPrjName(int prjNo) {
		return dao.getPrjName(prjNo);
	}
	
	
	
	
	
	
	
	//물적자원리스트및검색
	public List<MaterialResource> getMRList(MaterialResource mrsch){
		if(mrsch.getPrjname()==null ||mrsch.getPrjname().equals("")) {mrsch.setPrjname("");}
		if(mrsch.getMaterialresourcename()==null ||mrsch.getMaterialresourcename().equals("")) {mrsch.setMaterialresourcename("");}
		return dao.getMRList(mrsch);
	}
	
	//물적자원리스트 price 합(총액)
	public int totalPriceMr(MaterialResource mrsch) {
		return dao.totalPriceMr(mrsch);
	}
	
	//물적자원 추가
	public String insertMR(MaterialResource mrIns) {
		return dao.insertMR(mrIns)>0?"등록성공":"등록실패";
	}
	
	//물적자원 상세정보
	public MaterialResource getDetailMR(int materialresourceno) {
		return dao.getDetailMR(materialresourceno);
	}

	
	
	
	
	
	
	
	
	
	//인적자원리스트및검색
	public List<HumanResource> getHRList(HumanResource hrsch){
		if(hrsch.getTel()==null ||hrsch.getTel().equals("")) {hrsch.setTel("");}
		return dao.getHRList(hrsch);
	}
	
	//인적자원리스트 price 합(총액)
	public int totalPriceHr(HumanResource hrsch) {
		return dao.totalPriceHr(hrsch);
	}
	
	//인적자원 추가
	public String insertHR(HumanResource hrIns) {
		return dao.insertHR(hrIns)>0?"등록성공":"등록실패";
	}
	
	
}
