package com.ssm.chapter.pojo;

import java.io.Serializable;

public class TrueAnswer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7058646578256260065L;

	private int id;

	private int table_name;

	private int event_id;

	private String answer;

	private int fraction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTable_name() {
		return table_name;
	}

	public void setTable_name(int table_name) {
		this.table_name = table_name;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getFraction() {
		return fraction;
	}

	public void setFraction(int fraction) {
		this.fraction = fraction;
	}

}
