package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Mineral;
import com.ccs.util.DBUtil;

/*
 * 配料矿石表数据库操作对象。 可进行增删改查。4月23日完成。
 * 
 */
public class MineralDAO {
	/**
	 * 查询配料矿石表中的所有记录
	 * 
	 * @return List<Mineral> 一个包含mineral表全部记录的集合,按仓号升序
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Mineral> FindAll() throws SQLException {
		List<Mineral> list = new ArrayList<Mineral>();
		String sql = "select * from mineral order by housenum asc";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Mineral m = new Mineral();
			m.setId(rs.getInt(1));
			m.setName(rs.getString(2));
			m.setMine_number(rs.getString(3));
			m.setDate(rs.getString(4));
			m.setHousenum(rs.getInt(5));
			m.setCu(rs.getDouble(6));
			m.setFe(rs.getDouble(7));
			m.setS(rs.getDouble(8));
			m.setSiO2(rs.getDouble(9));
			m.setCaO(rs.getDouble(10));
			m.setMgO(rs.getDouble(11));
			m.setAl2O3(rs.getDouble(12));
			list.add(m);
		}
		DBUtil.closeConnection();
		return list;
	}

	/**
	 * 在配料矿石表中插入一条记录
	 * 
	 * @param m
	 *            一个配料矿石记录实体
	 * @return boolean 插入记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean InsertOne(Mineral m) throws SQLException {
		String exe = "insert into mineral ";
		String col = "(name,mine_number,date,housenum,Cu,Fe,S,SiO2,CaO,MgO,Al2O3) ";
		String val = "values('" + m.getName() + "','" + m.getMine_number()
				+ "','" + m.getDate() + "'," + m.getHousenum() + ","
				+ m.getCu() + "," + m.getFe() + "," + m.getS() + ","
				+ m.getSiO2() + "," + m.getCaO() + "," + m.getMgO() + ","
				+ m.getAl2O3() + ")";
		String sql = exe + col + val;
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
	 * 在配料矿石表中修改一条记录
	 * 
	 * @param m
	 *            一个矿石记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOne(Mineral m) throws SQLException {
		String exe = "update mineral set ";
		String col = "mine_number='" + m.getMine_number() + "',date='"
				+ m.getDate() + "',housenum=" + m.getHousenum() + ",Cu="
				+ m.getCu() + ",Fe=" + m.getFe() + ",S=" + m.getS() + ",SiO2="
				+ m.getSiO2() + ",CaO=" + m.getCaO() + ",MgO=" + m.getMgO()
				+ ",Al2O3=" + m.getAl2O3();
		String cond = " where name='" + m.getName() + "'";
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
	 * 在配料矿石表中删除一条记录
	 * 
	 * @param name
	 *            一个矿石记录实体的矿石名称
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteOne(String name) throws SQLException {
		String exe = "delete from mineral ";
		String cond = "where name='" + name + "'";
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
