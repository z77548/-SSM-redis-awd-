package com.ssm.chapter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.chapter.pojo.OrdinaryUsers;

//娉ㄨВ@Controller琛ㄧず瀹冩槸锟�?涓帶鍒跺櫒
@Controller()
//琛ㄦ槑褰撹姹傜殑URI锟�?/my涓嬬殑鏃讹拷?锟芥墠鏈夎鎺у埗鍣ㄥ搷锟�?

public class IndexController {

	// 琛ㄦ槑URI锟�?/index鐨勬椂鍊欒鏂规硶鎵嶈锟�?
	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("link-logoin/index");
		return mv;
	}

	@RequestMapping("/home.do")
	public ModelAndView home(@SessionAttribute("user") OrdinaryUsers ordinaryUsers) {
		ModelAndView mv = new ModelAndView();
		if (ordinaryUsers.getType() == 0) {
			if (ordinaryUsers.getCaptain() == 1) {
				mv.setViewName("captain/index");
				return mv;
			} else {
				mv.setViewName("user/index");
				return mv;
			}
		} else if (ordinaryUsers.getType() == 1) {
			mv.setViewName("admin/index");
			return mv;
		}
		return null;
	}

}