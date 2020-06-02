package com.ssm.chapter.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.chapter.pojo.docker;
import com.ssm.chapter.service.AwdService;
import com.ssm.chapter.service.DockerService;
import com.ssm.chapter.pojo.AwdteamEntity;
import com.ssm.chapter.pojo.SshService;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.ssm.chapter.dao.DockerDao;

@Service
public class DockerServiceimpl implements DockerService {

	@Autowired
	private DockerDao dockerDao = null;

	@Autowired
	private AwdService awdserivce = null;

	@Override
	public docker findDockerByIds(int id) {
		// TODO Auto-generated method stub
		return dockerDao.findDockerByIds(id);
	}

	@Override
	public boolean insertDocker(docker docker) {
		// TODO Auto-generated method stub
		return dockerDao.insertDocker(docker);
	}

	// docker链接

	@Override
	public DockerClient DockerContnet(String ip, int port) {
		// TODO Auto-generated method stub
		try {
			File file = new File("/usr/certs");
			file.createNewFile();
			DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
					.withDockerHost("tcp://" + ip + ":" + port).withApiVersion("1.26") // optional
					.withDockerTlsVerify(true).withDockerCertPath("/usr/certs").build();
			DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();
			return dockerClient;
		} catch (

		Exception e) {
			return null;
		}
	}

	/**
	 * 远程执行shell
	 * 
	 * @param args
	 * @throws IOException
	 */
	public  String Exeshell(SshService tool, String cmd) {
		try {
			StringBuilder exec;
			exec = tool.exec(cmd);
			return exec.toString();
		} catch (IOException e) {
			return "error";
		}

	}

	public  SshService ShellConet(String ip, String name, String passwd) {
		SshService tool = new SshService(ip, name, passwd, StandardCharsets.UTF_8);
		return tool;
	}

	public boolean Directory(String ip, String name, String passwd, String model, int count) {
		try {

			String game = model;
			SshService tool = ShellConet(ip, name, passwd);
			String cmd = "mkdir -p /usr/erbaoawd/team/{1.." + count + "}";
			Exeshell(tool, cmd);
			for (int i = 1; i <= count; i++) {
				cmd = "cp -r /usr/erbaoawd/gamemodel/" + game + "/. /usr/erbaoawd/team/" + i;
				Exeshell(tool, cmd);
				cmd = "cp -r /usr/erbaoawd/run.sh /usr/erbaoawd/team/" + i;
				Exeshell(tool, cmd);
				cmd = "docker run -p " + (8800 + i) + ":80 " + "-p " + (2200 + i) + ":22 -v /usr/erbaoawd/team/" + i
						+ ":/var/www/html -d" + " --name team" + i + " -ti web_14.04 /var/www/html/run.sh";
				System.out.println(cmd);
				Exeshell(tool, cmd);
			}
			List<AwdteamEntity> a = awdserivce.getawds();
			AwdteamEntity awdteamEntity = new AwdteamEntity();
			DockerClient dockerClient = DockerContnet("127.0.0.1", 2375);
			if (dockerClient == null) {
				return false;
			} else {
				List<Container> b = dockerClient.listContainersCmd().exec();
				Container container = new Container();
				for (int i = 0; i < a.size(); i++) {
					awdteamEntity = a.get(i);
					container = b.get(i);
					awdteamEntity.setIpaddr(container.getId());
					awdserivce.updateAwdteam(awdteamEntity);
				}

				return true;

			}

		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean off(String id) {
		// TODO Auto-generated method stub
		DockerClient dockerClient = DockerContnet("127.0.0.1", 2375);
		if (dockerClient == null) {
			return false;
		} else {
			dockerClient.stopContainerCmd(id).exec();
			return true;
		}
	}

	@Override
	public boolean on(String id) {
		// TODO Auto-generated method stub
		DockerClient dockerClient = DockerContnet("127.0.0.1", 2375);
		if (dockerClient == null) {
			return false;
		} else {
			dockerClient.startContainerCmd(id).exec();
			return true;
		}
	}


	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		DockerClient dockerClient = DockerContnet("127.0.0.1", 2375);
		if (dockerClient == null) {
			return false;
		} else {
			dockerClient.removeContainerCmd(id).exec();
			return true;
		}
	}

	@Override
	public boolean offall() {
		// TODO Auto-generated method stub
		SshService tool = ShellConet("127.0.0.1", "root", "这里填docker服务器密码");
		String cmd = "/usr/erbaoawd/./stop.sh";
		Exeshell(tool, cmd);
		return true;
	}

	@Override
	public boolean onall() {
		// TODO Auto-generated method stub
		SshService tool = ShellConet("127.0.0.1", "root", "这里填docker服务器密码");
		String cmd = "/usr/erbaoawd/./start.sh";
		Exeshell(tool, cmd);
		return true;
	}

	@Override
	public String cmd(String cmd) {
		SshService tool = ShellConet("127.0.0.1", "root", "这里填docker服务器密码");
		return Exeshell(tool, cmd);
	}

	@Override
	public boolean deleteall() {
		// TODO Auto-generated method stub
		SshService tool = ShellConet("127.0.0.1", "root", "这里填docker服务器密码");
		String cmd = "/usr/erbaoawd/./dele.sh";
		Exeshell(tool, cmd);
		return true;
	}

}
