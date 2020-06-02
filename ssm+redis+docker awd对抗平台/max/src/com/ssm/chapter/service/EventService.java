package com.ssm.chapter.service;

import java.util.List;

import com.ssm.chapter.pojo.Event;

public interface EventService {
	public List<Event> getEvents();

	public Event getOneEvent(int id);

	public boolean TimeCheck(int EventId);

	public boolean TimeCheck(Event event);

	public Event findAwdEvent();

	public boolean deleteEvent(int id);

	public boolean insertEvent(Event event);
}
