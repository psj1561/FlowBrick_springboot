package com.web.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.Dao_notice;
import com.web.spring.dao.Dao_risk;
import com.web.spring.vo.Notice;
import com.web.spring.vo.NoticeFile;
import com.web.spring.vo.NoticeSch;
import com.web.spring.vo.Risk;
import com.web.spring.vo.RiskFile;
import com.web.spring.vo.RiskSch;

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
