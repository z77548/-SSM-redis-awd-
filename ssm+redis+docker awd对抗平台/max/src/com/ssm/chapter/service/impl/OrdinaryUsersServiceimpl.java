package com.ssm.chapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;
import com.ssm.chapter.service.OrdinaryUsersService;
import com.ssm.chapter.dao.OrdinaryUsersDao;

@Service
public class OrdinaryUsersServiceimpl implements OrdinaryUsersService {

	@Autowired
	private OrdinaryUsersDao OrdinaryUsersDao = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Cacheable(value = "redisCacheManager", key = "'redis_user_'+#name")
	public OrdinaryUsers LoginVerification(String name) {
		return OrdinaryUsersDao.getOrdinaryUsers(name);

	}

	@Override
	public OrdinaryUsers signVerification(String name, String truename, String idcard) {
		// TODO Auto-generated method stub

		return OrdinaryUsersDao.getOrdinaryUsersByIdcard(name, truename, idcard);

	}

	// 插入新注册用户
	@Override
	@CachePut(value = "redisCacheManager", key = "'redis_user_'+#result.name")
	public Signer InsertSigner(Signer signer) {

		OrdinaryUsersDao.insertSigner(signer);
		return signer;

	}

	// 修改MAC地址
	@Override
	@CachePut(value = "redisCacheManager", key = "'redis_user_'+#result.name")
	public OrdinaryUsers ChangeMac(OrdinaryUsers ordinaryUsers) {
		// TODO Auto-generated method stub
		OrdinaryUsersDao.changeMac(ordinaryUsers.getMac(), ordinaryUsers.getId());
		return ordinaryUsers;
	}

	// 修改个人信息
	@Override
	@CachePut(value = "redisCacheManager", key = "'redis_user_'+#result.name")
	public OrdinaryUsers ChangePersonal(OrdinaryUsers ordinaryUsers) {
		OrdinaryUsersDao.changePersonal(ordinaryUsers.getIphone(), ordinaryUsers.getEmail(), ordinaryUsers.getPasswd(),
				ordinaryUsers.getId());
		return ordinaryUsers;
	}

	// 查看是否加入战队
	@Override
	public int getUserTeamId(int UserId) {
		// TODO Auto-generated method stub
		return OrdinaryUsersDao.getUserTeamId(UserId);
	}

	@Override
	public OrdinaryUsers getOrdinaryUsersByUserId(int UserId) {
		// TODO Auto-generated method stub
		return OrdinaryUsersDao.getOrdinaryUsersByUserId(UserId);
	}

	@Override
	@CachePut(value = "redisCacheManager", key = "'redis_user_'+#result.name")
	public OrdinaryUsers changeall(OrdinaryUsers ordinaryUsers) {
		// TODO Auto-generated method stub
		OrdinaryUsersDao.changeall(ordinaryUsers);
		return ordinaryUsers;
	}
	@Override
	public List<OrdinaryUsers> getOrdinaryUsersByUsers() {
		// TODO Auto-generated method stub
		return OrdinaryUsersDao.getlist();
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		 OrdinaryUsersDao.delea(id);
		 return true;
	}

}
