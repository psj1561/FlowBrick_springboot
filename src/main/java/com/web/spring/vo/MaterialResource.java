package com.web.spring.vo;

public class MaterialResource {

	
	
	private int materialresourceno; //물적자원번호
	private int prjNo; //프로젝트번호
	private String prjname; //프로젝트이름
	private int rentorbuy; //임대or구매여부
	private int price; //비용
	private String materialresourcename; //자원이름
	private int productcnt; //물건갯수
	private String facilityloc; //시설위치
	private int division; //시설or물건구분
	
	public void showAll() {
		System.out.println(materialresourceno);
		System.out.println(prjNo);
		System.out.println(prjname);
		System.out.println(rentorbuy);
		System.out.println(price);
		System.out.println(materialresourcename);
		System.out.println(productcnt);
		System.out.println(facilityloc);
		System.out.println(division);
	}
	
	public int getMaterialresourceno() {
		return materialresourceno;
	}
	public void setMaterialresourceno(int materialresourceno) {
		this.materialresourceno = materialresourceno;
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
	public int getRentorbuy() {
		return rentorbuy;
	}
	public void setRentorbuy(int rentorbuy) {
		this.rentorbuy = rentorbuy;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaterialresourcename() {
		return materialresourcename;
	}
	public void setMaterialresourcename(String materialresourcename) {
		this.materialresourcename = materialresourcename;
	}
	public int getProductcnt() {
		return productcnt;
	}
	public void setProductcnt(int productcnt) {
		this.productcnt = productcnt;
	}
	public String getFacilityloc() {
		return facilityloc;
	}
	public void setFacilityloc(String facilityloc) {
		this.facilityloc = facilityloc;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	public MaterialResource(int materialresourceno, int prjNo, String prjname, int rentorbuy, int price,
			String materialresourcename, int productcnt, String facilityloc, int division) {
		this.materialresourceno = materialresourceno;
		this.prjNo = prjNo;
		this.prjname = prjname;
		this.rentorbuy = rentorbuy;
		this.price = price;
		this.materialresourcename = materialresourcename;
		this.productcnt = productcnt;
		this.facilityloc = facilityloc;
		this.division = division;
	}
	public MaterialResource() {
		
	}
	
	
	
}
