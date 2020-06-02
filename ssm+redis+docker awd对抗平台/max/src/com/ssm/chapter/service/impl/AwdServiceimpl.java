package com.ssm.chapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.ssm.chapter.pojo.AwdteamEntity;
import com.ssm.chapter.service.AwdService;
import com.ssm.chapter.dao.AwdDao;

@Service
public class AwdServiceimpl implements AwdService {

	@Autowired
	private AwdDao awdDao = null;

	@Override
	public AwdteamEntity findDockerByIds(int id) {
		// TODO Auto-generated method stub
		return awdDao.findDockerByIds(id);
	}

	@Override
	@CachePut(value = "redisCacheManager", key = "'redis_awd_'+#id")
	public AwdteamEntity insertAwd(AwdteamEntity awdteamEntity) {
		// TODO Auto-generated method stub

		try {
			awdDao.insertAwd(awdteamEntity);

		} catch (Exception e) {

			return awdteamEntity;
		}
		return awdteamEntity;
	}

	@Override
	@CachePut(value = "redisCacheManager", key = "'redis_awd_'+#id")
	public AwdteamEntity updateAwdteam(AwdteamEntity awdteamEntity) {
		// TODO Auto-generated method stub
		try {
			awdDao.updateAwdteam(awdteamEntity);
		} catch (Exception e) {

			return awdteamEntity;
		}
		return awdteamEntity;

	}

	@Override
	public List<AwdteamEntity> getawds() {
		// TODO Auto-generated method stub
		return awdDao.getawds();
	}

	@Override
	@Cacheable(value = "redisCacheManager", key = "'redis_awd_'+#id")
	public AwdteamEntity getOneawd2(String ipaddr) {
		// TODO Auto-generated method stub
		return awdDao.getOneawd(ipaddr);
	}

	@Override
	@Cacheable(value = "redisCacheManager", key = "'redis_awd_'+#id")
	public AwdteamEntity getOneawd(int teamid) {
		// TODO Auto-generated method stub
		return awdDao.getOneawdbytemid(teamid);
	}

	@Override
	public AwdteamEntity getOneawdbyflag(String flag) {
		// TODO Auto-generated method stub
		return awdDao.getOneawdbyflag(flag);
	}

}
