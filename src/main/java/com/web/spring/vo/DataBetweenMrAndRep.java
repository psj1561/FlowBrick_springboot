package com.web.spring.vo;

public class DataBetweenMrAndRep {
	
	private int cntInputRepToMr;
	private int repno;
	private int prjNo;
	private String prjname;
	
	
	public int getCntInputRepToMr() {
		return cntInputRepToMr;
	}
	public void setCntInputRepToMr(int cntInputRepToMr) {
		this.cntInputRepToMr = cntInputRepToMr;
	}
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
	public int getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(int prjNo) {
		this.prjNo = prjNo;
	}
	public String getPrjname() {
		return prjname;
	}
	public void setPrjname(String prjname) {
		this.prjname = prjname;
	}
	public DataBetweenMrAndRep(int cntInputRepToMr, int repno, int prjNo, String prjname) {
		super();
		this.cntInputRepToMr = cntInputRepToMr;
		this.repno = repno;
		this.prjNo = prjNo;
		this.prjname = prjname;
	}
	public DataBetweenMrAndRep() {
		super();
	}
	
	
}
