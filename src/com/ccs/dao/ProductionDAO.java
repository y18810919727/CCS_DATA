package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Production;
import com.ccs.entity.Summary;
import com.ccs.util.DBUtil;

/*
 * 生产记录表数据库操作对象。 可进行增删改查。4月23日完成。
 * 
 * 6月11日添加：更新target、按单号删除记录
 * 
 * 2016年8月5日添加：查询生产记录时新增字段grade
 * 
 * 2016年9月4日添加：查询、添加、修改生产记录时新增字段oxypur和oxyconc
 * 
 * 2017年2月14日，根据数据库的变动修改操作逻辑(增加了11,12号仓)
 * 
 */
public class ProductionDAO {
	/**
	 * 查询生产记录表中的所有记录
	 * 
	 * @return List<Production> 一个包含production表全部记录的集合
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Production> FindAll() throws SQLException {
		List<Production> list = new ArrayList<Production>();
		String sql = "select * from production ";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Production p = new Production();
			p.setId(rs.getInt(1));
			p.setNumber(rs.getString(2));
			p.setDate(rs.getString(3));
			p.setProduceNo(rs.getString(4));
			p.setDuty(rs.getString(5));
			p.setSampleNo(rs.getString(6));
			p.setTargetMatte(rs.getString(7));
			p.setFactMatte(rs.getString(8));
			p.setTargetMagIron(rs.getString(9));
			p.setFactMagIron(rs.getString(10));
			p.setTargetSiO2Fe(rs.getString(11));
			p.setFactSiO2Fe(rs.getString(12));
			p.setTargetSiO2CaO(rs.getString(13));
			p.setFactSiO2CaO(rs.getString(14));
			p.setMagnetic_force(rs.getString(15));
			p.setDrum_hole(rs.getString(16));
			p.setColor(rs.getString(17));
			p.setNozzle_pressure(rs.getString(18));
			p.setFuel_ratio(rs.getString(19));
			p.setAmountPerHour(rs.getString(20));
			p.setTime(rs.getString(21));
			p.setAir_volume(rs.getString(22));
			p.setH1used(rs.getString(23));
			p.setH2used(rs.getString(24));
			p.setH3used(rs.getString(25));
			p.setH4used(rs.getString(26));
			p.setH5used(rs.getString(27));
			p.setH6used(rs.getString(28));
			p.setH7used(rs.getString(29));
			p.setH8used(rs.getString(30));
			p.setH9used(rs.getString(31));
			p.setH10used(rs.getString(32));
			p.setH11used(rs.getString(33));
			p.setH12used(rs.getString(34));
			p.setCreatedate(rs.getString(35));
			p.setGrade(rs.getString(36));
			p.setOxypur(rs.getString(37));
			p.setOxyconc(rs.getString(38));
			list.add(p);
		}
		return list;
	}

	/**
	 * 按照日期查询生产记录表中的相应所有记录
	 * 
	 * @return List<Production> 一个包含production表全部相应记录的集合
	 * @throws SQLException
	 * @author YePengfei & GaoYuxing
	 * 
	 * */
	public List<Production> FindAllByDate(String key) throws SQLException {
		List<Production> list = new ArrayList<Production>();
		String sql = "select * from production where date='" + key + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Production p = new Production();
			p.setId(rs.getInt(1));
			p.setNumber(rs.getString(2));
			p.setDate(rs.getString(3));
			p.setProduceNo(rs.getString(4));
			p.setDuty(rs.getString(5));
			p.setSampleNo(rs.getString(6));
			p.setTargetMatte(rs.getString(7));
			p.setFactMatte(rs.getString(8));
			p.setTargetMagIron(rs.getString(9));
			p.setFactMagIron(rs.getString(10));
			p.setTargetSiO2Fe(rs.getString(11));
			p.setFactSiO2Fe(rs.getString(12));
			p.setTargetSiO2CaO(rs.getString(13));
			p.setFactSiO2CaO(rs.getString(14));
			p.setMagnetic_force(rs.getString(15));
			p.setDrum_hole(rs.getString(16));
			p.setColor(rs.getString(17));
			p.setNozzle_pressure(rs.getString(18));
			p.setFuel_ratio(rs.getString(19));
			p.setAmountPerHour(rs.getString(20));
			p.setTime(rs.getString(21));
			p.setAir_volume(rs.getString(22));
			p.setH1used(rs.getString(23));
			p.setH2used(rs.getString(24));
			p.setH3used(rs.getString(25));
			p.setH4used(rs.getString(26));
			p.setH5used(rs.getString(27));
			p.setH6used(rs.getString(28));
			p.setH7used(rs.getString(29));
			p.setH8used(rs.getString(30));
			p.setH9used(rs.getString(31));
			p.setH10used(rs.getString(32));
			p.setH11used(rs.getString(33));
			p.setH12used(rs.getString(34));
			p.setCreatedate(rs.getString(35));
			p.setGrade(rs.getString(36));
			p.setOxypur(rs.getString(37));
			p.setOxyconc(rs.getString(38));
			list.add(p);
		}
		return list;
	}

	/**
	 * 按照单号查询生产记录表中的相应所有记录
	 * 
	 * @return List<Production> 一个包含production表全部相应记录的集合
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Production> FindAllByNumber(String number, String date)
			throws SQLException {
		List<Production> list = new ArrayList<Production>();
		String sql = "select * from production where number='" + number
				+ "'and date='" + date + "'";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Production p = new Production();
			p.setId(rs.getInt(1));
			p.setNumber(rs.getString(2));
			p.setDate(rs.getString(3));
			p.setProduceNo(rs.getString(4));
			p.setDuty(rs.getString(5));
			p.setSampleNo(rs.getString(6));
			p.setTargetMatte(rs.getString(7));
			p.setFactMatte(rs.getString(8));
			p.setTargetMagIron(rs.getString(9));
			p.setFactMagIron(rs.getString(10));
			p.setTargetSiO2Fe(rs.getString(11));
			p.setFactSiO2Fe(rs.getString(12));
			p.setTargetSiO2CaO(rs.getString(13));
			p.setFactSiO2CaO(rs.getString(14));
			p.setMagnetic_force(rs.getString(15));
			p.setDrum_hole(rs.getString(16));
			p.setColor(rs.getString(17));
			p.setNozzle_pressure(rs.getString(18));
			p.setFuel_ratio(rs.getString(19));
			p.setAmountPerHour(rs.getString(20));
			p.setTime(rs.getString(21));
			p.setAir_volume(rs.getString(22));
			p.setH1used(rs.getString(23));
			p.setH2used(rs.getString(24));
			p.setH3used(rs.getString(25));
			p.setH4used(rs.getString(26));
			p.setH5used(rs.getString(27));
			p.setH6used(rs.getString(28));
			p.setH7used(rs.getString(29));
			p.setH8used(rs.getString(30));
			p.setH9used(rs.getString(31));
			p.setH10used(rs.getString(32));
			p.setH11used(rs.getString(33));
			p.setH12used(rs.getString(34));
			p.setCreatedate(rs.getString(35));
			p.setGrade(rs.getString(36));
			p.setOxypur(rs.getString(37));
			p.setOxyconc(rs.getString(38));
			list.add(p);
		}
		return list;
	}

	/**
	 * 向生产记录表中添加一条记录 (2016.08.06)增加熔炼状况评分 (2016.09.04)增加氧气纯度和富氧浓度
	 * (2017.02.14)增加11,12号仓
	 * 
	 * @param p
	 *            一条生产记录实体
	 * @return boolean 添加记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean InsertOne(Production p) throws SQLException {
		String exe = "insert into production ";
		String col = "(number,date,produceNo,duty,sampleNo,targetMatte,factMatte,"
				+ "targetMagIron,factMagIron,targetSiO2Fe,factSiO2Fe,targetSiO2CaO,"
				+ "factSiO2CaO,magnetic_force,drum_hole,color,nozzle_pressure,"
				+ "fuel_ratio,amountPerHour,time,air_volume,h1used,h2used,h3used,"
				+ "h4used,h5used,h6used,h7used,h8used,h9used,h10used,h11used,"
				+ "h12used,createdate,grade,oxypur,oxyconc) ";
		String val = "values('" + p.getNumber() + "','" + p.getDate() + "','"
				+ p.getProduceNo() + "','" + p.getDuty() + "','"
				+ p.getSampleNo() + "','" + p.getTargetMatte() + "','"
				+ p.getFactMatte() + "','" + p.getTargetMagIron() + "','"
				+ p.getFactMagIron() + "','" + p.getTargetSiO2Fe() + "','"
				+ p.getFactSiO2Fe() + "','" + p.getTargetSiO2CaO() + "','"
				+ p.getFactSiO2CaO() + "','" + p.getMagnetic_force() + "','"
				+ p.getDrum_hole() + "','" + p.getColor() + "','"
				+ p.getNozzle_pressure() + "','" + p.getFuel_ratio() + "','"
				+ p.getAmountPerHour() + "','" + p.getTime() + "','"
				+ p.getAir_volume() + "','" + p.getH1used() + "','"
				+ p.getH2used() + "','" + p.getH3used() + "','" + p.getH4used()
				+ "','" + p.getH5used() + "','" + p.getH6used() + "','"
				+ p.getH7used() + "','" + p.getH8used() + "','" + p.getH9used()
				+ "','" + p.getH10used() + "','" + p.getH11used() + "','"
				+ p.getH12used() + "','" + p.getCreatedate() + "','"
				+ p.getGrade() + "','" + p.getOxypur() + "','" + p.getOxyconc()
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
	 * 在生产记录表中修改一条记录 (2016.08.06)修复bug：现在修改记录将同时判定样号与单号
	 * 
	 * @param p
	 *            一条生产记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOne(Production p) throws SQLException {
		String exe = "update production set ";
		String col = "number='" + p.getNumber() + "',date='" + p.getDate()
				+ "',produceNo='" + p.getProduceNo() + "',duty='" + p.getDuty()
				+ "',sampleNo='" + p.getSampleNo() + "',targetMatte='"
				+ p.getTargetMatte() + "',factMatte='" + p.getFactMatte()
				+ "',targetMagIron='" + p.getTargetMagIron()
				+ "',factMagIron='" + p.getFactMagIron() + "',targetSiO2Fe='"
				+ p.getTargetSiO2Fe() + "',factSiO2Fe='" + p.getFactSiO2Fe()
				+ "',targetSiO2CaO='" + p.getTargetSiO2CaO()
				+ "',factSiO2CaO='" + p.getFactSiO2CaO() + "',magnetic_force='"
				+ p.getMagnetic_force() + "',drum_hole='" + p.getDrum_hole()
				+ "',color='" + p.getColor() + "',nozzle_pressure='"
				+ p.getNozzle_pressure() + "',fuel_ratio='" + p.getFuel_ratio()
				+ "',amountPerHour='" + p.getAmountPerHour() + "',time='"
				+ p.getTime() + "',air_volume='" + p.getAir_volume()
				+ "',h1used='" + p.getH1used() + "',h2used='" + p.getH2used()
				+ "',h3used='" + p.getH3used() + "',h4used='" + p.getH4used()
				+ "',h5used='" + p.getH5used() + "',h6used='" + p.getH6used()
				+ "',h7used='" + p.getH7used() + "',h8used='" + p.getH8used()
				+ "',h9used='" + p.getH9used() + "',h10used='" + p.getH10used()
				+ "',h11used='" + p.getH11used() + "',h12used='"
				+ p.getH12used() + "',grade='" + p.getGrade() + "',oxypur='"
				+ p.getOxypur() + "',oxyconc='" + p.getOxyconc() + "'";
		String cond = " where sampleNo='" + p.getSampleNo() + "' and number='"
				+ p.getNumber() + "'";
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
	 * (2016.08.06)在生产记录表中修改一条记录的grade字段
	 * 
	 * @param p
	 *            一条生产记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOnlyGrade(Production p) throws SQLException {
		String exe = "update production set ";
		String col = "grade='" + p.getGrade() + "'";
		String cond = " where number='" + p.getNumber() + "' and sampleNo='"
				+ p.getSampleNo() + "'";
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
	 * 在生产记录表中修改某一单号下的所有目标值
	 * 
	 * @param p
	 *            一条生产记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateTargetByNum(Production p) throws SQLException {
		String exe = "update production set ";
		String col = "targetMatte='" + p.getTargetMatte() + "',targetMagIron='"
				+ p.getTargetMagIron() + "',targetSiO2Fe='"
				+ p.getTargetSiO2Fe() + "',targetSiO2CaO='"
				+ p.getTargetSiO2CaO() + "'";
		String cond = " where number='" + p.getNumber() + "'";
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
	 * 在生产记录表中删除一条记录
	 * 
	 * @param number
	 *            要删除的生产记录单号
	 * @param sampleNo
	 *            要删除的生产记录样号
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteOne(String number, String sampleNo)
			throws SQLException {
		String exe = "delete from production ";
		String cond = "where number='" + number + "' and sampleNo='" + sampleNo
				+ "'";
		String sql = exe + cond;
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		int result = pst.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}

	/**
	 * 在生产记录表中删除所有同一单号的记录
	 * 
	 * @param number
	 *            要删除的生产记录单号
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteByNum(String number) throws SQLException {
		String exe = "delete from production ";
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
