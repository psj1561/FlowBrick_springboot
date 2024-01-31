package com.web.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.spring.vo.HumanResource;
import com.web.spring.vo.MaterialResource;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.Repository;


@Mapper
public interface Dao_JangSunWoong{
	

	
	//프로젝트기본 리스트
	@Select("SELECT * FROM PROJECTBASIC WHERE prjNo = #{prjNo}")
	ProjectBasic getProjectBasic(int prjNo);
	//프로젝트기본 변경
	int uptPrjBasic(ProjectBasic upt);
	//프로젝트기본 삭제
	int delPrjBasic(int prjNo);
	//프로젝트이름 추출
	String getPrjName(int prjNo);
	//자원테이블의 프로젝트이름 변경하기
	int changePrjName(int prjNo);
	

	
	
	
	//물적자원 리스트
	List<MaterialResource> getMRList(MaterialResource mrsch);
	//물적자원 총액
	int totalPriceMr(MaterialResource mrsch);	
	//물적자원 추가
	int insertMR(MaterialResource mrIns);
	//물적자원 삭제
	int delMaterialResource(int materialresourceno);
	//물적자원 상세
	MaterialResource getDetailMR(int materialresourceno);
	//물적자원 변경
	int uptMR(MaterialResource uptMR);
	
	
	
	//인적자원 리스트
	List<HumanResource> getHRList(HumanResource hrsch);
	//인적자원 총액
	int totalPriceHr(HumanResource hrsch);
	//인적자원 추가
	int insertHR(HumanResource hrIns);	
	//인적자원 삭제
	int delHumanResource(String tel);
	//인적자원 상세
	HumanResource getDetailHR(String tel);
	//인적자원 변경
	int uptHR(HumanResource uptHR);

	
	
	//비품창고 리스트 출력
	List<Repository> getRepositoryList(Repository sch);
	
	
	
}


