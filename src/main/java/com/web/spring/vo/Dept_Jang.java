package com.web.spring.vo;

public class Dept_Jang {
	private int deptno;
	private String dname;
	
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Dept_Jang(int deptno, String dname) {
		super();
		this.deptno = deptno;
		this.dname = dname;
	}
	public Dept_Jang() {
		super();
	}
	
}
