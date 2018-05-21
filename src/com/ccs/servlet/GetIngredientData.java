package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ccs.dao.IngredientDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.entity.Ingredient;
import com.ccs.entity.Mineral;

@WebServlet(name = "GetIngredientData", urlPatterns = { "/getingredient.servlet" })
public class GetIngredientData extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetIngredientData() {
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
		Ingredient ingredient = null;
		List<String> dosage = null;
		// 获取前台传来的单号
		String number = request.getParameter("number");
		System.out.println("已获取精矿成分数据，配料单号：" + number);
		JSONArray jary = new JSONArray();
		try {
			// 这个操作需要查询两张表
			ingredient = new IngredientDAO().FindOneByNum(number);
			dosage = new SummaryDAO().FindDosageByNum(number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 用反射方法完成
		// 2017年2月14日增加11,12号仓
		String[] stockname = { "NO1", "NO2", "NO3", "NO4", "NO8", "NO9", "NO10", "NO11", "NO12","NO13","NO14","NO15"};
		int[] house = { 0, 1, 2, 3, 7, 8, 9, 10, 11 , 12, 13, 14};
		if (ingredient != null) {
			int i = 0;
			// 封入15个仓的数据
			for (String str : stockname) {
				JSONObject jobj = new JSONObject();
				String getname = "get" + str + "_name";
				String getCu = "get" + str + "_Cu";
				String getFe = "get" + str + "_Fe";
				String getS = "get" + str + "_S";
				String getSiO2 = "get" + str + "_SiO2";
				String getCaO = "get" + str + "_CaO";
				String getMgO = "get" + str + "_MgO";
				String getAl2O3 = "get" + str + "_Al2O3";
				String getCo = "get" + str + "_Co";
				try {
					jobj.put("housenum", house[i] + 1);
					jobj.put(
							str + "_name",
							ingredient.getClass()
									.getMethod(getname, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_Cu",
							ingredient.getClass()
									.getMethod(getCu, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_Fe",
							ingredient.getClass()
									.getMethod(getFe, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_S",
							ingredient.getClass()
									.getMethod(getS, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_SiO2",
							ingredient.getClass()
									.getMethod(getSiO2, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_CaO",
							ingredient.getClass()
									.getMethod(getCaO, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_MgO",
							ingredient.getClass()
									.getMethod(getMgO, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_Al2O3",
							ingredient.getClass()
									.getMethod(getAl2O3, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(
							str + "_Co",
							ingredient.getClass()
									.getMethod(getCo, new Class[] {})
									.invoke(ingredient, new Object[] {}));
					jobj.put(str + "_dosage", dosage.get(house[i++]));
					jary.add(jobj);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 单独封入“模块输入成分”
			JSONObject jobj = new JSONObject();
			jobj.put("housenum", "-");
			jobj.put("Con_name", "模块输入成分concentrate");
			jobj.put("Con_Cu", ingredient.getCon_Cu());
			jobj.put("Con_Fe", ingredient.getCon_Fe());
			jobj.put("Con_S", ingredient.getCon_S());
			jobj.put("Con_SiO2", ingredient.getCon_SiO2());
			jobj.put("Con_CaO", ingredient.getCon_CaO());
			jobj.put("Con_MgO", ingredient.getCon_MgO());
			jobj.put("Con_Al2O3", ingredient.getCon_Al2O3());
			jobj.put("Con_Co", ingredient.getCon_Co());
			jobj.put("Con_dosage", ingredient.getCon_dosage());
			jary.add(jobj);
			// 封装该配料单是否使用过
			jobj = new JSONObject();
			jobj.put("is_used",ingredient.isIs_used());
			jary.add(jobj);
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
