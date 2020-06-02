package com.ssm.chapter.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Info;
import com.ssm.chapter.pojo.AwdteamEntity;
import com.ssm.chapter.pojo.ChooseTopicEntity;
import com.ssm.chapter.pojo.Event;
import com.ssm.chapter.pojo.FileTopicEntity;
import com.ssm.chapter.pojo.MultipleTopicEntity;
import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.TeamInformation;
import com.ssm.chapter.pojo.docker;
import com.ssm.chapter.service.AwdService;
import com.ssm.chapter.service.DockerService;
import com.ssm.chapter.service.EventService;
import com.ssm.chapter.service.OrdinaryUsersService;
import com.ssm.chapter.service.TeamInformationService;
import com.ssm.chapter.service.TopicService;

@Controller()
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EventService eventService = null;
	@Autowired
	private DockerService dockerService = null;
	@Autowired
	private AwdService awdService = null;
	@Autowired
	private TeamInformationService teamService = null;
	@Autowired
	private TopicService topicService = null;
	@Autowired
	private OrdinaryUsersService userService = null;

	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/index");
		return mv;
	}

	@RequestMapping("/release.do")
	public ModelAndView release() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/release");
		return mv;
	}

	@RequestMapping("/management.do")
	public ModelAndView management() {
		ModelAndView mv = new ModelAndView();
		List<Event> list = eventService.getEvents();
		mv.addObject("list", list);
		mv.setViewName("admin/management");
		return mv;
	}

	@RequestMapping("/title.do")
	public ModelAndView title() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/title");
		return mv;
	}

	@RequestMapping("/docker.do")
	public ModelAndView docker() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/docker");
		return mv;
	}

	@RequestMapping("/dockersubmit.do")
	@ResponseBody
	public boolean dockersubmit(String model, String count, String eventid, String ipaddr) {
		try {
			docker docker = new docker();
			int count1 = Integer.parseInt(count);
			docker.setCount(count1);
			docker.setEventid(Integer.parseInt(eventid));
			docker.setIpaddr(ipaddr);
			docker.setModel(model);
			dockerService.insertDocker(docker);
			if (dockerService.Directory(ipaddr, "root", "z9958258Z", model, count1) == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = "/releasesubmit.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public boolean releasesubmit(MultipartFile file, String name, String intime, String outtime, String jianjie,
			int pid) {
		String fileName = file.getOriginalFilename();
		file.getContentType();
		File dest = new File(fileName);
		try {
			file.transferTo(dest);
			Event event = new Event();
			event.setName(name);
			event.setIntime(intime);
			event.setOutime(outtime);
			event.setJianjie(jianjie);
			event.setFile(fileName);
			if (pid == 1) {
				event.setAwd(0);
			} else if (pid == 2) {
				event.setAwd(1);
			} else {
				return false;
			}
			if (eventService.insertEvent(event)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	@RequestMapping("/ranking.do")
	public ModelAndView ranking() {
		ModelAndView mv = new ModelAndView();
		List<AwdteamEntity> list = awdService.getawds();
		mv.addObject("list", list);
		mv.setViewName("admin/dockersm");
		return mv;
	}

	@RequestMapping(value = "/rankings.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String rankings() {
		List<AwdteamEntity> list = awdService.getawds();
		String resultJson = JSONObject.toJSONString(list);
		return resultJson;
	}

	// 服务器页面 OK
	@RequestMapping("/Service.do")
	public ModelAndView Service() {
		ModelAndView mv = new ModelAndView();
		DockerClient dockerClient = dockerService.DockerContnet("127.0.0.1", 2375);
		List<Container> b = dockerClient.listContainersCmd().exec();
		Info info = dockerClient.infoCmd().exec();
		mv.addObject("dockerlist", b);
		mv.addObject("info", info);
		mv.setViewName("admin/Service");
		return mv;
	}

	// 战队管理页面 OK
	@RequestMapping("/TeamMan.do")
	public ModelAndView TeamMan() {
		ModelAndView mv = new ModelAndView();
		List<TeamInformation> list = teamService.getTeams();
		mv.addObject("list", list);
		mv.setViewName("admin/TeamMan");
		return mv;
	}

	// 用户管理页面 OK
	@RequestMapping("/UserMan.do")
	public ModelAndView UserMan() {
		ModelAndView mv = new ModelAndView();
		List<OrdinaryUsers> list = userService.getOrdinaryUsersByUsers();
		mv.addObject("list", list);
		mv.setViewName("admin/UserMan");
		return mv;
	}

	// 删除用户 OK
	@RequestMapping(value = "/DeleteUser.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String DeleteUser(String id) {
		if (userService.delete(Integer.parseInt(id))) {
			return "true";
		} else {
			return "false";
		}
	}

	// 删除战队 OK
	@RequestMapping(value = "/DeleteTeam.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String DeleteTeam(String id) {
		if (teamService.delete(Integer.parseInt(id))) {
			return "true";
		} else {
			return "false";
		}
	}

	// 修改用户信息页面 OK
	@RequestMapping("/ChangeUsery.do")
	public ModelAndView ChangeUsery(String Name) {
		ModelAndView mv = new ModelAndView();
		OrdinaryUsers newordinaryUsers = userService.LoginVerification(Name);
		mv.addObject("newordinaryUsers", newordinaryUsers);
		mv.setViewName("admin/Personal_information");
		return mv;
	}

	// 修改用户信息 OK
	@RequestMapping(value = "/ChangeUser.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String ChangeUser(String iphone, String email, String passwd) {
		OrdinaryUsers ordinaryUsers = new OrdinaryUsers();
		ordinaryUsers.setEmail(email);
		ordinaryUsers.setIphone(iphone);
		ordinaryUsers.setPasswd(passwd);
		userService.ChangePersonal(ordinaryUsers);
		return "true";
	}

	// 赛事删除 OK
	@RequestMapping(value = "/DeletEvent.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String ChangeUser(int id) {
		if (eventService.deleteEvent(id)) {
			return "true";
		} else {
			return "false";
		}
	}

	// 显示所有题目 OK
	@RequestMapping("/topicall.do")
	public ModelAndView topicall() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("choose", topicService.getChooseTopicList());
		mv.addObject("multiple", topicService.getMultipleTopicList());
		mv.addObject("file", topicService.getFileTopicList());
		mv.setViewName("admin/topicall");
		return mv;
	}

	// 删除题目
	@RequestMapping("/deletTopic.do")
	public String deletTopic(int id, String type) {
		return topicService.deletetopic(id, type);
	}

	// 新建题目
	@RequestMapping("/submitTopic.do")
	@ResponseBody
	public boolean submitTopic(int id, int type) {
		if (type == 1) {
			ChooseTopicEntity topic = new ChooseTopicEntity();
			return topicService.newchoosetopic(topic);
		} else if (type == 2) {
			MultipleTopicEntity topic = new MultipleTopicEntity();

			return topicService.newmultchoosetopic(topic);
		} else if (type == 3) {
			FileTopicEntity topic = new FileTopicEntity();
			return topicService.newfiletopic(topic);
		}
		return false;

	}

	// 关闭容器
	@RequestMapping(value = "/off.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String off(String id) {
		dockerService.off(id);
		return "关闭成功";
	}

	// 开启容器
	@RequestMapping(value = "/on.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String on(String id) {
		dockerService.on(id);
		return "开启成功";
	}

	// 删除容器
	@RequestMapping(value = "/dele.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String dele(String id) {
		dockerService.delete(id);
		return "删除成功";
	}

	// 开启所有容器
	@RequestMapping(value = "/onall.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String onall() {
		dockerService.onall();
		return "开启成功";
	}

	// 关闭所有容器
	@RequestMapping(value = "/offall.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String offall() {
		dockerService.offall();
		return "关闭成功";
	}

	// 删除所有容器
	@RequestMapping(value = "/deleall.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String deleall(String id) {
		dockerService.deleteall();
		return "删除成功";
	}
	@RequestMapping(value = "/cmdexe.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String cmdexe(String cmd) {
		return	dockerService.cmd(cmd);
	}
}