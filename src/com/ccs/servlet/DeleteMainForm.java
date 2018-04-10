package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccs.dao.IngredientDAO;
import com.ccs.dao.ProductionDAO;
import com.ccs.dao.StockDAO;
import com.ccs.dao.SummaryDAO;

@WebServlet(name = "DeleteMainForm", urlPatterns = { "/doDeleteMain.servlet" })
public class DeleteMainForm extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteMainForm() {
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
		if (request.getHeader("Referer") == null) {
			PrintWriter out = response.getWriter();
			out.println("请求非法，请返回！");
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
			out.flush();
			out.close();
		}
		String number = request.getParameter("number");
		try {
			boolean isSuccess = true;
			boolean stockres = new StockDAO().DeleteOne(number);
			boolean summaryres = new SummaryDAO().DeleteOne(number);
			boolean productions = new ProductionDAO().DeleteByNum(number);
			boolean ingredients = new IngredientDAO().DeleteOne(number);
			System.out.println("用户删除配料单：" + number + "，删除情况如下");
			System.out.println("StockDelete:" + stockres);
			System.out.println("SummaryDelete:" + summaryres);
			System.out.println("productionsDelete:" + productions);
			System.out.println("ingredientsDelete:" + ingredients);
			if (!stockres)// stock表插入失败
				isSuccess = false;
			if (!summaryres)// summary表插入失败
				isSuccess = false;
			if (!productions)// production表插入失败
				isSuccess = false;
			if (!ingredients)// ingredient表插入失败
				isSuccess = false;
			if (isSuccess) {
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
				out.println("数据删除成功...<br>如果您的浏览器没有自动跳转，请"
						+ "<a href='/CCS/mainform.jsp'>点击这里返回</a>");
				out.flush();
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
				out.println("数据删除失败！即将返回到查询页面...<br>如果您的浏览器没有自动跳转，请"
						+ "<a href='/CCS/mainform.jsp'>点击这里返回</a>");
				out.flush();
				out.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
