package com.ssm.chapter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FILE_TOPIC
 * 
 * @author bianj
 * @version 1.0.0 2020-03-17
 */
@Entity
@Table(name = "FILE_TOPIC")
public class FileTopicEntity implements java.io.Serializable {
	/** 版本号 */
	private static final long serialVersionUID = -2551409663744241351L;

	/*  */

	/** id */
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 3)
	private Integer id;

	/** eventId */
	@Column(name = "EVENT_ID", nullable = false, length = 100)
	private String event_id;

	/** name */
	@Column(name = "NAME", nullable = true, length = 1000)
	private String name;

	/** type */
	@Column(name = "TYPE", nullable = true, length = 1000)
	private String type;

	/** topicName */
	@Column(name = "TOPIC_NAME", nullable = true, length = 1000)
	private String topic_name;

	/** introduction */
	@Column(name = "INTRODUCTION", nullable = true, length = 1000)
	private String introduction;

	/** file */
	@Column(name = "FILE", nullable = true, length = 100)
	private String file;


	/** fraction */
	@Column(name = "FRACTION", nullable = true, length = 3)
	private Integer fraction;

	/*  */

	/*  */

	/**
	 * 获取id
	 * 
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取eventId
	 * 
	 * @return eventId


	/**
	 * 获取name
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取type
	 * 
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置type
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取topicName
	 * 
	 * @return topicName
	 */
	

	/**
	 * 获取introduction
	 * 
	 * @return introduction
	 */
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * 设置introduction
	 * 
	 * @param introduction
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 获取file
	 * 
	 * @return file
	 */
	public String getFile() {
		return this.file;
	}

	/**
	 * 设置file
	 * 
	 * @param file
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * 获取answer
	 * 
	 * @return answer
	 */


	/**
	 * 获取fraction
	 * 
	 * @return fraction
	 */
	public Integer getFraction() {
		return this.fraction;
	}

	/**
	 * 设置fraction
	 * 
	 * @param fraction
	 */
	public void setFraction(Integer fraction) {
		this.fraction = fraction;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	

	/*  */
}