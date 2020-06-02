package com.ssm.chapter.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Answer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7058646578256260065L;
	@NotNull
	@Size(min = 0, max = 256)
	private int id;
	@NotNull
	@Size(min = 0, max = 256)
	private int type;
	@NotNull
	@Size(min = 0, max = 256)
	private int event_id;
	@NotNull
	@Size(min = 0, max = 256)
	private String code;
	@NotNull
	@Size(min = 0, max = 256)
	private String answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	

}
