package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Summary;
import com.ccs.util.DBUtil;

/*
 * 配料总表数据库操作对象。 可进行增删改查。4月23日完成。
 * 
 * 4月25日添加按number查询dosage方法。
 * 
 * 4月26日添加按number查询一条记录方法。
 * 
 * 2017年2月14日，根据数据库的变动修改操作逻辑(增加了11,12号仓)
 * 
 */
public class SummaryDAO {
	/**
	 * 查询配料总表中的所有记录
	 * 
	 * @return List<Summary> 一个包含summary表全部记录的集合
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Summary> FindAll() throws SQLException {
		List<Summary> list = new ArrayList<Summary>();
		boolean noresult = true;// 查询无结果，置为true
		String sql = "select * from summary";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			noresult = false;
			Summary s = new Summary();
			s.setId(rs.getInt(1));
			s.setNumber(rs.getString(2));
			s.setDate(rs.getString(3));
			s.setHouse1(rs.getString(4));
			s.setHouse2(rs.getString(5));
			s.setHouse3(rs.getString(6));
			s.setHouse4(rs.getString(7));
			s.setHouse5(rs.getString(8));
			s.setHouse6(rs.getString(9));
			s.setHouse7(rs.getString(10));
			s.setHouse8(rs.getString(11));
			s.setHouse9(rs.getString(12));
			s.setHouse10(rs.getString(13));
			s.setDosage1(rs.getString(14));
			s.setDosage2(rs.getString(15));
			s.setDosage3(rs.getString(16));
			s.setDosage4(rs.getString(17));
			s.setDosage5(rs.getString(18));
			s.setDosage6(rs.getString(19));
			s.setDosage7(rs.getString(20));
			s.setDosage8(rs.getString(21));
			s.setDosage9(rs.getString(22));
			s.setDosage10(rs.getString(23));
			s.setDosage11(rs.getString(24));
			s.setDosage12(rs.getString(25));
			s.setOxyconc(rs.getString(26));
			s.setDigifax(rs.getString(27));
			s.setFuelratio(rs.getString(28));
			s.setAirvolume(rs.getString(29));
			s.setSup_SiO2(rs.getString(30));
			s.setReal_Matte(rs.getString(31));
			s.setReal_Fe3O4(rs.getString(32));
			s.setReal_SiO2Fe(rs.getString(33));
			s.setReal_SiO2CaO(rs.getString(34));
			s.setSup_CaO(rs.getString(35));
			s.setPre_oxyconc(rs.getString(36));
			s.setPre_digifax(rs.getString(37));
			s.setPre_fuelratio(rs.getString(38));
			s.setPre_airvolume(rs.getString(39));
			s.setPre_sup_SiO2(rs.getString(40));
			s.setPre_real_matte(rs.getString(41));
			s.setPre_real_Fe3O4(rs.getString(42));
			s.setPre_real_SiO2Fe(rs.getString(43));
			s.setPre_real_SiO2CaO(rs.getString(44));
			s.setPre_sup_CaO(rs.getString(45));
			list.add(s);
		}
		if (noresult)
			list = null;
		return list;
	}

	/**
	 * 查询配料总表中的最后一条记录
	 * 
	 * @return Summary summary表的最后一条记录
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public Summary FindLastOne() throws SQLException {
		Summary s = null;
		String sql = "select * from summary order by number desc";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			s = new Summary();
			s.setId(rs.getInt(1));
			s.setNumber(rs.getString(2));
			s.setDate(rs.getString(3));
			s.setHouse1(rs.getString(4));
			s.setHouse2(rs.getString(5));
			s.setHouse3(rs.getString(6));
			s.setHouse4(rs.getString(7));
			s.setHouse5(rs.getString(8));
			s.setHouse6(rs.getString(9));
			s.setHouse7(rs.getString(10));
			s.setHouse8(rs.getString(11));
			s.setHouse9(rs.getString(12));
			s.setHouse10(rs.getString(13));
			s.setDosage1(rs.getString(14));
			s.setDosage2(rs.getString(15));
			s.setDosage3(rs.getString(16));
			s.setDosage4(rs.getString(17));
			s.setDosage5(rs.getString(18));
			s.setDosage6(rs.getString(19));
			s.setDosage7(rs.getString(20));
			s.setDosage8(rs.getString(21));
			s.setDosage9(rs.getString(22));
			s.setDosage10(rs.getString(23));
			s.setDosage11(rs.getString(24));
			s.setDosage12(rs.getString(25));
			s.setOxyconc(rs.getString(26));
			s.setDigifax(rs.getString(27));
			s.setFuelratio(rs.getString(28));
			s.setAirvolume(rs.getString(29));
			s.setSup_SiO2(rs.getString(30));
			s.setReal_Matte(rs.getString(31));
			s.setReal_Fe3O4(rs.getString(32));
			s.setReal_SiO2Fe(rs.getString(33));
			s.setReal_SiO2CaO(rs.getString(34));
			s.setSup_CaO(rs.getString(35));
			s.setPre_oxyconc(rs.getString(36));
			s.setPre_digifax(rs.getString(37));
			s.setPre_fuelratio(rs.getString(38));
			s.setPre_airvolume(rs.getString(39));
			s.setPre_sup_SiO2(rs.getString(40));
			s.setPre_real_matte(rs.getString(41));
			s.setPre_real_Fe3O4(rs.getString(42));
			s.setPre_real_SiO2Fe(rs.getString(43));
			s.setPre_real_SiO2CaO(rs.getString(44));
			s.setPre_sup_CaO(rs.getString(45));
		}
		return s;
	}

	/**
	 * 按订单号查询配料总表中对应订单的记录
	 * 
	 * @return Summary 一个包含指定单号所对应的记录
	 * @param num
	 *            要查找的单号
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public Summary FindOneByNum(String num) throws SQLException {
		Summary s = null;
		String sql = "select * from summary where number='" + num + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			s = new Summary();
			s.setId(rs.getInt(1));
			s.setNumber(rs.getString(2));
			s.setDate(rs.getString(3));
			s.setHouse1(rs.getString(4));
			s.setHouse2(rs.getString(5));
			s.setHouse3(rs.getString(6));
			s.setHouse4(rs.getString(7));
			s.setHouse5(rs.getString(8));
			s.setHouse6(rs.getString(9));
			s.setHouse7(rs.getString(10));
			s.setHouse8(rs.getString(11));
			s.setHouse9(rs.getString(12));
			s.setHouse10(rs.getString(13));
			s.setDosage1(rs.getString(14));
			s.setDosage2(rs.getString(15));
			s.setDosage3(rs.getString(16));
			s.setDosage4(rs.getString(17));
			s.setDosage5(rs.getString(18));
			s.setDosage6(rs.getString(19));
			s.setDosage7(rs.getString(20));
			s.setDosage8(rs.getString(21));
			s.setDosage9(rs.getString(22));
			s.setDosage10(rs.getString(23));
			s.setDosage11(rs.getString(24));
			s.setDosage12(rs.getString(25));
			s.setOxyconc(rs.getString(26));
			s.setDigifax(rs.getString(27));
			s.setFuelratio(rs.getString(28));
			s.setAirvolume(rs.getString(29));
			s.setSup_SiO2(rs.getString(30));
			s.setReal_Matte(rs.getString(31));
			s.setReal_Fe3O4(rs.getString(32));
			s.setReal_SiO2Fe(rs.getString(33));
			s.setReal_SiO2CaO(rs.getString(34));
			s.setSup_CaO(rs.getString(35));
			s.setPre_oxyconc(rs.getString(36));
			s.setPre_digifax(rs.getString(37));
			s.setPre_fuelratio(rs.getString(38));
			s.setPre_airvolume(rs.getString(39));
			s.setPre_sup_SiO2(rs.getString(40));
			s.setPre_real_matte(rs.getString(41));
			s.setPre_real_Fe3O4(rs.getString(42));
			s.setPre_real_SiO2Fe(rs.getString(43));
			s.setPre_real_SiO2CaO(rs.getString(44));
			s.setPre_sup_CaO(rs.getString(45));
		}
		return s;
	}

	/**
	 * 按订单号查询配料总表中对应订单的矿石用量
	 * 
	 * @return List<Double> 一个包含指定单号所有矿石用量的集合
	 * @param num
	 *            要查找的单号
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<String> FindDosageByNum(String num) throws SQLException {
		List<String> list = null;
		String sql = "select dosage1,dosage2,dosage3,dosage4,dosage5,"
				+ "dosage6,dosage7,dosage8,dosage9,dosage10,dosage11,"
				+ "dosage12 " + "from summary where number='" + num + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			list = new ArrayList<String>();
			for (int i = 1; i <= 12; i++) {
				list.add(rs.getString(i));
			}
		}
		return list;
	}

	/**
	 * 在配料总表中插入一条记录
	 * 
	 * @param s
	 *            一个配料总表记录实体
	 * @return boolean 插入记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean InsertOne(Summary s) throws SQLException {
		String exe = "insert into summary ";
		String col = "(number,date,house1,house2,house3,house4,house5,house6,"
				+ "house7,house8,house9,house10,dosage1,dosage2,dosage3,dosage4,"
				+ "dosage5,dosage6,dosage7,dosage8,dosage9,dosage10,dosage11,"
				+ "dosage12,oxyconc,digifax,fuelratio,airvolume,sup_SiO2,"
				+ "real_Matte,real_Fe3O4,real_SiO2Fe,real_SiO2CaO,sup_CaO,"
				+ "pre_oxyconc,pre_digifax,pre_fuelratio,pre_airvolume,"
				+ "pre_sup_SiO2,pre_real_matte,pre_real_Fe3O4,pre_real_SiO2Fe,"
				+ "pre_real_SiO2CaO,pre_sup_CaO) ";
		String val = "values('" + s.getNumber() + "','" + s.getDate() + "','"
				+ s.getHouse1() + "','" + s.getHouse2() + "','" + s.getHouse3()
				+ "','" + s.getHouse4() + "','" + s.getHouse5() + "','"
				+ s.getHouse6() + "','" + s.getHouse7() + "','" + s.getHouse8()
				+ "','" + s.getHouse9() + "','" + s.getHouse10() + "','"
				+ s.getDosage1() + "','" + s.getDosage2() + "','"
				+ s.getDosage3() + "','" + s.getDosage4() + "','"
				+ s.getDosage5() + "','" + s.getDosage6() + "','"
				+ s.getDosage7() + "','" + s.getDosage8() + "','"
				+ s.getDosage9() + "','" + s.getDosage10() + "','"
				+ s.getDosage11() + "','" + s.getDosage12() + "','"
				+ s.getOxyconc() + "','" + s.getDigifax() + "','"
				+ s.getFuelratio() + "','" + s.getAirvolume() + "','"
				+ s.getSup_SiO2() + "','" + s.getReal_Matte() + "','"
				+ s.getReal_Fe3O4() + "','" + s.getReal_SiO2Fe() + "','"
				+ s.getReal_SiO2CaO() + "','" + s.getSup_CaO() + "','"
				+ s.getPre_oxyconc() + "','" + s.getPre_digifax() + "','"
				+ s.getPre_fuelratio() + "','" + s.getPre_airvolume() + "','"
				+ s.getPre_sup_SiO2() + "','" + s.getPre_real_matte() + "','"
				+ s.getPre_real_Fe3O4() + "','" + s.getPre_real_SiO2Fe()
				+ "','" + s.getPre_real_SiO2CaO() + "','" + s.getPre_sup_CaO()
				+ "')";
		String sql = exe + col + val;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在配料总表中修改一条记录
	 * 
	 * @param s
	 *            一个配料总表记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOne(Summary s) throws SQLException {
		String exe = "update summary set ";
		String col = "date='" + s.getDate() + "',house1='" + s.getHouse1()
				+ "',house2='" + s.getHouse2() + "',house3='" + s.getHouse3()
				+ "',house4='" + s.getHouse4() + "',house5='" + s.getHouse5()
				+ "',house6='" + s.getHouse6() + "',house7='" + s.getHouse7()
				+ "',house8='" + s.getHouse8() + "',house9='" + s.getHouse9()
				+ "',house10='" + s.getHouse10() + "',dosage1='"
				+ s.getDosage1() + "',dosage2='" + s.getDosage2()
				+ "',dosage3='" + s.getDosage3() + "',dosage4='"
				+ s.getDosage4() + "',dosage5='" + s.getDosage5()
				+ "',dosage6='" + s.getDosage6() + "',dosage7='"
				+ s.getDosage7() + "',dosage8='" + s.getDosage8()
				+ "',dosage9='" + s.getDosage9() + "',dosage10='"
				+ s.getDosage10() + "',dosage11='" + s.getDosage11()
				+ "',dosage12='" + s.getDosage12() + "',oxyconc='"
				+ s.getOxyconc() + "',digifax='" + s.getDigifax()
				+ "',fuelratio='" + s.getFuelratio() + "',airvolume='"
				+ s.getAirvolume() + "',sup_SiO2='" + s.getSup_SiO2()
				+ "',real_Matte='" + s.getReal_Matte() + "',real_Fe3O4='"
				+ s.getReal_Fe3O4() + "',real_SiO2Fe='" + s.getReal_SiO2Fe()
				+ "',real_SiO2CaO='" + s.getReal_SiO2CaO() + "',sup_CaO='"
				+ s.getSup_CaO() + "',pre_oxyconc='" + s.getPre_oxyconc()
				+ "',pre_digifax='" + s.getPre_digifax() + "',pre_fuelratio='"
				+ s.getPre_fuelratio() + "',pre_airvolume='"
				+ s.getPre_airvolume() + "',pre_sup_SiO2='"
				+ s.getPre_sup_SiO2() + "',pre_real_matte='"
				+ s.getPre_real_matte() + "',pre_real_Fe3O4='"
				+ s.getPre_real_Fe3O4() + "',pre_real_SiO2Fe='"
				+ s.getPre_real_SiO2Fe() + "',pre_real_SiO2CaO='"
				+ s.getPre_real_SiO2CaO() + "',pre_sup_CaO='"
				+ s.getPre_sup_CaO() + "'";
		String cond = " where number='" + s.getNumber() + "'";
		String sql = exe + col + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * (7.11修改)在配料总表中修改下一条记录的“换料前”数据表，使用本条记录的“换料后”记录
	 * 
	 * (7.16修改)在修改“换料前”记录时仅影响三项数据
	 * 
	 * @param s
	 *            一个配料总表记录实体
	 * @param nextid
	 *            下一个单号对应的id
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdatePreData(Summary s, int nextid) throws SQLException {
		String exe = "update summary set ";
		String col = "pre_oxyconc='" + s.getOxyconc() + "',pre_digifax='"
				+ s.getDigifax() + "',pre_fuelratio='" + s.getFuelratio() + "'";
		String cond = " where id=" + nextid;
		String sql = exe + col + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在配料总表中删除一条记录
	 * 
	 * @param number
	 *            一个配料总表记录实体的单号名称
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteOne(String number) throws SQLException {
		String exe = "delete from summary ";
		String cond = "where number='" + number + "'";
		String sql = exe + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}
}
