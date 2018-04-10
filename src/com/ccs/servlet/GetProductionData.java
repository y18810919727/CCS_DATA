package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ccs.dao.MineralDAO;
import com.ccs.dao.ProductionDAO;
import com.ccs.entity.Mineral;
import com.ccs.entity.Production;

@WebServlet(name = "GetProductionData", urlPatterns = { "/getproductiondata.servlet" })
public class GetProductionData extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetProductionData() {
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

		List<Production> list = null;
		// 获取前台传来的单号
		String number = request.getParameter("number");
		String date = request.getParameter("date");
		System.out.println("用户查询下料情况记录表，单号：" + number);
		JSONArray jary = new JSONArray();
		try {
			list = new ProductionDAO().FindAllByNumber(number, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null) {
			for (Production production : list) {
				JSONObject jobj = new JSONObject();
				// 初始化json对象
				jobj.put("createDate", production.getCreatedate());
				jobj.put("produceNo", production.getProduceNo());
				jobj.put("duty", production.getDuty());
				jobj.put("sampleNo", production.getSampleNo());
				jobj.put("targetMatte", production.getTargetMatte());
				jobj.put("factMatte", production.getFactMatte());
				jobj.put("targetMagIron", production.getTargetMagIron());
				jobj.put("factMagIron", production.getFactMagIron());
				jobj.put("targetSiO2Fe", production.getTargetSiO2Fe());
				jobj.put("factSiO2Fe", production.getFactSiO2Fe());
				jobj.put("targetSiO2CaO", production.getTargetSiO2CaO());
				jobj.put("factSiO2CaO", production.getFactSiO2CaO());
				jobj.put("magnetic_force", production.getMagnetic_force());
				jobj.put("drum_hole", production.getDrum_hole());
				jobj.put("color", production.getColor());
				jobj.put("nozzle_pressure", production.getNozzle_pressure());
				jobj.put("fuel_ratio", production.getFuel_ratio());
				jobj.put("amountPerHour", production.getAmountPerHour());
				jobj.put("time", production.getTime());
				jobj.put("air_volume", production.getAir_volume());
				jobj.put("oxypur", production.getOxypur());
				jobj.put("oxyconc", production.getOxyconc());
				jobj.put("h1used", production.getH1used());
				jobj.put("h2used", production.getH2used());
				jobj.put("h3used", production.getH3used());
				jobj.put("h4used", production.getH4used());
				jobj.put("h5used", production.getH5used());
				jobj.put("h6used", production.getH6used());
				jobj.put("h7used", production.getH7used());
				jobj.put("h8used", production.getH8used());
				jobj.put("h9used", production.getH9used());
				jobj.put("h10used", production.getH10used());
				jobj.put("h11used", production.getH11used());
				jobj.put("h12used", production.getH12used());
				jobj.put("grade", production.getGrade());
				jary.add(jobj);
			}
		}
		// System.out.println(jary.toString());
		out.print(jary.toString());
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
