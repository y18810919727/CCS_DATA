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

import com.ccs.dao.IngredientDAO;
import com.ccs.dao.ProductionDAO;
import com.ccs.dao.StockDAO;
import com.ccs.dao.SummaryDAO;
import com.ccs.dao.WarehouseDAO;
import com.ccs.entity.Ingredient;
import com.ccs.entity.Production;
import com.ccs.entity.Stock;
import com.ccs.entity.Summary;
import com.ccs.entity.Warehouse;

/*
 * 4月27日完成，用于完成新建配料单操作
 * 
 * 5月7日补充数据自动填0
 * 
 */

@WebServlet(name = "CreateNewForm", urlPatterns = { "/createnewform.servlet" })
public class CreateNewForm extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CreateNewForm() {
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
		PrintWriter out = response.getWriter();
		out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
		out.println("请求非法，请返回！");
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
		boolean isSuccess = true;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 将用户输入数据对应提取到stock
		Stock stock = new Stock();
		stock.setNumber(request.getParameter("number"));
		stock.setDate(request.getParameter("date"));
		String lmval = request.getParameter("lmval");
		String lm1 = change_DecimalFormat(request.getParameter("lm1"));
		String lm2 = change_DecimalFormat(request.getParameter("lm2"));
		String lm3 = change_DecimalFormat(request.getParameter("lm3"));
		String lm4 = change_DecimalFormat(request.getParameter("lm4"));
		String lm5 = change_DecimalFormat(request.getParameter("lm5"));
		String lm6 = change_DecimalFormat(request.getParameter("lm6"));
		String lm7 = change_DecimalFormat(request.getParameter("lm7"));
		String lm8 = change_DecimalFormat(request.getParameter("lm8"));
		String lm9 = change_DecimalFormat(request.getParameter("lm9"));
		String lm10 = change_DecimalFormat(request.getParameter("lm10"));
		String lm11 = change_DecimalFormat(request.getParameter("lm11"));
		String lm12 = change_DecimalFormat(request.getParameter("lm12"));
		String tmval = request.getParameter("tmval");
		String tm1 = change_DecimalFormat(request.getParameter("tm1"));
		String tm2 = change_DecimalFormat(request.getParameter("tm2"));
		String tm3 = change_DecimalFormat(request.getParameter("tm3"));
		String tm4 = change_DecimalFormat(request.getParameter("tm4"));
		String tm5 = change_DecimalFormat(request.getParameter("tm5"));
		String tm6 = change_DecimalFormat(request.getParameter("tm6"));
		String tm7 = change_DecimalFormat(request.getParameter("tm7"));
		String tm8 = change_DecimalFormat(request.getParameter("tm8"));
		String tm9 = change_DecimalFormat(request.getParameter("tm9"));
		String tm10 = change_DecimalFormat(request.getParameter("tm10"));
		String tm11 = change_DecimalFormat(request.getParameter("tm11"));
		String tm12 = change_DecimalFormat(request.getParameter("tm12"));
		// System.out.println("cur1=" + request.getParameter("cur1"));
		String cur1 = change_DecimalFormat(request.getParameter("cur1"));
		String cur2 = change_DecimalFormat(request.getParameter("cur2"));
		String cur3 = change_DecimalFormat(request.getParameter("cur3"));
		String cur4 = change_DecimalFormat(request.getParameter("cur4"));
		String cur5 = change_DecimalFormat(request.getParameter("cur5"));
		String cur6 = change_DecimalFormat(request.getParameter("cur6"));
		String cur7 = change_DecimalFormat(request.getParameter("cur7"));
		String cur8 = change_DecimalFormat(request.getParameter("cur8"));
		String cur9 = change_DecimalFormat(request.getParameter("cur9"));
		String cur10 = change_DecimalFormat(request.getParameter("cur10"));
		String cur11 = change_DecimalFormat(request.getParameter("cur11"));
		String cur12 = change_DecimalFormat(request.getParameter("cur12"));
		stock.setLm_value(lmval);
		stock.setLm_LUANSHYA(lm1);
		stock.setLm_KANSANSHI(lm2);
		stock.setLm_LUMWANA(lm3);
		stock.setLm_CHIBULUMA(lm4);
		stock.setLm_ENRC(lm5);
		stock.setLm_TF(lm6);
		stock.setLm_COLD(lm7);
		stock.setLm_REVERTS(lm8);
		stock.setLm_LUBAMBE(lm9);
		stock.setLm_NFCA(lm10);
		stock.setLm_BOLO(lm11);
		stock.setLm_CCS(lm12);
		// ----分割线----
		stock.setTm_value(tmval);
		stock.setTm_LUANSHYA(tm1);
		stock.setTm_KANSANSHI(tm2);
		stock.setTm_LUMWANA(tm3);
		stock.setTm_CHIBULUMA(tm4);
		stock.setTm_ENRC(tm5);
		stock.setTm_TF(tm6);
		stock.setTm_COLD(tm7);
		stock.setTm_REVERTS(tm8);
		stock.setTm_LUBAMBE(tm9);
		stock.setTm_NFCA(tm10);
		stock.setTm_BOLO(tm11);
		stock.setTm_CCS(tm12);
		// ----分割线----
		stock.setCur_LUANSHYA(cur1);
		stock.setCur_KANSANSHI(cur2);
		stock.setCur_LUMWANA(cur3);
		stock.setCur_CHIBULUMA(cur4);
		stock.setCur_ENRC(cur5);
		stock.setCur_TF(cur6);
		stock.setCur_COLD(cur7);
		stock.setCur_REVERTS(cur8);
		stock.setCur_LUBAMBE(cur9);
		stock.setCur_NFCA(cur10);
		stock.setCur_BOLO(cur11);
		stock.setCur_CCS(cur12);
		// 将用户输入数据对应提取到summary
		Summary summary = new Summary();
		Warehouse warehouse = null;
		try {
			// 从配料仓号表中取出每个仓号对应的精矿ID复制过来到配料总表
			warehouse = new WarehouseDAO().FindAll().get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		summary.setDate(request.getParameter("date"));
		summary.setNumber(request.getParameter("number"));
		summary.setHouse1(warehouse.getHouse1());
		summary.setHouse2(warehouse.getHouse2());
		summary.setHouse3(warehouse.getHouse3());
		summary.setHouse4(warehouse.getHouse4());
		summary.setHouse5(warehouse.getHouse5());
		summary.setHouse6(warehouse.getHouse6());
		summary.setHouse7(warehouse.getHouse7());
		summary.setHouse8(warehouse.getHouse8());
		summary.setHouse9(warehouse.getHouse9());
		summary.setHouse10(warehouse.getHouse10());
		String dosage1 = change_DecimalFormat(request.getParameter("dosage1"));
		String dosage2 = change_DecimalFormat(request.getParameter("dosage2"));
		String dosage3 = change_DecimalFormat(request.getParameter("dosage3"));
		String dosage4 = change_DecimalFormat(request.getParameter("dosage4"));
		String dosage5 = "0.00";
		String dosage6 = "0.00";
		String dosage7 = "0.00";
		String dosage8 = change_DecimalFormat(request.getParameter("dosage8"));
		String dosage9 = change_DecimalFormat(request.getParameter("dosage9"));
		String dosage10 = change_DecimalFormat(request.getParameter("dosage10"));
		String dosage11 = change_DecimalFormat(request.getParameter("dosage11"));
		String dosage12 = change_DecimalFormat(request.getParameter("dosage12"));
		String dosage13 = change_DecimalFormat(request.getParameter("dosage13"));
		String dosage14 = change_DecimalFormat(request.getParameter("dosage14"));
		String dosage15 = change_DecimalFormat(request.getParameter("dosage15"));
		// 防崩溃(注：getParameter得到的空串为""而不是null)
		summary.setDosage1(dosage1);
		summary.setDosage2(dosage2);
		summary.setDosage3(dosage3);
		summary.setDosage4(dosage4);
		summary.setDosage5(dosage5);
		summary.setDosage6(dosage6);
		summary.setDosage7(dosage7);
		summary.setDosage8(dosage8);
		summary.setDosage9(dosage9);
		summary.setDosage10(dosage10);
		summary.setDosage11(dosage11);
		summary.setDosage12(dosage12);
		summary.setDosage13(dosage13);
		summary.setDosage14(dosage14);
		summary.setDosage15(dosage15);
		String oxyconc = change_DecimalFormat(request.getParameter("oxyconc"));
		String digifax = change_DecimalFormat(request.getParameter("digifax"));
		String fuelratio = change_DecimalFormat(request
				.getParameter("fuelratio"));
		String airvolume = change_DecimalFormat(request
				.getParameter("airvolume"));
		String sup_SiO2 = change_DecimalFormat(request.getParameter("sup_SiO2"));
		String real_Matte = change_DecimalFormat(request
				.getParameter("real_Matte"));
		String real_Fe3O4 = change_DecimalFormat(request
				.getParameter("real_Fe3O4"));
		String real_SiO2Fe = change_DecimalFormat(request
				.getParameter("real_SiO2Fe"));
		String real_SiO2CaO = change_DecimalFormat(request
				.getParameter("real_SiO2CaO"));
		String sup_CaO = change_DecimalFormat(request.getParameter("sup_CaO"));
		String pre_oxyconc = change_DecimalFormat(request
				.getParameter("pre_oxyconc"));
		String pre_digifax = change_DecimalFormat(request
				.getParameter("pre_digifax"));
		String pre_fuelratio = change_DecimalFormat(request
				.getParameter("pre_fuelratio"));
		String pre_airvolume = change_DecimalFormat(request
				.getParameter("pre_airvolume"));
		String pre_sup_SiO2 = change_DecimalFormat(request
				.getParameter("pre_sup_SiO2"));
		String pre_real_matte = change_DecimalFormat(request
				.getParameter("pre_real_matte"));
		String pre_real_Fe3O4 = change_DecimalFormat(request
				.getParameter("pre_real_Fe3O4"));
		String pre_real_SiO2Fe = change_DecimalFormat(request
				.getParameter("pre_real_SiO2Fe"));
		String pre_real_SiO2CaO = change_DecimalFormat(request
				.getParameter("pre_real_SiO2CaO"));
		String pre_sup_CaO = change_DecimalFormat(request
				.getParameter("pre_sup_CaO"));
		summary.setOxyconc(oxyconc);
		summary.setDigifax(digifax);
		summary.setFuelratio(fuelratio);
		summary.setAirvolume(airvolume);
		summary.setSup_SiO2(sup_SiO2);
		summary.setReal_Matte(real_Matte);
		summary.setReal_Fe3O4(real_Fe3O4);
		summary.setReal_SiO2Fe(real_SiO2Fe);
		summary.setReal_SiO2CaO(real_SiO2CaO);
		summary.setSup_CaO(sup_CaO);
		summary.setPre_oxyconc(pre_oxyconc);
		summary.setPre_digifax(pre_digifax);
		summary.setPre_fuelratio(pre_fuelratio);
		summary.setPre_airvolume(pre_airvolume);
		summary.setPre_sup_SiO2(pre_sup_SiO2);
		summary.setPre_real_matte(pre_real_matte);
		summary.setPre_real_Fe3O4(pre_real_Fe3O4);
		summary.setPre_real_SiO2Fe(pre_real_SiO2Fe);
		summary.setPre_real_SiO2CaO(pre_real_SiO2CaO);
		summary.setPre_sup_CaO(pre_sup_CaO);
		// 将数据封装进production对象中
		Production p = new Production();
		p.setDate(summary.getDate());
		p.setNumber(summary.getNumber());
		p.setProduceNo("0");
		p.setDuty("0");
		p.setSampleNo("0");
		p.setTargetMatte(summary.getReal_Matte());
		p.setFactMatte("0.00");
		p.setTargetMagIron(summary.getReal_Fe3O4());
		p.setFactMagIron("0.00");
		p.setTargetSiO2Fe(summary.getReal_SiO2Fe());
		p.setFactSiO2Fe("0.00");
		p.setTargetSiO2CaO(summary.getReal_SiO2CaO());
		p.setFactSiO2CaO("0.00");
		p.setMagnetic_force("无");
		p.setDrum_hole("无");
		p.setColor("无");
		p.setNozzle_pressure("0.00");
		p.setFuel_ratio(summary.getFuelratio());
		p.setAmountPerHour("0.00");
		p.setTime("0.00");
		p.setAir_volume(summary.getAirvolume());
		p.setH1used("0.00");
		p.setH2used("0.00");
		p.setH3used("0.00");
		p.setH4used("0.00");
		p.setH5used("0.00");
		p.setH6used("0.00");
		p.setH7used("0.00");
		p.setH8used("0.00");
		p.setH9used("0.00");
		p.setH10used("0.00");
		p.setH11used("0.00");
		p.setH12used("0.00");
		p.setH13used("0.00");
		p.setH14used("0.00");
		p.setH15used("0.00");
		p.setCreatedate("0");

		// 从前台获取表ingredient中个字段的数据
		Ingredient ingredient = new Ingredient();
		ingredient.setNumber(request.getParameter("number"));
		ingredient.setDate(request.getParameter("date"));
		ingredient.setNO1_name(request.getParameter("NO1_name"));
		ingredient.setNO1_Cu(change_DecimalFormat(request
				.getParameter("NO1_Cu")));
		ingredient.setNO1_Fe(change_DecimalFormat(request
				.getParameter("NO1_Fe")));
		ingredient
				.setNO1_S(change_DecimalFormat(request.getParameter("NO1_S")));
		ingredient.setNO1_Co(change_DecimalFormat(request
				.getParameter("NO1_Co")));
		ingredient.setNO1_SiO2(change_DecimalFormat(request
				.getParameter("NO1_SiO2")));
		ingredient.setNO1_CaO(change_DecimalFormat(request
				.getParameter("NO1_CaO")));
		ingredient.setNO1_MgO(change_DecimalFormat(request
				.getParameter("NO1_MgO")));
		ingredient.setNO1_Al2O3(change_DecimalFormat(request
				.getParameter("NO1_Al2O3")));
		// ------分割线------
		ingredient.setNO2_name(request.getParameter("NO2_name"));
		ingredient.setNO2_Cu(change_DecimalFormat(request
				.getParameter("NO2_Cu")));
		ingredient.setNO2_Fe(change_DecimalFormat(request
				.getParameter("NO2_Fe")));
		ingredient
				.setNO2_S(change_DecimalFormat(request.getParameter("NO2_S")));
		ingredient.setNO2_Co(change_DecimalFormat(request
				.getParameter("NO2_Co")));
		ingredient.setNO2_SiO2(change_DecimalFormat(request
				.getParameter("NO2_SiO2")));
		ingredient.setNO2_CaO(change_DecimalFormat(request
				.getParameter("NO2_CaO")));
		ingredient.setNO2_MgO(change_DecimalFormat(request
				.getParameter("NO2_MgO")));
		ingredient.setNO2_Al2O3(change_DecimalFormat(request
				.getParameter("NO2_Al2O3")));
		// ------分割线------
		ingredient.setNO3_name(request.getParameter("NO3_name"));
		ingredient.setNO3_Cu(change_DecimalFormat(request
				.getParameter("NO3_Cu")));
		ingredient.setNO3_Fe(change_DecimalFormat(request
				.getParameter("NO3_Fe")));
		ingredient
				.setNO3_S(change_DecimalFormat(request.getParameter("NO3_S")));
		ingredient.setNO3_Co(change_DecimalFormat(request
				.getParameter("NO3_Co")));
		ingredient.setNO3_SiO2(change_DecimalFormat(request
				.getParameter("NO3_SiO2")));
		ingredient.setNO3_CaO(change_DecimalFormat(request
				.getParameter("NO3_CaO")));
		ingredient.setNO3_MgO(change_DecimalFormat(request
				.getParameter("NO3_MgO")));
		ingredient.setNO3_Al2O3(change_DecimalFormat(request
				.getParameter("NO3_Al2O3")));
		// ------分割线------
		ingredient.setNO4_name(request.getParameter("NO4_name"));
		ingredient.setNO4_Cu(change_DecimalFormat(request
				.getParameter("NO4_Cu")));
		ingredient.setNO4_Fe(change_DecimalFormat(request
				.getParameter("NO4_Fe")));
		ingredient
				.setNO4_S(change_DecimalFormat(request.getParameter("NO4_S")));
		ingredient.setNO4_Co(change_DecimalFormat(request
				.getParameter("NO4_Co")));
		ingredient.setNO4_SiO2(change_DecimalFormat(request
				.getParameter("NO4_SiO2")));
		ingredient.setNO4_CaO(change_DecimalFormat(request
				.getParameter("NO4_CaO")));
		ingredient.setNO4_MgO(change_DecimalFormat(request
				.getParameter("NO4_MgO")));
		ingredient.setNO4_Al2O3(change_DecimalFormat(request
				.getParameter("NO4_Al2O3")));
		// ------分割线------
		ingredient.setNO8_name(request.getParameter("NO8_name"));
		ingredient.setNO8_Cu(change_DecimalFormat(request
				.getParameter("NO8_Cu")));
		ingredient.setNO8_Fe(change_DecimalFormat(request
				.getParameter("NO8_Fe")));
		ingredient
				.setNO8_S(change_DecimalFormat(request.getParameter("NO8_S")));
		ingredient.setNO8_Co(change_DecimalFormat(request
				.getParameter("NO8_Co")));
		ingredient.setNO8_SiO2(change_DecimalFormat(request
				.getParameter("NO8_SiO2")));
		ingredient.setNO8_CaO(change_DecimalFormat(request
				.getParameter("NO8_CaO")));
		ingredient.setNO8_MgO(change_DecimalFormat(request
				.getParameter("NO8_MgO")));
		ingredient.setNO8_Al2O3(change_DecimalFormat(request
				.getParameter("NO8_Al2O3")));
		// ------分割线------
		ingredient.setNO9_name(request.getParameter("NO9_name"));
		ingredient.setNO9_Cu(change_DecimalFormat(request
				.getParameter("NO9_Cu")));
		ingredient.setNO9_Fe(change_DecimalFormat(request
				.getParameter("NO9_Fe")));
		ingredient
				.setNO9_S(change_DecimalFormat(request.getParameter("NO9_S")));
		ingredient.setNO9_Co(change_DecimalFormat(request
				.getParameter("NO9_Co")));
		ingredient.setNO9_SiO2(change_DecimalFormat(request
				.getParameter("NO9_SiO2")));
		ingredient.setNO9_CaO(change_DecimalFormat(request
				.getParameter("NO9_CaO")));
		ingredient.setNO9_MgO(change_DecimalFormat(request
				.getParameter("NO9_MgO")));
		ingredient.setNO9_Al2O3(change_DecimalFormat(request
				.getParameter("NO9_Al2O3")));
		// ------分割线------
		ingredient.setNO10_name(request.getParameter("NO10_name"));
		ingredient.setNO10_Cu(change_DecimalFormat(request
				.getParameter("NO10_Cu")));
		ingredient.setNO10_Fe(change_DecimalFormat(request
				.getParameter("NO10_Fe")));
		ingredient.setNO10_S(change_DecimalFormat(request
				.getParameter("NO10_S")));
		ingredient.setNO10_Co(change_DecimalFormat(request
				.getParameter("NO10_Co")));
		ingredient.setNO10_SiO2(change_DecimalFormat(request
				.getParameter("NO10_SiO2")));
		ingredient.setNO10_CaO(change_DecimalFormat(request
				.getParameter("NO10_CaO")));
		ingredient.setNO10_MgO(change_DecimalFormat(request
				.getParameter("NO10_MgO")));
		ingredient.setNO10_Al2O3(change_DecimalFormat(request
				.getParameter("NO10_Al2O3")));
		// ------分割线------
		ingredient.setNO11_name(request.getParameter("NO11_name"));
		ingredient.setNO11_Cu(change_DecimalFormat(request
				.getParameter("NO11_Cu")));
		ingredient.setNO11_Fe(change_DecimalFormat(request
				.getParameter("NO11_Fe")));
		ingredient.setNO11_S(change_DecimalFormat(request
				.getParameter("NO11_S")));
		ingredient.setNO11_Co(change_DecimalFormat(request
				.getParameter("NO11_Co")));
		ingredient.setNO11_SiO2(change_DecimalFormat(request
				.getParameter("NO11_SiO2")));
		ingredient.setNO11_CaO(change_DecimalFormat(request
				.getParameter("NO11_CaO")));
		ingredient.setNO11_MgO(change_DecimalFormat(request
				.getParameter("NO11_MgO")));
		ingredient.setNO11_Al2O3(change_DecimalFormat(request
				.getParameter("NO11_Al2O3")));
		// ------分割线------
		ingredient.setNO12_name(request.getParameter("NO12_name"));
		ingredient.setNO12_Cu(change_DecimalFormat(request
				.getParameter("NO12_Cu")));
		ingredient.setNO12_Fe(change_DecimalFormat(request
				.getParameter("NO12_Fe")));
		ingredient.setNO12_S(change_DecimalFormat(request
				.getParameter("NO12_S")));
		ingredient.setNO12_Co(change_DecimalFormat(request
				.getParameter("NO12_Co")));
		ingredient.setNO12_SiO2(change_DecimalFormat(request
				.getParameter("NO12_SiO2")));
		ingredient.setNO12_CaO(change_DecimalFormat(request
				.getParameter("NO12_CaO")));
		ingredient.setNO12_MgO(change_DecimalFormat(request
				.getParameter("NO12_MgO")));
		ingredient.setNO12_Al2O3(change_DecimalFormat(request
				.getParameter("NO12_Al2O3")));
		// ------分割线------
		ingredient.setNO13_name(request.getParameter("NO13_name"));
		ingredient.setNO13_Cu(change_DecimalFormat(request
				.getParameter("NO13_Cu")));
		ingredient.setNO13_Fe(change_DecimalFormat(request
				.getParameter("NO13_Fe")));
		ingredient.setNO13_S(change_DecimalFormat(request
				.getParameter("NO13_S")));
		ingredient.setNO13_Co(change_DecimalFormat(request
				.getParameter("NO13_Co")));
		ingredient.setNO13_SiO2(change_DecimalFormat(request
				.getParameter("NO13_SiO2")));
		ingredient.setNO13_CaO(change_DecimalFormat(request
				.getParameter("NO13_CaO")));
		ingredient.setNO13_MgO(change_DecimalFormat(request
				.getParameter("NO13_MgO")));
		ingredient.setNO13_Al2O3(change_DecimalFormat(request
				.getParameter("NO13_Al2O3")));
		// ------分割线------
		ingredient.setNO14_name(request.getParameter("NO14_name"));
		ingredient.setNO14_Cu(change_DecimalFormat(request
				.getParameter("NO14_Cu")));
		ingredient.setNO14_Fe(change_DecimalFormat(request
				.getParameter("NO14_Fe")));
		ingredient.setNO14_S(change_DecimalFormat(request
				.getParameter("NO14_S")));
		ingredient.setNO14_Co(change_DecimalFormat(request
				.getParameter("NO14_Co")));
		ingredient.setNO14_SiO2(change_DecimalFormat(request
				.getParameter("NO14_SiO2")));
		ingredient.setNO14_CaO(change_DecimalFormat(request
				.getParameter("NO14_CaO")));
		ingredient.setNO14_MgO(change_DecimalFormat(request
				.getParameter("NO14_MgO")));
		ingredient.setNO14_Al2O3(change_DecimalFormat(request
				.getParameter("NO14_Al2O3")));
		// ------分割线------
		ingredient.setNO15_name(request.getParameter("NO15_name"));
		ingredient.setNO15_Cu(change_DecimalFormat(request
				.getParameter("NO15_Cu")));
		ingredient.setNO15_Fe(change_DecimalFormat(request
				.getParameter("NO15_Fe")));
		ingredient.setNO15_S(change_DecimalFormat(request
				.getParameter("NO15_S")));
		ingredient.setNO15_Co(change_DecimalFormat(request
				.getParameter("NO15_Co")));
		ingredient.setNO15_SiO2(change_DecimalFormat(request
				.getParameter("NO15_SiO2")));
		ingredient.setNO15_CaO(change_DecimalFormat(request
				.getParameter("NO15_CaO")));
		ingredient.setNO15_MgO(change_DecimalFormat(request
				.getParameter("NO15_MgO")));
		ingredient.setNO15_Al2O3(change_DecimalFormat(request
				.getParameter("NO15_Al2O3")));
		// ------分割线------
		ingredient.setCon_Cu(change_DecimalFormat(request
				.getParameter("Con_Cu")));
		ingredient.setCon_Fe(change_DecimalFormat(request
				.getParameter("Con_Fe")));
		ingredient
				.setCon_S(change_DecimalFormat(request.getParameter("Con_S")));
		ingredient.setCon_Co(change_DecimalFormat(request
				.getParameter("Con_Co")));
		ingredient.setCon_SiO2(change_DecimalFormat(request
				.getParameter("Con_SiO2")));
		ingredient.setCon_CaO(change_DecimalFormat(request
				.getParameter("Con_CaO")));
		ingredient.setCon_MgO(change_DecimalFormat(request
				.getParameter("Con_MgO")));
		ingredient.setCon_Al2O3(change_DecimalFormat(request
				.getParameter("Con_Al2O3")));
		ingredient.setCon_dosage(change_DecimalFormat(request
				.getParameter("Con_dosage")));
		try {
			boolean stockres = new StockDAO().InsertOne(stock);
			boolean summaryres = new SummaryDAO().InsertOne(summary);
			boolean productions = new ProductionDAO().InsertOne(p);
			boolean ingredients = new IngredientDAO().InsertOne(ingredient);
			if (!stockres)// stock表插入失败
				isSuccess = false;
			if (!summaryres)// summary表插入失败
				isSuccess = false;
			if (!productions)// production表插入失败
				isSuccess = false;
			if (!ingredients)// ingredient表插入失败
				isSuccess = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isSuccess) {
			System.out
					.println("用户新建配料单成功，单号：" + request.getParameter("number"));
			PrintWriter out = response.getWriter();
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
			out.println("操作成功...<br>如果您的浏览器没有自动跳转，请"
					+ "<a href='/CCS/mainform.jsp'>点击这里返回</a>");
			out.flush();
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println("<meta http-equiv='refresh' content='2; url=/CCS/mainform.jsp'> ");
			out.println("操作失败！即将返回到查询页面...<br>如果您的浏览器没有自动跳转，请"
					+ "<a href='/CCS/mainform.jsp'>点击这里返回</a>");
			out.flush();
			out.close();
		}
	}

	public String change_DecimalFormat(String s) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return (df.format(Double.parseDouble(s)));
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
