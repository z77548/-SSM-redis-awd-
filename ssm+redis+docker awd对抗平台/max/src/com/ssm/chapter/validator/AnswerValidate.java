package com.ssm.chapter.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ssm.chapter.pojo.Answer;
import com.ssm.chapter.service.EventService;

public class AnswerValidate implements Validator {

	@Autowired
	private EventService eventService = null;

	@Override
	public boolean supports(Class<?> clazz) {
		return Answer.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Answer answer = (Answer) arg0;
		try {
			if (eventService.TimeCheck(answer.getEvent_id())) {
				errors.rejectValue("name", "±ÈÈü½áÊø");
			}

			else {

			}

		} catch (Exception e) {

		}
	}

}
