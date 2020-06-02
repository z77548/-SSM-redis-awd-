package com.ssm.chapter.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.service.CheckService;
import com.ssm.chapter.service.TeamInformationService;
import com.ssm.chapter.service.TopicService;
import com.ssm.chapter.dao.OrdinaryUsersDao;
import com.ssm.chapter.dao.ResultCompetitionEntityDao;
import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.ResultCompetitionEntity;
import com.ssm.chapter.pojo.TeamInformation;
import com.ssm.chapter.pojo.TrueAnswer;

@Service
public class CheckServiceimpl implements CheckService {

	@Autowired
	TeamInformationService teamInformationService = null;
	@Autowired
	private OrdinaryUsersDao ordinaryUsersDao = null;
	@Autowired
	private TopicService topicDao = null;
	@Autowired
	private ResultCompetitionEntityDao rs = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean JoinTeamCheck(int UserId) {

		if (ordinaryUsersDao.getUserTeamId(UserId) == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean TeamCheck(int EventId, int UserId) {
		try {
			TeamInformation teamInformation = teamInformationService.getTeamInformation(UserId);
			String[] temp = teamInformation.getEvent_id().split(";");
			for (int i = 0; i < temp.length; i++) {
				if (Integer.parseInt(temp[i]) == EventId) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String AnswerCheck(int Id, int Type, String Answer, int EventId, int TeamId) {
		TrueAnswer trueAnswer = topicDao.getAnswer(Id, Type);
		ResultCompetitionEntity rescom = rs.getGameResult(EventId, TeamId);
		if (null == rescom.getSubmit_number()) {
			rescom.setSubmit_number(1);
		} else {
			rescom.setSubmit_number(rescom.getSubmit_number() + 1);
		}
		if (Type == 1) {
			if (rescom.getRadio_answer() != null) {
				rescom.setRadio_answer(rescom.getRadio_answer() + Answer + ";");

			} else {
				rescom.setRadio_answer(Answer + ";");
			}
			if (rescom.getAlready_answered1() == null) {
				rescom.setAlready_answered1(Id + ";");
			} else {
				rescom.setAlready_answered1(rescom.getAlready_answered1() + Id + ";");
			}

			rs.updateGameResult(rescom);
			return "�ύ�ɹ�";
		} else if (Type == 2) {
			if (rescom.getMultiple_choice_answer() == null) {
				rescom.setMultiple_choice_answer((Answer + ";"));
			} else {
				rescom.setMultiple_choice_answer((rescom.getMultiple_choice_answer() + Answer + ";"));
			}
			if (rescom.getAlready_answered2() == null) {
				rescom.setAlready_answered2(Id + ";");
			} else {
				rescom.setAlready_answered2(rescom.getAlready_answered2() + Id + ";");
			}
			rs.updateGameResult(rescom);
			return "�ύ�ɹ�";
		} else if (Type == 3) {
			if (trueAnswer.getAnswer().equals(Answer)) {
				// ����
				rescom.setFlag_score((rescom.getFlag_score() + trueAnswer.getFraction()));
				if (rescom.getAlready_answered3() == null) {
					rescom.setAlready_answered3(Id + ";");
				} else {
					rescom.setAlready_answered3(rescom.getAlready_answered3() + Id + ";");
				}
				rs.updateGameResult(rescom);
				return "����ȷ!";
			} else {
				return "�𰸴���";
			}
		} else {
			return "��Ŀ���ʹ���";
		}

	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean AnswerState(int Id, int Type, int UserId, int TeamId, int EventId) {
		ResultCompetitionEntity rc = rs.getGameResult(EventId, TeamId);
		String answer = null;
		String[] as = null;
		try {
			if (Type == 1) {
				answer = rc.getAlready_answered1();
			} else if (Type == 2) {
				answer = rc.getAlready_answered2();
			} else if (Type == 3) {
				answer = rc.getAlready_answered3();
			} else {
				return false;
			}
		} catch (Exception e) {
			answer = null;
		}
		if (answer != null) {
			as = answer.split(";");
			for (int i = 0; i < as.length; i++) {
				if (Integer.parseInt(as[i]) == Id) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean MacCheck(int Userid) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ����IP��ַ��ȡmac��ַ
	 * 
	 * @param ipAddress 127.0.0.1
	 * @return
	 */
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public String getLocalMac(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "127.0.0.1";
		}
		String ipAddress = ip;
		String str = "";
		String macAddress = "";
		String LOOPBACK_ADDRESS = "127.0.0.1";
		// ���Ϊ127.0.0.1,���ȡ����MAC��ַ��
		try {
			if (LOOPBACK_ADDRESS.equals(ipAddress)) {
				InetAddress inetAddress = InetAddress.getLocalHost();
				// ò�ƴ˷�����ҪJDK1.6��
				byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
				// ��������ǰ�mac��ַƴװ��String
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					if (i != 0) {
						sb.append("-");
					}
					// mac[i] & 0xFF ��Ϊ�˰�byteת��Ϊ������
					String s = Integer.toHexString(mac[i] & 0xFF);
					sb.append(s.length() == 1 ? 0 + s : s);
				}
				// ���ַ�������Сд��ĸ��Ϊ��д��Ϊ�����mac��ַ������
				macAddress = sb.toString().trim().toUpperCase();
				return macAddress;
			} else {
				// ��ȡ�Ǳ���IP��MAC��ַ
				try {
					System.out.println(ipAddress);
					Process p = Runtime.getRuntime().exec("nbtstat -A " + ipAddress);
					System.out.println("===process==" + p);
					InputStreamReader ir = new InputStreamReader(p.getInputStream());
					BufferedReader br = new BufferedReader(ir);
					while ((str = br.readLine()) != null) {
						if (str.indexOf("MAC") > 1) {
							macAddress = str.substring(str.indexOf("MAC") + 9, str.length());
							macAddress = macAddress.trim();
							System.out.println("macAddress:" + macAddress);
							break;
						}
					}
					p.destroy();
					br.close();
					ir.close();
				} catch (IOException ex) {
				}
				return macAddress;
			}
		} catch (Exception e) {
			return macAddress;
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean MacCheck(HttpServletRequest request, int UserId) {
		String Mac = getLocalMac(request);
		OrdinaryUsers ordinaryUsers = ordinaryUsersDao.getOrdinaryUsersByUserId(UserId);
		if (Mac.equals(ordinaryUsers.getMac())) {
			return true;
		} else {
			return false;
		}

	}

}
