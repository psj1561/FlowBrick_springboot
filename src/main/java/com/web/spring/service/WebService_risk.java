package com.web.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.Dao_notice;
import com.web.spring.dao.Dao_risk;
import com.web.spring.vo.Emp;
import com.web.spring.vo.Notice;
import com.web.spring.vo.NoticeFile;
import com.web.spring.vo.NoticeSch;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.Risk;
import com.web.spring.vo.RiskFile;
import com.web.spring.vo.RiskSch;

import jakarta.servlet.http.HttpSession;

@Service
public class WebService_risk {
	@Autowired(required = false)
	private Dao_risk dao;
	// 공지사항 리스트 불러오기
	public List<Risk> riskList(RiskSch sch) {
		if(sch.getPrjName()==null) sch.setPrjName("");
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getRiskName()==null) sch.setRiskName("");
		
		sch.setCount(dao.cntRisk(sch));
		
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage= (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		
		if(sch.getCurPage()>sch.getPageCount())
			sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		
		sch.setEndNo(sch.getCurPage()*sch.getPageSize());
		if(sch.getEndNo()>sch.getCount()) {
			sch.setEndNo(sch.getCount());
		}
		sch.setStartNo((sch.getCurPage()-1)*sch.getPageSize()+1);
		
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/
				(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.riskList(sch);
	} 
	
    public List<ProjectBasic> getProject(HttpSession session) {
        // 세션에서 empno 값을 가져옵니다.
    	Emp empnoObject = new Emp();
        empnoObject = (Emp)session.getAttribute("empResult");
     
        // empno 값이 null인지 확인합니다.
        if (empnoObject != null) {
            int empno = empnoObject.getEmpno();
            
            // service의 getProject 메서드를 호출하여 프로젝트 목록을 가져옵니다.
            return dao.getProject(empno);
        } else {
            // empno 값이 null이면 빈 리스트를 반환합니다.
            return new ArrayList<>();
        }
    }
	
	@Value("${riskFile.upload}")
	private String path;
	
	// 등록처리
	public String insertRisk(Risk ins) {
		int insertRiskInfo = dao.insertRisk(ins);
		String msg = insertRiskInfo>0?"리스크 등록 성공":"등록 실패"; msg+="\\n";
		
		int insertRiskFile =0;
		MultipartFile [] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
				// 1) 파일업로드 처리
					String fname = mpf.getOriginalFilename();
					mpf.transferTo(new File(path+fname));
					insertRiskFile += dao.insertRiskFile(
							new RiskFile(fname, path, "프로젝트명 : " + ins.getPrjName() + "리스크명 : " +ins.getRiskName()));
				}
			} catch (IllegalStateException e) {
				msg += "파일업로드 오류 : " + e.getMessage() + "\\n";
			} catch (IOException e) {
				msg += "기타 오류 : " + e.getMessage() + "\\n";
			}
			msg += "리스크 파일 " + insertRiskFile + "건 등록 완료";
		}
		return msg;
	}
	
	
}
