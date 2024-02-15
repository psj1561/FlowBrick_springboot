package com.web.spring.vo;

public class Gantt_Links {
	int id;
	int source;
	int target;
	String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Gantt_Links(int id, int source, int target, String type) {
		super();
		this.id = id;
		this.source = source;
		this.target = target;
		this.type = type;
	}
	public Gantt_Links() {
		super();
	}
	
	
}
