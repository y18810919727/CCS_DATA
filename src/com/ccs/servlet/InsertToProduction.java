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
import javax.servlet.http.HttpSession;

import com.ccs.dao.ProductionDAO;
import com.ccs.entity.Production;

@WebServlet(name="InserToProduction",urlPatterns={"/insertToproduction.servlet"})
public class InsertToProduction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertToProduction() {
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
		String Result=null;

		response.setContentType("text/html");
		//修改字符编码为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取session
		HttpSession session = request.getSession();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();// 得到当前系统时间
		String createdate = formatter.format(currentTime); // 将日期时间格式化
		// 接受用户提交的信息
		String produceNo = new String(request.getParameter("produceNo").
				getBytes("ISO-8859-1"), "utf-8");
		System.out.println("当班人是：" + produceNo);
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
				getBytes("ISO-8859-1"), "utf-8");
		String drum_hole = new String(request.getParameter("drum_hole").
				getBytes("ISO-8859-1"), "utf-8");
		String color = new String(request.getParameter("color").
				getBytes("ISO-8859-1"), "utf-8"); 
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
		String h5used = change_DecimalFormat(request.getParameter("h5used"));
		String h6used = change_DecimalFormat(request.getParameter("h6used"));
		String h7used = change_DecimalFormat(request.getParameter("h7used"));
		String h8used = change_DecimalFormat(request.getParameter("h8used"));
		String h9used = change_DecimalFormat(request.getParameter("h9used"));
		String h10used = change_DecimalFormat(request.getParameter("h10used"));
		String h11used = change_DecimalFormat(request.getParameter("h11used"));
		String h12used = change_DecimalFormat(request.getParameter("h12used"));
		// 将数据封装进production对象中
		Production p = new Production();
		p.setCreatedate(createdate);
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
		// 设置本次加入的记录“熔炼情况评分”为“待评分”
		p.setGrade("待评分");
		//向production表中插入一条记录
		try {
			boolean result = new ProductionDAO().InsertOne(p);
			// 样号不为1，说明本次添加之前已经有下料情况记录，要求填写上次熔炼情况评分
			if(Integer.parseInt(p.getSampleNo()) > 1){
				// 从前端取出上次熔炼情况评分
				String lastgrade = change_DecimalFormat(request.getParameter("lastgrade"));
				// 新建Production实体p2，初始化必要参数
				Production p2 = new Production();
				p2.setNumber(p.getNumber());
				String lastSampleNo = (Integer.parseInt(p.getSampleNo()) - 1) + "";
				p2.setSampleNo(lastSampleNo);
				p2.setGrade(lastgrade);
				boolean result2 = new ProductionDAO().UpdateOnlyGrade(p2);
				result = result && result2;
			}
			if(result){
				System.out.println("一条下料情况记录已经成功添加，单号：" 
						+ p.getNumber() + "，样号：" + p.getSampleNo());
				Result = "Insert is OK";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将结果传递给JSP，返回给用户
		// 设置键值对，键是"result"，值是result
		request.setAttribute("result", Result);
		// 请求转发。转到"/index.jsp"页面下。注意一定加"/"
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
