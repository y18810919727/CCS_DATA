package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ccs.dao.MineralDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.entity.Mineral;

/*
 * 此类已经废弃，无需使用！
 * 
 * 4月25日完成，用于为Ajax提供mineral数据表的数据及summary数据表的部分数据
 * 
 */

@WebServlet(name = "GetMineralData", urlPatterns = { "/getmineral.servlet" })
public class GetMineralData extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetMineralData() {
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
		List<Mineral> list = null;
		List<String> dosage = null;
		DecimalFormat df = new DecimalFormat("#0.00");
		// 获取前台传来的单号
		String number = request.getParameter("number");
		System.out.println("GetMineralData中的number：" + number);
		JSONArray jary = new JSONArray();
		try {
			// 这个操作需要查询两张表
			list = new MineralDAO().FindAll();
			dosage = new SummaryDAO().FindDosageByNum(number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null) {
			int i = 0;
			for (Mineral mineral : list) {
				JSONObject jobj = new JSONObject();
				jobj.put("housenum", mineral.getHousenum());
				jobj.put("name", mineral.getName());
				jobj.put("Cu", df.format(mineral.getCu()));
				jobj.put("Fe", df.format(mineral.getFe()));
				jobj.put("S", df.format(mineral.getS()));
				jobj.put("SiO2", df.format(mineral.getSiO2()));
				jobj.put("CaO", df.format(mineral.getCaO()));
				jobj.put("MgO", df.format(mineral.getMgO()));
				jobj.put("Al2O3", df.format(mineral.getAl2O3()));
				if (dosage != null)
					jobj.put("dosage", df.format(dosage.get(i++)));// 将查到的用量封入Json对象
				jary.add(jobj);
			}
		}
		System.out.println(jary.toString());
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
