package com.ssm.chapter.pojo;

import java.io.Serializable;

public class Accout implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;          //用户ID
	private String  name;    //用户�?
	private String truename; //真实名称
	private String passwd;
	private String idcard;   //身份�?
	private String iphone;   //电话号码
	private String email;    //邮件地址
	private int type;        //用户类型 0普�?�用�?  1管理�?
	private int team_id;     //战队ID   默认0未加入战�?
	private int captain;     //是否为队�?  0普�?�用�? 1队长
	private String mac;      //Mac地址  默认null
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
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getCaptain() {
		return captain;
	}
	public void setCaptain(int captain) {
		this.captain = captain;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
