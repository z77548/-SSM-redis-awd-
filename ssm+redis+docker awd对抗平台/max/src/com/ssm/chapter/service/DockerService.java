package com.ssm.chapter.service;

import com.github.dockerjava.api.DockerClient;
import com.ssm.chapter.pojo.docker;

public interface DockerService {
	public docker findDockerByIds(int id);

	public boolean insertDocker(docker docker);

	public boolean Directory(String ip, String name, String passwd, String model, int count);

	DockerClient DockerContnet(String ip, int port);

	public boolean off(String id);

	public boolean on(String id);

	public boolean delete(String id);

	public boolean offall();

	public boolean onall();

	public boolean deleteall();

	public String cmd(String cmd) ;
}
