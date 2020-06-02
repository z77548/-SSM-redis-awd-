package com.ssm.chapter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;

@Repository
public interface OrdinaryUsersDao {

	// 通过用户名获取一个用户
	public OrdinaryUsers getOrdinaryUsers(String name);

	// 通过用户ID获取用户信息
	public OrdinaryUsers getOrdinaryUsersByUserId(int UserId);

	// 插入新注册用户
	public int insertSigner(Signer signer);

	// 通过用户名or真实姓名or身份号查找用户
	public OrdinaryUsers getOrdinaryUsersByIdcard(String name, String truename, String idcard);

	// 修改MAC地址
	public boolean changeMac(@Param("mac") String mac, @Param("UserId") int UserId);

	// 修改个人信息
	public boolean changePersonal(@Param("iphone") String iphone, @Param("email") String email,
			@Param("passwd") String passwd, @Param("UserId") int UserId);

	public int getUserTeamId(int UserId);

	public boolean quitTeam(int UserId);

	public boolean changeTeam(@Param("TeamId") int TeamId, @Param("UserId") int UserId);

	public boolean changeall(OrdinaryUsers ordinaryUsers);

	public List<OrdinaryUsers> getlist();

	public boolean delea(int id);
}
