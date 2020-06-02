package com.ssm.chapter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ssm.chapter.pojo.Answer;
import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.service.CheckService;
import com.ssm.chapter.service.EventService;
import com.ssm.chapter.service.TeamInformationService;

@Controller
@RequestMapping("/check")

public class CheckController {

	@Autowired
	private EventService eventService = null;
	@Autowired
	private CheckService checkService = null;
	@Autowired
	private TeamInformationService teamInformationService = null;

	@RequestMapping(value = "/check.do", method = RequestMethod.POST)
	@ResponseBody
	public String check(Answer answer, @SessionAttribute("code") String realCode,
			@SessionAttribute("user") OrdinaryUsers ordinaryUsers, HttpServletRequest request) {
		int Id = answer.getId();
		int EventId = answer.getEvent_id();
		int UserId = ordinaryUsers.getId();
		int Type = answer.getType();
		int TeamId = teamInformationService.getTeamInformation(UserId).getId();
		if (eventService.TimeCheck(EventId)) {
			if (realCode.toLowerCase().equals(answer.getCode().toLowerCase())) {
				if (checkService.JoinTeamCheck(UserId)) {
					if (checkService.TeamCheck(EventId, UserId)) {
						if (!checkService.AnswerState(Id, Type, UserId, TeamId, EventId)) {
								return checkService.AnswerCheck(Id, Type, answer.getAnswer(), EventId, TeamId);
						} else {
							return "您已经答过此题了！";
						}
					} else {
						return "未参加比赛";
					}
				} else {
					return "请先加入战队";
				}
			} else {
				return "验证码错误";
			}
		} else {
			return "比赛已经结束";
		}

	}
}
