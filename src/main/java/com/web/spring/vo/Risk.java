package com.web.spring.vo;

import java.util.Date;

public class Risk {
	private int riskNo;
	private int prjNo;
	private int empNo;
	private String riskName;
	private String riskContent;
	private String dangerStep;
	private Date uploadDate;
	private String uploadDateStr;
	private Date completeDate;
	private String completeDateStr;
	private String state;
	
	public Risk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Risk(int riskNo, int prjNo, int empNo, String riskName, String riskContent, String dangerStep,
			Date uploadDate, Date completeDate, String state) {
		super();
		this.riskNo = riskNo;
		this.prjNo = prjNo;
		this.empNo = empNo;
		this.riskName = riskName;
		this.riskContent = riskContent;
		this.dangerStep = dangerStep;
		this.uploadDate = uploadDate;
		this.completeDate = completeDate;
		this.state = state;
	}
	
	public int getRiskNo() {
		return riskNo;
	}
	public void setRiskNo(int riskNo) {
		this.riskNo = riskNo;
	}
	public int getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	public String getRiskContent() {
		return riskContent;
	}
	public void setRiskContent(String riskContent) {
		this.riskContent = riskContent;
	}
	public String getDangerStep() {
		return dangerStep;
	}
	public void setDangerStep(String dangerStep) {
		this.dangerStep = dangerStep;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUploadDateStr() {
		return uploadDateStr;
	}
	public void setUploadDateStr(String uploadDateStr) {
		this.uploadDateStr = uploadDateStr;
	}
	public String getCompleteDateStr() {
		return completeDateStr;
	}
	public void setCompleteDateStr(String completeDateStr) {
		this.completeDateStr = completeDateStr;
	}
}
