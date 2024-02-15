package com.web.spring.vo;



public class Gantt_Task {

	private int id;
	private String start_date;
	private String text;
	private double progress;
	private int duration;
	private int parent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public Gantt_Task(int id, String start_date, String text, double progress, int duration, int parent) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.text = text;
		this.progress = progress;
		this.duration = duration;
		this.parent = parent;
	}
	public Gantt_Task() {
		super();

	}
	
	
	
	
	
	
	
}
