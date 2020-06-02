package com.ssm.chapter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;

@Repository
public interface OrdinaryUsersDao {

	// ͨ���û�����ȡһ���û�
	public OrdinaryUsers getOrdinaryUsers(String name);

	// ͨ���û�ID��ȡ�û���Ϣ
	public OrdinaryUsers getOrdinaryUsersByUserId(int UserId);

	// ������ע���û�
	public int insertSigner(Signer signer);

	// ͨ���û���or��ʵ����or��ݺŲ����û�
	public OrdinaryUsers getOrdinaryUsersByIdcard(String name, String truename, String idcard);

	// �޸�MAC��ַ
	public boolean changeMac(@Param("mac") String mac, @Param("UserId") int UserId);

	// �޸ĸ�����Ϣ
	public boolean changePersonal(@Param("iphone") String iphone, @Param("email") String email,
			@Param("passwd") String passwd, @Param("UserId") int UserId);

	public int getUserTeamId(int UserId);

	public boolean quitTeam(int UserId);

	public boolean changeTeam(@Param("TeamId") int TeamId, @Param("UserId") int UserId);

	public boolean changeall(OrdinaryUsers ordinaryUsers);

	public List<OrdinaryUsers> getlist();

	public boolean delea(int id);
}
