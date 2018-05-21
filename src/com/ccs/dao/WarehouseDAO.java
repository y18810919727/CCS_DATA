package com.ccs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccs.entity.Warehouse;
import com.ccs.util.DBUtil;

/*
 * 配料仓号表数据库操作对象。 可进行增删改查。4月23日完成。
 * 
 */
public class WarehouseDAO {
	/**
	 * 查询配料仓号表中的所有记录
	 * 
	 * @return List<Warehouse> 一个包含warehouse表全部记录的集合
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public List<Warehouse> FindAll() throws SQLException {
		List<Warehouse> list = new ArrayList<Warehouse>();
		String sql = "select * from warehouse";
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Warehouse w = new Warehouse();
			w.setId(rs.getInt(1));
			w.setHouse1(rs.getString(2));
			w.setHouse2(rs.getString(3));
			w.setHouse3(rs.getString(4));
			w.setHouse4(rs.getString(5));
			w.setHouse5(rs.getString(6));
			w.setHouse6(rs.getString(7));
			w.setHouse7(rs.getString(8));
			w.setHouse8(rs.getString(9));
			w.setHouse9(rs.getString(10));
			w.setHouse10(rs.getString(11));
			list.add(w);
		}
		DBUtil.closeConnection();
		return list;
	}

	/**
	 * 在配料仓号表中插入一条记录
	 * 
	 * @param w
	 *            一个配料仓号记录实体
	 * @return boolean 插入记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean InsertOne(Warehouse w) throws SQLException {
		String exe = "insert into warehouse ";
		String col = "(house1,house2,house3,house4,house5,house6,house7,"
				+ "house8,house9,house10) ";
		String val = "values('" + w.getHouse1() + "','" + w.getHouse2() + "','"
				+ w.getHouse3() + "','" + w.getHouse4() + "','" + w.getHouse5()
				+ "','" + w.getHouse6() + "','" + w.getHouse7() + "','"
				+ w.getHouse8() + "','" + w.getHouse9() + "','"
				+ w.getHouse10() + "')";
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
	 * 在配料仓号表中修改一条记录
	 * 
	 * @param w
	 *            一个配料仓号记录实体
	 * @return boolean 修改记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean UpdateOne(Warehouse w) throws SQLException {
		String exe = "update warehouse set ";
		String col = "house1='" + w.getHouse1() + "',house2='" + w.getHouse2()
				+ "',house3='" + w.getHouse3() + "',house4='" + w.getHouse4()
				+ "',house5='" + w.getHouse5() + "',house6='" + w.getHouse6()
				+ "',house7='" + w.getHouse7() + "',house8='" + w.getHouse8()
				+ "',house9='" + w.getHouse9() + "',house10='" + w.getHouse10()
				+ "'";
		String cond = " where id=" + w.getId();
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
	 * 在配料仓号表中删除一条记录
	 * 
	 * @param id
	 *            一个配料仓号记录实体的id
	 * @return boolean 删除记录成功与否
	 * @throws SQLException
	 * @author GaoYuxing
	 * 
	 * */
	public boolean DeleteOne(int id) throws SQLException {
		String exe = "delete from warehouse ";
		String cond = "where id=" + id;
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
