package com.ssm.chapter.service;

import com.ssm.chapter.pojo.docker;

public interface testService {
	public docker findDockerByIds(int id);

	public boolean insertDocker(docker docker);

	public boolean Directory(String ip, String name, String passwd, String model, int count);
}
