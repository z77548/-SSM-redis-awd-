package com.ssm.chapter.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**ע��**/
public class Signer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1917282854021615436L;
	private int id;          //�û�ID
	@NotNull
	@Size(min=0,max=256)
	private String  name;    //�û���
	@NotNull
	@Size(min=0,max=256)
	@Pattern(regexp="^[\\\\u4e00-\\\\u9fa5.��\\\\u36c3\\\\u4DAE]{0,4}$" ,message="��ʵ������ʽ����")
	private String truename; //��ʵ����
	@NotNull
	@Size(min=0,max=256)
	private String passwd;   //����
	@NotNull
	@Size(min=0,max=256)
	@Pattern(regexp="\\\\d{15}(\\\\d{2}[0-9xX])?" ,message="���֤��ʽ����")
	private String idcard;   //���֤����
	@NotNull
	@Size(min=0,max=256)
	private String iphone;   //�ֻ�����
	@NotNull
	@Size(min=0,max=256)
	@Pattern(regexp="^\\\\s*\\\\w+(?:\\\\.{0,1}[\\\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\\\.[a-zA-Z]+\\\\s*$" ,message="�ʼ���ʽ����")
	private String email;    //�ʼ�
	@NotNull
	@Size(min=0,max=256)
	private int type;        //������ͣ���ͨ�û�������Ա��
	@NotNull
	@Size(min=0,max=256)
	private int team_id;     //����ID   Ĭ�ϣ�0δ�μӶ���
	@NotNull
	@Size(min=0,max=256)
	private int captain;     //�ӳ�       Ĭ�ϣ�0��ͨ�û�  1�Ƕӳ�
	@NotNull
	@Size(min=0,max=256)
	private String mac;      //Mac��ַ��Ĭ��:null
	
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

