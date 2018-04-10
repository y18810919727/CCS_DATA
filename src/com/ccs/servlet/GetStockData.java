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

import com.ccs.dao.StockDAO;
import com.ccs.entity.Stock;

/*
 * 4月23日完成，用于为Ajax提供stock数据表的数据
 */

@WebServlet(name = "GetStockData", urlPatterns = { "/getstock.servlet" })
public class GetStockData extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetStockData() {
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
		String date = (String) request.getParameter("date");
		List<Stock> list = null;
		JSONArray jary = new JSONArray();
		// System.out.println(date);
		try {
			list = new StockDAO().FindByDate(date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null) {
			// 取出所有该日期下的单号及其内容
			for (Stock stock : list) {
				// System.out.println(stock.getNumber());
				// 以两位小数的形式显示
				DecimalFormat df = new DecimalFormat("#0.00");
				// 初始化json对象
				JSONObject jobj = new JSONObject();
				jobj.put("number", stock.getNumber());
				jobj.put("date", stock.getDate());
				
				jobj.put("lm_value", stock.getLm_value());
				jobj.put("lm_LUANSHYA",
						df.format(Double.parseDouble(stock.getLm_LUANSHYA())));
				jobj.put("lm_KANSANSHI",
						df.format(Double.parseDouble(stock.getLm_KANSANSHI())));
				jobj.put("lm_LUMWANA",
						df.format(Double.parseDouble(stock.getLm_LUMWANA())));
				jobj.put("lm_CHIBULUMA",
						df.format(Double.parseDouble(stock.getLm_CHIBULUMA())));
				jobj.put("lm_ENRC",
						df.format(Double.parseDouble(stock.getLm_ENRC())));
				jobj.put("lm_TF",
						df.format(Double.parseDouble(stock.getLm_TF())));
				jobj.put("lm_COLD",
						df.format(Double.parseDouble(stock.getLm_COLD())));
				jobj.put("lm_REVERTS",
						df.format(Double.parseDouble(stock.getLm_REVERTS())));
				jobj.put("lm_LUBAMBE",
						df.format(Double.parseDouble(stock.getLm_LUBAMBE())));
				jobj.put("lm_NFCA",
						df.format(Double.parseDouble(stock.getLm_NFCA())));
				jobj.put("lm_BOLO",
						df.format(Double.parseDouble(stock.getLm_BOLO())));
				jobj.put("lm_CCS",
						df.format(Double.parseDouble(stock.getLm_CCS())));
				jobj.put("tm_value", stock.getTm_value());
				jobj.put("tm_LUANSHYA",
						df.format(Double.parseDouble(stock.getTm_LUANSHYA())));
				jobj.put("tm_KANSANSHI",
						df.format(Double.parseDouble(stock.getTm_KANSANSHI())));
				jobj.put("tm_LUMWANA",
						df.format(Double.parseDouble(stock.getTm_LUMWANA())));
				jobj.put("tm_CHIBULUMA",
						df.format(Double.parseDouble(stock.getTm_CHIBULUMA())));
				jobj.put("tm_ENRC",
						df.format(Double.parseDouble(stock.getTm_ENRC())));
				jobj.put("tm_TF",
						df.format(Double.parseDouble(stock.getTm_TF())));
				jobj.put("tm_COLD",
						df.format(Double.parseDouble(stock.getTm_COLD())));
				jobj.put("tm_REVERTS",
						df.format(Double.parseDouble(stock.getTm_REVERTS())));
				jobj.put("tm_LUBAMBE",
						df.format(Double.parseDouble(stock.getTm_LUBAMBE())));
				jobj.put("tm_NFCA",
						df.format(Double.parseDouble(stock.getTm_NFCA())));
				jobj.put("tm_BOLO",
						df.format(Double.parseDouble(stock.getTm_BOLO())));
				jobj.put("tm_CCS",
						df.format(Double.parseDouble(stock.getTm_CCS())));
				jobj.put("cur_LUANSHYA",
						df.format(Double.parseDouble(stock.getCur_LUANSHYA())));
				jobj.put("cur_KANSANSHI",
						df.format(Double.parseDouble(stock.getCur_KANSANSHI())));
				jobj.put("cur_LUMWANA",
						df.format(Double.parseDouble(stock.getCur_LUMWANA())));
				jobj.put("cur_CHIBULUMA",
						df.format(Double.parseDouble(stock.getCur_CHIBULUMA())));
				jobj.put("cur_ENRC",
						df.format(Double.parseDouble(stock.getCur_ENRC())));
				jobj.put("cur_TF",
						df.format(Double.parseDouble(stock.getCur_TF())));
				jobj.put("cur_COLD",
						df.format(Double.parseDouble(stock.getCur_COLD())));
				jobj.put("cur_REVERTS",
						df.format(Double.parseDouble(stock.getCur_REVERTS())));
				jobj.put("cur_LUBAMBE",
						df.format(Double.parseDouble(stock.getCur_LUBAMBE())));
				jobj.put("cur_NFCA",
						df.format(Double.parseDouble(stock.getCur_NFCA())));
				jobj.put("cur_BOLO",
						df.format(Double.parseDouble(stock.getCur_BOLO())));
				jobj.put("cur_CCS",
						df.format(Double.parseDouble(stock.getCur_CCS())));
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
