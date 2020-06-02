package com.ssm.chapter.service;

import javax.servlet.http.HttpServletRequest;

public interface CheckService {
	// 用户是否加入战队
	public boolean JoinTeamCheck(int UserId);

	// 战队是否报名比赛
	public boolean TeamCheck(int EventId, int UserId);

	String AnswerCheck(int Id, int Type, String Answer, int EvenId, int TeamId);

	boolean AnswerState(int Id, int Type, int UserId, int TeamId, int EventId);

	boolean MacCheck(int Userid);

	public String getLocalMac(HttpServletRequest request);

	boolean MacCheck(HttpServletRequest request, int UserId);
}
