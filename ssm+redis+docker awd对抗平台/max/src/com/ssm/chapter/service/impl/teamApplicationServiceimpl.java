package com.ssm.chapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.pojo.TeamApplicationEntity;
import com.ssm.chapter.service.teamApplicationService;
import com.ssm.chapter.dao.teamApplicationDao;

@Service
public class teamApplicationServiceimpl implements teamApplicationService {

	@Autowired
	private teamApplicationDao teamApplicationDao = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)

	public TeamApplicationEntity insertTeAp(TeamApplicationEntity teamApplicationEntity) {
		// TODO Auto-generated method stub
		teamApplicationDao.insert(teamApplicationEntity);
		return teamApplicationEntity;
	}

	@Override
	public List<TeamApplicationEntity> getteamApplication(int UserId) {
		// TODO Auto-generated method stub
		return teamApplicationDao.getteamApplication(UserId);
	}

	@Override
	public TeamApplicationEntity getteamAppById(int id) {
		// TODO Auto-generated method stub
		return teamApplicationDao.getteamAppById(id);
	}

	@Override
	public boolean deleteapp(int id) {
		// TODO Auto-generated method stub
		return teamApplicationDao.deleteapp(id);
	}

}
