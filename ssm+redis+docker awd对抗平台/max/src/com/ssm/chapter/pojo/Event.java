package com.ssm.chapter.pojo;

public class Event {
	private int id; // 赛事ID
	private String name; // 赛事名称
	private String intime; // 开始时间
	private String outime; // 结束时间
	private String jianjie; // 赛事简介
	private String file; // 赛事文件地址
	private String state;
	private int awd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOutime() {
		return outime;
	}

	public void setOutime(String outime) {
		this.outime = outime;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAwd() {
		return awd;
	}

	public void setAwd(int awd) {
		this.awd = awd;
	}

}
