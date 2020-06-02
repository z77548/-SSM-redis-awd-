package com.ssm.chapter.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;
import com.ssm.chapter.service.OrdinaryUsersService;

public class SingerValidate implements Validator {

	@Autowired
	private OrdinaryUsersService ordinaryUsersService = null;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Signer.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Signer user = (Signer) arg0;
		try {
			OrdinaryUsers ordinaryUsers = ordinaryUsersService.signVerification(user.getName(), user.getTruename(),
					user.getIdcard());
			errors.rejectValue("name", "ÇëÎðÖØ¸´×¢²á");
		} catch (Exception e) {

		}
	}

}
