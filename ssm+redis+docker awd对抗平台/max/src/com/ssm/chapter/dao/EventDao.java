package com.ssm.chapter.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.chapter.pojo.Event;

@Repository
public interface EventDao {
	public List<Event> getEvents();

	public Event getOneEvent(int id);

	public boolean insertEvent(Event event);

	public Event findAwdEvent();

	public boolean deleteEvent(int id);
}

