package com.web.spring.vo;

public class Wizet_PrjStep {
	private int pj;
	private int complete;
	private int develop;
	private int design;
	private int test;
	private int debug;
	
	public Wizet_PrjStep() {
		super();
	}

	public Wizet_PrjStep(int pj, int complete, int develop, int design, int test, int debug) {
		super();
		this.pj = pj;
		this.complete = complete;
		this.develop = develop;
		this.design = design;
		this.test = test;
		this.debug = debug;
	}

	public int getPj() {
		return pj;
	}

	public void setPj(int pj) {
		this.pj = pj;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public int getDevelop() {
		return develop;
	}

	public void setDevelop(int develop) {
		this.develop = develop;
	}

	public int getDesign() {
		return design;
	}

	public void setDesign(int design) {
		this.design = design;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public int getDebug() {
		return debug;
	}

	public void setDebug(int debug) {
		this.debug = debug;
	}
	
}
