package com.ssm.chapter.pojo;

import java.io.Serializable;

public class TeamInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 642643836569803942L;
	private int id; // ս��ID
	private String name; // ս������
	private int captain_id; // �ӳ�ID
	private int team_member_1_id; // ��Ա1 ID
	private int team_member_2_id; // ��Ա2 ID
	private String captain_name; // �ӳ�����
	private String team_member_1_name; // ��Ա1����
	private String team_member_2_name;// ��Ա2����
	private String event_id;
	private int count; // ս������

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

	public int getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(int captain_id) {
		this.captain_id = captain_id;
	}

	public int getTeam_member_1_id() {
		return team_member_1_id;
	}

	public void setTeam_member_1_id(int team_member_1_id) {
		this.team_member_1_id = team_member_1_id;
	}

	public int getTeam_member_2_id() {
		return team_member_2_id;
	}

	public void setTeam_member_2_id(int team_member_2_id) {
		this.team_member_2_id = team_member_2_id;
	}

	public String getCaptain_name() {
		return captain_name;
	}

	public void setCaptain_name(String captain_name) {
		this.captain_name = captain_name;
	}

	public String getTeam_member_1_name() {
		return team_member_1_name;
	}

	public void setTeam_member_1_name(String team_member_1_name) {
		this.team_member_1_name = team_member_1_name;
	}

	public String getTeam_member_2_name() {
		return team_member_2_name;
	}

	public void setTeam_member_2_name(String team_member_2_name) {
		this.team_member_2_name = team_member_2_name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

}
