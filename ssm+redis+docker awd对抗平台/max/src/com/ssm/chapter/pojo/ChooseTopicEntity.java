package com.ssm.chapter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CHOOSE_TOPIC
 * 
 * @author bianj
 * @version 1.0.0 2020-03-17
 */
@Entity
@Table(name = "CHOOSE_TOPIC")
public class ChooseTopicEntity implements java.io.Serializable {
	/** 版本号 */
	private static final long serialVersionUID = 5701514947555896833L;

	/*  */

	/** id */
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 3)
	private Integer id;

	/** eventId */
	@Column(name = "EVENT_ID", nullable = false, length = 3)
	private Integer event_id;

	/** name */
	@Column(name = "NAME", nullable = true, length = 1000)
	private String name;

	/** chooseContent */
	@Column(name = "CHOOSE_CONTENT", nullable = true, length = 65535)
	private String choose_content;

	/** fraction */
	@Column(name = "FRACTION", nullable = true, length = 3)
	private Integer fraction;

	/*  */

	/*  */

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getChoose_content() {
		return choose_content;
	}

	public void setChoose_content(String choose_content) {
		this.choose_content = choose_content;
	}

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

	/*  */
}