package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.AwdteamEntity;

public interface AwdService {
	public AwdteamEntity findDockerByIds(int id);

	public  AwdteamEntity insertAwd(AwdteamEntity awdteamEntity);

	public AwdteamEntity updateAwdteam(AwdteamEntity awdteamEntity);

	public List<AwdteamEntity> getawds();

	public AwdteamEntity getOneawdbyflag(String flag);

	public AwdteamEntity getOneawd(int teamid);

	public AwdteamEntity getOneawd2(String ipaddr);
}
