package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccs.dao.MineralDAO;
import com.ccs.dao.StockDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.entity.Mineral;
import com.ccs.entity.Summary;

/*
 * 4月26日完成，用于为新建配料单提供初始数据
 */

@WebServlet(name = "InitNewForm", urlPatterns = { "/initnewform.servlet" })
public class InitNewForm extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InitNewForm() {
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();// 得到当前系统时间
		String str_date = formatter.format(currentTime); // 将日期时间格式化
		// 将日期封入请求
		request.setAttribute("date", str_date);
		// 查询得到该日期下的单号数量，以便决定创建订单的新单号
		int count = 0;
		String str_num = null;// 单号
		Summary s = null;// 总表最后一条记录
		System.out.println("request get");
		try {
			count = new StockDAO().FindCountByDate(str_date);
			s = new SummaryDAO().FindLastOne();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将最后一条summary记录封入请求
		request.setAttribute("lastsummary", s);
		count++;
		// 得到当天日期，去掉"-"
		StringBuilder strb = new StringBuilder(str_date.replaceAll("-", ""));
		// 确定当前是第几单，格式化最后两位数字

		if (count < 10)
			strb.append("0" + count);
		else
			strb.append(count);
		// 生成单号
		str_num = strb.toString();
		// 将单号封入请求
		request.setAttribute("number", str_num);
		// 生成月号
		String month = Integer.parseInt(str_num.substring(4, 6)) + "";
		// 将月号封入请求
		request.setAttribute("month", month);
		// 请求转发
		request.getRequestDispatcher("/newform.jsp").forward(request, response);
		// 如果是直接输入网址访问此servlet，request被直接转发到newform时判定来源就会拒绝用户请求
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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		out.println("请求非法！请通过点击“新建”按钮新增配料单！");
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
