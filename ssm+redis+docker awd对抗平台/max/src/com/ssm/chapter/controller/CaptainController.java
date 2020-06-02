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
import com.ssm.chapter.pojo.MultipleTopicEntity;
import com.ssm.chapter.pojo.OneNew;
import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.ResultCompetitionEntity;
import com.ssm.chapter.pojo.TeamApplicationEntity;
import com.ssm.chapter.pojo.TeamInformation;
import com.ssm.chapter.service.AwdService;
import com.ssm.chapter.service.CheckService;
import com.ssm.chapter.service.DockerService;
import com.ssm.chapter.service.EventService;
import com.ssm.chapter.service.NewsService;
import com.ssm.chapter.service.OrdinaryUsersService;
import com.ssm.chapter.service.ResultCompetitionEntityService;
import com.ssm.chapter.service.TeamInformationService;
import com.ssm.chapter.service.TopicService;
import com.ssm.chapter.service.teamApplicationService;

@Controller
@RequestMapping("/captain")
@SessionAttributes(types = { OrdinaryUsers.class })
public class CaptainController {
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
	ResultCompetitionEntityService rs = null;
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
			mv.setViewName("captain/Navigation");
			return mv;
		}
		return null;

	}

	/** MAC��ַ��ȡ **/
	@RequestMapping(value = "/Mac.do", method = RequestMethod.GET)
	public ModelAndView Mac(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		OrdinaryUsers newordinaryUsers = ordinaryUsersService.LoginVerification(ordinaryUsers.getName());
		mv.addObject("mac", newordinaryUsers.getMac());
		mv.setViewName("captain/System_settings");
		return mv;
	}

	/** MAC��ַ�޸� **/
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

	/** ������Ϣ��ȡ **/
	@RequestMapping(value = "/Personal_information.do", method = RequestMethod.GET)
	public ModelAndView Personal_information(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		OrdinaryUsers newordinaryUsers = ordinaryUsersService.LoginVerification(ordinaryUsers.getName());
		mv.addObject("newordinaryUsers", newordinaryUsers);
		mv.setViewName("captain/Personal_information");
		return mv;
	}

	/** ������Ϣ�޸� **/
	@RequestMapping(value = "/PersonalChange.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean PersonalChange(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, String iphone, String email,
			String passwd, Model model) {
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

	/** �����б�ҳ�� **/
	@RequestMapping(value = "/MacthList.do", method = RequestMethod.GET)
	public ModelAndView MacthList() {
		ModelAndView mv = new ModelAndView();
		List<Event> list = eventService.getEvents();
		mv.addObject("list", list);
		mv.setViewName("captain/Match_list");
		return mv;
	}

	/** ���µȴ� **/

	@RequestMapping(value = "/MacthWite.do", method = RequestMethod.GET)
	public ModelAndView MacthWite(int id) {
		ModelAndView mv = new ModelAndView();
		Event event = eventService.getOneEvent(id);
		if (event == null) {
			mv.setViewName("redirect:./MacthList.do");
			return mv;
		} else {
			mv.addObject("event", event);
			mv.setViewName("captain/Match_wite");
			return mv;
		}
	}

	public int Team(OrdinaryUsers ordinaryUsers, int id) {
		if (ordinaryUsersService.getUserTeamId(ordinaryUsers.getId()) == 0) {
			try {
				TeamInformation teamInformation = teamInformationService.getTeamCount(id);
				if (teamInformation != null) {
					if (teamInformation.getCount() < 3) {
						return 0; // ���Լ���
					} else {
						return 2; // ս����������
					}
				} else {
					return 1; // ս�Ӳ�����
				}
			} catch (Exception e) {
				System.out.println(e);
				return 1; // ս�Ӳ�����
			}

		} else {
			return 3; // �Ѿ�����ս��
		}

	}

	/** ս�Ӽ���ǰ��ѯ **/
	@RequestMapping(value = "/TeamCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public int TeamCheck(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		return Team(ordinaryUsers, id);
	}

	/** ��Ŀ��ʾҳ�� **/

	@RequestMapping(value = "/Topic.do", method = RequestMethod.GET)
	public ModelAndView Topic(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int EventId) {
		ModelAndView mv = new ModelAndView();
		int UserId = ordinaryUsers.getId();
		if (eventService.TimeCheck(EventId)) {
			if (checkService.TeamCheck(EventId, UserId)) {
				int[] as = topicService.getTopicCount(EventId);
				mv.addObject("EventId", EventId);
				mv.addObject("count", as);
				mv.setViewName("captain/Match");
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

	/** ��Ŀ��ȡ **/
	@RequestMapping(value = "/Topicdq.do", method = RequestMethod.POST)
	@ResponseBody
	public String Topicdq(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int ssid, int count, int type) {
		int UserId = ordinaryUsers.getId();
		if (checkService.TeamCheck(ssid, UserId)) {
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
		} else {
			return "�뱨���μӱ���";
		}
	}

	/** ע�� **/
	@RequestMapping(value = "/quit.do", method = RequestMethod.GET)
	public ModelAndView quit(SessionStatus sessionStatus) {
		ModelAndView mv = new ModelAndView();
		sessionStatus.setComplete();
		mv.setViewName("redirect:../index.do");
		return mv;
	}

	/**
	 * ����ս�� �Ƿ��Ѿ����� ս���Ƿ���� ս���Ƿ�����
	 **/
	@RequestMapping(value = "/JoinTeam.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean JoinTeam(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		if (Team(ordinaryUsers, id) == 0) {
			// ����������ʾ
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
				onenew.setData(UserName + "���㷢����ս�����룬�뵽ս�ӹ���鿴��");
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
				// ������Ϣ��ʾ
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	/** ɾ����Ϣ **/
	@RequestMapping(value = "/delectnews.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean delectnews(int id) {
		if (!newsService.deleteNews(id)) {
			return false;
		} else {
			return true;
		}
	}

	/** ս�ӹ���ҳ�� **/
	@RequestMapping(value = "/team.do", method = RequestMethod.GET)
	public ModelAndView team(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		int UserId = ordinaryUsers.getId();
		TeamInformation teamInformation = teamInformationService.getTeamInformation(UserId);
		List<TeamApplicationEntity> teamapplication = teamapplicationService.getteamApplication(UserId);
		mv.addObject("teamInformation", teamInformation);
		mv.addObject("teamapplication", teamapplication);
		mv.setViewName("captain/Team_management");
		return mv;
	}

	/** ս��������� **/
	@RequestMapping(value = "/appteam.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean appteam(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		// ������������Ƿ����
		TeamApplicationEntity teamapplication = teamapplicationService.getteamAppById(id);
		if (teamapplication != null) {
			TeamInformation teamInformation = teamInformationService.getTeamCount(teamapplication.getTeam_id());
			// ���ս���Ƿ����
			if (teamInformation != null) {
				// ����ύ�û��ǲ�������ս�ӵĶӳ�
				int UserId = ordinaryUsers.getId();
				int CaptainId = teamInformation.getCaptain_id();
				int ApplicantId = teamapplication.getApplicant_id();
				if (CaptainId == UserId) {
					// ����û���û�м�������ս��
					OrdinaryUsers ordinary = ordinaryUsersService.getOrdinaryUsersByUserId(ApplicantId);
					if (ordinary.getTeam_id() == 0 && teamInformationService.getTeamInformation(ApplicantId) == null) {
						// ���ս�������ǲ����Ѿ�����
						int c = teamInformation.getCount();
						if (c == 1) {
							// �޸�ս���û�
							teamInformation.setTeam_member_1_id(ApplicantId);
							teamInformation.setTeam_member_1_name(teamapplication.getApplicant_name());
							teamInformation.setCount(2);
							teamInformationService.updateTeam(teamInformation);
							ordinary.setTeam_id(teamapplication.getTeam_id());
							ordinaryUsersService.changeall(ordinary);
							// ɾ������
							teamapplicationService.deleteapp(id);
						} else if (c == 2) {
							teamInformation.setTeam_member_2_id(teamapplication.getApplicant_id());
							teamInformation.setTeam_member_2_name(teamapplication.getApplicant_name());
							teamInformation.setCount(3);
							teamInformationService.updateTeam(teamInformation);
							ordinary.setTeam_id(teamapplication.getTeam_id());
							ordinaryUsersService.changeall(ordinary);
							// ɾ������
							teamapplicationService.deleteapp(id);
						} else {
							return false;
						}
						// ֪ͨ�û�
						OneNew onenew = new OneNew();
						onenew.setPublisher_id(CaptainId);
						onenew.setPublisher_name(teamInformation.getCaptain_name());
						onenew.setRecipient_id(ApplicantId);
						onenew.setData(teamInformation.getName() + "ս���������ɹ���");
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
					} else {
						return false;
					}
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

	@RequestMapping(value = "/Refused.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean Refused(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		TeamApplicationEntity teamapplication = teamapplicationService.getteamAppById(id);
		if (teamapplication != null) {
			// ɾ������
			teamapplicationService.deleteapp(id);
			// ֪ͨ�û�
			OneNew onenew = new OneNew();
			onenew.setPublisher_id(0);
			onenew.setPublisher_name("ϵͳ");
			onenew.setRecipient_id(teamapplication.getApplicant_id());
			onenew.setData("ϵͳ��ʾ���������뱻�ӳ��ܾ���");
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
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/Kick.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean Kick(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		OrdinaryUsers ordinary = ordinaryUsersService.getOrdinaryUsersByUserId(id);
		TeamInformation teamInformation = teamInformationService.getTeamInformation(id);
		// ���ս���Ƿ����
		if (ordinary.getTeam_id() != 0 && teamInformation != null) {
			// ���û��ǲ��Ǳ�ս��
			if (ordinary.getTeam_id() == teamInformation.getId()) {
				// �����û��ǲ��Ƕӳ�
				if (ordinaryUsers.getId() == teamInformation.getCaptain_id()) {
					// �߳�
					if (teamInformation.getTeam_member_1_id() == id) {
						if (teamInformation.getCount() == 3) {
							teamInformation.setTeam_member_1_id(teamInformation.getTeam_member_2_id());
							teamInformation.setTeam_member_1_name(teamInformation.getTeam_member_2_name());
							teamInformation.setTeam_member_2_id(0);
							teamInformation.setTeam_member_2_name("null");
							teamInformation.setCount(2);
						} else {
							teamInformation.setTeam_member_1_id(0);
							teamInformation.setTeam_member_1_name("null");
							teamInformation.setCount(1);
						}
						teamInformationService.updateTeam(teamInformation);
						ordinary.setTeam_id(0);
						ordinaryUsersService.changeall(ordinary);
					} else if (teamInformation.getTeam_member_2_id() == id) {
						teamInformation.setTeam_member_2_id(0);
						teamInformation.setTeam_member_2_name("null");
						teamInformation.setCount(2);
						teamInformationService.updateTeam(teamInformation);
						ordinary.setTeam_id(0);
						ordinaryUsersService.changeall(ordinary);
					} else {
						return false;
					}
					OneNew onenew = new OneNew();
					onenew.setPublisher_id(0);
					onenew.setPublisher_name("ϵͳ");
					onenew.setRecipient_id(id);
					onenew.setData("ϵͳ��ʾ�������ӳ��߳��˶��飡");
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

	/** ���±���ҳ�� **/
	@RequestMapping(value = "/CompetitionRegistration.do", method = RequestMethod.GET)
	public ModelAndView CompetitionRegistration(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		List<Event> list = eventService.getEvents();
		mv.addObject("list", list);
		mv.setViewName("captain/CompetitionRegistration");
		return mv;

	}

	/** ���±����ύ **/
	@RequestMapping(value = "/bm.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean bm(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		TeamInformation teamInformation = teamInformationService.getTeamInformation(ordinaryUsers.getId());
		if (teamInformation != null) {
			String eventid = teamInformation.getEvent_id();
			ResultCompetitionEntity rsty = new ResultCompetitionEntity();
			Event eventbase = eventService.getOneEvent(id);
			if (eventid != null && eventid != "" && eventid != "null") {
				String[] event = eventid.split(";");
				int temp = 0;
				int c = 0;
				for (int i = 0; i < event.length; i++) {
					temp = Integer.parseInt(event[i]);
					if (temp == id) {
						c = 1;
						break;
					}
				}
				if (c == 0) {
					eventid = eventid + id + ";";
					teamInformation.setEvent_id(eventid);
					teamInformationService.updateTeam(teamInformation);
					if (eventbase.getAwd() == 0) {
						rsty.setEvent_id(id);
						rsty.setTeam_id(teamInformation.getId());
						rs.insert(rsty);
						return true;
					} else {
						AwdteamEntity awdteamEntity = new AwdteamEntity();
						awdteamEntity.setEventid(id);
						awdteamEntity.setTeamid(teamInformation.getId());
						awdteamEntity.setSource(1000);
						awdteamEntity.setFlag("null");
						awdteamEntity.setIpaddr("null");
						awdteamEntity.setStates("0");
						awdService.insertAwd(awdteamEntity);
						return true;
					}
				} else {
					return false;
				}
			} else {
				eventid = id + ";";
				teamInformation.setEvent_id(eventid);
				teamInformationService.updateTeam(teamInformation);
				if (eventbase.getAwd() == 0) {
					rsty.setEvent_id(id);
					rsty.setTeam_id(teamInformation.getId());
					rs.insert(rsty);
					return true;
				} else {
					AwdteamEntity awdteamEntity = new AwdteamEntity();
					awdteamEntity.setEventid(id);
					awdteamEntity.setTeamid(teamInformation.getId());
					awdteamEntity.setSource(1000);
					awdteamEntity.setFlag("null");
					awdteamEntity.setIpaddr("null");
					awdteamEntity.setStates("0");
					awdService.insertAwd(awdteamEntity);
					return true;
				}
			}
		} else {
			return false;
		}
	}

	/** ս����Ϣҳ�� **/
	@RequestMapping(value = "/TeamInformation.do", method = RequestMethod.GET)
	public ModelAndView index(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		TeamInformation TeamInformation = teamInformationService.getTeamInformation(ordinaryUsers.getId());
		mv.addObject("TeamInformation", TeamInformation);
		mv.setViewName("captain/TeamInformation");
		return mv;
	}

	@RequestMapping(value = "/dissolution.do", method = RequestMethod.GET)
	@ResponseBody
	public boolean dissolution(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, Model model) {
		TeamInformation teamInformation = teamInformationService.getTeamInformation(ordinaryUsers.getId());
		if (teamInformation != null) {
			int user1 = teamInformation.getTeam_member_1_id();
			int user2 = teamInformation.getTeam_member_2_id();
			int teamid = ordinaryUsers.getTeam_id();
			OrdinaryUsers or = new OrdinaryUsers();
			or.setCaptain(0);
			or.setTeam_id(0);
			or.setId(user1);
			ordinaryUsersService.changeall(ordinaryUsers);
			or.setId(user2);
			ordinaryUsersService.changeall(ordinaryUsers);
			ordinaryUsers.setTeam_id(0);
			ordinaryUsers.setCaptain(0);
			ordinaryUsersService.changeall(ordinaryUsers);
			teamInformationService.delete(teamid);
			model.addAttribute("user", ordinaryUsers);
			rs.deleteResultCompetitionById(teamid);
			return true;
		} else {
			return false;
		}
	}

	/** ���µȴ� **/

	@RequestMapping(value = "/awd.do", method = RequestMethod.GET)
	public ModelAndView awd(@SessionAttribute("user") OrdinaryUsers ordinaryUsers, int id) {
		ModelAndView mv = new ModelAndView();
		Event eventa = eventService.getOneEvent(id);
		if (eventa.getAwd() == 1) {
			AwdteamEntity awdteamEntity = awdService.getOneawd(ordinaryUsers.getTeam_id());
			String ipaddr = awdteamEntity.getIpaddr();
			DockerClient dockerClient = dockerService.DockerContnet("127.0.0.1", 2375);
			if (dockerClient == null) {
				System.out.println("DOkcer����ʧ��");
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
				mv.setViewName("captain/awd");
				return mv;
			}
		} else {
			System.out.println("����awd����");
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
							System.out.println("�����������" + flag + "wwww" + awdteamEntity.getFlag());
							if (!flag.equals(awdteamEntity.getFlag())) {
								AwdteamEntity awdteamEntity2 = awdService.getOneawdbyflag(flag);
								if (awdteamEntity2 != null) {
									awdteamEntity2.setSource(awdteamEntity2.getSource() - 20);
									awdService.updateAwdteam(awdteamEntity2);
									// 2��������
									awdteamEntity.setSource(awdteamEntity.getSource() + 20);
									if (states.equals("0")) {
										awdteamEntity.setStates(flag + ";");
									} else {
										awdteamEntity.setStates(awdteamEntity.getStates() + flag + ";");
									}
									awdService.updateAwdteam(awdteamEntity);
									return "�ύ�ɹ�";
								} else {
									return "flag����";
								}
							} else {
								return "�벻Ҫ�ύ�Լ�flag";
							}
						} else {
							return "���Ѿ��ύ���˸�flag";
						}
					} else {
						return "δ�μӱ���";
					}
				} else {
					return "���ȼ���ս��";
				}
			} else

			{
				return "��֤�����";
			}
		} else

		{
			return "�����Ѿ�����";
		}

	}
}
