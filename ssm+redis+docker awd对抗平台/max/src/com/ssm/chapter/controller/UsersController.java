package com.ssm.chapter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.ssm.chapter.pojo.AwdteamEntity;
import com.ssm.chapter.pojo.ChooseTopicEntity;
import com.ssm.chapter.pojo.Event;
import com.ssm.chapter.pojo.FileTopicEntity;
import com.ssm.chapter.pojo.InsertTeam;
import com.ssm.chapter.pojo.MultipleTopicEntity;
import com.ssm.chapter.pojo.OneNew;
import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.TeamApplicationEntity;
import com.ssm.chapter.pojo.TeamInformation;
import com.ssm.chapter.service.AwdService;
import com.ssm.chapter.service.CheckService;
import com.ssm.chapter.service.DockerService;
import com.ssm.chapter.service.EventService;
import com.ssm.chapter.service.NewsService;
import com.ssm.chapter.service.OrdinaryUsersService;
import com.ssm.chapter.service.TeamInformationService;
import com.ssm.chapter.service.TopicService;
import com.ssm.chapter.service.teamApplicationService;

@Controller
@RequestMapping("/user")
@SessionAttributes(types = { OrdinaryUsers.class })
public class UsersController {

	@Autowired
	private OrdinaryUsersService ordinaryUsersService = null;
	@Autowired
	private TeamInformationService teamInformationService = null;
	@Autowired
	private NewsService newsService = null;
	@Autowired
	private EventService eventService = null;
	@Autowired
	private TopicService topicService = null;
	@Autowired
	private teamApplicationService teamapplicationService = null;
	@Autowired
	private CheckService checkService = null;
	@Autowired
	private AwdService awdService = null;

	@Autowired
	private DockerService dockerService = null;

	@RequestMapping("/Navigation.do")
	public ModelAndView home(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		if (ordinaryUsers.getType() == 0) {
			ModelAndView mv = new ModelAndView();
			List<OneNew> list = newsService.getNewsList(ordinaryUsers.getId());
			mv.addObject("list", list);
			mv.addObject("count", list.size());
			mv.setViewName("user/Navigation");
			return mv;
		}
		return null;

	}

	/** 战队信息页面 **/
	@RequestMapping(value = "/TeamInformation.do", method = RequestMethod.GET)
	public ModelAndView TeamInformation(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		TeamInformation TeamInformation = teamInformationService.getTeamInformation(ordinaryUsers.getId());
		mv.addObject("TeamInformation", TeamInformation);
		mv.setViewName("user/TeamInformation");
		return mv;
	}

	/** MAC地址读取 **/
	@RequestMapping(value = "/Mac.do", method = RequestMethod.GET)
	public ModelAndView Mac(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		OrdinaryUsers newordinaryUsers = ordinaryUsersService.LoginVerification(ordinaryUsers.getName());
		mv.addObject("mac", newordinaryUsers.getMac());
		mv.setViewName("user/System_settings");
		return mv;
	}

	/** MAC地址修改 **/
	@RequestMapping(value = "/MacChange.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean MacChange(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, String mac, Model model) {
		try {
			ordinaryUsers.setMac(mac);
			ordinaryUsersService.ChangeMac(ordinaryUsers);
			model.addAttribute("user", ordinaryUsers);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** 个人信息读取 **/
	@RequestMapping(value = "/Personal_information.do", method = RequestMethod.GET)
	public ModelAndView Personal_information(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		OrdinaryUsers newordinaryUsers = ordinaryUsersService.LoginVerification(ordinaryUsers.getName());
		mv.addObject("newordinaryUsers", newordinaryUsers);
		mv.setViewName("user/Personal_information");
		return mv;
	}

	/** 个人信息修改 **/
	@RequestMapping(value = "/PersonalChange.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean PersonalChange(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, Model model, String iphone,
			String email, String passwd) {
		try {
			ordinaryUsers.setEmail(email);
			ordinaryUsers.setIphone(iphone);
			ordinaryUsers.setPasswd(passwd);
			ordinaryUsersService.ChangePersonal(ordinaryUsers);
			model.addAttribute("user", ordinaryUsers);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** 赛事列表页面 **/
	@RequestMapping(value = "/MacthList.do", method = RequestMethod.GET)
	public ModelAndView MacthList() {
		ModelAndView mv = new ModelAndView();
		List<Event> list = eventService.getEvents();
		mv.addObject("list", list);
		mv.setViewName("user/Match_list");
		return mv;
	}

	/** 赛事等待 **/
	@RequestMapping(value = "/MacthWite.do", method = RequestMethod.GET)
	public ModelAndView MacthWite(int id) {
		ModelAndView mv = new ModelAndView();
		Event event = eventService.getOneEvent(id);
		if (event == null) {
			mv.setViewName("redirect:./MacthList.do");
			return mv;
		} else {
			mv.addObject("event", event);
			mv.setViewName("user/Match_wite");
			return mv;
		}
	}

	/** 加入战队页面 **/
	@RequestMapping(value = "/JoinTeam.do", method = RequestMethod.GET)
	public ModelAndView JoinTeam() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Join_team");
		return mv;
	}

	public int Team(OrdinaryUsers ordinaryUsers, int id) {
		if (ordinaryUsersService.getUserTeamId(ordinaryUsers.getId()) == 0) {
			try {
				TeamInformation teamInformation = teamInformationService.getTeamCount(id);
				if (teamInformation != null) {
					if (teamInformation.getCount() < 3) {
						return 0; // 可以加入
					} else {
						return 2; // 战队人数已满
					}
				} else {
					return 1; // 战队不存在
				}
			} catch (Exception e) {
				return 1; // 战队不存在
			}

		} else {
			return 3; // 已经加入战队
		}

	}

	/** 战队加入前查询 **/
	@RequestMapping(value = "/TeamCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public int TeamCheck(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		return Team(ordinaryUsers, id);
	}

	/** 题目显示页面 **/
	@RequestMapping(value = "/Topic.do", method = RequestMethod.GET)
	public ModelAndView Topic(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int EventId) {
		ModelAndView mv = new ModelAndView();
		int UserId = ordinaryUsers.getId();
		if (eventService.TimeCheck(EventId)) {
			if (checkService.TeamCheck(EventId, UserId)) {
				int[] as = topicService.getTopicCount(EventId);
				mv.addObject("EventId", EventId);
				mv.addObject("count", as);
				mv.setViewName("user/Match");
				return mv;
			} else {
				mv.setViewName("redirect:./MacthList.do");
				return mv;
			}
		} else {
			mv.setViewName("redirect:./MacthList.do");
			return mv;
		}

	}

	/** 题目读取 **/
	@RequestMapping(value = "/Topicdq.do", method = RequestMethod.POST)
	@ResponseBody
	public String Topicdq(int ssid, int count, int type) {

		if (type == 3) {
			System.out.println(type);
		}
		if (type == 1) {
			ChooseTopicEntity chooseTopicEntity = topicService.getChooseTopic(ssid, count);
			String resultJson = JSONObject.toJSONString(chooseTopicEntity);
			return resultJson;
		} else if (type == 2) {
			MultipleTopicEntity multipleTopicEntity = topicService.getMultipleTopic(ssid, count);
			String resultJson = JSONObject.toJSONString(multipleTopicEntity);
			return resultJson;
		} else if (type == 3) {
			FileTopicEntity fileTopicEntity = topicService.getFileTopic(ssid, count);
			String resultJson = JSONObject.toJSONString(fileTopicEntity);
			return resultJson;
		} else {
			return "err";
		}

	}

	/** 注销 **/
	@RequestMapping(value = "/quit.do", method = RequestMethod.GET)
	public ModelAndView quit(SessionStatus sessionStatus) {
		ModelAndView mv = new ModelAndView();
		sessionStatus.setComplete();
		mv.setViewName("redirect:../index.do");
		return mv;
	}

	/** 创建战队页面 **/

	@RequestMapping(value = "/CreateTeam.do", method = RequestMethod.GET)
	public ModelAndView CreateTean(SessionStatus sessionStatus) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/Create_team");
		return mv;
	}

	/** 战队名称检查 **/
	@RequestMapping(value = "/TeamName.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean TeamCheck(String Name) {

		TeamInformation teamInformation = teamInformationService.getTeamByName(Name);
		if (teamInformation != null) {
			return false;
		} else {
			return true;
		}

	}

	/** 创建战队 **/
	@RequestMapping(value = "/TeamCreat.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean TeamCreat(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, String Name, Model model) {
		if (Name == null) {
			return false;
		} else {
			if (Name.length() > 3 || Name.length() < 10) {
				if (TeamCheck(Name)) {
					int UserId = ordinaryUsers.getId();
					TeamInformation TeamInformation = teamInformationService.getTeamInformation(UserId);
					if (TeamInformation != null) {
						return false;
					} else {
						try {
							InsertTeam insertTeam = new InsertTeam();
							insertTeam.setName(Name);
							insertTeam.setUserId(UserId);
							insertTeam.setUserName(ordinaryUsers.getTruename());
							insertTeam = teamInformationService.insertTeam(insertTeam);
							int TeamId = insertTeam.getId();
							if (TeamId != 0) {
								ordinaryUsers.setCaptain(1);
								ordinaryUsers.setTeam_id(TeamId);
								ordinaryUsers.setId(UserId);
								ordinaryUsersService.changeall(ordinaryUsers);
								model.addAttribute("user", ordinaryUsers);
								return true;
							} else {
								return false;
							}
						} catch (Exception e) {
							System.out.println(e);
							return false;
						}
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	/**
	 * 加入战队 是否已经加入 战队是否存在 战队是否已满
	 **/
	@RequestMapping(value = "/JoinTeam.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean JoinTeam(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		if (Team(ordinaryUsers, id) == 0) {
			// 插入申请提示
			TeamApplicationEntity teamapplicationEntity = new TeamApplicationEntity();
			TeamInformation teamInformation = teamInformationService.getTeamCount(id);
			int captain_id = teamInformation.getCaptain_id();
			int UserId = ordinaryUsers.getId();
			String UserName = ordinaryUsers.getTruename();
			teamapplicationEntity.setApplicant_id(UserId);
			teamapplicationEntity.setApplicant_name(UserName);
			teamapplicationEntity.setCaptain_id(captain_id);
			teamapplicationEntity.setTeam_id(id);
			teamapplicationEntity = teamapplicationService.insertTeAp(teamapplicationEntity);
			if (teamapplicationEntity.getId() != null) {
				OneNew onenew = new OneNew();
				onenew.setPublisher_id(UserId);
				onenew.setPublisher_name(UserName);
				onenew.setRecipient_id(captain_id);
				onenew.setData(UserName + "向你发出了战队申请，请到战队管理查看！");
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					onenew.setTime(df.format(new Date()));
					df = null;
					if (newsService.insertNews(onenew)) {
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
				// 插入消息提示
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	/** 删除消息 **/
	@RequestMapping(value = "/delectnews.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean delectnews(int id) {
		if (!newsService.deleteNews(id)) {
			return false;
		} else {
			return true;
		}
	}

	/** 退出战队 **/
	@RequestMapping(value = "/quitteam.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean quitteam(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, Model model) {
		// 是否加入战队
		int UserId = ordinaryUsers.getId();
		TeamInformation TeamInformation = teamInformationService.getTeamInformation(UserId);
		if (TeamInformation != null) {
			if (TeamInformation.getTeam_member_1_id() == UserId) {
				TeamInformation.setTeam_member_1_id(0);
				TeamInformation.setTeam_member_1_name("null");
				TeamInformation.setCount(TeamInformation.getCount() - 1);
				if (teamInformationService.updateTeam(TeamInformation)) {
					ordinaryUsers.setCaptain(0);
					ordinaryUsers.setTeam_id(0);
					ordinaryUsersService.changeall(ordinaryUsers);
					model.addAttribute("user", ordinaryUsers);
					return true;
				} else {
					return false;
				}

			} else if (TeamInformation.getTeam_member_2_id() == UserId) {
				TeamInformation.setTeam_member_2_id(0);
				TeamInformation.setTeam_member_2_name("null");
				TeamInformation.setCount(TeamInformation.getCount() - 1);
				if (teamInformationService.updateTeam(TeamInformation)) {
					ordinaryUsers.setCaptain(0);
					ordinaryUsers.setTeam_id(0);
					ordinaryUsersService.changeall(ordinaryUsers);
					model.addAttribute("user", ordinaryUsers);
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/awd.do", method = RequestMethod.GET)
	public ModelAndView awd(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		ModelAndView mv = new ModelAndView();
		Event eventa = eventService.getOneEvent(id);
		if (eventa.getAwd() == 1) {
			AwdteamEntity awdteamEntity = awdService.getOneawd(ordinaryUsers.getTeam_id());
			String ipaddr = awdteamEntity.getIpaddr();
			DockerClient dockerClient = dockerService.DockerContnet("127.0.0.1", 2375);
			if (dockerClient == null) {
					mv.setViewName("redirect:./MacthList.do");
				return mv;
			} else {
				List<Container> b = dockerClient.listContainersCmd().exec();
				Container container = new Container();
				for (int i = 0; i < b.size(); i++) {
					container = b.get(i);
					if (ipaddr.equals(container.getId())) {
						break;
					}
				}

				mv.addObject("event", eventa);
				mv.addObject("container", container);
				mv.setViewName("user/awd");
				return mv;
			}
		} else {
			System.out.println("不是awd赛事");
			mv.setViewName("redirect:./MacthList.do");
			return mv;
		}

	}

	@RequestMapping(value = "/flag.do", method = RequestMethod.POST, produces = "text/html;charset=GBK")
	@ResponseBody
	public String flag(HttpServletRequest request, @SessionAttribute("user") OrdinaryUsers ordinaryUsers, int EventId,
			String code, String flag, @SessionAttribute("code") String realCode) {
		int UserId = ordinaryUsers.getId();
		int TeamId = teamInformationService.getTeamInformation(UserId).getId();
		if (eventService.TimeCheck(EventId)) {
			if (realCode.toLowerCase().equals(code)) {
				if (checkService.JoinTeamCheck(UserId)) {
					if (checkService.TeamCheck(EventId, UserId)) {
						AwdteamEntity awdteamEntity = awdService.getOneawd(TeamId);
						String states = awdteamEntity.getStates();
						int count = 0;
						if (states.equals("0")) {

						} else {
							String[] s = states.split(";");
							for (int i = 0; i < s.length; i++) {
								if (s[i].equals(flag)) {
									count = 1;
									break;
								}
							}
						}
						if (count == 0) {
								if (!flag.equals(awdteamEntity.getFlag())) {
								AwdteamEntity awdteamEntity2 = awdService.getOneawdbyflag(flag);
								if (awdteamEntity2 != null) {
									awdteamEntity2.setSource(awdteamEntity2.getSource() - 20);
									awdService.updateAwdteam(awdteamEntity2);
									// 2被攻击了
									awdteamEntity.setSource(awdteamEntity.getSource() + 20);
									if (states.equals("0")) {
										awdteamEntity.setStates(flag + ";");
									} else {
										awdteamEntity.setStates(awdteamEntity.getStates() + flag + ";");
									}
									awdService.updateAwdteam(awdteamEntity);
									return "提交成功";
								} else {
									return "flag错误";
								}
							} else {
								return "请不要提交自己flag";
							}
						} else {
							return "你已经提交过了该flag";
						}
					} else {
						return "未参加比赛";
					}
				} else {
					return "请先加入战队";
				}
			} else

			{
				return "验证码错误";
			}
		} else

		{
			return "比赛已经结束";
		}

	}
}
