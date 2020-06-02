package com.ssm.chapter.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssm.chapter.pojo.OrdinaryUsers;

public class HomeInterceptor extends HandlerInterceptorAdapter {

	@Override

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)

			throws Exception {
		HttpSession session = request.getSession();
		OrdinaryUsers ordinaryUsers = (OrdinaryUsers) session.getAttribute("user");
		response.setCharacterEncoding("GB2312");
		String sb = "";
		if (ordinaryUsers == null) {
			PrintWriter out = response.getWriter();
			sb = "<script type=\"text/javascript\" charset=\"GB2312\">" + "alert(\"你的账号被挤掉，或者没有登录，或者页面已经过期，请重新登录\");"
					+ "window.location.href='../';" + "</script>";

			out.print(sb);
			out.close();
			return false;
		}
		return true;

	}

	@Override

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,

			ModelAndView modelAndView) throws Exception {

		System.out.println("--1--HandlerInterceptor1.postHandle");

	}

	@Override

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)

			throws Exception {

		System.out.println("--1--HandlerInterceptor1.afterCompletion");

	}

}
