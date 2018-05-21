package com.ccs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccs.dao.ProductionDAO;
import com.ccs.entity.Production;
@WebServlet(name = "UpdateRecordToProduction", urlPatterns = { "/updateRecordToProduction.servlet" })
public class UpdateRecordToProduction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateRecordToProduction() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Result = null;
		response.setContentType("text/html");
		//修改字符编码为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/* 2016年8月6日修复bug：修改记录时会修改原来的添加的时间为当前时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();// 得到当前系统时间
		String createdate = formatter.format(currentTime); // 将日期时间格式化
		*/
		//接受用户提交的信息
				String produceNo = new String(request.getParameter("produceNo").
						getBytes("utf-8"), "utf-8");
				String duty = request.getParameter("duty");
				String number = request.getParameter("number");
				String date = request.getParameter("date");
				String sampleNo = request.getParameter("sampleNo");
				String targetMatte = change_DecimalFormat(request.getParameter("targetMatte"));
				String factMatte = change_DecimalFormat(request.getParameter("factMatte"));
				String targetMagIron = change_DecimalFormat(request.getParameter("targetMagIron"));
				String factMagIron = change_DecimalFormat(request.getParameter("factMagIron"));
				String targetSiO2Fe = change_DecimalFormat(request.getParameter("targetSiO2Fe"));
				String factSiO2Fe = change_DecimalFormat(request.getParameter("factSiO2Fe"));
				String targetSiO2CaO = change_DecimalFormat(request.getParameter("targetSiO2CaO"));
				String factSiO2CaO = change_DecimalFormat(request.getParameter("factSiO2CaO"));
				String magnetic_force = new String(request.getParameter("magnetic_force").
						getBytes("utf-8"), "utf-8");
				String drum_hole = new String(request.getParameter("drum_hole").
						getBytes("utf-8"), "utf-8");
				String color = new String(request.getParameter("color").
						getBytes("utf-8"), "utf-8");
				String nozzle_pressure = change_DecimalFormat(request.getParameter("nozzle_pressure"));
				String fuel_ratio = change_DecimalFormat(request.getParameter("fuel_ratio"));
				String amountPerHour = change_DecimalFormat(request.getParameter("amountPerHour"));
				String time = change_DecimalFormat(request.getParameter("time"));
				String air_volume = change_DecimalFormat(request.getParameter("air_volume"));
				// 2016.09新增氧气纯度和富氧浓度
				String oxypur = change_DecimalFormat(request.getParameter("oxypur"));
				String oxyconc = change_DecimalFormat(request.getParameter("oxyconc"));
				String h1used = change_DecimalFormat(request.getParameter("h1used"));
				String h2used = change_DecimalFormat(request.getParameter("h2used"));
				String h3used = change_DecimalFormat(request.getParameter("h3used"));
				String h4used = change_DecimalFormat(request.getParameter("h4used"));
				// 5，6，7号仓也会使用，现将监控该字段的填写
				String h5used = change_DecimalFormat(request.getParameter("h5used"));
				String h6used = change_DecimalFormat(request.getParameter("h6used"));
				String h7used = change_DecimalFormat(request.getParameter("h7used"));
				String h8used = change_DecimalFormat(request.getParameter("h8used"));
				String h9used = change_DecimalFormat(request.getParameter("h9used"));
				String h10used = change_DecimalFormat(request.getParameter("h10used"));
				// 新增11,12号仓
				String h11used = change_DecimalFormat(request.getParameter("h11used"));
				String h12used = change_DecimalFormat(request.getParameter("h12used"));
				String h13used = change_DecimalFormat(request.getParameter("h13used"));
				String h14used = change_DecimalFormat(request.getParameter("h14used"));
				String h15used = change_DecimalFormat(request.getParameter("h15used"));
				String grade = change_DecimalFormat(request.getParameter("grade"));
				//将数据封装进production对象中（没有createdate）
				Production p = new Production();
				p.setDate(date);
				p.setNumber(number);
				p.setProduceNo(produceNo);
				p.setDuty(duty);
				p.setSampleNo(sampleNo);
				p.setTargetMatte(targetMatte);
				p.setFactMatte(factMatte);
				p.setTargetMagIron(targetMagIron);
				p.setFactMagIron(factMagIron);
				p.setTargetSiO2Fe(targetSiO2Fe);
				p.setFactSiO2Fe(factSiO2Fe);
				p.setTargetSiO2CaO(targetSiO2CaO);
				p.setFactSiO2CaO(factSiO2CaO);
				p.setMagnetic_force(magnetic_force);
				p.setDrum_hole(drum_hole);
				p.setColor(color);
				p.setNozzle_pressure(nozzle_pressure);
				p.setFuel_ratio(fuel_ratio);
				p.setAmountPerHour(amountPerHour);
				p.setTime(time);
				p.setAir_volume(air_volume);
				p.setOxypur(oxypur);
				p.setOxyconc(oxyconc);
				p.setH1used(h1used);
				p.setH2used(h2used);
				p.setH3used(h3used);
				p.setH4used(h4used);
				p.setH5used(h5used);
				p.setH6used(h6used);
				p.setH7used(h7used);
				p.setH8used(h8used);
				p.setH9used(h9used);
				p.setH10used(h10used);
				p.setH11used(h11used);
				p.setH12used(h12used);
				p.setH13used(h13used);
				p.setH14used(h14used);
				p.setH15used(h15used);
				p.setGrade(grade);
				// 在production表中修改一条记录
				try {
					boolean result = new ProductionDAO().UpdateOne(p);
					if(result){
						Result = "Update is OK";
						System.out.println("用户修改下料情况记录，单号：" 
						+ number + "，样号：" + sampleNo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 将结果传递给JSP，返回给用户
				// 设置键值对，键是"Result"，值是Result
				request.setAttribute("Result", Result);
				// 请求转发。转到"/material_records.jsp"页面下。注意一定加"/"
				request.getRequestDispatcher("/material_records.jsp").forward(request, response);
	}

	public String change_DecimalFormat(String s){
		DecimalFormat df = new DecimalFormat("#0.00");
		return (df.format(Double.parseDouble(s)));
	}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
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
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
