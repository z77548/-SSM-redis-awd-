package com.ssm.chapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.pojo.InsertTeam;
import com.ssm.chapter.pojo.TeamInformation;
import com.ssm.chapter.service.TeamInformationService;
import com.ssm.chapter.dao.TeamInformationDao;

@Service
public class TeamInformationServiceimpl implements TeamInformationService {

	@Autowired
	private TeamInformationDao TeamInformationDao = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public TeamInformation getTeamInformation(int UserId) {

		return TeamInformationDao.getTeamInformation(UserId);

	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public TeamInformation getTeamCount(int Id) {
		return TeamInformationDao.getTeamCount(Id);

	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public TeamInformation getTeamByName(String Name) {
		// TODO Auto-generated method stub
		return TeamInformationDao.getTeamByName(Name);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public InsertTeam insertTeam(InsertTeam insertTeam) {
		// TODO Auto-generated method stub
		TeamInformationDao.insertTeam(insertTeam);
		return insertTeam;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)

	public boolean updateTeam(TeamInformation teamInformation) {
		// TODO Auto-generated method stub
		return TeamInformationDao.updateTeam(teamInformation);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return TeamInformationDao.delete(id);
	}

	@Override
	public List<TeamInformation> getTeams() {
		// TODO Auto-generated method stub
		return TeamInformationDao.getTeams();
	}

}
