package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Ingredient;
import com.ccs.entity.Stock;
import com.ccs.util.DBUtil;

/*
 * 5月27日，增加Ingredient数据库操作实体类。用于对新添加的表进行操作。
 * 
 * 7月17日，增加Con_Cu等9个字段的操作
 * 
 * 8月29日，增加查找所有日期
 * 
 * 2017年2月14日，根据数据库的变动修改操作逻辑(增加了11,12号仓)
 */

public class IngredientDAO {
	/**
	 * 查询配料成分表所有记录
	 * 
	 * @return List<Ingredient> 一个包含ingredient表全部记录的集合
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Ingredient> FindAll() throws SQLException {
		List<Ingredient> list = new ArrayList<Ingredient>();
		String sql = "select * from ingredient";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Ingredient i = new Ingredient();
			i.setId(rs.getInt(1));
			i.setNumber(rs.getString(2));
			i.setDate(rs.getString(3));
			i.setNO1_Cu(rs.getString(4));
			i.setNO1_Fe(rs.getString(5));
			i.setNO1_S(rs.getString(6));
			i.setNO1_Co(rs.getString(7));
			i.setNO1_SiO2(rs.getString(8));
			i.setNO1_CaO(rs.getString(9));
			i.setNO1_MgO(rs.getString(10));
			i.setNO1_Al2O3(rs.getString(11));
			i.setNO2_Cu(rs.getString(12));
			i.setNO2_Fe(rs.getString(13));
			i.setNO2_S(rs.getString(14));
			i.setNO2_Co(rs.getString(15));
			i.setNO2_SiO2(rs.getString(16));
			i.setNO2_CaO(rs.getString(17));
			i.setNO2_MgO(rs.getString(18));
			i.setNO2_Al2O3(rs.getString(19));
			i.setNO3_Cu(rs.getString(20));
			i.setNO3_Fe(rs.getString(21));
			i.setNO3_S(rs.getString(22));
			i.setNO3_Co(rs.getString(23));
			i.setNO3_SiO2(rs.getString(24));
			i.setNO3_CaO(rs.getString(25));
			i.setNO3_MgO(rs.getString(26));
			i.setNO3_Al2O3(rs.getString(27));
			i.setNO4_Cu(rs.getString(28));
			i.setNO4_Fe(rs.getString(29));
			i.setNO4_S(rs.getString(30));
			i.setNO4_Co(rs.getString(31));
			i.setNO4_SiO2(rs.getString(32));
			i.setNO4_CaO(rs.getString(33));
			i.setNO4_MgO(rs.getString(34));
			i.setNO4_Al2O3(rs.getString(35));
			i.setNO8_Cu(rs.getString(36));
			i.setNO8_Fe(rs.getString(37));
			i.setNO8_S(rs.getString(38));
			i.setNO8_Co(rs.getString(39));
			i.setNO8_SiO2(rs.getString(40));
			i.setNO8_CaO(rs.getString(41));
			i.setNO8_MgO(rs.getString(42));
			i.setNO8_Al2O3(rs.getString(43));
			i.setNO9_Cu(rs.getString(44));
			i.setNO9_Fe(rs.getString(45));
			i.setNO9_S(rs.getString(46));
			i.setNO9_Co(rs.getString(47));
			i.setNO9_SiO2(rs.getString(48));
			i.setNO9_CaO(rs.getString(49));
			i.setNO9_MgO(rs.getString(50));
			i.setNO9_Al2O3(rs.getString(51));
			i.setNO10_Cu(rs.getString(52));
			i.setNO10_Fe(rs.getString(53));
			i.setNO10_S(rs.getString(54));
			i.setNO10_Co(rs.getString(55));
			i.setNO10_SiO2(rs.getString(56));
			i.setNO10_CaO(rs.getString(57));
			i.setNO10_MgO(rs.getString(58));
			i.setNO10_Al2O3(rs.getString(59));
			i.setNO11_Cu(rs.getString(60));
			i.setNO11_Fe(rs.getString(61));
			i.setNO11_S(rs.getString(62));
			i.setNO11_Co(rs.getString(63));
			i.setNO11_SiO2(rs.getString(64));
			i.setNO11_CaO(rs.getString(65));
			i.setNO11_MgO(rs.getString(66));
			i.setNO11_Al2O3(rs.getString(67));
			i.setNO12_Cu(rs.getString(68));
			i.setNO12_Fe(rs.getString(69));
			i.setNO12_S(rs.getString(70));
			i.setNO12_Co(rs.getString(71));
			i.setNO12_SiO2(rs.getString(72));
			i.setNO12_CaO(rs.getString(73));
			i.setNO12_MgO(rs.getString(74));
			i.setNO12_Al2O3(rs.getString(75));
			i.setNO13_Cu(rs.getString(76));
			i.setNO13_Fe(rs.getString(77));
			i.setNO13_S(rs.getString(78));
			i.setNO13_Co(rs.getString(79));
			i.setNO13_SiO2(rs.getString(80));
			i.setNO13_CaO(rs.getString(81));
			i.setNO13_MgO(rs.getString(82));
			i.setNO13_Al2O3(rs.getString(83));
			i.setNO14_Cu(rs.getString(84));
			i.setNO14_Fe(rs.getString(85));
			i.setNO14_S(rs.getString(86));
			i.setNO14_Co(rs.getString(87));
			i.setNO14_SiO2(rs.getString(88));
			i.setNO14_CaO(rs.getString(89));
			i.setNO14_MgO(rs.getString(90));
			i.setNO14_Al2O3(rs.getString(91));
			i.setNO15_Cu(rs.getString(92));
			i.setNO15_Fe(rs.getString(93));
			i.setNO15_S(rs.getString(94));
			i.setNO15_Co(rs.getString(95));
			i.setNO15_SiO2(rs.getString(96));
			i.setNO15_CaO(rs.getString(97));
			i.setNO15_MgO(rs.getString(98));
			i.setNO15_Al2O3(rs.getString(99));
			i.setNO1_name(rs.getString(100));
			i.setNO2_name(rs.getString(101));
			i.setNO3_name(rs.getString(102));
			i.setNO4_name(rs.getString(103));
			i.setNO8_name(rs.getString(104));
			i.setNO9_name(rs.getString(105));
			i.setNO10_name(rs.getString(106));
			i.setNO11_name(rs.getString(107));
			i.setNO12_name(rs.getString(108));
			i.setNO13_name(rs.getString(109));
			i.setNO14_name(rs.getString(110));
			i.setNO15_name(rs.getString(111));
			i.setCon_Cu(rs.getString(112));
			i.setCon_Fe(rs.getString(113));
			i.setCon_S(rs.getString(114));
			i.setCon_Co(rs.getString(115));
			i.setCon_SiO2(rs.getString(116));
			i.setCon_CaO(rs.getString(117));
			i.setCon_MgO(rs.getString(118));
			i.setCon_Al2O3(rs.getString(119));
			i.setCon_dosage(rs.getString(120));
			i.setIs_used(rs.getBoolean(121));
			list.add(i);
		}
		DBUtil.closeConnection();
		return list;
	}

	/**
	 * 按单号查询配料成分表记录
	 * 
	 * @return Ingredient 一个ingredient表记录实体
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public Ingredient FindOneByNum(String number) throws SQLException {
		String sql = "select * from ingredient where number='" + number + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		Ingredient i = null;
		if (rs.next()) {
			i = new Ingredient();
			i.setId(rs.getInt(1));
			i.setNumber(rs.getString(2));
			i.setDate(rs.getString(3));
			i.setNO1_Cu(rs.getString(4));
			i.setNO1_Fe(rs.getString(5));
			i.setNO1_S(rs.getString(6));
			i.setNO1_Co(rs.getString(7));
			i.setNO1_SiO2(rs.getString(8));
			i.setNO1_CaO(rs.getString(9));
			i.setNO1_MgO(rs.getString(10));
			i.setNO1_Al2O3(rs.getString(11));
			i.setNO2_Cu(rs.getString(12));
			i.setNO2_Fe(rs.getString(13));
			i.setNO2_S(rs.getString(14));
			i.setNO2_Co(rs.getString(15));
			i.setNO2_SiO2(rs.getString(16));
			i.setNO2_CaO(rs.getString(17));
			i.setNO2_MgO(rs.getString(18));
			i.setNO2_Al2O3(rs.getString(19));
			i.setNO3_Cu(rs.getString(20));
			i.setNO3_Fe(rs.getString(21));
			i.setNO3_S(rs.getString(22));
			i.setNO3_Co(rs.getString(23));
			i.setNO3_SiO2(rs.getString(24));
			i.setNO3_CaO(rs.getString(25));
			i.setNO3_MgO(rs.getString(26));
			i.setNO3_Al2O3(rs.getString(27));
			i.setNO4_Cu(rs.getString(28));
			i.setNO4_Fe(rs.getString(29));
			i.setNO4_S(rs.getString(30));
			i.setNO4_Co(rs.getString(31));
			i.setNO4_SiO2(rs.getString(32));
			i.setNO4_CaO(rs.getString(33));
			i.setNO4_MgO(rs.getString(34));
			i.setNO4_Al2O3(rs.getString(35));
			i.setNO8_Cu(rs.getString(36));
			i.setNO8_Fe(rs.getString(37));
			i.setNO8_S(rs.getString(38));
			i.setNO8_Co(rs.getString(39));
			i.setNO8_SiO2(rs.getString(40));
			i.setNO8_CaO(rs.getString(41));
			i.setNO8_MgO(rs.getString(42));
			i.setNO8_Al2O3(rs.getString(43));
			i.setNO9_Cu(rs.getString(44));
			i.setNO9_Fe(rs.getString(45));
			i.setNO9_S(rs.getString(46));
			i.setNO9_Co(rs.getString(47));
			i.setNO9_SiO2(rs.getString(48));
			i.setNO9_CaO(rs.getString(49));
			i.setNO9_MgO(rs.getString(50));
			i.setNO9_Al2O3(rs.getString(51));
			i.setNO10_Cu(rs.getString(52));
			i.setNO10_Fe(rs.getString(53));
			i.setNO10_S(rs.getString(54));
			i.setNO10_Co(rs.getString(55));
			i.setNO10_SiO2(rs.getString(56));
			i.setNO10_CaO(rs.getString(57));
			i.setNO10_MgO(rs.getString(58));
			i.setNO10_Al2O3(rs.getString(59));
			i.setNO11_Cu(rs.getString(60));
			i.setNO11_Fe(rs.getString(61));
			i.setNO11_S(rs.getString(62));
			i.setNO11_Co(rs.getString(63));
			i.setNO11_SiO2(rs.getString(64));
			i.setNO11_CaO(rs.getString(65));
			i.setNO11_MgO(rs.getString(66));
			i.setNO11_Al2O3(rs.getString(67));
			i.setNO12_Cu(rs.getString(68));
			i.setNO12_Fe(rs.getString(69));
			i.setNO12_S(rs.getString(70));
			i.setNO12_Co(rs.getString(71));
			i.setNO12_SiO2(rs.getString(72));
			i.setNO12_CaO(rs.getString(73));
			i.setNO12_MgO(rs.getString(74));
			i.setNO12_Al2O3(rs.getString(75));
			i.setNO13_Cu(rs.getString(76));
			i.setNO13_Fe(rs.getString(77));
			i.setNO13_S(rs.getString(78));
			i.setNO13_Co(rs.getString(79));
			i.setNO13_SiO2(rs.getString(80));
			i.setNO13_CaO(rs.getString(81));
			i.setNO13_MgO(rs.getString(82));
			i.setNO13_Al2O3(rs.getString(83));
			i.setNO14_Cu(rs.getString(84));
			i.setNO14_Fe(rs.getString(85));
			i.setNO14_S(rs.getString(86));
			i.setNO14_Co(rs.getString(87));
			i.setNO14_SiO2(rs.getString(88));
			i.setNO14_CaO(rs.getString(89));
			i.setNO14_MgO(rs.getString(90));
			i.setNO14_Al2O3(rs.getString(91));
			i.setNO15_Cu(rs.getString(92));
			i.setNO15_Fe(rs.getString(93));
			i.setNO15_S(rs.getString(94));
			i.setNO15_Co(rs.getString(95));
			i.setNO15_SiO2(rs.getString(96));
			i.setNO15_CaO(rs.getString(97));
			i.setNO15_MgO(rs.getString(98));
			i.setNO15_Al2O3(rs.getString(99));
			i.setNO1_name(rs.getString(100));
			i.setNO2_name(rs.getString(101));
			i.setNO3_name(rs.getString(102));
			i.setNO4_name(rs.getString(103));
			i.setNO8_name(rs.getString(104));
			i.setNO9_name(rs.getString(105));
			i.setNO10_name(rs.getString(106));
			i.setNO11_name(rs.getString(107));
			i.setNO12_name(rs.getString(108));
			i.setNO13_name(rs.getString(109));
			i.setNO14_name(rs.getString(110));
			i.setNO15_name(rs.getString(111));
			i.setCon_Cu(rs.getString(112));
			i.setCon_Fe(rs.getString(113));
			i.setCon_S(rs.getString(114));
			i.setCon_Co(rs.getString(115));
			i.setCon_SiO2(rs.getString(116));
			i.setCon_CaO(rs.getString(117));
			i.setCon_MgO(rs.getString(118));
			i.setCon_Al2O3(rs.getString(119));
			i.setCon_dosage(rs.getString(120));
			i.setIs_used(rs.getBoolean(121));
		}
		DBUtil.closeConnection();
		return i;
	}

	/**
	 * 查询配料成分表所有有记录的日期
	 * 
	 * @return List<String> 一个集合，含有所有有记录的日期
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<String> FindAllDate() throws SQLException {
		List<String> list = new ArrayList<String>();
		String sql = "select date from ingredient";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String s = new String(rs.getString(1));
			list.add(s);
		}
		DBUtil.closeConnection();
		return list;
	}

	/**
	 * 向配料成分表中插入一条记录
	 * 
	 * @param e
	 *            一个配料成分记录实体
	 * @return boolean 插入记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean InsertOne(Ingredient e) throws SQLException {
		String exe = "insert into ingredient ";
		String col = "(number,date,NO1_Cu,NO1_Fe,NO1_S,NO1_Co,NO1_SiO2,"
				+ "NO1_CaO,NO1_MgO,NO1_Al2O3,NO2_Cu,NO2_Fe,NO2_S,NO2_Co,"
				+ "NO2_SiO2,NO2_CaO,NO2_MgO,NO2_Al2O3,NO3_Cu,NO3_Fe,NO3_S,"
				+ "NO3_Co,NO3_SiO2,NO3_CaO,NO3_MgO,NO3_Al2O3,NO4_Cu,NO4_Fe,"
				+ "NO4_S,NO4_Co,NO4_SiO2,NO4_CaO,NO4_MgO,NO4_Al2O3,NO8_Cu,"
				+ "NO8_Fe,NO8_S,NO8_Co,NO8_SiO2,NO8_CaO,NO8_MgO,NO8_Al2O3,"
				+ "NO9_Cu,NO9_Fe,NO9_S,NO9_Co,NO9_SiO2,NO9_CaO,NO9_MgO,"
				+ "NO9_Al2O3,NO10_Cu,NO10_Fe,NO10_S,NO10_Co,NO10_SiO2,"
				+ "NO10_CaO,NO10_MgO,NO10_Al2O3,NO11_Cu,NO11_Fe,NO11_S,"
				+ "NO11_Co,NO11_SiO2,NO11_CaO,NO11_MgO,NO11_Al2O3,NO12_Cu,"
				+ "NO12_Fe,NO12_S,NO12_Co,NO12_SiO2,NO12_CaO,NO12_MgO,"
				+ "NO12_Al2O3,"
				+ "NO13_Cu,NO13_Fe,NO13_S,NO13_Co,NO13_SiO2,NO13_CaO,NO13_MgO,NO13_Al2O3,"
				+ "NO14_Cu,NO14_Fe,NO14_S,NO14_Co,NO14_SiO2,NO14_CaO,NO14_MgO,NO14_Al2O3,"
				+ "NO15_Cu,NO15_Fe,NO15_S,NO15_Co,NO15_SiO2,NO15_CaO,NO15_MgO,NO15_Al2O3,"
				+ "NO1_name,NO2_name,NO3_name,NO4_name,NO8_name,"
				+ "NO9_name,NO10_name,NO11_name,NO12_name,NO13_name,NO14_name,NO15_name,Con_Cu,Con_Fe,"
				+ "Con_S,Con_Co,Con_SiO2,Con_CaO,Con_MgO,Con_Al2O3,Con_dosage,is_used) ";
		String val = "values('" + e.getNumber() + "','" + e.getDate() + "','"
				+ e.getNO1_Cu() + "','" + e.getNO1_Fe() + "','" + e.getNO1_S()
				+ "','" + e.getNO1_Co() + "','" + e.getNO1_SiO2() + "','"
				+ e.getNO1_CaO() + "','" + e.getNO1_MgO() + "','"
				+ e.getNO1_Al2O3() + "','" + e.getNO2_Cu() + "','"
				+ e.getNO2_Fe() + "','" + e.getNO2_S() + "','" + e.getNO2_Co()
				+ "','" + e.getNO2_SiO2() + "','" + e.getNO2_CaO() + "','"
				+ e.getNO2_MgO() + "','" + e.getNO2_Al2O3() + "','"
				+ e.getNO3_Cu() + "','" + e.getNO3_Fe() + "','" + e.getNO3_S()
				+ "','" + e.getNO3_Co() + "','" + e.getNO3_SiO2() + "','"
				+ e.getNO3_CaO() + "','" + e.getNO3_MgO() + "','"
				+ e.getNO3_Al2O3() + "','" + e.getNO4_Cu() + "','"
				+ e.getNO4_Fe() + "','" + e.getNO4_S() + "','" + e.getNO4_Co()
				+ "','" + e.getNO4_SiO2() + "','" + e.getNO4_CaO() + "','"
				+ e.getNO4_MgO() + "','" + e.getNO4_Al2O3() + "','"
				+ e.getNO8_Cu() + "','" + e.getNO8_Fe() + "','" + e.getNO8_S()
				+ "','" + e.getNO8_Co() + "','" + e.getNO8_SiO2() + "','"
				+ e.getNO8_CaO() + "','" + e.getNO8_MgO() + "','"
				+ e.getNO8_Al2O3() + "','" + e.getNO9_Cu() + "','"
				+ e.getNO9_Fe() + "','" + e.getNO9_S() + "','" + e.getNO9_Co()
				+ "','" + e.getNO9_SiO2() + "','" + e.getNO9_CaO() + "','"
				+ e.getNO9_MgO() + "','" + e.getNO9_Al2O3() + "','"
				+ e.getNO10_Cu() + "','" + e.getNO10_Fe() + "','"
				+ e.getNO10_S() + "','" + e.getNO10_Co() + "','"
				+ e.getNO10_SiO2() + "','" + e.getNO10_CaO() + "','"
				+ e.getNO10_MgO() + "','" + e.getNO10_Al2O3() + "','"
				+ e.getNO11_Cu() + "','" + e.getNO11_Fe() + "','"
				+ e.getNO11_S() + "','" + e.getNO11_Co() + "','"
				+ e.getNO11_SiO2() + "','" + e.getNO11_CaO() + "','"
				+ e.getNO11_MgO() + "','" + e.getNO11_Al2O3() + "','"
				+ e.getNO12_Cu() + "','" + e.getNO12_Fe() + "','"
				+ e.getNO12_S() + "','" + e.getNO12_Co() + "','"
				+ e.getNO12_SiO2() + "','" + e.getNO12_CaO() + "','"
				+ e.getNO12_MgO() + "','" + e.getNO12_Al2O3() + "','"
				+ e.getNO13_Cu() + "','" + e.getNO13_Fe() + "','"
				+ e.getNO13_S() + "','" + e.getNO13_Co() + "','"
				+ e.getNO13_SiO2() + "','" + e.getNO13_CaO() + "','"
				+ e.getNO13_MgO() + "','" + e.getNO13_Al2O3() + "','"
				+ e.getNO14_Cu() + "','" + e.getNO14_Fe() + "','"
				+ e.getNO14_S() + "','" + e.getNO14_Co() + "','"
				+ e.getNO14_SiO2() + "','" + e.getNO14_CaO() + "','"
				+ e.getNO14_MgO() + "','" + e.getNO14_Al2O3() + "','"
				+ e.getNO15_Cu() + "','" + e.getNO15_Fe() + "','"
				+ e.getNO15_S() + "','" + e.getNO15_Co() + "','"
				+ e.getNO15_SiO2() + "','" + e.getNO15_CaO() + "','"
				+ e.getNO15_MgO() + "','" + e.getNO15_Al2O3() + "','"
				+ e.getNO1_name() + "','" + e.getNO2_name() + "','"
				+ e.getNO3_name() + "','" + e.getNO4_name() + "','"
				+ e.getNO8_name() + "','" + e.getNO9_name() + "','"
				+ e.getNO10_name() + "','" + e.getNO11_name() + "','"
				+ e.getNO12_name() + "','" + e.getNO13_name() + "','"
				+ e.getNO14_name() + "','" + e.getNO15_name() + "','"
				+ e.getCon_Cu() + "','"
				+ e.getCon_Fe() + "','" + e.getCon_S() + "','" + e.getCon_Co()
				+ "','" + e.getCon_SiO2() + "','" + e.getCon_CaO() + "','"
				+ e.getCon_MgO() + "','" + e.getCon_Al2O3() + "','"
				+ e.getCon_dosage() + "','"+(e.isIs_used()?"1":"0")+"')";
		String sql = exe + col + val;
		System.out.println(sql);
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		DBUtil.closeConnection();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在配料成分表中修改一条记录
	 * 
	 * @param e
	 *            一个配料成分记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOne(Ingredient e) throws SQLException {
		String exe = "update ingredient set ";
		String col = "date='" + e.getDate() + "',NO1_Cu='" + e.getNO1_Cu()
				+ "',NO1_Fe='" + e.getNO1_Fe() + "',NO1_S='" + e.getNO1_S()
				+ "',NO1_Co='" + e.getNO1_Co() + "',NO1_SiO2='"
				+ e.getNO1_SiO2() + "',NO1_CaO='" + e.getNO1_CaO()
				+ "',NO1_MgO='" + e.getNO1_MgO() + "',NO1_Al2O3='"
				+ e.getNO1_Al2O3() + "',NO2_Cu='" + e.getNO2_Cu()
				+ "',NO2_Fe='" + e.getNO2_Fe() + "',NO2_S='" + e.getNO2_S()
				+ "',NO2_Co='" + e.getNO2_Co() + "',NO2_SiO2='"
				+ e.getNO2_SiO2() + "',NO2_CaO='" + e.getNO2_CaO()
				+ "',NO2_MgO='" + e.getNO2_MgO() + "',NO2_Al2O3='"
				+ e.getNO2_Al2O3() + "',NO3_Cu='" + e.getNO3_Cu()
				+ "',NO3_Fe='" + e.getNO3_Fe() + "',NO3_S='" + e.getNO3_S()
				+ "',NO3_Co='" + e.getNO3_Co() + "',NO3_SiO2='"
				+ e.getNO3_SiO2() + "',NO3_CaO='" + e.getNO3_CaO()
				+ "',NO3_MgO='" + e.getNO3_MgO() + "',NO3_Al2O3='"
				+ e.getNO3_Al2O3() + "',NO4_Cu='" + e.getNO4_Cu()
				+ "',NO4_Fe='" + e.getNO4_Fe() + "',NO4_S='" + e.getNO4_S()
				+ "',NO4_Co='" + e.getNO4_Co() + "',NO4_SiO2='"
				+ e.getNO4_SiO2() + "',NO4_CaO='" + e.getNO4_CaO()
				+ "',NO4_MgO='" + e.getNO4_MgO() + "',NO4_Al2O3='"
				+ e.getNO4_Al2O3() + "',NO8_Cu='" + e.getNO8_Cu()
				+ "',NO8_Fe='" + e.getNO8_Fe() + "',NO8_S='" + e.getNO8_S()
				+ "',NO8_Co='" + e.getNO8_Co() + "',NO8_SiO2='"
				+ e.getNO8_SiO2() + "',NO8_CaO='" + e.getNO8_CaO()
				+ "',NO8_MgO='" + e.getNO8_MgO() + "',NO8_Al2O3='"
				+ e.getNO8_Al2O3() + "',NO9_Cu='" + e.getNO9_Cu()
				+ "',NO9_Fe='" + e.getNO9_Fe() + "',NO9_S='" + e.getNO9_S()
				+ "',NO9_Co='" + e.getNO9_Co() + "',NO9_SiO2='"
				+ e.getNO9_SiO2() + "',NO9_CaO='" + e.getNO9_CaO()
				+ "',NO9_MgO='" + e.getNO9_MgO() + "',NO9_Al2O3='"
				+ e.getNO9_Al2O3() + "',NO10_Cu='" + e.getNO10_Cu()
				+ "',NO10_Fe='" + e.getNO10_Fe() + "',NO10_S='" + e.getNO10_S()
				+ "',NO10_Co='" + e.getNO10_Co() + "',NO10_SiO2='"
				+ e.getNO10_SiO2() + "',NO10_CaO='" + e.getNO10_CaO()
				+ "',NO10_MgO='" + e.getNO10_MgO() + "',NO10_Al2O3='"
				+ e.getNO10_Al2O3() + "',NO11_Cu='" + e.getNO11_Cu()
				+ "',NO11_Fe='" + e.getNO11_Fe() + "',NO11_S='" + e.getNO11_S()
				+ "',NO11_Co='" + e.getNO11_Co() + "',NO11_SiO2='"
				+ e.getNO11_SiO2() + "',NO11_CaO='" + e.getNO11_CaO()
				+ "',NO11_MgO='" + e.getNO11_MgO() + "',NO11_Al2O3='"
				+ e.getNO11_Al2O3() + "',NO12_Cu='" + e.getNO12_Cu()
				+ "',NO12_Fe='" + e.getNO12_Fe() + "',NO12_S='" + e.getNO12_S()
				+ "',NO12_Co='" + e.getNO12_Co() + "',NO12_SiO2='"
				+ e.getNO12_SiO2() + "',NO12_CaO='" + e.getNO12_CaO()
				+ "',NO12_MgO='" + e.getNO12_MgO() + "',NO12_Al2O3='"
				+ e.getNO12_Al2O3() 
				+ "',NO13_Cu='" + e.getNO13_Cu() + "',NO13_Fe='" + e.getNO13_Fe() + "',NO13_S='" + e.getNO13_S() + "',NO13_Co='" + e.getNO13_Co() 
				+ "',NO13_SiO2='"+ e.getNO13_SiO2() + "',NO13_CaO='" + e.getNO13_CaO()	+ "',NO13_MgO='" + e.getNO13_MgO() + "',NO13_Al2O3='"+ e.getNO13_Al2O3()
				+ "',NO14_Cu='" + e.getNO14_Cu() + "',NO14_Fe='" + e.getNO14_Fe() + "',NO14_S='" + e.getNO14_S() + "',NO14_Co='" + e.getNO14_Co()
				+ "',NO14_SiO2='"+ e.getNO14_SiO2() + "',NO14_CaO='" + e.getNO14_CaO()	+ "',NO14_MgO='" + e.getNO14_MgO() + "',NO14_Al2O3='"+ e.getNO14_Al2O3()
				+ "',NO15_Cu='" + e.getNO15_Cu() + "',NO15_Fe='" + e.getNO15_Fe() + "',NO15_S='" + e.getNO15_S() + "',NO15_Co='" + e.getNO15_Co()
				+ "',NO15_SiO2='"+ e.getNO15_SiO2() + "',NO15_CaO='" + e.getNO15_CaO()	+ "',NO15_MgO='" + e.getNO15_MgO() + "',NO15_Al2O3='"+ e.getNO15_Al2O3()
				+ "',NO1_name='" + e.getNO1_name()
				+ "',NO2_name='" + e.getNO2_name() + "',NO3_name='"
				+ e.getNO3_name() + "',NO4_name='" + e.getNO4_name()
				+ "',NO8_name='" + e.getNO8_name() + "',NO9_name='"
				+ e.getNO9_name() + "',NO10_name='" + e.getNO10_name()
				+ "',NO11_name='" + e.getNO11_name() + "',NO12_name='"
				+ e.getNO12_name()
				+ "',NO13_name='" + e.getNO13_name()
				+ "',NO14_name='" + e.getNO14_name()
				+ "',NO15_name='" + e.getNO15_name()
				+ "',Con_Cu='" + e.getCon_Cu()
				+ "',Con_Fe='" + e.getCon_Fe() + "',Con_S='" + e.getCon_S()
				+ "',Con_Co='" + e.getCon_Co() + "',Con_SiO2='"
				+ e.getCon_SiO2() + "',Con_CaO='" + e.getCon_CaO()
				+ "',Con_MgO='" + e.getCon_MgO() + "',Con_Al2O3='"
				+ e.getCon_Al2O3() + "',Con_dosage='" + e.getCon_dosage() + "',is_used='" + (e.isIs_used()?"1":"0") + "'";
		String cond = " where number='" + e.getNumber() + "'";
		String sql = exe + col + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		DBUtil.closeConnection();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在配料成分表中删除一条记录
	 * 
	 * @param number
	 *            一个配料成分实体的编号
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteOne(String number) throws SQLException {
		String exe = "delete from ingredient ";
		String cond = "where number='" + number + "'";
		String sql = exe + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		DBUtil.closeConnection();
		if (result > 0)
			return true;
		else
			return false;
	}
}
