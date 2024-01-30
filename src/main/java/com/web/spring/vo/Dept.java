package com.web.spring.vo;

public class Dept {
	private int deptno;
	private String dname;
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	public Dept(int deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
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
	
	
	
	
	
}
