package com.ssm.chapter.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**注册**/
public class Signer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1917282854021615436L;
	private int id;          //用户ID
	@NotNull
	@Size(min=0,max=256)
	private String  name;    //用户名
	@NotNull
	@Size(min=0,max=256)
	@Pattern(regexp="^[\\\\u4e00-\\\\u9fa5.·\\\\u36c3\\\\u4DAE]{0,4}$" ,message="真实姓名格式错误")
	private String truename; //真实姓名
	@NotNull
	@Size(min=0,max=256)
	private String passwd;   //密码
	@NotNull
	@Size(min=0,max=256)
	@Pattern(regexp="\\\\d{15}(\\\\d{2}[0-9xX])?" ,message="身份证格式错误")
	private String idcard;   //身份证号码
	@NotNull
	@Size(min=0,max=256)
	private String iphone;   //手机号码
	@NotNull
	@Size(min=0,max=256)
	@Pattern(regexp="^\\\\s*\\\\w+(?:\\\\.{0,1}[\\\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\\\.[a-zA-Z]+\\\\s*$" ,message="邮件格式错误")
	private String email;    //邮件
	@NotNull
	@Size(min=0,max=256)
	private int type;        //身份类型（普通用户，管理员）
	@NotNull
	@Size(min=0,max=256)
	private int team_id;     //队伍ID   默认：0未参加队伍
	@NotNull
	@Size(min=0,max=256)
	private int captain;     //队长       默认：0普通用户  1是队长
	@NotNull
	@Size(min=0,max=256)
	private String mac;      //Mac地址默认:null
	
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	
}

