package com.ssm.chapter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.AwdteamEntity;

@Repository
public interface AwdDao {
	public AwdteamEntity findDockerByIds(int id);

	public boolean insertAwd(AwdteamEntity awdteamEntity);

	public boolean updateAwdteam(AwdteamEntity awdteamEntity);

	public List<AwdteamEntity> getawds();

	public AwdteamEntity getOneawd(String ipaddr);

	public AwdteamEntity getOneawdbyflag(String flag);

	public AwdteamEntity getOneawdbytemid(int teamid);
}
