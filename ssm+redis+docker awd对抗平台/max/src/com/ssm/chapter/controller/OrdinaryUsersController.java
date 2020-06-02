package com.ssm.chapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.chapter.pojo.OrdinaryUsers;
import com.ssm.chapter.service.OrdinaryUsersService;

@Controller
@RequestMapping("/logoin")
@SessionAttributes(types = { OrdinaryUsers.class })
public class OrdinaryUsersController {

	@Autowired
	private OrdinaryUsersService ordinaryUsersService = null;

	/** 登陆验证 **/
	@RequestMapping(value = "/logoin.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String LoginVerification(String name, String passwd, String code, @SessionAttribute("code") String realCode,
			Model model) {
		if (name != null && passwd != null && code != null) {
			if (realCode.toLowerCase().equals(code.toLowerCase())) {
				System.out.println("m名字是！@！！！"+name);
				OrdinaryUsers result = ordinaryUsersService.LoginVerification(name);
				if (result != null) {
					if (result.getPasswd().equals(passwd)) {
						model.addAttribute("user", result);
						return "0";
					} else {
						return "登陆失败";// 密码错误
					}

				} else {
					return "登陆失败";// 用户不存在
				}
			} else {
				return "验证码错误"; // 验证码错误
			}
		} else {
			return "登陆失败"; // 数据都为空 有黑客入侵行为
		}
	}

	
	/** 注销 **/
	@RequestMapping(value = "/quit.do", method = RequestMethod.GET)
	public ModelAndView quit(SessionStatus sessionStatus) {
		ModelAndView mv = new ModelAndView();
		sessionStatus.setComplete();
		mv.setViewName("redirect:../index.do");
		return mv;
	}

	/** 注册页面 **/
	@RequestMapping(value = "/sign.do", method = RequestMethod.GET)
	public ModelAndView sign() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("link-logoin/sign");
		return mv;
	}

	/** 注册用户名验证 **/
	@RequestMapping(value = "/Verification.do", method = RequestMethod.GET)
	@ResponseBody
	public int Verification(String name) {
		OrdinaryUsers result = ordinaryUsersService.LoginVerification(name);
		if (result != null) {
			return 1;
		} else {
			return 0;
		}
	}

}
