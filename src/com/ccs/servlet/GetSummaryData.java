package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccs.dao.SummaryDAO;
import com.ccs.entity.Summary;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 4月26日完成，用于为Ajax提供summary数据表的数据
 */

@WebServlet(name = "GetSummaryData", urlPatterns = { "/getsummary.servlet" })
public class GetSummaryData extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetSummaryData() {
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
		PrintWriter out = response.getWriter();
		// 获取前台传来的单号
		String number = request.getParameter("number");
		System.out.println("已获取控制参数数据，配料单号：" + number);
		JSONObject jobj = new JSONObject();
		Summary s = null;
		try {
			s = new SummaryDAO().FindOneByNum(number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (s != null) {
			DecimalFormat df = new DecimalFormat("#0.00");
			jobj.put("oxyconc", df.format(Double.parseDouble(s.getOxyconc())));
			jobj.put("digifax", df.format(Double.parseDouble(s.getDigifax())));
			jobj.put("fuelratio",
					df.format(Double.parseDouble(s.getFuelratio())));
			jobj.put("airvolume",
					df.format(Double.parseDouble(s.getAirvolume())));
			jobj.put("sup_SiO2", df.format(Double.parseDouble(s.getSup_SiO2())));
			jobj.put("real_Matte",
					df.format(Double.parseDouble(s.getReal_Matte())));
			jobj.put("real_Fe3O4",
					df.format(Double.parseDouble(s.getReal_Fe3O4())));
			jobj.put("real_SiO2Fe",
					df.format(Double.parseDouble(s.getReal_SiO2Fe())));
			jobj.put("real_SiO2CaO",
					df.format(Double.parseDouble(s.getReal_SiO2CaO())));
			jobj.put("sup_CaO", df.format(Double.parseDouble(s.getSup_CaO())));
			jobj.put("pre_oxyconc",
					df.format(Double.parseDouble(s.getPre_oxyconc())));
			jobj.put("pre_digifax",
					df.format(Double.parseDouble(s.getPre_digifax())));
			jobj.put("pre_fuelratio",
					df.format(Double.parseDouble(s.getPre_fuelratio())));
			jobj.put("pre_airvolume",
					df.format(Double.parseDouble(s.getPre_airvolume())));
			jobj.put("pre_sup_SiO2",
					df.format(Double.parseDouble(s.getPre_sup_SiO2())));
			jobj.put("pre_real_matte",
					df.format(Double.parseDouble(s.getPre_real_matte())));
			jobj.put("pre_real_Fe3O4",
					df.format(Double.parseDouble(s.getPre_real_Fe3O4())));
			jobj.put("pre_real_SiO2Fe",
					df.format(Double.parseDouble(s.getPre_real_SiO2Fe())));
			jobj.put("pre_real_SiO2CaO",
					df.format(Double.parseDouble(s.getPre_real_SiO2CaO())));
			jobj.put("pre_sup_CaO",
					df.format(Double.parseDouble(s.getPre_sup_CaO())));
		}
		// System.out.println(jobj.toString());
		out.print(jobj.toString());
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
