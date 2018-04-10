package com.ccs.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户退出登录时用于清除session。4月30日添加。Powered By GYX
 * 
 * */
public class Logout {
	public void DestroySession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("style");
		session.removeAttribute("password");
	}
}
