package com.ssm.chapter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/code")

public class CodeController {

//验证码生成
	@RequestMapping("/code.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("code/code");
		return mv;
	}
}
