package com.ccs.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccs.biz.CreateMainFormExcel;

/**
 * 4月29日完成，用于将配料单导出excel供下载
 * 
 * */

@WebServlet(name = "DownloadMainExcel", urlPatterns = { "/DownloadMainExcel.servlet" })
public class DownloadMainExcel extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownloadMainExcel() {
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
		request.setCharacterEncoding("UTF-8");
		String referer = request.getHeader("Referer");
		String date = request.getParameter("date");
		String numval = request.getParameter("numval");
		if (referer == null) {
			PrintWriter out = response.getWriter();
			out.println("请求非法，请返回！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
			out.flush();
			out.close();
		} else if (date == null || numval == null || "".equals(date)
				|| "".equals(numval)) {
			PrintWriter out = response.getWriter();
			out.println("错误：您还没有选择要导出的单号，请返回！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
			out.flush();
			out.close();
		} else {
			// 根据下拉框的值生成单号
			StringBuilder strb = new StringBuilder(date.replaceAll("-", ""));
			int count = Integer.parseInt(numval) + 1;
			// 格式化最后两位数字
			if (count < 10)
				strb.append("0" + count);
			else
				strb.append(count);
			// 得到单号
			String number = strb.toString();
			// 生成附件文件名
			response.addHeader("Content-Disposition", "attachment;filename="
					+ number + ".xls");
			System.out.println("用户下载配比通知单Excel文件，配料单号：" + number);
			// 获得输出流
			OutputStream os = response.getOutputStream();
			// 输出Excel
			new CreateMainFormExcel().onCreate(date, number, os);
		}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
