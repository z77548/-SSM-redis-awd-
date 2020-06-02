package com.ssm.chapter.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.github.dockerjava.api.DockerClient;
import com.ssm.chapter.pojo.AwdteamEntity;
import com.ssm.chapter.pojo.Event;
import com.ssm.chapter.service.AwdService;
import com.ssm.chapter.service.DockerService;
import com.ssm.chapter.service.EventService;

@EnableScheduling

@Controller()
public class FlagController {
	@Autowired
	private DockerService dockerService = null;
	@Autowired
	private EventService eventService = null;
	@Autowired
	private AwdService awdService = null;

	@Scheduled(cron = "0 0/30 * * * ?")
	public void getNews() {
		Event event = eventService.findAwdEvent();
		if (event == null) {
			System.out.println("没有AWD比赛");
		} else {
			if (eventService.TimeCheck(event)) {
				System.out.println("比赛开始");
				DockerClient dockerClient = dockerService.DockerContnet("175.24.33.212", 2375);
				if (dockerClient == null) {
					System.out.println("docker 服务器失败");
				}
				List<AwdteamEntity> b = awdService.getawds();
				AwdteamEntity awdteamEntity = new AwdteamEntity();
				for (int i = 0; i < b.size(); i++) {
					awdteamEntity = b.get(i);
					String str = getRandomString(35);
					String id = awdteamEntity.getIpaddr();
					dockerClient.copyArchiveToContainerCmd(id).withHostResource("flag").withRemotePath("/").exec();
					awdteamEntity.setFlag(str);
					awdteamEntity.setStates("0");
					awdService.updateAwdteam(awdteamEntity);
					System.out.println("复制完" + str);
				}
			} else {
				System.out.println("比赛还没有开始");
			}
		}
	}

	public String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		try {
			File file = new File("flag");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWritter = new FileWriter(file.getName(), false);
			fileWritter.write(sb.toString());
			fileWritter.close();
			return sb.toString();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return "false";
		}

	}

}