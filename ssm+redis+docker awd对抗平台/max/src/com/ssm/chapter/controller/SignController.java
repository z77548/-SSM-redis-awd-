package com.ssm.chapter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.pojo.Signer;
import com.ssm.chapter.service.OrdinaryUsersService;
import com.ssm.chapter.validator.SingerValidate;

@Controller
@RequestMapping("/sign")
@SessionAttributes(types = { OrdinaryUsers.class })
public class SignController {

	@Autowired
	private OrdinaryUsersService ordinaryUsersService = null;

	/** ×¢²áÑéÖ¤ **/
	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.setValidator(new SingerValidate());
	}

	@RequestMapping(value = "/signer.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String signer(@Valid Signer user, Errors errors, String code, @SessionAttribute("code") String realCode,
			Model model) {
		if (realCode.toLowerCase().equals(code.toLowerCase())) {
			if (errors.hasErrors()) {
				List<FieldError> errorList = errors.getFieldErrors();
				for (FieldError error : errorList) {
					System.err.println(error.getField() + "----" + error.getDefaultMessage());
				}
				return "×¢²áÊ§°Ü";
			} else {
				if (ordinaryUsersService.InsertSigner(user) != null) {
					OrdinaryUsers or = new OrdinaryUsers();
					or.setId(user.getId());
					or.setCaptain(user.getCaptain());
					or.setEmail(user.getEmail());
					or.setIdcard(user.getIdcard());
					or.setIphone(user.getIphone());
					or.setMac(user.getMac());
					or.setName(user.getName());
					or.setTeam_id(0);
					or.setTruename(user.getTruename());
					or.setType(0);
					model.addAttribute("user", or);
					return "×¢²á³É¹¦";
				} else {
					return "×¢²áÊ§°Ü";
				}
			}
		} else {
			return "ÑéÖ¤Âë´íÎó";
		}
	}

}
