package com.ssm.chapter.dao;

import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.docker;

@Repository
public interface DockerDao {
	public docker findDockerByIds(int id);

	public boolean insertDocker(docker docker);
	

}
