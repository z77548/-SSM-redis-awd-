package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;

public interface OrdinaryUsersService {
	// 登陆验证
	public OrdinaryUsers LoginVerification(String name);

	// 注册验证是否存在
	public OrdinaryUsers signVerification(String name, String truename, String idcard);

	// 插入注册用户
	public Signer InsertSigner(Signer signer);

	// 修改MAC地址
	public OrdinaryUsers ChangeMac(OrdinaryUsers ordinaryUsers);

	// 修改个人信息
	public OrdinaryUsers ChangePersonal(OrdinaryUsers ordinaryUsers);
	// 查看是否加入战队

	public int getUserTeamId(int UserId);

	public OrdinaryUsers getOrdinaryUsersByUserId(int UserId);

	// 改队长和teamid
	public OrdinaryUsers changeall(OrdinaryUsers ordinaryUsers);
	public List<OrdinaryUsers> getOrdinaryUsersByUsers();
	public boolean delete(int id);
}
