package com.ssm.chapter.service;

import javax.servlet.http.HttpServletRequest;

public interface CheckService {
	// �û��Ƿ����ս��
	public boolean JoinTeamCheck(int UserId);

	// ս���Ƿ�������
	public boolean TeamCheck(int EventId, int UserId);

	String AnswerCheck(int Id, int Type, String Answer, int EvenId, int TeamId);

	boolean AnswerState(int Id, int Type, int UserId, int TeamId, int EventId);

	boolean MacCheck(int Userid);

	public String getLocalMac(HttpServletRequest request);

	boolean MacCheck(HttpServletRequest request, int UserId);
}
