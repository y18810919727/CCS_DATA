/*时间：2015.04.23
 * 内容：实现处理用户修改密码的请求代码基本框架。
 * 作者：yepengfei
 * 
 * 时间：2015.04.24
 * 内容：1.获得本地的cookie文件，筛选出存有用户的cookie，用来匹配数据库。
 * 		2.请求修改数据中的用户密码，并返回处理结果。
 * 作者：yepengfei
 * */
package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccs.biz.RemoveSession;
import com.ccs.biz.UpdatePassword;

@WebServlet(name = "UpdatePasswordServlet", urlPatterns = { "/UpdatePasswordServlet.servlet" })
public class UpdatePasswordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePasswordServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 修改字符编码为utf-8
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		out.println("请求非法，请返回！");
		out.flush();
		out.close();
		/*
		 * //读取所有cookie信息 Cookie cookies[]=request.getCookies(); //筛选Cookie
		 * for(int i=0;i<cookies.length;i++){ Cookie cookie=cookies[i]; String
		 * key = cookie.getName(); if("username".equals(key)){ String user_name
		 * = cookie.getValue(); System.out.println("用户的名字是："+user_name); }else{
		 * continue; } }
		 */
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义存放本次Servlet处理结果的字符串
		String result = null;
		// 修改字符编码为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 定义字符串oldpassword,newpassword,checkpassword,以接受用户提交的信息
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String checkpassword = request.getParameter("checkpassword");
		/*
		 * //读取本地的cookie文件，获得用户的账号名 String username = new
		 * UpdatePassword().readCookie(request);
		 */
		// 获取Session中的username
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			result = "The user is not logged in";
		} else {
			// 执行修改数据库中的密码的代码
			if (new UpdatePassword().startUpdatePassword(username, newpassword)) {
				result = "Updating password succeed";// 修改密码成功
				// 移除session中的用户属性，防止用户非法登录
				new RemoveSession().removeSession("username", request);
			} else {
				result = "Updating password failed";
			}
		}
		// 将结果传递给JSP，返回给用户
		// 设置键值对，键是"result"，值是result
		request.setAttribute("result", result);
		// 请求转发。转到"/updatepassword.jsp"页面下。注意一定加"/"
		request.getRequestDispatcher("/updatepassword.jsp").forward(request,
				response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
