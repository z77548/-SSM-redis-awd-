package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.TeamApplicationEntity;

public interface teamApplicationService {
	public TeamApplicationEntity insertTeAp(TeamApplicationEntity teamApplicationEntity);

	public List<TeamApplicationEntity> getteamApplication(int UserId);

	public TeamApplicationEntity getteamAppById(int id);

	public boolean deleteapp(int id);
}
