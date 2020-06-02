package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.InsertTeam;
import com.ssm.chapter.pojo.TeamInformation;

public interface TeamInformationService {
	public TeamInformation getTeamInformation(int UserId);

	public TeamInformation getTeamCount(int id);

	public TeamInformation getTeamByName(String Name);

	public InsertTeam insertTeam(InsertTeam insertTeam);

	public boolean updateTeam(TeamInformation teamInformation);

	public boolean delete(int id);
	

	public List<TeamInformation> getTeams();
}
