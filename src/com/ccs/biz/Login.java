/*时间：2015.04.24
 * 内容：添加了CreateSession(String username,HttpServletRequest request)函数，实现存放用户名的session
 * */
package com.ccs.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Login {
	public void CreateSession(String username, String password, String style,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		if ("0".equals(style))
			session.setAttribute("style", "管理员");
		else if ("1".equals(style))
			session.setAttribute("style", "下料员");
		session.setAttribute("password", password);
		session.setMaxInactiveInterval(3600 * 24 * 7);
	}
}
