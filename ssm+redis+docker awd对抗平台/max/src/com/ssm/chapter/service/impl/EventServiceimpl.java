package com.ssm.chapter.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter.pojo.Event;
import com.ssm.chapter.service.EventService;
import com.ssm.chapter.dao.EventDao;

@Service
public class EventServiceimpl implements EventService {

	@Autowired
	private EventDao eventDao = null;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Event> getEvents() {
		List<Event> list = eventDao.getEvents();
		try {
			for (int i = 0; i < list.size(); i++) {
				Date date = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				Date sd0 = df.parse(df.format(date));
				Date sd1 = df.parse(list.get(i).getIntime());
				Date sd2 = df.parse(list.get(i).getOutime());
				df = null; // 销毁对象
				if (sd0.before(sd2) && sd0.after(sd1)) {
					list.get(i).setState("开始比赛");

				} else {

					list.get(i).setState("比赛关闭");

				}

			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public Event getOneEvent(int id) {
		// TODO Auto-generated method stub
		return eventDao.getOneEvent(id);
	}

	@Override
	public boolean TimeCheck(int EventId) {
		try {
			Event event = eventDao.getOneEvent(EventId);
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date sd0 = df.parse(df.format(date));
			Date sd1 = df.parse(event.getIntime());
			Date sd2 = df.parse(event.getOutime());
			df = null; // 销毁对象
			if (sd0.before(sd2) && sd0.after(sd1)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean TimeCheck(Event event) {
		try {
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date sd0 = df.parse(df.format(date));
			Date sd1 = df.parse(event.getIntime());
			Date sd2 = df.parse(event.getOutime());
			df = null; // 销毁对象
			if (sd0.before(sd2) && sd0.after(sd1)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean insertEvent(Event event) {
		// TODO Auto-generated method stub
		return eventDao.insertEvent(event);
	}

	@Override
	public Event findAwdEvent() {
		// TODO Auto-generated method stub

		return eventDao.findAwdEvent();
	}

	@Override
	public boolean deleteEvent(int id) {
		// TODO Auto-generated method stub
		return eventDao.deleteEvent(id);
	}

}
