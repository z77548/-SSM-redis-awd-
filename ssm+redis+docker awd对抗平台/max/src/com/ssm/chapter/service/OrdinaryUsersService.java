package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;

public interface OrdinaryUsersService {
	// ��½��֤
	public OrdinaryUsers LoginVerification(String name);

	// ע����֤�Ƿ����
	public OrdinaryUsers signVerification(String name, String truename, String idcard);

	// ����ע���û�
	public Signer InsertSigner(Signer signer);

	// �޸�MAC��ַ
	public OrdinaryUsers ChangeMac(OrdinaryUsers ordinaryUsers);

	// �޸ĸ�����Ϣ
	public OrdinaryUsers ChangePersonal(OrdinaryUsers ordinaryUsers);
	// �鿴�Ƿ����ս��

	public int getUserTeamId(int UserId);

	public OrdinaryUsers getOrdinaryUsersByUserId(int UserId);

	// �Ķӳ���teamid
	public OrdinaryUsers changeall(OrdinaryUsers ordinaryUsers);
	public List<OrdinaryUsers> getOrdinaryUsersByUsers();
	public boolean delete(int id);
}
