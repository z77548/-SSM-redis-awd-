package com.ssm.chapter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM_APPLICATION")
public class TeamApplicationEntity implements java.io.Serializable {
	/** �汾�� */
	private static final long serialVersionUID = -6732354563514888077L;

	/* This code was generated by TableGo tools, mark 1 begin. */

	/** id */
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 3)
	private Integer id;

	/** teamId */
	@Column(name = "team_id", nullable = true, length = 3)
	private Integer team_id;

	/** applicantId */
	@Column(name = "applicant_id", nullable = true, length = 3)
	private Integer applicant_id;

	/** captainId */
	@Column(name = "captain_id", nullable = true, length = 3)
	private Integer captain_id;

	/** applicantName */
	@Column(name = "applicant_name", nullable = true, length = 100)
	private String applicant_name;

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

	public Integer getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(Integer applicant_id) {
		this.applicant_id = applicant_id;
	}

	public Integer getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(Integer captain_id) {
		this.captain_id = captain_id;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

}