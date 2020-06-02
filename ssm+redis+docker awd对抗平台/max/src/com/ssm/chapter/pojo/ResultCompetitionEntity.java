package com.ssm.chapter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESULT_COMPETITION")
public class ResultCompetitionEntity implements java.io.Serializable {
	/** °æ±¾ºÅ */
	private static final long serialVersionUID = 850719183000266159L;

	/*  */

	/** id */
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 3)
	private Integer id;

	/** teamId */
	@Column(name = "TEAM_ID", nullable = true, length = 3)
	private Integer team_id;

	/** submitNumber */
	@Column(name = "SUBMIT_NUMBER", nullable = true, length = 3)
	private Integer submit_number;

	/** radioAnswer */
	@Column(name = "RADIO_ANSWER", nullable = true, length = 65535)
	private String radio_answer;

	/** multipleChoiceAnswer */
	@Column(name = "MULTIPLE_CHOICE_ANSWER", nullable = true, length = 65535)
	private String multiple_choice_answer;

	/** flagScore */
	@Column(name = "FLAG_SCORE", nullable = true, length = 3)
	private Integer flag_score;

	/** radioScore */
	@Column(name = "RADIO_SCORE", nullable = true, length = 3)
	private Integer radio_score;

	/** multipleChoiceScore */
	@Column(name = "MULTIPLE_CHOICE_SCORE", nullable = true, length = 3)
	private Integer multiple_choice_score;

	/** eventId */
	@Column(name = "EVENT_ID", nullable = true, length = 3)
	private Integer event_id;

	/** alreadyAnswered1 */
	@Column(name = "ALREADY_ANSWERED1", nullable = true, length = 65535)
	private String already_answered1;

	/** alreadyAnswered2 */
	@Column(name = "ALREADY_ANSWERED2", nullable = true, length = 65535)
	private String already_answered2;

	/** alreadyAnswered3 */
	@Column(name = "ALREADY_ANSWERED3", nullable = true, length = 65535)
	private String already_answered3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public Integer getSubmit_number() {
		return submit_number;
	}

	public void setSubmit_number(Integer submit_number) {
		this.submit_number = submit_number;
	}

	public String getRadio_answer() {
		return radio_answer;
	}

	public void setRadio_answer(String radio_answer) {
		this.radio_answer = radio_answer;
	}

	public String getMultiple_choice_answer() {
		return multiple_choice_answer;
	}

	public void setMultiple_choice_answer(String multiple_choice_answer) {
		this.multiple_choice_answer = multiple_choice_answer;
	}

	public Integer getFlag_score() {
		return flag_score;
	}

	public void setFlag_score(Integer flag_score) {
		this.flag_score = flag_score;
	}

	public Integer getRadio_score() {
		return radio_score;
	}

	public void setRadio_score(Integer radio_score) {
		this.radio_score = radio_score;
	}

	public Integer getMultiple_choice_score() {
		return multiple_choice_score;
	}

	public void setMultiple_choice_score(Integer multiple_choice_score) {
		this.multiple_choice_score = multiple_choice_score;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getAlready_answered1() {
		return already_answered1;
	}

	public void setAlready_answered1(String already_answered1) {
		this.already_answered1 = already_answered1;
	}

	public String getAlready_answered2() {
		return already_answered2;
	}

	public void setAlready_answered2(String already_answered2) {
		this.already_answered2 = already_answered2;
	}

	public String getAlready_answered3() {
		return already_answered3;
	}

	public void setAlready_answered3(String already_answered3) {
		this.already_answered3 = already_answered3;
	}

	

}