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

import com.ccs.dao.IngredientDAO;
import com.ccs.dao.StockDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.entity.Ingredient;
import com.ccs.entity.Stock;
import com.ccs.entity.Summary;

@WebServlet(name = "UpdateFormInit", urlPatterns = { "/updateform.servlet" })
public class UpdateFormInit extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateFormInit() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (request.getHeader("Referer") == null) {
			PrintWriter out = response.getWriter();
			out.println("请求非法，请返回！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
			out.flush();
			out.close();
		}
		// 前台得到日期
		String str_date = (String) request.getParameter("date");
		// 将日期封入请求
		request.setAttribute("date", str_date);
		// 前台得到单号
		String str_num = (String) request.getParameter("number");// 单号
		System.out.println("用户准备修改配料单，单号：" + str_num);
		// 将单号封入请求
		request.setAttribute("number", str_num);
		Stock stock = null;
		Ingredient ingredient = null;
		Summary summary = null;
		try {
			// 查询三张表，得到数据传入前台，用于初始化表格数据
			stock = new StockDAO().FindByNum(str_num);
			ingredient = new IngredientDAO().FindOneByNum(str_num);
			summary = new SummaryDAO().FindOneByNum(str_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("stock", stock);
		request.setAttribute("ingredient", ingredient);
		request.setAttribute("summary", summary);
		// 请求转发
		request.getRequestDispatcher("/updateform.jsp").forward(request,
				response);
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
