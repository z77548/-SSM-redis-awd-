package com.ssm.chapter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.InsertTeam;
import com.ssm.chapter.pojo.TeamInformation;

@Repository
public interface TeamInformationDao {

	public TeamInformation getTeamInformation(int UserId);

	public TeamInformation getTeamCount(int Id);

	public TeamInformation getTeamByName(String Name);

	public int insertTeam(InsertTeam insertTeam);

	public boolean updateTeam(TeamInformation teamInformation);

	public boolean delete(int id);

	public List<TeamInformation> getTeams();

}
