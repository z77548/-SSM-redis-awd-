package com.ssm.chapter.pojo;

public class OneNew {
	private int id ;
	private int publisher_id;
	private int recipient_id;
	private String  data;
	private String publisher_name;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public int getRecipient_id() {
		return recipient_id;
	}
	public void setRecipient_id(int recipient_id) {
		this.recipient_id = recipient_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
