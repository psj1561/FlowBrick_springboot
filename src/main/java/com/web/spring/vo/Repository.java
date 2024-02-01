package com.web.spring.vo;

public class Repository {
	private int repno;//저장번호
	private int division;//시설or물건구분
	private String materialresourcename;//자원이름
	private int repcnt;//비품갯수
	private int rentorbuy; //임대or구매여부
	private String facilityloc; //시설위치
	
	public void showAll() {
		System.out.println(this.repno);
		System.out.println(this.division);
		System.out.println(this.materialresourcename);
		System.out.println(this.repcnt);
		System.out.println(this.rentorbuy);
		System.out.println(this.facilityloc);
	}
	
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public String getMaterialresourcename() {
		return materialresourcename;
	}
	public void setMaterialresourcename(String materialresourcename) {
		this.materialresourcename = materialresourcename;
	}
	public int getRepcnt() {
		return repcnt;
	}
	public void setRepcnt(int repcnt) {
		this.repcnt = repcnt;
	}
	public int getRentorbuy() {
		return rentorbuy;
	}
	public void setRentorbuy(int rentorbuy) {
		this.rentorbuy = rentorbuy;
	}
	public String getFacilityloc() {
		return facilityloc;
	}
	public void setFacilityloc(String facilityloc) {
		this.facilityloc = facilityloc;
	}
	public Repository(int repno, int division, String materialresourcename, int repcnt, int rentorbuy,
			String facilityloc) {
		super();
		this.repno = repno;
		this.division = division;
		this.materialresourcename = materialresourcename;
		this.repcnt = repcnt;
		this.rentorbuy = rentorbuy;
		this.facilityloc = facilityloc;
	}
	public Repository() {
		super();
		
	}
	
	
	
}
