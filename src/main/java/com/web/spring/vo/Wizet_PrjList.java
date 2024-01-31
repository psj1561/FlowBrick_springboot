package com.web.spring.vo;

import java.util.Date;

public class Wizet_PrjList {
	private int prjNo;
	private String prjName;
	private double prjPriority;
	private Date prjAcceptDate; //프로젝트수주일
	private Date prjBegin; //프로젝트시작일
	private Date prjEnd; //프로젝트종료일
	private String prjStep;
	private String teamName;
	
	public Wizet_PrjList() {
		super();
	}

	public Wizet_PrjList(int prjNo, String prjName, double prjPriority, Date prjAcceptDate, Date prjBegin, Date prjEnd,
			String prjStep, String teamName) {
		super();
		this.prjNo = prjNo;
		this.prjName = prjName;
		this.prjPriority = prjPriority;
		this.prjAcceptDate = prjAcceptDate;
		this.prjBegin = prjBegin;
		this.prjEnd = prjEnd;
		this.prjStep = prjStep;
		this.teamName = teamName;
	}

	public int getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public double getPrjPriority() {
		return prjPriority;
	}

	public void setPrjPriority(double prjPriority) {
		this.prjPriority = prjPriority;
	}

	public Date getPrjAcceptDate() {
		return prjAcceptDate;
	}

	public void setPrjAcceptDate(Date prjAcceptDate) {
		this.prjAcceptDate = prjAcceptDate;
	}

	public Date getPrjBegin() {
		return prjBegin;
	}

	public void setPrjBegin(Date prjBegin) {
		this.prjBegin = prjBegin;
	}

	public Date getPrjEnd() {
		return prjEnd;
	}

	public void setPrjEnd(Date prjEnd) {
		this.prjEnd = prjEnd;
	}

	public String getPrjStep() {
		return prjStep;
	}

	public void setPrjStep(String prjStep) {
		this.prjStep = prjStep;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
}
