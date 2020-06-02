package com.ssm.chapter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MULTIPLE_TOPIC
 * 
 * @author bianj
 * @version 1.0.0 2020-03-17
 */
@Entity
@Table(name = "MULTIPLE_TOPIC")
public class MultipleTopicEntity implements java.io.Serializable {
	/** �汾�� */
	private static final long serialVersionUID = 7694588851765781228L;

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

	/** topicContent */
	@Column(name = "TOPIC_CONTENT", nullable = true, length = 65535)
	private String topic_content;

	/** fraction */
	@Column(name = "FRACTION", nullable = true, length = 3)
	private Integer fraction;

	/*  */

	/*  */

	/**
	 * ��ȡid
	 * 
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * ����id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ��ȡname
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * ����name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡtopicContent
	 * 
	 * @return topicContent
	 */

	/**
	 * ��ȡanswer
	 * 
	 * @return answer
	 * 
	 *         /** ��ȡfraction
	 * 
	 * @return fraction
	 */
	public Integer getFraction() {
		return this.fraction;
	}

	/**
	 * ����fraction
	 * 
	 * @param fraction
	 */
	public void setFraction(Integer fraction) {
		this.fraction = fraction;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getTopic_content() {
		return topic_content;
	}

	public void setTopic_content(String topic_content) {
		this.topic_content = topic_content;
	}

	/*  */
}