package com.web.spring.vo;

public class TeamEmp {
	private int empno;
	private String ename;
	private String job;
	private int deptno;
	private String dname;
	
	public TeamEmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TeamEmp(int empno, String ename, String job, int deptno, String dname) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.deptno = deptno;
		this.dname = dname;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
