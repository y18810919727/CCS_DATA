/*时间：2015.04.22
 * 内容：创建一个Servlet，响应用户登入和修改密码的请求，得到用户的账号和密码，并与数据库进行比较，将比较结果发送给
 * JSP文件
 * 作者：yepengfei
 * 
 * 时间：2015.04.22
 * 内容：当用户登录成功时，创建cookie用来存放用户的账号名
 * 作者：yepengfei
 * */
package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccs.biz.Login;
import com.ccs.dao.AccountDAO;
import com.ccs.entity.User;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet.servlet" })
public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta http-equiv='refresh' content='2; url=/CCS/index.jsp'> ");
		out.println("请求非法，请重新登录！");
		out.flush();
		out.close();
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
		Cookie cookie_username = null;
		String result = null;
		// 定义字符串username和password，以接受用户提交的信息
		String username = new String(request.getParameter("username").
				getBytes("utf-8"), "utf-8");
		String password = request.getParameter("password");
		// System.out.println(username);
		// System.out.println(password);
		// 修改字符编码为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 得到一条对应的用户信息
		User user = new AccountDAO().FindAllUser(username);
		// 将接受到的用户信息与数据库的用户信息进行比较，将结果写入变量result中
		if (user != null) {
			if (user.getPassword().equals(password)) {
				result = "User can login";
				// 4月30日添加：用户权限(GYX)
				String style = user.getStyle();
				/*
				 * //当用户登录成功时，创建cookie cookie_username = new
				 * Cookie("username",username); //设置cookie的生命周期
				 * cookie_username.setMaxAge(3600*24*7);
				 */

				// 调用类Login里的CreateSession()函数创建session，存入用户名
				new Login().CreateSession(username, password, style, request);
				// 控制台记录用户登录信息
				System.out.println("用户" + username + "已登录，权限："
						+ ("0".equals(style) ? "管理员":"下料员"));
			} else {
				result = "Password is error";
			}
		} else {
			result = "User does not exist";
		}
		// System.out.println(result);
		/*
		 * for(User user:list){ if(username.equals(user.getName())){
		 * if(password.equals(user.getPassword())){ result = "User can login";
		 * }else{ result = "Password is error"; } } } if(result == null){ result
		 * = "User does not exist"; }
		 */
		// 将结果传递给JSP，返回给用户
		// 设置键值对，键是"result"，值是result
		request.setAttribute("result", result);
		// 请求转发。转到"/index.jsp"页面下。注意一定加"/"
		request.getRequestDispatcher("/index.jsp").forward(request, response);

		// 把cookie写回到浏览器中
		// response.addCookie(cookie_username);

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
