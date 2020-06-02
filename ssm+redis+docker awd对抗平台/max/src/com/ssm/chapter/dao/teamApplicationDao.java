package com.ssm.chapter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.TeamApplicationEntity;

@Repository
public interface teamApplicationDao {

	public boolean insert(TeamApplicationEntity teamApplicationEntity);

	public List<TeamApplicationEntity> getteamApplication(int UserId);

	public TeamApplicationEntity getteamAppById(int id);

	public boolean deleteapp(int id);
}
